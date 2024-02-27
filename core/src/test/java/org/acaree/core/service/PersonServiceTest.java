package org.acaree.core.service;

import org.acaree.core.config.AwsConfig;
import org.acaree.core.exceptions.PersonException;
import org.acaree.core.model.Person;
import org.acaree.core.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private S3Client s3Client;
    @Mock
    private Environment env;


    @InjectMocks
    private PersonService personService;

    private final String originalFilename = "testImage.jpg";
    private final byte[] imageContent = new byte[]{1, 2, 3};
    private final MultipartFile imageFile = new MockMultipartFile("image", originalFilename, "image/jpeg", imageContent);

    @BeforeEach
    void setUp() {
        String bucketName = "acaree-s3-bucket";
    }


    @Test
    void testSaveImageSuccess() throws IOException, PersonException {
        // Given
        Person person = new Person();
        Long personId = 1L;
        person.setId(personId);
        MockMultipartFile file = new MockMultipartFile("image", "test.jpg", "image/jpeg", "test image content".getBytes());
        when(personRepository.findById(personId)).thenReturn(Optional.of(person));

        // execute
        personService.saveImage(personId, imageFile);

        // Verify
        verify(s3Client).putObject(any(PutObjectRequest.class), any(RequestBody.class));
        verify(personRepository).save(person);
    }



    @Test
    void testSaveImagePersonNotFound() {
        Long personId = 1L;
        // Given
        when(personRepository.findById(personId)).thenReturn(Optional.empty());

        // Then
        assertThrows(PersonException.class, () -> {
            // When
            personService.saveImage(personId, imageFile);
        });
    }


    @Test
    public void testGetImageSuccess() throws IOException, PersonException {
        // Setup
        Long personId = 1L;
        Person person = new Person();
        person.setId(personId);
        person.setPictureUrl("https://test-bucket.s3.amazonaws.com/test.jpg");

        when(personRepository.findById(personId)).thenReturn(Optional.of(person));
        when(s3Client.getObjectAsBytes(any(GetObjectRequest.class))).thenReturn(ResponseBytes.fromByteArray(GetObjectResponse.builder().build(), "test image content".getBytes()));

        // Execute
        byte[] result = personService.getImage(personId);

        // Verify
        assertNotNull(result);
        assertEquals("test image content", new String(result));
    }


    @Test
    public void testGetImageFileNotFound() {
        // Setup
        Long personId = 1L;
        Person person = new Person();
        person.setId(personId);
        person.setPictureUrl("https://test-bucket.s3.amazonaws.com/nonexistent/image.jpg");

        when(personRepository.findById(personId)).thenReturn(Optional.of(person));
        when(s3Client.getObjectAsBytes(any(GetObjectRequest.class))).thenThrow(S3Exception.class);

        // Assert
        assertThrows(FileNotFoundException.class, () -> {
            // Execute
            personService.getImage(personId);
        });
    }




    @Test
    void getImageContentTypeSuccessfully() throws IOException, PersonException {
        // Setup
        Long personId = 1L;
        Person person = new Person();
        person.setId(personId);
        person.setPictureUrl("https://test-bucket.s3.amazonaws.com/test.jpg");

        when(personRepository.findById(personId)).thenReturn(Optional.of(person));
        when(s3Client.headObject(any(HeadObjectRequest.class))).thenReturn(HeadObjectResponse.builder().contentType("image/jpeg").build());

        // Execute
        String contentType = personService.getImageContentType(personId);

        // Verify
        assertEquals("image/jpeg", contentType);
    }

}

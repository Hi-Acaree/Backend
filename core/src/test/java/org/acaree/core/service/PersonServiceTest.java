package org.acaree.core.service;

import org.acaree.core.exceptions.PersonException;
import org.acaree.core.model.Person;
import org.acaree.core.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private FileStorageService fileStorageService;
    @Mock
    private ResourceLoader resourceLoader;
    @Mock
    private Resource mockResource;


    @InjectMocks
    private PersonService personService;

    private final String originalFilename = "testImage.jpg";
    private final byte[] imageContent = new byte[]{1, 2, 3};
    private final MultipartFile imageFile = new MockMultipartFile("image", originalFilename, "image/jpeg", imageContent);

    @BeforeEach
    void setUp() {
//
//        when(resourceLoader.getResource(anyString())).thenReturn(mockResource);
//        when(mockResource.exists()).thenReturn(true);
//
//        // Mock the InputStream of the mockResource to return your imageContent
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageContent);
//        when(mockResource.getInputStream()).thenReturn(inputStream);
//        try {
//            when(mockResource.getInputStream()).thenReturn(inputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


    @Test
    void testSaveImageSuccess() throws IOException, PersonException {
        // Given
        Person person = new Person();
        Long personId = 1L;
        person.setId(personId);
        String originalFilename = "testImage.jpg";
        String expectedFilename = personId + "_" + originalFilename; // Adjusted to match the actual service logic
        when(personRepository.findById(personId)).thenReturn(Optional.of(person));

        // When
        personService.saveImage(personId, imageFile);

        // Then
        verify(fileStorageService, times(1)).writeFileBytes(eq(expectedFilename), eq(imageContent));
        verify(personRepository, times(1)).save(any(Person.class));
        Person savedPerson = personRepository.findById(personId).get();
        assertEquals("/images/" + expectedFilename, savedPerson.getPictureUrl()); // Adjusted to match the actual service logic
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
        String pictureUrl = "/path/to/image.jpg";
        byte[] imageContent = new byte[]{1, 2, 3}; // The expected content of the image file
        Person person = new Person();
        person.setId(personId);
        person.setPictureUrl(pictureUrl);

        when(mockResource.exists()).thenReturn(true);
        when(mockResource.getInputStream()).thenReturn(new ByteArrayInputStream(imageContent));

        when(personRepository.findById(personId)).thenReturn(Optional.of(person));
        when(resourceLoader.getResource("classpath:/static" + pictureUrl)).thenReturn(mockResource);

        // Execute
        byte[] result = personService.getImage(personId);

        // Verify
        assertArrayEquals(imageContent, result);
        verify(resourceLoader).getResource("classpath:/static" + pictureUrl);
        verify(mockResource).getInputStream(); // Ensure that the input stream of the resource was accessed
    }


    @Test
    public void testGetImageFileNotFound() {
        // Setup
        Long personId = 1L;
        Person person = new Person();
        person.setId(personId);
        person.setPictureUrl("/nonexistent/image.jpg");

        when(personRepository.findById(personId)).thenReturn(Optional.of(person));
        when(mockResource.exists()).thenReturn(false);
        when(resourceLoader.getResource("classpath:static" + person.getPictureUrl())).thenReturn(mockResource);

        // Assert & Execute
        assertThrows(FileNotFoundException.class, () -> {
            personService.getImageContentType(personId);
        });

        // Verify
        verify(resourceLoader).getResource("classpath:static" + person.getPictureUrl());
    }



    @Test
    void getImageContentTypeSuccess() throws FileNotFoundException, IOException, URISyntaxException {
        try (MockedStatic<Files> mockedFiles = Mockito.mockStatic(Files.class)) {
            // Setup
            Long personId = 1L;
            Person person = new Person();
            person.setId(personId);
            person.setPictureUrl("/valid/image.jpg");
            String expectedContentType = "image/jpeg";

//            Resource mockResource = Mockito.mock(Resource.class);
            when(resourceLoader.getResource("classpath:static" + person.getPictureUrl())).thenReturn(mockResource);
            when(mockResource.exists()).thenReturn(true);
            when(mockResource.getURI()).thenReturn(new URI("file:///valid/image.jpg"));
            mockedFiles.when(() -> Files.probeContentType(Paths.get(mockResource.getURI()))).thenReturn(expectedContentType);
            when(personRepository.findById(personId)).thenReturn(Optional.of(person));

            // Execute
            String contentType = personService.getImageContentType(personId);

            // Assert
            assertEquals(expectedContentType, contentType);
        }
    }



    @Test
    public void testGetImageContentTypeNotFound() {
        // Setup
        Long personId = 1L;
        Person person = new Person();
        person.setId(personId);
        person.setPictureUrl("/nonexistent/image.jpg");

        when(personRepository.findById(personId)).thenReturn(Optional.of(person));
        when(mockResource.exists()).thenReturn(false);
        when(resourceLoader.getResource("classpath:static" + person.getPictureUrl())).thenReturn(mockResource);

        // Assert & Execute
        assertThrows(FileNotFoundException.class, () -> {
            personService.getImageContentType(personId);
        });

        // Verify
        verify(resourceLoader).getResource("classpath:static" + person.getPictureUrl());
    }

}

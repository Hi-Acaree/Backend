package org.acaree.core.service;

import org.acaree.core.exceptions.PersonException;
import org.acaree.core.model.Person;
import org.acaree.core.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

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
    private FileStorageService fileStorageService;

    @InjectMocks
    private PersonService personService;

    private final String originalFilename = "testImage.jpg";
    private final byte[] imageContent = new byte[]{1, 2, 3};
    private final MultipartFile imageFile = new MockMultipartFile("image", originalFilename, "image/jpeg", imageContent);

    @BeforeEach
    void setUp() {
    }

    @Test
    void testSaveImageSuccess() throws IOException, PersonException {
        // Given
        Person person = new Person();
        Long personId = 1L;
        person.setId(personId);
        String expectedFilename = personId + "_" + originalFilename;
        when(personRepository.findById(personId)).thenReturn(Optional.of(person));


        // When
        personService.saveImage(personId, imageFile);

        // Then
        verify(fileStorageService, times(1)).writeFileBytes(eq(expectedFilename), eq(imageContent));
        verify(personRepository, times(1)).save(any(Person.class));
        Person savedPerson = personRepository.findById(personId).get();
        assertEquals(expectedFilename, savedPerson.getPictureUrl());
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
    public void testGetImageSuccess() throws IOException {
        Person person = new Person();
        person.setId(1L);
        person.setPictureUrl("path/to/image.jpg");
        byte[] imageContent = new byte[]{1, 2, 3};
        // Given
        when(personRepository.findById(person.getId())).thenReturn(Optional.of(person));
        when(fileStorageService.exists(person.getPictureUrl())).thenReturn(true);
        when(fileStorageService.readFileBytes(person.getPictureUrl())).thenReturn(imageContent);

        // When
        byte[] result = personService.getImage(person.getId());

        // Then
        assertArrayEquals(imageContent, result);
    }

    @Test
    public void testGetImageFileNotFound() {
        // Setup
        Long id = 1L;
        Person person = new Person(); // Assuming you have a constructor or setters to initialize
        person.setId(id);
        person.setPictureUrl("nonexistent.jpg");

        when(personRepository.findById(id)).thenReturn(Optional.of(person));
        when(fileStorageService.exists(person.getPictureUrl())).thenReturn(false);

        // Assert
        assertThrows(FileNotFoundException.class, () -> {
            personService.getImage(id); // Assuming personImageService is the class containing your method
        });
    }


    @Test
    public void testGetImageContentTypeSuccess() throws FileNotFoundException {
        Person person = new Person();
        person.setId(1L);
        person.setPictureUrl("path/to/image.jpg");
         String contentType = "image/jpeg";


        // Given
        when(personRepository.findById(person.getId())).thenReturn(Optional.of(person));
        when(fileStorageService.exists(person.getPictureUrl())).thenReturn(true);
        when(fileStorageService.getContentType(person.getPictureUrl())).thenReturn(contentType);

        // When
        String result = personService.getImageContentType(person.getId());

        // Then
        assertEquals(contentType, result);
    }

    @Test
    public void testGetImageContentTypeNotFound() {
        Person person = new Person();
        person.setId(1L);
        person.setPictureUrl("image.jpg");
        String contentType = "image/jpeg";
        // Given
        when(personRepository.findById(person.getId())).thenReturn(Optional.of(person));
        when(fileStorageService.exists(person.getPictureUrl())).thenReturn(false);

        // Then
        assertThrows(FileNotFoundException.class, () -> {
            // When
            personService.getImageContentType(person.getId());
        });
    }

}

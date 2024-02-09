package org.acaree.core.service;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.exceptions.PersonException;
import org.acaree.core.model.Person;
import org.acaree.core.repository.PersonRepository;
import org.acaree.core.util.ErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Service class for Person entity
 * <p> This class is responsible for all the business logic related to Person entity</p>
 * {@code @Service} annotation to mark the class as a service class
 * {@code @Slf4j} annotation to enable logging
 * {@code @Autowired} annotation to inject the PersonRepository
 */

@Service
@Slf4j
public class PersonService {
    private final PersonRepository personRepository;
    private final FileStorageService fileStorageService;

    @Autowired
    public PersonService(PersonRepository personRepository, FileStorageService fileStorageService) {
        this.personRepository = personRepository;
        this.fileStorageService = fileStorageService;
    }

    /**
     * Save the image to the file system and update the person's image path in the database
     * @param id The person's ID
     * @param imageFile The image file to save
     */

    public void saveImage(Long id, MultipartFile imageFile) throws IOException, PersonException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonException("Person not found", ErrorType.PERSON_NOT_FOUND));

        String filename = id + "_" + imageFile.getOriginalFilename();
        fileStorageService.writeFileBytes(filename, imageFile.getBytes());

        // Update person record with new image path
        person.setPictureUrl(filename);
        personRepository.save(person);
    }

    /*
    * This method is used to get the image from the file system
    * @param id The person's ID
    * @return The image as a byte array
    * @throws IOException If the image cannot be read from the file system
    * @throws PersonException If the person with the given ID is not found
     */
    public byte[] getImage(Long id) throws PersonException, FileNotFoundException{
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonException("Person not found", ErrorType.PERSON_NOT_FOUND));

        if (!fileStorageService.exists(person.getPictureUrl())) {
            throw new FileNotFoundException("Image not found");
        }

         try {
            return fileStorageService.readFileBytes(person.getPictureUrl());
         } catch (IOException e) {
             log.error("Error reading image from file system", e);
               throw new RuntimeException("Error reading image from file system", e);
         }
    }


    public String getImageContentType(Long id) throws FileNotFoundException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonException("Person not found", ErrorType.PERSON_NOT_FOUND));

        if (!fileStorageService.exists(person.getPictureUrl())) {
            throw new FileNotFoundException("Image not found");
        }

        return fileStorageService.getContentType(person.getPictureUrl()); // Get the content type from the file system
    }
}

package org.acaree.core.service;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.exceptions.PersonException;
import org.acaree.core.model.Person;
import org.acaree.core.repository.PersonRepository;
import org.acaree.core.util.ErrorType;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

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
    private final ResourceLoader resourceLoader;

    @Autowired
    public PersonService(PersonRepository personRepository, FileStorageService fileStorageService,
    ResourceLoader resourceLoader) {
        this.personRepository = personRepository;
        this.fileStorageService = fileStorageService;
        this.resourceLoader = resourceLoader;
    }



    /**
     * Save the image to the file system and update the person's image path in the database
     * @param id The person's ID
     * @param imageFile The image file to save
     */

    public void saveImage(Long id, MultipartFile imageFile) throws IOException, PersonException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonException("Person not found", ErrorType.PERSON_NOT_FOUND));

        // Construct a unique filename
        String filename = id + "_" + imageFile.getOriginalFilename();

        // Save the image file to the file system or specific directory
        fileStorageService.writeFileBytes(filename, imageFile.getBytes());

        // Construct and store a retrievable image path or URL
        String imagePath = "/images/" + filename; // Adjust path as necessary
        person.setPictureUrl(imagePath);
        personRepository.save(person);
    }


    /*
    * This method is used to get the image from the file system
    * @param id The person's ID
    * @return The image as a byte array
    * @throws IOException If the image cannot be read from the file system
    * @throws PersonException If the person with the given ID is not found
     */
    public byte[] getImage(Long id) throws PersonException, FileNotFoundException, IOException {
        var person = personRepository.findById(id)
                .orElseThrow(() -> new PersonException("Person not found", ErrorType.PERSON_NOT_FOUND));

        String imagePath = "classpath:/static" + person.getPictureUrl(); // Adjusted path

        Resource resource = resourceLoader.getResource(imagePath);
        if (!resource.exists()) {
            throw new FileNotFoundException("Image not found at " + imagePath);
        }

//        log.info("Resolved image path: {}", resource.getURI().toString());

        try (InputStream inputStream = resource.getInputStream()) {
            return IOUtils.toByteArray(inputStream);
        }
    }


    public String getImageContentType(Long id) throws FileNotFoundException, IOException, URISyntaxException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonException("Person not found", ErrorType.PERSON_NOT_FOUND));

        String imagePath = "classpath:static" + person.getPictureUrl();
        Resource resource = resourceLoader.getResource(imagePath);
        if (!resource.exists()) {
            throw new FileNotFoundException("Image not found");
        }

        // Use Files.probeContentType for a more reliable content type determination
        String contentType = Files.probeContentType(Paths.get(resource.getURI()));
        if (contentType == null) {
            // Fallback to manual determination or throw an error
            throw new IllegalArgumentException("Unable to determine content type");
        }
        return contentType;
    }
}

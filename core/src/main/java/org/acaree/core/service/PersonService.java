package org.acaree.core.service;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.exceptions.PersonException;
import org.acaree.core.model.Person;
import org.acaree.core.repository.PersonRepository;
import org.acaree.core.util.ErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
    @Value("${S3_BUCKET_BASE_URL}")
    private String bucketBaseUrl;

    @Value("${S3_BUCKET_NAME}")
    private String bucketName;


    private final PersonRepository personRepository;
    private final S3Client s3Client;
    private final Environment env;


    @Autowired
    public PersonService(Environment env, PersonRepository personRepository, S3Client s3Client) {
        this.personRepository = personRepository;
        this.s3Client = s3Client;
        this.env = env;
    }


    /**
     * This method is used to save an image to S3.
     * @param id The person's ID
     * @param imageFile The image file to be saved to S3.
     * @throws IOException If the image cannot be read from the file system.
     * @throws PersonException If the person with the given ID is not found.
     */
    public void saveImage(Long id, MultipartFile imageFile) throws IOException, PersonException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonException("Person not found", ErrorType.PERSON_NOT_FOUND));
        String bucketName = env.getProperty("S3_BUCKET_NAME");
        if (Objects.isNull(imageFile)) {
            throw new IllegalArgumentException("Image file is required");
        }
        if (imageFile.isEmpty()) {
            throw new IllegalArgumentException("Image file is empty");
        }
        log.info("Image file size: {}", imageFile.getSize());
        String keyName = "images/" + id + "_" + imageFile.getOriginalFilename();

        try (InputStream inputStream = imageFile.getInputStream()) {
            s3Client.putObject(PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(keyName)
                    .build(), RequestBody.fromInputStream(inputStream, imageFile.getSize()));
            log.info("Image uploaded to S3: {}", keyName);
        } catch (S3Exception e) {
            log.error("Failed to upload image to S3", e);
            throw new IOException("Failed to upload image to S3: " + e.getMessage());
        }
        person.setPictureUrl(keyName);
        personRepository.save(person);
    }

    /**
     * This method is used to get the image from S3.
     * @param id The person's ID
     * @return The image as a byte array.
     * @throws PersonException If the person with the given ID is not found.
     * @throws IOException If the image cannot be read from the file system.
     */
    public byte[] getImage(Long id) throws PersonException, IOException {
        var person = personRepository.findById(id)
                .orElseThrow(() -> new PersonException("Person not found", ErrorType.PERSON_NOT_FOUND));
        if (Objects.isNull(person.getPictureUrl())) {
            throw new FileNotFoundException("Image not found");
        }

        String keyName = bucketBaseUrl + person.getPictureUrl();
        log.info("Fetching image with key: {}", keyName); // Log the key for debugging

        try {
            var response = s3Client.getObjectAsBytes(GetObjectRequest.builder()
                    .bucket(env.getProperty("S3_BUCKET_NAME"))
                    .key(person.getPictureUrl())
                    .build());
            return response.asByteArray();
        } catch (S3Exception e) {
            log.error("Failed to load image from S3 with ID: {}, Error: {}", id, e.getMessage()); // Log the original exception for more context
            throw new FileNotFoundException("Failed to load image from " + person.getPictureUrl() + ". Reason: " + e.getMessage());
        }
    }


    /**
     * This method is used to get the content type of the image.
     * @param id The person's ID
     * @return The content type of the image.
     * @throws PersonException If the person with the given ID is not found.
     * @throws IOException If the image cannot be read from the file system.
     */

    public String getImageContentType(Long id) throws PersonException, IOException {
        // Get the person from the database
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonException("Person not found", ErrorType.PERSON_NOT_FOUND));

        // Get the content type of the image from S3

        String bucketName = env.getProperty("S3_BUCKET_NAME");
        String keyName = person.getPictureUrl();

        HeadObjectRequest objectHead = HeadObjectRequest.builder()
                .bucket(bucketName)
                .key(keyName)
                .build();
        try {
            HeadObjectResponse response = s3Client.headObject(objectHead);
            return response.contentType();
        } catch (S3Exception e) {
            throw new FileNotFoundException("Failed to load image metadata for " + person.getPictureUrl());
        }
    }

    public boolean isImageAvailable(Long id) {
        return personRepository.findById(id).map(Person::getPictureUrl).isPresent();
    }
}


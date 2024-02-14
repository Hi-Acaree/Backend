package org.acaree.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Encoding;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.acaree.core.exceptions.PersonException;
import org.acaree.core.service.PersonService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.acaree.web.ApiMappings.*;

/**
 * This class is responsible for handling all the requests related to the person.
 * The person controller class is responsible for handling all the requests related to the person.
 * This class is annotated with {@code @RestController} to mark it as a controller class.
 * It is also annotated with {@code @Slf4j} to enable logging.
 * It is also annotated with {@code @RequestMapping} to map the requests to the person controller.
 * It is also annotated with {@code @PostMapping} to handle the POST requests.
 */

@RestController
@Slf4j
@RequestMapping(PERSON_BASE_URL) // /api/v1/person
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(UPLOAD_IMAGE_URL) // /person/{id}/image
    @Operation(summary = "Upload an image for a person", description = "This API is used to upload an image for a person",
            requestBody =  @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "multipart/form-data",
                    schema = @Schema(implementation = Object.class),
                    encoding = @Encoding(name = "image", contentType = "image/jpeg, image/png"))),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Image uploaded successfully"),
                    @ApiResponse(responseCode = "404", description = "Person not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    public ResponseEntity<String> uploadImage(@PathVariable Long id, @RequestParam("image") MultipartFile imageFile) {
        try {
            personService.saveImage(id, imageFile);
            return ResponseEntity.ok("Image uploaded successfully");
        } catch (PersonException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Internal server error: " + e.getMessage());
        }
    }

    @GetMapping(GET_IMAGE_URL) // /person/{id}/image
    @Operation(summary = "Get an image for a person", description = "This API is used to get an image for a person",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Image retrieved successfully"),
                    @ApiResponse(responseCode = "404", description = "Person not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    public ResponseEntity<byte[]> getUserImage(@PathVariable Long id) {
        try {
            byte[] imageData = personService.getImage(id);
            HttpHeaders headers = new HttpHeaders();

            // Assuming you have a method to get the stored content type of the image
            String contentType = personService.getImageContentType(id);

            if (contentType != null && !contentType.isEmpty()) {
                headers.setContentType(MediaType.parseMediaType(contentType));
            } else {
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); // Fallback content type
            }

            headers.setContentLength(imageData.length);
            return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (PersonException | URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }




}

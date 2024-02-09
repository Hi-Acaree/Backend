package org.acaree.controller;

import org.acaree.core.exceptions.PersonException;
import org.acaree.core.service.PersonService;
import org.acaree.core.util.ErrorType;
import org.acaree.web.controller.PersonController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.acaree.web.ApiMappings.PERSON_BASE_URL;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @BeforeEach
    public void setup() {
        // Mock the behavior of the person service to simulate successful image upload
        try {
            doNothing().when(personService).saveImage(eq(1L), any(MultipartFile.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void uploadImage_ShouldUploadSuccessfully() throws Exception {
        MockMultipartFile file = new MockMultipartFile(
                "image",
                "test.jpg",
                MediaType.IMAGE_JPEG_VALUE,
                "test image content".getBytes());

        mockMvc.perform(MockMvcRequestBuilders.multipart(PERSON_BASE_URL + "/1/image")
                .file(file)
                .param("id", "1"))
                .andExpect(status().isOk());

    }

    @Test
    public void getUserImage_ReturnsImageSuccessfully() throws Exception {
        // Given
        Long id = 1L;
        byte[] imageData = new byte[]{1, 2, 3};
        String contentType = "image/jpeg";

        given(personService.getImage(id)).willReturn(imageData);
        given(personService.getImageContentType(id)).willReturn(contentType);

        // When & Then
        mockMvc.perform(get(PERSON_BASE_URL + "/{id}/image", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.parseMediaType(contentType)))
                .andExpect(header().string(HttpHeaders.CONTENT_LENGTH, String.valueOf(imageData.length)));
    }

    @Test
    public void getUserImage_PersonNotFound_ReturnsNotFound() throws Exception {
        // Given
        Long id = 1L;
        doThrow(new PersonException("Person not found", ErrorType.PERSON_NOT_FOUND)).when(personService).getImage(id);

        // When & Then
        mockMvc.perform(get(PERSON_BASE_URL + "/{id}/image", id))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getUserImage_InternalServerError() throws Exception {
        // Given
        Long id = 1L;
        doThrow(new FileNotFoundException()).when(personService).getImage(id);

        // When & Then
        mockMvc.perform(get(PERSON_BASE_URL + "/{id}/image", id))
                .andExpect(status().isInternalServerError());
    }
}

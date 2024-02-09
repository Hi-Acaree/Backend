package org.acaree.core.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class is responsible for storing and retrieving files from the local file system.
 * It is used to store and retrieve images and other files from the local file system.
 * The files are stored in the "upload-dir" directory in the root of the project.
 */

@Service
public class LocalFileStorageService implements FileStorageService {

    private final Path rootLocation = Paths.get("upload-dir");

    /**
     * This method is called after the bean has been constructed.
     * It is used to create the "upload-dir" directory in the root of the project.
     * If the directory already exists, it will not be created again.
     */

    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage location", e);
        }
    }

    /**
     * This method is used to store a file in the local file system.
     * It takes the file name and the file content as input and stores the file in the "upload-dir" directory.
     */

    @Override
    public byte[] readFileBytes(String filePath) throws IOException {
        Path path = rootLocation.resolve(filePath).normalize();
        return Files.readAllBytes(path);
    }

    /**
     * This method is used to retrieve a file from the local file system.
     * It takes the file name as input and returns the file content as a byte array.
     */

    @Override
    public void writeFileBytes(String filename, byte[] content) throws IOException {
        Path path = rootLocation.resolve(filename).normalize();
        Path parentDir = path.getParent();
        if (parentDir != null) {
            Files.createDirectories(parentDir);
        }
        Files.write(path, content);
    }


    @Override
    public boolean exists(String filePath) {
        Path path = rootLocation.resolve(filePath).normalize();
        return Files.exists(path);
    }

    @Override
    public String getContentType(String pictureUrl) {
        Path path = rootLocation.resolve(pictureUrl).normalize();
        try {
            return Files.probeContentType(path);
        } catch (IOException e) {
            throw new RuntimeException("Could not determine the file type", e);
        }
    }
}

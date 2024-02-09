package org.acaree.core.service;

import java.io.IOException;

/**
 * This interface provides the necessary methods to perform file operations.
 * The implementation of this interface should be able to perform file operations
 * on the local file system, cloud storage, or any other file storage system.
 * The implementation should be able to read and write files, check if a file exists,
 * and perform other necessary file operations.
 * The implementation should also be able to handle different file types and file sizes.
 *
 */

public interface FileStorageService {
    byte[] readFileBytes(String filePath) throws IOException;
    void writeFileBytes(String filePath, byte[] content) throws IOException;
    boolean exists(String filePath);

    String getContentType(String pictureUrl);
    // Add other necessary file operations
}

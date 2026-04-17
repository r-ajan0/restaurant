package com.example.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileUploadController extends BaseController {

    @Value("${upload.path:upload/}")
    private String uploadPath;

    // Remove the /api/files prefix if you already have /api/file at @RequestMapping
    @GetMapping("/{folderName}/{fileName:.+}")
    public ResponseEntity<Resource> getFile(
            @PathVariable String folderName,
            @PathVariable String fileName) throws IOException {

        Path filePath = Paths.get(uploadPath).resolve(folderName).resolve(fileName).normalize();
        File file = filePath.toFile();

        if (!file.exists()) {
            // This will be caught by your GlobalExceptionHandler
            throw new RuntimeException("File not found");
        }

        Resource resource = new UrlResource(filePath.toUri());

        // Detect content type (image/png, image/jpeg, etc.)
        String contentType = Files.probeContentType(filePath);
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        // Return the Resource directly, NOT wrapped in GlobalApiResponse
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }
}
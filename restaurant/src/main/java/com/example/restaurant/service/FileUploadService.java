package com.example.restaurant.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileUploadService {
    public String addImage(MultipartFile file, String directoryPath) throws IOException {
        if (file == null || file.isEmpty()) {
            return null;
        }

        String originalName = file.getOriginalFilename();

        if (originalName == null || (!originalName.toLowerCase().endsWith(".jpg") && !originalName.toLowerCase().endsWith(".png"))) {
            throw new IOException("Only .jpg or .png files are allowed.");
        }

        String extension = originalName.substring(originalName.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString() + extension;

        File folder = new File(directoryPath);
        if (!folder.exists()) {
            if (!folder.mkdirs()) {
                throw new IOException("Failed to create directory: " + directoryPath);
            }
        }

        Path targetPath = Paths.get(directoryPath).resolve(fileName);
        Files.copy(file.getInputStream(), targetPath);

        // --- CHANGE IS HERE ---
        // Instead of targetPath.toString(), return "folderName/fileName"
        // This matches your @GetMapping("/{folderName}/{fileName}")
        return folder.getName() + "/" + fileName;
    }
}
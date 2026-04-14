package com.example.restaurant.service;

import com.example.restaurant.exception.AppException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;




@Service
public class FileUploadService {
    public String addImage(MultipartFile file, String urlPath) throws IOException {

        String originalName = file.getOriginalFilename();
        String randomId = UUID.randomUUID().toString();


        String fileName = null;
        if (originalName.contains(".jpg") || originalName.contains(".png")) {
            fileName = randomId.concat(originalName.substring(originalName.lastIndexOf(".")));
        }
        else {
            throw new IOException("only jpg or png allowed.");
        }


        String filePath = urlPath + File.separator + fileName;

        File folder = new File(urlPath);
        if(!folder.exists()){
            folder.mkdir();
        }

        Files.copy(file.getInputStream(), Paths.get(filePath));
        return filePath;
    }




}

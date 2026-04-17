package com.example.restaurant.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${upload.path:upload/}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Get the absolute path of your upload directory
        String path = new File(uploadPath).getAbsolutePath();

        // Logical URL path -> Physical file path
        // "file:" prefix is mandatory for external folders
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:" + path + File.separator);
    }
}

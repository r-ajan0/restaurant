package com.example.restaurant.config;

import com.example.restaurant.pojo.restaurant.RestaurantReqPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final ObjectMapper objectMapper;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(String.class, RestaurantReqPojo.class, source -> {
            try {
                return objectMapper.readValue(source, RestaurantReqPojo.class);
            } catch (Exception e) {
                throw new RuntimeException("JSON conversion failed", e);
            }
        });
    }
}
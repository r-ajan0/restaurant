package com.example.restaurant.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${openapi.title}")
    private String title;

    @Value("${openapi.version}")
    private String version;

    @Value("${openapi.description}")
    private String description;

    @Bean
    public OpenAPI customOpenAPI() {

        Server devServer = new Server();
        devServer.setUrl("");
        devServer.setDescription("Development Server");


        Contact contact = new Contact();
        contact.setName("Backend Support");
        contact.setEmail("rajanprime123@gmail.com");

        return new OpenAPI()
                .info(new Info()
                        .title(title)
                        .version(version)
                        .description(description)
                        .contact(contact))
                .servers(List.of(devServer));
    }
}
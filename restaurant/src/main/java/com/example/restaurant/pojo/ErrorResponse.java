package com.example.restaurant.pojo;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private int statusCode;
    private String message;
    private long timestamp;

    // Practice: Initialize as an empty list to avoid null in JSON
    private List<FieldErrorResponse> errorResponses = new ArrayList<>();

    // Custom constructor for simple error messages
    public ErrorResponse(int statusCode, String message, long timestamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = timestamp;
        this.errorResponses = new ArrayList<>();
    }
}

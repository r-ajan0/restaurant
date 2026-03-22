package com.example.restaurant.pojo;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private int statusCode;
    private String message;
    private long timestamp;
    private List<FieldErrorResponse> errorResponses;
}

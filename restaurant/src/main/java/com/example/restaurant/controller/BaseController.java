package com.example.restaurant.controller;

import com.example.restaurant.pojo.GlobalApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {
    protected ResponseEntity<GlobalApiResponse> successResponse(String message,Object data) {
        GlobalApiResponse response = new GlobalApiResponse(HttpStatus.OK.value(),message,data);
        return ResponseEntity.ok(response);
    }
    protected ResponseEntity<GlobalApiResponse> successResponse(String message) {
        GlobalApiResponse response = new GlobalApiResponse(HttpStatus.OK.value(),message,null);
        return ResponseEntity.ok(response);
    }
}

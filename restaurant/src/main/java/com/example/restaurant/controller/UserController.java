package com.example.restaurant.controller;

import com.example.restaurant.constant.StringConstant;
import com.example.restaurant.pojo.GlobalApiResponse;
import com.example.restaurant.pojo.user.UserReqPojo;
import com.example.restaurant.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController extends BaseController{
    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<GlobalApiResponse> saveUser(@RequestBody UserReqPojo userReqPojo) {
        return successResponse(StringConstant.SUCCESS_SAVE,userService.addUser(userReqPojo));
    }
}

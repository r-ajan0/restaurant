package com.example.restaurant.controller;

import com.example.restaurant.constant.StringConstant;
import com.example.restaurant.pojo.GlobalApiResponse;
import com.example.restaurant.pojo.user.UserReqPojo;
import com.example.restaurant.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController extends BaseController {
    private final UserService userService;

    @PostMapping("/save-user")
    public ResponseEntity<GlobalApiResponse> saveUser(@RequestBody UserReqPojo userReqPojo) {
        return successResponse(StringConstant.SUCCESS_SAVE, userService.addUser(userReqPojo));
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<GlobalApiResponse> getAllUsers() {
        return successResponse(StringConstant.SUCCESS_RETRIEVE, userService.getAllUsers());
    }

    @GetMapping("/get-user-by-id/{id}")
    public ResponseEntity<GlobalApiResponse> getUserById(@PathVariable Long id) {
        return successResponse(StringConstant.SUCCESS_RETRIEVE, userService.getUserById(id));
    }

    @PutMapping("/update-user-detail/{id}")
    public ResponseEntity<GlobalApiResponse> updateUserDetail(@RequestBody UserReqPojo userReqPojo, @PathVariable Long id) {
        return successResponse(StringConstant.SUCCESS_UPDATE, userService.updateUser(userReqPojo, id));
    }
    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<GlobalApiResponse> deleteUser(@PathVariable Long id) {
        return successResponse(StringConstant.SUCCESS_DELETE, userService.deleteUser(id));
    }
}

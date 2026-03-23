package com.example.restaurant.service;

import com.example.restaurant.pojo.user.UserReqPojo;
import com.example.restaurant.pojo.user.UserResPojo;

import java.util.List;

public interface UserService {
    Long addUser(UserReqPojo userReqPojo);
    Long updateUser(UserReqPojo userReqPojo);
    Long deleteUser(Long id);
    List<UserResPojo> getAllUsers();
    Long getUserById(Long id);
}

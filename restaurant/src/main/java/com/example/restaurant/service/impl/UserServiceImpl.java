package com.example.restaurant.service.impl;

import com.example.restaurant.constant.RegexConstant;
import com.example.restaurant.exception.AppException;
import com.example.restaurant.mapper.UserMapper;
import com.example.restaurant.pojo.user.UserReqPojo;
import com.example.restaurant.pojo.user.UserResPojo;
import com.example.restaurant.repository.UserRepository;
import com.example.restaurant.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;



    @Override
    public Long addUser(UserReqPojo userReqPojo) {
        return 0L;
    }


    @Override
    public Long updateUser(UserReqPojo userReqPojo) {
        return 0L;
    }

    @Override
    public Long deleteUser(Long id) {
        return 0L;
    }

    @Override
    public List<UserResPojo> getAllUsers() {
        return List.of();
    }

    @Override
    public Long getUserById(Long id) {
        return 0L;
    }

    private void validatePhoneNumber(String phone, Long userId) {
        if (!userRepository.validateNumber(phone, userId)) {
            throw new AppException("Phone number already exists");
        }
        if (phone.matches(RegexConstant.PHONE_NUMBER_NEPALI)) {
            return;
        }
        throw new AppException("Invalid phone number");
    }


}

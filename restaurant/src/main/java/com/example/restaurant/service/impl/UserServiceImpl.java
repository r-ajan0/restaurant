package com.example.restaurant.service.impl;

import com.example.restaurant.constant.RegexConstant;
import com.example.restaurant.entity.User;
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
    private final UserMapper userMapper;


    @Override
    public Long addUser(UserReqPojo userReqPojo) {
        User user = new User();

        if (userRepository.existsByPhoneNumber(userReqPojo.getPhone())){
            throw new AppException("Phone number already exists");
        }
        user.setFirstName(userReqPojo.getFirstName());
        user.setMiddleName(userReqPojo.getMiddleName());
        user.setLastName(userReqPojo.getLastName());
        user.setUserRole(userReqPojo.getRole());
        user.setAddress(userReqPojo.getAddress());
        user.setPhoneNumber(userReqPojo.getPhone());
        userRepository.save(user);
        return user.getId();

    }


    @Override
    public Long updateUser(UserReqPojo userReqPojo,Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new AppException("User not found"));
        if(user.getIsActive()==false){
            throw new AppException("User doesn't exist");
        }
        if (userRepository.existsByPhoneNumberAndIdNot(userReqPojo.getPhone(),id)){
            throw new AppException("Phone number already exists");
        }
        user.setFirstName(userReqPojo.getFirstName());
        user.setMiddleName(userReqPojo.getMiddleName());
        user.setLastName(userReqPojo.getLastName());
        user.setAddress(userReqPojo.getAddress());
        user.setPhoneNumber(userReqPojo.getPhone());
        return id;
    }

    @Override
    public Long deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new AppException("User not found"));
        user.setIsActive(false);
        userRepository.save(user);
        return id;
    }

    @Override
    public List<UserResPojo> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toPojoList(users);
    }

    @Override
    public UserResPojo getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new AppException("User not found"));
        return userMapper.toPojo(user);

    }


}

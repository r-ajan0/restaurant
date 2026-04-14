package com.example.restaurant.mapper;

import com.example.restaurant.entity.User;
import com.example.restaurant.pojo.user.UserResPojo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "phoneNumber", target = "phone")
    @Mapping(source = "userRole", target = "role")
    UserResPojo toPojo(User user);
    List<UserResPojo> toPojoList(List<User> users);
}

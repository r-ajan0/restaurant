package com.example.restaurant.pojo.user;

import com.example.restaurant.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserReqPojo {
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String phone;
    private UserRole role;
}

package com.example.restaurant.pojo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResPojo {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phone;
}

package com.example.restaurant.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class RegexConstant {
    public static final String EMAIL = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    public static final String PHONE_NUMBER_NEPALI = "^9[6-9]\\d{8}$";
    public static final String PASSWORD = "^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}";

}

package com.example.restaurant.pojo.restaurant;

import com.example.restaurant.entity.User;
import com.example.restaurant.enums.RestaurantRegistration;
import com.example.restaurant.enums.RestaurantStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantReqPojo {
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantPhone;
    private String restaurantEmail;
    private MultipartFile addressProofUrl;
    private MultipartFile ownerVerificationIdUrl;
    private MultipartFile panCardImageUrl;
    private RestaurantStatus  restaurantStatus;
    private RestaurantRegistration restaurantRegistration;
    private Long userId;
}

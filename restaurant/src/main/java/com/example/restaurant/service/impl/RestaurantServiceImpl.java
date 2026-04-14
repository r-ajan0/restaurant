package com.example.restaurant.service.impl;

import com.example.restaurant.entity.Restaurant;
import com.example.restaurant.entity.User;
import com.example.restaurant.exception.AppException;
import com.example.restaurant.pojo.restaurant.RestaurantReqPojo;
import com.example.restaurant.repository.RestaurantRepository;
import com.example.restaurant.repository.UserRepository;
import com.example.restaurant.service.FileUploadService;
import com.example.restaurant.service.RestaurantService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Transactional
@RequiredArgsConstructor

public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final FileUploadService fileUploadService;

    @Value("upload/")
    private String uploadPath;

    @Override
    public Long addRestaurant(RestaurantReqPojo restaurantReqPojo) {
        User user = userRepository.findById(restaurantReqPojo.getUserId())
                .orElseThrow(() -> new AppException("User with ID " + restaurantReqPojo.getUserId() + " not found"));
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(restaurantReqPojo.getRestaurantName());
        restaurant.setRestaurantAddress(restaurantReqPojo.getRestaurantAddress());
        restaurant.setRestaurantEmail(restaurantReqPojo.getRestaurantEmail());
        restaurant.setRestaurantPhone(restaurantReqPojo.getRestaurantPhone());
        restaurant.setRestaurantRegistration(restaurantReqPojo.getRestaurantRegistration());
        restaurant.setUser(user);
        try {

            restaurant.setAddressProofImageUrl(fileUploadService.addImage(restaurantReqPojo.getAddressProofUrl(), uploadPath));
            restaurant.setOwnerVerificationIdUrl(fileUploadService.addImage(restaurantReqPojo.getOwnerVerificationIdUrl(), uploadPath));
            restaurant.setPanCardImageUrl(fileUploadService.addImage(restaurantReqPojo.getPanCardImageUrl(), uploadPath));
        } catch (AppException | IOException e) {
            throw new AppException("File upload failed");
        }
        restaurantRepository.save(restaurant);
        return restaurant.getId();
    }
}

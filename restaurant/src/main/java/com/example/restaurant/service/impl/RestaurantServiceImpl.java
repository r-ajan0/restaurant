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

import java.io.File;
import java.io.IOException;

@Service
@Transactional
@RequiredArgsConstructor

public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final FileUploadService fileUploadService;

    @Value("${upload.path:upload/}") // Recommended: use property key from application.properties
    private String uploadPath;

    @Override
    public Long addRestaurant(RestaurantReqPojo restaurantReqPojo) {
        User user = userRepository.findById(restaurantReqPojo.getUserId())
                .orElseThrow(
                        () -> new AppException("User with ID " + restaurantReqPojo.getUserId() + " not found"));

        if (restaurantRepository.existsByUserId(restaurantReqPojo.getUserId())) {
            throw new AppException("This user already has a registered restaurant.");
        }

        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(restaurantReqPojo.getRestaurantName());
        restaurant.setRestaurantAddress(restaurantReqPojo.getRestaurantAddress());
        restaurant.setRestaurantEmail(restaurantReqPojo.getRestaurantEmail());
        restaurant.setRestaurantPhone(restaurantReqPojo.getRestaurantPhone());
        restaurant.setRestaurantRegistration(restaurantReqPojo.getRestaurantRegistration());
        restaurant.setUser(user);

        String correctFileName = restaurantReqPojo.getRestaurantName()
                .trim()
                .replaceAll("[^a-zA-Z0-9\\s]", "")
                .replaceAll("\\s+", "_");

        String dynamicUploadPath = uploadPath + File.separator + correctFileName;
        try {
            // Upload files to the dynamic path
            if (restaurantReqPojo.getAddressProofUrl() != null) {
                restaurant.setAddressProofImageUrl(
                        fileUploadService.addImage(restaurantReqPojo.getAddressProofUrl(), dynamicUploadPath));
            }
            if (restaurantReqPojo.getOwnerVerificationIdUrl() != null) {
                restaurant.setOwnerVerificationIdUrl(
                        fileUploadService.addImage(restaurantReqPojo.getOwnerVerificationIdUrl(), dynamicUploadPath));
            }
            if (restaurantReqPojo.getPanCardImageUrl() != null) {
                restaurant.setPanCardImageUrl(
                        fileUploadService.addImage(restaurantReqPojo.getPanCardImageUrl(), dynamicUploadPath));
            }
            restaurantRepository.saveAndFlush(restaurant);
            return restaurant.getId();

        } catch (IOException e) {
            deleteDirectory(new File(dynamicUploadPath));
            throw new AppException("File upload failed: " + e.getMessage());


        }

    }

    private void deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                file.delete();
            }
        }
        directoryToBeDeleted.delete();
    }
}

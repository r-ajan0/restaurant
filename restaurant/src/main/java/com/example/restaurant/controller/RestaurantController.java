package com.example.restaurant.controller;

import com.example.restaurant.pojo.restaurant.RestaurantReqPojo;
import com.example.restaurant.repository.UserRepository;
import com.example.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class RestaurantController extends BaseController {
    private final RestaurantService restaurantService;
    private final UserRepository userRepository;

    @PostMapping(value = "/add-restaurant", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Long> addRestaurant(@ModelAttribute RestaurantReqPojo req) {
        return ResponseEntity.ok(restaurantService.addRestaurant(req));
    }
}

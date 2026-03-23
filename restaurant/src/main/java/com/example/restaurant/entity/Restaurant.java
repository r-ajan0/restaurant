package com.example.restaurant.entity;

import com.example.restaurant.entity.audit.AuditAbstract;
import com.example.restaurant.enums.RestaurantRegistration;
import com.example.restaurant.enums.RestaurantStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
public class Restaurant extends AuditAbstract {
    @Id
    @SequenceGenerator(name = "restaurants_seq_gen", sequenceName = "restaurants_seq", allocationSize = 1)
    @GeneratedValue(generator = "restaurants_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "restaurant_name", length = 50, nullable = false)
    @NotBlank(message = "restaurant name cannot be empty")
    @NotNull(message = "restaurant name cannot be null")
    private String restaurantName;

    @Column(name = "restaurant_email")
    private String restaurantEmail;
    @Column(name = "restaurant_phone")
    private String restaurantPhone;
    @Column(name = "restaurant_address")
    private String restaurantAddress;
    @Column(name = "address_proof_image_url")
    private String addressProofImageUrl;
    @Column(name = "pan_card_image_url")
    private String panCardImageUrl;
    @Column(name = "owner_verification_id_url")
    private String ownerVerificationIdUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "restaurant_status")
    private RestaurantStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "restaurant_registration_status")
    private RestaurantRegistration registrationStatus;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}

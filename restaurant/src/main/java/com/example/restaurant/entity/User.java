package com.example.restaurant.entity;

import com.example.restaurant.entity.audit.AuditAbstract;
import com.example.restaurant.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter

public class User extends AuditAbstract {
    @Id
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_seq", allocationSize = 1)
    @GeneratedValue(generator = "users_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "First Name cannot be blank")
    @NotNull(message = "First Name cannot be null")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "Last Name cannot be blank")
    @NotNull(message = "Last Name cannot be null")
    private String lastName;

    @Column(name = "address", nullable = false)
    @NotBlank(message = "Address cannot be blank")
    @NotNull(message = "Address Name cannot be null")
    private String address;

    @Column(name = "phone_number", nullable = false)
    @NotBlank(message = "Phone Number cannot be blank")
    @NotNull(message = "Phone Number cannot be null")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole userRole;

}

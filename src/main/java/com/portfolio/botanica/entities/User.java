package com.portfolio.botanica.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import com.portfolio.botanica.dtos.UserDto;
import lombok.*;

import java.util.*;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, columnDefinition = "ENUM('admin', 'user') DEFAULT 'user'")
    private UserRole role; // Ann enum field to represent user roles

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Garden> gardens;

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JsonBackReference
//    private Set<Garden> gardenSet = new HashSet<>();

//    public User(UserDto userDto) {
//        if (userDto.getUsername() != null) {
//            this.username = userDto.getUsername();
//        }
//        if (userDto.getPassword() != null) {
//            this.password = userDto.getPassword();
//        }
//    }
}

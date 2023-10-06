package com.portfolio.botanica.repositories;

import com.portfolio.botanica.entities.User;
import com.portfolio.botanica.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    // These are your custom queries.
    // Define them as needed for your project.
    Optional<User> findByUsername(String username);

    User findByEmail(String email);

    List<User> findByRole(UserRole role);

    boolean existsByUsername(String username);


}
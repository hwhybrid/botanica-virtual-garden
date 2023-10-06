package com.portfolio.botanica.repositories;

import com.portfolio.botanica.entities.User;
import com.portfolio.botanica.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    // These are your custom queries.
    // Define them as needed for your project.
    User findByUsername(String username);
    User findByEmail(String email);

    List<User> findByRole(UserRole role);


//    Optional<User> findByUsername(String username);

}
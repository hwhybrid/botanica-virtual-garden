package com.portfolio.botanica.controllers;

import com.portfolio.botanica.dtos.UserDto;
import com.portfolio.botanica.entities.User;
import com.portfolio.botanica.entities.UserRole;
import com.portfolio.botanica.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin(origins = "*") // Allows requests from the frontend
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto) {
        try {

            if (userRepository.existsByUsername((userDto.getUsername()))) {
                return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
            }
            User user = new User();
            user.setUsername((userDto.getUsername()));
            user.setPassword(passwordEncoder.encode((userDto.getPassword())));
            user.setEmail(userDto.getEmail());
            user.setRole(UserRole.USER); // Sets the user role to 'user'

            userRepository.save(user);
            return new ResponseEntity<>("User successfully registered!", HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Error during user registration", e);
            return new ResponseEntity<>("Registration failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto){
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDto.getUsername(),
                            userDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            logger.info("Authentication successful for user: " + userDto.getUsername());
            return new ResponseEntity<>("You have successfully signed in!", HttpStatus.OK);
        } catch (BadCredentialsException e) {
            logger.warn("Bad credentials for user: " + userDto.getUsername());
            return new ResponseEntity<>("Username or password is incorrect!", HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            logger.error("Error during user login", e);
            return new ResponseEntity<>("Login failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        try {
            // Implement logout logic here (if needed)
            SecurityContextHolder.getContext().setAuthentication(null);
            return new ResponseEntity<>("You have successfully logged out!", HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error during user logout", e);
            return new ResponseEntity<>("Logout failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

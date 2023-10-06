package com.portfolio.botanica.services;

import com.portfolio.botanica.dtos.UserDto;
import com.portfolio.botanica.entities.UserRole;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    UserDto updateUser(Long userId, UserDto userDto);
    void deleteUser(Long userId);
    List<UserDto> getAllUsers();

    UserDto updateUserRole(Long userId, UserRole newRole);

}

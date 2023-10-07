//package com.portfolio.botanica.security;
//
//import com.portfolio.botanica.entities.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//public class CustomUserDetails implements UserDetails {
//
//    private User user; // Your User entity class
//
//    public CustomUserDetails(User user) {
//        this.user = user;
//    }
//
//    // Implement UserDetails methods: getUsername(), getPassword(), getAuthorities(), ...
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // Return user's roles as authorities
//        return user.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}

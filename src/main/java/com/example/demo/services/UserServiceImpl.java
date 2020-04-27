package com.example.demo.services;

import java.util.Arrays;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService{

    
 private UserRepository userRepository;

 @Autowired    
 public UserServiceImpl(UserRepository userRepository) {    
        this.userRepository = userRepository;    
    }  

@Override 
 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {    
        User user = userRepository.findByUsername(username)    
                .orElseThrow(() -> new UsernameNotFoundException("User: " + username + " not found"));    
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),    
                Arrays.asList(new SimpleGrantedAuthority("user")));    
    } 
}
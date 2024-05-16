package com.example.internetpetshop.Services.impl;

import com.example.internetpetshop.Models.User;
import com.example.internetpetshop.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username){
        User user = userRepository.findByUsername(username);

        if (user != null) {
            logger.debug(String.format("User with name: %s and password: %s created.", user.getUsername(), user.getPassword()));
            return UserDetailsImpl.fromUser(user);
        }else{
            throw new UsernameNotFoundException("User " + username + " not found!");
        }
    }
}

package com.pranoy.bookstore.service.impl;

import com.pranoy.bookstore.domain.User;
import com.pranoy.bookstore.repository.UserRepository;
import com.pranoy.bookstore.service.UserSecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserSecurityServiceImpl implements UserSecurityService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserSecurityServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);

        if (Objects.isNull(user)) {
            LOGGER.warn("Username {} not found", username);
            throw new UsernameNotFoundException("Username " + username + " not found");
        }

        return user;
    }
}

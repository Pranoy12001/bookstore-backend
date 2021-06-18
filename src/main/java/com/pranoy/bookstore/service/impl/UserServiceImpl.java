package com.pranoy.bookstore.service.impl;

import com.pranoy.bookstore.domain.User;
import com.pranoy.bookstore.domain.security.UserRole;
import com.pranoy.bookstore.repository.RoleRepository;
import com.pranoy.bookstore.repository.UserRepository;
import com.pranoy.bookstore.service.UserService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Objects;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) {
        User localUser = userRepository.findByUserName(user.getUsername());

        if(Objects.nonNull(localUser)) {
            LOGGER.info("User with username {} already exist. Nothing will be done", user.getUsername());
        } else {
            for (UserRole userRole : userRoles) {
                roleRepository.save(userRole.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            localUser = userRepository.save(user);
        }

        return localUser;
    }
}

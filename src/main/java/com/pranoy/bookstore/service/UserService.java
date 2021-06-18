package com.pranoy.bookstore.service;

import com.pranoy.bookstore.domain.User;
import com.pranoy.bookstore.domain.security.UserRole;

import java.util.Set;

public interface UserService {
    User createUser(User user, Set<UserRole> userRoles);
}

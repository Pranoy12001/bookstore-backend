package com.pranoy.bookstore.domain.security;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

public class Authority implements GrantedAuthority, Serializable {
    private static final long serialVersionUID = 12345L;
    private final String authority;

    /**
     * var-age constructor
     *
     * @param authority
     */
    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}

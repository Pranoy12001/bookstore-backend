package com.pranoy.bookstore.domain.security;

import com.pranoy.bookstore.domain.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 12345L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userRoleID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    public UserRole() {
    }

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public long getUserRoleID() {
        return userRoleID;
    }

    public void setUserRoleID(long userRoleID) {
        this.userRoleID = userRoleID;
    }
}

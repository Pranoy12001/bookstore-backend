package com.pranoy.bookstore.controller;

import com.pranoy.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/token")
    public Map<String, String> token(HttpSession httpSession, HttpServletRequest request) {
        System.out.println(request.getRemoteHost());
        String remoteHost = request.getRemoteHost();
        int portNumber = request.getRemotePort();

        System.out.println(remoteHost + ":" + portNumber);
        System.out.println(request.getRemoteAddr());

        return Collections.singletonMap("token", httpSession.getId());
    }

}

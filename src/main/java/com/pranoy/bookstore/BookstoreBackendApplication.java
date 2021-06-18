package com.pranoy.bookstore;

import com.pranoy.bookstore.config.utility.SecurityUtility;
import com.pranoy.bookstore.domain.User;
import com.pranoy.bookstore.domain.security.Role;
import com.pranoy.bookstore.domain.security.UserRole;
import com.pranoy.bookstore.service.UserService;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@Controller
public class BookstoreBackendApplication{

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreBackendApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
////		User user1 = new User();
////		user1.setFirstName("john");
////		user1.setLastName("Adams");
////		user1.setUserName("j");
////		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
////		user1.setEmail("pranoy.mbstu12001@gmail.com");
////
////		Set<UserRole> userRoles = new HashSet<>();
////		Role role1 = new Role();
////		role1.setRoleId(1);
////		role1.setName("ROLE_USER");
////		userRoles.add(new UserRole(user1, role1));
////		userService.createUser(user1, userRoles);
//	}


	@GetMapping("/test")
	@ResponseBody
	public String test (){


		User user1 = new User();
		user1.setFirstName("john");
		user1.setLastName("Adams");
		user1.setUserName("j");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("pranoy.mbstu12001@gmail.com");

		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		userService.createUser(user1, userRoles);

		return "test";
	}





}

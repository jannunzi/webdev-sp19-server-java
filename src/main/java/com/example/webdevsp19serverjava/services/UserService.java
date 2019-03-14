package com.example.webdevsp19serverjava.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevsp19serverjava.model.User;

@RestController
public class UserService {
	User alice = new User(123, "alice", "rabit", "Alice", "Wonderland");
	User bob   = new User(234, "bob", "love", "Bob", "Marley");
	List<User> users = new ArrayList<User>();
	{
	    users.add(alice);
	    users.add(bob);
	};

	@PostMapping("/api/login")
	public User login(
	        @RequestBody User loginUser,
	        HttpSession session) {
	    for(User user: users) {
	        if(user.getUsername().equals(loginUser.getUsername()) &&
	           user.getPassword().equals(loginUser.getPassword())) {
	            session.setAttribute("currentUser", user);
	            return user;
	        }
	    }
	    return null;
	}
	
	@PostMapping("/api/register")
	public User register(
	        @RequestBody User user,
	        HttpSession session) {
	    session.setAttribute("currentUser", user);
	    users.add(user);
	    return user;
	}
	
	@PostMapping("/api/loggedin")
	public User loggedin(HttpSession session) {
	    return (User)session.getAttribute("currentUser");
	}
	
	@GetMapping("/api/user")
	public List<User> findAllUser() {
		return users;
	}
	@GetMapping("/api/user/{userId}")
	public User findUserById(
			@PathVariable("userId") Integer id) {
		for(User user: users) {
			if(id == user.getId().intValue())
				return user;
		}
		return null;
	}
//	public User createUser(User user) {
//		
//	}
//	public void deleteUser(Integer id) {
//		
//	}
//	public User updateUser(Integer id, User user) {
//		
//	}
}

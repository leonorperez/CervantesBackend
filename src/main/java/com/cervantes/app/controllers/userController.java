package com.cervantes.app.controllers;

//import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cervantes.app.models.User;
//import com.cervantes.app.services.UserService;
import com.cervantes.app.services.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class userController {
	
	 @Autowired
	    UserServiceImpl userServiceImpl;

	    @GetMapping("")
	    public List<User> list() {
	        return userServiceImpl.listAllUser();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<User> get(@PathVariable Integer id) {
	        try {
	            User user = userServiceImpl.getUser(id);
	            return new ResponseEntity<User>(user, HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }
	    }
	    @PostMapping("/")
	    public void add(@RequestBody User user) {
	    	System.out.println("paso " +  user.toString());
	        userServiceImpl.saveUser(user);
	    }
	    @PutMapping("/{id}")
	    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
	        try {
	            User existUser = userServiceImpl.getUser(id);
	            user.setUserId(id);            
	            userServiceImpl.saveUser(user);
	            return new ResponseEntity<>(HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable Integer id) {

	        userServiceImpl.deleteUser(id);
	    }
	
	
	
	
//	@Autowired
//	UserService userService;
//	
//	@GetMapping
//	public ResponseEntity<Collection<User>> getUsers() {	
//		
//		return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
//		
//	}
//	
//	@PostMapping
//	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
//		
//		return new ResponseEntity<>(userService.createUser(user),HttpStatus.OK);
//		
//	}
//	
//	@GetMapping(path="/{userId}")
//	public ResponseEntity<User> getUser(@PathVariable String userId) {
//		
//		return new ResponseEntity<>(userService.getUser(userId),HttpStatus.OK);
//		
//	}
//	
//	@PutMapping(path="/{userId}")
//	public ResponseEntity<User> updateUser(@PathVariable String userId, @Valid @RequestBody User user){
//		
//		return new ResponseEntity<>(userService.updateUser(userId, user), HttpStatus.OK);
//		
//	}
//	
//	@DeleteMapping(path="/{userId}")
//	public ResponseEntity<User> deleteUser(@PathVariable String userId){
//		userService.deleteUser(userId);
//		return ResponseEntity.noContent().build();
//	}
}

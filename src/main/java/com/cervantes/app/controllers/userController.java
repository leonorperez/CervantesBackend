package com.cervantes.app.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cervantes.app.models.User;
import com.cervantes.app.services.UserServiceImpl;


@RestController
@RequestMapping("users/")
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
	    public String add(@RequestBody User user) {
	        userServiceImpl.saveUser(user);
	        return "Usuario generado correctamente";
	    }
	    @PutMapping("/{id}")
	    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
	        try {
	            User existUser = userServiceImpl.getUser(id);
	            user.setUser_id(id);            
	            userServiceImpl.saveUser(user);
	            return new ResponseEntity<>(HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    @DeleteMapping("/{id}")
	    public String delete(@PathVariable Integer id) {

	        userServiceImpl.deleteUser(id);
	        
	        return "Usuario eliminado";
	    }
	

}

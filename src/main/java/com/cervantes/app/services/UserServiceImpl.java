package com.cervantes.app.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cervantes.app.models.User;

@Service
public class UserServiceImpl implements UserService {
	
	Map<String, User> users;

	@Override
	public Collection<User> getUsers() {
		
		return users.values();
	}

	@Override
	public User createUser(User user) {
		
		User createdUser =new User();
		createdUser.setName(user.getName());
		createdUser.setSurname(user.getSurname());
		createdUser.setDocument(user.getDocument());
		createdUser.setEmail(user.getEmail());
		createdUser.setPhone(user.getPhone());
		createdUser.setPassword(user.getPassword());
		String userId = UUID.randomUUID().toString();
		createdUser.setUserId(userId);
		
		
		if(users == null) {			
			users = new HashMap<>();
						
		}
		users.put(userId, createdUser);		
		return createdUser;
		
		
	}

	@Override
	public User getUser(String userId) {
		
		return users.get(userId);
	}

	@Override
	public User updateUser(String userId, User user) {
		User userFromDatabase = users.get(userId);
		userFromDatabase.setName(user.getName());
		userFromDatabase.setSurname(user.getSurname());
		userFromDatabase.setDocument(user.getDocument());
		userFromDatabase.setEmail(user.getEmail());
		userFromDatabase.setPhone(user.getPhone());
		userFromDatabase.setPassword(user.getPassword());
		
		return userFromDatabase;
	}

	@Override
	public void deleteUser(String userId) {
	 users.remove(userId);
		
	}

}

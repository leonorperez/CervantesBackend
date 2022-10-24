package com.cervantes.app.services;

import java.util.Collection;

import com.cervantes.app.models.User;

public interface UserService {
//	User createUser(User user);
//	
//	Collection<User> getUsers();
//	
//	User getUser(String userId);
//	
//	User updateUser(String userId, User user);
//	
//	void deleteUser(String userId);
//	

	void saveUser(User user);

	public User getUser(Integer id);

	void deleteUser(Integer id);

}

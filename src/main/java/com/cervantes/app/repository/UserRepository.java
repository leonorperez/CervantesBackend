package com.cervantes.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cervantes.app.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}

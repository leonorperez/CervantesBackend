package com.cervantes.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="usuarios",schema ="clubcervantes")
public class User {
	public User() {

	}

	

	public User(Integer userId, String name, String surname, int document, String password, String email, int phone) {
		super();
		this.userId = userId;
		this.name = name;
		this.surname = surname;
		this.document = document;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}


	@Id
	@Column(name="userId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer userId;	
	
	private String name;
	private String surname;
	private int document;
	private String password;
	private String email;
	private int phone;
	   
	
	public Integer getUserId() {
        return userId;
    }
	public void setUserId(Integer id) {
		this.userId = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getDocument() {
		return document;
	}

	public void setDocument(int document) {
		this.document = document;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	



	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", surname=" + surname + ", document=" + document
				+ ", password=" + password + ", email=" + email + ", phone=" + phone + "]";
	}
	

}

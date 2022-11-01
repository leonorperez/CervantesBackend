package com.cervantes.app.models;


import javax.persistence.*;


@Entity
@Table(name="usuarios")
public class User {
	private Integer user_id;	
	private String name;
	private String surname;
	private int document;
	private String password;
	private String email;
	private int phone;
	
	public User() {

	}
	

	public User(Integer user_id, String name, String surname, int document, String password, String email, int phone) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.surname = surname;
		this.document = document;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
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
		return "User [user_id=" + user_id + ", name=" + name + ", surname=" + surname + ", document=" + document
				+ ", password=" + password + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
	
}

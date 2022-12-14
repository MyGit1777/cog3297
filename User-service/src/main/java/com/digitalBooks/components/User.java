package com.digitalBooks.components;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;

//change package name to model

@Entity
@Table(name="user")
public class User {
	
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USERID")
	private int userId;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="ROLE")
	private String role;
	
	//List<Book> books = new ArrayList<>();

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
//	public List<Book> getBooks() {
//		return books;
//	}
//	public void setBooks(List<Book> books) {
//		this.books = books;
//	}
//	public User(int userId, String userName, List<Book> books) {
//		super();
//		this.userId = userId;
//		this.userName = userName;
//		this.books = books;
//	}
	public User(int userId, String userName,String password,String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role =role;
	}
	public User() {
		
	}

}

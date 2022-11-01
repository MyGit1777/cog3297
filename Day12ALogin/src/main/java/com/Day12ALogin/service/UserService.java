package com.Day12ALogin.service;

import java.util.Optional;

import com.Day12ALogin.model.User;

public interface UserService {
	public User getUser(int userId);
	public User createUser(User user);
	public User getUserByUserNameAndPassword(String userName, String password);

}

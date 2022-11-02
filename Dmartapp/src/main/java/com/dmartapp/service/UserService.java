package com.dmartapp.service;

import com.dmartapp.model.User;

public interface UserService {
	public User getUser(Long userId);
	public User createUser(User user);
	public User getUserByUserNameAndPassword(String userName, String password);

}

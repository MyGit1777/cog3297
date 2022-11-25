package com.dataloaderportal.service;

import com.dataloaderportal.model.User;

public interface UserService {
	
	public User getUser(Long userId);
	public User createUser(User user);
	public User updateUser(User user);
	public User getUserByUserNameAndPassword(String userName, String password);

}

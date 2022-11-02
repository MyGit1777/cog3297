package com.dmartapp.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.dmartapp.model.User;
import com.dmartapp.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@org.springframework.beans.factory.annotation.Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {

		User createdUser = userRepository.save(user);
		return createdUser;
	}

	@Override
	public User getUser(Long userId) {
		User user = userRepository.findByUserId(userId);

		return user;
	}

	@Override
	public User getUserByUserNameAndPassword(String userName, String password) {

		List<User> users = userRepository.findAll();
		for (User user : users) {

			if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				return (user);

			}
		}
		return null;

	}
}
package com.dataloaderportal.repoTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dataloaderportal.model.User;
import com.dataloaderportal.repository.UserRepository;

@SpringBootTest
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepo;

	@Test
	void createUserTest() {
		User user = new User(1L, "Avinash", "Jadhav", "avinash@gmail.com", "Avinash@177", 0);
		userRepo.save(user);
		User retrievedUser = userRepo.findByUserName("avinash@gmail.com");
		assertThat(retrievedUser).isNotNull();
		assertThat(retrievedUser.getPassword().equals(user.getPassword()));

	}
}

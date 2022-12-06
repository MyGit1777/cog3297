package com.dataloaderportal.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dataloaderportal.model.User;
import com.dataloaderportal.repository.UserRepository;
import com.dataloaderportal.service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	
	private UserRepository userRepo;

	@InjectMocks
	private UserServiceImpl userServiceImpl;
	private User user;

	@BeforeEach
	void setUp() {
		
		userRepo = Mockito.mock(UserRepository.class);
        userServiceImpl = new UserServiceImpl(userRepo);
		user = User.builder()
				.firstName("Avinash")
				.lastName("Jadhav")
				.userName("avinash@gmail.com")
				.password("Avinash@177").build();

	}

//	@Test
//	public void getUserByUserNameAndPasswordTest() throws Exception {
//
//		User createddUser1 = userRepo.save(user);
//
//		User retrievedUser = userServiceImpl.getUserByUserNameAndPassword(user.getUserName(), user.getPassword());
//		assertThat(retrievedUser).isNotNull();
//	}

	@Test
	public void updateUserTest() {
		user.setUserName("Marc@gmail.com");
		user.setFirstName("Marc");
		user.setLastName("Nicolic");
		user.setPassword("MarcNicolic@177");
		User updatedUser = userServiceImpl.updateUser(user);

		assertThat(updatedUser).isNotNull();
		assertThat(updatedUser.getFirstName()).isEqualTo("Marc");
		assertThat(updatedUser.getLastName()).isEqualTo("Nicolic");
		assertThat(updatedUser.getUserName()).isEqualTo("Marc@gmail.com");

	}
	
	@Test
	public void getUserTest() {
		user.setUserName("Marc@gmail.com");
		user.setFirstName("Marc");
		user.setLastName("Nicolic");
		user.setPassword("MarcNicolic@177");
		User updatedUser = userServiceImpl.updateUser(user);
//		User searchedUser = userServiceImpl.getUser(updatedUser.getUserId());
		assertThat(updatedUser).isNotNull();
		assertThat(updatedUser.getFirstName()).isEqualTo("Marc");
		assertThat(updatedUser.getLastName()).isEqualTo("Nicolic");
		assertThat(updatedUser.getUserName()).isEqualTo("Marc@gmail.com");

	}

}

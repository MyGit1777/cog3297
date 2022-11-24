package com.dataloaderportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dataloaderportal.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserId(Long usrId);
	User findByUserName(String userName);
}

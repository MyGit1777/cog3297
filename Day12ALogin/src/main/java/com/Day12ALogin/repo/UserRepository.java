package com.Day12ALogin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Day12ALogin.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserId(int usrId);

	User findByUserName(String userName);
}
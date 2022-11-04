package com.dmartapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmartapp.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserId(Long usrId);

	User findByUserName(String userName);
}
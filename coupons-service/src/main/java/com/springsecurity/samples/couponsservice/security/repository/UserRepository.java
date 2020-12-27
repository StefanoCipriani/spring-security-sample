package com.springsecurity.samples.couponsservice.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.samples.couponsservice.security.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String mail);
}

package com.springsecurity.samples.couponsservice.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.samples.couponsservice.security.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}

package com.dronezzfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dronezzfly.model.UserRegistration;

public interface UserRepo extends JpaRepository<UserRegistration, Long> {

}

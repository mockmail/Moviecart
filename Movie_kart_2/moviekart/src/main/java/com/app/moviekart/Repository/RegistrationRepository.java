package com.app.moviekart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.moviekart.model.User;

public interface RegistrationRepository extends JpaRepository<User, Integer> {
	public User findByEmailId(String emailID);
	public User findByEmailIdAndPassword(String emailID, String password);

}

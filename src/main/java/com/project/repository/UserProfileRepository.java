package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

	public UserProfile findByRole(String role);
}

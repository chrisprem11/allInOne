package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

	public AppUser findByUsername(String username);
}

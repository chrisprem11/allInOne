package com.project.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.DTO.UserDTO;
import com.project.model.AppUser;
import com.project.model.UserProfile;
import com.project.repository.UserProfileRepository;
import com.project.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public List<AppUser> getUsers() {
		return userRepository.findAll();
	}

	public AppUser getUser(String username) {
		return userRepository.findByUsername(username);
	}

	public AppUser addUser(UserDTO userDTO) {
		AppUser user = modelMapper.map(userDTO, AppUser.class);
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		UserProfile profile = userProfileRepository.findByRole("user");
		if (profile == null) {
			profile = new UserProfile();
			profile.setRole("user");
			userProfileRepository.save(profile);
		}
		Set<UserProfile> profiles = new HashSet<>();
		profiles.add(profile);
		user.setUserProfiles(profiles);
		return userRepository.save(user);
	}

	public void deleteUser(String username) {
		AppUser user = userRepository.findByUsername(username);
		if (user == null) {
			System.out.println("USer Not Found");
		}
		userRepository.delete(user);
	}
}

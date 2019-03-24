package com.project.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Qualifier("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.project.model.AppUser user = userService.getUser(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found !!");
		}
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, getAuthorities(user));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(com.project.model.AppUser user) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		user.getUserProfiles().forEach(role -> {
			System.out.println("Profile Found -->" + "ROLE_" + role.getRole());
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
		});
		return authorities;
	}

}

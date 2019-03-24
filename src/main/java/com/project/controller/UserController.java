package com.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/user/test")
	public ResponseEntity<String> testRequest() {
		return new ResponseEntity<String>("Protected User Resources...", HttpStatus.OK);
	}
}

package com.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.DTO.UserDTO;
import com.project.model.AppUser;
import com.project.service.CustomEmailService;
import com.project.service.MailClientService;
import com.project.service.UserService;

@RestController
@RequestMapping("/rest")
public class HomeController {

	private static Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private MailClientService mailClientService;

	@Autowired
	private CustomEmailService emailService;

	@Autowired
	private UserService userService;

	@GetMapping("/app")
	public ResponseEntity<String> testApp() {
		return new ResponseEntity<String>("App is running !!", HttpStatus.OK);
	}

	@GetMapping("/users")
	public ResponseEntity<List<AppUser>> getUsers() {
		List<AppUser> users = userService.getUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<AppUser>>(users, HttpStatus.OK);
	}

	@PostMapping(path = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AppUser> addUSer(@RequestBody UserDTO userDTO) {
		AppUser user = userService.addUser(userDTO);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}
		return new ResponseEntity<AppUser>(user, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/delete-user")
	public ResponseEntity<String> deleteUser(@RequestParam("username") String username) {
		userService.deleteUser(username);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}

	@GetMapping("/mail")
	public ResponseEntity<String> testMail() {
		String recipient = "chris.prem12@gmail.com";
		String message = "Gmail Message Has Been Sent With Modification!!";
		System.out.println("About to send mail");
		mailClientService.prepareAndSend(recipient, message);
		return new ResponseEntity<String>("Mail Sending..Check..", HttpStatus.OK);
	}

	@GetMapping("/email")
	public ResponseEntity<String> testEmail() {
		log.info("Sending Email with Thymeleaf HTML Template Example");
		String subject = "Sending Email with Thymeleaf HTML Template Example";
		Map<String, Object> model = new HashMap<>();
		model.put("name", "Prem Bhai");
		model.put("location", "India");
		model.put("signature", "chris...prem");
		emailService.sendEmail("chris.prem12@gmail.com", subject, model);

		return new ResponseEntity<String>("Sent !!", HttpStatus.OK);
	}

}

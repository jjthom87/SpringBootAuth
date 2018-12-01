package com.jao.web.controller;

import java.security.Principal;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jao.web.domain.Register;
import com.jao.web.entity.UserEntity;
import com.jao.web.repository.UserRepository;

@RestController
@RequestMapping("/v1")
public class WebController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private static Logger log = Logger.getLogger("InfoLogging");
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> registerUser(@RequestBody Register registerObj) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(registerObj.getUsername());
		userEntity.setPassword(bCryptPasswordEncoder.encode(registerObj.getPassword()));
		userRepository.save(userEntity);
		return new ResponseEntity<String>("Register Post", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public Object getUser() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
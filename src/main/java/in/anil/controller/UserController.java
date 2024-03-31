package in.anil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.anil.binding.UserLoginForm;
import in.anil.binding.UserRegistrationForm;
import in.anil.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/citizen")
	public ResponseEntity<String> registerCitizen(@RequestBody UserRegistrationForm userRegistrationForm) {
		boolean user = userService.saveUser(userRegistrationForm);
		return (user) ? new ResponseEntity<String>("user saved", HttpStatus.CREATED) : new ResponseEntity<String>("something went wrong", HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginCheck(@RequestBody UserLoginForm userLoginForm) {
		boolean user = userService.loginUser(userLoginForm);
		return (user) ? new ResponseEntity<String>("user logged in", HttpStatus.OK) : new ResponseEntity<String>("something went wrong", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/password")
	public ResponseEntity<String> passwordRecovery(@RequestParam String email) {
		boolean user = userService.forgotPasswordFunctionality(email);
		return (user) ? new ResponseEntity<String>("password sent to your email address", HttpStatus.OK) : new ResponseEntity<String>("something went wrong", HttpStatus.BAD_REQUEST);
	}
}

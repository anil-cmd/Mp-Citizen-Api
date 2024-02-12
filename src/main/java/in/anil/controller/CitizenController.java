package in.anil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.anil.binding.CitizenLoginForm;
import in.anil.binding.CitizenRegistrationForm;
import in.anil.service.CitizenService;

@RestController
public class CitizenController {
	
	@Autowired
	private CitizenService citizenService;
	
	@PostMapping("/citizen")
	public ResponseEntity<String> registerCitizen(@RequestBody CitizenRegistrationForm citizenRegistrationForm) {
		boolean citizen = citizenService.saveCitizen(citizenRegistrationForm);
		return (citizen) ? new ResponseEntity<String>("user saved", HttpStatus.CREATED) : new ResponseEntity<String>("something went wrong", HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginCheck(@RequestBody CitizenLoginForm citizenLoginForm) {
		boolean citizen = citizenService.loginCitizen(citizenLoginForm);
		return (citizen) ? new ResponseEntity<String>("user logged in", HttpStatus.OK) : new ResponseEntity<String>("something went wrong", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/password")
	public ResponseEntity<String> passwordRecovery(@RequestParam String email) {
		boolean citizen = citizenService.forgotPasswordFunctionality(email);
		return (citizen) ? new ResponseEntity<String>("password sent to your email address", HttpStatus.OK) : new ResponseEntity<String>("something went wrong", HttpStatus.BAD_REQUEST);
	}
}

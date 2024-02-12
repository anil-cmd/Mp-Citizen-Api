package in.anil.service;

import in.anil.binding.CitizenLoginForm;
import in.anil.binding.CitizenRegistrationForm;

public interface CitizenService {
	
	public boolean saveCitizen(CitizenRegistrationForm citizenRegistrationForm);
	
	public boolean loginCitizen(CitizenLoginForm citizenLoginForm);
	
	public boolean forgotPasswordFunctionality(String email);

}

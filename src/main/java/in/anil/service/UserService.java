package in.anil.service;

import in.anil.binding.UpdatePasswordForm;
import in.anil.binding.UserLoginForm;
import in.anil.binding.UserRegistrationForm;

public interface UserService {
	
	public boolean saveUser(UserRegistrationForm userRegistrationForm);
	
	public boolean loginUser(UserLoginForm userLoginForm);
	
	public boolean forgotPasswordFunctionality(String email);
	
	public boolean updatePassword(UpdatePasswordForm updatePasswordForm, Integer userId);

}

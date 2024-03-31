package in.anil.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.anil.binding.UpdatePasswordForm;
import in.anil.binding.UserLoginForm;
import in.anil.binding.UserRegistrationForm;
import in.anil.entity.User;
import in.anil.repo.UserRepo;
import in.anil.utils.EmailUtils;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private EmailUtils emailUtils;
	

	@Override
	public boolean saveUser(UserRegistrationForm userRegistrationForm) {
		
		String dummyPassword = generatePwd(10);
		userRegistrationForm.setPassword(dummyPassword);
		userRegistrationForm.setPasswordUpdated("No");
		User user = new User();
		BeanUtils.copyProperties(userRegistrationForm, user);
		User savedUser = userRepo.save(user);
		
		boolean isSent = false;
		if(savedUser != null) {
			String subject = "Password Update";
			String body = "Hi Mr. " + savedUser.getName() + " this is your temporary password :" + savedUser.getPassword();
			emailUtils.sendEmail(savedUser.getEmail(), subject, body);
			isSent = true;
			return (isSent) ? true : false;
		}else {
			return false;
		}
	}
	
	private String generatePwd(Integer len) {
	    String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    Random rnd = new Random();

	    StringBuilder sb = new StringBuilder(len);
	    for (int i = 0; i < len; i++) {
	        sb.append(AB.charAt(rnd.nextInt(AB.length())));
	    }
	    return sb.toString();
	}

	@Override
	public boolean loginUser(UserLoginForm userLoginForm) {
		
		User user = userRepo.findByEmailAndPassword(userLoginForm.getEmail(), userLoginForm.getPassword());
		return (user != null) ? true : false;
	}

	@Override
	public boolean forgotPasswordFunctionality(String email) {
		User user = userRepo.findByEmail(email);
		boolean isSent = false;
		if(user != null) {
			String subject = "Password Recovery";
			String body = " Hello Mr." + user.getName() + " this is your password : " + user.getPassword();
			emailUtils.sendEmail(user.getEmail(), subject, user.getPassword());
			isSent = true;
			return (isSent) ? true : false;
		}else {
			return false;
		}
	}
	
	
	public boolean updatePassword(UpdatePasswordForm updatePasswordForm, Integer userId) {
		
		Optional<User> user = userRepo.findById(userId);
		if(user.isPresent()) {
			User userFromDb = user.get(); 
			userFromDb.setPassword(updatePasswordForm.getNewPassword());
			userFromDb.setPasswordUpdated("Yes");
			userRepo.save(userFromDb);
			return true;
		}
		return false;	
	}
	

}

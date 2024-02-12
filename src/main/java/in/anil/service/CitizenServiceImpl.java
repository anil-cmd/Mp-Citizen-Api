package in.anil.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.anil.binding.CitizenLoginForm;
import in.anil.binding.CitizenRegistrationForm;
import in.anil.entity.Citizen;
import in.anil.repo.CitizenRepo;
import in.anil.utils.EmailUtils;

@Service
public class CitizenServiceImpl implements CitizenService{
	
	@Autowired
	private CitizenRepo citizenRepo;
	
	@Autowired
	private EmailUtils emailUtils;
	

	@Override
	public boolean saveCitizen(CitizenRegistrationForm citizenRegistrationForm) {
		
		Citizen citizen  = citizenRepo.findByEmail(citizenRegistrationForm.getEmail());
		if(citizen == null) {
			Citizen citizenEntity = new Citizen();
			BeanUtils.copyProperties(citizenRegistrationForm, citizenEntity);
			Citizen savedCitizen = citizenRepo.save(citizenEntity);
			
			return (savedCitizen.getCitizenName().equals(citizenRegistrationForm.getCitizenName())) ? true : false;
		}else {
			return false;
		}
	}

	@Override
	public boolean loginCitizen(CitizenLoginForm citizenLoginForm) {
		
		Citizen citizen = citizenRepo.findByEmailAndPassword(citizenLoginForm.getEmail(), citizenLoginForm.getPassword());
		return (citizen != null) ? true : false;
	}

	@Override
	public boolean forgotPasswordFunctionality(String email) {
		Citizen citizen = citizenRepo.findByEmail(email);
		boolean isSent = false;
		if(citizen != null) {
			String subject = "Password Recovery";
			String body = " Hello Mr." + citizen.getCitizenName() + " this is your password : " + citizen.getPassword();
			emailUtils.sendEmail(citizen.getEmail(), subject, citizen.getPassword());
			isSent = true;
			return (isSent) ? true : false;
		}else {
			return false;
		}
	}

}

package in.anil.binding;

public class CitizenRegistrationForm {
	
	private String citizenName;
	
	private String email;
	
	private String gender;
	
	private String phoneNumber;
	
	private String password;

	public String getCitizenName() {
		return citizenName;
	}

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CitizenRegistrationForm [citizenName=" + citizenName + ", email=" + email + ", gender=" + gender
				+ ", phoneNumber=" + phoneNumber + ", password=" + password + "]";
	}
	
}

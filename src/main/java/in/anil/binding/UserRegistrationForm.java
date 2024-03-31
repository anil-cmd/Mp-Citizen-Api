package in.anil.binding;

public class UserRegistrationForm {
	
	private String name;
	
	private String email;
	
	private String gender;
	
	private String phoneNumber;
	
	private String password;
	
	private String passwordUpdated;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	

	public String getPasswordUpdated() {
		return passwordUpdated;
	}

	public void setPasswordUpdated(String passwordUpdated) {
		this.passwordUpdated = passwordUpdated;
	}

	@Override
	public String toString() {
		return "UserRegistrationForm [name=" + name + ", email=" + email + ", gender=" + gender + ", phoneNumber="
				+ phoneNumber + ", password=" + password + ", passwordUpdated=" + passwordUpdated + "]";
	}

	
}

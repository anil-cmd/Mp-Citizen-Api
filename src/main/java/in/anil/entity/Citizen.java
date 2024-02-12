package in.anil.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "citizen_Role")
public class Citizen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer citizenId;
	
	private String citizenName;
	
	private String email;
	
	private String gender;
	
	private String phoneNumber;
	
	private String password;

	public Citizen() {
		super();
	}

	public Citizen(Integer citizenId, String citizenName, String email, String gender, String phoneNumber,
			String password) {
		super();
		this.citizenId = citizenId;
		this.citizenName = citizenName;
		this.email = email;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	public Integer getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(Integer citizenId) {
		this.citizenId = citizenId;
	}

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
		return "Citizen [citizenId=" + citizenId + ", citizenName=" + citizenName + ", email=" + email + ", gender="
				+ gender + ", phoneNumber=" + phoneNumber + ", password=" + password + "]";
	}

	
}

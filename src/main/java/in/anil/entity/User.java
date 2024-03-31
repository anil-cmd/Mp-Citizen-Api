package in.anil.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_tbl")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	private String name;
	
	private String email;
	
	private String gender;
	
	private String phoneNumber;
	
	private String password;
	
	private String passwordUpdated;
	
	private String role;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDateTime UpdatedDate;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String name, String email, String gender, String phoneNumber, String password,
			String passwordUpdated, String role, LocalDateTime createdDate, LocalDateTime updatedDate) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.passwordUpdated = passwordUpdated;
		this.role = role;
		this.createdDate = createdDate;
		UpdatedDate = updatedDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return UpdatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		UpdatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", gender=" + gender
				+ ", phoneNumber=" + phoneNumber + ", password=" + password + ", passwordUpdated=" + passwordUpdated
				+ ", role=" + role + ", createdDate=" + createdDate + ", UpdatedDate=" + UpdatedDate + "]";
	}
	
}

package com.cg.onlinepharmacystore.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "user_table")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	@Column(name="FullName")
	private String name;
	@Column(name="UserName")
	private String userName;
	@Column(name="Password")
	private String password;
	@Column(name="Age")
	private Integer age;
	@Column(name="Gender")
	private String gender;
	@Column(name="Address")
	private String address;
	@Column(name="Prescription")
	private String prescription;
	@Column(name="MobileNumber")
	@Pattern(regexp="(^$|[0-9]{10})")
	private String mNumber;
	@Column(name = "email")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String email;
	public User() {
		super();
	}
	public User(String name, String userName, String password, Integer age, String gender, String address,
			String prescription, String mNumber,String email) {
		super();
		this.name = name;
		this.userName = userName;
//		this.userId = userId;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.prescription = prescription;
		this.mNumber = mNumber;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
//	public Long getUserId() {
//		return userId;
//	}
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public String getmNumber() {
		return mNumber;
	}
	public void setmNumber(String mNumber) {
		this.mNumber = mNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [Name=" + name + ", userId=" + userId + ", UserName=" + userName+ ", Password=" + password
				+ ", address=" + address+ ", MobileNumber =" + mNumber + ", Age=" + age + ", Gender=" + gender+
				", Prescription=" + prescription + ", Email=" + email+ "]";
	}
	
}

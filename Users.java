package com.app.pojos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Users {
private Integer UserId;
private String EmailId,Name,Password,MobileNo;
@JsonIgnore
private List<OtpDetails> otpDetails = new ArrayList<>();
private Roles role;
@JsonIgnore
private List<OrderDetails> details = new ArrayList<>();


public Users()
{
	System.out.println("Inside Users constructor !!");
}

public Users(String EmailId,String Name,String Password,String MobileNo)
{
	super();
	this.EmailId=EmailId;
	this.Name=Name;
	this.Password=Password;
	this.MobileNo=MobileNo;
}
public Users(String EmailId,String Password)
{
	super();
	this.EmailId=EmailId;
	this.Password=Password;
}
public Users(String EmailId,String Name,String Password,String MobileNo,Roles role)
{
	super();
	this.EmailId=EmailId;
	this.Name=Name;
	this.Password=Password;
	this.MobileNo=MobileNo;
	this.role=role;
}


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getUserId() {
	return UserId;
}

public void setUserId(Integer userId) {
	UserId = userId;
}


@Column(length = 50,unique = true)
public String getEmailId() {
	return EmailId;
}

public void setEmailId(String emailId) {
	EmailId = emailId;
}

@Column(length = 50)
public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public String getPassword() {
	return Password;
}

public void setPassword(String password) {
	Password = password;
}

@Column(length = 10,unique = true)
public String getMobileNo() {
	return MobileNo;
}

public void setMobileNo(String mobileNo) {
	MobileNo = mobileNo;
}

@ManyToOne
@JoinColumn(name = "RoleId")
public Roles getRole() {
	return role;
}

public void setRole(Roles role) {
	this.role = role;
}

@OneToMany(fetch = FetchType.EAGER,mappedBy = "usr",cascade = CascadeType.ALL,orphanRemoval = true)
public List<OtpDetails> getOtpdetails() {
	return otpDetails;
}

public void setOtpdetails(List<OtpDetails> otpdetails) {
	this.otpDetails = otpdetails;
}



@OneToMany(fetch = FetchType.EAGER,mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
public List<OrderDetails> getDetails() {
	return details;
}

public void setDetails(List<OrderDetails> details) {
	this.details = details;
}

@Override
public String toString() {
	return "Users [UserId=" + UserId + ", EmailId=" + EmailId + ", Name=" + Name + ", Password=" + Password
			+ ", MobileNo=" + MobileNo + ", role=" + role + "]";
}




}

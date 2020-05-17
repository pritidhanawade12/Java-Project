package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OtpDetails {
private Integer otpId;
private String otp;
private Date generatedOn;
private Users user;

private OtpDetails()
{
	System.out.println("In constructor of otpDetails");
}

private OtpDetails(String otp,Date generatedOn)
{
	this.otp=otp;
	this.generatedOn=generatedOn;
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getOtpId() {
	return otpId;
}

public void setOtpId(Integer otpId) {
	this.otpId = otpId;
}

@Column(length = 40)
public String getOtp() {
	return otp;
}

public void setOtp(String otp) {
	this.otp = otp;
}

public Date getGeneratedOn() {
	return generatedOn;
}

public void setGeneratedOn(Date generatedOn) {
	this.generatedOn = generatedOn;
}

@JsonIgnore
@ManyToOne
@JoinColumn(name = "UserId")
public Users getUser() {
	return user;
}

public void setUser(Users user) {
	this.user = user;
}

@Override
public String toString() {
	return "OtpDetails [otpId=" + otpId + ", otp=" + otp + ", generatedOn=" + generatedOn + "]";
}




}

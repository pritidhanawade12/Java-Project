package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedbacks {
private Integer feedbackId;
private String emailId;
private String title;
private String description;


public Feedbacks()
{
	System.out.println("In feedback constructor !!");
}


public Feedbacks(Integer feedbackId,String emailId,String title,String description)
{
	super();
	this.feedbackId=feedbackId;
	this.emailId=emailId;
	this.title=title;
	this.description=description;
	
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getFeedbackId() {
	return feedbackId;
}


public void setFeedbackId(Integer feedbackId) {
	this.feedbackId = feedbackId;
}

@Column(length = 50)
public String getEmailId() {
	return emailId;
}


public void setEmailId(String emailId) {
	this.emailId = emailId;
}

@Column(length = 50)
public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


@Override
public String toString() {
	return "Feedbacks [feedbackId=" + feedbackId + ", emailId=" + emailId + ", title=" + title + ", description="
			+ description + "]";
}





}

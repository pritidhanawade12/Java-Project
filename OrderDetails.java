package com.app.pojos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderDetails {
	
private Integer orderId;
private String description;
private Date orderDate;
private Users user;

public OrderDetails()
{
	System.out.println("In constructor of orderDetails");
}

public OrderDetails(String description,Date orderDate)
{
	super();
	this.description=description;
	this.orderDate=orderDate;
	
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getOrderId() {
	return orderId;
}

public void setOrderId(Integer orderId) {
	this.orderId = orderId;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Date getOrderDate() {
	return orderDate;
}

public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}


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
	return "OrderDetails [orderId=" + orderId + ", description=" + description + ", orderDate=" + orderDate + "]";
}





}

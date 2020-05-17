package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Products {
private Integer productId;
private String productName;
private String productDescription;
private Integer productPrice;
private Categories category;
	
public Products()
{
	System.out.println("inside products pojo");
}

public Products(String productName,String productDescription, Integer productPrice)
{
	super();
	this.productName=productName;
	this.productDescription=productDescription;
	this.productPrice=productPrice;
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getProductId() {
	return productId;
}

public void setProductId(Integer productId) {
	this.productId = productId;
}

@Column(length = 40)
public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

@Column(length = 60)
public String getProductDescription() {
	return productDescription;
}

public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}

public Integer getProductPrice() {
	return productPrice;
}

public void setProductPrice(Integer productPrice) {
	this.productPrice = productPrice;
}

@ManyToOne
@JoinColumn(name = "CategoryId")
public Categories getCategory() {
	return category;
}

public void setCategory(Categories category) {
	this.category = category;
}

@Override
public String toString() {
	return "Products [productId=" + productId + ", productName=" + productName + ", productDescription="
			+ productDescription + ", productPrice=" + productPrice + "]";
}





}

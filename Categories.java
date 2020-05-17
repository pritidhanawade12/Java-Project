package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categories {
private Integer categoryId;
private Category categoryName;
@JsonIgnore
private List<Products> prodcts = new ArrayList<>();

public Categories()
{
	System.out.println("inside categories pojo ");
}

public Categories(Category categoryName)
{
	super();
	this.categoryName=categoryName;
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getCategoryId() {
	return categoryId;
}

public void setCategoryId(Integer categoryId) {
	this.categoryId = categoryId;
}

@Column(length = 15)
@Enumerated(EnumType.STRING)
public Category getCategoryName() {
	return categoryName;
}

public void setCategoryName(Category categoryName) {
	this.categoryName = categoryName;
}

@OneToMany(orphanRemoval = true,fetch = FetchType.EAGER,mappedBy = "category",cascade = CascadeType.ALL)
public List<Products> getProdcts() {
	return prodcts;
}

public void setProdcts(List<Products> prodcts) {
	this.prodcts = prodcts;
}

@Override
public String toString() {
	return "Categories [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
}

public void addproduct(Products p) {
	System.out.println("helper method");
	// add student info in course
	prodcts.add(p);
	System.out.println("helper method");
	// add course info to student
	p.setCategory(this);
	System.out.println("helper method");
}


}

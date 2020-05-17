package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IAdminDao;
import com.app.dao.IUserDao;
import com.app.pojos.Categories;
import com.app.pojos.Feedbacks;
import com.app.pojos.Products;
import com.app.pojos.Users;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/user")
public class UserController {

	
@Autowired
IUserDao userdao;
@Autowired
IAdminDao dao;
public UserController()
{
	System.out.println("In user Controller !!");
}


@PostMapping("/register")
public Integer register(@RequestBody Users user)
{
if(userdao.registerUser(user)!=0)
{
	return 1;
}
else
{
	return 0;
}
	
}
@PostMapping("/feedback")
public Integer feedback(@RequestBody Feedbacks feedback)
{
if(userdao.feedback(feedback)!=0)
{
	return 1;
}
else
{
	return 0;
}
	
}







@PutMapping("/updatePassword/{Npassword}")
public Integer UpdatePassword(@PathVariable String Npassword ,@RequestBody Users user)
{
	
	int userId=user.getUserId();
	String password = user.getPassword();
	System.out.println(userId+" "+password+" "+Npassword);
if(userdao.updatePassword(userId, password, Npassword)!=0)
{
	return 1;
}
else
{
	return 0;
}
	
}






@PostMapping("/login")
public Users login(@RequestBody Users user) {
	System.out.println("input from ui is "+user);
	Users u=userdao.login(user);
	System.out.println("output in controller is ::");
	System.out.println(u);
	if(u.getName() !=null)
	{
		System.out.println("login successful");
	}
    return u ;
	
}

@PostMapping("/login1")
public Users login1(@RequestParam String emailId, @RequestParam String password) {
	System.out.println("email id is"+emailId);
	Users u=userdao.login1(emailId,password);
	System.out.println("output in controller is ::");
	System.out.println(u);
	if(u.getName() !=null)
	{
		System.out.println("login successful");
	}
	else
	{
		System.out.println("invalid");
		
	}
	return u;
	
}


@GetMapping("/getPlan/{categoryId}")
public List<Products> getPlan(@PathVariable int categoryId)
{
	System.out.println("categoryId is"+categoryId);
	//Categories category = userdao.category(categoryId);
	
	Categories category1 = dao.category(categoryId);
	
	
//	System.out.println(category);
	List<Products> products=category1.getProdcts();
	System.out.println(products);
	return products;
	
}






	
}

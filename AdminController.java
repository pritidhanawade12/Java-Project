package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.app.pojos.Products;
import com.app.pojos.Users;



@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {


@Autowired	
private IAdminDao dao;




	
public AdminController()
{
	System.out.println("In admin controller !!");
}


@GetMapping("/allUsers")
public ResponseEntity<?>getAllUsers()
{
	return new ResponseEntity<List<Users>>(dao.allUsers(),HttpStatus.OK);
	
}

@GetMapping("/allProducts")
public ResponseEntity<?>getAllProducts()
{
	
	return new ResponseEntity<List<Products>>(dao.allProducts(),HttpStatus.OK);
	
}
@GetMapping("/allCategories")
public ResponseEntity<?>getAllCategories()
{
	
	return new ResponseEntity<List<Categories>>(dao.allCategories(),HttpStatus.OK);
	
}

@GetMapping("/getProduct/{productId}")
public Products findProduct(@PathVariable int productId)
{
		return dao.findProduct(productId);		
}



@PutMapping("/updateProduct")
public Integer UpdateProduct(@RequestBody Products product)
{
	System.out.println(product.getProductId());
	int productId = product.getProductId();
	Products product1 = dao.findProduct(productId);
	if(dao.updateProduct(product,product1) !=0)
	{
		
		return 1;
	}
	else
	{
		
		return 0;
	}

	
}



@PostMapping("/addProduct/{categoryId}")
public Integer addProduct(@PathVariable int categoryId,@RequestBody Products product)
{
	System.out.println("add product");
	System.out.println(categoryId);
	System.out.println(product);
if(dao.addProduct(categoryId,product)!=0)
{
	return 1;
}
else
{
	return 0;
}
}	




@DeleteMapping("/deleteProduct/{productId}")
public Integer deleteProduct(@PathVariable Integer productId)
{
	System.out.println( "prouctId is ::"+productId);
	Products product = dao.findProduct(productId);
    System.out.println( productId);
if(dao.deleteProduct( product)!=0)
{
	return 1;
}
else
{
	return 0;
}
	
}



}

package com.app.dao;

import java.util.List;

import com.app.pojos.Categories;
import com.app.pojos.Products;
import com.app.pojos.Users;

public interface IAdminDao {
	public List<Users> allUsers();
	public List<Products> allProducts();
	public List<Categories> allCategories();
	public Integer deleteProduct(Products product);
	public Products findProduct(Integer id);
	public Integer addProduct(int categoryId, Products product);
	public Integer updateProduct(Products product, Products product1);
	public Categories category(Integer id);


}

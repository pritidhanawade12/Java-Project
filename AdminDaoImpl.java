package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Categories;
import com.app.pojos.Products;
import com.app.pojos.Roles;
import com.app.pojos.Users;

@Transactional
@Service
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	private SessionFactory sf;
	
	
	
	@Override
	public List<Users> allUsers() {
		// TODO Auto-generated method stub
		String jpql="select u from Users u";
		return sf.getCurrentSession().createQuery(jpql,Users.class).getResultList();
	}

	
	@Override
	public Products findProduct(Integer id) {
		// TODO Auto-generated method stub
		//String jpql="select p from Products p where p.productId=:productid";
		//return sf.getCurrentSession().createQuery(jpql,Products.class).setParameter("prouctid",id).getSingleResult();
		
		return sf.getCurrentSession().get(Products.class, id);
	}


	@Override
	public List<Products> allProducts() {
		// TODO Auto-generated method stub
		String jpql="select p from Products p";
		return sf.getCurrentSession().createQuery(jpql,Products.class).getResultList();
	}

	@Override
	public List<Categories> allCategories() {
		// TODO Auto-generated method stub
		String jpql="select c from Categories c";
		return sf.getCurrentSession().createQuery(jpql,Categories.class).getResultList();
	}



	@Override
	public Integer deleteProduct(Products product) {
		
		// TODO Auto-generated method stub
			sf.getCurrentSession().delete(product);
			return 1;
		
		
		
	}
	
	@Override
	public Integer addProduct(int categoryId,Products product) {
		System.out.println(product);
		// TODO Auto-generated method stub
		 System.out.println("priti here");
		 
		Categories category = category(categoryId);
		System.out.println(category);
		category.addproduct(product);
		return (Integer) sf.getCurrentSession().save(product);
	}

	
	@Override
	public Categories category(Integer id) {
		
		System.out.println("in category method ,id is"+id);
	String jpql="select c from Categories c where c.categoryId=:categoryid";
	return sf.getCurrentSession().createQuery(jpql,Categories.class).setParameter("categoryid",id).getSingleResult();
	}
	
	@Override
	public Integer updateProduct(Products product, Products product1) {
		// TODO Auto-generated method stub
		System.out.println(product);
		System.out.println(product1);
		product1.setProductName(product.getProductName());
		product1.setProductDescription(product.getProductDescription());
		product1.setProductPrice(product.getProductPrice());
		product1.setProductId(product.getProductId());
		System.out.println(product);
		System.out.println(product1);
		
        sf.getCurrentSession().update(product1);
        return 1;
	}

	
	
	
	
}

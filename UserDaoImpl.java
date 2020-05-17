package com.app.dao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Categories;
import com.app.pojos.Feedbacks;
import com.app.pojos.Roles;
import com.app.pojos.Users;

@Transactional
@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Integer registerUser(Users user) {
		System.out.println(user);
		// TODO Auto-generated method stub
		
		
		Roles role = role(2);
		//user.setRole(role);
		role.adduser(user);

		return (Integer) sf.getCurrentSession().save(user);
	}

	
	@Override
	public Roles role(Integer id) {
		
	String jpql="select r from Roles r where r.roleId=:roleid";
	return sf.getCurrentSession().createQuery(jpql,Roles.class).setParameter("roleid",id).getSingleResult();
	}
	
	
	@Override
	public Users login(Users user) {
		System.out.println("dao layer output is");
		System.out.println("email is "+user.getEmailId());
		
	String jpql="select u from Users u where u.emailId=:email and u.password=:password";
	return sf.getCurrentSession().createQuery(jpql,Users.class).setParameter("email",user.getEmailId()).setParameter("password",user.getPassword()).getSingleResult();
	
	}
	
	@Override
	public Users login1(String emailId, String password) {
		System.out.println("dao layer output is");
		System.out.println("email is "+emailId);
		
	String jpql="select u from Users u where u.emailId=:email and u.password=:password";
	return sf.getCurrentSession().createQuery(jpql,Users.class).setParameter("email",emailId).setParameter("password",password).getSingleResult();
	}


	@Override
	public Integer updatePassword(int userId, String password, String Npassword) {
		// TODO Auto-generated method stub
		System.out.println(userId+password+Npassword);
		Users u = sf.getCurrentSession().get(Users.class,userId);     
		System.out.println(u.getPassword());
        if(u.getPassword().equals(password))
        {
        	System.out.println("equal");
        	u.setPassword(Npassword);
            sf.getCurrentSession().save(u);
            return 1;
        }
        
        return 0;
		
	}


	@Override
	public Integer feedback(Feedbacks feedback) {
		// TODO Auto-generated method stub
		return (Integer) sf.getCurrentSession().save(feedback);
	}
	

	

}

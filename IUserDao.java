package com.app.dao;

import com.app.pojos.Categories;
import com.app.pojos.Feedbacks;
import com.app.pojos.Roles;
import com.app.pojos.Users;

public interface IUserDao {

public Integer registerUser(Users user);

public Roles role(Integer id);

public Users login(Users user);

public Users login1(String email, String password);

public Integer updatePassword(int userId, String password,String Npassword);

public Integer feedback(Feedbacks feedback);


}

package com.user_signup_login.dao;

import com.user_signup_login.entity.*;

public interface DAOInterface {

	int createDAOProfile(Entity e);
	public void getUser(String username,String password);

}

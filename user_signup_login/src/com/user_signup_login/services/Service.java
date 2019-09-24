package com.user_signup_login.services;

import com.user_signup_login.dao.DAO;
import com.user_signup_login.dao.DAOInterface;
import com.user_signup_login.entity.Entity;

public class Service implements ServiceInterface{
	
	private Service(){}

	public static ServiceInterface createServiceObject() {
		
		return new Service();
	}

	@Override
	public int createProfile(Entity e) {
		DAOInterface di=DAO.createDAOObject();
		
		return di.createDAOProfile(e);
	}

	

}

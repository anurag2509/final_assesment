package com.user_signup_login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.user_signup_login.entity.*;

public class DAO implements DAOInterface{
	
	private DAO(){}

	public static DAOInterface createDAOObject() {
		
		return new DAO();
	}

	@Override
	public int createDAOProfile(Entity e) {
		int i=0;
		try {
			Properties prop=new Properties();
			prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			prop.put(Context.PROVIDER_URL, "localhost:1099");
			prop.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
			
			InitialContext ctx= new InitialContext();
			
			DataSource ds;
			
			ds=(DataSource)ctx.lookup("java:/OracleDS");
			
			Connection con=ds.getConnection();
			
			PreparedStatement ps=con.prepareStatement("insert into users_entry values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, e.getFname());
			ps.setString(2, e.getLname());
			ps.setString(3, e.getGender());
			ps.setString(4, e.getDob());
			ps.setString(5, e.getCnumber());
			ps.setString(6, e.getUsername());
			ps.setString(7, e.getPass());
			ps.setString(8, e.getCpass());
			ps.setString(9, e.getCountry());
			ps.setString(10, e.getState());
			ps.setString(11, e.getCity());
			ps.setString(12, e.getPin());
			i=ps.executeUpdate();
		} 
		catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return i;
	}

	public  void getUser(String username,String password){
		try {
			String query="select * from users where username=";
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	}
	


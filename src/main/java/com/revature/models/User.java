package com.revature.models;

import java.util.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.ArrayList;
import java.util.List;


import com.revature.repositories.LoginDAO;
import com.revature.repositories.ReimbursementDAO;

public class User {
	
	private int userId;
	
	private String username;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Boolean isFinanceManager;
	
	public List <Reimbursements> user_reimb_list = new ArrayList<Reimbursements>();

	public User() {
		super();
	}
	
	public User(int userId, String username, String password, String firstName, String lastName, String email, Boolean isFinanceManager) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.isFinanceManager = isFinanceManager;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean get_isFinanceManager() {
		return isFinanceManager;
	}

	public void set_isFinanceManager(boolean isFinanceManager) {
		this.isFinanceManager = isFinanceManager;
	}
	
	public void approvingRequests(String reimb_status, Reimbursements reimb) {
		reimb.set_reimb_status(reimb_status);
		
		Date todaysDate = new Date();
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    String DateString = df.format(todaysDate);
	    
	    
		reimb.set_date_resolved(DateString);
		reimb.set_resolver(this.getUserId());
		
	}
	
	public static User verifyCustomer(String name, String password) {
		
		LoginDAO lDAO = new LoginDAO();
		
		ReimbursementDAO RDAO = new ReimbursementDAO();
		
		if (lDAO.DAOuserLogin(name, password) == null) {
			return null;
		}	else { 
			
			User u = lDAO.DAOuserLogin(name, password);
			RDAO.User_ReimbursementDAO(u);
			
			System.out.println("Account Verified!");
			return u;
		}
	}

}

package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.models.User;
import com.revature.repositories.LoginDAO;
import com.revature.repositories.ReimbursementDAO;


public class AuthController {
	
	//private UserService us = new UserServiceImplementation(new UserPostgresDao());
	
	private ObjectMapper om = new ObjectMapper();
	
	//actually do the request
	public User userLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		LoginDAO LDAO = new LoginDAO();	
		
		User u = om.readValue(req.getInputStream(), User.class);
		
		u = LDAO.DAOuserLogin(u.getUsername(), u.getPassword());
		ReimbursementDAO RDAO = new ReimbursementDAO();
		RDAO.User_ReimbursementDAO(u);
		
		//use your session to keep track of your user permission level
		HttpSession sess = req.getSession();
		
		if (u.get_isFinanceManager() == true) {
			sess.setAttribute("User-Role", "Finance Manager");
		} else if (u.get_isFinanceManager() == false){
			sess.setAttribute("User-Role", "User");
		} else {
			sess.setAttribute("User-Role", "Failed");
		}
		
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(u));
		return u;
	}
	
	
	

}

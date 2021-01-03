package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.UnauthenticatedException;
import com.revature.exceptions.UnauthorizedException;
import com.revature.models.User;
import com.revature.repositories.LoginDAO;


public class UserController {

	
	
	private ObjectMapper om = new ObjectMapper();
	

	public void findAllUsers(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		LoginDAO LDAO = new LoginDAO();
		
		HttpSession sess = req.getSession();
		
		
		if(sess.getAttribute("User-Role") == null) {
			throw new UnauthenticatedException();
		} else if(!sess.getAttribute("User-Role").equals("Finance Manager")) {
			throw new UnauthorizedException();
		}
		
		
		List<User> allusers = LDAO.findall();
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(allusers));
		
	}
	
}

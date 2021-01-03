package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.UnauthenticatedException;

public class OptionsController {

	private ObjectMapper om = new ObjectMapper();
	
	public void showOptions(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession sess = req.getSession();
		
		String button1 = "button for viewing reimbursements";
		
		String button2 = "button for submitting reimbursements";
		
		String button3 = "button for approving requests";
		
		if(sess.getAttribute("User-Role") == null) {
			throw new UnauthenticatedException();
		} 
		
		else if(sess.getAttribute("User-Role").equals("Finance Manager")) {
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(button3));
		}
		
		else if(sess.getAttribute("User-Role").equals("User")) {
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(button1));
		res.getWriter().write(om.writeValueAsString(button2));
		}
	}
}

package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.UnauthenticatedException;
import com.revature.exceptions.UnauthorizedException;
import com.revature.models.Reimbursements;
import com.revature.models.User;
import com.revature.repositories.ReimbursementDAO;

public class SubmitReimbursementController {

	private ObjectMapper om = new ObjectMapper();
	
	public void submitRequest(HttpServletRequest req, HttpServletResponse res, User u) throws IOException {
		
		ReimbursementDAO RDAO = new ReimbursementDAO();
		
		HttpSession sess = req.getSession();
		
		/*
		if(sess.getAttribute("User-Role") == null) {
			throw new UnauthenticatedException();
		} else if(sess.getAttribute("User-Role").equals("Finance Manager")) {
			throw new UnauthorizedException();
		}
		
		*/
		
		
		
		Reimbursements reimb = om.readValue(req.getInputStream(), Reimbursements.class);
		
		RDAO.addReimbursement(reimb);
		
		System.out.println(u.user_reimb_list.add(reimb));
		
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(reimb));
		
	}
}

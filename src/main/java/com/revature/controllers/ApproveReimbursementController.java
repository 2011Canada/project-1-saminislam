package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.UnauthenticatedException;
import com.revature.exceptions.UnauthorizedException;
import com.revature.models.Reimbursements;
import com.revature.models.User;
import com.revature.repositories.LoginDAO;

public class ApproveReimbursementController {

	private ObjectMapper om = new ObjectMapper();
	
	public void approveRequests(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		LoginDAO LDAO = new LoginDAO();
		
		List<User> allusers = LDAO.findall();
		
		HttpSession sess = req.getSession();
		
		/*
		if(sess.getAttribute("User-Role") == null) {
			throw new UnauthenticatedException();
		} else if(!sess.getAttribute("User-Role").equals("Finance Manager")) {
			throw new UnauthorizedException();
		}
		*/
		
		res.getWriter().write(om.writeValueAsString(allusers));
		
		
		/*
		for (int i = 0; i < allusers.size() - 1 ; i ++) {
			for (Reimbursements reimb : allusers.get(i).user_reimb_list) {
				res.getWriter().write(om.writeValueAsString(reimb.get_reimb_id()));
				res.getWriter().write("\n");
				res.getWriter().write(om.writeValueAsString(reimb.get_author()));
				res.getWriter().write("\n");
				res.getWriter().write(om.writeValueAsString(reimb.get_amount()));
				res.getWriter().write("\n");
				res.getWriter().write(om.writeValueAsString(reimb.get_date_submitted()));
				res.getWriter().write("\n");
				res.getWriter().write(om.writeValueAsString(reimb.get_date_resolved()));
				res.getWriter().write("\n");
				res.getWriter().write(om.writeValueAsString(reimb.get_reimb_type()));
				res.getWriter().write("\n");
				res.getWriter().write(om.writeValueAsString(reimb.get_reimb_description()));
				res.getWriter().write("\n");
				res.getWriter().write(om.writeValueAsString(reimb.get_receipt()));
				res.getWriter().write("\n");
				res.getWriter().write(om.writeValueAsString(reimb.get_reimb_status()));
				}
			}
		*/
		res.setStatus(200);
		}
	}

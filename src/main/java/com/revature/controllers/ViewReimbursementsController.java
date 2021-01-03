package com.revature.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursements;
import com.revature.models.User;


public class ViewReimbursementsController {

	private ObjectMapper om = new ObjectMapper();
	
	public void ViewReimbursement(HttpServletRequest req, HttpServletResponse res, User u) throws IOException {
	
		List<Reimbursements> allReimb = new ArrayList<>();
		
		for (Reimbursements reimb : u.user_reimb_list) { 
			/*
			res.getWriter().write(om.writeValueAsString(reimb.get_reimb_id()));
			res.getWriter().write(om.writeValueAsString(reimb.get_author()));
			res.getWriter().write(om.writeValueAsString(reimb.get_amount()));
			res.getWriter().write(om.writeValueAsString(reimb.get_date_submitted()));
			res.getWriter().write(om.writeValueAsString(reimb.get_date_resolved()));
			res.getWriter().write(om.writeValueAsString(reimb.get_reimb_type()));
			res.getWriter().write(om.writeValueAsString(reimb.get_reimb_description()));
			res.getWriter().write(om.writeValueAsString(reimb.get_receipt()));
			res.getWriter().write(om.writeValueAsString(reimb.get_reimb_status()));
			*/
			
			allReimb.add(reimb);
		}
		res.getWriter().write(om.writeValueAsString(allReimb));
		
	}
	

}

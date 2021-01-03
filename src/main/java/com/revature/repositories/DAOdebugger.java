package com.revature.repositories;





import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.models.Reimbursements;
import com.revature.models.User;
public class DAOdebugger {

	public DAOdebugger() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	
		
		/*
		LoginDAO LDAO = new LoginDAO();
		List<User> allUsers = new ArrayList<User>();
		allUsers = LDAO.findall();
		
		
		for (User u : allUsers) {
			System.out.println(u.getUsername());
			System.out.println(u.user_reimb_list.get(0).get_reimb_id());
		}
		
		*/
		
		/*
		LoginDAO LDAO = new LoginDAO();	
		
		ReimbursementDAO RDAO = new ReimbursementDAO();
		
		User u = LDAO.DAOuserLogin("saminislam_", "password1");
		
		RDAO.User_ReimbursementDAO(u);
		System.out.println(u.getEmail());
		System.out.println(u.getFirstName());
		System.out.println(u.getLastName());
		System.out.println(u.getUserId());
		System.out.println(u.get_isFinanceManager());
		System.out.println(u.user_reimb_list.get(0).get_reimb_id());
		System.out.println("\n");
		
		*/
		/*
		ReimbursementDAO RDAO = new ReimbursementDAO();
		RDAO.User_ReimbursementDAO(u);
		
		
		System.out.println("XXXXX");
		
		
		
		for (Reimbursements r : u.user_reimb_list) {
			System.out.println("XXXXXX");
			System.out.println("reimbursement id: " + r.get_reimb_id());
			System.out.println("Date resolved: " + r.get_date_resolved());
			System.out.println("Resolver " + r.get_resolver());
			System.out.println("Date resolved: " + r.get_reimb_id());
			System.out.println("XXXXXX");
		}
		
		*/
		
		/*
		RDAO.updateReimbursementWithDateAndResolver(u.user_reimb_list.get(2));
		u.approvingRequests("Approved", u.user_reimb_list.get(2));
		
		System.out.println("date resolved = " + u.user_reimb_list.get(2).get_date_resolved());
		
		for (Reimbursements r : u.user_reimb_list) {
			System.out.println("XXXXXX");
			System.out.println("reimbursement id: " + r.get_reimb_id());
			System.out.println("Date resolved: " + r.get_date_resolved());
			System.out.println("Resolver " + r.get_resolver());
			System.out.println("Date resolved: " + r.get_reimb_id());
			System.out.println("XXXXXX");
		}
		
		*/
		
		/*
		Reimbursements reimb1 = new Reimbursements();
		
		reimb1.set_amount(300.04);
		reimb1.set_author(1);
		Date todaysDate = new Date();
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    String DateString = df.format(todaysDate);
		reimb1.set_date_submitted(DateString);
		reimb1.set_reimb_status("Pending");
		reimb1.set_reimb_type("Lodging");
		RDAO.addReimbursement(reimb1);
		
	*/
	}
}

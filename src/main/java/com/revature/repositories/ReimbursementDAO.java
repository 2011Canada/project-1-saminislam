package com.revature.repositories;

import java.text.SimpleDateFormat;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.Reimbursements;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;




public class ReimbursementDAO {

	ConnectionFactory cf = ConnectionFactory.getConnectionFactory();

	
	public void User_ReimbursementDAO(User u) {
		
		Connection conn = this.cf.getConnection();
		
		try {
			
			String sql = "select * from samin_project1.\"ers_reimbursement\" where \"reimb_author\" = '" + u.getUserId() + "' order by \"reimb_id\";";

			
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			
			while (res.next()) {
				Reimbursements reimb = new Reimbursements();
				reimb.set_reimb_Id(res.getInt("reimb_id"));
				reimb.set_amount(res.getDouble("reimb_amount"));
				reimb.set_date_submitted(res.getString("reimb_submitted"));
				reimb.set_date_resolved(res.getString("reimb_resolved"));
				reimb.set_reimb_description(res.getString("reimb_description"));
				reimb.set_receipt(res.getBytes("reimb_receipt"));
				reimb.set_author(res.getInt("reimb_author"));
				reimb.set_resolver(res.getInt("reimb_resolver"));
				reimb.set_reimb_status(res.getString("reimb_status"));
				reimb.set_reimb_type(res.getString("reimb_type"));
				u.user_reimb_list.add(reimb);

			} 
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			}
		
		}
	
	public void addReimbursement(Reimbursements reimb) {
		
		Connection conn = cf.getConnection();
		
		try {
			
			String sql = "insert into samin_project1.\"ers_reimbursement\" (\"reimb_amount\",\"reimb_submitted\",\"reimb_description\",\n" + 
					"\"reimb_receipt\",\"reimb_author\",\"reimb_status\",\n" + 
					"\"reimb_type\")\n" + 
					"values (?, ?, ?, ?, ?, ?, ?);\n";
			
			PreparedStatement addReimbursement = conn.prepareStatement(sql);
			
			addReimbursement.setDouble(1, reimb.get_amount());
			addReimbursement.setString(2, reimb.get_date_submitted());
			addReimbursement.setString(3, reimb.get_reimb_description());
			addReimbursement.setBytes(4, reimb.get_receipt());
			addReimbursement.setInt(5, reimb.get_author());
			addReimbursement.setString(6, reimb.get_reimb_status());
			addReimbursement.setString(7, reimb.get_reimb_type());
			addReimbursement.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void updateReimbursementWithDateAndResolver(Reimbursements reimb) {
		
		Connection conn = cf.getConnection();
		
		try {
			
			String sql ="update samin_project1.\"ers_reimbursement\"\n" + 
					"set \"reimb_resolver\" = ? , \"reimb_resolved\" = ?\n" + 
					"where \"reimb_id\" = ?;\n";
			
			PreparedStatement updateReimbursement = conn.prepareStatement(sql);
			
			updateReimbursement.setInt(1, reimb.get_resolver());
			System.out.println("DAO = " + reimb.get_resolver());
			updateReimbursement.setString(2, reimb.get_date_resolved());
			System.out.println("DAO = " + reimb.get_date_resolved());
			updateReimbursement.setInt(3, reimb.get_reimb_id());
			System.out.println("DAO = " + reimb.get_reimb_id());
			updateReimbursement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		
	}
	public void updateReimbursementResolver(Reimbursements reimb) {
		
		Connection conn = cf.getConnection();
		
		try {
			
			String sql = "update samin_project1.ers_reimbursement set reimb_resolver = (?) where reimb_id = (?) ;";
			
			PreparedStatement updateReimbursement = conn.prepareStatement(sql);
			
			updateReimbursement.setInt(1, reimb.get_resolver());
			System.out.println("DAO = " + reimb.get_resolver());
			updateReimbursement.setInt(2, reimb.get_reimb_id());
			System.out.println("DAO = " + reimb.get_reimb_id());
			updateReimbursement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		
	}
}

package com.revature.repositories;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursements;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;



public class LoginDAO {

	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	static int ers_user_role_id;
	
	
	public User DAOuserLogin(String username, String password) {
		
		//int ers_user_role_id;
		
		Connection conn = this.cf.getConnection();
		
		User u;
		
		u = new User();
		

		
		try {		
			String sql = "select * from samin_project1.\"ers_users\" where \"ers_users_username\" = '" + username + "' and \"ers_users_password\" = '" + password + "';\n";
			
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
				
			while (res.next()) {
								
				u = new User();
				u.setUserId(res.getInt("ers_users_id"));
				u.setUsername(res.getString("ers_users_username"));
				u.setPassword(res.getString("ers_users_password")); 
				u.setFirstName(res.getString("user_first_name"));
				u.setLastName(res.getString("user_last_name"));
				u.setEmail(res.getString("user_email"));
				ers_user_role_id = res.getInt("user_role_id");

			
				try {

					String sql1 = "select \"user_role\" from samin_project1.\"ers_user_roles\" where \"ers_user_role_id\" = '" + ers_user_role_id + "';";
					
					Statement s1 = conn.createStatement();
					ResultSet res1 = s1.executeQuery(sql1);
					
					while (res1.next()) {
						if (res1.getString("user_role") .equals("Finance Manager")) {
							u.set_isFinanceManager(true);
						}
						else {
							u.set_isFinanceManager(false);
						}
				}
				return u;
			} catch (SQLException ex) {
				System.out.println("BAD INPUT");
				ex.printStackTrace();
			}
		}
	}
		 catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
		}
	
	public List <User> findall() {
		Connection conn = this.cf.getConnection();
		int ers_user_role_id;
		User u;
		u = new User();
		try {		
			String sql = "select * from samin_project1.\"ers_users\" order by \"ers_users_id\" ;\n";
			
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			
			List<User> allUsers = new ArrayList<User>();
			while (res.next()) {
				u = new User();				
				u.setUserId(res.getInt("ers_users_id"));
				u.setUsername(res.getString("ers_users_username"));
				u.setPassword(res.getString("ers_users_password")); 
				u.setFirstName(res.getString("user_first_name"));
				u.setLastName(res.getString("user_last_name"));
				u.setEmail(res.getString("user_email"));
				ers_user_role_id = res.getInt("user_role_id");
				
				try {

					String sql1 = "select \"user_role\" from samin_project1.\"ers_user_roles\" where \"ers_user_role_id\" = '" + ers_user_role_id + "';";
					
					Statement s1 = conn.createStatement();
					ResultSet res1 = s1.executeQuery(sql1);
					
					while (res1.next()) {
						if (res1.getString("user_role") .equals("Finance Manager")) {
							u.set_isFinanceManager(true);
							
							ReimbursementDAO RDAO = new ReimbursementDAO();
							RDAO.User_ReimbursementDAO(u);
							allUsers.add(u);
							
							
						}
						else {
							u.set_isFinanceManager(false);
							ReimbursementDAO RDAO = new ReimbursementDAO();
							RDAO.User_ReimbursementDAO(u);
							allUsers.add(u);
						}
				}
				
			} catch (SQLException ex) {
				System.out.println("BAD INPUT");
				ex.printStackTrace();
				}
			}
			
			return allUsers;
		} catch (SQLException ex) {
			System.out.println("BAD INPUT");
			ex.printStackTrace();
			}
		return null;
		}
	}


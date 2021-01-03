package com.project1.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.ApproveReimbursementController;
import com.revature.controllers.AuthController;
import com.revature.controllers.ErrorController;
import com.revature.controllers.OptionsController;
import com.revature.controllers.SubmitReimbursementController;
import com.revature.controllers.UserController;
import com.revature.controllers.ViewReimbursementsController;
import com.revature.models.User;
import com.revature.repositories.LoginDAO;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	
	static User u;

	static List<User> listOfUsers;
	
	private SubmitReimbursementController subreimbController = new SubmitReimbursementController();
	
	private AuthController authController = new AuthController();
	
	private UserController userController = new UserController();
	
	private ErrorController errorController = new ErrorController();
	
	private OptionsController optionsController = new OptionsController();
	
	private ApproveReimbursementController approveReimbursementController = new ApproveReimbursementController();
	
	private ViewReimbursementsController viewReimbursementsController = new ViewReimbursementsController(); 
       
	protected void directControlRouter(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		LoginDAO LDAO = new LoginDAO();
		
		listOfUsers = LDAO.findall();
		
		// will be our front controller
		
		//be our front controller
				String URI = req.getRequestURI().substring(req.getContextPath().length(), 
															req.getRequestURI().length());
			//	User u = new User();
				System.out.println(URI);
				switch (URI) {
					case "/login":{
						switch (req.getMethod()) {
							case "GET":{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
							case "POST":{
								
								u = authController.userLogin(req, res);
								break;
							}
							case "PUT":{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
							case "DELETE":{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
							default:{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
						
						}
						break;
					}
					case "/users": {
						switch (req.getMethod()) {
							case "GET":{
								userController.findAllUsers(req, res);
								break;
							}
							case "POST":{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
							case "PUT":{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
							case "DELETE":{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
							default:{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
						}
						break;
					}
					

					
					case "/options":{
						switch (req.getMethod()) {
							case "GET":{
								optionsController.showOptions(req,res);
								break;
							}
							case "POST":{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
							case "PUT":{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
							case "DELETE":{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
							default:{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
						
						}
						break;
					}
					case "/view_reimbursements":{
						switch (req.getMethod()) {
							case "GET":{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
							case "POST":{
								System.out.println(u.getUsername());
								viewReimbursementsController.ViewReimbursement(req, res, u);
								break;
							}
							case "PUT":{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
							case "DELETE":{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
							default:{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
						
						}
						break;
					}
					case "/submit_reimbursements":{
						switch (req.getMethod()) {
							case "GET":{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
							case "POST":{
								System.out.println(u.getUsername());
								subreimbController.submitRequest(req, res, u);
								break;
							}
							case "PUT":{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
							case "DELETE":{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
							default:{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
						
						}
						break;
					}
					
					case "/approve_reimbursements":{
						switch (req.getMethod()) {
							case "GET":{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
							case "POST":{
								approveReimbursementController.approveRequests(req, res);
								break;
							}
							case "PUT":{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
							case "DELETE":{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
							default:{
								res.setStatus(400);
								res.getWriter().write("Method Not Supported");
								break;
							}
						
						}
						break;
					}
					
				}
				
	}
	
	protected void directControl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//to handle all internal errors/exceptions
		try {
			directControlRouter(request, response);
		}catch (Throwable t) {
			errorController.handle(request, response, t);//go to the error controller
		}
	}
	

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		directControl(request,response);
	}


	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		directControl(request,response);
	}


	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		directControl(request,response);
	}


	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		directControl(request,response);
	}

}

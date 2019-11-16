package com.login;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.handler.DatabaseHandler;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet(description = "Checks the login details entered", urlPatterns = { "/LoginCheck" })
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("UserName");
		String password = request.getParameter("Password");
		if(userName.equals("Bivor") && password.contentEquals("Welcome1")) {
			response.sendRedirect("SuccessfulLogin.jsp");
		}else {
			response.sendRedirect("LoginError.jsp");
		}
		MongoCollection<Document> collection = DatabaseHandler.getInstance().getCollection("EMPLOYEE");
		System.out.println(collection);
		
//		doGet(request, response);
	}

}

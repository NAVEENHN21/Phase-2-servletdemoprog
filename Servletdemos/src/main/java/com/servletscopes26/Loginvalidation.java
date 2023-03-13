package com.servletscopes26;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginController")
public class Loginvalidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Loginvalidation() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String username=request.getParameter("username");
    	String password=request.getParameter("Password");
    	
    	RequestDispatcher rd=null;
    	if(username.equalsIgnoreCase("naveen") && password.equals("qwerty")){
    		rd=request.getRequestDispatcher("SuccessServlet");
    		rd.forward(request, response);
    	}else {
    		rd=request.getRequestDispatcher("login.html");
    		PrintWriter out=response.getWriter();
    		rd.include(request, response);
    		out.print("<center><span style='color:red'>Invalid Credentials!!</span></center>");
    	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

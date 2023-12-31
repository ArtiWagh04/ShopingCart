/*
package cn.TechTutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.TechTutorial.dao.UserDao;
import cn.TechTutorial.connection.DbCon;
import cn.TechTutorial.model.User;

/**
 * Servlet implementation class LoginServlet
 * @param <UserDao>
 */
/*
@WebServlet("/user-Login")
public class LoginServlet<UserDao> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out=response.getWriter()){
			String email=request.getParameter("login-email");
			String password=request.getParameter("login-password");
			
			try {
			UserDao udao = new UserDao(DbCon.getConnetion());
			User user = udao.userLogin(email, password);
			if (user != null) {
				out.print("user login");
			} else {
				out.println("user login failed");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
			
		
	}

}
}

*/


package cn.TechTutorial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.TechTutorial.connection.DbCon;
import cn.TechTutorial.dao.*;
import cn.TechTutorial.model.*;

@WebServlet("/user-Login")
public class LoginServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");

			UserDao udao = new UserDao(DbCon.getConnetion());
			User user = udao.userLogin(email, password);
			if (user != null) {
				request.getSession().setAttribute("auth", user);
//				System.out.print("user logged in");
				response.sendRedirect("index.jsp");
			} else {
				out.println("there is no user");
			}

		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		} 

	}
}
	


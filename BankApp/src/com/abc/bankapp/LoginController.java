package com.abc.bankapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginController extends HttpServlet 
{
	public void service(HttpServletRequest  x,HttpServletResponse y)
	{
		try
		{
			String cusid=x.getParameter("cusid");
			int id=Integer.parseInt(cusid); //since id in database is number
			String password=x.getParameter("password");
			Model m=new Model();
			m.setId(id);
			m.setPassword(password);
			
			boolean b=m.login();
			if(b==true)
			{
				HttpSession hs=x.getSession(true);
				hs.setAttribute("NAME", m.getName());
				hs.setAttribute("ACCNO", m.getAccno());
				y.sendRedirect("/BankApp/LoginSuccess.jsp");
			}
			else
			{
				y.sendRedirect("/BankApp/LoginFailure.jsp");
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
	
	


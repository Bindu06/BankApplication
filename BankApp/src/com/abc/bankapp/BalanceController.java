package com.abc.bankapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class BalanceController extends HttpServlet
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		try
		{
			HttpSession hs=x.getSession();
			int accn0=(int) hs.getAttribute("ACCNO");
			Model m=new Model();
			m.setAccno(accn0);
			boolean b=m.checkBalance();
			if(b==true)
			{
				hs=x.getSession();
				hs.setAttribute("BALANCE", m.getBalance());
				y.sendRedirect("/BankApp/BalanceSuccess.jsp");
				}
			else
			{
				y.sendRedirect("/BankApp/BalanceFailure.jsp");
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	



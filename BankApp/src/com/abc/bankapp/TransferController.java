package com.abc.bankapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class TransferController extends HttpServlet 
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		try
		{
			int tpaccno=Integer.parseInt(x.getParameter("tpaccno"));
			int transamt=Integer.parseInt(x.getParameter("transamt"));
			HttpSession hs=x.getSession();
			int accno=(int) hs.getAttribute("ACCNO");
			Model m=new Model();
			m.setTpaccno(tpaccno);
			m.setTransamt(transamt);
			m.setAccno(accno);
			boolean b=m.transfer();
				if(b==true)
				{
					y.sendRedirect("/BankApp/TransferSuccess.jsp");
				}
				else
				{
					y.sendRedirect("/BankApp/TransferFailure.jsp");
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

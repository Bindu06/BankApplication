package com.abc.bankapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ChangePasswordController extends HttpServlet 
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		try
		{
			String op=x.getParameter("op");
			String np=x.getParameter("np");
			String cnp=x.getParameter("cnp");
			
			if(np.equals(cnp)==true)
			{
				Model m=new Model();
				m.setOp(op);
				m.setNp(np);
				boolean b=m.changePassword();
				if(b==true)
					{
						y.sendRedirect("/BankApp/PasswordChangeSuccess.jsp");
					}
					else
					{
						y.sendRedirect("/BankApp/PasswordChangeFailure.jsp");
					}
			}
			else
			{
				y.sendRedirect("/BankApp/PasswordError.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

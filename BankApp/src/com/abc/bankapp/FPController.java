package com.abc.bankapp;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FPController extends HttpServlet 
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		try
		{
			String toEmailID=x.getParameter("toEmail");
			final String fromEmail="jbindu2014@gmail.com";
			final String password="naren@jan12";
			//final String toEmail=toEmailID;
			HttpSession hs=x.getSession();
			hs.setAttribute("toEmail",toEmailID);
			
			Properties prop=new Properties();     //util package
			prop.put("mail.smtp.host", "smtp.gmail.com");  //ipaddr
			prop.put("mail.smtp.port", 587);            //port no
			prop.put("mail.smtp.auth", "true");      //Authenticate
			prop.put("mail.smtp.starttls.enable", "true");  //Encrypt
			
			Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator()    //javax. mail
			{
				protected PasswordAuthentication getPasswordAuthentication()   //javax.mail
				{
					//sender's mail id and pwd is encapsulated inside "SendersCredentials.java"
					return new PasswordAuthentication(fromEmail, password);
				}
			});
			
			MimeMessage mesg = new MimeMessage(session);   //javax.mail.net
			mesg.setFrom(new InternetAddress(fromEmail));
			mesg.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmailID));  //javax.mail
			mesg.setSubject("DO NOT REPLY TO THIS EMAIL");  
			mesg.setText("http://localhost:9090/BankApp/NewPassword.jsp");  
			
			Transport.send(mesg);    //javax.mail (Sending Mail)
			y.sendRedirect("/BankApp/SuccessMail.jsp");
			}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		
	}
	
}

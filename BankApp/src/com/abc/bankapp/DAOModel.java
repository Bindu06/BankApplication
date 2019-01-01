package com.abc.bankapp;

import java.sql.Connection;
import java.sql.DriverManager;

import oracle.jdbc.driver.OracleDriver;

public class DAOModel 
{
	private String url="jdbc:oracle:thin:@//localhost:1521/XE";
	private String un="system";
	private String pw="system";
	Connection con=null;
	
	Connection getConnection()
	{
	try
{
		DriverManager.registerDriver(new OracleDriver()); //load the driver
		con=DriverManager.getConnection(url,un,pw);
		return con;   //establish connection
}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return null;
		}
}

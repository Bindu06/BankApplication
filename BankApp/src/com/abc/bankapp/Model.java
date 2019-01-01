package com.abc.bankapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model 
{
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet res=null;
	
	
	private String name=null;
	private String password=null;
	private int id=0;
	private int accno=0;
	
	private int tpaccno=0;
	private int transamt=0;
	private int balance=0;
	
	private String op=null;
	private String np=null;
	
	private String newpassword=null;
	private String toEmail=null;
	
	public Connection getCon() {
		return con;
	}
	public PreparedStatement getPstmt() {
		return pstmt;
	}
	public ResultSet getRes() {
		return res;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public int getId() {
		return id;
	}
	public int getAccno() {
		return accno;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}
	public void setRes(ResultSet res) {
		this.res = res;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	Model()
	{
		try
		{
			DAOModel d=new DAOModel();
			con=d.getConnection();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	boolean login()
	{
		try {
			pstmt=con.prepareStatement("select * from BANK1 where CUSTOMERID=? and PASSWORD=?  ");
			pstmt.setInt(1, id);
			pstmt.setString(2, password);
			res=pstmt.executeQuery();
			
			while(res.next()==true)
			{
				name=res.getString(5);
				accno=res.getInt(1);
				return true;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
		}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getNp() {
		return np;
	}
	public void setNp(String np) {
		this.np = np;
	}
	
	boolean changePassword()
	{
		try
		{
			pstmt=con.prepareStatement("update BANK1 set PASSWORD=? where PASSWORD=?");
			pstmt.setString(1, np);
			pstmt.setString(2, op);
			pstmt.executeUpdate();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
	}
		return false;
}
	public int getTpaccno() {
		return tpaccno;
	}
	public void setTpaccno(int tpaccno) {
		this.tpaccno = tpaccno;
	}
	public int getTransamt() {
		return transamt;
	}
	public void setTransamt(int transamt) {
		this.transamt = transamt;
	}
	
	boolean transfer()
	{
		try
		{
			pstmt=con.prepareStatement("update BANK1 set BALANCE = BALANCE - ? where ACCNO = ?");
			pstmt.setInt(1, transamt);
			pstmt.setInt(2, accno);
			pstmt.executeUpdate();
			
			pstmt=con.prepareStatement("update BANK1 set BALANCE = BALANCE + ? where ACCNO = ?");
			pstmt.setInt(1, transamt);
			pstmt.setInt(2, tpaccno);
			pstmt.executeUpdate();
			return true;
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public int getBalance() {
		return balance; 
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	boolean checkBalance()
	{
		try
		{
			pstmt=con.prepareStatement("select * from BANK1 where ACCNO=? ");
			pstmt.setInt(1, accno);
			res=pstmt.executeQuery();
			while(res.next()==true)
			{
				balance=res.getInt(9);
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	
	boolean forgotPassword()
	{
		try
		{
			pstmt=con.prepareStatement("update BANK1 set PASSWORD = ? where EMAIL = ?");
			pstmt.setString(1, newpassword);
			pstmt.setString(2, toEmail);
			pstmt.executeQuery();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
	
	
	

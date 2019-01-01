<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%out.println("Hello "  +session.getAttribute("NAME")+ " ,You have logged in Succeesfully") ;%>
	<table>
		<tr>
			<td><a href="Transfer.jsp">ThirdPartyTransfer</a></td>
		</tr>
		<tr>
			<td><a href="ChangePassword.jsp">ChangePassword</a></td>
		</tr>
		<tr>
			<td><a href="Loan.jsp">Apply Loan</a></td>
		</tr>
		<tr>
			<td><a href="BalanceController">Balance Check</a></td>
		</tr>
		<tr>
			<td><a href="">MiniStatement</a></td>
		</tr>
		<tr>
			<td><a href="">Logout</a></td>
		</tr>
	</table>
</body>
</html>
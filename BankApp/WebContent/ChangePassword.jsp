<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ChangePasswordController">
		<table>
			<tr>
				<td>Old Password</td>
				<td><input type="password" name="op" Required /></td>
			</tr>

			<tr>
				<td>New Password</td>
				<td><input type="password" name="np" Required /></td>
			</tr>

			<tr>
				<td>Confirm New Password</td>
				<td><input type="password" name="cnp" Required /></td>
			</tr>

			<tr>
				<td><input type="submit" value="CHANGE" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
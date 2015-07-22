<%@ page import="java.sql.*,javax.sql.*,dao.DbUtil" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

Connection conn=DbUtil.getConnection();

String name=request.getParameter("name");
String password=request.getParameter("password");
String newpwd=request.getParameter("newpwd");
PreparedStatement stmt=conn.prepareStatement("update customer set password=? where name=? and password=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
stmt.setString(1,newpwd);
stmt.setString(2,name);
stmt.setString(3,password);
ResultSet rs=stmt.executeQuery();
stmt.close();
conn.close();

response.sendRedirect("reset_success.jsp");
%>
</html>
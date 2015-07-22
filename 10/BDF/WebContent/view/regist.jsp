<%@ page
	import="java.sql.*,javax.sql.*,dao.DbUtil,java.text.*"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	

	<%
	
	request.setCharacterEncoding("UTF-8") ;
	Connection conn = DbUtil.getConnection();
	PreparedStatement pstat = null;
	ResultSet rs = null;
	String sql = null;
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");	
	sql = "insert into customer(name,password,email,point,phone,adress1,adress2,payid) values(?,?,?,?,?,?,?,?)";
	pstat = conn.prepareStatement(sql);
	pstat.setString(1, name);
	pstat.setString(2, password);
	pstat.setString(3, email);
	pstat.setInt(4, 20);
	pstat.setString(5, phone);
	pstat.setString(6, "");
	pstat.setString(7, "");
    pstat.setString(8,"");
	pstat.executeUpdate();
	pstat.close();
	conn.close();	
	response.sendRedirect("regsuccess.jsp");

	%>
</body>
</html>
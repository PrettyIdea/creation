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
	String name = (String) request.getSession().getAttribute(
			"name");
	
	
	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	java.util.Date currentTime = new java.util.Date();//得到当前系统时间

	String str_date1 = formatter.format(currentTime); //将日期时间格式化 
	String str_date2 = currentTime.toString(); //将Date型日期时间转换成字符串形

	//String OrderTime = request.getParameter("str_date1");
	//out.print(str_date1);
%>
	
	
	
	
	<%
	request.setCharacterEncoding("UTF-8") ;
	Connection conn = DbUtil.getConnection();
	PreparedStatement pstat = null;
	ResultSet rs = null;
	String sql = null;
	String adress = request.getParameter("adress");
	String resturant = request.getParameter("resturant");
	String item = request.getParameter("item");
	String price = request.getParameter("price");
	String phone = request.getParameter("phone");
	String tips = request.getParameter("tips");
	sql = "insert into `order`(adress,resturant,item,price,phone,tips,reciever,deliver,odtime) values(?,?,?,?,?,?,?,?,?)";
	pstat = conn.prepareStatement(sql);
	pstat.setString(1, adress);
	pstat.setString(2, resturant);
	pstat.setString(3, item);
	pstat.setString(4, price);
	pstat.setString(5, phone);
	pstat.setString(6, tips);
	pstat.setString(7, name);
	pstat.setString(8, "");
	pstat.setString(9, str_date1);
	pstat.executeUpdate();
	pstat.close();
	//关闭数据库连接 
	conn.close();
	//重定向到购物车页面  
	response.sendRedirect("seerequest.jsp");

	%>
</body>
</html>
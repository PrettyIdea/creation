<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功</title>
</head>
<body>
 <div class="container-fluid" style="background-color:rgb(255,210,120);  ">
	<%@include file="header2.jsp" %>
	<h1 class="text-center" text-color="rgb(210,40,0);">恭喜你，注册成功啦</h1>
	<div class="row">
	<div class="col-md-3"><img alt="Bootstrap Image Preview" src="${img }/introduction1.jpg" class="img-thumbnail"></div>
	<div class="col-md-3"><img alt="Bootstrap Image Preview" src="${img }/introduction2.jpg" class="img-thumbnail"></div>
	<div class="col-md-3"><img alt="Bootstrap Image Preview" src="${img }/introduction3.jpg" class="img-thumbnail"></div>
	<div class="col-md-3"><img alt="Bootstrap Image Preview" src="${img }/introduction4.jpg" class="img-thumbnail"></div>
	</div>
	<div class="row">
	<div class="col-md-5"></div>
	<div class="col-md-2"><a href="index.jsp"><img alt="Bootstrap Image Preview" src="${img }/logoback.jpg" class="img-thumbnail"></a></div>
	<div class="col-md-5"></div>
	
	</div>
	<%@include file="footer.jsp"%> 
</div>	
</body>
</html>
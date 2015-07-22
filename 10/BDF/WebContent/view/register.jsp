<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
	<title>带饭网</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	   <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	
	
	<link rel="stylesheet" type="text/css" href="${css }/imtshop.css">
	
	<script src="${js }/jquery-1.10.2.js"></script>
	
	
	
    <link href="css/bootstrap.min.css" rel="stylesheet">
   
	
</head>
<body>
   <div class="container-fluid" style="background-color:rgb(255,210,120);  ">
   <%@include file="header2.jsp" %>
	
	<div class="row">
	<div class="col-md-3"></div>
		<div class="col-md-6">
			<h3 class="text-center">
				用户注册
			</h3>
			<form role="form" action="regist.jsp" method="post">
			<div class="form-group">
					 
					<label for="text">
						用户名：
					</label>
					<input type="text" name="name" class="form-control" id="text">
				</div>
				<div class="form-group">
					 
					<label for="pwd">
						密码：
					</label>
					<input type="password"  name="password" class="form-control" id="rpwd">
				</div>
				<div class="form-group">
				<label for="pwd">
						确认密码：
					</label>
					<input type="password" name="rpassword" class="form-control" id="rpwd">
				</div>
				
				<div class="form-group"> 
					<label for="Email1">
						邮箱地址：
					</label>
					<input type="email" name="email" class="form-control" id="Email1">
				</div>
				<div class="form-group"> 
					<label for="phone">
						电话号码：：
					</label>
					<input type="text" name="phone" class="form-control" id="phone">
				</div>
				<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<button type="submit" class="btn btn-default" align="center">
					提交：
				</button>
				<button type="reset" class="btn btn-default" align="center">
					重置：
				</button>
			</form>
		</div>
		<div class="col-md-3"></div>
	</div>
	<div><br><br></div>
	<%@include file="footer.jsp"%> 
</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>
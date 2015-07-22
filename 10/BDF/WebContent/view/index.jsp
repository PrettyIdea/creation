<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
	<title>送饭网</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	   <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	
	
	<link rel="stylesheet" type="text/css" href="${css }/imtshop.css">
	
	<script src="${js }/jquery-1.10.2.js"></script>
	
	<script type="text/javascript">
		$(function(){
			//设置左侧高度和main相同
			var mainHeight = $('#main').height();
			$('#indexLeftColumn').height(mainHeight);
			
			$("#nav .tit").slide({
				type:"menu",
				titCell:".mod_cate",
				targetCell:".mod_subcate",
				delayTime:0,
				triggerTime:10,
				defaultPlay:false,
				returnDefault:true
			});
		});
	</script>
	
    <link href="css/bootstrap.min.css" rel="stylesheet">
   
	
</head>
<body>
 <div class="container-fluid">
	<%@include file="header2.jsp" %>
	<a  href="request.html">  我要带饭</a>	<%@include file="footer.jsp"%> 
	</div>
	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>
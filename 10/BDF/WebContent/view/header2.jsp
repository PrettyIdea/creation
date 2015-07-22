<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="${js }/jquery-1.10.2.js"></script>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>带饭网</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
<link rel="stylesheet" type="text/css" href="${css }/imtshop.css">
    <link href="${css }/bootstrap.min.css" rel="stylesheet">
    <link href="${css }/style.css" rel="stylesheet">
    <link rel="stylesheet" href="${css }/ui-dialog.css">
<title>Insert title here</title>
</head>
<body>

<script src="${js }/dialog-min.js"></script>
<script type="text/javascript">
	function showLogin(){
		var d = dialog({
		    title: '请登录',
		    content: $('#login_dialog'),
		    button: [
		             {
		                 value: '提交',
		                 callback: function () {
		                     var userName = $(':input[name=userName]').val().trim();
		                     var password = $(':input[name=password]').val().trim();
		                     if(userName && password) {
		                    	 var params = $('#loginInfo').serialize();
		                    	 $.post('${ctx}/login?'+params, function(json){
		                    		 if(json){
		                    			 location.reload();//登陆成功，刷新页面
		                    		 } else {
				                    	 alert('用户名或密码错误');
		                    		 }
		                    	 },'json');
		                     } else {
		                    	 alert('用户名和密码不能为空');
		                     }
		                     return false;
		                 },
		                 autofocus: true
		             },
		             {
		                 value: '重置',
		                 callback: function () {
		                	 $(':input[name=userName]').val('');
		                     $(':input[name=password]').val('');
		                     return false;
		                 }
		             },
		             {
		                 value: '关闭'
		             }
		             ]
		});
		d.showModal();
	}
</script>
 
<div class="container-fluid">
  <div id="widgetBar"  role="navigation" style="background-color:rgb(195,180,150); height:70px; "  class="navbar navbar-default ">

     <div class="container">
   
    
     <div class="navbar-header clearfix">
      <span class="icon-bar">^_^感谢您使用带饭网。^_^ </span><span class="split"></span>
      <span class="icon-bar">当前在线人数：${counter }  </span><span class="split"></span>
                    
                    <c:if test="${not empty name}">
                        <span class="icon-bar">
                            欢迎:${name }
                       </span><span class="split"></span>
                        <span class="icon-bar">
                            <a href='${ctx }/logout'>退出登陆</a>
                        </span>
                    </c:if>
                    <c:if test="${empty name}">
                        <span class="icon-bar">
                            <a href="javascript:showLogin();">请登陆</a>
                        </span><span class="split"></span>
                        <span class="icon-bar">
                            <a href='register.jsp'>还没有账号？</a>
                        </span>
                      </c:if>       
                  
                                   
                </div>

  </div>
 
</div>
</div>


<!-- 登陆对话框 -->
<div id="login_dialog">
	<span style="color: red;">${not empty loginError ? loginError : ''}</span>
	<form action="${ctx }/login" method="post" name="loginInfo" id="loginInfo">
		<table style="margin: auto;">
			<tr>
				<td></td>
				<td align="center">用户登录</td>
			</tr>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="userName" id="uname" /></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="password" id="upwd" /></td>
			</tr>
			<tr>
				<td>记住一周:</td>
				<td><input type="checkbox" name="remenberMe" id="remenberMe" /></td>
			</tr>
		</table>
	</form>
	<p align="right">
		<a href='findpassword.jsp'>忘记密码了？^ 。^</a>
	</p>
</div>


    <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<img alt="Bootstrap Image Preview" src="${img }/DFWlogotext.jpg" class="img-thumbnail">
		</div>
	</div>
</div>





    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</body>
</html>
<%@ page  language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>酒仙网管理平台</title>
<link href="${res }/themes/css/login.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="login">
		<div id="login_header">
		
				<a href="#"><img src="${res }/themes/default/images/login_logo.gif" /></a>
			</h1>
			<div class="login_headerContent">
				<div class="navList">
					<ul>
						<li><a href="#">欢迎</a></li>
						<li><a href="#">来</a></li>
						<li><a href="#">购物</a></li>
					</ul>
				</div>
				<h2 class="login_title"><img src="${res }/themes/default/images/login_title.png" /></h2>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
				<form action="${ctx }/backend/login" method="post">
					<p>
						<label>用户名：</label>
						<input type="text" name="name" size="20" class="login_input" />
					</p>
					<p>
						<label>密码：</label>
						<input type="password" name="password" size="20" class="login_input" />
					</p>
					<div class="login_bar">
						<input class="sub" type="submit" value=" " />
					</div>
				</form>
			</div>
			
			<div class="login_main">
				<ul class="helpList">
					
				</ul>
				<div class="login_inner">
					
				</div>
			</div>
		</div>
		<div id="login_footer">
			Copyright &copy; <%=String.format("%tY", new java.util.Date())%> www.linlin.song.com Inc. All Rights Reserved.
		</div>
	</div>
</body>
</html>
<%@ page  language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${css }/imtshop.css">
<title> 酒仙网</title>
</head>
<body>
<div >
<div >
    <div >

        <div >
        	<c:if test="${not empty name}">
        	欢迎:${name }
        	</c:if>
          <p>我要找回我送饭网的密码</p>
        </div>

    </div>

    
</div>
<div >


<form method="post" action="${ctx }/find_password">
请输入您的用户名：<input type='text' name='name'  size='25' maxlength='6'>
<br>
请输入您的问题：<input type='text' name='question'  size='25' >
<br>
请输入您的答案：<input type='text' name='answer'  size='25' ><br>
<input type="submit" value="提交"/>&nbsp;<input type="reset" value="重置"/>
</form>
</div>



<div >
    <hr>
    
</div>
</div>
</body>
</html>
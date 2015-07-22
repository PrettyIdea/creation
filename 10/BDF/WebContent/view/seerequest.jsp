<%@ page
	import="java.sql.*,javax.sql.*,dao.DbUtil,java.text.*"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>我的订单详情</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>

<%


String name = (String) request.getSession().getAttribute(
		"name");
Connection conn = DbUtil.getConnection();
PreparedStatement pstat = null;
ResultSet rs = null;

String sql = null;
	//从商品库中取出所选购商品的数据  
	
	String adress = null, resturant= null,item=null, price= null, phone=null;
	sql = "select * from order where name=?";
	pstat = conn.prepareStatement(sql);
	pstat.setString(1, name);
	rs = pstat.executeQuery();
	if (rs.next()) {
		name = rs.getString("name").trim();
		adress = rs.getString("adress").trim();
		resturant = rs.getString("resturant").trim();
		item = rs.getString("item").trim();
		price = rs.getString("price").trim();
		phone = rs.getString("phone").trim();	
	}
	rs.close();
	pstat.close();

%>

 <div class="container-fluid">
	<div class="row">
		<div class="col-md-4">
			<img alt="Bootstrap Image Preview" src="http://lorempixel.com/140/140/">
		</div>
		<div class="col-md-8">
			<h3>
			
			</h3>
			<p>
			我要带饭
			
			</p>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<h3 class="text-center">
				求带饭
			</h3>
			<form role="form" action="request.jsp" method="post">
			<div class="form-group">
					 
					<label for="adress">
						你的地点：
					</label>
					<input type="text" name="adress" class="form-control" id="adress">
				</div>
				<div class="form-group">
					 
					<label for="resturant">
						你的餐厅
					</label>
					<input type="text"  name="resturant" class="form-control" id="resturant">
				</div>
				<div class="form-group">
				<label for="item">
						菜品：
					</label>
					<input type="text" name="item" class="form-control" id="item">
				</div>
				
				<div class="form-group"> 
					<label for="price">
						饭资：
					</label>
					<input type="text" name="price" class="form-control" id="price">
				</div>
					<div class="form-group"> 
					<label for="phone">
						我的联系方式：：
					</label>
					<input type="text" name="phone" class="form-control" id="phone">
				</div>
				<div class="form-group"> 
					<label for="tips">
						备注：
					</label>
					<input type="text" name="tips" class="form-control" id="tips">
				</div>
				
				<button type="submit" class="btn btn-default">
					生成请求
				</button>
				<button type="reset" class="btn btn-default">
					重置
				</button>
			</form>
		</div>
	</div>
</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>
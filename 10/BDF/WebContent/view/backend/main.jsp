<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>酒仙网台管理</title>

<link href="${res}/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${res}/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${res}/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="${res}/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lte IE 9]>
<script src="js/speedup.js" type="text/javascript"></script>
<![endif]-->

<script src="${js}/jquery-1.7.2.js" type="text/javascript"></script>
<script src="${js}/jquery.cookie.js" type="text/javascript"></script>
<script src="${js}/jquery.validate.js" type="text/javascript"></script>
<script src="${js}/jquery.bgiframe.js" type="text/javascript"></script>
<script src="${res}/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>


<script src="${js}/dwz.core.js" type="text/javascript"></script>
<script src="${js}/dwz.util.date.js" type="text/javascript"></script>
<script src="${js}/dwz.validate.method.js" type="text/javascript"></script>
<script src="${js}/dwz.regional.zh.js" type="text/javascript"></script>
<script src="${js}/dwz.barDrag.js" type="text/javascript"></script>
<script src="${js}/dwz.drag.js" type="text/javascript"></script>
<script src="${js}/dwz.tree.js" type="text/javascript"></script>
<script src="${js}/dwz.accordion.js" type="text/javascript"></script>
<script src="${js}/dwz.ui.js" type="text/javascript"></script>
<script src="${js}/dwz.theme.js" type="text/javascript"></script>
<script src="${js}/dwz.switchEnv.js" type="text/javascript"></script>
<script src="${js}/dwz.alertMsg.js" type="text/javascript"></script>
<script src="${js}/dwz.contextmenu.js" type="text/javascript"></script>
<script src="${js}/dwz.navTab.js" type="text/javascript"></script>
<script src="${js}/dwz.tab.js" type="text/javascript"></script>
<script src="${js}/dwz.resize.js" type="text/javascript"></script>
<script src="${js}/dwz.dialog.js" type="text/javascript"></script>
<script src="${js}/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="${js}/dwz.sortDrag.js" type="text/javascript"></script>
<script src="${js}/dwz.cssTable.js" type="text/javascript"></script>
<script src="${js}/dwz.stable.js" type="text/javascript"></script>
<script src="${js}/dwz.taskBar.js" type="text/javascript"></script>
<script src="${js}/dwz.ajax.js" type="text/javascript"></script>
<script src="${js}/dwz.pagination.js" type="text/javascript"></script>
<script src="${js}/dwz.database.js" type="text/javascript"></script>
<script src="${js}/dwz.datepicker.js" type="text/javascript"></script>
<script src="${js}/dwz.effects.js" type="text/javascript"></script>
<script src="${js}/dwz.panel.js" type="text/javascript"></script>
<script src="${js}/dwz.checkbox.js" type="text/javascript"></script>
<script src="${js}/dwz.history.js" type="text/javascript"></script>
<script src="${js}/dwz.combox.js" type="text/javascript"></script>
<script src="${js}/dwz.print.js" type="text/javascript"></script>
<!--
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->
<script src="${js}/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	DWZ.init("${res}/dwz.frag.xml", {
		loginUrl:"${ctx}/backend/login.jsp", loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"${res}/themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
});

</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="" href="#">酒仙网</a>
				<ul class="nav">
					<li><a href="#" >欢迎：${sessionScope.adminName}</a></li>
					<li><a href="${ctx}/backend/logout">退出登陆</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>

			<!-- navMenu -->
			
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>

				<div class="accordion" fillSpace="sidebar">
					<div class="accordionHeader">
						<h2><span>Folder</span>商品</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a>商品管理</a>
								<ul>
									<li><a href="${ctx }/backend/product_list" target="navTab" rel="product_list">商品维护</a></li>
									<li><a href="${ctx }/backend/product_category_list" target="navTab" rel="product_category_list">商品类别维护</a></li>
								</ul>
							</li>
							
							<li><a>销售管理</a>
								<ul>
									<li><a href="w_panel.html" target="navTab" rel="w_panel">销售、库存维护</a></li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							<div class="alertInfo">
								<h2><a >欢迎使用</a></h2>
                                
							</div>
							<div class="right">
								<p>只有本公司内部员工才能可以使用</p>
							</div>
							<p>请勿泄漏公司机密</p>
						</div>
						<div class="pageFormContent" layoutH="80" style="margin-right:230px">
							

						</div>
					</div>
					
				</div>
			</div>
		</div>

	</div>

	<div id="footer">Copyright &copy; <%=String.format("%tY", new java.util.Date())%> 酒仙网</div>
</body>
</html>
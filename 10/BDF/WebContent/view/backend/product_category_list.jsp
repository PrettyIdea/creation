<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="${ctx }/backend/product_category_list" method="post">
	<input type="hidden" name="pageNum" value="${page.pageNum}" />
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					分类名称：<input type="text" name="name" value="${param.name }"/>
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="${ctx }/backend/product_category_edit" target="dialog"><span>添加</span></a></li>
			<li><a class="delete" href="${ctx }/backend/product_category_delete?id={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="${ctx }/backend/product_category_edit?id={sid_user}" target="dialog"><span>修改</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80">序号</th>
				<th width="120" align="center">名称</th>
				<th width="100">等级</th>
				<th width="150">父类别名</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list }" var="bean" varStatus="status">
				<tr target="sid_user" rel="${bean.id }">
					<td>${status.count }</td>
					<td>${bean.name }</td>
					<td>${bean.level }</td>
					<td>${bean.superName }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="200">200</option>
			</select>
			<span>条，共${page.totalCount}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="${page.totalCount}" numPerPage="${page.numPerPage }" pageNumShown="10" currentPage="${page.pageNum }"></div>

	</div>
</div>

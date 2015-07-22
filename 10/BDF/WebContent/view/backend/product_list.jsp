<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css" media="screen">
	.my-uploadify-button {
		background:none;
		border: none;
		text-shadow: none;
		border-radius:0;
	}
</style>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="${ctx }/backend/product_list" method="post">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					商品名称：<input type="text" name="name" value="${param.name }"/>
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
			<li><a class="add" href="${ctx }/backend/product_edit" target="dialog"><span>添加</span></a></li>
			<li><a class="delete" href="${ctx }/backend/product_delete?id={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="${ctx }/backend/product_edit?id={sid_user}" target="dialog"><span>修改</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80">序号</th>
				<th width="120" align="center">名称</th>
				<th width="100">价格</th>
				<th width="150">数量</th>
				<th width="150">所属类别</th>
				<th width="150">描述</th>
				<th width="150">商品图片</th>
				<th width="150">上传图片</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list }" var="bean" varStatus="status">
				<tr target="sid_user" rel="${bean.id }">
					<td>${status.count }</td>
					<td>${bean.name }</td>
					<td>${bean.price }</td>
					<td>${bean.quantity }</td>
					<td>${bean.productCategory.name }</td>
					<td>${bean.description }</td>
					<td>
						<a class="button" href="${ctx }/backend/product_picture?id=${bean.id}" width="450" height="600" title="查看图片" target="dialog" rel="picture_dialog"><span>查看</span></a>
					</td>
					<td>
						<input id="upload_${status.count }" type="file" name="image" 
							uploaderOption="{
								swf:'${res }/uploadify/scripts/uploadify.swf;jsessionid=${pageContext.session.id}',
								uploader:'${ctx }/backend/product_picture',
								formData:{id:${bean.id }},
								buttonImage:'${res }/uploadify/img/add.jpg',
								buttonClass:'my-uploadify-button',
								width:102,
								fileSizeLimit:'1000KB',
								fileTypeDesc:'*.jpg;*.jpeg;*.gif;*.png;',
								fileTypeExts:'*.jpg;*.jpeg;*.gif;*.png;',
								auto:true,
								multi:true,
								queueID:'fileQueue',
								onUploadSuccess:uploadifySuccess,
								onQueueComplete:uploadifyQueueComplete
							}"
						/>
						<input type="image" src="${res }/uploadify/img/upload.jpg" onclick="$('#upload_${status.count }').uploadify('upload', '*');"/>
						<input type="image" src="${res }/uploadify/img/cancel.jpg" onclick="$('#upload_${status.count }').uploadify('cancel', '*');"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="fileQueue" class="fileQueue"></div>
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

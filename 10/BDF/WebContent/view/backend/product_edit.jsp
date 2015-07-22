<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="pageContent">
	<form method="post" action="${ctx }/backend/product_edit" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<input type="hidden" name="id" value="${bean.id }"/>
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>名称：</label>
				<input name="name" type="text" size="30" value="${bean.name }" class="required" remote="${ctx }/backend/product_name?oldValue=${bean.name}"/>
			</p>
			<p>
				<label>价格：</label>
				<input name="price" type="text" size="30" value="${bean.price }" class="required number"/>
			</p>
			<p>
				<label>数量：</label>
				<input name="quantity" type="text" size="30" value="${bean.quantity }" class="required digits"/>
			</p>
			<p>
				<label>描述：</label>
				<input name="description" type="text" size="30" value="${bean.description }" class="required"/>
			</p>
			<p>
				<label>类别：</label>
				<select name="categoryId" id="categoryId" class="required combox">
					<option value="">请选择</option>
					<c:forEach items="${threeLevels }" var="level">
						<option value="${level.id }" ${bean.productCategory.id eq level.id ? 'selected' : ''}>${level.name}</option>
					</c:forEach>
				</select>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>


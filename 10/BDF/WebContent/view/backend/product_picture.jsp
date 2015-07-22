<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	.product_pic{
		width: 400px;
	}
</style>
<div class="pageContent">
		<div class="pageFormContent" layoutH="56" align="center">
			<c:forEach items="${pictureNames }" var="name">
				<div>
					<img alt="商品图片" class="product_pic" src="${img }/product/${name}">
				</div>
				<hr>
			</c:forEach>
		</div>
</div>
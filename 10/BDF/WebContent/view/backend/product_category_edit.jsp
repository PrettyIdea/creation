<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function(){
		$('#productCategoryId').change(function(){
			var $this = $(this);
			var superId = $this.val();
			if(superId) {
				var superName =$('option[value='+superId+']').text();
				$('#level').val(parseInt(superName.split('--')[1]) + 1);
			} else {
				$('#level').val(1);
			}
		});
	});
</script>
<div class="pageContent">
	<form method="post" action="${ctx }/backend/product_category_edit" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<input type="hidden" name="id" value="${bean.id }"/>
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>名称：</label>
				<input name="name" type="text" size="30" value="${bean.name }" class="required" remote="${ctx }/backend/product_category_name?oldValue=${bean.name}"/>
			</p>
			<p>
				<label>父类别：</label>
				<select name="productCategoryId" id="productCategoryId" class="combox">
					<option value="">请选择</option>
					<c:forEach items="${allCategory }" var="ca">
						<option value="${ca.key }" ${bean['productCategoryId'] eq ca.key ? 'selected' : ''}>${ca.value}</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>等级：</label>
				<input type="text" readonly="readonly" id="level" name="level" value="${empty bean.level ? '1' : bean.level}">
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


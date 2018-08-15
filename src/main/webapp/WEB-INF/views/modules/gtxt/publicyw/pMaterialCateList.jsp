<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>业务材料分类管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/publicyw/pMaterialCate/">业务材料分类列表</a></li>
		<shiro:hasPermission name="publicyw:pMaterialCate:edit"><li><a href="${ctx}/publicyw/pMaterialCate/form">业务材料分类添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="pMaterialCate" action="${ctx}/publicyw/pMaterialCate/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>材料名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>材料名称</th>
				<th>功能代码</th>
				<th>状态</th>
				<th>更新时间</th>
				<th>材料列表</th>
				<shiro:hasPermission name="publicyw:pMaterialCate:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="pMaterialCate">
			<tr>
				<td><a href="${ctx}/publicyw/pMaterialCate/form?id=${pMaterialCate.id}">
					${pMaterialCate.name}
				</a></td>
				<td>
					${pMaterialCate.code}
				</td>
				<td>
					${fns:getDictLabel(pMaterialCate.state, 'state', '')}
				</td>
				<td>
					<fmt:formatDate value="${pMaterialCate.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<a href="${ctx}/publicyw/pMaterialinfo/list?id=${pMaterialCate.id}">材料列表</a>
				</td>
				<shiro:hasPermission name="publicyw:pMaterialCate:edit"><td>
    				<a href="${ctx}/publicyw/pMaterialCate/form?id=${pMaterialCate.id}">修改</a>
					<a href="${ctx}/publicyw/pMaterialCate/delete?id=${pMaterialCate.id}" onclick="return confirmx('确认要删除该业务材料分类吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
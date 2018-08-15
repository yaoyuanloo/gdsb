<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>本地业务属性定义管理</title>
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
		<li class="active"><a href="${ctx}/city/dYwinfoGroup2/">本地业务属性定义列表</a></li>
		<shiro:hasPermission name="city:dYwinfoGroup2:edit"><li><a href="${ctx}/city/dYwinfoGroup2/form">本地业务属性定义添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="dYwinfoGroup2" action="${ctx}/city/dYwinfoGroup2/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="city:dYwinfoGroup2:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dYwinfoGroup2">
			<tr>
				<td><a href="${ctx}/city/dYwinfoGroup2/form?id=${dYwinfoGroup2.id}">
					<fmt:formatDate value="${dYwinfoGroup2.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${dYwinfoGroup2.remarks}
				</td>
				<shiro:hasPermission name="city:dYwinfoGroup2:edit"><td>
    				<a href="${ctx}/city/dYwinfoGroup2/form?id=${dYwinfoGroup2.id}">修改</a>
					<a href="${ctx}/city/dYwinfoGroup2/delete?id=${dYwinfoGroup2.id}" onclick="return confirmx('确认要删除该本地业务属性定义吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
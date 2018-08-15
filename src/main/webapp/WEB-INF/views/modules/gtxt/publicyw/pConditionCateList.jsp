<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>业务条件分类管理</title>
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
		<li class="active"><a href="${ctx}/publicyw/pConditionCate/">业务条件分类列表</a></li>
		<shiro:hasPermission name="publicyw:pConditionCate:edit"><li><a href="${ctx}/publicyw/pConditionCate/form">业务条件分类添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="pConditionCate" action="${ctx}/publicyw/pConditionCate/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>条件分类名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>功能代码：</label>
				<form:input path="code" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>条件分类名称</th>
				<th>功能代码</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<th>条件列表</th>
				<shiro:hasPermission name="publicyw:pConditionCate:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="pConditionCate">
			<tr>
				<td><a href="${ctx}/publicyw/pConditionCate/form?id=${pConditionCate.id}">
					${pConditionCate.name}
				</a></td>
				<td>
					${pConditionCate.code}
				</td>
				<td>
					<fmt:formatDate value="${pConditionCate.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${pConditionCate.remarks}
				</td>
				<td>
					<a href="${ctx}/publicyw/pConditioninfo/list?id=${pConditionCate.id}">条件列表</a>
				</td>
				<td>
    				<a href="${ctx}/publicyw/pConditionCate/form?id=${pConditionCate.id}">修改</a>
					<a href="${ctx}/publicyw/pConditionCate/delete?id=${pConditionCate.id}" onclick="return confirmx('确认要删除该业务条件分类吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
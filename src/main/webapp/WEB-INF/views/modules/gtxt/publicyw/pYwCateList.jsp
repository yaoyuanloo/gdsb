<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>公共业务类别管理</title>
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
		<li class="active"><a href="${ctx}/publicyw/pYwCate/list">公共业务类别列表</a></li>
		<shiro:hasPermission name="publicyw:pYwCate:edit"><li><a href="${ctx}/publicyw/pYwCate/form">公共业务类别添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="pYwCate" action="${ctx}/publicyw/pYwCate/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
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
				<th>业务分类名称</th>
				<th>功能代码</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<th>业务类别</th>
				<th>业务列表</th>
				<shiro:hasPermission name="publicyw:pYwCate:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="pYwCate">
			<tr>
				<td><a href="${ctx}/publicyw/pYwCate/form?id=${pYwCate.id}">
					${pYwCate.name}
				</a></td>
				<td>
					${pYwCate.code}
				</td>
				<td>
					<fmt:formatDate value="${pYwCate.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${pYwCate.remarks}
				</td>

				<td>${fns:getDictLabel(pYwCate.ywType, 'yw_type', '无')}</td>
				<td>
					<a href="${ctx}/publicyw/pYwinfo/list?id=${pYwCate.id}">业务列表</a>
				</td>
				
				<shiro:hasPermission name="publicyw:pYwCate:edit"><td>
    				<a href="${ctx}/publicyw/pYwCate/form?id=${pYwCate.id}">修改</a>
					<a href="${ctx}/publicyw/pYwCate/delete?id=${pYwCate.id}" onclick="return confirmx('确认要删除该公共业务类别吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
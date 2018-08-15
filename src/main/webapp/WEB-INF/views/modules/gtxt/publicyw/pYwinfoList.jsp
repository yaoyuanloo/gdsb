<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>公共业务信息表管理</title>
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
	<li class="active"><a href="${ctx}/publicyw/pYwinfo/">公共业务信息表列表</a></li>
	<li><a href="${ctx}/publicyw/pYwinfo/form">公共业务信息表添加</a></li>

	<div align="right"><input   class="btn btn-primary" onclick="javascript:window.location.href='${ctx}/publicyw/pYwCate/list'"  type="button"    value="返回"/>

</ul>
<form:form id="searchForm" modelAttribute="pYwCate" action="${ctx}/publicyw/pYwinfo/" method="post" class="breadcrumb form-search">
	<input id="cate" name="pywCate.id" type="hidden" value="${pYwCate.id}"/>
	<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
	<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
</form:form>

<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
	<thead>
	<tr>
		<th>业务名称</th>
		<th>功能代码</th>
		<th>更新时间</th>
		<th>备注信息</th>
		<shiro:hasPermission name="publicyw:pYwinfo:edit"><th>操作</th></shiro:hasPermission>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${page.list}" var="pYwinfo">
		<tr>

			<td>
					${pYwinfo.name}
			</td>
			<td>
					${pYwinfo.code}
			</td>
			<td>
				<fmt:formatDate value="${pYwinfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
			<td>
					${pYwinfo.remarks}
			</td>
			<td>
				<a href="${ctx}/publicyw/pYwinfo/form?id=${pYwinfo.id}">修改</a>
				<a href="${ctx}/publicyw/pYwinfo/delete?id=${pYwinfo.id}" onclick="return confirmx('确认要删除该公共业务信息表吗？', this.href)">删除</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>
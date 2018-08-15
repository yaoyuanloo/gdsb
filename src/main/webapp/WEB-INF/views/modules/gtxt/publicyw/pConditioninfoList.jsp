<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>公共条件信息表管理</title>
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
		<li class="active"><a href="${ctx}/publicyw/pConditioninfo/">公共条件信息表列表</a></li>
		 <li><a href="${ctx}/publicyw/pConditioninfo/form">公共条件信息表添加</a></li>
		<div align="right"><input   class="btn btn-primary" onclick="javascript:window.location.href='${ctx}/city/dWrittemp/list'"  type="button"    value="返回"/>

	</ul>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>条件名称</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="publicyw:pConditioninfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="pConditioninfo">
			<tr>
				<td><a href="${ctx}/publicyw/pConditioninfo/form?id=${pConditioninfo.id}">
					${pConditioninfo.name}
				</a></td>
				<td>
					<fmt:formatDate value="${pConditioninfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${pConditioninfo.remarks}
				</td>
				<shiro:hasPermission name="publicyw:pConditioninfo:edit"><td>
    				<a href="${ctx}/publicyw/pConditioninfo/form?id=${pConditioninfo.id}">修改</a>
					<a href="${ctx}/publicyw/pConditioninfo/delete?id=${pConditioninfo.id}" onclick="return confirmx('确认要删除该公共条件信息表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
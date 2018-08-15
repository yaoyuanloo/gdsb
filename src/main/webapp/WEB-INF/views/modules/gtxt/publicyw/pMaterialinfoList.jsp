<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>公共业务材料表管理</title>
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
		<li class="active"><a href="${ctx}/publicyw/pMaterialinfo/">公共业务材料表列表</a></li>
	 <li><a href="${ctx}/publicyw/pMaterialinfo/form?cateId=${pMaterialinfo.id}">公共业务材料表添加</a></li>
		<div align="right"><input   class="btn btn-primary" onclick="javascript:window.location.href='${ctx}/publicyw/pMaterialCate/list'"  type="button"    value="返回"/>

	</ul>
	<form:form id="searchForm" modelAttribute="pMaterialinfo" action="${ctx}/publicyw/pMaterialinfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input type="hidden" name ="cateId" value="${pMaterialinfo.cateId}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>材料名称</th>
				<th>更新时间</th>
				<th>备注信息</th>

			 <th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="pMaterialinfo">
			<tr>
				<td><a href="${ctx}/publicyw/pMaterialinfo/form?id=${pMaterialinfo.id}">
					${pMaterialinfo.name}
				</a></td>
				<td>
					<fmt:formatDate value="${pMaterialinfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${pMaterialinfo.remarks}
				</td>

			 <td>
    				<a href="${ctx}/publicyw/pMaterialinfo/form?id=${pMaterialinfo.id}">修改</a>
					<a href="${ctx}/publicyw/pMaterialinfo/delete?id=${pMaterialinfo.id}" onclick="return confirmx('确认要删除该公共业务材料表吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
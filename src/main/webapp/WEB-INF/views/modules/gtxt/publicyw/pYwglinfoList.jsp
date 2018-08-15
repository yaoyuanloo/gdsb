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
	<li class="active"><a href="${ctx}/publicyw/pYwinfo/pwywList">公共业务信息表列表</a></li>
	<li><a href="${ctx}/publicyw/pYwinfo/pwywform">公共业务信息表添加</a></li>
	
	<div align="right"><input   class="btn btn-primary" onclick="javascript:window.location.href='${ctx}/publicyw/pYwinfo/pwywList'"  type="button"    value="返回"/>

</ul>


<form:form id="searchForm" modelAttribute="pYwinfo" action="${ctx}/publicyw/pYwinfo/pwywList" method="post" class="breadcrumb form-search ">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<sys:tableSort id="orderBy" name="orderBy" value="${page.orderBy}" callback="page();"/>
		<ul class="ul-form">
			<li><label>业务名称：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/></li>
			<li class="btns">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" onclick="return page();"/>
				</li>
			<li class="clearfix"></li>
		</ul>
</form:form>


<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
	<thead>
	<tr>
		<th>业务名称</th>
		<th>功能代码</th>
		<th>更新时间</th>
		<th>备注信息</th>	
			
		<th>受理地址</th>
		<th>审核地址</th>
		<th>初审地址</th>
		<th>复审地址</th>
		<th>审批地址</th>
		<th>操作      </th>
	</tr>
	
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
					<a href="${ctx}${pYwinfo.acceptaddress}">受理地址</a>	
					
			</td>
			</td>
			
			<td>
			<a href="${ctx}${pYwinfo.examineaddress}">审核地址</a>	
					
			</td>
			
			<td>
			<a href="${ctx}${pYwinfo.trialaddress}">初审地址</a>	
					
			</td>
			</td>
			
			<td>
			<a href="${ctx}${pYwinfo.reviewaddress}">复审地址</a>	
					
			</td>
			<td>
			<a href="${ctx}${pYwinfo.approveaddress}">审批地址</a>	
					
			</td>
			
			
			<td>
				<a href="${ctx}/publicyw/pYwinfo/updatePYwinfo?id=${pYwinfo.id}">修改</a>
				<a href="${ctx}/publicyw/pYwinfo/delPYwinfo?id=${pYwinfo.id}" onclick="return confirmx('确认要删除该公共业务信息表吗？', this.href)">删除</a>
			</td>
		</tr>
	</c:forEach>
	</thead>

</table>
<div class="pagination">${page}</div>
</body>
</html>
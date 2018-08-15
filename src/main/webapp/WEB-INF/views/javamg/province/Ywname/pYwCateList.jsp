<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>指标代码表管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		<!--让多选框单选-->
		$(document).ready(function() {
			$(':checkbox[name="checkid"]').each(function(){
				$(this).click(function(){
					if($(this).attr('checked')){
						$(':checkbox[name="checkid"]').removeAttr('checked');
						$(this).attr('checked','checked');
					}
				});
			});
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }



		function  checkInfo(){
			var chk_value =[];
			$('input[name="checkid"]:checked').each(function(){
				chk_value.push($(this).val());
			});
			if(chk_value.length>0){
				location.href = "${ctx}/ywgl/targets/formYwName?id="+chk_value

			}else{
				alert('请选择业务类别');
			}

		}

	</script>
</head>
<body>

	<div align="right"><input   class="btn btn-primary" onclick="javascript:window.location.href='${ctx}/province/pYwCate/form'"  type="button"    value="添加业务类别"/>

	</div>
	<%--<a href="">指标代码表添加</a>--%>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>类别编号</th>
				<th>业务类别</th>
				<th>状态</th>
				<shiro:hasPermission name="province:pYwCate:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="targets">
			<tr>
				<td>
						${targets.CODE}
				</td>
				<td>
					<a href="${ctx}/province/pYwinfo?id=${targets.id}">	${targets.name}</a>
				</td>
				<td>
						${fns:getDictLabel(targets.state, 'states', '')}
				</td>
				<shiro:hasPermission name="province:pYwCate:edit"><td>
					<a href="${ctx}/province/pYwinfo?id=${targets.id}">业务列表</a>
    				<a href="${ctx}/province/pYwCate/form?id=${targets.id}">修改</a>
					<a href="${ctx}/province/pYwCate/delete?id=${targets.id}" onclick="return confirmx('确认要删除该指标代码表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
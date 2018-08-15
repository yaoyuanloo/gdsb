<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title> </title>
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
				location.href = "${ctx}/ywgl/targets/ywqxList?id="+chk_value

			}else{
				alert('请选择类别');
			}

		}

	</script>
</head>
<body>

	<div align="right"><input   class="btn btn-primary" onclick="javascript:window.location.href='${ctx}/ywgl/targets/tjform'"  type="button"    value="添加"/>
  </div>
	<%--<a href="">指标代码表添加</a>--%>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>代码编号</th>
				<th>条件类别名称</th>
				<th>状态</th>
				<shiro:hasPermission name="ywgl:targets:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="targets">
			<tr>
				<td>
						${targets.JDmbh}
				</td>
				<td>
						${targets.JDmmc}
				</td>
				<td>
						${fns:getDictLabel(targets.JBj, 'states', '')}
				</td>
				 <td>
    				<a href="${ctx}/ywgl/targets/formTjList?jZbdm=${targets.JDmbh}">条件列表</a>

				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
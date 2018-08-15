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
				location.href = "${ctx}/ywgl/targets/formTiaoJian?id="+chk_value;

			}else{
				alert('请选择业务类别');
			}

		}

	</script>
</head>
<body>

<TABLE  width="100%">
    <TR>
        <TD >
            <span style="font-size:20px;color:#ff0000;"> 业务类别：${targets.JDmmc}</TD>
        </TD>

        <TD ALIGN="right" >

            <input   class="btn btn-primary" onclick="javascript:window.location.href='${ctx}/ywgl/targets/formYwNameInfo?id=${targets.id}'"  type="button"    value="添加业务"/>
            <input   class="btn btn-primary"  type="button"  onclick="javascript:window.location.href='${ctx}/ywgl/targets'"  value="返回"/>

        </TD>
    </TR>

</TABLE>
	<%--<a href="">指标代码表添加</a>--%>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>代码编号</th>
				<th>代码名称</th>
                <th>备注</th>
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
                <td >${targets.JPs}</td>
				<td>
						${fns:getDictLabel(targets.JBj, 'states', '')}
				</td>
				<shiro:hasPermission name="ywgl:targets:edit"><td>
					<a href="${ctx}/ywgl/targets/formTiaoJian?id=${targets.id}">条件管理</a>
    				<a href="${ctx}/ywgl/targets/formYwNameInfo?id=${targets.id}&xg=1">修改</a>
					<a href="${ctx}/ywgl/targets/delete?id=${targets.id}" onclick="return confirmx('确认要删除该指标代码表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
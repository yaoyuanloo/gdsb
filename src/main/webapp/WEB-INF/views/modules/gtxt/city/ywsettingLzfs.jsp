<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>



<title>业务状态流转方式</title>
<meta name="decorator" content="default" />
<style>
   span{
      color:#00CC33;
   } 
</style>



	<script type="text/javascript">
		function checkiframe(){
			top.$.jBox.open("iframe:${ctx}/sys/role/usertorole?id=${role.id}", "分配角色",810,$(top.document).height()-240,{
				buttons:{"确定分配":"ok", "清除已选":"clear", "关闭":true}, bottomText:"通过选择部门，然后为列出的人员分配角色。",submit:function(v, h, f){
					var pre_ids = h.find("iframe")[0].contentWindow.pre_ids;
					var ids = h.find("iframe")[0].contentWindow.ids;
					//nodes = selectedTree.getSelectedNodes();
					if (v=="ok"){
						// 删除''的元素
						if(ids[0]==''){
							ids.shift();
							pre_ids.shift();
						}
						if(pre_ids.sort().toString() == ids.sort().toString()){
							top.$.jBox.tip("未给角色【${role.name}】分配新成员！", 'info');
							return false;
						};
						// 执行保存
						loading('正在提交，请稍等...');
						var idsArr = "";
						for (var i = 0; i<ids.length; i++) {
							idsArr = (idsArr + ids[i]) + (((i + 1)== ids.length) ? '':',');
						}

						$('#idsArr').val(idsArr);
						$('#assignRoleForm').submit();
						return true;
					} else if (v=="clear"){
						h.find("iframe")[0].contentWindow.clearAssign();
						return false;
					}
				}, loaded:function(h){
					$(".jbox-content", top.document).css("overflow-y","hidden");
				}
			});
		}
	</script>
</head>
<body>
<form:form id="inputForm" modelAttribute="dywatter" action=" " method="post" class="form-horizontal">
   <table id="contentTable" class="table table-striped table-bordered table-condensed">
	 <form:hidden path="ywid" value="${ywid}"></form:hidden>
	<tr>
		 <td>
				 <label>业务流转方式：</label>
			</td>
				 <td>
				 <form:select id="jReviis" path="lzfscode" class="input-xlarge">
					 <form:option value="" label="请选择"/>
					 <form:options items="${fns:getDictList('ywlzfs')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
		   </td>
	 </tr>
		 <tr>
			 <td>
					 <label>主流程方式：</label>
			 <td>


					<form:select id="jAssis" path="flowcode" class="input-xlarge">
					 <form:option value="" label="请选择"/>
					 <form:options items="${fns:getDictList('yw_zlfcs')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>

			 </td>
		 </tr>
		 <tr>
			 <td>
				 <label>业务审核级别：</label>


			 </td>
             <td>
				<form:select id="jClassis" path="shjbcode" class="input-xlarge">
					 <form:option value="" label="请选择"/>
					 <form:options items="${fns:getDictList('ywshfs')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>

			 </td>

		  </tr>
	      <tr>
		     <td>
			 <label>设定人员：</label>
             </td>
		     <td>
		      <%-- <sys:treeselect id="jReviZe" name="primaryPerson.id" value="${office.primaryPerson.id}" labelName="office.primaryPerson.name" labelValue="${office.primaryPerson.name}"
				title="用户" url="/sys/office/treeData?type=3" allowClear="true" notAllowSelectParent="true"/> --%>
				<sys:treeselect id="jReviZeis" checked="true" name="jReviZeis" value="${organization.primaryPerson.id}" labelName="organization.primaryPerson.name" labelValue="${organization.primaryPerson.name}"
					title="一级审核员列表" url="/sys/office/treeDataUser" allowClear="true" notAllowSelectParent="true"/>
		     </td>

	</tr>
</table>


负责人员列表
<table id="contentTable" class="table table-striped table-bordered table-condensed">
	<thead>
	<tr>
		<th>用户ID</th>
		<th>用户名称</th>
		<th>联系方式</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${userList}" var="user">
		<tr>
			<td>
					${user.loginName}
			</td>
			<td>
					${user.name}
			</td>
			<td>
					${user.phone}
			</td>
		</tr>
	</c:forEach>
	</tbody>
	<tbody>
 </form:form>
</body>
</html>

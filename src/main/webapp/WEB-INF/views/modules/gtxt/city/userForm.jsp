<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户管理</title>
	<meta name="decorator" content="default"/>
		<%@include file="/WEB-INF/views/include/treeview.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate({
				submitHandler: function(form){
					var ids2 = [], nodes2 = tree2.getCheckedNodes(true);
					for(var i=0; i<nodes2.length; i++) {
						ids2.push(nodes2[i].id);
					}
					$("#ywids").val(ids2);
					loading('正在提交，请稍等...');
					form.submit();
				},
			});
			var setting = {check:{enable:true,nocheckInherit:true},view:{selectedMulti:false},
					data:{simpleData:{enable:true}},callback:{beforeClick:function(id, node){
						tree.checkNode(node, !node.checked, true, true);
						return false;
					}}};
			
			// 用户-机构
			var zNodes2=[
					<c:forEach items="${qsyw}" var="qsyws">{id:"${qsyws.id}", pId:"${not empty qsyws.parent?qsyws.parent.id:0}", name:"${qsyws.name}"},
		            </c:forEach>];
			// 初始化树结构
		var tree2 = $.fn.zTree.init($("#ywinfoTree"), setting, zNodes2);
			// 不选择父节点
			tree2.setting.check.chkboxType = { "Y" : "ps", "N" : "s" };
			// 默认选择节点
		// 默认选择节点
 			var ids = "${org.ywIds}".split(",");
			for(var i=0; i<ids.length; i++) {
				var node = tree2.getNodeByParam("id", ids[i]);
				try{tree2.checkNode(node, true, false);}catch(e){}
			} 
			// 默认展开全部节点
			tree2.expandAll(true); 
			
			$("#no").focus();
			$("#inputForm").validate({
				rules: {
					loginName: {remote: "${ctx}/sys/user/checkLoginName?oldLoginName=" + encodeURIComponent('${user.loginName}')}
				},
				messages: {
					loginName: {remote: "用户登录名已存在"},
					confirmNewPassword: {equalTo: "输入与上面相同的密码"}
				},
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
	
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sys/user/listDjUser">用户列表</a></li>
		<li class="active"><a href="${ctx}/sys/user/form?id=${user.id}">用户<shiro:hasPermission name="sys:user:edit">${not empty user.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sys:user:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="user" action="${ctx}/sys/user/saveDi" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<form:hidden path="company.id"/>

		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">归属部门:</label> 
		  	<div class="controls">
                <sys:treeselect id="office" name="office.id" value="${user.office.id}" labelName="office.name" labelValue="${user.office.name}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="required" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">姓名:</label>
			<div class="controls">
				<input id="name" name="name" value="${user.name}" htmlEscape="false" maxlength="50" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">登录名:</label>
			<div class="controls">
				<input id="oldLoginName" name="oldLoginName" type="hidden" value="${user.loginName}">
				<form:input path="loginName" readonly="true" htmlEscape="false" maxlength="50" class="required userName"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">系统角色(菜单):</label>
			<div class="controls">
				 <form:checkboxes path="roleIdList" items="${allRoles}" itemLabel="name" itemValue="id" htmlEscape="false" class="required"/>
			 <span class="help-inline"><font color="red">*</font> </span>
			</div>
		 </div>
		 <div class="control-group" >
			<label class="control-label">用户角色:</label>
			<div class="controls">
			<form:select  path="gtuserslrole.roleid" class="input-medium selectWidth" >
			 <c:forEach items="${userRoleList}" var="shoulirole">
               <form:option value="${shoulirole.id}" label="${shoulirole.name}"/>
               </c:forEach> 
			   <span class="help-inline"><font color="red">*</font> </span>
			   </form:select>
		</div>
		</div>

		<div class="control-group">
			<label class="control-label">用户权限:</label>
			<div class="controls">
				<form:select path="userqx.qxid" class="input-xlarge">
				
					<form:options items="${fns:getDictList('ROLEQX')}" itemLabel="label"  itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="3" maxlength="200" class="input-xlarge"/>
			</div>
		</div>
		<c:if test="${not empty user.id}">
			<div class="control-group">
				<label class="control-label">创建时间:</label>
				<div class="controls">
					<label class="lbl"><fmt:formatDate value="${user.createDate}" type="both" dateStyle="full"/></label>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">最后登陆:</label>
				<div class="controls">
					<label class="lbl">IP: ${user.loginIp}&nbsp;&nbsp;&nbsp;&nbsp;时间：<fmt:formatDate value="${user.loginDate}" type="both" dateStyle="full"/></label>
				</div>
			</div>
		</c:if>

		<div class="form-actions">
			<shiro:hasPermission name="sys:user:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
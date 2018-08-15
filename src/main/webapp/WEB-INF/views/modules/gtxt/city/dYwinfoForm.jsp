<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>本地业务制定管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">

		$(document).ready(function() {

			//$("#name").focus();
			$("#inputForm").validate({
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
		<li><a href="${ctx}/city/dYwinfo/">本地业务制定列表</a></li>
		<li class="active"><a href="${ctx}/city/dYwinfo/form?id=${dYwinfo.id}">本地业务制定<shiro:hasPermission name="city:dYwinfo:edit">${not empty dYwinfo.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="city:dYwinfo:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="dYwinfo" action="${ctx}/city/dYwinfo/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">业务名称：</label>
			<div class="controls">
				<form:input path="pywinfo" htmlEscape="false" value="${dYwinfo.pywinfo.name}" maxlength="35" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">业务内容：</label>
			<div class="controls">
				<form:input path="conment" htmlEscape="false" value="${dYwinfo.conment}"  maxlength="300" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">工作日：</label>
			<div class="controls">
				<form:input path="day" htmlEscape="false" value="${dYwinfo.day}" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">机构代码：</label>
			<div class="controls">
				<form:input path="orgid" htmlEscape="false" value="${dYwinfo.orgid}" maxlength="30" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" value="${dYwinfo.remarks}" rows="4" maxlength="1000" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">状态：</label>
			<div class="controls">
				<form:input path="state" htmlEscape="false"  value="${dYwinfo.state}" maxlength="1" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="city:dYwinfo:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
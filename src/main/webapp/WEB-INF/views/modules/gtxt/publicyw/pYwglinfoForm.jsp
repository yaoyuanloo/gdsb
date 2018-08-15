<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>公共业务信息表管理</title>
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
	<li><a href="${ctx}/city/dYwinfo/pwywList">公共业务信息表列表</a></li>
	<li class="active"><a href="${ctx}/city/dYwinfo/pwywform?id=${pywinfo.id}">公共业务信息表<shiro:hasPermission name="publicyw:pYwinfo:edit">${not empty pYwinfo.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="publicyw:pYwinfo:edit">查看</shiro:lacksPermission></a></li>
</ul><br/>
<form:form id="inputForm" modelAttribute="pYwinfo" action="${ctx}/publicyw/pYwinfo/save" method="post" class="form-horizontal">
	<form:hidden path="id"/>
	<sys:message content="${message}"/>
	<div class="control-group">
		<label class="control-label">业务分类：</label>
		<div class="controls">
			<form:select path="pywCate.id" class="input-xlarge ">
				<form:options items="${pYwCate}" itemLabel="name" itemValue="id" htmlEscape="false"/>
			</form:select>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">业务名称：</label>
		<div class="controls">
			<form:input path="name" htmlEscape="false" maxlength="200" class="input-xlarge "/>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">功能代码：</label>
		<div class="controls">
			<form:input path="code" htmlEscape="false" maxlength="100" class="input-xlarge "/>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">受理地址：</label>
		<div class="controls">
			<form:input path="acceptaddress" htmlEscape="false" maxlength="100" class="input-xlarge "/>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">审核地址：</label>
		<div class="controls">
			<form:input path="examineaddress" htmlEscape="false" maxlength="100" class="input-xlarge "/>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">初审地址：</label>
		<div class="controls">
			<form:input path="trialaddress" htmlEscape="false" maxlength="100" class="input-xlarge "/>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">复审地址：</label>
		<div class="controls">
			<form:input path="reviewaddress" htmlEscape="false" maxlength="100" class="input-xlarge "/>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">审批地址：</label>
		<div class="controls">
			<form:input path="approveaddress" htmlEscape="false" maxlength="100" class="input-xlarge "/>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">内容：</label>
		<div class="controls">
			<form:textarea path="conment" htmlEscape="false" rows="4" maxlength="2000" class="input-xxlarge "/>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">状态：</label>
		<div class="controls">
			<form:select path="state" class="input-xlarge ">
				<form:options items="${fns:getDictList('state')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</form:select>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">备注信息：</label>
		<div class="controls">
			<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="1000" class="input-xxlarge "/>
		</div>
	</div>
	<div class="form-actions">
		<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
		<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
	</div>
</form:form>
</body>
</html>
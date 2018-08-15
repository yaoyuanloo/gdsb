<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>指标代码表管理</title>
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
 <br/>
	<form:form id="inputForm" modelAttribute="targets" action="${ctx}/ywgl/targets/saveTjInfo" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<form:hidden path="jZbdm" value="${targets.JZbdm}"/>
		<form:hidden path="jZbmc" value="${targets.JZbmc}"/>
		<div class="control-group">
			<label class="control-label">条件类别代码：</label>
			<div class="controls">
				<form:input path="jDmbh" htmlEscape="false"  readonly="true"  maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		 <div class="control-group">
			<label class="control-label">条件类别名称：</label>
			<div class="controls">
				<form:input path="jDmmc" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div></div>


	 <div class="control-group">
		 <label class="control-label">备注：</label>
		 <div class="controls">
			 <form:textarea htmlEscape="false" maxlength="555" rows="5" class="input-xlarge " path="jPs"></form:textarea>
		 </div>
	 </div>
		<div class="control-group">
			<label class="control-label">状态：</label>
			<div class="controls">
				<form:select path="jBj" class="input-medium">
					<form:options items="${fns:getDictList('states')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>



		<div class="form-actions">
	<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
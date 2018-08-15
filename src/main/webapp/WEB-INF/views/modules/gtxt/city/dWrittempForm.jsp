<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>地级市业务分类管理</title>
	<meta name="decorator" content="yhdefault"/>

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
	<!--页面主体-->
<div class=""> 
  <!--行一-->
  <div class="row">
    <div class="span12"> 
      <!-- box -->
      <div class="box box-default"> 
        <div class="box-body">
          	<form:form id="dwrittemForm" modelAttribute="dWrittemp" action="${ctx}/city/dWrittemp/save" method="post" class="form-horizontal">
        	<form:hidden path="id"/>
			<sys:message content="${message}"/>
        		<div class="form-group">
           			<label class="span3 control-label"><b class="mr5 red500">*</b>名称：</label>
           			<div class="span8">
           				<input type="text" placeholder="请输入业务名称"  value="${dWrittemp.name}" class="form-control" name="name" id="name"/>
           			</div>
               </div>
               
               
              <div class="form-group">
                  	<label class="span3 control-label"><b class="mr5 red500">*</b>功能代码：</label>
                  	<div class="span8">
                  		<input type="text" placeholder="请输入功能代码"  value="${dWrittemp.code}" class="form-control" name="code" id="code"/>
                  	</div>
             </div>
             
             <div class="form-group">
            		<label class="span3 control-label"><b class="mr5 red500"></b>内容：</label>
            		<div class="span8">
            			<input type="text" placeholder="请输入内容"  value="${dWrittemp.conment}" class="form-control" name="conment" id="conment"/>
            		</div>
             </div>
                					
                					
			<div class="form-group">
			 	<label class="span3 control-label"><b class="mr5 red500"></b>备注信息：</label>
				<div class="span8">
					<input type="text" placeholder="请输入备注信息"  value="${dWrittemp.remarks}" class="form-control" name="remarks" id="remarks"/>
				</div>
			</div>
            						
			<div class="form-group">
				<label class="span3 control-label"><b class="mr5 red500">*</b>状态：</label>
				<div class="span8">
					<form:select path="state" class="form-control selectpicker">
						<form:options items="${fns:getDictList('state')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
					</form:select>
			    </div>
			</div>
    		</form:form>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>
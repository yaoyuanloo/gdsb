<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<html>
<head>
	<title>文书模板信息表管理</title>
	<meta name="decorator" content="yhdefault"/>
	<script type="text/javascript" charset="utf-8" src="${ctxStatic}/utf8-jsp/ueditor.config.js"></script>
	<script type="text/javascript" charset="ut8" src="${ctxStatic}/utf8-jsp/ueditor.all.js"> </script>
	<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
	<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
	<script type="text/javascript" charset="utf-8" src="${ctxStatic}/utf8-jsp/lang/zh-cn/zh-cn.js"></script>

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
      	   <div class="box-header with-border">
                  <h3 class="box-title">
                      <div class="dec_1"></div>
                    	  文书模板信息表<shiro:hasPermission name="city:dWrittempinfo:edit">${not empty dWrittempinfo.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="city:dWrittempinfo:edit">查看</shiro:lacksPermission>
                  </h3>
                  <div class="box-tools pull-right">
                      <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                  </div>
           </div>
        <div class="box-body">
          	<form:form id="inputForm" modelAttribute="dWrittempinfo" action="${ctx}/city/dWrittempinfo/save" method="post" class="form-horizontal">
        	<form:hidden path="id"/>
			<sys:message content="${message}"/>		
        		<div class="form-group">
           			<label class="span2 control-label"><b class="mr5 red500">*</b>模板分类：</label>
           			<div class="span2">
           				<form:select path="cateId" class="form-control selectpicker">
							<form:options items="${dWrittemp}" itemLabel="name" itemValue="id" htmlEscape="false"/>
						</form:select>
           			</div>
           			
           			<label class="span2 control-label"><b class="mr5 red500">*</b>模板名称：</label>
                  	<div class="span2">
                  		<div class="controls">
							<input type="text" placeholder="请输入模板名称" readonly="readonly" value="${dWrittempinfo.name}" class="form-control" name="name" id="name"/>
						</div>
                  	</div>
                  	<input id="btnSubmit" class="btn yellow" type="submit" value="保 存"/>&nbsp;
				<input id="btnCancel" class="btn gray" type="button" value="返 回" onclick="history.go(-1)"/>
               </div>
             
             
             <div class="form-group">
            		<label class="span2 control-label"><b class="mr5 red500">*</b>功能代码：</label>
            		<div class="span2">
            			<input type="text" placeholder="请输入功能代码" readonly="readonly" value="${dWrittempinfo.code}" class="form-control" name="code" id="code"/>
            		</div>
            		
            		<label class="span2 control-label"><b class="mr5 red500">*</b>状态：</label>
					<div class="span2">
						<form:select path="state" class="form-control selectpicker">
							<form:options items="${fns:getDictList('state')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
						</form:select>
			    	</div>
             </div>
			 <div class="form-group">
				<label class="span2 control-label"><b class="mr5 red500">*</b>内容：</label>
				<div class="span6">
					<form:hidden id="moConment" path="conment"></form:hidden>
					<%--	<form:textarea path="conment" htmlEscape="false" rows="4" class="input-xxlarge "/>--%>
					<script id="editor"     type="text/plain" style="align:left;width:768px;height:500px;">
						${dWrittempinfo.conment}
					</script>
			    </div>
			 </div>
    		</form:form>
        </div>
      </div>
    </div>
  </div>
</div>
	<script type="text/javascript">

		//实例化编辑器
		//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例


		UE.getEditor('editor');
		function isFocus(e){
			alert(UE.getEditor('editor').isFocus());
			UE.dom.domUtils.preventDefault(e)
		}


		function onSumit(){
			var  sr=UE.getEditor('editor').getContent();
			$("#moConment").val(sr);
			$("#inputForm").submit();

		}
		function setblur(e){
			UE.getEditor('editor').blur();
			UE.dom.domUtils.preventDefault(e)
		}
		function insertHtml() {
			var value = prompt('22', '${dWrittempinfo.conment}');
			UE.getEditor('editor').execCommand('insertHtml',value)
		}
		function createEditor() {
			enableBtn();
			UE.getEditor('editor');
		}
		function getAllHtml() {
			alert(UE.getEditor('editor').getAllHtml())
		}
		function getContent() {
			var arr = [];
			arr.push("使用editor.getContent()方法可以获得编辑器的内容");
			arr.push("内容为：");
			arr.push(UE.getEditor('editor').getContent());
			alert(arr.join("\n"));
		}
		function getPlainTxt() {
			var arr = [];
			arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
			arr.push("内容为：");
			arr.push(UE.getEditor('editor').getPlainTxt());
			alert(arr.join('\n'))
		}
		function setContent(isAppendTo) {
			var arr = [];
			arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
			UE.getEditor('editor').setContent('', isAppendTo);

		}
		function setDisabled() {
			UE.getEditor('editor').setDisabled('fullscreen');
			disableBtn("enable");
		}

		function setEnabled() {
			UE.getEditor('editor').setEnabled();
			enableBtn();
		}

		function getText() {
			//当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
			var range = UE.getEditor('editor').selection.getRange();
			range.select();
			var txt = UE.getEditor('editor').selection.getText();
			alert(txt)
		}

		function getContentTxt() {
			var arr = [];
			arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
			arr.push("编辑器的纯文本内容为：");
			arr.push(UE.getEditor('editor').getContentTxt());
			alert(arr.join("\n"));
		}
		function hasContent() {
			var arr = [];
			arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
			arr.push("判断结果为：");
			arr.push(UE.getEditor('editor').hasContents());
			alert(arr.join("\n"));
		}
		function setFocus() {
			UE.getEditor('editor').focus();
		}
		function deleteEditor() {
			disableBtn();
			UE.getEditor('editor').destroy();
		}
		function disableBtn(str) {
			var div = document.getElementById('btns');
			var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
			for (var i = 0, btn; btn = btns[i++];) {
				if (btn.id == str) {
					UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
				} else {
					btn.setAttribute("disabled", "true");
				}
			}
		}
		function enableBtn() {
			var div = document.getElementById('btns');
			var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
			for (var i = 0, btn; btn = btns[i++];) {
				UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
			}
		}

		function getLocalData () {
			alert(UE.getEditor('editor').execCommand( "getlocaldata" ));
		}

		function clearLocalData () {
			UE.getEditor('editor').execCommand( "clearlocaldata" );
			alert("已清空草稿箱")
		}

	</script>

</body>
</html>
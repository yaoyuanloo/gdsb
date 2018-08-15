<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
	<style type="text/css">
		.ztree {
			overflow: auto;
			margin: 0;
			_margin-top: 10px;
			padding: 10px 0 0 10px;
		}
	</style>
	<title>定制受理角色管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treeview.jsp" %>
	<script type="text/javascript">

		var key, lastValue = "", nodeList = [], type = getQueryString("type", "${url}");
		var tree, setting = {
			view: {selectedMulti: false, dblClickExpand: false}, check: {enable: "true", nocheckInherit: true},

			data: {simpleData: {enable: true}}, callback: {
				onClick: function (event, treeId, treeNode) {
					tree.expandNode(treeNode);
				}, onCheck: function (e, treeId, treeNode) {
					var nodes = tree.getCheckedNodes(true);
					for (var i = 0, l = nodes.length; i < l; i++) {
						tree.expandNode(nodes[i], true, false, false);
					}
					setYwIds();
					return false;
				}
			}
		};
		function expandNodes(nodes) {
			if (!nodes) return;
			for (var i = 0, l = nodes.length; i < l; i++) {
				tree.expandNode(nodes[i], true, false, false);
				if (nodes[i].isParent && nodes[i].zAsync) {
					expandNodes(nodes[i].children);
				}
			}
		}
		$(document).ready(function () {
			$.get("${ctx}/ywgl/ywinfo/treeDataCheck", function (zNodes) {
				// 初始化树结构
				tree = $.fn.zTree.init($("#tree"), setting, zNodes);
//                tree.expandAll(true);
				// 默认展开一级节点
				var nodes = tree.getNodesByParam("level", 0);
				for (var i = 0; i < nodes.length; i++) {
					tree.expandNode(nodes[i], true, false, false);
				}
				//异步加载子节点（加载用户）
				var nodesOne = tree.getNodesByParam("isParent", true);
				for (var j = 0; j < nodesOne.length; j++) {
					tree.reAsyncChildNodes(nodesOne[j], "!refresh", true);
				}
				selectCheckNode();
			});
			key = $("#key");
			key.bind("focus", focusKey).bind("blur", blurKey).bind("change cut input propertychange", searchNode);
			key.bind('keydown', function (e) {
				if (e.which == 13) {
					searchNode();
				}
			});
			setTimeout("search();", "300");
		});

		// 默认选择节点
		function selectCheckNode() {
			var ids = "${targetsDj.JDmnr}".split(",");
			for (var i = 0; i < ids.length; i++) {
				var node = tree.getNodeByParam("id", (type == 3 ? "u_" : "") + ids[i]);
				if (!node.isParent) {
					if ("${checked}" == "true") {
						try {
							tree.checkNode(node, true, true);
						} catch (e) {
						}
						tree.selectNode(node, false);
					} else {
						tree.selectNode(node, true);
					}
				}
			}
		}
		function focusKey(e) {
			if (key.hasClass("empty")) {
				key.removeClass("empty");
			}
		}
		function blurKey(e) {
			if (key.get(0).value === "") {
				key.addClass("empty");
			}
			searchNode(e);
		}

		//搜索节点
		function searchNode() {
			// 取得输入的关键字的值
			var value = $.trim(key.get(0).value);

			// 按名字查询
			var keyType = "name";
			<%--
                        if (key.hasClass("empty")) {
                            value = "";
                        }--%>

			// 如果和上次一次，就退出不查了。
			if (lastValue === value) {
				return;
			}

			// 保存最后一次
			lastValue = value;

			var nodes = tree.getNodes();
			// 如果要查空字串，就退出不查了。
			if (value == "") {
				showAllNode(nodes);
				return;
			}
			hideAllNode(nodes);
			nodeList = tree.getNodesByParamFuzzy(keyType, value);
			updateNodes(nodeList);
		}

		//隐藏所有节点
		function hideAllNode(nodes) {
			nodes = tree.transformToArray(nodes);
			for (var i = nodes.length - 1; i >= 0; i--) {
				tree.hideNode(nodes[i]);
			}
		}

		//显示所有节点
		function showAllNode(nodes) {
			nodes = tree.transformToArray(nodes);
			for (var i = nodes.length - 1; i >= 0; i--) {
				/* if(!nodes[i].isParent){
				 tree.showNode(nodes[i]);
				 }else{ */
				if (nodes[i].getParentNode() != null) {
					tree.expandNode(nodes[i], false, false, false, false);
				} else {
					tree.expandNode(nodes[i], true, true, false, false);
				}
				tree.showNode(nodes[i]);
				showAllNode(nodes[i].children);
				/* } */
			}
		}

		//更新节点状态
		function updateNodes(nodeList) {
			tree.showNodes(nodeList);
			for (var i = 0, l = nodeList.length; i < l; i++) {
				//展开当前节点的父节点
				tree.showNode(nodeList[i].getParentNode());
				//tree.expandNode(nodeList[i].getParentNode(), true, false, false);
				//显示展开符合条件节点的父节点
				while (nodeList[i].getParentNode() != null) {
					tree.expandNode(nodeList[i].getParentNode(), true, false, false);
					nodeList[i] = nodeList[i].getParentNode();
					tree.showNode(nodeList[i].getParentNode());
				}
				//显示根节点
				tree.showNode(nodeList[i].getParentNode());
				//展开根节点
				tree.expandNode(nodeList[i].getParentNode(), true, false, false);
			}
		}

		// 开始搜索
		function search() {
			$("#search").slideToggle(200);
			$("#txt").toggle();
			$("#key").focus();
		}

		function setYwIds() {

			var ids = [], names = [], nodes = [];
			nodes = tree.getCheckedNodes(true);

			for (var i = 0; i < nodes.length; i++) {
				if (nodes[i].isParent) {
					continue; // 如果为复选框选择，则过滤掉父节点
				}
				ids.push(nodes[i].id);
				names.push(nodes[i].name);
			}
			$("#by1").val(ids.join(",").replace(/u_/ig, ""));
		}

		$("#no").focus();
		$("#inputForm").validate({
			rules: {
				loginName: {remote: "${ctx}/sys/user/checkLoginName?oldLoginName=" + encodeURIComponent('${user.loginName}')}
			},
			messages: {
				loginName: {remote: "用户登录名已存在"},
				confirmNewPassword: {equalTo: "输入与上面相同的密码"}
			},
			submitHandler: function (form) {
				loading('正在提交，请稍等...');
				form.submit();
			},
			errorContainer: "#messageBox",
			errorPlacement: function (error, element) {
				$("#messageBox").text("输入有误，请先更正。");
				if (element.is(":checkbox") || element.is(":radio") || element.parent().is(".input-append")) {
					error.appendTo(element.parent().parent());
				} else {
					error.insertAfter(element);
				}
			}
		});

	</script>

</head>
<body>
<br>

<form:form id="inputForm" modelAttribute="targetsDj" action="${ctx}/ywgl/targetsDj/savejsinfo" method="post"
		   class="form-horizontal">
	<form:hidden path="id"/>
	<sys:message content="${message}"/>
	<div class="control-group">
		<label class="control-label">受理角色名称：</label>
		<div class="controls">
			<form:input path="jDmmc"  readonly="true"  htmlEscape="false" maxlength="255" class="input-xlarge required"/>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>

	<div class="control-group">
		<label class="control-label">业务数据范围授权:</label>
		<span class="help-inline"><font color="red">默认为部门指定的业务，也可以灵活选定业务授权范围</font> </span>
		<div id="tree" class="ztree"></div>

	</div>
	<form:hidden path="by1"></form:hidden>
	<div class="form-actions">
		<input id="btnSubmit" class="btn btn-primary" type="submit"   value="保 存"/>&nbsp;
		<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
	</div>
</form:form>
</body>

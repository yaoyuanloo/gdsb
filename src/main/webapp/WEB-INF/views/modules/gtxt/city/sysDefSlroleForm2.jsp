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
    <meta name="decorator" content="yhdefault"/>


    <script type="text/javascript">

    var key, lastValue = "", nodeList = [];
    var tree,setting = {
    		view: {selectedMulti: false, dblClickExpand: false}, check: {enable: "true", nocheckInherit: true},
            data: {simpleData: {enable: true, idKey: "id", pIdKey: "pId", rootPId: '0'}},
           
            
        	callback: {
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
        	getTreeData();//获取tree数据
        });
        function getTreeData() {
            $.getJSON("${ctx}/city/dYwinfo/treeDataCheck", function (data) {
            	tree=$.fn.zTree.init($("#mytree"), setting, data);
            	var nodes = tree.getNodesByParam("level", 0);
            	for (var i = 0; i < nodes.length; i++) {
                     tree.expandNode(nodes[i], true, false, false);
                }
            	var nodesOne = tree.getNodesByParam("isParent", true);
                for (var j = 0; j < nodesOne.length; j++) {
                    tree.reAsyncChildNodes(nodesOne[j], "!refresh", true);
                }
                
                selectCheckNode();
            })
        }
        
        
     // 默认选择节点
        function selectCheckNode() {
    	 console.log("tree:"+tree);
            var ids = "${ywIdsRole}".split(",");
            for (var i = 0; i < ids.length; i++) {
                var node = tree.getNodeByParam("id",ids[i]);
                if (!node.isParent) {
                    if ("${checked}" == "true") {
                        try {
                            tree.checkNode(node, true, true,true);
                        } catch (e) {
                        }
                        tree.selectNode(node, true,true);
                    } else {
                        tree.selectNode(node, true,true);
                    }
                }
            }
        }
     
      //搜索节点
        function searchNode() {
            // 取得输入的关键字的值
            var value = $.trim(key.get(0).value);

            // 按名字查询
            var keyType = "name";
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
            $("#ywIds").val(ids.join(","));
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
        
        
        function check(){
        	var name=$("#name").val();
        	if(name==""){
        		alert("用户名不能为空");
        		return false;
        	}
        	
        	if($("#ywIds").val()==""){
        		alert("请勾选权限!");
        		return false;
        	}
        	return true;
        }
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
        <!-- box-header -->
      	 <div class="box-header with-border">
          <h3 class="box-title">
            <div class="dec_1"></div>
         		定制受理角色列表</h3>
           <div class="box-tools pull-right">
            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
          </div>
        </div>
        <!-- box-body -->
        <div class="box-body">
        	<form:form id="inputForm" modelAttribute="gtrole" action="${ctx}/city/gtRole/savedi" method="post" class="form-horizontal" onsubmit="return check()">
        		<form:hidden path="id"/> 
        		<div class="form-group">
           			<label class="span3 control-label"><b class="mr5 red500">*</b>受理角色名称：</label>
           			<div class="span4">
           				 <input type="text" value="${gtrole.name }" class="form-control" name="name" id="name"/>
           			</div>
           			
           			<shiro:hasPermission name="city:gtRole:view"><button type="submit" class="btn yellow">保存</button>&nbsp;</shiro:hasPermission>
                    <button type="button" onclick="history.go(-1)" class="btn gray" id="resetButton">返回</button>
               </div>
               
               <div class="form-group">
           			<label class="span3 control-label"><b class="mr5 red500">*</b>业务数据范围授权:</label>
              		<div class="span5">
           				<font color="red">默认为部门指定的业务，也可以灵活选定业务授权范围</font>
           			</div>
               </div>
              
               <div class="form-group">
               		<label class="span3 control-label"></label>
               		<div class="span4">
           					<div id="mytree" class="ztree"></div>
           					<form:hidden  id="ywIds" path="ywIds"/>
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
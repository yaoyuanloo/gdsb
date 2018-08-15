<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户管理</title>
	<meta name="decorator" content="yhdefault"/>
	<style type="text/css">
	</style>
</head>
<body>
	<sys:message content="${message}"/>
	<div class="wrapper">

    <section class="sub-sidebar">
        <ul id="mytree" class="ztree">
        </ul>
    </section>


    <div class="content-wrapper">
        <!-- Main content -->
        <section class="col-lg-12 main_content">
            <div id="subtabs">
                <ul class="nav nav-tabs maintab" role="tablist">
                    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab"
                                                              data-toggle="tab">用户列表</a></li>
                </ul>
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="home">
                        <div class="box box-default">
                            <div class="box-body">
          						<form class="form-horizontal" name="myform" id="myform" method="post" action="">
						            <div class="form-group">
              <label class="span1 control-label">业务类型：</label>
              <div class="span1-5">
                <select name="show" class="form-control selectpicker">
                  <option value="1">社保基金</option>
                  <option value="0">...</option>
                </select>
              </div>
              <label class="span1 control-label">消息类型：</label>
              <div class="span1-5">
                <select name="show" class="form-control selectpicker">
                  <option value="1">服务指南</option>
                  <option value="0">...</option>
                </select>
              </div>
              <label class="span1 control-label">分组下拉：</label>
              <div class="span2">
                <select class="form-control selectpicker bs-select-hidden" multiple="multiple" data-live-search="true" data-live-search-placeholder="Search" data-actions-box="true">
                  <optgroup label="filter1">
                  <option>option1</option>
                  <option>option2</option>
                  <option>option3</option>
                  <option>option4</option>
                  </optgroup>
                  <optgroup label="filter2">
                  <option>option1</option>
                  <option>option2</option>
                  <option>option3</option>
                  <option>option4</option>
                  </optgroup>
                  <optgroup label="filter3">
                  <option>option1</option>
                  <option>option2</option>
                  <option>option3</option>
                  <option>option4</option>
                  </optgroup>
                </select>
              </div>
              <div class="span4 pull-right">
                <button type="submit" class="btn btn-sm yellow">查询(F)</button>
                <button type="submit" class="btn btn-sm gray">重置(R)</button>
                <button type="submit" class="btn btn-sm rd">审核</button>
                <button type="submit" class="btn btn-sm rd">删除</button>
                <button type="submit" class="btn btn-sm darkgray">禁用</button>
              </div>
            </div>
            					<table class="table table-bordered table-striped table-hover tablesorter" id="dynamic_pager_content" data-resizable-columns-id="table2">
						              <thead>
						                <tr>
						                  <th data-resizable-column-id=""> 个人编号 </th>
						                  <th data-resizable-column-id=""> 身份证号 </th>
						                  <th data-resizable-column-id=""> 姓名 </th>
						                  <th data-resizable-column-id=""> 性别 </th>
						                  <th data-resizable-column-id=""> 险种名称 </th>
						                  <th data-resizable-column-id=""> 参保身份 </th>
						                  <th data-resizable-column-id=""> 缴费状态 </th>
						                  <th data-resizable-column-id=""> 缴费工资 </th>
						                  <th data-resizable-column-id=""> 通讯地址 </th>
						                  <th data-resizable-column-id=""> 操作 </th>
						                </tr>
						              </thead>
						              <tbody>
						                <tr>
						                  <td> 1 </td>
						                  <td class="number"> 602546 </td>
						                  <td class="number"> 352225198710112512 </td>
						                  <td class="txt"> 测试 </td>
						                  <td> 男 </td>
						                  <td class="txt"> 城镇职工基本医疗保险 </td>
						                  <td class="txt"> 在职人员 </td>
						                  <td class="txt"> 参保缴费 </td>
						                  <td class="rmb"> 3000</td>
						                  <td> 2016-02 </td>
						                </tr>
						              </tbody>
           						 </table>
						            <!--pager-->
						            <div class="row">
						              <div class="span5"> </div>
						              <div class="span7">
						              <div class="pull-right">
						                <div class="pageinfo"> <span class="mr15">共<span class="blue_data mlr5">80</span>条数据 </span>
						                  <div id="dropdown_to_select" class="dropdown itempp"> <span class="btn-group"> <a data-toggle="dropdown" type="button" id="dropdownMenu1" class="btn btn-default btn-xs dropdown-toggle"><span class="placeholder">8</span></a>
						                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
						                      <li role="presentation" value="1"><a role="menuitem" href="javascript:void(0);">5</a></li>
						                      <li role="presentation" value="2"><a role="menuitem" href="javascript:void(0);">10</a></li>
						                      <li role="presentation" value="3"><a role="menuitem" href="javascript:void(0);">15</a></li>
						                      <li role="presentation" value="4"><a role="menuitem" href="javascript:void(0);">20</a></li>
						                    </ul>
						                    </span> </div>
						                  <span class="mr15">条/页</span> <span class="mr5">1/10</span> </div>
						                <span id="page_selection"></span> 
						                </div>
						                 </div>
						            </div>
						            <!--pager./-->
         						 </form>
        					</div>
                        </div>
                    </div>
                </div>

            </div>
        </section>
    </div>
</div>
	<script type="text/javascript">
		var setting = {data:{simpleData:{enable:true,idKey:"id",pIdKey:"pId",rootPId:'0'}},
			callback:{onClick:function(event, treeId, treeNode){
					var id = treeNode.id == '0' ? '' :treeNode.id;
					$('#organizationContent').attr("src","${ctx}/sys/user/listDjUser?Office.id="+id+"&office.name="+treeNode.name);
					Addtabs.add({
                        id: id,
                        title: "定义 " + treeNode.name + " 业务属性",
                        url: '${ctx}/city/dYwinfo/ywsxn?id=' + id
//                        ajax: true
                    });
				}
			}
		};
		  //点击菜单打开标签
	    $("#subtabs").addtabs({
	        monitor: ".ztree"
	    });
		function refreshTree(){
			$.getJSON("${ctx}/sys/office/treeDatadi",function(data){
				$.fn.zTree.init($("#mytree"), setting, data).expandAll(true);
			});
		}
		refreshTree();
		 
		var leftWidth = 260; // 左侧窗口大小
		var htmlObj = $("html"), mainObj = $("#main");
		var frameObj = $("#left, #openClose, #right, #right iframe");
		function wSize(){
			var strs = getWindowSize().toString().split(",");
			htmlObj.css({"overflow-x":"hidden", "overflow-y":"hidden"});
			mainObj.css("width","auto");
			frameObj.height(strs[0] - 5);
			var leftWidth = ($("#left").width() < 0 ? 0 : $("#left").width());
			$("#right").width($("#content").width()- leftWidth - $("#openClose").width() -5);
			$(".ztree").width(leftWidth - 10).height(frameObj.height() - 46);
		}
	</script>
	<script src="${ctxStatic}/common/wsize.min.js" type="text/javascript"></script>
</body>
</html>
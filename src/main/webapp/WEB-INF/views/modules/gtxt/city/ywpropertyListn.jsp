<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>地级市业务分类管理</title>
    <meta name="decorator" content="yhdefault"/>
</head>
<body>
<%--<div class="accordion-heading">--%>
<%--<a class="accordion-toggle">定义 <span style="color: red;">${dyw.pywinfo.name}</span> 业务属性<i--%>
<%--class="icon-refresh pull-right"></i></a>--%>
<%--</div>--%>

<!--业务信息-->
<sys:message content="${message}"/>
<div class="box box-default">
    <!-- box-header -->
    <div class="box-header with-border">
        <h3 class="box-title">
            <div class="dec_1"></div>
            业务信息
        </h3>
        <div class="box-tools pull-right">
            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
        </div>
    </div>
    <!-- box-body -->
    <div class="box-body">
        <form class="form-horizontal" id="ywInfoFrom" method="post" action="${ctx}/city/dYwinfo/ywInfoSaven">
            <input id="ywid" type="hidden" name="ywid" value="${ywid}"/>
            <div class="form-group">
                <label class="span2 control-label">功能代码：</label>
                <div class="span2">
                    <input type="text" class="form-control" disabled="disabled" value=" ${dyw.pywinfo.code}"/>
                </div>
                <label class="span2 control-label">业务名称：</label>
                <div class="span2">
                    <input type="text" class="form-control" disabled="disabled" value="${dyw.pywinfo.name}"/>
                </div>
                <label class="span2 control-label">业务审核流转方式：</label>
                <div class="span2">
                    <input type="text" class="form-control" disabled="disabled" value="${dYwatter.lzfscode}"/>
                </div>
            </div>

            <div class="form-group">
                <label class="span2 control-label">审核级别：</label>
                <div class="span2">
                    <input type="text" class="form-control" value="${dYwatter.shjbcode}" disabled="disabled"/>
                </div>
                <label class="span2 control-label">主流程方式：</label>
                <div class="span2">
                    <input type="text" class="form-control" name=" " disabled="disabled"
                           value="${dYwatter.lzfscode}"/>
                </div>
                <label class="span2 control-label"><b class="mr5 red500">*</b>有效状态：</label>
                <div class="span2">
                    <select id="ywstate" name="state" class="form-control selectpicker">
                        <option value="0">启用</option>
                        <option value="1">停用</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="span2 control-label"><b class="mr5 red500">*</b>业务内容：</label>
                <div class="span10">
                    <textarea rows="2" class="form-control tip" id="ywnr" name="ywnr"
                              placeholder="最多输入500字">${dyw.conment}</textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="span2 control-label"><b class="mr5 red500">*</b>工作日：</label>
                <div class="span2">
                    <input type="text" placeholder="请输入工作日" MAXLENGTH="10" SIZE="10" class="form-control" id="gzr"
                           name="gzr" value="${dyw.day}"/>
                </div>
                <label class="span2 control-label"><b class="mr5 red500">*</b>备注：</label>
                <div class="span2">
                    <input type="text" placeholder="请输入备注" class="form-control" id="bz" name="bz"
                           value="${dyw.remarks}"/>
                </div>
                <div class="col-sm-offset-2 span2">
                    <button type="submit" class="btn yellow" id="ywnrSubmit">保存</button>
                </div>
            </div>
        </form>
    </div>
</div>


<!--绑定材料-->
<div class="box box-default">
    <!-- box-header -->
    <div class="box-header with-border">
        <h3 class="box-title">
            <div class="dec_1"></div>
            绑定材料
        </h3>
        <div class="box-tools pull-right">
            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
        </div>
    </div>
    <div class="box-body">
        <div class="form-horizontal">
            <div class="form-group">
                <label class="span4 control-label">该业务已设定<strong
                        style="color: red">
                    <c:if test="${empty ywclcount}">
                        0
                    </c:if>${ywclcount}项</strong>材料您可以进行</label>
                <form id="assignRoleForm" action="${ctx}/city/dYwinfo/clsaven" method="post"
                      class="hide">
                    <input id="idsArr" type="hidden" name="idsArr" value=""/>
                    <input id="ywcode" type="hidden" name="ywcode" value="${dyw.id}"/>
                    <input id="ywid" type="hidden" name="ywid" value="${ywid}"/>
                </form>
                <div class="span4">
                    <button id="assignButton" type="submit" class="btn yellow">编辑主材料</button>
                </div>
            </div>
            <form id="ywsettingForm" action="${ctx}/city/dYwinfo/saveYwlzfsn" method="post">
                <input type="hidden" name="id" value="${ywid}"/>
                <input id="jRevi" type="hidden" name="jRevi" value=""/>
                <input id="jAss" type="hidden" name="jAss" value=""/>
                <input id="jClass" type="hidden" name="jClass" value=""/>
                <input id="jReviZe" type="hidden" name="jReviZe" value=""/>
            </form>

            <div class="form-group" id="mytable" style="margin-top:10px">
                <table id="" class="table table-bordered table-striped table-hover span12">
                    <thead>
                    <tr>
                        <th>材料编号</th>
                        <th>材料名称</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listPMInfo}" var="mymap">
                        <tr>
                            <td><c:out value="${mymap.code}"/></td>
                            <td><c:out value="${mymap.name}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- 设定流转方式-->
<div class="box box-default">
    <!-- box-header -->
    <div class="box-header with-border">
        <h3 class="box-title">
            <div class="dec_1"></div>
            设定流转方式
        </h3>
        <div class="box-tools pull-right">
            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
        </div>
    </div>
    <div class="box-body">
        <div class="form-horizontal">
            <div class="form-group">
                <form:form id="inputForm" modelAttribute="dYwatter" action="${ctx}/city/dYwinfo/saveYwlzfsn"
                           method="post" class="form-horizontal">

                <form:hidden path="ywid" value="${ywid}"/>
                <label class="span2 control-label">业务流转方式：</label>
                <div class="span2">
                    <form:select id="jReviis" path="lzfscode" class="form-control selectpicker">
                        <form:option value="" label="请选择"/>
                        <form:options items="${fns:getDictList('ywlzfs')}" itemLabel="label"
                                      itemValue="value" htmlEscape="false"/>
                    </form:select>
                </div>

                <label class="span2 control-label">主流程方式：</label>
                <div class="span2">
                    <form:select id="jAssis" path="flowcode" class=" form-control selectpicker">
                        <form:option value="" label="请选择"/>
                        <form:options items="${fns:getDictList('yw_zlfcs')}" itemLabel="label"
                                      itemValue="value" htmlEscape="false"/>
                    </form:select>
                </div>
                <label class="span2 control-label">业务审核级别：</label>
                <div class="span2">
                    <form:select id="jClassis" path="shjbcode" class="form-control selectpicker">
                        <form:option value="" label="请选择"/>
                        <form:options items="${fns:getDictList('ywshfs')}" itemLabel="label"
                                      itemValue="value" htmlEscape="false"/>
                    </form:select>
                </div>
            </div>
            <div class="form-group">
                <label class="span2 control-label">设定人员：</label>
                <div class="span2">
                    <div class="input-group">
                        <input id="jReviZeis" class="form-control" placeholder="请选择一级审核人员列表"
                               disabled="disabled"/>
                        <input id="userList" name="userList" value="" hidden="hidden"/>
                        <span class="input-group-btn">
                      <button type='button' name='search' id='searchUserListbtn' class="btn btn-flat">
                      <i class="fa fa-search"></i></button>
                      </span>
                    </div>
                        <%--assignButton--%>
                        <%--<sys:treeselect id="jReviZeis" checked="true" name="userList"--%>
                        <%--value=""--%>
                        <%--labelName=""--%>
                        <%--labelValue=""--%>
                        <%--title="一级审核员列表" url="/sys/office/treeDataUser?type=2"--%>
                        <%--allowClear="true" notAllowSelectParent="true"/>--%>
                </div>
                <div class="col-sm-offset-2 span2">
                    <input id="sdlzfssubmitbtn" class="btn yellow" type="submit" value="保 存"/>
                </div>
            </div>
            <div class="form-group">

            </div>
            <div class="form-group">
                负责人员列表
                <table id="contentTable" class="table table-bordered table-striped table-hover">
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
                </table>

                </form:form>

            </div>
        </div>
    </div>
</div>


<!-- 打印事项 -->
<div class="box box-default">
    <!-- box-header -->
    <div class="box-header with-border">
        <h3 class="box-title">
            <div class="dec_1"></div>
            打印事项
        </h3>
        <div class="box-tools pull-right">
            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
        </div>
    </div>
    <!-- box-body -->
    <div class="box-body">
        <form class="form-horizontal" name="wenshuForm"
              id="wenshuForm" method="post"
              action="${ctx}/city/dYwatter/savedin">
            <input name="ywid" value="${ywid}" hidden="hidden"/>
            <div class="form-group">
                <label class="span2 control-label">打印事项：</label>
                <div class="span6">
                    <div class="checkbox-list">
                        <label class="checkbox-inline">
                            <input type="checkbox" id="issjhz" name="issjhz" value="${dYwatter.issjhz}">
                            打印回执 </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" id="isbb" name="isbb" value="${dYwatter.isbb}">
                            打印报表 </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" id="isjds" name="isjds" value="${dYwatter.isjds}">
                            答应决定书 </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="form-group hzdctrl" style="display: none;">
                    <label class="span2 control-label">受理回执单模板:</label>
                    <input id="slTempidselect" value="${dYwatter.slTempid}" hidden="hidden"/>
                    <div class="span2">
                        <select id="slTempid" name="slTempid" class="form-control selectpicker">
                        </select>
                        <%--<sys:treeselect id="slTempid" name="slTempid"--%>
                        <%--value="${dYwatter.slTempid}"--%>
                        <%--labelName="${gtxt:getMOName(dYwatter.slTempid)}"--%>
                        <%--labelValue="${gtxt:getMOName(dYwatter.slTempid)}"--%>
                        <%--title="受理回执单模板" url="/city/dWrittempinfo/json"--%>
                        <%--cssClass="input-small" allowClear="true"--%>
                        <%--notAllowSelectParent="false"/>--%>
                    </div>
                    <%--</div>--%>
                    <%--<div class="form-group hzdctrl" style="display: none;">--%>
                    <label class="span2 control-label">收件回执单模板:</label>
                    <input id="sjTempidselect" value="${dYwatter.sjTempid}" hidden="hidden"/>
                    <div class="span2">
                        <select id="sjTempid" name="sjTempid" class="form-control selectpicker">
                        </select>
                        <%--<sys:treeselect id="sjTempid" name="sjTempid"--%>
                        <%--value="${dYwatter.sjTempid}" labelName=""--%>
                        <%--labelValue="${gtxt:getMOName(dYwatter.sjTempid)}"--%>
                        <%--title="收件回执单模板" url="/city/dWrittempinfo/json"--%>
                        <%--cssClass="input-small" allowClear="true"--%>
                        <%--notAllowSelectParent="false"/>--%>
                    </div>
                    <%--</div>--%>
                    <%--<div class="form-group hzdctrl" style="display: none;">--%>
                    <label class="span2 control-label">补齐材料单模板:</label>
                    <input id="bqTempidselect" value="${dYwatter.bqTempid}" hidden="hidden"/>
                    <div class="span2">
                        <select id="bqTempid" name="bqTempid" class="form-control selectpicker">
                        </select>
                        <%--<form:select id="bqTempid" path="bqTempid" class="form-control selectpicker">--%>
                        <%--<form:option value="" label="请选择"/>--%>
                        <%--<form:options items="${fns:getDictList('ywlzfs')}" itemLabel="label"--%>
                        <%--itemValue="value" htmlEscape="false"/>--%>
                        <%--</form:select>--%>
                        <%--<sys:treeselect id="bqTempid" name="bqTempid"--%>
                        <%--value="${dYwatter.bqTempid}" labelName=""--%>
                        <%--labelValue="${gtxt:getMOName(dYwatter.bqTempid)}"--%>
                        <%--title="补齐材料单模板" url="/city/dWrittempinfo/json"--%>
                        <%--cssClass="input-small" allowClear="true"--%>
                        <%--notAllowSelectParent="false"/>--%>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="form-group baobiaoctrl" style="display: none;">
                    <label class="span2 control-label">报表模板:</label>
                    <input id="bqTempidselect" value="${dYwatter.bqTempid}" hidden="hidden"/>
                    <div class="span2">
                        <select id="bbTempid" name="bbTempid" class="form-control selectpicker">
                        </select>
                        <%--<sys:treeselect id="bbTempid" name="bbTempid"--%>
                        <%--value="${dYwatter.bbTempid}" labelName=""--%>
                        <%--labelValue="${gtxt:getMOName(dYwatter.bqTempid)}"--%>
                        <%--title="报表模板" url="/city/dWrittempinfo/json"--%>
                        <%--cssClass="input-small" allowClear="true"--%>
                        <%--notAllowSelectParent="false"/>--%>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <%--<div class="form-group">--%>
                <div class="span2 col-sm-offset-2 ">
                    <button id="wenshuFormbtn" type="button" class="btn yellow">保存</button>
                </div>

            </div>
        </form>
    </div>
</div>


<!-- 打印事项 -->
<div class="box box-default">
    <!-- box-header -->
    <div class="box-header with-border">
        <h3 class="box-title">
            <div class="dec_1"></div>
            查询标签
        </h3>
        <div class="box-tools pull-right">
            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
        </div>
    </div>
    <!-- box-body -->
    <div class="box-body">
        <form class="form-horizontal" name="myform" id="myform" method="post" action="${ctx}/city/dYwatter/savetabn">
            <input id="ywid" name="ywid" value="${ywid}" type="hidden"/>
            <div class="form-group">
                <label class="span2 control-label">查询标签页：</label>
                <div class="span6">
                    <select id="cxbq" name="tabid" class="form-control selectpicker dropup" multiple
                            data-selected-text-format="count>5" data-size="10">
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 span10">
                    <button id="btnSubmit" type="submit" class="btn yellow">保存</button>
                </div>
            </div>
        </form>

        <div class="form-group">
            负责人员列表
            <table id="contentTable" class="table table-bordered table-striped table-hover span12">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>查询标签</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${tabList}" var="tab" varStatus="stat">
                    <tr>
                        <td> ${stat.index}</td>
                        <td>${fns:getDictLabel(tab.querytagid.value,"yw_tag",'' )} </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script type="text/javascript">
    var changeBoo = false;
    $(document).ready(function () {
        $("input").change(function () {
            changeBoo = true;
        });

        initCheckBox();

        $("#ywstate option[value=${dyw.state}]").attr("selected", true);

    });

    function initCheckBox() {
        $("input[type='checkbox']").each(function (i, e) {
            if (e.value == 1) {//
                this.checked = true;
                if (e.id == "issjhz") {
                    $(".hzdctrl").fadeIn();
                }
                if (e.id == "isbb") {
                    $(".baobiaoctrl").fadeIn();
                }
            }
        });
        $('input').iCheck({
            checkboxClass: 'icheckbox_square_gd',
            radioClass: 'iradio_square_gd',
            increaseArea: '20%' // optional
        });
    }
    //打印回执
    $('#issjhz').on('ifChecked', function () {
        $(".hzdctrl").fadeIn();
    });
    $('#issjhz').on('ifUnchecked', function () {
        $(".hzdctrl").fadeOut();
    });
    //打印报表
    $('#isbb').on('ifChecked', function () {
        $(".baobiaoctrl").fadeIn();
    });
    $('#isbb').on('ifUnchecked', function () {
        $(".baobiaoctrl").fadeOut();
    });

    //打印回执下拉框:1.受理回执单模板
    $("#slTempid").on('loaded.bs.select', function () {
        $.ajax({
            type: 'GET',
            url: '${ctx}/city/dWrittempinfo/json',
            success: function (data) {
                var data = eval(data);
                $.each(data, function (i) {
                    if ($("#slTempidselect").val() == data[i].id) {
                        $("<option value='" + data[i].id + "' selected>" + data[i].name + "</option>").appendTo("#slTempid");
                    } else {
                        $("<option value='" + data[i].id + "'>" + data[i].name + "</option>").appendTo("#slTempid");
                    }
                });
                $('#slTempid').selectpicker('refresh');
            }
        });
    });

    //打印报表下拉框:2.收件回执单模板
    $("#sjTempid").on('loaded.bs.select', function () {
        $.ajax({
            type: 'GET',
            url: '${ctx}/city/dWrittempinfo/json',
            success: function (data) {
                var data = eval(data);
                $.each(data, function (i) {
                    if ($("#sjTempidselect").val() == data[i].id) {
                        $("<option value='" + data[i].id + "' selected>" + data[i].name + "</option>").appendTo("#sjTempid");
                    } else {
                        $("<option value='" + data[i].id + "'>" + data[i].name + "</option>").appendTo("#sjTempid");
                    }
                });
                $('#sjTempid').selectpicker('refresh');
            }
        });
    })

    //答应决定书下拉框:3.补齐材料单模板
    $("#bqTempid").on('loaded.bs.select', function () {
        $.ajax({
            type: 'GET',
            url: '${ctx}/city/dWrittempinfo/json',
            success: function (data) {
                var data = eval(data);
                $.each(data, function (i) {
                    if ($("#bqTempidselect").val() == data[i].id) {
                        $("<option value='" + data[i].id + "' selected>" + data[i].name + "</option>").appendTo("#bqTempid");
                    } else {
                        $("<option value='" + data[i].id + "'>" + data[i].name + "</option>").appendTo("#bqTempid");
                    }
                });
                $('#bqTempid').selectpicker('refresh');
            }
        });
    })

    //打印报表 1.报表模板:
    $("#bbTempid").on('loaded.bs.select', function () {
        $.ajax({
            type: 'GET',
            url: '${ctx}/city/dWrittempinfo/json',
            success: function (data) {
                var data = eval(data);
                $.each(data, function (i) {
                    if ($("#bbTempidselect").val() == data[i].id) {
                        $("<option value='" + data[i].id + "' selected>" + data[i].name + "</option>").appendTo("#bbTempid");
                    } else {
                        $("<option value='" + data[i].id + "'>" + data[i].name + "</option>").appendTo("#bbTempid");
                    }
                });
                $('#bbTempid').selectpicker('refresh');
            }
        });
    })

    $("#wenshuFormbtn").click(function () {
//            $("#issjhz").checked
//            console.log($("#issjhz").checked('check'));
//            if ($("#issjhz").val() == 0) {
//
//            }
//            if ($("#isbb").val() == 0) {
//
//            }
//            if ($("#issjhz").val() == 0) {
//
//            }
        $('#wenshuForm').submit();
    });


    //查询标签多选下拉框:
    $("#cxbq").on('loaded.bs.select', function () {
        $.ajax({
            type: 'GET',
            url: '${ctx}/city/dWrittempinfo/treeData?type=yw_tag',
            success: function (data) {
                var data = eval(data);
                $.each(data, function (i) {
                    $("<option value='" + data[i].id + "'>" + data[i].name + "</option>").appendTo("#cxbq");
                });
                $('#cxbq').selectpicker('refresh');
            }
        });
    });

    $("#searchUserListbtn").click(function () {
        BootstrapDialog.show({
//            size: BootstrapDialog.SIZE_LARGE,
            title: '一级审核员列表',
            message: $('<div></div>').load('${ctx}/city/dYwinfo/ztreeData'),
            buttons: [{
                label: '确定',
                action: function (dialogRef) {
                    var treeObj = $.fn.zTree.getZTreeObj("mydatatree");
                    var nodes = treeObj.getCheckedNodes(true);
//                    console.log(nodes);
                    var userList = "";
                    var names = "";
                    for (var i = 0; i < nodes.length; i++) {
//                        nodes[i].id;
//                        names += nodes[i].name;
                        if (!nodes[i].isParent) {//只拿子节点
                            names += nodes[i].name + " ";
                            userList += nodes[i].id + ",";
//                            console.log(nodes[i].name);
//                            $('#jReviZeis').val(nodes[i].name);
                        }
                    }
                    $('#jReviZeis').val(names);//name显示
                    $('#userList').val(userList);//写入隐藏域
//                    console.log(userList);
                    dialogRef.close();
                }
            }, {
                label: '取消',
                action: function (dialogRef) {
                    dialogRef.close();
                }
            }]
        });

//        $("#sdlzfssubmitbtn").click(function () {
//
//        });

    });


</script>


<script type="text/javascript">

    function dyhzd() {

        $('#jRevi').val(jRevi);
        $('#jAss').val(jAss);
        $('#jReviZe').val(jReviZe);
        $('#jClass').val(jClass);
        $('#ywsettingForm').submit();
    }

    $("#lzfsButton").click(function () {
        top.$.jBox.open("iframe:${ctx}/city/dYwinfo/ylout?ywid=${ywid}", "设定流转方式", 800,
                600, {
                    buttons: {"确定保存": "ok", "关闭": true},
                    bottomText: "设定该业务的流转方式",
                    submit: function (v, h, f) {
                        var jRevi = h.find("iframe")[0].contentWindow.$("#jReviis").val();
                        var jAss = h.find("iframe")[0].contentWindow.$("#jAssis").val();
                        var jClass = h.find("iframe")[0].contentWindow.$("#jClassis").val();
                        var jReviZe = h.find("iframe")[0].contentWindow.$("#jReviZeisId").val();
                        if (v == "ok") {
                            $('#jRevi').val(jRevi);
                            $('#jAss').val(jAss);
                            $('#jReviZe').val(jReviZe);
                            $('#jClass').val(jClass);
                            $('#ywsettingForm').submit();
                            return true;
                        }
                    },
                    loaded: function (h) {
                        $(".jbox-content", top.document).css("overflow-y", "hidden");
                    }
                });
    });

</script>
<script type="text/javascript">
    $("#assignButton").click(function () {
        var ywid = $("#ywid").val();
        var clcode = $("#ywcode").val();
        BootstrapDialog.show({
            title: 'More dialog sizes',
            message: 'Hi Apple!',
            buttons: [{
                label: 'Normal',
                action: function (dialog) {
                    dialog.setTitle('Normal');
                    dialog.setSize(BootstrapDialog.SIZE_NORMAL);
                }
            }, {
                label: 'Small',
                action: function (dialog) {
                    dialog.setTitle('Small');
                    dialog.setSize(BootstrapDialog.SIZE_SMALL);
                }
            }, {
                label: 'Wide',
                action: function (dialog) {
                    dialog.setTitle('Wide');
                    dialog.setSize(BootstrapDialog.SIZE_WIDE);
                }
            }, {
                label: 'Large',
                action: function (dialog) {
                    dialog.setTitle('Large');
                    dialog.setSize(BootstrapDialog.SIZE_LARGE);
                }
            }]
        });
        <%--top.$.jBox.open("iframe:${ctx}/city/dYwinfo/ywcaiLiao?clcode=" + clcode, "编辑材料", 1336, $(top.document).height() - 50, {--%>
        <%--buttons: {"确定分配": "ok", "清除已选": "clear", "关闭": true},--%>
        <%--bottomText: "通过选择材料类别，然后为列出所有材料进行分配材料。",--%>
        <%--submit: function (v, h, f) {--%>
        <%--var pre_ids = h.find("iframe")[0].contentWindow.pre_ids;--%>

        <%--var ids = h.find("iframe")[0].contentWindow.ids;--%>
        <%--//nodes = selectedTree.getSelectedNodes();--%>
        <%--if (v == "ok") {--%>
        <%--// 删除''的元素--%>
        <%--if (ids[0] == '') {--%>
        <%--ids.shift();--%>
        <%--pre_ids.shift();--%>
        <%--}--%>
        <%--if (pre_ids.sort().toString() == ids.sort().toString()) {--%>
        <%--top.$.jBox.tip("未给角色【】分配新成员！", 'info');--%>
        <%--return false;--%>
        <%--}--%>
        <%--;--%>

        <%--var idsArr = "";--%>
        <%--for (var i = 0; i < ids.length; i++) {--%>
        <%--idsArr = (idsArr + ids[i]) + (((i + 1) == ids.length) ? '' : ',');--%>
        <%--}--%>


        <%--// 执行保存--%>
        <%--$('#idsArr').val(idsArr);--%>

        <%--$('#assignRoleForm').submit();--%>
        <%--return true;--%>
        <%--} else if (v == "clear") {--%>
        <%--h.find("iframe")[0].contentWindow.clearAssign();--%>
        <%--return false;--%>
        <%--}--%>
        <%--},--%>
        <%--loaded: function (h) {--%>
        <%--$(".jbox-content", top.document).css("overflow-y", "hidden");--%>
        <%--}--%>
        <%--});--%>
    });


    $("#dy").click(function () {
        $('#ywInfoFrom').submit();
    });

    $("#qy").click(function () {
        $('#ywInfoFrom').submit();
    });


    $("#assignTiaoJianButton").click(function () {
        var ywid = $("#ywid").val();
        var clcode = $("#ywcode").val();
        alert();
        top.$.jBox.open("iframe:${ctx}/city/dYwinfo/ywtianjian?clcode=" + clcode, "编辑条件", 810, $(top.document).height() - 240, {
            buttons: {"确定分配": "ok", "清除已选": "clear", "关闭": true},
            bottomText: "通过选择条件类别，然后为列出所有条件进行绑定。",
            submit: function (v, h, f) {
                var pre_ids = h.find("iframe")[0].contentWindow.pre_ids;
                var ids = h.find("iframe")[0].contentWindow.ids;
                if (v == "ok") {
                    // 删除''的元素
                    if (ids[0] == '') {
                        ids.shift();
                        pre_ids.shift();
                    }
                    if (pre_ids.sort().toString() == ids.sort().toString()) {
                        top.$.jBox.tip("未给绑定！", 'info');
                        return false;
                    }
                    ;

                    var idsArr = "";
                    for (var i = 0; i < ids.length; i++) {
                        idsArr = (idsArr + ids[i]) + (((i + 1) == ids.length) ? '' : ',');
                    }
                    // 执行保存

                    $('#idsArrs').val(idsArr);
                    $('#assignTiaojForm').submit();
                    return true;
                } else if (v == "clear") {
                    h.find("iframe")[0].contentWindow.clearAssign();
                    return false;
                }
            },
            loaded: function (h) {
                $(".jbox-content", top.document).css("overflow-y", "hidden");
            }
        });
    });


    $("#conditionidButton").click(function () {
        var conditionid = $("#conditionid").val();
        top.$.jBox.open("iframe:${ctx}/city/dYwinfo/tjcailiao?conditionid=" + conditionid, "编辑材料", 810, $(top.document).height() - 240, {
            buttons: {"确定分配": "ok", "清除已选": "clear", "关闭": true},
            bottomText: "通过选择条件类别，然后为列出所有条件进行绑定。",
            submit: function (v, h, f) {
                var pre_ids = h.find("iframe")[0].contentWindow.pre_ids;
                var ids = h.find("iframe")[0].contentWindow.ids;
                if (v == "ok") {
                    // 删除''的元素
                    if (ids[0] == '') {
                        ids.shift();
                        pre_ids.shift();
                    }
                    if (pre_ids.sort().toString() == ids.sort().toString()) {
                        top.$.jBox.tip("未给绑定！", 'info');
                        return false;
                    }
                    ;

                    var idsArr = "";
                    for (var i = 0; i < ids.length; i++) {
                        idsArr = (idsArr + ids[i]) + (((i + 1) == ids.length) ? '' : ',');
                    }
                    // 执行保存

                    $('#idsArrstj').val(idsArr);
                    $('#conditionidFrom').submit();
                    return true;
                } else if (v == "clear") {
                    h.find("iframe")[0].contentWindow.clearAssign();
                    return false;
                }
            },
            loaded: function (h) {
                $(".jbox-content", top.document).css("overflow-y", "hidden");
            }
        });
    });
</script>

</div>


<script type="text/javascript">//<!-- 无框架时，左上角显示菜单图标按钮。
if (!(self.frameElement && self.frameElement.tagName == "IFRAME")) {
    $("body").prepend("<i id=\"btnMenu\" class=\"icon-th-list\" style=\"cursor:pointer;float:right;margin:10px;\"></i><div id=\"menuContent\"></div>");
    $("#btnMenu").click(function () {
        top.$.jBox('get:/psd/admin/sys/menu/treeselect;JSESSIONID=d6027716e1e24831a36365d8cf980a35', {
            title: '选择菜单',
            buttons: {'关闭': true},
            width: 300,
            height: 350,
            top: 10
        });
        //if ($("#menuContent").html()==""){$.get("/psd/admin/sys/menu/treeselect", function(data){$("#menuContent").html(data);});}else{$("#menuContent").toggle(100);}
    });
}//-->
</script>
</body>
</html>
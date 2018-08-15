<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>地级市业务分类管理</title>
    <meta name="decorator" content="default"/>
</head>
<body>
<div class="accordion-heading">
    <a class="accordion-toggle">定义 <span style="color: red;">${dyw.pywinfo.name}</span> 业务属性<i
            class="icon-refresh pull-right"></i></a>
</div>
<sys:message content="${message}"/>
<div class="setting-page">
    <div class="control-group">
        <div class="controls">
            <div id="baseCollapse" class="accordior-body">
                <ul id="myTab" class="nav nav-tabs">
                    <li class="active">
                        <a href="#home" data-toggle="tab">
                            业务信息
                        </a>
                    </li>
                    <li><a href="#ios" data-toggle="tab">绑定材料</a></li>
                    <%--       <li><a href="#tj" data-toggle="tab">绑定条件</a></li>--%>
                    <li><a href="#lzfs" data-toggle="tab">设定流转方式</a></li>
                    <li><a href="#dysx" data-toggle="tab">打印事项</a></li>
                    <!--  <li><a href="#slfs"    data-toggle="tab">受理方式</a></li> -->
                    <li><a href="#cxbq" data-toggle="tab">查询标签页</a></li>
                </ul>
                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade in active" id="home">
                        <form action="${ctx}/city/dYwinfo/ywInfoSave" id="ywInfoFrom" method="post">
                            <input id="ywid" type="hidden" name="ywid" value="${ywid}"/>
                            <table id="baseTable" class="table table-bordered table-condensed"
                                   style="margin-bottom: 0;">
                                <tr>
                                    <td style="width:120px;color: black;font-weight:bold">
                                        功能代码
                                    </td>
                                    <td>
                                        ${dyw.pywinfo.code}
                                    </td>
                                    <td style="width:80px;color: black;font-weight: bold">
                                        业务名称
                                    </td>
                                    <td colspan="5">
                                        ${dyw.pywinfo.name}
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:120px;color: black;font-weight: bold">
                                        业务审核流转方式
                                    </td>
                                    <td>
                                        ${dYwatter.lzfscode}
                                    </td>
                                    <td style="width:80px;color: black;font-weight: bold">
                                        审核级别
                                    </td>
                                    <td>
                                        ${dYwatter.shjbcode}
                                    </td>
                                    <td style="width:80px;color: black;font-weight: bold">
                                        主流程方式
                                    </td>
                                    <td>
                                        ${dYwatter.lzfscode}
                                    </td>
                                    <td style="width:80px;color: black;font-weight: bold">
                                        有效状态
                                    </td>
                                    <td>
                                        <select id="ywstate" name="state">
                                            <option value="0">启用</option>
                                            <option value="1">停用</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="color: black;font-weight: bold">
                                        业务内容
                                    </td>
                                    <td colspan="7">
                                        <textarea style="resize:none;width:95%;" id="ywnr" name="ywnr"
                                                  rows="5">${dyw.conment}</textarea>
                                    </td>

                                </tr>
                                <tr>
                                    <td style="color: black;font-weight: bold">
                                        工作日
                                    </td>
                                    <td colspan="7">
                                        <input id="gzr" name="gzr" MAXLENGTH="10" SIZE="10" type="text"
                                               value="${dyw.day}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="color: black;font-weight: bold">
                                        备注
                                    </td>
                                    <td colspan="7">
                                        <input id="bz" name="bz" type="text" value="${dyw.remarks}"/>
                                    </td>
                                </tr>
                            </table>
                            <input id="ywnrSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
                        </form>
                    </div>
                    <div class="tab-pane fade" id="ios">
                        <!--内容项-->
                        <div class="control-group">
                            <div class="controls">
                                <label class="control-label"><strong>该业务已设定<strong
                                        style="color: red">${ywclcount}项</strong>材料您可以进行</strong></label>
                                <form id="assignRoleForm" action="${ctx}/city/dYwinfo/clsave" method="post"
                                      class="hide">
                                    <input id="idsArr" type="hidden" name="idsArr" value=""/>
                                    <input id="ywcode" type="hidden" name="ywcode" value="${dyw.id}"/>
                                    <input id="ywid" type="hidden" name="ywid" value="${ywid}"/>
                                </form>
                                <input id="assignButton" class="btn btn-primary" type="submit" value="编辑主材料"/>
                            </div>
                        </div>

                        <form id="ywsettingForm" action="${ctx}/city/dYwinfo/saveYwlzfs" method="post">
                            <input type="hidden" name="id" value="${ywid}"/>
                            <input id="jRevi" type="hidden" name="jRevi" value=""/>
                            <input id="jAss" type="hidden" name="jAss" value=""/>
                            <input id="jClass" type="hidden" name="jClass" value=""/>
                            <input id="jReviZe" type="hidden" name="jReviZe" value=""/>
                        </form>

                        <table id="" class="table table-bordered table-condensed" style="margin-bottom: 0;">
                            <thead>
                            <tr>
                                <th width="20%">材料编号</th>
                                <th>材料名称</th>
                            </tr>

                            <c:forEach items="${listPMInfo}" var="mymap">
                                <tr>
                                    <td width="20%"><c:out value="${mymap.code}"/></td>
                                    <td><c:out value="${mymap.name}"/>　</td>
                                </tr>
                                　　 </c:forEach>
                            </thead>
                        </table>

                    </div>
                    <div class="tab-pane fade" id="tj">
                        <!--内容项-->
                        <div class="control-group">
                            <div class="controls">
                                <label class="control-label"><strong>该业务已设定<strong
                                        style="color: red">${ywtjcount}项</strong>条件您可以进行</strong></label>

                                <form id="assignTiaojForm" action="${ctx}/city/dYwinfo/tjsave" method="post"
                                      class="hide">
                                    <input id="tjcode" type="hidden" name="tjcode" value="${dyw.id}"/>
                                    <input id="ywid" type="hidden" name="ywid" value="${ywid}"/>
                                    <input id="idsArrs" type="hidden" name="idsArr" value=""/>
                                </form>
                                <input id="assignTiaoJianButton" class="btn btn-primary" type="submit" value="编辑条件"/>
                            </div>
                        </div>
                        <form id="conditionidFrom" action="${ctx}/city/dYwinfo/tjcailiaosave" method="post"
                              class="hide">
                            <c:forEach items="${listPCInfo}" var="mymap">
                                <input id="idsArrstj" type="hidden" name="idsArrstj" value=""/>
                                <input id="ywid" type="hidden" name="ywid" value="${ywid}"/>
                                <input type="hidden" name="conditionid" id="conditionid" value="${mymap.id}">
                            </c:forEach>
                        </form>
                        <table id="" class="table table-bordered table-condensed" style="margin-bottom: 0;">
                            <thead>
                            <tr>
                                <th width="20%">条件编号</th>
                                <th>条件名称</th>
                                <th>条件类别</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listPCInfo}" var="mymap">
                                <tr>
                                    <td>
                                            ${mymap.code}
                                    </td>
                                    <td>
                                            ${mymap.name}
                                    </td>
                                    <td>
                                            ${mymap.conment}
                                    </td>
                                    <td>
                                        <input type="hidden" name="conditionid" id="conditionid" value="${mymap.code}">
                                        <a href="#" id="conditionidButton"><input id="assignButtonTJCL"
                                                                                  class="btn btn-primary" type="button"
                                                                                  value="编辑主材料"/></a>
                                    </td>
                                </tr>
                                　　 </c:forEach>
                            </tbody>
                        </table>

                    </div>
                    <div class="tab-pane fade" id="lzfs">
                        <!--内容项-->
                        <div class="control-group">


                            <form:form id="inputForm" modelAttribute="dYwatter" action="${ctx}/city/dYwinfo/saveYwlzfs"
                                       method="post" class="form-horizontal">
                                <table id="contentTable" class="table table-striped table-bordered table-condensed">
                                    <form:hidden path="ywid" value="${ywid}"/>
                                    <tr>
                                        <td>
                                            <label>业务流转方式：</label>
                                        </td>
                                        <td>
                                            <form:select id="jReviis" path="lzfscode" class="input-xlarge">
                                                <form:option value="" label="请选择"/>
                                                <form:options items="${fns:getDictList('ywlzfs')}" itemLabel="label"
                                                              itemValue="value" htmlEscape="false"/>
                                            </form:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>主流程方式：</label>
                                        <td>


                                            <form:select id="jAssis" path="flowcode" class="input-xlarge">
                                                <form:option value="" label="请选择"/>
                                                <form:options items="${fns:getDictList('yw_zlfcs')}" itemLabel="label"
                                                              itemValue="value" htmlEscape="false"/>
                                            </form:select>

                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>业务审核级别：</label>


                                        </td>
                                        <td>
                                            <form:select id="jClassis" path="shjbcode" class="input-xlarge">
                                                <form:option value="" label="请选择"/>
                                                <form:options items="${fns:getDictList('ywshfs')}" itemLabel="label"
                                                              itemValue="value" htmlEscape="false"/>
                                            </form:select>

                                        </td>

                                    </tr>
                                    <tr>
                                        <td>
                                            <label>设定人员：</label>
                                        </td>
                                        <td>
                                                <%-- <sys:treeselect id="jReviZe" name="primaryPerson.id" value="${office.primaryPerson.id}" labelName="office.primaryPerson.name" labelValue="${office.primaryPerson.name}"
                                                  title="用户" url="/sys/office/treeData?type=3" allowClear="true" notAllowSelectParent="true"/> --%>
                                            <sys:treeselect id="jReviZeis" checked="true" name="userList"
                                                            value=""
                                                            labelName=""
                                                            labelValue=""
                                                            title="一级审核员列表" url="/sys/office/treeDataUser?type=2"
                                                            allowClear="true" notAllowSelectParent="true"/>

                                        </td>
                                    <tr>
                                        <td>
                                            <input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>
                                        </td>
                                    </tr>

                                    </tr>
                                </table>


                                负责人员列表
                                <table id="contentTable" class="table table-striped table-bordered table-condensed">
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


                    <div class="tab-pane fade" id="dysx">


                        <form:form id="wenshuForm" modelAttribute="dYwatter" action="${ctx}/city/dYwatter/savedi"
                                   method="post">
                            <form:hidden path="ywid" value="${ywid}"/>
                            <div class="control-group">
                                <div class="controls">
                                    <label class="control-label"><strong>打印事项:</strong></label>
                                    <form:checkbox path="issjhz" label="打印回执" value="1"/>
                                    <form:checkbox path="isbb" label="打印报表" value="1"/>
                                    <form:checkbox path="isjds" label="打印决定书" value="1"/>
                                </div>
                            </div>

                            <div class="control-group hzdctrl" style="display: none;">
                                <label class="control-label"></label>
                                <div class="controls">
                                    <label>受理回执单模板:</label>
                                    <sys:treeselect id="slTempid" name="slTempid"
                                                    value="${dYwatter.slTempid}"
                                                    labelName="${gtxt:getMOName(dYwatter.slTempid)}"
                                                    labelValue="${gtxt:getMOName(dYwatter.slTempid)}"
                                                    title="受理回执单模板" url="/city/dWrittempinfo/json"
                                                    cssClass="input-small" allowClear="true"
                                                    notAllowSelectParent="false"/>
                                </div>
                            </div>
                            <div class="control-group hzdctrl" style="display: none;">
                                <label class="control-label"></label>
                                <div class="controls">
                                    <label>收件回执单模板:</label>
                                    <sys:treeselect id="sjTempid" name="sjTempid"
                                                    value="${dYwatter.sjTempid}" labelName=""
                                                    labelValue="${gtxt:getMOName(dYwatter.sjTempid)}"
                                                    title="收件回执单模板" url="/city/dWrittempinfo/json"
                                                    cssClass="input-small" allowClear="true"
                                                    notAllowSelectParent="false"/>
                                </div>
                            </div>
                            <div class="control-group hzdctrl" style="display: none;">
                                <label class="control-label"></label>
                                <div class="controls">
                                    <label>补齐材料单模板:</label>
                                    <sys:treeselect id="bqTempid" name="bqTempid"
                                                    value="${dYwatter.bqTempid}" labelName=""
                                                    labelValue="${gtxt:getMOName(dYwatter.bqTempid)}"
                                                    title="补齐材料单模板" url="/city/dWrittempinfo/json"
                                                    cssClass="input-small" allowClear="true"
                                                    notAllowSelectParent="false"/>
                                </div>
                            </div>
                            <div class="control-group baobiaoctrl" style="display: none;">
                                <label class="control-label"></label>
                                <div class="controls">
                                    <label>报表模板:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <sys:treeselect id="bbTempid" name="bbTempid"
                                                    value="${dYwatter.bbTempid}" labelName=""
                                                    labelValue="${gtxt:getMOName(dYwatter.bqTempid)}"
                                                    title="报表模板" url="/city/dWrittempinfo/json"
                                                    cssClass="input-small" allowClear="true"
                                                    notAllowSelectParent="false"/>
                                </div>
                            </div>
                            <input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
                        </form:form>
                    </div>


                    <div class="tab-pane fade" id="cxbq">
                        <!--内容项-->
                        <form id="inputFormOks" action="${ctx}/city/dYwatter/savetab" method="post">
                            <div class="control-group">
                                <div class="controls">
                                    <input id="ywid" name="ywid" value="${ywid}" type="hidden"/>
                                    <label class="control-label"><strong>查询标签:</strong></label>
                                    <sys:treeselect id="tabid" name="tabid"
                                                    value="" labelName="" cssStyle="width:500px"
                                                    labelValue=""
                                                    title="受理回执单模板" url="/city/dWrittempinfo/treeData?type=yw_tag"
                                                    cssClass="input-small" allowClear="true" checked="true"
                                                    notAllowSelectParent="false"/>
                                </div>
                            </div>
                            <input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
                        </form>
                        <table id="contentTable" class="table table-striped table-bordered table-condensed">
                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>查询标签</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${tabList}" var="tab" varStatus="stat">
                                <tr>
                                    <td>
                                            ${stat.index}
                                    </td>
                                    <td>
                                            ${fns:getDictLabel(tab.querytagid.value,"yw_tag",'' )}

                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</div>


<script type="text/javascript">
    var changeBoo = false;
    $(document).ready(function () {
        // lzfschange();
        hzdchange();
        bbchange();

        $("input[name='issjhz']").change(function () {
            // lzfschange();
            hzdchange();
        });

        $("input[name='isbb']").change(function () {
            bbchange();
        });
        $("input").change(function () {
            changeBoo = true;
        });

    });


    function hzdchange() {
        if ($("input[name='issjhz']:checked").is(':checked')) {
            $(".hzdctrl").fadeIn();

        } else {
            $(".hzdctrl").fadeOut();
        }
    }

    function bbchange() {
        if ($("input[name='isbb']:checked").is(':checked')) {

            $(".baobiaoctrl").fadeIn();

        } else {
            $(".baobiaoctrl").fadeOut();
        }
    }
    $("#ywstate option[value=${dyw.state}]").attr("selected", true);
</script>


<script type="text/javascript">

    function dyhzd() {

        $("#11_dyHzd").show();

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
        top.$.jBox.open("iframe:${ctx}/city/dYwinfo/ywcaiLiao?clcode=" + clcode, "编辑材料", 1336, $(top.document).height() - 50, {
            buttons: {"确定分配": "ok", "清除已选": "clear", "关闭": true},
            bottomText: "通过选择材料类别，然后为列出所有材料进行分配材料。",
            submit: function (v, h, f) {
                var pre_ids = h.find("iframe")[0].contentWindow.pre_ids;

                var ids = h.find("iframe")[0].contentWindow.ids;
                //nodes = selectedTree.getSelectedNodes();
                if (v == "ok") {
                    // 删除''的元素
                    if (ids[0] == '') {
                        ids.shift();
                        pre_ids.shift();
                    }
                    if (pre_ids.sort().toString() == ids.sort().toString()) {
                        top.$.jBox.tip("未给角色【】分配新成员！", 'info');
                        return false;
                    }
                    ;

                    var idsArr = "";
                    for (var i = 0; i < ids.length; i++) {
                        idsArr = (idsArr + ids[i]) + (((i + 1) == ids.length) ? '' : ',');
                    }


                    // 执行保存
                    $('#idsArr').val(idsArr);

                    $('#assignRoleForm').submit();
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


    $("#dy").click(function () {
        $('#ywInfoFrom').submit();
    });

    $("#qy").click(function () {
        $('#ywInfoFrom').submit();
    });


    $("#assignTiaoJianButton").click(function () {
        var ywid = $("#ywid").val();
        var clcode = $("#ywcode").val();
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
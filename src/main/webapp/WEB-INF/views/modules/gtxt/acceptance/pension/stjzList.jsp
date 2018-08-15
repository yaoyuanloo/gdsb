<%--
  Created by IntelliJ IDEA.
  User: cxdweqq
  Date: 2016/9/6
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>养老业务受理视同建账受理</title>
    <meta name="decorator" content="default"/>
    <style>
        .accordion-toggle {
            color: black;
        }

        .form-search .ul-form li label {
            width: 100px;
        }

        table {
            table-layout: fixed;
        }

        table th {
            /*width: 80px;*/
        }

        #baseTable td {
            padding: 0;
        }

        #baseTable td > input {
            padding: 0;
            margin: 0;
            border: 0;
            width: 100%;
            background: none;
            height: 28px;
        }

        #zysxTable th {
            text-align: center;
            width: 70px;
        }

        .multiBox {
        }

        .multiBoxIcon {
        }

        .multiBoxLabel {
        }

        .table td i {
            margin: 4px 2px 0 2px;
        }

        .selectWidth {
            width: 164px;
        }

        .inputWidth {
            width: 150px;
        }

        .input-append .accordion-toggle{
            /*padding-left: 10px;*/
            /*padding-right: 10px;*/
        }

        table {
            table-layout: fixed;
        }
    </style>
</head>
<body>
<div id="content" class="row-fluid">
    <div id="openClose" class="close">&nbsp;</div>
    <div id="right">
        <div id="centerDiv" style="width: 100%; margin: 0;overflow-x: hidden; overflow-y: auto;">
            <div class="accordion-group" style="margin: 0;">
                <div class="accordion-heading" style="float: inherit;width: 100%; height: 40px;">
                    <div class="input-append" style="margin-top: 4px;">
                        <div style="display: inline-block;">
                            <a class="accordion-toggle"
                               style="font-size:16px;color: black; line-height: 10px;">
                                电脑号:
                            </a>
                        </div>
                        <input id="pcNo" class="inputprm" name="pcno" type="text"
                               maxlength="11" placeholder="请输入电脑号" htmlEscape="false"
                               style="width: 100px;"/>
                        <div style="display: inline-block;">
                            <a class="accordion-toggle"
                               style="font-size:16px;color: black; line-height: 10px;">
                                身份证号:
                            </a>
                        </div>
                        <input id="IDNo" class="inputprm" name="IDNo" type="text"
                               maxlength="11" placeholder="请输入身份证号" htmlEscape="false"
                               style="width: 150px;"/>
                        <div style="display: inline-block;">
                            <a class="accordion-toggle"
                               style="font-size:16px;color: black; line-height: 10px;">
                                社保卡号:
                            </a>
                        </div>
                        <input id="SBIDNo" class="inputprm" name="IDNo" type="text"
                               maxlength="11" placeholder="请输入社保卡号" htmlEscape="false"
                               style="width: 150px;"/>
                        <button id="searchBtn" class="btn pull-right" type="submit" data-toggle="tooltip"
                                data-placement="right">
                            <i class="icon-search"></i>
                        </button>
                    </div>
                </div>
                <table id="baseTable" class="table table-striped table-bordered table-condensed" style="margin: 0;">
                </table>
                 <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                        <thead>                         
	                        <tr>
	                            <th width="80">姓名:</th>
	                            <td></td>
	                            <th width="80">身份证:</th>
	                            <td></td>
	                            <th width="80">户籍：</th>
	                            <td></td>
	                        </tr>               
                        </thead>
                    </table>
            </div>
           
            <div id="searchForm" action="${ctx}/slzt/slinfo/list" method="post"
                 class="breadcrumb form-search" cssStyle=" margin: 0; border: 0;">
               <center>   
                <ul class="breadcrumb form-search">              
                     <li><label for="sqr">性质：</label>
                        <select id="sqrr" name="sqrr" class="input-medium selectWidth">
                            <option value="1">个人</option>
                            <option value="0">单位</option>
                        </select>
                    </li>
                     <li><label style="width:120px" for="employinfo">是否已收职工档案：</label>
                        <select id="employinfo" name="employinfo" class="input-medium selectWidth">
                            <option value="1">已收职工档案</option>
                            <option value="0">否收职工档案</option>
                        </select>
                    </li>
                    
                    <li><label for="transactor">办理人类别：</label>
                        <select id="transactor" name="transactor" class="input-medium selectWidth">
                            <option value="0">本人办理</option>
                            <option value="1">他人代办</option>
                        </select>
                    </li>
                    <li class="daibanren" style="display: none;">
                        <label for="ywlsh">代办人姓名：</label>
                        <input id="ywlsh" name="ywlsh" type="text" htmlEscape="false" maxlength="50"
                               class="input-medium inputWidth"/>
                    </li>
                    <li class="daibanren" style="display: none;">
                        <label for="dnh">代办人身份证：</label>
                        <input id="dnh" name="dnh" type="text" htmlEscape="false" maxlength="50"
                               class="input-medium inputWidth"/>
                    </li>
                   
                    <li>
                        <label for="phone">联系电话：</label>
                        <input id="phone" name="phone" type="text" htmlEscape="false" maxlength="50"
                               class="input-medium inputWidth" />
                    </li>                                                    
                    <li style="margin-top: 10px">
                        <label for="note">备注：</label>
                        <input id="note" name="note" type="text" htmlEscape="false" maxlength="100"
                               style="width: 710px;"/>
                    </li>
                 </ul> 
                 
                 </center>
                 
                   <div class="breadcrumb" style="margin-top: 3px; margin-right: 10px;">
                    <center>
                       <div class="breadcrumb" style="margin-top: 3px; margin-right: 10px;">
                        <button type="button" id="tijiao" onclick="" class="btn btn-warning"
                                style="width: 110px;"><i
                                class="icon-cloud-upload"></i>&nbsp; 提 交
                        </button>
                       
                    </div>
                     <%-- <div class="btn-group">
                       <a href="${ctx}/ylyw/meun/scan?" class="btn btn-small">提交</a>
                     </div>   
                          
                          --%>  
                          
                      </center>
                     </div>
                </div>
                
                
                  
               
               
            <ul id="myTab" class="nav nav-tabs">
                <li><a href="#YWCXBQ09" data-toggle="tab">查询参保人信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">个人账户基本信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">个人缴费信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">历史缴费信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">异地转入视同和地方养老金</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">异地转入工资信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">视同账户详细信息</a></li>
                
            </ul>
        </div>
    </div>
</div>
</div>

<script>
    $(document).ready(function () {
        var tpl = $("#baseTableTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
        updateBaseTable({msg: '0'}, tpl);
        $("#searchForm").submit(function () {
            if ($("#searchInput").val() == "") {
                showTip("请输入单位社保编号", 'info', 2000, 0);
            } else {
                $.post("${ctx}/slzt/zsyw/dwsb/json", {dwbh: $("#searchInput").val()}, function (data) {
                    updateBaseTable(data, tpl);
                    $("#shenheBtn").attr("dwbh", ($("#searchInput").val()));
                });
            }
            return false;
        });
        $("[data-toggle='tooltip']").tooltip({
            delay: {show: 1000, hide: 200}
        });
        $("[data-toggle='popover']").popover();

        $("#transactor").change(function () {
            if ($(this).val()!= 0)
                $(".daibanren").fadeIn('fast');
            else
                $(".daibanren").fadeOut('fast');
        });
    });

    function updateBaseTable(data, tpl) {
        if (((data['msg']).toString().trim()) != '0') {
            showTip(((data['msg']).toString().trim()), 'error');
        }
        $("#baseTable").children().remove();
        $("#baseTable").append(Mustache.render(tpl, {
            dict: {
                udstarttime: function (v) {
                    if (data.udayy1) {
                        return data.udayy1 + "年" + data.udamm1 + "月";
                    } else {
                        return "";
                    }
                },
                udchar: function () {
                    if (data['udchar'] == null) {
                        return "";
                    } else {
                        return (data['udchar'] == '0') ? "企业" : '机关企业';
                    }
                }
            },
            data: data
        }));
    }

    var values = new Array();
    function allCheck(e) {
        var i = $(e).find("i")[0];
        if (!$(i).hasClass("icon-check")) {
            $(i).removeClass("icon-check-empty").addClass("icon-check");
            $("#paperTable .multiBoxIcon").removeClass("icon-check-empty").addClass("icon-check");
        } else {
            $(i).removeClass("icon-check").addClass("icon-check-empty");
            $("#paperTable .multiBoxIcon").removeClass("icon-check").addClass("icon-check-empty");
        }
        setValues();
        checkAll();
    }

    function checkLabel(e) {
        var box = ($(e).children("i"))[0];
        if (!($(box).hasClass("active"))) {
            $(".multiBoxIcon").removeClass("icon-circle").removeClass("active").addClass("icon-circle-blank");
            $(box).addClass("icon-circle").addClass("active");

            $("#shenheBtn").attr("ywbh", ($(e).attr("value")));
        }
    }

    function checkMultiLabel(e) {
        var box = ($(e).find(".multiBoxIcon"))[0];
        if ($(box).hasClass("icon-check-empty")) {
            $(box).addClass("icon-check").removeClass("icon-check-empty");
        } else {
            $(box).addClass("icon-check-empty").removeClass("icon-check");
        }
        $.post("${ctx}/slzt/zsyw/dwsb/zhuyi", {ywbh: $(e).attr("value")}, function (data) {
            $("#zysxTable").html("");
            $("#blsj").val("");

            $("#blsj").val((data.ywxx.by1).toString().trim());
            ywsc = data.ywsc;
            ywscCount = ywsc.length;

            $("#ywscPageBar").html("");
            /*if (ywsc.length > pageSize) {*/
            var prev = $("<li class='disabled'><a href='javascript:void(0);' onclick='prev($(this));' class='icon-double-angle-left'></a></li>");
            $("#ywscPageBar").append(prev);
            for (var i = 0; i < (ywscCount / pageSize); i++) {
                $("#ywscPageBar").append($("<li><a href='javascript:void(0);' onclick='ywscPage(this);' data-page-no='" + (i + 1) + "'>" + (i + 1) + "</a></li>"));
            }
            var next = $("<li><a href='javascript:void(0);' onclick='next($(this));' class='icon-double-angle-right'></a></li>");
            $("#ywscPageBar").append(next);
            var f = (($("#ywscPageBar").find("li a")[1]));
            ywscPage(f);
            $("#ywscPageBar").attr("data-page-count", ywscCount);
            /*} else {
             var page = $("#ywscPageBar").attr("data-page-no");
             var li = ($("#ywscPageBar").find("li")[1]);
             var a = $(li).find("a");
             console.log(a);
             ywscPage(a);
             }*/
        });
        checkAll();
    }

    function checkAll() {
        var e = $("#paperTable .multiBox").find(".icon-check");
        var all = $("#paperTable tr");
        if (e.length == all.length) {
            $("#allcheckBox .multiBoxIcon:first").addClass("icon-check").removeClass("icon-check-empty");
        } else {
            $("#allcheckBox .multiBoxIcon:first").addClass("icon-check-empty").removeClass("icon-check");
        }
    }

    function checkNumber() {
        var a = $("#yewuleibie .multiBox");
        var c = $("#yewuleibie .multiBox").find(".icon-check").parent();
        var vs = new Array();
        var ns = new Array();
        var js = new Array();
        var j = {};
        $(c).each(function () {
            j = {"name": $(this).attr("value"), "value": $(this).find(".multiBoxLabel").html()};
            js.push(j);
            vs.push($(this).attr("value"));
            ns.push($(this).find(".multiBoxLabel").html());
        });
        return {all: a, checked: c, values: vs, names: ns, json: js, boo: (c.length < a.length) ? false : true};
    }
</script>
<script type="text/javascript">
    var showDetailObj = null;
    var detailTrTheme = "info";
    var tableTrTheme = "";

    var leftWidth = 200; // 左侧窗口大小
    var htmlObj = $("html"), mainObj = $("#main");
    var frameObj = $("#left, #openClose, #right, #right iframe");
    function wSize() {
        var strs = getWindowSize().toString().split(",");
        htmlObj.css({"overflow-x": "hidden", "overflow-y": "auto"});
        mainObj.css("width", "auto");
        frameObj.height(strs[0] - 5);
        var leftWidth = ($("#left").width() < 0 ? 0 : $("#left").width());
        $("#right").width($("#content").width() - leftWidth - $("#openClose").width() - 5);
    }
    function tableTurnCss() {
        $("#treeTableList").find("tr:odd").removeClass(tableTrTheme).removeClass(detailTrTheme);
        $("#treeTableList").find("tr:even").addClass(tableTrTheme);
    }
</script>
<script src="${ctxStatic}/common/wsize.min.js" type="text/javascript"></script>

</body>
</html>

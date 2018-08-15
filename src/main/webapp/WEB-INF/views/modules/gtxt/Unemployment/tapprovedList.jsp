<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>失业业务受理</title>
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

        .input-append .accordion-toggle {
            /*padding-left: 10px;*/
            /*padding-right: 10px;*/
        }

        table {
            table-layout: fixed;
        }
    </style>
</head>
<body>
<div>
    <div style="width: 100%; margin: 0;overflow-x: hidden; overflow-y: auto;">
        <div class="accordion-group" style="margin: 0;">
            <div class="accordion-heading" style="float: inherit;width: 100%; height: 40px;">
                <div style="float: left;">
                    <a class="accordion-toggle"
                       style="font-size: 18px; line-height: 22px;">${ywinfo.pywinfo.name}</a>
                </div>
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
        </div>
        <div id="searchForm" action="#" method="post"
             class="breadcrumb form-search" cssStyle=" margin: 0; border: 0;">
            <ul class="ul-form">
                <li><label for="sqr">申请人：</label>
                    <select id="sqr" name="sqr" class="input-medium selectWidth">
                        <option value="1">本人办理</option>
                        <option value="0">他人代办</option>
                    </select>
                </li>

                <li>
                    <label for="phone">联系电话：</label>
                    <input id="phone" name="phone" type="text" htmlEscape="false" maxlength="50"
                           class="input-medium inputWidth"/>
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
                <li class="clearfix"></li>
                <li>
                    <label for="firstpayreason">银行名称：</label>
                    <select style="width: 165px;">
                        <option>请选择</option>
                    </select>
                </li>
                <li>
                    <label for="dnh">银行卡号：</label>
                    <input id="dnh" name="dnh" type="text" htmlEscape="false" maxlength="50"
                           class="input-medium inputWidth"/>
                </li>
                <li class="clearfix"></li>
                <li>
                    <label for="note">备注：</label>
                    <input id="note" name="note" type="text" htmlEscape="false" maxlength="100"
                           style="width: 710px;"/>
                </li>
            </ul>
        </div>

        <div class="accordion-group" style="margin: 0; border: 0;">
            <div class="accordion-heading"
                 style="float: inherit; width: 100%; height: 35px;">
                <div style="float: left;">
                    <a href="javascript:void(0);" class="accordion-toggle" data-toggle="tooltip"
                       data-placement="right" title="">劳动局失业登记信息 </a>
                </div>
            </div>
        </div>
        <div class="accordion-heading" style="width: 100%;text-align: center;">
            <div class="breadcrumb form-search">
                <ul class="ul-form">
                    <li>
                        <label for="ywlsh">失业登记日期:</label>
                        <input name="starthospitaldate" type="text" readonly="readonly"
                               maxlength="20" class="input-mini Wdate"
                               value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                               style="width: 150px;"/>
                    </li>
                    <li>
                        <label for="ywlsh">失业证号:</label>
                        <input id="ywlsh" name="ywlsh" type="text" htmlEscape="false" maxlength="50"
                               class="input-medium inputWidth"/>
                    </li>
                    <li class="clearfix"></li>
                    <li>
                        <label for="ywlsh">劳动关系终止时间:</label>
                        <input name="starthospitaldate" type="text" readonly="readonly"
                               maxlength="20" class="input-mini Wdate"
                               value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                               style="width: 150px;"/>
                    </li>
                    <li>
                        <label for="ywlsh">离职原因:</label>
                        <select id="firstpay" name="firstpay" class="input-medium selectWidth">
                            <option value="0">自愿离职</option>
                            <option value="0">非自愿离职</option>
                        </select>
                    </li>
                </ul>
            </div>
        </div>
        <center>
            <div class="breadcrumb" style="">
                <button type="button" id="tijiao" onclick="" class="btn btn-info"
                        style="width: 110px;"><i
                        class="icon-list-alt"></i>&nbsp;提交
                </button>
            </div>
        </center>
        <ul id="myTab" class="nav nav-tabs">
            <li class="active"><a href="#YWCL" data-toggle="tab">业务所需材料</a></li>
            <gt:tags items="${tabs}" />
        </ul>
        <div id="myTabContent" class="tab-content">
            <%-- 业务材料 --%>
            <div class="tab-pane active" id="YWCL">
                <div class="breadcrumb">
                    <c:choose>
                        <c:when test="${fn:length(cailiaoList) <= 0}">
                            <div class="alert" style="font-size: 14px; margin: 0; text-align: center;">
                                <button type="button" class="close" data-dismiss="alert">&times;</button>
                                <strong>温馨提示：</strong>未找到【${ywinfo.pywinfo.name}】 业务所需材料。
                            </div>
                        </c:when>
                        <c:otherwise>
                            <table class="table table-striped table-bordered table-condensed"
                                   style="overflow-y: auto;">
                                <thead>
                                <tr>
                                    <th class="multiBox" id="allcheckBox" onclick="allCheck(this, '#paperTable')"
                                        style=" text-align: center; width: 40px; color: #1a22ff;">
                                        <i class="multiBoxIcon icon-check-empty" style="width: 30px;"></i>
                                            <%--<span class="multiBoxLabel pull-right">全选</span>--%>
                                    </th>
                                    <th>材料名称</th>
                                </tr>
                                </thead>
                                <tbody id="paperTable">
                                <c:forEach items="${cailiaoList}" var="cl">
                                    <tr class="multiBox" onclick="checkMultiLabel(this, '#paperTable')" rank="1"
                                        value="${cl.id}">
                                        <td width="16px">
                                            <div value="${cl.id}" style="margin: 0 auto; text-align: center;">
                                                <i class="multiBoxIcon icon-check-empty" style="" value="${cl.id}"></i>
                                            </div>
                                        </td>
                                        <td class="multiBoxLabel">${cl.name}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </c:otherwise>
                    </c:choose>
                </div>

            </div>
            <gt:tagsContent />
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

        $("#sqr").change(function () {
            if ($(this).val() == 0)
                $(".daibanren").fadeIn('fast');
            else
                $(".daibanren").fadeOut('fast');
        });

        $("#firstpay").change(function () {
            if ($(this).val() == 1)
                $(".firstpay").fadeIn('fast');
            else
                $(".firstpay").fadeOut('fast');
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
    //    $(function () {
    //        $("#centerDiv").css({"overflow-y" : "scroll"});
    //    });
    var leftWidth = 200; // 左侧窗口大小
    var htmlObj = $("html"), mainObj = $("#main");
    var frameObj = $("#left, #openClose, #right, #right iframe");
    function wSize() {
        var strs = getWindowSize().toString().split(",");
        htmlObj.css({"overflow-x": "hidden", "overflow-y": "auto"});
//        $("body").css("overflow", "hidden");
        mainObj.css("width", "auto");
        frameObj.height(strs[0] - 25);
        var leftWidth = ($("#left").width() < 0 ? 0 : $("#left").width());
        $("#right").width($("#content").width() - leftWidth - $("#openClose").width() - 25);
    }
    function tableTurnCss() {
        $("#treeTableList").find("tr:odd").removeClass(tableTrTheme).removeClass(detailTrTheme);
        $("#treeTableList").find("tr:even").addClass(tableTrTheme);
    }
</script>
<script src="${ctxStatic}/common/wsize.min.js" type="text/javascript"></script>
<script type="text/template" id="baseTableTpl">
    <tr>
        <th width="80">姓名</th>
        <td>
            <input readonly="readonly" id="name" value="{{data.name}}"/>
        </td>
        <th width="80">身份证号</th>
        <td>
            <input readonly="readonly" id="idcard" value="{{dict.idcard}}"/>
        </td>
        <th width="80">户籍</th>
        <td>
            <input readonly="readonly" id="home" value="{{dict.home}}"/>
        </td>
    </tr>
</script>
</body>
</html>

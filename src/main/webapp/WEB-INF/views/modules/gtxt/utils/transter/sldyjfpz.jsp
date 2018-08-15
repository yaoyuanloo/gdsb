<%--
  Created by IntelliJ IDEA.
  User: cxd
  Date: 2016/9/6
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>打印缴费凭证-受理</title>
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

        .row-fluid .span1 {
            /*margin-left: 3px;*/
        }
    </style>
</head>
<body>
<%--<div class="row-fluid">--%>
<div class="" id="">
    <div id="centerDiv" style="width: 100%; margin: 0;overflow-x: hidden; overflow-y: auto;">
        
       
        <form id="infoForm" method="post" class="form-search breadcrumb" style=" margin: 0; border: 0;">
            <ul class="ul-form">
                <li><label for="ztype">凭证类型：</label>
                    <select id="ztype" name="ztype" class="input-medium selectWidth">
                        <option value="0">省内养老</option>
                        <option value="1">省外养老</option>
                        <option value="2">医疗</option>
                        <option value="3">失业</option>
                    </select>
                </li>
                 <li class="clearfix"></li>
                <li>
                    <label for="livePlace">户籍所在地址：</label>
                     <input id="livePlace" name="livePlace" type="text" htmlEscape="false" maxlength="100"
                           style="width: 710px;"/>
                </li>
               
                
                <li class="clearfix"></li>
                <li>
                    <label for="note">备注：</label>
                    <input id="note" name="note" type="text" htmlEscape="false" maxlength="100"
                           style="width: 710px;"/>
                </li>
            </ul>
            <center>
                <div class="breadcrumb" style="margin-top: 3px; margin-right: 10px;">
                    <button type="button" onclick="tijiao();" class="btn btn-warning"
                            style="width: 110px;">
                        <i class="icon-cloud-upload"></i>&nbsp; 提 交
                    </button>
                </div>
            </center>
        </form>
    
       
    </div>
</div>
<script>
    $(document).ready(function () {
        var tpl = $("#baseTableTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
//        updateBaseTable({msg: '0'}, tpl);
        $("#searchBtn").click(function () {
//            if ($("#searchInput").val() == "") {
//                showTip("请输入单位社保编号", 'info', 2000, 0);
//            } else {
            var ajaxdata = {
                pcno: $("#pcno").val(),
                icno: $("#icno").val(),
                sino: $("#sino").val()
            };
            $.post("${ctx}/gtxt/utils/util/json", ajaxdata, function (data) {
//                    updateBaseTable(data, tpl);
//                    $("#shenheBtn").attr("dwbh", ($("#searchInput").val()));
                for (var i in data) {
                    $("." + i).val(data[i]);
                }
            });
//            }
            return false;
        });
        $("[data-toggle='tooltip']").tooltip({
            delay: {show: 1000, hide: 200}
        });
        $("[data-toggle='popover']").popover();

        $("#sqr").change(function () {
            if ($(this).val() == 0) {
                $(".daibanren").fadeIn('fast');
                $(".daibanren input").removeClass("disabled");
                $(".daibanren input").removeAttr("disabled");
            } else {
                $(".daibanren").fadeOut('fast');
                $(".daibanren input").addClass("disabled");
                $(".daibanren input").attr("disabled", "disabled");
            }
        });

        $("#firstpay").change(function () {
            if ($(this).val() == 1) {
                $(".firstpay").fadeIn('fast');
                $(".firstpay input").removeClass("disabled");
                $(".firstpay input").removeAttr("disabled");
            } else {
                $(".firstpay").fadeOut('fast');
                $(".firstpay input").addClass("disabled");
                $(".firstpay input").attr("disabled", "disabled");
            }
        });
    });

    function tijiao() {
        var data = $("#infoForm").serializeJson();

        $("#jsoninfo").val(JSON.stringify(data));
        $("#submitForm").submit();
    }

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
        checkAll();
    }

    function checkLabel(e, pid) {
        var box = ($(e).children("i"))[0];
        var box = ($(pid).find($(e)).find(".multiBoxIcon"))[0];
        if (!($(box).hasClass("active"))) {
            $(".multiBoxIcon").removeClass("icon-circle").removeClass("active").addClass("icon-circle-blank");
            $(box).addClass("icon-circle").addClass("active");

            $("#shenheBtn").attr("ywbh", ($(e).attr("value")));
        }
    }

    function checkMultiLabel(e, pid) {
        var box = ($(pid).find($(e)).find(".multiBoxIcon"))[0];
        if ($(box).hasClass("icon-check-empty")) {
            $(box).addClass("icon-check").removeClass("icon-check-empty");
        } else {
            $(box).addClass("icon-check-empty").removeClass("icon-check");
        }
        checkAll(pid);
    }

    function checkAll(pid) {
        var e = $(pid + " .multiBox").find(".icon-check");
        var all = $(pid + " tr");
        if (e.length == all.length) {
            $("#allcheckBox .multiBoxIcon:first").addClass("icon-check").removeClass("icon-check-empty");
        } else {
            $("#allcheckBox .multiBoxIcon:first").addClass("icon-check-empty").removeClass("icon-check");
        }
        console.log(checkNumber(pid));
    }

    function checkNumber(pid) {
        var a = $(pid + " .multiBox");
        var c = $(pid + " .multiBox").find(".icon-check").parents(".multiBox");
        var vs = new Array();
        var ns = new Array();
        var js = new Array();
        var j = {};
        $(c).each(function () {
            j = {"name": $(this).find(".multiBoxLabel").html(), "value": $(this).attr("value")};
            js.push(j);
            vs.push($(this).attr("value"));
            ns.push($(this).find(".multiBoxLabel").html());
        });
        return {all: a, checked: c, values: vs, names: ns, json: js, boo: (c.length < a.length) ? false : true};
    }
</script>
<script type="text/javascript">
    //    $(function () {
    //        $("#centerDiv").css({"overflow-y" : "scroll"});
    //    });
    var leftWidth = 220; // 左侧窗口大小
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
</script>
<script src="${ctxStatic}/common/wsize.min.js" type="text/javascript"></script>
<script type="text/template" id="baseTableTpl">

</script>
</body>
</html>

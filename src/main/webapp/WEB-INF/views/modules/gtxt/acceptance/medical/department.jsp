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
    <title>医疗业务-门诊报销业务-受理</title>
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
<div id="">
    <div id="centerDiv" style="width: 100%; margin: 0;overflow-x: hidden; overflow-y: auto;">
        <div class="accordion-group" style="margin: 0;">
            <div class="accordion-heading" style="float: inherit;width: 100%; height: 40px;">
                <div style="float: left;">
                    <a class="accordion-toggle" style="font-size: 18px; line-height: 22px;">${ywinfo.pywinfo.name}</a>
                </div>
                <div id="inputBar" class="input-append" style="margin-top: 5px;">
                    <div style="display: inline-block;">
                        <a class="accordion-toggle"
                           style="font-size:16px;color: black; line-height: 10px;">
                            电脑号:
                        </a>
                    </div>
                    <input id="pcno" class="pcno inputprm" name="pcno" type="text" value="${gtywinfos[0].dnh}"
                           maxlength="18" placeholder="请输入电脑号" htmlEscape="false"
                           style="width: 100px;"/>
                    <div style="display: inline-block;">
                        <a class="accordion-toggle"
                           style="font-size:16px;color: black; line-height: 10px;">
                            身份证号:
                        </a>
                    </div>
                    <input id="idno" class="idno inputprm" name="idno" type="text" value="${gtywinfos[0].sfzh}"
                           maxlength="20" placeholder="请输入身份证号" htmlEscape="false"
                           style="width: 150px;"/>
                    <div style="display: inline-block;">
                        <a class="accordion-toggle"
                           style="font-size:16px;color: black; line-height: 10px;">
                            社保卡号:
                        </a>
                    </div>
                    <input id="sino" class="sino inputprm" name="sino" type="text" value="${gtywinfos[0].grsbh}"
                           maxlength="15" placeholder="请输入社保卡号" htmlEscape="false"
                           style="width: 120px;"/>
                    <button id="searchBtn" class="btn pull-right" type="submit" data-toggle="tooltip"
                            data-placement="right">
                        <i class="icon-search"></i>
                    </button>
                </div>
            </div>
            <table id="baseTable" class="table table-striped table-bordered table-condensed" style="margin: 0;">
                <tr>
                    <th width="80">姓名</th>
                    <td>
                        <input readonly="readonly" id="peosonname" class="peosonname" value="${gtywinfos[0].xm}"/>
                    </td>
                    <th width="80">身份证号</th>
                    <td>
                        <input readonly="readonly" id="idcard" class="idno" value="${gtywinfos[0].sfzh}"/>
                    </td>
                    <th width="80">户籍</th>
                    <td>
                        <input readonly="readonly" id="oldhome" class="oldhome" value=""/>
                    </td>
                </tr>
                <tr>
                    <th>业务类型</th>
                    <td colspan="5">
                        <ul id="condition" class="nav nav-pills" style="margin-bottom: 0;">
                            <c:choose>
                                <c:when test="${checkMultiLabel}">
                                    <c:forEach items="${types}" var="t">
                                        <li>
                                            <a href="javascript:void(0);" class="multiBox" value="${t.id}"
                                               onclick="checkMultiLabel(this, '#baseTable')">
                                                <i class="multiBoxIcon icon-check-empty"></i>
                                                <span class="multiBoxLabel">${t.name}</span>
                                            </a>
                                        </li>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${types}" var="t">
                                        <li>
                                            <a href="javascript:void(0);" class="multiBox" value="${t.id}"
                                               onclick="checkLabel(this, '#baseTable')">
                                                <i class="multiBoxIcon icon-circle-blank"></i>
                                                <span class="multiBoxLabel">${t.name}</span>
                                            </a>
                                        </li>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </td>
                </tr>
            </table>
        </div>
        <form id="submitForm" action="${ctx}/gtxt/accept/medical/save" method="post" style="margin: 0; border: 0;">
            <input type="hidden" id="jsoninfo" name="jsoninfo"/>
            <input type="hidden" id="ywid" name="ywid" value="${ywinfo.id}"/>
            <input type="hidden" id="nextywid" name="nextywid" value=""/>
            <input type="hidden" id="cls" name="cls" value=""/>
            <input type="hidden" id="teamwork" name="teamwork" value=""/>
            <input type="hidden" id="active" name="active" value=""/>
            <input type="hidden" id="flowcode" name="flowcode" value="${ywatter.flowcode.value}"/>
            <input type="hidden" id="shjbcode" name="shjbcode" value="${ywatter.shjbcode.value}"/>

            <input type="hidden" id="hzdh" name="hzdh" value="${hzdh}"/>
            <input type="hidden" id="slhzh" name="slhzh" value="${slhzh}"/>
            <input type="hidden" id="grsbh" name="grsbh" class="sino" value=""/>
            <input type="hidden" id="sfzh" name="sfzh" class="idno" value=""/>
            <input type="hidden" id="dnh" name="dnh" class="pcno" value=""/>
            <input type="hidden" id="ywbh" name="ywbh" value="${ywinfo.pywinfo.code}"/>
            <input type="hidden" id="ywmc" name="ywmc" value="${ywinfo.pywinfo.name}"/>
            <input type="hidden" id="xm" name="xm" class="peosonname" value=""/>
            <input type="hidden" id="dwbh" name="dwbh" class="dwbh" value=""/>
            <input type="hidden" id="dwmc" name="dwmc" class="dwmc" value=""/>
        </form>
        <form id="infoForm" method="post" class="form-search breadcrumb" style=" margin: 0; border: 0;">
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
                    <label for="daibanrenname">代办人姓名：</label>
                    <input id="daibanrenname" name="daibanrenname" type="text" htmlEscape="false" maxlength="50"
                           class="input-medium inputWidth"/>
                </li>
                <li class="daibanren" style="display: none;">
                    <label for="daibanrenidcard">代办人身份证：</label>
                    <input id="daibanrenidcard" name="daibanrenidcard" type="text" htmlEscape="false" maxlength="50"
                           class="input-medium inputWidth"/>
                </li>
                <li class="clearfix"></li>
                <li><label>入院日期：</label>
                    <input name="starthospitaldate" type="text" readonly="readonly"
                           maxlength="20" class="input-mini Wdate"
                           value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                           onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                           style="width: 150px;"/>
                </li>
                <li><label>出院日期：</label>
                    <input name="endhospitaldate" type="text" readonly="readonly"
                           maxlength="20" class="input-mini Wdate"
                           value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                           onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                           style="width: 150px;"/>
                </li>
                <li class="clearfix"></li>
                <li><label for="firstpay">先行支付：</label>
                    <select id="firstpay" name="firstpay" class="input-medium selectWidth">
                        <option value="0">否</option>
                        <option value="1">是</option>
                    </select>
                </li>
                <li class="firstpay" style="display: none;">
                    <label for="firstpayreason">先行支付原因：</label>
                    <input id="firstpayreason" name="firstpayreason" type="text" htmlEscape="false" maxlength="100"
                           style="width: 430px;"/>
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
                    <button type="button" onclick="tijiao()" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-cloud-upload"></i>&nbsp; 提 交
                    </button>
                </div>
            </center>
        </form>
        <ul id="myTab" class="nav nav-tabs">
            <li class="active"><a href="#YWCL" data-toggle="tab">业务所需材料</a></li>
            <c:forEach items="${tabs}" var="tab">
                <li><a href="#TAB${tab.querytagid.value}" data-toggle="tab">${tab.querytagid.label}</a></li>
            </c:forEach>
            <%--<li><a href="#YWCXBQ01" data-toggle="tab">单位基本信息</a></li>
            <li><a href="#YWCXBQ02" data-toggle="tab">个人基本信息</a></li>
            <li><a href="#YWCXBQ09" data-toggle="tab">查询医疗信息</a></li>
            <li><a href="#YWCXBQ01" data-toggle="tab">个人缴费基本信息</a></li>
            <li><a href="#YWCXBQ01" data-toggle="tab">历史缴费信息</a></li>
            <li><a href="#YWCXBQ01" data-toggle="tab">历史住院信息</a></li>
            <li><a href="#YWCXBQ01" data-toggle="tab">转诊信息</a></li>
            <li><a href="#YWCXBQ01" data-toggle="tab">长住异地信息</a></li>
            <li><a href="#YWCXBQ01" data-toggle="tab">门诊病种信息</a></li>--%>
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
            <c:forEach items="${tabs}" var="tab">
                <div class="tab-pane" id="TAB${tab.querytagid.value}">
                    <div>
                        查询${tab.querytagid.label}
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $("#searchBtn").click(function () {
            var ajaxdata = {
                pcno: $("#pcno").val(),
                icno: $("#icno").val(),
                sino: $("#sino").val()
            };
            $.post("${ctx}/gtxt/utils/util/json", ajaxdata, function (data) {
                for (var i in data) {
                    $("." + i).val(data[i]);
                }
            });
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
        if($("#dnh").val() == null || $("#dnh").val() == undefined || $("#dnh").val() == ''){
            twinkle("#inputBar");
        }else if(!checkNumber("#paperTable").boo){
            twinkle("#paperTable");
        }else{
            liuzhuan();
        }

    }

    function liuzhuan() {
        top.$.jBox.confirm("是否有下一单业务", '系统提示', function (v, h, f) {
            if (v == 'ok') {
                top.$.jBox.open("iframe:${ctx}/tag/treeselect?url=" + encodeURIComponent("/city/dYwinfo/treeData") + "&module=&checked=&extId=<%--${ywinfo.id}--%>&isAll=", "选择下一单业务", 400, 500, {
                    ajaxData: {
                        selectIds: "1"
                    },
                    buttons: {
                        "确定": "ok"
                    },
                    persistent: true,
                    submit: function (v, h, f) {
                        if (v == "ok") {
                            var tree = h.find("iframe")[0].contentWindow.tree;//h.find("iframe").contents();
                            var ids = [], names = [], nodes = [];
                            if ("${checked}" == "true") {
                                nodes = tree.getCheckedNodes(true);
                            } else {
                                nodes = tree.getSelectedNodes();
                            }
                            for (var i = 0; i < nodes.length; i++) {
                                if (nodes[i].level == 0) {
                                    top.$.jBox.tip("不能选择根节点（" + nodes[i].name + "）请重新选择。");
                                    return false;
                                }
                                if (nodes[i].isParent) {
                                    top.$.jBox.tip("不能选择父节点（" + nodes[i].name + "）请重新选择。");
                                    return false;
                                }
                                ids.push(nodes[i].id);
                                names.push(nodes[i].name);
                            }
                            var idstr = ids.join(",").replace(/u_/ig, "");
                            var nameatr = names.join(",");
                            $("#nextywid").val(ids[0]);
                        }
                        var data = $("#infoForm").serializeJson();
                        $("#jsoninfo").val(JSON.stringify(data));
                        $("#submitForm").submit();

                    },
                    loaded: function (h) {
                        $(".jbox-content", top.document).css("overflow-y", "hidden");
                    }
                });
            } else if (v == 'cancel') {
                var hzdh = $("#hzdh").val();
                if(hzdh == null || hzdh == undefined || hzdh == ''){
                    submit();
                }else{
                    checkMultiBusiness();
                }
            }
        }, {
            persistent: true,
            buttons: {
                "有": "ok",
                "没有": "cancel"
            },
            buttonsFocus: 1
        });
        top.$('.jbox-body .jbox-icon').css('top', '55px');
    }

    function checkMultiBusiness(){
        top.$.jBox.open("iframe:${ctx}/gtxt/utils/util/teamwork", "多业务设置", 500, 500, {
            ajaxData: {
                'hzdh': "${hzdh}",
                'ywid': "${ywinfo.id}",
                'ywmc': "${ywinfo.pywinfo.name}"
            },
            buttons: {
                "确定": "ok"
            },
            persistent: true,
            submit: function (v, h, f) {
                if (v == "ok") {
                    var doc = h.find("iframe")[0].contentWindow.document;
                    var teamwork = $("#teamwork", doc).val();
                    var active = $("#mutilBusinessSetting .multiBoxIcon.active", doc).attr("value");
                    $("#teamwork").val(teamwork);
                    $("#active").val(active);
                    submit();
                }
            },
            loaded: function (h) {
                $(".jbox-content", top.document).css("overflow-y", "hidden");
            }
        });
    }

    function submit(){
        var data = $("#infoForm").serializeJson();
        $("#jsoninfo").val(JSON.stringify(data));
        var cls = checkNumber("#paperTable").values;
        $("#cls").val(JSON.stringify(cls));
        $("#submitForm").submit();
    }
</script>
</body>
</html>

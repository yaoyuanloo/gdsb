<%--
  Created by IntelliJ IDEA.
  User: yj
  Date: 2016/10/13
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html style="height: 100%;">
<head>
    <title>特殊工种认定</title>
    <meta name="decorator" content="yhdefault"/>
    <style>
        html, body {
            padding: 5px;
            height: 100%;
            min-height: 100%;
        }

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

        input.form-control{
            padding-left: 3px;
            padding-right: 3px;
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
    <div class="row">
        <div class="span12">
            <div class="bs-callout bs-callout-info" style=" padding: 5px; margin: 0 0 10px 0; line-height: 30px;">
                <div class="row">
                    <div class="span4">
                        <span class="navbar-brand">${ywinfo.pywinfo.name}</span>
                    </div>
                    <div class="span8">
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <div class="btn btn-primary">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" name="xietong" id="xietong" value="1">
                                        是否协同
                                    </label>
                                </div>
                            </div>
                            <%--<button type="submit" class="btn yellow">提交</button>--%>
                            <button type="button" class="btn yellow" onclick="tijiao()">保存(S)</button>
                            <button type="button" class="btn gray" onclick="location.reload();">重置(R)</button>
                            <button type="button" class="btn gray">关闭</button>
                            <button type="button" class="btn darkgray">禁用</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="span12">
            <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        信息查询
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i
                                class="fa fa-minus"></i></button>
                    </div>
                </div>
                <div class="box-body" style="margin: 0;">
                    <form id="searchForm" class="form-horizontal">
                        <div class="form-group">
                            <label class="span1 control-label"><b class="mr5 red500">*</b>身份证号码:</label>
                            <div class="span2">
                                <input id="aac147" name="aac147" type="text" placeholder="请输入身份证号"
                                       class="form-control aac147"
                                       value="801947195009177783"/>
                            </div>
                            <label class="span1 control-label"><b class="mr5 red500">*</b>社保卡号:</label>
                            <div class="span2">
                                <input id="aac002" name="aac002" type="text" placeholder="请输入社保卡号"
                                       class="form-control aac002"/>
                            </div>
                            <%--<div class="span1"></div>--%>
                            <div class="span2">
                                <button onclick="searchPerson();" type="button" class="btn yellow">查询</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        个人基本信息
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i
                                class="fa fa-minus"></i></button>
                    </div>
                </div>
                <div class="box-body" style="margin: 0;">
                    <form id="personInfoForm" class="form-horizontal">
                        <%-- 个人编号 --%>
                        <input type="hidden" name="aac999" class="aac001"/>
                        <%-- 个人管理码 --%>
                        <input type="hidden" name="aac999" class="aac999"/>
                        <div class="form-group">
                            <label class="span1 control-label">联系人</label>
                            <div class="span2">
                                <input readonly type="text" class="form-control aae004" id="aae004" name="aae004"/>
                            </div>
                            <label class="span1 control-label">固定电话</label>
                            <div class="span2">
                                <input readonly type="text" class="form-control aae005" id="aae005" name="aae005"/>
                            </div>
                            <label class="span1 control-label">手机号码</label>
                            <div class="span2">
                                <input readonly type="text" class="form-control aac067" id="aac067" name="aac067"/>
                            </div>
                            <label class="span1 control-label">社保卡号</label>
                            <div class="span2">
                                <input readonly type="text" class="form-control aac002" id="aac002" name="aac002"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="span1 control-label">姓名</label>
                            <div class="span2">
                                <input readonly type="text" class="form-control aac003" id="aac003" name="aac003"/>
                            </div>
                            <label class="span1 control-label">证件类型</label>
                            <div class="span2">
                                <input readonly type="text" class="form-control aac058" id="aac058" name="aac058"/>
                            </div>
                            <label class="span1 control-label">证件号码</label>
                            <div class="span2">
                                <input readonly type="text" class="form-control aac147" id="aac147" name="aac147"/>
                            </div>
                            <label class="span1 control-label">性别</label>
                            <div class="span2">
                                <input readonly type="text" class="form-control aac004" id="aac004" name="aac004"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="span1 control-label">民族</label>
                            <div class="span2">
                                <input readonly type="text" class="form-control aac005" id="aac005" name="aac005"/>
                            </div>
                            <label class="span1 control-label">出生日期</label>
                            <div class="span2">
                                <input readonly type="text" class="form-control aac006" id="aac006" name="aac006"/>
                            </div>
                            <label class="span1 control-label">户口性质</label>
                            <div class="span2">
                                <input readonly type="text" class="form-control aac009" id="aac009" name="aac009"/>
                            </div>
                            <label class="span1 control-label">地区代码</label>
                            <div class="span2">
                                <input readonly type="text" class="form-control aac161" id="aac161" name="aac161"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="span1 control-label">参加工作时间</label>
                            <div class="span2">
                                <input readonly type="text" class="form-control aac007" id="aac007" name="aac007"/>
                            </div>
                            <label class="span1 control-label">文化程度</label>
                            <div class="span2">
                                <input readonly type="text" class="form-control aac031" id="aac031" name="aac031"/>
                            </div>
                            <label class="span1 control-label">用工形式</label>
                            <div class="span2">
                                <input readonly type="text" class="form-control aac033" id="aac033" name="aac033"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="span1 control-label">家庭地址</label>
                            <div class="span11">
                                <input readonly type="text" class="form-control aae006" id="aae006" name="aae006"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="span1 control-label">备注</label>
                            <div class="span11">
                                <input readonly type="text" class="form-control aae013" id="aae013" name="aae013"/>
                            </div>
                        </div>
                    </form>
                    </form>
                </div>
            </div>
            <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        特殊工种列表
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i
                                class="fa fa-minus"></i></button>
                    </div>
                </div>
                <div class="box-body" style="margin: 0;">
                    <div class="form-horizontal">
                        <div name="infoForm">
                            <div class="form-group">
                                <div class="span12">
                                    <button type="button" class="btn btn-sm yellow" onclick="add_tr();">添加</button>
                                    <button type="button" class="btn btn-sm yellow" onclick="del_tr();">删除</button>
                                </div>
                            </div>
                            <div class="form-group">
                                <table class="table table-bordered table-striped table-hover tablesorter"
                                       data-resizable-columns-id="table2">
                                    <thead>
                                    <tr>
                                        <th style="width: 20px; text-align: center;">
                                            <input type="checkbox" onclick="checkAll()"/>
                                        </th>
                                        <th style="width: 40px; text-align: center;">序号</th>
                                        <th style="width: 80px; text-align: center;">起始时间</th>
                                        <th style="width: 80px; text-align: center;">截至时间</th>
                                        <th style="width: 80px; text-align: center;">单位名称</th>
                                        <th style="width: 80px; text-align: center;">单位类型</th>
                                        <th style="width: 80px; text-align: center;">文件依据</th>
                                        <th style="width: 80px; text-align: center;">工种类别</th>
                                    </tr>
                                    </thead>
                                    <tbody id="TableFile"></tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
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
    <input type="hidden" id="sfzh" name="sfzh" class="aac147" value=""/>
    <input type="hidden" id="dnh" name="dnh" class="pcno" value="${gtywinfos[0].dnh}"/>
    <input type="hidden" id="ywbh" name="ywbh" value="${ywinfo.pywinfo.code}"/>
    <input type="hidden" id="ywmc" name="ywmc" value="${ywinfo.pywinfo.name}"/>
    <input type="hidden" id="xm" name="xm" class="aac003" value=""/>
    <input type="hidden" id="dwbh" name="dwbh" class="dwbh" value=""/>
    <input type="hidden" id="dwmc" name="dwmc" class="dwmc" value=""/>
    <input type="hidden" id="phone" name="phone" class="aac067" value=""/>
</form>
<script>
    $(document).ready(function () {
        flushCheckBox();
        flushDateTime();
        $("table").resizableColumns({});
        /*  var tpl = $("#baseTableTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g, ""); */
        /*  updateBaseTable({msg: '0'}, tpl); */

        $("[data-toggle='tooltip']").tooltip({
            delay: {show: 1000, hide: 200}
        });
        $("[data-toggle='popover']").popover();
    });

    function searchPerson() {
        $("#personInfoForm input").val("");
        if ($("#aac147").val().trim() == "" && $("#aac002").val().trim() == "") {
            $("#aac147").focus();
            showTip("请输入社保电脑号或者个人身份证号进行查询", 'info', 2000, 0);
            twinkle("#aac147");
            twinkle("#aac002");
        } else {
            $.post("${ctx}/gtxt/accept/pension/IdSpecialWorkSelect", {
                dnh: $("#aac002").val(),
                sfzh: $("#aac147").val()
            }, function (data) {
                for (var i in data) {
                    $("." + i).val(data[i]);
                }
            });
        }
        return false;
    }

    function flushCheckBox() {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square_gd',
            radioClass: 'iradio_square_gd',
            increaseArea: '20%' // optional
        });
    }

    function flushDateTime() {
        //日期插件
        $('.form_date').datetimepicker({
            language: 'zh-CN',
            format: "yyyy-mm-dd",
            weekStart: 1,
            todayBtn: 1,
            autoclose: true,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: true,
            pickerPosition: 'bottom-left'
        });
    }

    function flushSelect() {
        $('.selectpicker').selectpicker({
//            style: 'btn-info'
            size: 10
        });
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

    function tijiao() {
        if (($("#aac147").val() == null && $("#aac002").val() == null) || ($("#aac147").val() == undefined && $("#aac002").val() == undefined) || ($("#aac147").val() == '' && $("#aac002").val() == '')) {
            twinkle("#inputBar");
        } else if (!checkNumber("#paperTable").boo) {
            twinkle("#paperTable");
        } else {
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
                if (hzdh == null || hzdh == undefined || hzdh == '') {
                    submit();
                } else {
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
    function add_tr() {
        var tpl = $("#temp").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
        $("#TableFile").append(Mustache.render(tpl));
        flushCheckBox();
        flushDateTime();
        flushSelect();
//        var a = $("#personInfoForm").serializeJson();
//        a = $("#searchForm").serializeJson(a);
//        console.log(a);
    }
    <%--
    起始时间 aae041Date
    截至时间	aae042Date
    单位名称	aab004
    单位类型	aab019
    文件依据	baz125
    工种类别 aac019
--%>
    function del_tr() {
        $('input[name="cbk"]').each(function () {
            if (this.checked) {
                $(this).closest('tr').remove();
            }
        });
        var arr = [];
        $(".tatr").each(function () {
            var a = {};
            a["aae041Date"] = $(this).find("input[name='aae041Date']").val();
            a["aae042Date"] = $(this).find("input[name='aae042Date']").val();
            a["aab004"] = $(this).find("input[name='aab004']").val();
            a["aab019"] = $(this).find("select[name='aab019']").val();
            a["baz125"] = $(this).find("input[name='baz125']").val();
            a["aac019"] = $(this).find("select[name='aac019']").val();
            arr.push(a);
        });
        console.log(arr);
    }
    function checkMultiBusiness() {
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

    function submit() {
        var arr = [];
        $(".tatr").each(function () {
            var a = {};
            a["t1"] = $(this).find("input[name='t1']").val();
            a["t2"] = $(this).find("input[name='t2']").val();
            a["t3"] = $(this).find("input[name='t3']").val();
            a["t4"] = $(this).find("input[name='t4']").val();
            a["t5"] = $(this).find("input[name='t5']").val();
            a["t6"] = $(this).find("input[name='t6']").val();
            a["t7"] = $(this).find("input[name='t7']").val();
            arr.push(a);
        });
        /* var inputs = [];
         $(".tatr").each(function(){
         var input ={};
         $(this).find("input").each(function(){
         input[this.name] = this.value;
         });
         inputs.push(input);
         });
         console.log(inputs);
         var json = JSON.stringify(inputs);
         document.getElementById("inputs").value=json; */
        var data = $("#infoForm").serializeJson();
        $("#jsoninfo").val(JSON.stringify(data));
        var cls = checkNumber("#paperTable").values;
        $("#cls").val(JSON.stringify(cls));
        $("#submitForm").submit();
    }
</script>
<%--
    起始时间 aae041Date
    截至时间	aae042Date
    单位名称	aab004
    单位类型	aab019
    文件依据	baz125
    工种类别 aac019
--%>
<script type="text/template" id="temp">
    <tr class='tatr'>
        <td style='width: 50px; text-align: center;'>
            <input type='checkbox' name='cbk'/>
        </td>
        <td style='width: 80px; text-align: center;'>
            <input readonly type='text' class="form-control" style='width: 100%;' value="{{num}}"/>
        </td>
        <td style='width: 80px; text-align: center;'>
            <div class="input-group date form_date" data-date-format="yyyy-mm-dd">
                <input class="form-control testdate" type="text" name="aae041Date" readonly/>
                <span class="input-group-addon">
                    <i class="glyphicon glyphicon-remove"></i>
                </span>
                <span class="input-group-addon">
                    <i class="glyphicon glyphicon-calendar"></i>
                </span>
            </div>
        </td>
        <td style='width: 80px; text-align: center;'>
            <div class="input-group date form_date" data-date-format="yyyy-mm-dd">
                <input class="form-control testdate" type="text" name="aae042Date" readonly/>
                <span class="input-group-addon">
                    <i class="glyphicon glyphicon-remove"></i>
                </span>
                <span class="input-group-addon">
                    <i class="glyphicon glyphicon-calendar"></i>
                </span>
            </div>
        </td>
        <td style='width: 80px; text-align: center;'>
            <input type='text' class="form-control" style='width: 100%;' name='aab004'>
        </td>
        <td style='width: 80px; text-align: center;'>
            <select name="aab019" class="form-control selectpicker">
                <option value="100">正常企业</option>
                <option value="900">系统虚拟单位</option>
                <option value="120">改制企业</option>
                <option value="130">双低单位</option>
                <option value="135">代理单位</option>
                <option value="140">个体工商户（有雇工的）</option>
                <option value="141">国有企业</option>
                <option value="142">集体企业</option>
                <option value="143">股份制</option>
                <option value="144">私营企业</option>
                <option value="145">行业统筹</option>
                <option value="146">个体工商户(人才代理)</option>
                <option value="150">失地转城保单位</option>
                <option value="160">协保单位</option>
                <option value="170">定补单位</option>
                <option value="200">机关</option>
                <option value="301">集体全额拨款事业单位</option>
                <option value="310">差额拨款事业单位</option>
                <option value="311">集体差额拨款事业单位</option>
                <option value="321">集体自收自支事业单位</option>
                <option value="322">自收自支事业(人才个人代管)</option>
                <option value="340">社会团体(机关事业)</option>
                <option value="410">技校</option>
                <option value="420">中学</option>
                <option value="440">幼儿园</option>
                <option value="500">自谋职业虚拟单位</option>
                <option value="600">银行</option>
                <option value="700">区</option>
                <option value="710">街道</option>
                <option value="730">组</option>
                <option value="800">社保经办机构</option>
                <option value="910">建筑施工</option>
                <option value="920">合并后废弃</option>
                <option value="990">其它</option>
                <option value="300">全额拨款事业单位</option>
                <option value="320">自收自支事业单位</option>
                <option value="400">大学</option>
                <option value="430">小学</option>
                <option value="450">其他</option>
                <option value="610">银行网点</option>
                <option value="720">社区</option>
                <option value="110">破产企业</option>
            </select>
        </td>
        <td style='width: 80px; text-align: center;'>
            <input type='text' class="form-control" style='width: 100%;' name='baz125'>
        </td>
        <td style='width: 80px; text-align: center;'>
            <select name="aac019" class="form-control selectpicker">
                <option value="1">有毒有害</option>
                <option value="2">低温</option>
                <option value="4">高温</option>
                <option value="9">其他</option>
                <option value="5">高空</option>
                <option value="3">井下</option>
                <option value="6">特别繁重体力劳动</option>
            </select>
        </td>
    </tr>
</script>

</body>
</html>
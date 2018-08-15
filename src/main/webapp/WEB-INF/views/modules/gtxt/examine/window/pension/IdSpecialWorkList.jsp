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
    <div class="row">
        <div class="span12">
            <div class="bs-callout bs-callout-info" style=" padding: 5px; margin: 0 0 10px 0; line-height: 30px;">
                <div class="row">
                    <div class="span2">
                        <span class="navbar-brand">${ywinfo.pywinfo.name}</span>
                    </div>
                    <div class="span10">
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
                        <input type="hidden" name="aac001" class="aac001"/>
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
                            <label class="span1 control-label">证件号码</label>
                            <div class="span2">
                                <input readonly type="text" class="form-control aac147" id="aac147" name="aac147"/>
                            </div>
                            <label class="span1 control-label">性别</label>
                            <div class="span2">
                                <input readonly type="text" class="form-control aac004" id="aac004" name="aac004"/>
                            </div>
                            <label class="span1 control-label">出生年月</label>
                            <div class="span2">
                                <input readonly type="text" class="form-control aac006" id="aac006" name="aac006"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="span1 control-label">参加工作时间</label>
                            <div class="span2">
                                <input readonly type="text" class="form-control aac007" id="aac007" name="aac007"/>
                            </div>
                            <label class="span1 control-label">家庭地址</label>
                            <div class="span8">
                                <input readonly type="text" class="form-control aae006" id="aae006" name="aae006"/>
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
                            <%--<div class="form-group">
                                <div class="span12">
                                    <button type="button" class="btn btn-sm yellow" onclick="add_tr();">添加</button>
                                    <button type="button" class="btn btn-sm yellow" onclick="del_tr();">删除</button>
                                </div>
                            </div>--%>
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
                            <br>
                            <div class="form-group">
                                <label class="span1 control-label">备注</label>
                                <div class="span11">
                                    <input id="aae013" name="aae013" type="text" class="form-control"
                                           style="width: 100%"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        审核意见
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i
                                class="fa fa-minus"></i></button>
                    </div>
                </div>
                <div class="box-body" style="margin: 0;">
                    <div class="form-horizontal">
                        <textarea name="" id="" cols="30" rows="10"></textarea>
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

        $("[data-toggle='tooltip']").tooltip({
            delay: {
                show: 1000,
                hide: 200
            }
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

    function add_tr() {
        var tpl = $("#temp").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
        $("#TableFile").append(Mustache.render(tpl));
        flushCheckBox();
        flushDateTime();
        var a = $("#personInfoForm").serializeJson();
        a = $("#searchForm").serializeJson(a);
        console.log(a);
    }
    function del_tr() {
        $('input[name="cbk"]').each(function () {
            if (this.checked) {
                $(this).closest('tr').remove();
            }
        });
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
<script type="text/template" id="temp">
    <tr class='tatr'>
        <td style='width: 50px; text-align: center;'>
            <input type='checkbox' name='cbk'/>
        </td>
        <td style='width: 80px; text-align: center;'>
            <input type='text' style='width: 100%;' name='t1'/>
        </td>
        <td style='width: 80px; text-align: center;'>
            <div class="input-group date form_date" data-date-format="yyyy-mm-dd">
                <input class="form-control testdate" type="text" name="t2" readonly/>
                <span class="input-group-addon">
                    <i class="glyphicon glyphicon-remove"></i>
                </span>
                <span class="input-group-addon">
                    <i class="glyphicon glyphicon-calendar"></i>
                </span>
            </div>
        </td>
        <td style='width: 80px; text-align: center;'>
            <input type='text' style='width: 100%;' name='t3'>
        </td>
        <td style='width: 80px; text-align: center;'>
            <input type='text' style='width: 100%;' name='t4'>
        </td>
        <td style='width: 80px; text-align: center;'>
            <input type='text' style='width: 100%;' name='t5'>
        </td>
        <td style='width: 80px; text-align: center;'>
            <input type='text' style='width: 100%;' name='t6'>
        </td>
        <td style='width: 80px; text-align: center;'>
            <input type='text' style='width: 100%;' name='t7'>
        </td>
    </tr>
</script>

</body>
</html>

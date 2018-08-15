<%--
  Created by IntelliJ IDEA.
  User: cxd
  Date: 2016/9/6
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>窗口审核详细</title>
    <meta name="decorator" content="default"/>
    <style>
        td, td * {
            /*word-break: keep-all;
            word-wrap: break-word;*/
        }

        .ulHead {
            text-align: center;
            background-color: #2fa4e7;
            color: white;
            line-height: 30px;
            border-radius: 3px;
        }

        .dl-horizontal dd {
            margin-left: 110px;
        }

        #personInfo {
            font-size: 14px;
        }

        #personInfo th {
            text-align: right;
            width: 70px;
        }

        #yewuleixing th {
            text-align: right;
            width: 70px;
        }

        .form-horizontal .controls {
            margin-left: 60px;
        }

        #tableinfo tr td input, select {
            margin: 0px;
            /*margin-left: 10px;*/
            width: 250px;
        }

        #tableinfo .titleinfo {
            text-align: right;
            width: 130px;
            padding-right: 10px;
        }

        /*#contenttable{*/
        /*width: 800px;*/
        /*}*/

        #contenttable, #luruinfo {
            border: 1px solid #ddd;
            border-collapse: separate;
            border-radius: 6px;
            border-top: none;
        }

        #tableinfo .longstyle {
            width: 669px;
        }

        #luruinfo tr td input {
            margin: 0px;
            /*margin-left: 10px;*/
            width: 250px;
        }

        #luruinfo .titleinfo {
            text-align: right;
            width: 130px;
            padding-right: 10px;
        }

        .form-search .ul-form li label {
            width: 130px;
        }

        .selectWidth {
            width: 164px;
        }

        .inputWidth {
            width: 150px;
        }

        #familyTable td {
            padding: 0;
        }

        #familyTable td input {
            text-align: center;
        }
    </style>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/gtxt/examine/window/list?pageNo=${(not empty pageNo)?pageNo : 0}">窗口审核列表</a></li>
    <li class="active"><a href="#examine" data-toggle="tab" style="color: red;">审核内容</a></li>
    <li><a href="#YWCXBQ09" data-toggle="tab">审核材料</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">基本信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">个人缴费基本信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">历史缴费信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">历史住院信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">转诊信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">长住异地信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">门诊病种信息</a></li>
</ul>
<div id="myTabContent" class="tab-content">
    <div class="tab-pane active" id="examine">
        <input id="ywlsh" type="hidden" value="${ywlsh}">
        <input id="dwbh" type="hidden" value="${busRecviewBean.DWBH}"/>
        <input id="idcd" type="hidden" value="${busRecviewBean.SFZH}"/>
        <input id="newywbh" type="hidden" value="${newywbh}"/>
        <input id="lczt" type="hidden" value="${busRecviewBean.LCZT}"/>
        <input id="by15" type="hidden" value="${busRecviewBean.BY15}"/>
        <div>
            <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                <tr>
                    <th width="80">业务名称</th>
                    <td width="250">${typename}</td>
                    <th width="80">受理回执号</th>
                    <td></td>
                    <th width="80">业务流水号</th>
                    <td></td>
                </tr>
                <tr>
                    <th width="80">身份证号</th>
                    <td></td>
                    <th width="80">姓名</th>
                    <td></td>
                    <th width="80">所在单位</th>
                    <td></td>
                </tr>
                <tr>
                    <th width="80">经办人</th>
                    <td></td>
                    <th width="80">经办时间</th>
                    <td></td>
                    <th width="80">联系电话</th>
                    <td></td>
                </tr>
            </table>
            <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" href="#collapseOne"
                       style="text-align: center; font-size: 18px;">
                        审核信息
                    </a>
                </div>
                <div id="collapseOne" class="accordion-body collapse in">
                    <div class="accordion-inner" style="padding: 0;">
                        <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                            <tr>
                                <th width="80">丧葬补助金</th>
                                <td></td>
                                <th width="80">一次性工亡补助金</th>
                                <td></td>
                                <th width="80">核定单号</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th width="80">合计金额</th>
                                <td></td>
                                <th width="80">事故类别</th>
                                <td></td>
                                <th width="80">死亡时间</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th width="80">是否结案</th>
                                <td></td>
                                <th width="80">是否先行支付</th>
                                <td></td>
                                <th width="80">个人平均工资</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th width="80">先行支付原因</th>
                                <td colspan="5"></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" href="#collapseTwo"
                       style="text-align: center; font-size: 18px;">
                        录入信息
                    </a>
                </div>
                <div id="collapseTwo" class="accordion-body collapse in">
                    <div class="accordion-inner" style="padding: 0;">
                        <center>
                            <div id="controlForm" class="breadcrumb form-search" style=" margin: 0; border: 0;">
                                <ul class="ul-form" style="">
                                    <li><label for="sqr" style="width: 200px;">是否支付丧葬补助金：</label>
                                        <select id="sqr" name="sqr" class="input-medium selectWidth">
                                            <option value="0">否</option>
                                            <option value="1">是</option>
                                        </select>
                                    </li>
                                    <li><label for="sqr" style="width: 200px;">是否支付一次性工亡补助金：</label>
                                        <select id="sqr" name="sqr" class="input-medium selectWidth">
                                            <option value="0">否</option>
                                            <option value="1">是</option>
                                        </select>
                                    </li>
                                </ul>
                                <div style="padding: 0; ">
                                    <table class="table table-striped table-bordered table-condensed">
                                        <tr>
                                            <th>
                                                审核意见
                                            </th>
                                        </tr>
                                        <tr>
                                            <td style="width: 100%; padding: 0;" align="center">
                                                <textarea name="" id="" rows="4"
                                                          style="width: 98%; resize: none;"></textarea>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="breadcrumb pull-left" style="margin-top: 3px; margin-right: 10px;">
                                    <button type="button" onclick="addFamily()" class="btn btn-warning"
                                            style="width: 110px;"><i
                                            class="icon-cloud-upload"></i>&nbsp; 添加亲属
                                    </button>
                                    <button type="button" onclick="delFamily();" class="btn btn-warning"
                                            style="width: 110px;"><i
                                            class="icon-cloud-upload"></i>&nbsp; 删除亲属
                                    </button>
                                </div>
                                <div>
                                    <table id="familyTable" class="table table-striped table-bordered table-condensed">
                                    </table>
                                </div>
                            </div>
                        </center>
                    </div>
                </div>
            </div>
            <center>
                <div class="breadcrumb" style="margin-top: 3px; margin-right: 10px;">
                    <button type="button" id="ywbanjie" onclick="yewubanjie()" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-cloud-upload"></i>&nbsp; 提 交
                    </button>
                    <button type="button" id="lrfpxx" onclick="fapiao()" class="btn btn-warning"
                            style="width: 110px; padding-left: 3px; padding-right: 3px;"><i
                            class="icon-edit"></i>&nbsp;发票信息录入
                    </button>
                    <button type="button" id="xiugai" onclick="xiugai()" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-pencil"></i>&nbsp; 计 算
                    </button>
                    <button type="button" id="baocun" onclick="baocun()" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-save"></i>&nbsp; 保 存
                    </button>
                    <button type="button" id="qxxiugai" onclick="qxxiugai()" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-picture"></i>&nbsp;补充材料
                    </button>
                    <button type="button" id="bdzhuanjian" onclick="forwording()" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-external-link"></i>&nbsp;中止任务
                    </button>
                    <button type="button" id="fanhui"
                            onclick="location.href='${ctx}/sisl/busreview/list?pageNo=${pageNo}'" class="btn"
                            style="width: 110px;"><i
                            class="icon-reply"></i>&nbsp;返回前台
                    </button>
                </div>
            </center>
            <%--<div id="centerDiv" class="breadcrumb form-search" style="margin: 0; text-align: center;">

            </div>--%>
        </div>
    </div>
    <div class="tab-pane" id="YWCXBQ09">...</div>
    <div class="tab-pane" id="YWCXBQ01">...</div>
</div>
<script type="text/javascript">
    function fapiao() {
        top.$.jBox.open("iframe:${ctx}/gtxt/utils/util/fapiao?type=injury", "发票录入或修改", 1000, 600, {
            loaded: function () {
                closeTip();
                $(".jbox-content", top.document).css("overflow-y", "auto");
            },
            closed: function () {

            },
            opacity: 0.5,
            border: 1,
            iframeScrolling: "auto",
            persistent: true,
            buttons: {'保存': 'save'},
            submit: function (v, h, f) {
                if (v == "save") {
                    alertx("发票录入保存成功！");
                }
            }
        });
    }

    var familyNum = 0;
    function addFamily() {
        var tpl = $("#familyTemplate").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
        $("#familyTable").append(Mustache.render(tpl, {'familyId': 'family' + familyNum}));
        familyNum++;
    }

    function delFamily() {
        var boxs = $("#familyTable input[name='familyBox']:checked");
        $(boxs).each(function () {
            $("." + $(this).val()).remove();
        });
    }
</script>
<script type="text/template" id="familyTemplate">
    <tr class="{{familyId}}">
        <th rowspan="4" style="width: 20px;"><input type="checkbox" name="familyBox" value="{{familyId}}"/></th>
        <th style="width: 70px;">是否需要供养</th>
        <th style="width: 60px;">遗属姓名</th>
        <th style="width: 140px;">身份证</th>
        <th style="width: 40px;">性别</th>
        <th style="width: 70px;">出生年月</th>
        <th style="width: 70px;">年龄</th>
        <th>与属主关系</th>
        <th>供养开始时间</th>
        <th>供养月数</th>
        <th>供养比例</th>
        <th>供养抚恤金</th>
        <th>丧葬补助金</th>
        <th>一次性工亡补助金</th>
    </tr>
    <tr class="{{familyId}}">
        <td>
            <select name="sqr" style="width: 100%; margin: 0; ">
                <option value="0">否</option>
                <option value="1">是</option>
            </select>
        </td>
        <td>
            <input name="phone" type="text" htmlEscape="false" maxlength="50"
                   style="width: 100%; height: 100%; margin: 0; padding: 0; "/>
        </td>
        <td>
            <input name="phone" type="text" htmlEscape="false" maxlength="50"
                   style="width: 100%; height: 100%; margin: 0; padding: 0; "/>
        </td>
        <td>
            <select name="sex" style="width: 100%; margin: 0; ">
                <option value="1">男</option>
                <option value="0">女</option>
            </select>
        </td>
        <td>
            <input name="sqr7" type="text" readonly="readonly" class="Wdate"
                   value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM'/*,isShowClear:true*/});"
                   style="width: 100%; height: 100%; margin: 0; padding: 0;"
                   maxlength="20"/>
        </td>
        <td>
            <input name="age" type="text" htmlEscape="false" maxlength="50"
                   style="width: 100%; height: 100%; margin: 0; padding: 0; "/>
        </td>
        <td>
            <input name="age" type="text" htmlEscape="false" maxlength="50"
                   style="width: 100%; height: 100%; margin: 0; padding: 0; "/>
        </td>
        <td>
            <input name="sqr7" type="text" class="Wdate"
                   value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                   style="width: 100%; height: 100%; margin: 0; padding: 0;"
                   maxlength="20"/>
        </td>
        <td>
            <input name="age" type="text" htmlEscape="false" maxlength="50"
                   style="width: 100%; height: 100%; margin: 0; padding: 0; "/>
        </td>
        <td>
            <input name="age" type="text" htmlEscape="false" maxlength="50"
                   style="width: 100%; height: 100%; margin: 0; padding: 0; "/>
        </td>
        <td>
            <input name="age" type="text" htmlEscape="false" maxlength="50"
                   style="width: 100%; height: 100%; margin: 0; padding: 0; "/>
        </td>
        <td>
            <input name="age" type="text" htmlEscape="false" maxlength="50"
                   style="width: 100%; height: 100%; margin: 0; padding: 0; "/>
        </td>
        <td>
            <input name="age" type="text" htmlEscape="false" maxlength="50"
                   style="width: 100%; height: 100%; margin: 0; padding: 0; "/>
        </td>
    </tr>
    <tr class="{{familyId}}">
        <th colspan="3">地址</thcol>
        <th>邮政编码</th>
        <th>联系人</th>
        <th>联系电话</th>
        <th colspan="2">银行名称</th>
        <th colspan="2">银行账号</th>
        <th colspan="2">开户户名</th>
        <th>银行代码</th>
    </tr>
    <tr class="{{familyId}}" style="height: 30px;">
        <td colspan="3">
            <input name="age" type="text" htmlEscape="false" maxlength="50"
                   style="width: 100%; height: 100%; margin: 0; padding: 0; "/>
        </td>
        <td>
            <input name="age" type="text" htmlEscape="false" maxlength="50"
                   style="width: 100%; height: 100%; margin: 0; padding: 0; "/>
        </td>
        <td>
            <input name="age" type="text" htmlEscape="false" maxlength="50"
                   style="width: 100%; height: 100%; margin: 0; padding: 0; "/>
        </td>
        <td>
            <input name="age" type="text" htmlEscape="false" maxlength="50"
                   style="width: 100%; height: 100%; margin: 0; padding: 0; "/>
        </td>
        <td colspan="2">
            <input name="age" type="text" htmlEscape="false" maxlength="50"
                   style="width: 100%; height: 100%; margin: 0; padding: 0; "/>
        </td>
        <td colspan="2">
            <input name="age" type="text" htmlEscape="false" maxlength="50"
                   style="width: 100%; height: 100%; margin: 0; padding: 0; "/>
        </td>
        <td colspan="2">
            <input name="age" type="text" htmlEscape="false" maxlength="50"
                   style="width: 100%; height: 100%; margin: 0; padding: 0; "/>
        </td>
        <td>
            <input name="age" type="text" htmlEscape="false" maxlength="50"
                   style="width: 100%; height: 100%; margin: 0; padding: 0; "/>
        </td>
    </tr>
</script>
</body>
</html>

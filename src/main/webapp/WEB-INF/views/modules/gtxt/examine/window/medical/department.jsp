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
    <title>住院报销</title>
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
                    <td width="250">${gtywinfo.ywmc}</td>
                    <th width="80">受理回执号</th>
                    <td>${gtywinfo.hzdh}</td>
                    <th width="80">业务流水号</th>
                    <td>${gtywinfo.ywlsh}</td>
                </tr>
                <tr>
                    <th width="80">身份证号</th>
                    <td>${gtywinfo.sfzh}</td>
                    <th width="80">姓名</th>
                    <td>${gtywinfo.xm}</td>
                    <th width="80">所在单位</th>
                    <td>${gtywinfo.dwmc}</td>
                </tr>
                <tr>
                    <th width="80">经办人</th>
                    <td>${gtywinfo.slr.name}</td>
                    <th width="80">经办时间</th>
                    <td><fmt:formatDate value="${gtywinfo.cjdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <th width="80">联系电话</th>
                    <td>${jsonData.phone}</td>
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
                                <th width="80">累计核准医疗费</th>
                                <td></td>
                                <th width="80">连续缴费月数</th>
                                <td></td>
                                <th width="80">可享受限额</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th width="80">基金支付合计</th>
                                <td></td>
                                <th width="80">个人按比例支付</th>
                                <td></td>
                                <th width="80">个人支付总额</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th width="80">本次累计核准医疗费</th>
                                <td></td>
                                <th width="80">起付补助</th>
                                <td></td>
                                <th width="80">基金支付合计</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th width="80">个人按比例支付</th>
                                <td></td>
                                <th width="80">个人支付总额</th>
                                <td></td>
                                <th width="80">是否冲减</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th width="80">住院报销结算单号</th>
                                <td></td>
                                <th width="80"></th>
                                <td></td>
                                <th width="80"></th>
                                <td></td>
                            </tr>
                        <%--</table>
                        <table class="table table-striped table-bordered table-condensed" style="margin: 0;">--%>
                            <tr>
                                <th width="80">补充医保本次纳入自付部分累计</th>
                                <td></td>
                                <th width="80">补充医保本次纳入高额部分累计</th>
                                <td></td>
                                <th width="80">补充医保本次自付部分补偿</th>
                                <td></td>
                            </tr>
                            </tr>
                            <tr>
                                <th width="80">补充医保本次纳入自费项目累计</th>
                                <td></td>
                                <th width="80">补充医保本次高额部分补偿</th>
                                <td></td>
                                <th width="80">补充医保自费项目报销金额</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th width="80">补充医保基金支付合计</th>
                                <td></td>
                                <th width="80">补充医保化疗药报销</th>
                                <td></td>
                                <th width="80">伤残军警财政垫支</th>
                                <td></td>
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
                            <form id="submitForm" action="${ctx}/gtxt/examine/window/save" method="post" style="margin: 0; border: 0;">
                                <input type="hidden" id="jsoninfo" name="jsoninfo"/>
                                <input type="hidden" id="ywlsh" name="ywlsh" value="${gtywinfo.ywlsh}"/>
                                <input type="hidden" id="ywid" name="ywid" value="${gtywinfo.ywid}"/>
                                <input type="hidden" id="flowcode" name="flowcode" value="${flowcode}"/>
                                <input type="hidden" id="shjbcode" name="shjbcode" value="${shjbcode}"/>
                                <input type="hidden" id="ywbh" name="ywbh" value="${gtywinfo.ywbh}"/>
                                <input type="hidden" id="ywmc" name="ywmc" value="${gtywinfo.ywmc}"/>
                                <input type="hidden" id="grsbh" name="grsbh" class="sino" value=""/>
                                <input type="hidden" id="sfzh" name="sfzh" class="idno" value=""/>
                                <input type="hidden" id="dnh" name="dnh" class="pcno" value=""/>
                                <input type="hidden" id="xm" name="xm" class="peosonname" value=""/>
                                <input type="hidden" id="dwbh" name="dwbh" class="dwbh" value=""/>
                                <input type="hidden" id="dwmc" name="dwmc" class="dwmc" value=""/>
                            </form>
                            <form id="infoForm" method="post" class="breadcrumb form-search" style=" margin: 0; border: 0;">
                                <ul class="ul-form" style="">
                                    <li>
                                        <label for="yearmybacktotal" style="width: 180px;">本年度补充医保自付补偿累计:</label>
                                        <input id="yearmybacktotal" name="yearmybacktotal" type="text" value=""
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="yearmyhightotal" style="width: 180px;">本年度补充医保高额补偿累计:</label>
                                        <input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="yearmytotal" style="width: 180px;">本年度补充医保自费项目累计:</label>
                                        <input id="yearmytotal" name="yearmytotal" type="text" value=""
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="yearmytotal" style="width: 180px;">补充医保自费项目病种名称:</label>
                                        <input id="yearmytotal" name="yearmytotal" type="text" value=""
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="yearmytotal" style="width: 180px;">补充医保自费项目药品名称:</label>
                                        <input id="yearmytotal" name="yearmytotal" type="text" value=""
                                               class="input-xxlarge"
                                               style="width: 510px;"/>
                                    </li>
                                    <li class="clearfix"></li>
                                    <hr/>
                                    <li>
                                        <label for="sqr1">扣起付次数:</label>
                                        <input id="sqr1" name="dnh" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label>选择医院：</label>
                                        <sys:treeselect id="hospital" name="hospital.code" value="${work.fenqu.code}"
                                                        labelName="fenqu.name"
                                                        labelValue="${work.fenqu.name}" notAllowSelectParent="false"
                                                        title="医院" url="/xq/area/treeData" cssClass="input-small"
                                                        cssStyle="width: 105px;"
                                                        allowClear="true"/>
                                    </li>
                                    <li><label for="sqr">医院等级：</label>
                                        <select id="sqr" name="sqr" class="input-medium selectWidth">
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                        </select>
                                    </li>
                                    <li>
                                        <label for="sqr2">报销类型：</label>
                                        <select id="sqr2" name="sqr2" class="input-medium selectWidth">
                                            <option value="1">市内住院现金报销</option>
                                            <option value="2">市外转诊现金报销</option>
                                            <option value="3">合并其他险种住院报销</option>
                                            <option value="4">一次性材料费报销</option>
                                            <option value="5">未核准一次性材料费报销</option>
                                            <option value="6">急诊住院现金报销</option>
                                            <option value="7">门诊放、化疗</option>
                                            <option value="8">门诊碎石</option>
                                            <option value="9">他院检查、购药(市外)</option>
                                        </select>
                                    </li>
                                    <li>
                                        <label for="sqr3">计算起付标准：</label>
                                        <select id="sqr3" name="sqr3" class="input-medium selectWidth">
                                            <option value="0">否</option>
                                            <option value="1">是</option>
                                        </select>
                                    </li>
                                    <li>
                                        <label for="sqr4">缴费类型：</label>
                                        <select id="sqr4" name="sqr4" class="input-medium selectWidth">
                                            <option value="0">无</option>
                                            <option value="1">。。。</option>
                                        </select>
                                    </li>
                                   <!--  <li>
                                        <label for="sqr5">分成费用：</label>
                                        <input id="sqr5" name="sqr5" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="sqr6">初步核准医疗费：</label>
                                        <input id="sqr6" name="sqr6" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li> -->
                                    <li>
                                        <label for="sqr7">其他报销额：</label>
                                        <input id="sqr7" name="sqr7" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="sqr7">违规开始日期：</label>
                                        <input name="sqr7" type="text" readonly="readonly"
                                               maxlength="20" class="input-mini Wdate"
                                               value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                                               style="width: 150px;"/>
                                    </li>
                                    <li>
                                        <label for="sqr7">违规结束日期：</label>
                                        <input name="sqr7" type="text" readonly="readonly"
                                               maxlength="20" class="input-mini Wdate"
                                               value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                                               style="width: 150px;"/>
                                    </li>
                                    <li>
                                        <label for="sqr7">不予报销住院天数：</label>
                                        <input id="sqr7" name="sqr7" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="sqr7">起付标准：</label>
                                        <input id="sqr7" name="sqr7" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="sqr7">实际医疗费：</label>
                                        <input id="sqr7" name="sqr7" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="sqr7">分摊医疗费：</label>
                                        <input id="sqr7" name="sqr7" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="sqr7">核准医疗费：</label>
                                        <input id="sqr7" name="sqr7" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="sqr7">化疗自费药：</label>
                                        <input id="sqr7" name="sqr7" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="sqr7">材料核准药：</label>
                                        <input id="sqr7" name="sqr7" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="sqr7">PET费用：</label>
                                        <input id="sqr7" name="sqr7" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="sqr7">违规核准医疗费：</label>
                                        <input id="sqr7" name="sqr7" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="sqr4">是否纳入总控结：</label>
                                        <select id="sqr4" name="sqr4" class="input-medium selectWidth">
                                            <option value="1">不纳入总控管理</option>
                                            <option value="2">纳入总控管理</option>
                                        </select>
                                    </li>
                                </ul>
                                <div style="padding: 0; ">
                                    <table class="table table-striped table-bordered table-condensed">
                                        <tr>
                                            <th>
                                                诊断
                                            </th>
                                        </tr>
                                        <tr>
                                            <td style="width: 100%; padding: 0;" align="center">
                                                <textarea name="" id="" rows="4" style="width: 98%; resize: none;"></textarea>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </form>
                        </center>
                    </div>
                </div>
            </div>
            <center>
                <div class="breadcrumb" style="margin-top: 3px; margin-right: 10px;">
                    <button type="button" id="ywbanjie" onclick="tijiao()" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-cloud-upload"></i>&nbsp; 提 交
                    </button>
                    <button type="button" id="xgqfb" onclick="qxxiugai()" class="btn btn-warning"
                            style="width: 110px; padding-left: 3px; padding-right: 3px;"><i
                            class="icon-edit"></i>&nbsp;起付标准修改
                    </button>
                    <button type="button" id="lrfpxx" onclick="fapiao()" class="btn btn-warning"
                            style="width: 110px; padding-left: 3px; padding-right: 3px;"><i
                            class="icon-edit"></i>&nbsp;发票信息录入
                    </button>
                    <button type="button" id="qdsh" onclick="qxxiugai()" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-legal"></i>&nbsp;清单审核
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
    function fapiao(){
        top.$.jBox.open("iframe:${ctx}/gtxt/utils/util/fapiao?type=medical", "发票录入或修改", 1000, 600, {
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
            buttons: {'保存': 'save' },
            submit: function (v, h, f) {
                if (v == "save") {
                    alertx("发票录入保存成功！");
                }
            }
        });
    }
    function qxxiugai(){
        top.$.jBox.open("iframe:${ctx}/gtxt/utils/util/qingdan?type=medical", "清单录入或修改", 1000, 600, {
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
            buttons: {'保存': 'save' },
            submit: function (v, h, f) {
                if (v == "save") {
                    alertx("清单录入保存成功！");
                }
            }
        });
    }

    function tijiao() {
        var data = $("#infoForm").serializeJson();

        $("#jsoninfo").val(JSON.stringify(data));
        $("#submitForm").submit();
    }
</script>
</body>
</html>

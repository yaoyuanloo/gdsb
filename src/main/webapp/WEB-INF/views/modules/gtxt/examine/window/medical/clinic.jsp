<%--
  Created by IntelliJ IDEA.
  User: cxdss
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
    </style>
</head>
<body>
<ul class="nav nav-tabs">
    <%--<li><a href="${ctx}/gtxt/examine/window/list?pageNo=${(not empty pageNo)?pageNo : 0}">窗口审核列表</a></li>--%>
    <li class="active"><a href="#examine" data-toggle="tab" style="color: red;">审核内容</a></li>
    <li><a href="#YWCL" data-toggle="tab">审核材料</a></li>
    <li><a href="#YWTXYL" data-toggle="tab">扫描图像</a></li>
        <gt:tags items="${tabs}" />
</ul>
<div id="myTabContent" class="tab-content">
    <div class="tab-pane active" id="examine">
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

                                <th width="80">报销年度</th>
                                <td></td>
                                <th width="80">报销截至日期</th>
                                <td></td>
                                <th width="80">连续缴费月数</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th width="80">核准医疗费累计</th>
                                <td></td>
                                <th width="80">报销上限</th>
                                <td></td>
                                <th width="80">可享受余额</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th width="80">恶性肿瘤备注</th>
                                <td></td>
                                <th width="80">缴费类型</th>
                                <td></td>
                                <th width="80">医院等级</th>
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
                                <th width="80">年底总核准医疗费累计</th>
                                <td></td>
                                <th width="80"></th>
                                <td></td>
                                <th width="80"></th>
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
                                        <label for="backscale">报销比例：</label>
                                        <select id="backscale" name="backscale" class="input-medium selectWidth">
                                            <option value="1">50%</option>
                                        </select>
                                    </li>
                                    <li><label for="Diseasename">病种名称：</label>
                                        <select id="Diseasename" name="Diseasename" class="input-medium selectWidth">
                                            <option value="1">高血压(合并靶器官)</option>
                                        </select>
                                    </li>
                                    <li>
                                        <label for="realmedicalmoney">实际医疗费:</label>
                                        <input id="realmedicalmoney" name="realmedicalmoney" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="approvalmedicalmoney">核准医疗费：</label>
                                        <input id="approvalmedicalmoney" name="approvalmedicalmoney" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="approvaldiacrisismoney">核准诊疗费：</label>
                                        <input id="approvaldiacrisismoney" name="approvaldiacrisismoney" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
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
                                                <textarea name="examineopinion" id="examineopinion" rows="4" style="width: 98%; resize: none;"></textarea>
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
                    <%--<button type="button" id="qxxiugai" onclick="qxxiugai()" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-picture"></i>&nbsp;补充材料
                    </button>--%>
                    <button type="button" id="bdzhuanjian" onclick="forwording()" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-external-link"></i>&nbsp;中止任务
                    </button>
                    <button type="button" id="fanhui"
                            onclick="/*history.go(-1);*/" class="btn"
                            style="width: 110px;"><i
                            class="icon-reply"></i>&nbsp;返回前台
                    </button>
                </div>
            </center>
            <%--<div id="centerDiv" class="breadcrumb form-search" style="margin: 0; text-align: center;">

            </div>--%>
        </div>
    </div>
    <div class="tab-pane" id="YWCL">
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
                            <th>材料名称</th>
                        </tr>
                        </thead>
                        <tbody id="paperTable">
                        <c:forEach items="${cailiaoList}" var="cl">
                            <tr value="${cl.id}">
                                <td>${cl.name}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="tab-pane" id="YWTXYL" style="width: 100%; height: 100%; margin: 0; border: 0; padding: 0;">
        <iframe style="width: 100%; height: 700px; margin: 0; border: 0; padding: 0;" src="${ctx}/gt/gtSmjinfo/listShow?ywlsh=${gtywinfo.ywlsh}"></iframe>
    </div>
    <gt:tagsContent />
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

    function tijiao() {
        var data = $("#infoForm").serializeJson();
        $("#jsoninfo").val(JSON.stringify(data));
        $("#submitForm").submit();
    }
</script>
</body>
</html>

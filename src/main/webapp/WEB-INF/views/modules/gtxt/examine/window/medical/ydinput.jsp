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
    <gt:tags items="${tabs}"/>
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
                                <th width="80">姓名</th>
                                <td width="300">
                                    <input name="aac003" type="text"
                                           htmlEscape="false" maxlength="50"
                                           class="input-medium inputWidth"/>
                                </td>
                                <th width="80">证件号码</th>
                                <td width="300">
                                    <input name="aac002" type="text"
                                           htmlEscape="false" maxlength="50"
                                           class="input-medium inputWidth"/>
                                </td>
                                <th width="80">性别</th>
                                <td width="300">
                                    <input name="aac004" type="text"
                                           htmlEscape="false" maxlength="50"
                                           class="input-medium inputWidth"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="80">出生日期</th>
                                <input name="aac006" type="text"
                                                               htmlEscape="false" maxlength="50"
                                                               class="input-medium inputWidth"/>
                                <td>
                                </td>
                                <th width="80">参加工作日期</th>
                                <input name="aac00---" type="text"
                                       htmlEscape="false" maxlength="50"
                                       class="input-medium inputWidth"/>
                                <td>
                                </td>
                                <th width="80">单位管理号</th>
                                <input name="aab001" type="text"
                                       htmlEscape="false" maxlength="50"
                                       class="input-medium inputWidth"/>
                                <td>
                                </td>
                            </tr>
                            <tr>
                                <th width="80">单位名称</th>
                                <td>
                                    <input name="aab004" type="text"
                                           htmlEscape="false" maxlength="50"
                                           class="input-medium inputWidth"/>
                                </td>
                                <th width="80">人员类别</th>
                                <td>
                                    <input name="aacb066" type="text"
                                           htmlEscape="false" maxlength="50"
                                           class="input-medium inputWidth"/>
                                </td>
                                <th width="80">特殊人员类别</th>
                                <td>
                                    <input name="aab001" type="text"
                                           htmlEscape="false" maxlength="50"
                                           class="input-medium inputWidth"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="80">其他人员类别</th>
                                <td colspan="5">
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <form id="submitForm" action="${ctx}/gtxt/examine/window/save" method="post"
                  style="margin: 0; border: 0;">
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
            <form id="infoForm" method="post" class="" style="margin: 0; border: 0;">
                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" href="#collapse1"
                           style="text-align: center; font-size: 18px;">
                            异地申请信息
                        </a>
                    </div>
                    <div id="collapse1" class="accordion-body collapse in">
                        <div class="accordion-inner" style="padding: 0;">
                            <center>
                                <div class="breadcrumb form-search">
                                    <ul class="ul-form" style="">
                                        <li><label>异地申请受理号：</label>
                                            <input name="bke094" type="text"
                                                   htmlEscape="false" maxlength="50"
                                                   class="input-medium inputWidth"/>
                                        </li>
                                        <li><label>处理状态：</label>
                                            <select name="Diseasename" class="input-medium selectWidth">
                                                <option value="1"></option>
                                            </select>
                                        </li>
                                        <li>
                                            <label>受理部门:</label>
                                            <select name="bke087" class="input-medium selectWidth">
                                                <option value="1"></option>
                                            </select>
                                        </li>
                                        <li><label>与联系人关系：</label>
                                            <input name="bke077" type="text"
                                                   htmlEscape="false" maxlength="50"
                                                   class="input-medium inputWidth"/>
                                        </li>
                                        <li><label>联系人：</label>
                                            <input name="bke076" type="text"
                                                   htmlEscape="false" maxlength="50"
                                                   class="input-medium inputWidth"/>
                                        </li>
                                        <li><label>联系电话：</label>
                                            <input name="bke069" type="text"
                                                   htmlEscape="false" maxlength="50"
                                                   class="input-medium inputWidth"/>
                                        </li>
                                        <li><label>联系地址：</label>
                                            <input name="realmedicalmoney" type="text"
                                                   htmlEscape="false" maxlength="50"
                                                   class="input-medium inputWidth"/>
                                        </li>
                                    </ul>
                                </div>
                            </center>
                        </div>
                    </div>
                </div>
                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" href="#collapse2"
                           style="text-align: center; font-size: 18px;">
                            异地就医信息
                        </a>
                    </div>
                    <div id="collapse2" class="accordion-body collapse in">
                        <div class="accordion-inner" style="padding: 0;">
                            <center>
                                <div class="breadcrumb form-search">
                                    <ul class="ul-form" style="">
                                        <li><label>省内就医申请：</label>
                                            <input name="realmedicalmoney" type="text"
                                                   htmlEscape="false" maxlength="50"
                                                   class="input-medium inputWidth"/>
                                        </li>
                                        <li><label>异地就医待遇类型：</label>
                                            <select name="Diseasename" class="input-medium selectWidth">
                                                <option value="1"></option>
                                            </select>
                                        </li>
                                        <li>
                                            <label>省内就医待遇类型:</label>
                                            <select name="Diseasename" class="input-medium selectWidth">
                                                <option value="1"></option>
                                            </select>
                                        </li>
                                        <li><label>医疗保险类型：</label>
                                            <input name="realmedicalmoney" type="text"
                                                   htmlEscape="false" maxlength="50"
                                                   class="input-medium inputWidth"/>
                                        </li>
                                        <li><label>开始时间：</label>
                                            <input name="moneystartdate" type="text" readonly="readonly"
                                                   maxlength="20" class="input-mini Wdate"
                                                   value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                                                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                                                   style="width: 150px;"/>
                                        </li>
                                        <li><label>结束时间：</label>
                                            <input name="moneystartdate" type="text" readonly="readonly"
                                                   maxlength="20" class="input-mini Wdate"
                                                   value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                                                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                                                   style="width: 150px;"/>
                                        </li>
                                        <li><label>异地就医类型：</label>
                                            <select name="sqr2" class="input-medium">
                                                <option value="1">请选择</option>
                                            </select>
                                        </li>
                                        <li><label>有效期内可以记账次：</label>
                                            <input name="realmedicalmoney" type="text"
                                                   htmlEscape="false" maxlength="50"
                                                   class="input-medium inputWidth"/>
                                        </li>
                                        <li><label>异地类型：</label>
                                            <select name="sqr2" multiple="multiple" class="input-medium"
                                                    style="height: 24px;">
                                                <option value="正常异地">正常异地</option>
                                                <option value="周边异地">周边异地</option>
                                                <option value="泛珠异地">泛珠异地</option>
                                                <option value="省内异地">省内异地</option>
                                            </select>
                                        </li>
                                    </ul>
                                </div>
                            </center>
                        </div>
                    </div>
                </div>
                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" href="#collapse3"
                           style="text-align: center; font-size: 18px;">
                            异地申请安置地信息
                        </a>
                    </div>
                    <div id="collapse3" class="accordion-body collapse in">
                        <div class="accordion-inner" style="padding: 0;">
                            <center>
                                <div class="breadcrumb form-search">
                                    <ul class="ul-form" style="">
                                        <li><label>医疗机构名称：</label>
                                            <input name="realmedicalmoney" type="text"
                                                   htmlEscape="false" maxlength="50"
                                                   class="input-medium inputWidth"/>
                                        </li>
                                        <li><label>联系电话：</label>
                                            <input name="realmedicalmoney" type="text"
                                                   htmlEscape="false" maxlength="50"
                                                   class="input-medium inputWidth"/>
                                        </li>
                                        <li><label>联系人：</label>
                                            <input name="realmedicalmoney" type="text"
                                                   htmlEscape="false" maxlength="50"
                                                   class="input-medium inputWidth"/>
                                        </li>
                                        <li><label>邮编：</label>
                                            <input name="realmedicalmoney" type="text"
                                                   htmlEscape="false" maxlength="50"
                                                   class="input-medium inputWidth"/>
                                        </li>
                                        <li><label>等级：</label>
                                            <input name="realmedicalmoney" type="text"
                                                   htmlEscape="false" maxlength="50"
                                                   class="input-medium inputWidth"/>
                                        </li>
                                        <li><label>级别：</label>
                                            <input name="realmedicalmoney" type="text"
                                                   htmlEscape="false" maxlength="50"
                                                   class="input-medium inputWidth"/>
                                        </li>
                                        <li><label>类型：</label>
                                            <input name="realmedicalmoney" type="text"
                                                   htmlEscape="false" maxlength="50"
                                                   class="input-medium inputWidth"/>
                                        </li>
                                    </ul>
                                </div>
                            </center>
                        </div>
                    </div>
                </div>
                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" href="#collapse4"
                           style="text-align: center; font-size: 18px;">
                            邮寄信息
                        </a>
                    </div>
                    <div id="collapse4" class="accordion-body collapse in">
                        <div class="accordion-inner" style="padding: 0;">
                            <center>
                                <div class="breadcrumb form-search">
                                    <ul class="ul-form" style="">
                                        <li><label>邮寄标志：</label>
                                            <select id="sqr234" name="sqr2" class="input-medium">
                                                <option value="1">请选择</option>
                                            </select>
                                        </li>
                                        <li><label>处理状态：</label>
                                            <select name="Diseasename" class="input-medium selectWidth">
                                                <option value="1"></option>
                                            </select>
                                        </li>
                                        <li>
                                            <label>受理部门:</label>
                                            <select name="Diseasename" class="input-medium selectWidth">
                                                <option value="1"></option>
                                            </select>
                                        </li>
                                        <li><label>与联系人关系：</label>
                                            <input name="realmedicalmoney" type="text"
                                                   htmlEscape="false" maxlength="50"
                                                   class="input-medium inputWidth"/>
                                        </li>
                                        <li><label>联系人：</label>
                                            <input name="realmedicalmoney" type="text"
                                                   htmlEscape="false" maxlength="50"
                                                   class="input-medium inputWidth"/>
                                        </li>
                                        <li><label>联系电话：</label>
                                            <input name="realmedicalmoney" type="text"
                                                   htmlEscape="false" maxlength="50"
                                                   class="input-medium inputWidth"/>
                                        </li>
                                        <li><label>联系地址：</label>
                                            <input name="realmedicalmoney" type="text"
                                                   htmlEscape="false" maxlength="50"
                                                   class="input-medium inputWidth"/>
                                        </li>
                                    </ul>
                                </div>
                            </center>
                        </div>
                    </div>
                </div>
            </form>
            <center>
                <div class="breadcrumb" style="margin-top: 3px; margin-right: 10px;">
                    <button type="button" id="ywbanjie" onclick="tijiao()" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-cloud-upload"></i>&nbsp; 提 交
                    </button>
                    <button type="button" id="qdsh" onclick="qxxiugai()" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-legal"></i>&nbsp;清单审核
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
        <iframe style="width: 100%; height: 700px; margin: 0; border: 0; padding: 0;"
                src="${ctx}/gt/gtSmjinfo/listShow?ywlsh=${gtywinfo.ywlsh}"></iframe>
    </div>
    <gt:tagsContent/>
</div>
<script type="text/javascript">
    function fapiao() {
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
            buttons: {'保存': 'save'},
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

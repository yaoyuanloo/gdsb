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
    <title>个人异地长住管理</title>
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
        <div>
            <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                <tr>
                    <th width="80">业务名称</th>
                    <td width="250">${gtywinfo.ywmc}</td>
                    <th width="80">受理回执号</th>
                    <td width="250">${gtywinfo.hzdh}</td>
                    <th width="80">业务流水号</th>
                    <td>${gtywinfo.ywlsh}</td>
                </tr>
                <tr>
                    <th width="80">身份证号</th>
                    <td>${gtywinfo.sfzh}</td>
                    <th width="80">姓名</th>
                    <td width="250">${gtywinfo.xm}</td>
                    <th width="80">所在单位</th>
                    <td>${gtywinfo.dwmc}</td>
                </tr>
                <tr>
                    <th width="80">经办人</th>
                    <td>${gtywinfo.slr.name}</td>
                    <th width="80">经办时间</th>
                    <td width="250"></td>
                    <th width="80">联系电话</th>
                    <td>${jsonData.phone}</td>
                </tr>
                <tr>
                    <th>业务类型</th>
                    <td colspan="5">
                       <input  type="radio" id="ywtype1" name="ywtype" value="1" onclick="ischeck()"  > <span class="multiBoxLabel">长住异地人员管理</span>
                       <input type="radio" id="ywtype2" name="ywtype" value="2" onclick="ischeck()"  >用人单位指派外地工作人员
                       <input type="radio" id="ywtype3" name="ywtype" value="3" onclick="ischeck()"  >个人身份参保
                       <input type="radio" id="ywtype4" name="ywtype" value="4" onclick="ischeck()" >离退休人员
                       <input type="radio" id="ywtype5" name="ywtype" value="5" onclick="ischeck()" >港澳门及外籍人员
                      
                    </td>
                </tr>
                
                 <tr>
                    <th>操作类型</th>
                    <td colspan="5">
                       <input  type="radio" id="cztype1" name="cztype" value="1" onclick="ischeck()"  > 登记
                       <input type="radio" id="cztype2" name="cztype" value="2" onclick="ischeck()"  >注销
                       <input type="radio" id="cztype3" name="cztype" value="3" onclick="ischeck()"  >修改                    
                      
                    </td>
                </tr>
            </table>
            
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
                                <input type="hidden" id="xm" name="xm" class="peosonname" value=""/>
                                <input type="hidden" id="dwbh" name="dwbh" class="dwbh" value=""/>
                                <input type="hidden" id="dwmc" name="dwmc" class="dwmc" value=""/>
                            </form>
                            <form id="infoForm" method="post" class="breadcrumb form-search" style=" margin: 0; border: 0;">
                                <ul class="ul-form" style="">
                                    <li> <label for="medicalOrganizations">医疗机构1:</label>
                                        <input id="medicalorganizations" name="medicalorganizations" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li><label for="medicalOrganizationsClass">医疗机构等级1：</label>
                                        <select id="medicalOrganizationsClass" name="medicalOrganizationsClass"  class="input-medium selectWidth">
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                             <option value="3">3</option>
                                        </select>
                                    </li>
                                   <!--   <li class="clearfix"></li> -->
                                     <li> <label for="medicalOrganizations2">医疗机构2:</label>
                                        <input id="medicalorganizations2" name="medicalorganizations2" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li><label for="medicalOrganizationsClass2">医疗机构等级2：</label>
                                        <select id="medicalOrganizationsClass2" name="medicalOrganizationsClass2"  class="input-medium selectWidth">
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                             <option value="3">3</option>
                                        </select>
                                    </li>
                                   
                                     <li> <label for="medicalOrganizations3">医疗机构3:</label>
                                        <input id="medicalorganizations3" name="medicalorganizations3" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li><label for="medicalOrganizationsClass3">医疗机构等级3：</label>
                                        <select id="medicalOrganizationsClass3" name="medicalOrganizationsClass3"  class="input-medium selectWidth">
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                             <option value="3">3</option>
                                        </select>
                                    </li>
                                    <li><label for="livePlace">居住地：</label>
                                          <input id="livePlace" name="livePlace" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li><label for="li">居住地标记：</label>
                                        <select id="livePlaceMark" name="livePlaceMark" class="input-medium selectWidth">
                                            <option value="1">市内</option>
                                            <option value="2">省内市外</option>
                                            <option value="1">省外</option>
                                            <option value="1">国外</option>
                                        </select>
                                    </li>
                                    <li>
                                        <label for="linkman">联系人:</label>
                                        <input id="linkman" name="linkman" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="linkphone">联系电话：</label>
                                        <input id="linkphone" name="linkphone" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="bankname">银行名称：</label>
                                        <select id="bankname" name="bankname" class="input-medium selectWidth">
                                            <option value="1">招商</option>
                                            
                                        </select>
                                    </li>
                                     <li>
                                        <label for="bankcode">银行代码：</label>
                                        <input id="bankcode" name="bankcode" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="approveMark">发放标志：</label>
                                        <select id="approveMark" name="approveMark" class="input-medium selectWidth">
                                           <option value="1">请选择</option>
                                            
                                        </select>
                                    </li>
                                     <li>
                                        <label for="工残1-4级">工残1-4级：</label>
                                        <select id="disableMan" name="disableMan" class="input-medium selectWidth">
                                           <option value="0">不是</option>
                                           <option value="1">是</option>
                                            
                                        </select>
                                    </li>
                                    <li>
                                        <label for="pepName">户名：</label>
                                        <input id="pepName" name="pepName" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="accoutCode">账号：</label>
                                        <input id="accoutCode" name="accoutCode" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li class="clearfix"></li>
                                    <li>
                                        <label for="supplyMoney">补划金额：</label>
                                        <input id="supplyMoney" name="supplyMoney" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="stopDate">停发日期：</label>
                                        <input name="stopDate" type="text" readonly="readonly"
                                                  maxlength="20" class="input-mini Wdate"
                                                  value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                                                  onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                                                  style="width: 150px;"/>
                                    </li>
                                    <li>
                                        <label for="applyDate">申请日期：</label>
                                        <input name="applyDate" type="text" readonly="readonly"
                                                  maxlength="20" class="input-mini Wdate"
                                                  value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                                                  onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                                                  style="width: 150px;"/>
                                    </li>
                                    <li>
                                        <label for="writeDate">录入日期：</label>
                                        <input name="writeDate" type="text" readonly="readonly"
                                                  maxlength="20" class="input-mini Wdate"
                                                  value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                                                  onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                                                  style="width: 150px;"/>
                                    </li>
                                    <li>
                                        <label for="remarks">备注：</label>
                                        <input id="remarks" name="remarks" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="socialCode">社保卡号：</label>
                                        <input id="socialCode" name="socialCode" type="text" htmlEscape="false" maxlength="50"
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
   /*  function ischeck(){
    	
     	$("#ywtype")
    	 
    	
    } */
    function tijiao() {
        var data = $("#infoForm").serializeJson();

        $("#jsoninfo").val(JSON.stringify(data));
        $("#submitForm").submit();
    }
</script>
</body>
</html>

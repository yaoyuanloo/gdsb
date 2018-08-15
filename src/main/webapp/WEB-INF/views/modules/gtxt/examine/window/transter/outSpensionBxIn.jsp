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
    <title>跨省养老保险关系转入</title>
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
                     展示信息
                    </a>
                </div>
                <div id="collapseOne" class="accordion-body collapse in">
                    <div class="accordion-inner" style="padding: 0;">
                        <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                            <tr>
                                <th width="80">个人身份证号:</th>
                                <td></td>
                                <th width="80">个人姓名:</th>
                                <td></td>
                                <th width="80">性别:</th>
                                <td></td>
                                 <th width="80">其他申报材料:</th>
                                <td></td>
                                <th width="80">类型:</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th width="80">转入险种:</th>
                                <td></td>
                                <th width="80">转入总金额:</th>
                                <td></td>
                                <th width="80">备注:</th>
                                <td colspan="3"></td>
                            </tr>
                           
                           
                        </table>
                        
                        <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                            <tr>
                                <th width="80">流水号:</th>
                                <td> <input id="lsh" name="lsh" type="text" htmlEscape="false" maxlength="100" style="width: 100px;" /></td>
										
										
                                <th width="80">姓名:</th>
                                <td><input id="name" name="name" type="text" htmlEscape="false" maxlength="100" style="width: 100px;" /></td>
                                <th width="80">金额:</th>
                                <td><input id="money" name="money" type="text" htmlEscape="false" maxlength="100" style="width: 100px;" /></td>
                                 <th width="80">转出地名称:</th>
                                <td><input id="outWhere" name="outWhere" type="text" htmlEscape="false" maxlength="100" style="width: 100px;" /></td>
                                <th width="80">备注:</th>
                                <td><input id="onte" name="onte" type="text" htmlEscape="false" maxlength="100" style="width: 100px;" /></td>
                                <td>
                                  <input id="query" name="query" type="button" htmlEscape="false" maxlength="100" style="width: 50px;" value="查询"/>
                                  <input id="qkong" name="qkong" type="button" htmlEscape="false" maxlength="100" style="width: 50px;" value="清空"/>
                                </td>
                            </tr>
                        </table>
                       <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                            <tr>
                                <th width="80">流水号:</th>
                                <th width="80">财务收单时间(2010-06-07起):</th>
                                <th width="80">转入基金日期:</th>
                                <th width="80">姓名:</th>
                                <th width="80">实际转入金额:</th>
                                <th width="80">转出地:</th>
                                <th width="80">业务状态:</th>
                                <th width="80">备注:</th>
                                <th width="80">初审操作人:</th>
                                
                            </tr>
                             <tr>
                                <td width="80" height="15"></th>
                                <td width="80" height="15"></th>
                                <td width="80" height="15"></th>
                                <td width="80" height="15"></th>
                                <td width="80" height="15"></th>
                                <td width="80" height="15"></th>
                                <td width="80" height="15"></th>
                                <td width="80" height="15"></th>
                                <td width="80" height="15"></th>
                                
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
                                         <label for="chongsuan" style="width: 180px;">是否重算实际指数:</label>
                                         <select id="chongsuan" name="chongsuan" class="input-medium selectWidth">
                                                 <option value="1">是</option>
                                                 <option value="0">否</option>
                                          </select>
                                    </li>
                                    <li>
                                        <label for="shiji" style="width: 215px;">有没有1998年7月前的实际缴费时段 :</label>
                                        <select id="shiji" name="shiji" class="input-medium selectWidth">
                                                 <option value="1">是</option>
                                                 <option value="0">否</option>
                                          </select>
                                    </li>
                                    <li> 
                                    <label for="shiji" style="width: 200px;">&nbsp 建账方式:</label>
                                        <select id="jztype" name="jztype" class="input-medium selectWidth">
                                                 <option value="1">省外转出</option>
                                                
                                          </select>
                                    </li>
                                    <li>
                                        <label for="stdatestop" style="width: 180px;">视同截至时间点:</label>
                                        <input name="stdatestop" type="text" readonly="readonly"
                                                   maxlength="20" class="input-mini Wdate"
                                                   value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                                                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                                                     style="width: 150px;"/>
                                    </li> 
                                     <li class="clearfix"></li>
                                    <li>
                                        <label for="zhuany" style="width: 180px;">转移地址:</label>
                                       <select id="zhuany" name="zhuany" class="input-medium selectWidth">
                                                  <option value="1">请选择</option>
                                                 
                                                
                                          </select>
                                    </li>
                                     <li>
                                        <label for="shens" style="width: 18px;">省</label>
                                    
                                    </li>
                                    <li>
                                      
                                       <select id="shi" name="shi" class="input-medium selectWidth">
                                                  <option value="1">请选择</option>
                                                 
                                                
                                          </select>
                                    </li><li> <label for="shis" style="width: 18px;">市</label></li>
                                    <li>
                                       <select id=""xian"" name=""xian"" class="input-medium selectWidth">
                                                  <option value="1">请选择</option>
                                                 
                                                
                                          </select>
                                    </li><li> <label for="xianx" style="width: 18px;">县</label></li>
                                     
                                     <li>
                                        <label for="userType" style="width: 180px;">账户类别:</label>
                                       <select id=""userType"" name=""userType"" class="input-medium selectWidth">
                                                  <option value="0">一般账户</option>
                                                  <option value="1">临时账户</option>
                                                 
                                                
                                          </select>
                                    </li> 
                                    <li class="clearfix"></li>
                                   <!--  <li>
                                      <center>
                                          <label for="sqr1"> <a class="accordion-toggle" data-toggle="collapse" href="#collapseTwo"
                                                             style="text-align: center; font-size: 18px;">
                                                                                 参保人员基本信息
                                                            </a></label>
                                          </center>
                                     </li>
                                     <li class="clearfix"></li> -->
                                    <li>
                                        <label for="singercode" style="width:200px">个人编号:</label>
                                        <input id="singercode" name="singercode" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label  style="width:200px">姓名:</label>
                                       <input id="name" name="name" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li><label for="peptype"  style="width:200px">性别：</label>
                                        <select id="peptype" name="peptype" class="input-medium selectWidth">
                                            <option value="1">男</option>
                                            <option value="2">女</option>
                                        </select>
                                    </li>
                                    <li>
                                        <label for="csDate"  style="width:200px">出生日期：</label>
                                      <input name=""csDate"" type="text" readonly="readonly"
                                                   maxlength="20" class="input-mini Wdate"
                                                   value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                                                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                                                    style="width: 150px;"/>
                                    </li>
                                    <li>
                                        <label for="idcard"  style="width:200px">公民身份证号：</label>
                                         <input id="idcard" name="idcard" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="liveWhere"  style="width:200px">户籍地址：</label>
                                        <input id="liveWhere" name="liveWhere" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                 
                                    <li>
                                        <label for="outcName"  style="width:200px">转出单位名称：</label>
                                        <input id="outcName" name="outcName" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="startWork"  style="width:200px">参加工作时间：</label>
                                        <input name="startWork" type="text" readonly="readonly"
                                               maxlength="20" class="input-mini Wdate"
                                               value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                                               style="width: 150px;"/>
                                    </li>
                                    <li>
                                        <label for="firstjfdate"  style="width:200px">首次参保地实行个人缴费时间：</label>
                                        <input name="firstjfdate" type="text" readonly="readonly"
                                               maxlength="20" class="input-mini Wdate"
                                               value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                                               style="width: 150px;"/>
                                    </li>
                                    <li>
                                       <label for="myfirstjfdate"  style="width:200px">本人首次缴费时间：</label>
                                        <input name="myfirstjfdate" type="text" readonly="readonly"
                                               maxlength="20" class="input-mini Wdate"
                                               value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                                               style="width: 150px;"/>
                                    </li>
                                    <li> 
                                        <label for="myhavecdate" style="width:200px">本人建立个人账户时间：</label>
                                        <input name="myhavecdate" type="text" readonly="readonly"
                                               maxlength="20" class="input-mini Wdate"
                                               value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                                               style="width: 150px;"/>
                                    </li>
                                    <li>
                                        <label for="localjfDate"  style="width:200px">本地缴费起始时间：</label>
                                        <input name="localjfDate" type="text" readonly="readonly"
                                               maxlength="20" class="input-mini Wdate"
                                               value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                                               style="width: 150px;"/>
                                    </li>
                                    <li>
                                        <label for="localjfendDate"  style="width:200px">本地缴费终止时间：</label>
                                        <input name="localjfendDate" type="text" readonly="readonly"
                                               maxlength="20" class="input-mini Wdate"
                                               value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                                               style="width: 150px;"/>
                                    </li>
                                    <li>
                                        <label for="localjfMon"  style="width:200px">本地实际缴费月数：</label>
                                       <input id="localjfMon" name="localjfMon" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="transterDate"  style="width:200px">转移日期：</label>
                                        <input name="transterDate" type="text" readonly="readonly"
                                               maxlength="20" class="input-mini Wdate"
                                               value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                                               style="width: 150px;"/>
                                    </li>
                                   
                                    <li>
                                        <label for="countMoney"  style="width:200px">调转当年记入个人账户本金额：</label>
                                        <input id="countMoney" name="countMoney" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="singerstranter"  style="width:200px">个人账户基金转移额：</label>
                                       <input id="singerstranter" name="singerstranter" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                        <label for="transterMoney"  style="width:200px">统筹基金转移额：</label>
                                       <input id="transterMoney" name="transterMoney" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                     <li>
                                        <label for="transterMoney"  style="width:200px">统筹基金转移总额：</label>
                                       <input id="transterMoney" name="transterMoney" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                     <li>
                                        <label for="transterMoney"  style="width:200px">并入统筹基金额：</label>
                                       <input id="transterMoney" name="transterMoney" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                     <li>
                                        <label for="saveMoney"  style="width:300px">1998年1月1日前账户中个人缴费累计存储额：</label>
                                        <input id="saveMoney" name="saveMoney" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li>
                                    <li>
                                         <label for="saveMoney"  style="width:350px">1998年1月1日至调转上年末个人账户缴费累计存储额：</label>
                                        <input id="saveMoney" name="saveMoney" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/>
                                    </li> 
                                    <li class="clearfix"></li>
                        
                                  
                                     
                                </ul>
                                 <div class="accordion-heading">
                                             <a class="accordion-toggle" data-toggle="collapse" href="#collapseTwo"
                                                style="text-align: center; font-size: 18px;">
                                                                                养老基金转移信息
                                             </a>
                                             
                                    <div style="padding: 0; ">
                                     <table class="table table-striped table-bordered table-condensed">
                                         <tr>
                                           <th width="100px" colspan="4" >至本年末账户累计存储额-小计</th>
                                               
                                           <td colspan="4"> 
                                              <input id="sumMoney" name="sumMoney" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/> 
                                            </td>
                                           <th width="220" colspan="4" >至本年末账户累计存储额-个人缴费</th>
                                               
                                           <td  colspan="2"><input id="singermoney" name="singermoney" type="text" htmlEscape="false" maxlength="50"
                                               class="input-medium inputWidth"/> </td>
                                          </tr>
                                        <tr>
                                           <th  colspan="3" >参保地区</th>
                                           <th  colspan="3" ></th>
                                           <th  colspan="3" >缴费比例</th>
                                           <th  colspan="2" >当年记账金额</th>
                                           <th  colspan="2" >月平均利息</th>
                                           <th > </th>
                                        </tr>
                                        <tr>
                                           <th width="80"  >行政区划代码</th>
                                           <th width="80"  >名称</th>
                                           <th width="80"  >年份</th>
                                           <th width="80"  >缴费起止时间</th>
                                           <th width="80"  >缴费月数</th>
                                           <th width="80" >月缴基数费</th>
                                           <th width="80" >单位</th>
                                           <th width="80"  >划入个人账户比例</th>
                                          
                                           <th width="80"  >个人</th>
                                           <th width="80"  >小计</th>
                                           <th width="80"  >个人缴费</th>
                                           <th width="80" >小计</th>
                                           <th width="80"  >个人缴费</th>
                                           <th width="80"  >备注</th>
                                        </tr>
                                         <tr>
                                           <td width="100"  rowspan="2" heignt="80px"></td>
                                           <td width="100"  rowspan="2"  heignt="80px"></td>
                                           <td width="100"  rowspan="2" heignt="80px"></td>
                                           <td width="100"  rowspan="2"  heignt="80px"></td>
                                           <td width="100"  rowspan="2"  heignt="80px"></td>
                                           <td width="100"  rowspan="2"  heignt="80px"></td>
                                           <!-- <td width="100"   rowspan="2" heignt="80px"></td>
                                           <td width="100"  rowspan="2"  heignt="80px"></td> -->
                                           
                                           <td width="100"    heignt="80px"></td>
                                           <td width="100"    heignt="80px"></td>
                                           <td width="100"    heignt="80px"></td>
                                           
                                           <td width="100"   rowspan="2" heignt="80px"></td>
                                           <td width="100"   rowspan="2"  heignt="80px"></td>
                                           <td width="100"   rowspan="2" heignt="80px"></td>
                                           <td width="100"   rowspan="2" heignt="80px"></td>
                                           
                                           <td width="100"    heignt="80px"></td>
                                        </tr>
                                         <tr>
                                            <td width="100"    heignt="80px">
                                             <select id="danwei" name="danwei" class="input-medium selectWidth">
                                                       <option value="0">请选择</option>
                                                       
                                             </select>
                                            </td>
                                            <td width="100"   heignt="80px">
                                             <select id="monjf" name="monjf" class="input-medium selectWidth">
                                                       <option value="0">请选择</option>
                                             </select>
                                            </td>
                                            <td width="100"    heignt="80px">
                                              <select id="singer" name="singer" class="input-medium selectWidth">
                                                       <option value="0">请选择</option>
                                              </select>
                                            </td>
                                              <td width="100"    heignt="80px">
                                              <select id="noteyl" name=""noteyl"" class="input-medium selectWidth">
                                                       <option value="0">--请选择--</option>
                                              </select>
                                            </td>
                                           
                                        </tr>
                                         <tr>
                                           <td width="100"   colspan="2" heignt="80px">
                                            <input id="add" name="add" type="button" htmlEscape="false" maxlength="100" style="width: 50px;" value="添加"/>
                                           </td>
                                           <td width="100"  colspan="2"  heignt="80px">
                                            <input id="query" name="query" type="button" htmlEscape="false" maxlength="100" style="width: 50px;" value="删除"/>
                                           </td>
                                           <td width="100"  colspan="2"  heignt="80px">
                                           <input id="query" name="query" type="button" htmlEscape="false" maxlength="100" style="width: 50px;" value="修改"/>

                                           </td>
                                           <td width="100"  colspan="2"  heignt="80px">
                                           <input id="query" name="query" type="button" htmlEscape="false" maxlength="100" style="width: 50px;" value="清空"/>
                                           </td>
                                           <td width="100"  colspan="2" heignt="80px">
                                            <input id="query" name="query" type="button" htmlEscape="false" maxlength="100" style="width: 50px;" value="计算平均月息"/>
                                           </td>
                                           <td width="100"  colspan="2"  heignt="80px">
                                            <input id="query" name="query" type="button" htmlEscape="false" maxlength="100" style="width: 50px;" value="同时录入工资"/>
                                           </td>
                                           
                                           <td width="100"    heignt="80px">
                                           <input id="query" name="query" type="button" htmlEscape="false" maxlength="100" style="width: 50px;" value="全部由个人缴费"/>
                                           </td>
                                           
                                        </tr>
                                         <tr>
                                           <th width="100"  >行政区划代码</th>
                                           <th width="100"  >名称</th>
                                           <th width="100"  >年份</th>
                                           <th width="100"  >缴费起止时间</th>
                                           
                                            <th width="100"  >缴费月数</th>
                                            
                                           <th width="100" >月缴基数费</th>
                                           <th width="100" >单位</th>
                                           <th width="100"  >划入个人账户比例</th>
                                          
                                           <th width="100"  >个人</th>
                                           <th width="100"  >小计</th>
                                           <th width="100"  >个人缴费</th>
                                            <th width="100"  >小计</th>
                                              <th width="100"  >个人缴费</th>
                                      
                                           <th width="100"  >备注</th>
                                        </tr>
                                         <tr>
                                           <td width="100"  heignt="80px">小计</td>
                                           <td width="100"    heignt="80px"></td>
                                           <td width="100"    heignt="80px"></td>
                                           <td width="100"    heignt="80px"></td>
                                        <!--    <td width="100"    heignt="80px"></td>  -->
                                           <td width="100"    heignt="80px">
                                           <input id="monfjjs" name="monfjjs" type="text" htmlEscape="false" maxlength="100"
                           style="width: 710px;"/></td>
                                           
                                           <td width="100"    heignt="80px"></td>
                                           <td width="100"    heignt="80px"></td>
                                           <td width="100"    heignt="80px"></td>
                                           <td width="100"    heignt="80px"></td>
                                           
                                          
                                           <td width="100"     heignt="80px">
                                            <input id="xj" name="xj" type="text" htmlEscape="false" maxlength="100"
                           style="width: 50px;"/></td>
                                          
                                           <td width="100"    heignt="80px">
                                            <input id="gj" name="gj" type="text" htmlEscape="false" maxlength="100"
                           style="width: 50px;"/></td>
                                          
                                           <td width="100"    heignt="80px">
                                            <input id="xj2" name="xj2" type="text" htmlEscape="false" maxlength="100"
                           style="width: 50px;"/></td>
                                          
                                          <td width="100"    heignt="50px"><input id="gj2" name="gj2" type="text" htmlEscape="false" maxlength="100"
                           style="width: 50px;"/></td>  
                                           <td width="100"    heignt="80px">
                                           </td>
                                        </tr>
                                         
                                    </table>
                                </div>
                                 <div class="accordion-heading">
                                   <table class="table table-striped table-bordered table-condensed">
                                        <tr>
                                            <th> 
                                                说明                                  </th>
                                        </tr>
                                        <tr>
                                            <td style="width: 100%; padding: 0;" align="center">
                                                <textarea name="" id="" rows="3" style="width: 98%; resize: none;"></textarea>
                                            </td>
                                        </tr>
                                    </table>
                                 
                                 
                                 
                                 
                                 
                                </div>
                                
                                <div class="accordion-heading">
                                   <table class="table table-striped table-bordered table-condensed">
                                        <tr>
                                            <th> 
                                                审核意见
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
                    <button type="button" id="xgqfb" onclick="" class="btn btn-warning"
                            style="width: 110px; padding-left: 3px; padding-right: 3px;"><i
                            class="icon-edit"></i>&nbsp;打印凭证
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

<%--
  Created by IntelliJ IDEA.
  User: cxd
  Date: 2016/9/7
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>养老业务-视同建账变更业务-受理</title>
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

        .input-append .accordion-toggle{
            /*padding-left: 10px;*/
            /*padding-right: 10px;*/
        }

        table {
            table-layout: fixed;
        }
    </style>
     <script type="text/javascript">
        function dyyl(){
        	//alert('ok');
        	//var ywid=$("#ywid").val();
        	location.href = "${ctx}/city/dWrittempinfo/dyyl?ywid="+'9de9c34d49fa43a59482a74a0a7b59dd';
        }
    
    </script>
</head>
<body>
    <div id="">
        <div id="centerDiv" style="width: 100%; margin: 0;overflow-x: hidden; overflow-y: auto;">
            <div class="accordion-group" style="margin: 0;">
                <div class="accordion-heading" style="float: inherit;width: 100%; height: 40px;">
                    <div style="float: left;">
                        <a class="accordion-toggle" style="font-size: 18px; line-height: 22px;">${typename}</a>
                    </div>
                    <div class="input-append" style="margin-top: 5px;">
                        <div style="display: inline-block;">
                            <a class="accordion-toggle"
                               style="font-size:16px;color: black; line-height: 10px;">
                                电脑号:
                            </a>
                        </div>
                        <input id="pcNo" class="inputprm" name="pcno" type="text"
                               maxlength="11" placeholder="请输入电脑号" htmlEscape="false"
                               style="width: 100px;"/>
                        <div style="display: inline-block;">
                            <a class="accordion-toggle"
                               style="font-size:16px;color: black; line-height: 10px;">
                                身份证号:
                            </a>
                        </div>
                        <input id="IDNo" class="inputprm" name="IDNo" type="text"
                               maxlength="11" placeholder="请输入身份证号" htmlEscape="false"
                               style="width: 150px;"/>
                        <div style="display: inline-block;">
                            <a class="accordion-toggle"
                               style="font-size:16px;color: black; line-height: 10px;">
                                社保卡号:
                            </a>
                        </div>
                        <input id="SBIDNo" class="inputprm" name="IDNo" type="text"
                               maxlength="11" placeholder="请输入社保卡号" htmlEscape="false"
                               style="width: 150px;"/>
                        <button id="searchBtn" class="btn pull-right" type="submit" data-toggle="tooltip"
                                data-placement="right">
                            <i class="icon-search"></i>
                        </button>
                    </div>
                </div>
              <!--   <table id="baseTable" class="table table-striped table-bordered table-condensed" style="margin: 0;">
                </table> -->
            </div>
            <div id="searchForm" class="breadcrumb form-search" style=" margin: 0; border: 0;">
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
                        <label for="ywlsh">代办人姓名：</label>
                        <input id="ywlsh" name="ywlsh" type="text" htmlEscape="false" maxlength="50"
                               class="input-medium inputWidth"/>
                    </li>
                    <li class="daibanren" style="display: none;">
                        <label for="dnh">代办人身份证：</label>
                        <input id="dnh" name="dnh" type="text" htmlEscape="false" maxlength="50"
                               class="input-medium inputWidth"/>
                    </li>
                    
                    
                    <li class="clearfix"></li>
                     <li class="idcard" >
                        <label for="idcard">个人身份证：</label>
                        <input id="idcard" name="idcard" type="text" htmlEscape="false" maxlength="50"
                               class="input-medium inputWidth"/>
                    </li>
                     <li class="name">
                        <label for=""name"">个人姓名：</label>
                        <input id=""name"" name=""name"" type="text" htmlEscape="false" maxlength="50"
                               class="input-medium inputWidth"/>
                    </li>
                    <li><label for="nature">性质：</label>
                        <select id="nature" name="nature" class="input-medium selectWidth">
                            <option value="1">个人</option>
                            <option value="2">单位</option>
                        </select>
                    </li>
                    <li><label for="takeemployeedoc">收取职工档案：</label>
                        <select id="takeemployeedoc" name="takeemployeedoc" class="input-medium selectWidth">
                            <option value="1">已收档案</option>
                            <option value="0">未收档案</option>
                        </select>
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
                        <button type="button" id="tijiao" onclick="" class="btn btn-warning"
                                style="width: 110px;"><i
                                class="icon-cloud-upload"></i>&nbsp; 提 交
                        </button>
                         <button type="button"  onclick="dyyl()" class="btn btn-warning"
                                style="width: 110px;"><i
                                class="icon-save"></i>&nbsp; 打印
                        </button>
                    </div>
                </center>
            </div>
            <ul id="myTab" class="nav nav-tabs">
                <li><a href="#YWCXBQ09" data-toggle="tab">查询医疗信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">单位基本信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">个人基本信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">个人缴费基本信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">历史缴费信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">历史住院信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">转诊信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">长住异地信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">门诊病种信息</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
                <!-- 个人基本信息 -->
                <div class="tab-pane" id="YWCXBQ01">
                    <div>
                        <%--<table class="table table-striped table-bordered table-condensed" style="border-width: 1px;" >
                            <tr>
                                <td colspan="6">个人基本信息</td>
                            </tr>
                            <tr>
                                <th>公民身份证</th>
                                <td>547987461654647987987</td>
                                <th>姓名</th>
                                <td>赵月红</td>
                                <th>性别</th>
                                <td>女</td>
                            </tr>
                            <tr>
                                <th>出生日期</th>
                                <td>19080616</td>
                                <th>参加工作年月</th>
                                <td>201212</td>
                                <th>参保工资</th>
                                <td>3250.00</td>
                            </tr>

                            <tr>
                                <th>户口类型</th>
                                <td>珠户非农业户口</td>
                                <th>人员类别</th>
                                <td>在职</td>
                                <th>工种类型</th>
                                <td>普通</td>
                            </tr>

                            <tr>
                                <td>&nbsp; </td>
                                <td>&nbsp;</td>
                                <th>医保状态</th>
                                <td>在职</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                            </tr>

                            <tr>
                                <th>用工形式 </th>
                                <td>城镇合同制职工</td>
                                <th>个人身份</th>
                                <td>其他</td>
                                <th>社保身份</th>
                                <td>正常</td>
                            </tr>

                            <tr>
                                <th>医疗类别 </th>
                                <td>基本医疗</td>
                                <th>电话号码</th>
                                <td>7633000</td>
                                <th>联系人</th>
                                <td>&nbsp;</td>
                            </tr>

                            <tr>
                                <th>联系人电话 </th>
                                <td>&nbsp;</td>
                                <th>邮政编号</th>
                                <td>519040</td>
                                <th>电子邮箱</th>
                                <td>&nbsp;</td>
                            </tr>


                            <tr>
                                <th>民族</th>
                                <td>汉族</td>
                                <th>通讯地址</th>
                                <td colspan="3">珠海市横琴红旗天河街30号西楼281室</td>
                            </tr>


                            <tr>
                                <th>IC卡</th>
                                <td>092007778</td>
                                <th>人员去向</th>
                                <td>非中断或终止</td>
                                <th>纳税人编码</th>
                                <td>465464654</td>
                            </tr>

                            <tr>
                                <th>档案编号</th>
                                <td>J1674749874</td>
                                <th>银行账户</th>
                                <td>4646546546546546545644</td>
                                <th>开户银行</th>
                                <td>&nbsp;</td>
                            </tr>

                            <tr>
                                <th>组织机构代码</th>
                                <td>7965465</td>
                                <th>单位名称</th>
                                <td colspan="3">珠海泰坦电力电子有限公司</td>
                            </tr>

                            <tr>
                                <th>是否邮寄收据</th>
                                <td>否</td>
                                <th>退休待遇类型</th>
                                <td>&nbsp;</td>
                                <th>个账审档标识</th>
                                <td>未审档</td>
                            </tr>
                            <tr>
                                <th>地税增员时间</th>
                                <td>20160522</td>
                                <th>地税减员时间</th>
                                <td>&nbsp;</td>
                                <th>社会保险状态</th>
                                <td>参保缴费</td>
                            </tr>

                            <tr>
                                <th>个人编号</th>
                                <td>1654213</td>
                                <th>账户标记</th>
                                <td>一般账户</td>
                                <th>有效起始时间</th>
                                <td>20160523</td>
                            </tr>
                            <tr>
                                <th>有效终止时间</th>
                                <td colspan="5"></td>
                            </tr>
                        </table>
                        <table id="contentTables" class="table table-striped table-bordered table-condensed"
                               style="border-width: 2px;" >
                            <thead >
                            <tr>
                                <th>险种</th>
                                <th>状态</th>
                                <th>参保信息</th>
                                <th>停保月份</th>
                                <th>征收月份</th>
                                <th>首次参保月份</th>
                            </tr>
                            <tr>
                                <th>养老</th>
                                <td style="color: red;">参保</td>
                                <td>201610</td>
                                <td>0</td>
                                <td>200907</td>
                                <td>199210</td>
                            </tr>
                            <tr>
                                <th>工伤</th>
                                <td style="color: red;">参保</td>
                                <td>201610</td>
                                <td>0</td>
                                <td>200907</td>
                                <td>199210</td>
                            </tr>

                            <tr>
                                <th>失业</th>
                                <td style="color: red;">参保</td>
                                <td>201610</td>
                                <td>0</td>
                                <td>200907</td>
                                <td>199210</td>
                            </tr>

                            <tr>
                                <th>医疗</th>
                                <td style="color: red;">参保</td>
                                <td>201610</td>
                                <td>0</td>
                                <td>200907</td>
                                <td>199210</td>
                            </tr>
                            <tr>
                                <th>生育</th>
                                <td style="color: red;">参保</td>
                                <td>201610</td>
                                <td>0</td>
                                <td>200907</td>
                                <td>199210</td>
                            </tr>
                            </thead>
                        </table>--%>
                    </div>
                </div>
                <div class="tab-pane" id="YWCXBQ09">
                    <!-- 查询医疗信息 -->
                    查询医疗信息
                </div>
                <div class="tab-pane" id="YWCXBQ05">
                    <!-- 生育待遇信息 -->
                    生育待遇信息
                </div>
                <!-- 养老待遇信息 -->
                <div class="tab-pane" id="YWCXBQ07">
                    <!-- 养老待遇信息 -->
                    养老待遇信息
                </div>
                <!-- 个人账户基本信息 -->
                <div class="tab-pane" id="YWCXBQ08">
                    <!-- 个人账户基本信息 -->
                    <div>
                        <%--<table class="table table-bordered">
                            <thead>
                            <tr>
                                <th colspan="6">个人账户基本信息</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th>身份证号码</th>
                                <td colspan="2">7633000</td>
                                <th>人员身份</th>
                                <td colspan="2">在职</td>
                            </tr>
                            <tr>
                                <th>姓名</th>
                                <td>赵月红</td>
                                <th>出生日期</th>
                                <td>19800503</td>
                                <th>社会保险状态</th>
                                <td>参保缴费</td>
                            </tr>
                            <tr>
                                <th>IC卡号</th>
                                <td>7633000</td>
                                <th>退休待遇类型</th>
                                <td colspan="3"></td>
                            </tr>
                            <tr>
                                <th>性别</th>
                                <td>女</td>
                                <th>参加工作年月</th>
                                <td >201012</td>
                                <th>用工形式</th>
                                <td >城镇合同制职工</td>
                            </tr>
                            <tr>
                                <th>民族</th>
                                <td>汉</td>
                                <th>视同缴费月数</th>
                                <td >0</td>
                                <th>个人身份</th>
                                <td >其他</td>
                            </tr>
                            <tr>
                                <th>特殊工种标识</th>
                                <td>普通</td>
                                <th>特殊工种加发月数</th>
                                <td >0</td>
                                <th>社保身份</th>
                                <td >其他</td>
                            </tr>
                            <tr>
                                <th>技术职称</th>
                                <td></td>
                                <th>特殊工种缴费总月数</th>
                                <td >0</td>
                                <th>视同账户建账状态</th>
                                <td ></td>
                            </tr>
                            <tr>
                                <th>电话号码</th>
                                <td>7633000</td>
                                <th>联系人</th>
                                <td>张三</td>
                                <th>联系电话</th>
                                <td>7633000</td>
                            </tr>
                            <tr>
                                <th>邮政编码</th>
                                <td>519040</td>
                                <th>电子邮件地址</th>
                                <td></td>
                                <th>户口性质</th>
                                <td>珠户非农业户口</td>
                            </tr>
                            <tr>
                                <th>资料申档标识</th>
                                <td>未申档</td>
                                <th>通讯地址</th>
                                <td colspan="3">珠海市横琴红旗村天和街30号西楼281</td>
                            </tr>
                            <tr>
                                <th>组织机构代码</th>
                                <td>519040</td>
                                <th>单位名称</th>
                                <td colspan="3">珠海泰坦电路电子集团有限公司</td>

                            </tr>
                            <tr>
                                <th>实际缴费月数</th>
                                <td>104</td>
                                <th>1998年7月前实际缴费月数</th>
                                <td></td>
                                <th>人员去向</th>
                                <td>非中断或终止</td>
                            </tr>
                            <tr>
                                <th>实际缴费起止年月</th>
                                <td>200403-201607</td>
                                <th>建账方式</th>
                                <td></td>
                                <th>调入年月</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th>最近转入地</th>
                                <td></td>
                                <th>建账总额</th>
                                <td>0.0</td>
                                <th>特殊工种时段</th>
                                <td></td>
                            </tr>
                            </tbody>
                        </table>--%>
                    </div>
                </div>
                <!-- 工伤待遇查询 -->
                <div class="tab-pane" id="YWCXBQ06">
                    <!-- 工伤待遇查询 -->
                </div>
                <!-- 历史缴费信息 -->
                <div class="tab-pane" id="YWCXBQ04">
                    <!-- 历史缴费信息 -->
                    <div>
                        <table class="table table-striped table-bordered table-condensed"
                               style="border-width: 2px;">
                            <thead>
                            <tr>
                                <th>险种</th>
                                <th>开始年月</th>
                                <th>结束年月</th>
                                <th>缴费月数</th>
                                <th>工资</th>
                                <th>单位缴</th>
                                <th>个人缴</th>
                                <th>单位划入</th>
                                <th>缴费类型</th>
                                <th>法人代码</th>
                                <th>单位名称</th>
                                <th>业务事件</th>
                            </tr>
                        </table>
                    </div>
                </div>

                <div class="tab-pane" id="YWCXBQ03">
                    <div>
                        <table class="table table-striped table-bordered table-condensed"
                               style="border-width: 2px;">
                            <tr>
                                <td colspan="15">
                                    记录数 页次1/21
                                </td>
                            </tr>

                            <tr>
                                <td colspan="15">
                                    险种<select>
                                    <option>全部</option>
                                </select>


                                    缴费类型<select>
                                    <option>全部</option>
                                </select>


                                    到账标志<select>
                                    <option>全部</option>
                                </select>

                                    缴费年月
                                    <input>
                                    至
                                    <input>


                                    单位名称
                                    <input>

                                    <button class="btn" style="width: 100px;"><i class="icon-credit-card"></i>&nbsp;提交
                                    </button>
                                </td>
                            </tr>

                            <tr>
                                <th>序号</th>
                                <th>险种</th>
                                <th>缴费月份</th>
                                <th>台账月份</th>
                                <th>缴费工资</th>
                                <th>个人缴费</th>
                                <th>单位入户拨额</th>
                                <th>单位入户专额</th>
                                <th>缴费类型</th>
                                <th>到账标志</th>
                                <th>单位名称</th>
                                <th>总金额</th>
                                <th>到账日期</th>
                                <th>操作时间</th>
                                <th>业务事件</th>

                            </tr>
                            <tr>
                                <td>1</td>
                                <td>基本养老保险</td>
                                <td>201607</td>
                                <td>201607</td>
                                <td>3000.0</td>
                                <td>240.0</td>
                                <td>391.0</td>
                                <td>0.0</td>
                                <td>正常缴</td>
                                <td>已实现</td>
                                <td>珠海泰坦店里电子集团有限公司</td>
                                <td>630.0</td>
                                <td>20160721</td>
                                <td>20160721164542</td>
                                <td></td>
                            </tr>

                            <tr>
                                <td>1</td>
                                <td>基本养老保险</td>
                                <td>201607</td>
                                <td>201607</td>
                                <td>3000.0</td>
                                <td>240.0</td>
                                <td>391.0</td>
                                <td>0.0</td>
                                <td>正常缴</td>
                                <td>已实现</td>
                                <td>珠海泰坦店里电子集团有限公司</td>
                                <td>630.0</td>
                                <td>20160721</td>
                                <td>20160721164542</td>
                                <td></td>
                            </tr>

                            <tr>
                                <td>1</td>
                                <td>基本养老保险</td>
                                <td>201607</td>
                                <td>201607</td>
                                <td>3000.0</td>
                                <td>240.0</td>
                                <td>391.0</td>
                                <td>0.0</td>
                                <td>正常缴</td>
                                <td>已实现</td>
                                <td>珠海泰坦店里电子集团有限公司</td>
                                <td>630.0</td>
                                <td>20160721</td>
                                <td>20160721164542</td>
                                <td></td>
                            </tr>

                            <tr>
                                <td>1</td>
                                <td>基本养老保险</td>
                                <td>201607</td>
                                <td>201607</td>
                                <td>3000.0</td>
                                <td>240.0</td>
                                <td>391.0</td>
                                <td>0.0</td>
                                <td>正常缴</td>
                                <td>已实现</td>
                                <td>珠海泰坦店里电子集团有限公司</td>
                                <td>630.0</td>
                                <td>20160721</td>
                                <td>20160721164542</td>
                                <td></td>
                            </tr>

                            <tr>
                                <td>1</td>
                                <td>基本养老保险</td>
                                <td>201607</td>
                                <td>201607</td>
                                <td>3000.0</td>
                                <td>240.0</td>
                                <td>391.0</td>
                                <td>0.0</td>
                                <td>正常缴</td>
                                <td>已实现</td>
                                <td>珠海泰坦店里电子集团有限公司</td>
                                <td>630.0</td>
                                <td>20160721</td>
                                <td>20160721164542</td>
                                <td></td>
                            </tr>

                            <tr>
                                <td>1</td>
                                <td>基本养老保险</td>
                                <td>201607</td>
                                <td>201607</td>
                                <td>3000.0</td>
                                <td>240.0</td>
                                <td>391.0</td>
                                <td>0.0</td>
                                <td>正常缴</td>
                                <td>已实现</td>
                                <td>珠海泰坦店里电子集团有限公司</td>
                                <td>630.0</td>
                                <td>20160721</td>
                                <td>20160721164542</td>
                                <td></td>
                            </tr>

                            <tr>
                                <td>1</td>
                                <td>基本养老保险</td>
                                <td>201607</td>
                                <td>201607</td>
                                <td>3000.0</td>
                                <td>240.0</td>
                                <td>391.0</td>
                                <td>0.0</td>
                                <td>正常缴</td>
                                <td>已实现</td>
                                <td>珠海泰坦店里电子集团有限公司</td>
                                <td>630.0</td>
                                <td>20160721</td>
                                <td>20160721164542</td>
                                <td></td>
                            </tr>


                            <tr>
                                <td>1</td>
                                <td>基本养老保险</td>
                                <td>201607</td>
                                <td>201607</td>
                                <td>3000.0</td>
                                <td>240.0</td>
                                <td>391.0</td>
                                <td>0.0</td>
                                <td>正常缴</td>
                                <td>已实现</td>
                                <td>珠海泰坦店里电子集团有限公司</td>
                                <td>630.0</td>
                                <td>20160721</td>
                                <td>20160721164542</td>
                                <td></td>
                            </tr>
                        </table>
                    </div>
                </div>

                <div class="tab-pane" id="YWCXBQ02">
                    <!-- 单位 -->
                    <div>
                        <table class="table table-striped table-bordered table-condensed"
                               style="border-width: 2px;">
                            <thead>
                            <tr>
                                <td colspan="7">单位基本信息</td>
                            </tr>
                            <tr>
                                <th>组织机构代码</th>
                                <td>91440400778183973</td>
                                <th>单位电话</th>
                                <td>未提供电话</td>
                                <th>传真号码</th>
                                <td>3325889</td>
                            </tr>
                            <tr>
                                <th>单位名次</th>
                                <td colspan="3">珠海泰坦新能源系统有限公司</td>
                                <th>单位状态</th>
                                <td>参保缴费</td>
                            </tr>

                            <tr>
                                <th>单位地址</th>
                                <td colspan="3">珠海市吉大石花西路60号三楼</td>
                                <th>单位状态</th>
                                <td>参保缴费</td>
                            </tr>

                            <tr>
                                <th>邮政编号</th>
                                <td>&nbsp;</td>
                                <th>电子邮件地址</th>
                                <td>&nbsp;</td>
                                <th>经济类型</th>
                                <td>私营有限责任公司</td>
                            </tr>

                            <tr>
                                <th>辖区</th>
                                <td>香洲</td>
                                <th>银行名称</th>
                                <td>工商行分行营业部</td>
                                <th>单位类型</th>
                                <td>企业</td>
                            </tr>

                            <tr>
                                <th>缴费开户银行代码</th>
                                <td>0030207</td>
                                <th>银行帐号</th>
                                <td>2002020719100278549</td>
                                <th>缴费开户户名</th>
                                <td>珠海科利尔能源科技有限公司</td>
                            </tr>

                            <tr>
                                <th>隶属关系</th>
                                <td>县</td>
                                <th>行政区域</th>
                                <td>440402000</td>
                                <th>主管部门或总机构</th>
                                <td>市直属市直区</td>
                            </tr>


                            <tr>
                                <th>成立日期</th>
                                <td>20090404</td>
                                <th>联系人姓名</th>
                                <td>李小滨</td>
                                <th>联系电话</th>
                                <td>&nbsp; </td>
                            </tr>


                            <tr>
                                <th>通讯地址</th>
                                <td colspan="3">珠海市吉大石花西路60号三楼</td>
                                <th>单位密码</th>
                                <td>*******</td>
                            </tr>

                            <tr>
                                <th>工商登记执照种类</th>
                                <td>法人营业执照</td>
                                <th>工商登记执照号码</th>
                                <td>440400000019059</td>
                                <th>工商登记发证日期</th>
                                <td>20050708</td>
                            </tr>

                            <tr>
                                <th>工商登记有效期限</th>
                                <td>20150708</td>
                                <th>批准文号</th>
                                <td>&nbsp;</td>
                                <th>纳税人编码</th>
                                <td>4404020000157</td>
                            </tr>
                            <tr>
                                <th>法人代表人身份证号码</th>
                                <td>44040119570504041X</td>
                                <th>法人代表人姓名</th>
                                <td>李欣青</td>
                                <th>税务机构名称</th>
                                <td>&nbsp;</td>
                            </tr>

                            <tr>
                                <th>批准成立单位</th>
                                <td>&nbsp;</td>
                                <th>行业代码</th>
                                <td>4190</td>
                                <th>行业名称</th>
                                <td>其他电子设备制造业</td>
                            </tr>
                            <tr>
                                <th>工伤级别</th>
                                <td>二级</td>
                                <th>工伤浮动比例</th>
                                <td>1</td>
                                <th>工商费率</th>
                                <td>0.8</td>
                            </tr>


                            <tr>
                                <th>档案编号</th>
                                <td>G111012008120024</td>
                                <th>银行统发标识</th>
                                <td>非统发银行</td>
                                <th>单位征收类型</th>
                                <td>&nbsp;</td>
                            </tr>
                            <tr>
                                <th colspan="4">备注</th>
                                <th>单位社保号</th>
                                <td>0402200008643</td>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </div>

            </div>
        </div>
    </div>
<script>
    $(document).ready(function () {
        var tpl = $("#baseTableTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
        updateBaseTable({msg: '0'}, tpl);
        $("#searchForm").submit(function () {
            if ($("#searchInput").val() == "") {
                showTip("请输入单位社保编号", 'info', 2000, 0);
            } else {
                $.post("${ctx}/slzt/zsyw/dwsb/json", {dwbh: $("#searchInput").val()}, function (data) {
                    updateBaseTable(data, tpl);
                    $("#shenheBtn").attr("dwbh", ($("#searchInput").val()));
                });
            }
            return false;
        });
        $("[data-toggle='tooltip']").tooltip({
            delay: {show: 1000, hide: 200}
        });
        $("[data-toggle='popover']").popover();

        $("#sqr").change(function () {
            if ($(this).val() == 0)
                $(".daibanren").fadeIn('fast');
            else
                $(".daibanren").fadeOut('fast');
        });
    });

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
        setValues();
        checkAll();
    }

    function checkLabel(e) {
        var box = ($(e).children("i"))[0];
        if (!($(box).hasClass("active"))) {
            $(".multiBoxIcon").removeClass("icon-circle").removeClass("active").addClass("icon-circle-blank");
            $(box).addClass("icon-circle").addClass("active");

            $("#shenheBtn").attr("ywbh", ($(e).attr("value")));
        }
    }

    function checkMultiLabel(e) {
        var box = ($(e).find(".multiBoxIcon"))[0];
        if ($(box).hasClass("icon-check-empty")) {
            $(box).addClass("icon-check").removeClass("icon-check-empty");
        } else {
            $(box).addClass("icon-check-empty").removeClass("icon-check");
        }
        $.post("${ctx}/slzt/zsyw/dwsb/zhuyi", {ywbh: $(e).attr("value")}, function (data) {
            $("#zysxTable").html("");
            $("#blsj").val("");

            $("#blsj").val((data.ywxx.by1).toString().trim());
            ywsc = data.ywsc;
            ywscCount = ywsc.length;

            $("#ywscPageBar").html("");
            /*if (ywsc.length > pageSize) {*/
            var prev = $("<li class='disabled'><a href='javascript:void(0);' onclick='prev($(this));' class='icon-double-angle-left'></a></li>");
            $("#ywscPageBar").append(prev);
            for (var i = 0; i < (ywscCount / pageSize); i++) {
                $("#ywscPageBar").append($("<li><a href='javascript:void(0);' onclick='ywscPage(this);' data-page-no='" + (i + 1) + "'>" + (i + 1) + "</a></li>"));
            }
            var next = $("<li><a href='javascript:void(0);' onclick='next($(this));' class='icon-double-angle-right'></a></li>");
            $("#ywscPageBar").append(next);
            var f = (($("#ywscPageBar").find("li a")[1]));
            ywscPage(f);
            $("#ywscPageBar").attr("data-page-count", ywscCount);
            /*} else {
             var page = $("#ywscPageBar").attr("data-page-no");
             var li = ($("#ywscPageBar").find("li")[1]);
             var a = $(li).find("a");
             console.log(a);
             ywscPage(a);
             }*/
        });
        checkAll();
    }

    function checkAll() {
        var e = $("#paperTable .multiBox").find(".icon-check");
        var all = $("#paperTable tr");
        if (e.length == all.length) {
            $("#allcheckBox .multiBoxIcon:first").addClass("icon-check").removeClass("icon-check-empty");
        } else {
            $("#allcheckBox .multiBoxIcon:first").addClass("icon-check-empty").removeClass("icon-check");
        }
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
</script>
<script type="text/javascript">
    var showDetailObj = null;
    var detailTrTheme = "info";
    var tableTrTheme = "";
    //    $(function () {
    //        $("#centerDiv").css({"overflow-y" : "scroll"});
    //    });
    var leftWidth = 200; // 左侧窗口大小
    var htmlObj = $("html"), mainObj = $("#main");
    var frameObj = $("#left, #openClose, #right, #right iframe");
    function wSize() {
        var strs = getWindowSize().toString().split(",");
        htmlObj.css({"overflow-x": "hidden", "overflow-y": "auto"});
//        $("body").css("overflow", "hidden");
        mainObj.css("width", "auto");
        frameObj.height(strs[0] - 5);
        var leftWidth = ($("#left").width() < 0 ? 0 : $("#left").width());
        $("#right").width($("#content").width() - leftWidth - $("#openClose").width() - 5);
    }
    function tableTurnCss() {
        $("#treeTableList").find("tr:odd").removeClass(tableTrTheme).removeClass(detailTrTheme);
        $("#treeTableList").find("tr:even").addClass(tableTrTheme);
    }
</script>
<script src="${ctxStatic}/common/wsize.min.js" type="text/javascript"></script>
<script type="text/template" id="baseTableTpl">
    <tr>
        <th width="80">姓名</th>
        <td>
            <input readonly="readonly" id="name" value="{{data.name}}"/>
        </td>
        <th width="80">身份证号</th>
        <td>
            <input readonly="readonly" id="idcard" value="{{dict.idcard}}"/>
        </td>
        <th width="80">户籍</th>
        <td>
            <input readonly="readonly" id="home" value="{{dict.home}}"/>
        </td>
    </tr>
    <tr>
        <th>业务类型</th>
        <td colspan="5">
            <ul class="nav nav-pills" style="margin-bottom: 0;">
                <c:choose>
                    <c:when test="${checkMultiLabel}">
                        <c:forEach items="${types}" var="t">
                            <li>
                                <a href="javascript:void(0);" class="multiBox" value="${t.id}"
                                   onclick="checkMultiLabel(this)">
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
                                   onclick="checkLabel(this)">
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
</script>
</body>
</html>

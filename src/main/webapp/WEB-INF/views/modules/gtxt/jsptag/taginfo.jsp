<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>页面标签信息</title>
    <meta name="decorator" content="default"/>
    <style type="text/css">
        .accordion-group {
            background-color: blue;
        }

        .accordion-heading {
            background-color: blue;
        }
    </style>

    <script type="text/javascript">

    </script>
</head>
<body>
<ul id="myTab" class="nav nav-tabs">
    <li class="active"><a href="#birthbeforeOrginfo" data-toggle="tab">产前签约机构信息</a></li>
    <li><a href="#Pasurepersonalinfo" data-toggle="tab">养老个人账户信息</a></li>
    <li><a href="#CompanyInfo" data-toggle="tab">单位基本信息</a></li>
    <li><a href="#HistoryHospitoalinfo" data-toggle="tab">历史住院信息</a></li>
    <li><a href="#HistoryPayinfo" data-toggle="tab">历史缴费信息</a></li>
    <li><a href="#Historyoutpatient" data-toggle="tab">历史门诊信息</a></li>
    <li><a href="#GSregisterinfQurey" data-toggle="tab">工伤登记信息查询</a></li>
    <li><a href="#GSRecoverinfQurey" data-toggle="tab">工伤康复登记信息查询</a></li>
    <li><a href="#elsewherepensions" data-toggle="tab">异地转入地方养老金</a></li>
    <li><a href="#GSreferralsinfQurey" data-toggle="tab">工伤转诊登记信息查询</a></li>
    <li><a href="#elsewhereSameasInfo" data-toggle="tab">异地转入视同信息</a></li>
    <li><a href="#sameAccountnewA" data-toggle="tab">视同账户建账信息</a></li>
    <li><a href="#elsewherePay" data-toggle="tab">异地转入工资信息</a></li>
    <li><a href="#referralsInfo" data-toggle="tab">转诊信息</a></li>
    <li><a href="#liveelsewhereDetail" data-toggle="tab">长住异地详细信息</a></li>
    <li><a href="#PersonpasureInfo" data-toggle="tab">个人养老基本信息</a></li>
    <li><a href="#PersonInfo" data-toggle="tab">个人基本信息</a></li>
    <li><a href="#PersonPayInfo" data-toggle="tab">个人缴费信息</a></li>
    <li><a href="#FiveinsurancePayRecords" data-toggle="tab">五险待遇发放记录</a></li>
    <li><a href="#GSRegisterDetails" data-toggle="tab">工伤登记详细信息</a></li>


</ul>
<div id="myTabContent" class="tab-content">
    <div class="tab-pane active" id="birthbeforeOrginfo">
        <!-- 产前签约机构信息 -->
        <div style="margin: 0 auto;width:70%;">
            <table class="table table-striped table-bordered table-condensed">

                <tr>
                    <th colspan="4" style="text-align: left;">产前签约机构信息</th>
                </tr>
                <tr>
                    <td>机构名称</td>
                    <td></td>
                    <td>签约时间</td>
                    <td></td>
                </tr>
                <tr>
                    <td>额度</td>
                    <td></td>
                    <td>剩余额度</td>
                    <td></td>
                </tr>
                <tr>
                    <td>使用额度</td>
                    <td></td>
                    <td>审核状态</td>
                    <td></td>
                </tr>
            </table>
        </div>
    </div>
    <div class="tab-pane" id="CompanyInfo">
        <div style="margin: 0 auto;width:70%;">
            <table class="table table-striped table-bordered table-condensed">

                <tr>
                    <th colspan="6" style="text-align: left;">单位基本信息</th>
                </tr>
                <tr>
                    <td width="15%">组织机构代码</td>
                    <td width="20%"></td>
                    <td width="15%">单位电话</td>
                    <td width="15%"></td>
                    <td width="15%">传真号码</td>
                    <td width="20%"></td>
                </tr>
                <tr>
                    <td>单位名称</td>
                    <td colspan="3"></td>
                    <td>单位状态</td>
                    <td></td>

                </tr>
                <tr>
                    <td>单位地址</td>
                    <td colspan="5"></td>


                </tr>
                <tr>
                    <td>邮政编码</td>
                    <td></td>
                    <td>电子邮件地址</td>
                    <td></td>
                    <td>经济类型</td>
                    <td></td>

                </tr>
                <tr>
                    <td>辖区</td>
                    <td></td>
                    <td>银行名称</td>
                    <td></td>
                    <td>单位类型</td>
                    <td></td>

                </tr>
                <tr>
                    <td>缴费开户银行代码</td>
                    <td></td>
                    <td>银行账号</td>
                    <td></td>
                    <td>缴费开户户名</td>
                    <td></td>

                </tr>
                <tr>
                    <td>隶属关系</td>
                    <td></td>
                    <td>行政区域</td>
                    <td></td>
                    <td>主管部门或总机构</td>
                    <td></td>

                </tr>
                <tr>
                    <td>成立日期</td>
                    <td></td>
                    <td>联系人姓名</td>
                    <td></td>
                    <td>联系人电话</td>
                    <td></td>

                </tr>
                <tr>
                    <td>通讯地址</td>
                    <td colspan="3"></td>
                    <td>单位密码</td>
                    <td>******</td>
                </tr>
                <tr>
                    <td>工商登记执照种类</td>
                    <td></td>
                    <td>工商登记执照号码</td>
                    <td></td>
                    <td>工商登记发证日期</td>
                    <td></td>
                </tr>
                <tr>
                    <td>工商登记有效期限</td>
                    <td></td>
                    <td>批准文号</td>
                    <td></td>
                    <td>纳税人编码</td>
                    <td></td>
                </tr>
                <tr>
                    <td>法人代表身份证号码</td>
                    <td></td>
                    <td>法人代表人姓名</td>
                    <td></td>
                    <td>税务机构名称</td>
                    <td></td>
                </tr>

                <tr>
                    <td>批准成立单位</td>
                    <td></td>
                    <td>行业代码</td>
                    <td></td>
                    <td>行业名称</td>
                    <td></td>
                </tr>
                <tr>
                    <td>工伤级别</td>
                    <td></td>
                    <td>工伤浮动比例</td>
                    <td></td>
                    <td>工伤费率</td>
                    <td></td>
                </tr>
                <tr>
                    <td>档案编号</td>
                    <td></td>
                    <td>银行统发标识</td>
                    <td></td>
                    <td>单位征收类型</td>
                    <td></td>
                </tr>
                <tr>
                    <td>备注</td>
                    <td colspan="3"></td>
                    <td>单位社保号</td>
                    <td></td>

                </tr>

            </table>
        </div>
    </div>
    <div class="tab-pane fade" id="Pasurepersonalinfo">
        <%--养老个人账户信息--%>
        <div style="margin: 0 auto;width:70%;">
            <table class="table table-striped table-bordered table-condensed">

                <tr>
                    <th colspan="10" style="text-align: left;">财务个账信息</th>
                </tr>
                <tr>
                    <td width="10%">姓名</td>
                    <td width="10%"></td>
                    <td width="10%">公民身份号码</td>
                    <td width="10%"></td>
                    <td width="10%">单位号码</td>
                    <td width="50%" colspan="5"></td>
                </tr>
                <tr>
                    <td>总月数</td>
                    <td></td>
                    <td>单位缴本</td>
                    <td></td>
                    <td>单位入专本</td>
                    <td></td>
                    <td>个人缴本</td>
                    <td></td>
                    <td>个账</td>
                    <td></td>
                </tr>
                <tr>
                    <td>总指数</td>
                    <td></td>
                    <td>单位缴利</td>
                    <td></td>
                    <td>单位入专本</td>
                    <td></td>
                    <td>个人缴利</td>
                    <td></td>
                    <td>合计</td>
                    <td></td>
                </tr>
            </table>
        </div>
    </div>
    <div class="tab-pane fade" id="HistoryPayinfo">
        <%--历史缴费信息--%>
        <div style="margin: 0 auto;width:70%;">
            <table class="table table-striped table-bordered table-condensed">
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
    <div class="tab-pane fade" id="HistoryHospitoalinfo">
        <%--//历史住院信息--%>
        <div style="margin: 0 auto;width:70%;">
            <table class="table table-striped table-bordered table-condensed">
                <tr>
                    <th>序号</th>
                    <th>姓名</th>
                    <th>入院日期</th>
                    <th>出院日期</th>
                    <th>医院名称</th>
                    <th>医院等级</th>
                    <th>起付标准</th>
                    <th>单位划入</th>
                    <th>报销年度</th>
                    <th>本年度累计核准医疗费</th>
                    <th>核准医疗费</th>

                </tr>
            </table>
        </div>
    </div>
    <div class="tab-pane fade" id="Historyoutpatient">
        <%--历史门诊信息--%>
        <div style="margin: 0 auto;width:70%;">
            <table class="table table-striped table-bordered table-condensed">
                <tr>
                    <th>序号</th>
                    <th>姓名</th>
                    <th>身份证号</th>
                    <th>报销单号</th>
                    <th>报销年度</th>
                    <th>核准医疗费</th>
                    <th>累计核准医疗费</th>
                    <th>基金支付合计</th>
                    <th>数据来源名称</th>
                    <th>结算标志</th>

                </tr>
            </table>
        </div>
    </div>
    <div class="tab-pane fade" id="GSregisterinfQurey">
        <%--	//工伤登记信息查询--%>
        <div style="margin: 0 auto;width:70%;">
            <table class="table table-striped table-bordered table-condensed">
                <tr>
                    <th>序号</th>
                    <th>身份证号</th>
                    <th>姓名</th>
                    <th>单位名称</th>
                    <th>事故日期</th>
                    <th>伤亡</th>
                    <th>是否工伤</th>
                    <th>结案标志</th>
                    <th>伤残级别</th>
                    <th>治疗医院</th>
                    <th>住院门诊</th>
                    <th>工伤状态</th>

                </tr>
            </table>
        </div>
    </div>
    <div class="tab-pane fade" id="GSRecoverinfQurey">
        <%--	//工伤康复登记信息查询--%>
        <div style="margin: 0 auto;width:70%;">
            <table class="table table-striped table-bordered table-condensed">
                <tr>
                    <th>序号</th>
                    <th>姓名</th>
                    <th>身份证号</th>
                    <th>康复医院</th>
                    <th>事故时间</th>
                    <th>开始日期</th>
                    <th>结束日期</th>
                    <th>康复申请日期</th>
                    <th>康复类别</th>
                    <th>数据来源</th>
                    <th>操作类别</th>

                </tr>
            </table>
        </div>
    </div>
    <div class="tab-pane fade" id="GSreferralsinfQurey">
        <%--	//工伤转诊登记信息查询--%>
        <div style="margin: 0 auto;width:70%;">
            <table class="table table-striped table-bordered table-condensed">
                <tr>
                    <th>序号</th>
                    <th>姓名</th>
                    <th>身份证</th>
                    <th>转诊医院</th>
                    <th>审核标志</th>
                    <th>审核人</th>
                    <th>转诊日期</th>
                    <th>转诊有效日期</th>
                    <th>联系人</th>
                    <th>联系电话</th>
                    <th>操作</th>

                </tr>
            </table>
        </div>
    </div>
    <div class="tab-pane fade" id="elsewherepensions">
        <%--//异地转入地方养老金--%>
        <div style="margin: 0 auto;width:70%;">
            <table class="table table-striped table-bordered table-condensed">
                <tr>
                    <th>核定单号</th>
                    <th>类型</th>
                    <th>状态</th>
                    <th>转出地</th>
                    <th>险种</th>
                    <th>开始年月</th>
                    <th>结束年月</th>
                    <th>缴费月数</th>
                    <th>单位缴</th>
                    <th>个人缴</th>
                    <th>转入利息</th>
                    <th>缴费类型</th>
                    <th>业务事件</th>
                </tr>
            </table>
        </div>
    </div>
    <div class="tab-pane fade" id="elsewherePay">
        <%--//异地转入工资信息--%>
        <div style="margin: 0 auto;width:70%;">
            <table class="table table-striped table-bordered table-condensed">
                <tr>
                    <th>险种</th>
                    <th>年月</th>
                    <th>缴费工资</th>
                    <th>转移日期</th>
                    <th>录入人</th>
                    <th>录入时间</th>

                </tr>
            </table>
        </div>
    </div>
    <div class="tab-pane fade" id="elsewhereSameasInfo">/
        <%--/异地转入视同信息--%>
        <div style="margin: 0 auto;width:70%;">
            <table class="table table-striped table-bordered table-condensed">
                <tr>
                    <th>核定单号</th>
                    <th>状态</th>
                    <th>转出地</th>
                    <th>到账时间</th>
                    <th>转入金额</th>
                    <th>视同账户金额</th>
                    <th>地方养老金</th>
                    <th>入统筹基金额</th>
                    <th>业务事件</th>

                </tr>
            </table>
        </div>
    </div>
    <div class="tab-pane fade" id="sameAccountnewA">
        <%--	//视同账户建账信息--%>
        <div style="margin: 0 auto;width:70%;">
            <table class="table table-striped table-bordered table-condensed">
                <tr>
                    <td width="25%">人群;一般人群，特殊人群</td>
                    <td width="25%"></td>
                    <td width="25%">落实日期</td>
                    <td width="25%"></td>
                </tr>
                <tr>
                    <td>视同缴费人员类别</td>
                    <td colsapn="2"></td>
                </tr>
                <tr>
                    <td>视同起始年月</td>
                    <td></td>
                    <td>视同终止年月</td>
                    <td></td>
                </tr>
                <tr>
                    <td>视同截止点</td>
                    <td></td>
                    <td>调出地</td>
                    <td></td>
                </tr>
                <tr>
                    <td>备注</td>
                    <td colspan="3"></td>

                </tr>
            </table>
        </div>
    </div>
    <div class="tab-pane fade" id="referralsInfo">
        <%--	转诊信息
            //转诊信息--%>
        <div style="margin: 0 auto;width:70%;">
            <table class="table table-striped table-bordered table-condensed">
                <tr>
                    <th>序号</th>
                    <th>转诊登记流水号</th>
                    <th>个人ID</th>
                    <th>身份证号</th>
                    <th>姓名</th>
                    <th>转诊日期</th>
                    <th>转诊截止日期</th>
                    <th>转出医疗机构</th>
                    <th>转入医疗机构</th>
                    <th>延期标准</th>
                    <th>登记类型</th>
                    <th>转诊类型</th>
                    <th>结算标志</th>


                </tr>
            </table>
        </div>
    </div>
    <div class="tab-pane fade" id="liveelsewhereDetail">
        <%--长住异地详细信息--%>

        <div style="margin: 0 auto;width:70%;">
            <table class="table table-striped table-bordered table-condensed">
                <tr>
                    <th>序号</th>
                    <th>姓名</th>
                    <th>工伤1-4级人员</th>
                    <th>居住地类型</th>
                    <th>联系人</th>
                    <th>联系电话</th>
                    <th>医疗机构1</th>
                    <th>医疗等级1</th>
                    <th>医疗机构2</th>
                    <th>医疗等级2</th>
                    <th>医疗机构3</th>
                    <th>医疗等级3</th>
                    <th>停发日期</th>
                    <th>补划金额</th>
                    <th>操作人</th>
                    <th>操作日期</th>
                </tr>
            </table>
        </div>
    </div>
    <div class="tab-pane fade" id="MZsickKindList">
        <%--门诊病种列表--%>

        <div style="margin: 0 auto;width:70%;">
            <table class="table table-striped table-bordered table-condensed">
                <tr>
                    <th>序号</th>
                    <th>身份证号</th>
                    <th>姓名</th>
                    <th>病种名称</th>
                    <th>是否需要年审</th>
                    <th>结算开始日期</th>
                    <th>结算结束日期</th>
                    <th>结算医疗机构1</th>
                    <th>签约时间1</th>
                    <th>结算医疗机构2</th>
                    <th>签约时间2</th>
                    <th>结算医疗机构3</th>
                    <th>签约时间3</th>
                    <th>审核标准</th>
                    <th>鉴定医疗机构</th>
                    <th>操作人</th>
                    <th>操作时间</th>
                    <th>业务档案号</th>
                    <th>鉴定专家</th>
                </tr>
            </table>
        </div>
    </div>
    <div class="tab-pane fade" id="PersonpasureInfo">
        <%--	//个人养老基本信息--%>
        <div style="margin: 0 auto;width:70%;">
            <table class="table table-striped table-bordered table-condensed">
                <tr>
                    <td width="20%">身份证号码</td>
                    <td width="40%" colspan="2"></td>
                    <td width="20%">人员身份</td>
                    <td width="20%"></td>
                </tr>
                <tr>
                    <td width="10%">姓名</td>
                    <td width="10%"></td>
                    <td width="20%">出生日期</td>
                    <td width="20%"></td>
                    <td width="20%">社会保险状态</td>
                    <td width="20%"></td>
                </tr>
                <tr>
                    <td>IC卡号</td>
                    <td></td>
                    <td>退休待遇类型</td>
                    <td colspan="3"></td>

                </tr>
                <tr>
                    <td>性别</td>
                    <td></td>
                    <td>参加工作年月</td>
                    <td></td>
                    <td>用工形式</td>
                    <td></td>
                </tr>
                <tr>
                    <td>民族</td>
                    <td></td>
                    <td>视同缴费月数</td>
                    <td></td>
                    <td>个人身份</td>
                    <td></td>
                </tr>
                <tr>
                    <td>特殊工种标识</td>
                    <td></td>
                    <td>特殊工种加发月数</td>
                    <td></td>
                    <td>社保身份</td>
                    <td></td>
                </tr>
                <tr>
                    <td>技术职称</td>
                    <td></td>
                    <td>特殊工种缴费总月数</td>
                    <td></td>
                    <td>视同账户建账状态</td>
                    <td></td>
                </tr>
                <tr>
                    <td>电话号码</td>
                    <td></td>
                    <td>联系人</td>
                    <td></td>
                    <td>联系电话</td>
                    <td></td>
                </tr>
                <tr>
                    <td>邮政编码</td>
                    <td></td>
                    <td>电子邮件地址</td>
                    <td></td>
                    <td>户口性质</td>
                    <td></td>
                </tr>
                <tr>
                    <td>资料审档标识</td>
                    <td></td>
                    <td>通讯地址</td>
                    <td colspan="3"></td>

                </tr>
                <tr>
                    <td>组织机构代码</td>
                    <td></td>
                    <td>单位名称</td>
                    <td colspan="3"></td>

                </tr>
                <tr>
                    <td>实际缴费月数</td>
                    <td></td>
                    <td>1998年7月前实际缴费月数</td>
                    <td></td>
                    <td>人员去向</td>
                    <td></td>
                </tr>
                <tr>
                    <td>实际缴费起止年月</td>
                    <td></td>
                    <td>建账方式</td>
                    <td></td>
                    <td>调入年月</td>
                    <td></td>
                </tr>
                <tr>
                    <td>最近转入地</td>
                    <td></td>
                    <td>建账总额</td>
                    <td></td>
                    <td>特殊工种时段</td>
                    <td></td>
                </tr>

            </table>
        </div>
    </div>
    <div class="tab-pane fade" id="PersonInfo">
        <%--//个人基本信息--%>
        <div style="margin: 0 auto;width:80%;">
            <table class="table table-striped table-bordered table-condensed">
                <tr>
                    <th colspan="6" style="text-align:left;">个人基本信息</th>
                </tr>
                <tr>
                    <td width="20%">公民身份号码</td>
                    <td width="20%" style="color:red;"></td>
                    <td width="10%">姓名</td>
                    <td width="20%"></td>
                    <td width="10%">性别</td>
                    <td width="20%"></td>
                </tr>
                <tr>

                    <td>出生日期</td>
                    <td style="color:red;"></td>
                    <td>参加工作年月</td>
                    <td></td>
                    <td>参保工资</td>
                    <td></td>
                </tr>
                <tr>
                    <td>户口类型</td>
                    <td style="color:red;"></td>
                    <td>人员类别</td>
                    <td></td>
                    <td>工种类型</td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td>医保状态</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>用工形式</td>
                    <td style="color:red;"></td>
                    <td>个人身份</td>
                    <td></td>
                    <td>社保身份</td>
                    <td></td>
                </tr>
                <tr>
                    <td>医疗类别</td>
                    <td style="color:red;"></td>
                    <td>电话号码</td>
                    <td></td>
                    <td>联系人</td>
                    <td></td>
                </tr>
                <tr>
                    <td>联系人电话</td>
                    <td></td>
                    <td>邮政编码</td>
                    <td></td>
                    <td>电子邮箱</td>
                    <td></td>
                </tr>
                <tr>
                    <td>民族</td>
                    <td style="color:red;"></td>
                    <td>通讯地址</td>
                    <td colspan="3"></td>

                </tr>
                <tr>
                    <td>IC卡号</td>
                    <td
                    "></td>
                    <td>人员去向</td>
                    <td></td>
                    <td>纳税人编号</td>
                    <td></td>
                </tr>
                <tr>
                    <td>档案编号</td>
                    <td></td>
                    <td>银行账号</td>
                    <td></td>
                    <td>开户银行</td>
                    <td></td>
                </tr>
                <tr>
                    <td>组织机构代码</td>
                    <td style="color:red;"></td>
                    <td>单位名称</td>
                    <td colspan="3"></td>

                </tr>
                <tr>
                    <td>是否邮寄收据</td>
                    <td></td>
                    <td>退休待遇类型</td>
                    <td></td>
                    <td>个账审档标识</td>
                    <td></td>
                </tr>
                <tr>
                    <td>地税增员时间</td>
                    <td></td>
                    <td>地税减员时间</td>
                    <td></td>
                    <td>社会保险状态</td>
                    <td></td>
                </tr>

                <tr>
                    <td>个人编号</td>
                    <td></td>
                    <td>账户标记</td>
                    <td></td>
                    <td>有效起始时间</td>
                    <td></td>
                </tr>
                <tr>
                    <td>有效终止时间</td>
                    <td colspan="5"></td>


                </tr>
                <tr>
                    <td>性别</td>
                    <td></td>
                    <td>参加工作年月</td>
                    <td></td>
                    <td>用工形式</td>
                    <td></td>
                </tr>
                <tr>
                    <td>民族</td>
                    <td></td>
                    <td>视同缴费月数</td>
                    <td></td>
                    <td>个人身份</td>
                    <td></td>
                </tr>
                <tr>
                    <td>特殊工种标识</td>
                    <td></td>
                    <td>特殊工种加发月数</td>
                    <td></td>
                    <td>社保身份</td>
                    <td></td>
                </tr>
                <tr>
                    <td>技术职称</td>
                    <td></td>
                    <td>特殊工种缴费总月数</td>
                    <td></td>
                    <td>视同账户建账状态</td>
                    <td></td>
                </tr>
                <tr>
                    <td>电话号码</td>
                    <td></td>
                    <td>联系人</td>
                    <td></td>
                    <td>联系电话</td>
                    <td></td>
                </tr>
                <tr>
                    <td>邮政编码</td>
                    <td></td>
                    <td>电子邮件地址</td>
                    <td></td>
                    <td>户口性质</td>
                    <td></td>
                </tr>
                <tr>
                    <td>资料审档标识</td>
                    <td></td>
                    <td>通讯地址</td>
                    <td colspan="3"></td>

                </tr>
                <tr>
                    <td>组织机构代码</td>
                    <td></td>
                    <td>单位名称</td>
                    <td colspan="3"></td>

                </tr>
                <tr>
                    <td>实际缴费月数</td>
                    <td></td>
                    <td>1998年7月前实际缴费月数</td>
                    <td></td>
                    <td>人员去向</td>
                    <td></td>
                </tr>
                <tr>
                    <td>实际缴费起止年月</td>
                    <td></td>
                    <td>建账方式</td>
                    <td></td>
                    <td>调入年月</td>
                    <td></td>
                </tr>
                <tr>
                    <td>最近转入地</td>
                    <td></td>
                    <td>建账总额</td>
                    <td></td>
                    <td>特殊工种时段</td>
                    <td></td>
                </tr>

            </table>

            <table class="table table-striped table-bordered table-condensed" style="margin-top:10px;">
                <tr>
                    <th>险种</th>
                    <th>状态</th>
                    <th>参保月份</th>
                    <th>停保月份</th>
                    <th>征收月份</th>
                    <th>首次参保月份</th>
                    、
                </tr>
                <tr>
                    <td>养老</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>

                </tr>
                <tr>
                    <td>工伤</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>

                </tr>
                <tr>
                    <td>失业</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>

                </tr>
                <tr>
                    <td>医疗</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>

                </tr>
                <tr>
                    <td>生育</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>

                </tr>
            </table>
        </div>
    </div>
    <div class="tab-pane fade" id="PersonPayInfo">
        <%--//个人缴费信息--%>

        <div style="margin: 0 auto;width:80%;">


            <table class="table table-striped table-bordered table-condensed">

                <tr>
                    <td colspan="13" style="text-align:left;">记录数：页次：</td>
                </tr>
                <tr>
                    <td colspan="13" style="text-align:left;">
                        险种：
                        <select id="" name="" class="input-medium selectWidth">
                            <option value="1">基本养老保险</option>
                            <option value="2">基本医疗保险</option>
                            <option value="3">基本工伤保险</option>
                            <option value="4">基本失业保险</option>
                            <option value="5">基本生育保险</option>
                        </select>
                        到账标志
                        <select id="" name="" class="input-medium selectWidth">
                            <option value="1">全部</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="13">
                        缴费年月
                        <input name="starthospitaldate" type="text" readonly="readonly"
                               maxlength="20" class="input-mini Wdate"
                               value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                               style="width: 150px;margin-top:10px;"/>至
                        <input name="starthospitaldate" type="text" readonly="readonly"
                               maxlength="20" class="input-mini Wdate"
                               value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                               style="width: 150px;margin-top:10px;"/>
                        <button id="searchBtn" type="submit" data-toggle="tooltip" class="btn"
                                data-placement="right">
                            <i class="icon-search"></i>
                        </button>
                    </td>
                </tr>
                <tr>
                    <th>序号</th>
                    <th>险种</th>
                    <th>缴费月份</th>
                    <th>台账月份</th>
                    <th>缴费工资</th>
                    <th>个人缴拨额</th>
                    <th>单位缴拨额</th>
                    <th>单位入户专额</th>
                    <th>缴费类型</th>
                    <th>到账标志</th>
                    <th>单位名称</th>
                    <th>总金额</th>
                    <th>到账日期</th>

                </tr>
            </table>
        </div>
    </div>
    <div class="tab-pane fade" id="FiveinsurancePayRecords">
        <%--//五险待遇发放记录--%>

        <div style="margin: 0 auto;width:70%;">


            <table class="table table-striped table-bordered table-condensed">

                <tr>
                    <td colspan="13" style="text-align:left;">记录数：页次：</td>
                </tr>
                <tr>
                    <td colspan="13" style="text-align:left;">
                        险种：
                        <select id="" name="" class="input-medium selectWidth">
                            <option value="1">基本养老保险</option>
                            <option value="2">基本医疗保险</option>
                            <option value="3">基本工伤保险</option>
                            <option value="4">基本失业保险</option>
                            <option value="5">基本生育保险</option>
                        </select>


                        <button id="searchBtn" class="btn" type="submit" data-toggle="tooltip"
                                data-placement="right">
                            <i class="icon-search"></i>
                        </button>
                    </td>
                </tr>
                <tr>
                    <th>序号</th>
                    <th>户名</th>
                    <th>所属年月</th>
                    <th>待遇类型</th>
                    <th>金额</th>
                    <th>支付类型</th>
                    <th>支付年月</th>
                    <th>单位入户专额</th>
                    <th>支付状态</th>
                    <th>银行处理状态</th>


                </tr>
            </table>
        </div>
    </div>
    <div class="tab-pane fade" id="GSRegisterDetails">
        <%--工伤登记详细信息--%>
        <div style="margin: 0 auto;width:70%;">
            <table class="table table-striped table-bordered table-condensed">


                <tr>
                    <td width="25%">工伤人员身份证</td>
                    <td width="75%" colspan="3"></td>

                </tr>
                <tr>
                    <td width="25%">工伤人员姓名</td>
                    <td width="25%"></td>
                    <td width="25%">档案编号</td>
                    <td width="25%"></td>
                </tr>
                <tr>
                    <td>工行发生时所在单位</td>
                    <td></td>
                    <td>单位编号</td>
                    <td></td>
                </tr>
                <tr>
                    <td>申报人姓名</td>
                    <td></td>
                    <td>申报人联系电话</td>
                    <td></td>
                </tr>
                <tr>
                    <td>申请人性质</td>
                    <td></td>
                    <td>申报方式</td>
                    <td></td>
                </tr>
                <tr>
                    <td>治疗医院</td>
                    <td></td>
                    <td>住院或门诊</td>
                    <td></td>
                </tr>
                <tr>
                    <td>伤亡标志</td>
                    <td></td>
                    <td>死亡或失踪时间</td>
                    <td></td>
                </tr>
                <tr>
                    <td>事故时间</td>
                    <td></td>
                    <td>上报时间</td>
                    <td></td>
                </tr>
                <tr>
                    <td>事故描述</td>
                    <td colspan="3"></td>

                </tr>
                <tr>
                    <td>初步诊断</td>
                    <td></td>
                    <td>认定申报时间</td>
                    <td></td>
                </tr>
                <tr>
                    <td>老工伤分段旧病复发状态</td>
                    <td></td>
                    <td>旧病复发或延长医疗期时间段</td>
                    <td></td>
                </tr>
                <tr>
                    <td>是否结案</td>
                    <td></td>
                    <td>是否退伍军人</td>
                    <td></td>
                </tr>
                <tr>
                    <td>结案处理时间</td>
                    <td></td>
                    <td>辖区</td>
                    <td></td>
                </tr>
            </table>
        </div>
    </div>
</div>


</body>
</html>
<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%@ attribute name="items" type="java.util.List" required="true" description="编号" %>
<c:forEach items="${tabs}" var="tab">
    <c:choose>
        <c:when test="${tab.querytagid.value == 1}">
            <li><a href="#CompanyInfo" data-toggle="tab">单位基本信息</a></li>
        </c:when>
        <c:when test="${tab.querytagid.value == 2}">
            <li><a href="#PersonInfo" data-toggle="tab">个人基本信息</a></li>
        </c:when>
        <c:when test="${tab.querytagid.value == 3}">
            <li><a href="#PersonPayInfo" data-toggle="tab">个人缴费信息</a></li>
        </c:when>
        <c:when test="${tab.querytagid.value == 4}">
            <li><a href="#referralsInfo" data-toggle="tab">转诊信息</a></li>
        </c:when>
        <c:when test="${tab.querytagid.value == 5}">
            <li><a href="#HistoryHospitoalinfo" data-toggle="tab">历史住院信息</a></li>
        </c:when>
        <c:when test="${tab.querytagid.value == 6}">
            <li><a href="#Historyoutpatient" data-toggle="tab">历史门诊信息</a></li>
        </c:when>
        <c:when test="${tab.querytagid.value == 7}">
            <li><a href="#HistoryPayinfo" data-toggle="tab">历史缴费信息</a></li>
        </c:when>
        <c:when test="${tab.querytagid.value == 8}">
            <li><a href="#Pasurepersonalinfo" data-toggle="tab">养老个人账户信息</a></li>
        </c:when>
        <c:when test="${tab.querytagid.value == 9}">
            <li><a href="#PersonpasureInfo" data-toggle="tab">个人养老基本信息</a></li>
        </c:when>
        <c:when test="${tab.querytagid.value == 10}">
            <li><a href="#sameAccountnewA" data-toggle="tab">视同账户建账信息</a></li>
        </c:when>
        <c:when test="${tab.querytagid.value == 11}">
            <li><a href="#elsewherepensions" data-toggle="tab">异地转入地方养老金</a></li>
        </c:when>
        <c:when test="${tab.querytagid.value == 12}">
            <li><a href="#birthbeforeOrginfo" data-toggle="tab">产前签约机构信息</a></li>
        </c:when>
        <c:when test="${tab.querytagid.value == 13}">
            <li><a href="#GSRegisterDetails" data-toggle="tab">工伤登记详细信息</a></li>
        </c:when>
        <c:when test="${tab.querytagid.value == 14}">
            <li><a href="#GSregisterinfQurey" data-toggle="tab">工伤登记信息查询</a></li>
        </c:when>
        <c:when test="${tab.querytagid.value == 15}">
            <li><a href="#GSRecoverinfQurey" data-toggle="tab">工伤康复登记信息查询</a></li>
        </c:when>
        <c:when test="${tab.querytagid.value == 16}">
            <li><a href="#GSreferralsinfQurey" data-toggle="tab">工伤转诊登记信息查询</a></li>
        </c:when>
        <c:when test="${tab.querytagid.value == 17}">
            <li><a href="#elsewhereSameasInfo" data-toggle="tab">异地转入视同信息</a></li>
        </c:when>
        <c:when test="${tab.querytagid.value == 18}">
            <li><a href="#elsewherePay" data-toggle="tab">异地转入工资信息</a></li>
        </c:when>
        <c:when test="${tab.querytagid.value == 19}">
            <li><a href="#liveelsewhereDetail" data-toggle="tab">长住异地详细信息</a></li>
        </c:when>
        <c:when test="${tab.querytagid.value == 20}">
            <li><a href="#FiveinsurancePayRecords" data-toggle="tab">五险待遇发放记录</a></li>
        </c:when>
    </c:choose>
</c:forEach>
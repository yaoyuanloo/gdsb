<%--
  Created by IntelliJ IDEA.
  User: cxd
  Date: 2016/9/16
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>Title</title>
    <meta name="decorator" content="default"/>
    <style>
        #mutilBusinessSetting tr td:first-child{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="well" style="height: 381px; margin: 0;">
    <div class="form-search breadcrumb">
        <ul class="ul-form">
            <li>
                <label>是否协同：</label>
                <select id="teamwork" name="teamwork" class="input-medium selectWidth">
                    <option value="0">否</option>
                    <option value="1">是</option>
                </select>
            </li>
        </ul>
    </div>
    <table id="mutilBusinessSettingTable" class="table table-striped table-bordered table-condensed"
           style="overflow-y: auto;">
        <thead>
        <tr>
            <th style="width: 15px;"></th>
            <th>业务名称</th>
        </tr>
        </thead>
        <tbody id="mutilBusinessSetting">
        <tr href="javascript:void(0);" class="multiBox" value="${ywid}"
            onclick="checkLabel(this, '#mutilBusinessSetting')">
            <td><i class="multiBoxIcon icon-circle-blank" value="${ywid}"></i></td>
            <td class="multiBoxLabel">${ywmc}</td>
        </tr>
        <c:forEach items="${gtywinfos}" var="info">
            <tr href="javascript:void(0);" class="multiBox" value="${info.ywid}"
                onclick="checkLabel(this, '#mutilBusinessSetting')">
                <td><i class="multiBoxIcon icon-circle-blank" value="${info.ywid}"></i></td>
                <td class="multiBoxLabel">${info.ywmc}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script>
    $("#teamwork").change(function(){
        if($(this).val() == "1") {
            twinkle("#mutilBusinessSettingTable");
        }
    });

</script>
</body>
</html>

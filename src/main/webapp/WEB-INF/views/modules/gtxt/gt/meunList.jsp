<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>菜单</title>
    <meta name="decorator" content="yhdefault"/>
    <style>
    </style>
</head>
<body>
<div class="box box-default">
    <!-- box-header -->
    <div class="box-header with-border">
        <h3 class="box-title">
            <div class="dec_1"></div>
            菜单
        </h3>
        <div class="box-tools pull-right">
            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
        </div>
    </div>
    <!-- box-body -->
    <div class="box-body">
        <h5 class="form-horizontal">
            <h5 class="form-group">
                <ul class="list-group span3">
                    <li class="list-group-item">
                        <h5>登记业务</h5>
                    </li>
                    <c:forEach items="${dengjiyewu}" var="yewu">
                        <a href="${ctx}${yewu.href}" class="list-group-item">
                            <h7 class="list-group">&nbsp;&nbsp;${yewu.name}</h7>
                        </a>
                    </c:forEach>
                </ul>
                <ul class="list-group span3">
                    <li class="list-group-item">
                        <h5>失业业务</h5>
                    </li>
                    <c:forEach items="${shiyeyewu}" var="yewu">
                        <a href="${ctx}${yewu.href}" class="list-group-item">
                            <h7 class="list-group">&nbsp;&nbsp;${yewu.name}</h7>
                        </a>
                    </c:forEach>
                </ul>
                <ul class="list-group span3">
                    <li class="list-group-item">
                        <h5>养老业务</h5>
                    </li>
                    <c:forEach items="${yanglaoyewu}" var="yewu">
                        <a href="${ctx}${yewu.href}" class="list-group-item">
                            <h7 class="list-group">&nbsp;&nbsp;${yewu.name}</h7>
                        </a>
                    </c:forEach>
                </ul>

                <ul class="list-group span3">
                    <li class="list-group-item">
                        <h5>医疗业务</h5>
                    </li>
                    <c:forEach items="${yiliaoyewu}" var="yewu">
                        <a href="${ctx}${yewu.href}" class="list-group-item">
                            <h7 class="list-group">&nbsp;&nbsp;${yewu.name}</h7>
                        </a>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>

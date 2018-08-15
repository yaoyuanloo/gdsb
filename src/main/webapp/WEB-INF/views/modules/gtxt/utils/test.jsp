<%--
  Created by IntelliJ IDEA.
  User: cxdwe
  Date: 2016/9/10
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>流转失败提示</title>
    <meta name="decorator" content="default"/>
</head>
<body>
<c:choose>
    <c:when test="${finished}" >
        <script>
            $(function(){
                alertx("${content}", function(){
                    $.fn.jerichoTab.closeCurrentTab();
                });
            });
        </script>
    </c:when>
    <c:otherwise>
        <div class="alert" style="font-size: 14px; margin: 0; text-align: center;">
            <button type="button" class="close" data-dismiss="alert"><%--&times;--%></button>
                ${content}
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>

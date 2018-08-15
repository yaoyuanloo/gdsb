<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>深圳社保受理系统</title>
    <meta name="decorator" content="default"/>
    <style>

        .selectWidth {
            width: 170px;
        }

        .inputWidth {
            width: 156px;
        }

        td, td * {
            /*word-break: keep-all;*/
        }

        .btn-small {
            font-size: 13px;
        }

        label {
            width: 120px;
        }

        /*ul li {*/
            /*margin-left: 25px;*/
        /*}*/

        #contentTable th, #contentTable, td {
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
        }
    </style>
    <script type="text/javascript">
        function page(n, s) {
            $("#pageNo").val(n);
            $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/gt/gtywinfocb/list">业务信息列表</a></li>
</ul>

<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>业务流水号</th>
        <th>业务流程</th>
        <th>处理意见</th>
        <th>处理人</th>
        <th>处理人</th>
        <th style="width: 110px;">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="gtYwinfocb">
        <tr>
            <td  style="font-size: 16px;">
                    ${gtYwinfocb.ywlsh}
            </td>
            <td>
                    ${gtYwinfocb.ywlc}
            </td>
            <td>
                    ${gtYwinfocb.cljg}
            </td>
            <td>
                    ${gtYwinfocb.clyj}
            </td>
            <td>
                    ${gtYwinfocb.clr}
            </td>
            <td>
             <div class="btn-group">
                    <a href="#" class="btn btn-small">预览</a>
              </div>
                </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
<script>
    $("#contentTable").colResizable({
        liveDrag: true,
        gripInnerHtml: "<div class='grip'></div>",
        draggingClass: "dragging",
        resizeMode: 'fit'
    });
</script>
</body>
</html>
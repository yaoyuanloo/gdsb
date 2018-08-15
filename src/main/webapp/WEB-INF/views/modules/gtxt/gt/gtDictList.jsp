<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>业务字典管理</title>
    <meta name="decorator" content="default"/>
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
    <li class="active"><a href="${ctx}/gtxt/gt/gtdict/">业务字典列表</a></li>
    <shiro:hasPermission name="gt:gtdict:edit">
        <li><a href="${ctx}/gtxt/gt/gtdict/form?sort=10">业务字典添加</a></li>
    </shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="gtDict" action="${ctx}/gtxt/gt/gtdict/" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <label>类型：</label>
    <form:select id="type" path="type" class="input-medium" cssStyle="width: 300px;">
        <form:option value="" label=""/>
        <c:forEach items="${typeList}" var="d">
            <form:option value="${d.type}" label="${d.description} : ${d.type}"/>
        </c:forEach>
    </form:select>
    &nbsp;&nbsp;
    <label>描述 ：</label>
    <form:input path="description" htmlEscape="false" maxlength="50"
                class="input-medium"/>
    &nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>键值</th>
        <th>标签</th>
        <th>类型</th>
        <th>描述</th>
        <th>排序</th>
        <shiro:hasPermission name="gt:gtdict:edit">
            <th>操作</th>
        </shiro:hasPermission></tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="dict">
        <tr>
            <td>${dict.value}</td>
            <td><a href="${ctx}/gtxt/gt/gtdict/form?id=${dict.id}">${dict.label}</a></td>
            <td><a href="javascript:"
                   onclick="$('#type').val('${dict.type}');$('#searchForm').submit();return false;">${dict.type}</a>
            </td>
            <td>${dict.description}</td>
            <td>${dict.sort}</td>
            <shiro:hasPermission name="gt:gtdict:edit">
                <td>
                    <a href="${ctx}/gtxt/gt/gtdict/form?id=${dict.id}">修改</a>
                    <a href="${ctx}/gtxt/gt/gtdict/delete?id=${dict.id}&type=${dict.type}"
                       onclick="return confirmx('确认要删除该业务字典吗？', this.href)">删除</a>
                    <a href="<c:url value='${fns:getAdminPath()}/gtxt/gt/gtdict/form?type=${dict.type}&sort=${dict.sort+10}'><c:param name='description' value='${dict.description}'/></c:url>">添加键值</a>
                </td>
            </shiro:hasPermission>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>
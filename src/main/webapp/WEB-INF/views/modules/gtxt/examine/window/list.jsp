<%--
  Created by IntelliJ IDEA.
  User: cxd
  Date: 2016/9/6
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>窗口审核列表</title>
    <meta name="decorator" content="default"/>
    <style>

        .selectWidth {
            width: 164px;
        }

        .inputWidth {
            width: 150px;
        }

        td, td * {
            /*word-break: keep-all;*/
        }

        .btn-small {
            font-size: 13px;
        }

        table th, table, td {
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
    <li class="active"><a href="${ctx}/gtxt/examine/window/list?pageNo=${(not empty pageNo)?pageNo : 0}">窗口审核列表</a></li>
</ul>
<div style="margin: 0; padding: 0; border: 0; width: 100%; z-index: 999; background: white;">
    <div id="searchForm" class="breadcrumb form-search" style=" margin: 0; border: 0;">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
        <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
        <ul class="ul-form">
            <li><label for="by6">受理回执号：</label>
                <input id="by6" name="by6" type="text" htmlEscape="false" maxlength="50"
                       class="input-medium inputWidth"/>
            </li>
            <li><label for="ywlsh">业务流水号：</label>
                <input id="ywlsh" name="ywlsh" type="text" htmlEscape="false" maxlength="50"
                       class="input-medium inputWidth"/>
            </li>
            <li><label for="dnh">电脑号：</label>
                <input id="dnh" name="dnh" type="text" htmlEscape="false" maxlength="50"
                       class="input-medium inputWidth"/>
            </li>
            <li><label for="sfzh">身份证号：</label>
                <input id="sfzh" name="sfzh" type="text" htmlEscape="false" maxlength="50"
                       class="input-medium inputWidth"/>
            </li>
            <li class="clearfix"></li>
            <li><label for="xm">受理人：</label>
                <input id="xm" name="cjr" type="text" htmlEscape="false" maxlength="50"
                       class="input-medium inputWidth"/>
            </li>
            <li><label for="dwbh">单位编号：</label>
                <input id="dwbh" name="dwbh" type="text" htmlEscape="false" maxlength="50"
                       class="input-medium inputWidth"/>
            </li>
            <li><label>申报方式：</label>
                <select id="by13" name="by13" class="input-medium selectWidth">
                    <option value="社保窗口业务">社保窗口业务</option>
                </select>
            </li>
            <li><label>业务状态：</label>
                <select id="lczt" name="lczt" class="input-medium selectWidth">
                    <option value=""></option>
                    <option value="LCB004">已受理</option>
                </select></li>
            <li class="clearfix"></li>
            <li><label>受理时间：</label>
                <input name="cjsj" type="text" readonly="readonly"
                       maxlength="20" class="input-mini Wdate"
                       value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                       onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"
                       style="width: 150px;"/>
            <li><label>归属辖区：</label>
                <sys:treeselect id="fenqu" name="fenqu.code" value="${work.fenqu.code}" labelName="fenqu.name"
                                labelValue="${work.fenqu.name}" notAllowSelectParent="false"
                                title="辖区" url="/xq/area/treeData" cssClass="input-small" cssStyle="width: 105px;"
                                allowClear="true"/>
            </li>
            <li class="btns" style="padding-left: 436px;"><input id="btnSubmit" class="btn btn-primary" type="submit"
                                                                 value="查询" style="width: 80px;"/>
            </li>
        </ul>
    </
    >
    <sys:message content="${message}"/>
</div>
<div style="width: 100%; overflow-x: inherit;">
    <table id="contentTable" class="table table-striped table-bordered table-condensed" style="width: 100%;">
        <thead>
        <tr>
            <th>受理回执号</th>
            <th>申报方式</th>
            <th>业务名称</th>
            <th>单位编号</th>
            <th>单位名称</th>
            <th>电脑号</th>
            <th>姓名</th>
            <th>业务状态</th>
            <th>受理时间</th>
            <th>分管区域</th>
            <th>受理区域</th>
            <th>受理人</th>
            <th style="width: 60px;">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="yw">
            <tr>
                <td style="/*font-family: 'C39P24DmTt';*/ font-size: 16px;">

                </td>
                <td>

                </td>
                <td>
                        ${yw.name}
                </td>
                <td>

                </td>
                <td>

                </td>
                <td>

                </td>
                <td>

                </td>
                <td>

                </td>
                <td>

                </td>
                <td>

                </td>
                <td>

                </td>
                <td>

                </td>
                <td>
                    <div class="btn-group">
                        <a href="${ctx}/gtxt/examine/window/detail?business=${yw.business}&examine=${yw.examine}&typename=${yw.typename}&type=${yw.type}&ywlsh=100605120438450261527388"
                           class="btn btn-small">审核</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">${page}</div>
</div>
<script>
    $(function () {
        $("table").colResizable({
            liveDrag: true,
            gripInnerHtml: "<div class='grip'></div>",
            draggingClass: "dragging",
            resizeMode: 'fit',
            postbackSafe: true,
            partialRefresh: true
        });
    });
</script>
</body>
</html>

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
        var followDetailsObj = null;
        $(document).ready(function () {
            /* 	$(".preCss").each(function() {
             var n = $(this).text();
             var num = n - 0;
             if (num == '-3') {
             $(this).addClass("greenCss");
             $(this).text("√");
             } else if (num == '-2') {
             $(this).addClass("blackCss");
             $(this).text("×");
             } else {
             if (num > '5') {
             $(this).addClass("yellowCss");
             } else {
             $(this).addClass("redCss");
             }
             }
             }) */
            $(".followDetails").click(function () {
                followDetailsObj = this;
            });
        })
        function turnFollow() {
            /* 受理回执号slhzh 姓名xm 业务名称ywmc*/
            var slhzh = $(followDetailsObj).attr('by6');
            followDetail(slhzh);
        }

        function followDetail(slhzh) {
            top.$.jBox.open("iframe:${ctx}/sisl/TrackBus/showFollowDetail?slhzh="
                    + slhzh, title = "受理回执号:"
                    + slhzh, 810, 450, {
                loaded: function () {
                    $(".jbox-content", top.document).css("overflow-y", "hidden");
                    closeTip();
                },
                opacity: 0.5,
                border: 1
            });
        }
        $("#btnExport").click(function () {
            top.$.jBox.confirm("请选择导出条件", "系统提示", function (v, h, f) {
                if (v == "ok") {
                    /* $("#searchForm").attr("action","
                    ${ctx}/sys/user/export");
                     $("#searchForm").submit(); */
                }
            }, {buttonsFocus: 1});
            top.$('.jbox-body .jbox-icon').css('top', '55px');
        });
        function exportExcl() {
            top.$.jBox.open("iframe:${ctx}/slzt/slinfo/getExportForm", "选择导出条件", 720, 475, {
                buttons: {
                    "导出": "qr",
                    "返回": "cancer"
                },
                submit: function (v, h, f) {
                    var win = h.find("iframe")[0].contentWindow;
                    var doc = win.document;
                    var ywlx = win.getCheckbox();
                    var dcms = win.getRadio();
                    var startTime = $("#cjsj1", doc).val();
                    var endTime = $("#cjsj2", doc).val();
                    var lczt = $("#lczt", doc).val();
                    // console.log(data);
                    if (v == "qr") {
                        //var action="${ctx}/slzt/slinfo/export?startTime="+startTime+"&endTime="+endTime+"&lczt="+lczt+"&ywlx="+ywlx+"&dcms="+encodeURI(dcms)+"&qytype="+encodeURI(qytype);
                        if (startTime == '' || typeof(startTime) == 'undefined' || endTime == '' || typeof(endTime) == 'undefined') {
                            alertx("请选择导出时间段！");
                            return false;
                        } else if (ywlx == '' || typeof(ywlx) == "undefined") {
                            alertx("请选择业务类型！");
                            return false;
                        } else if (dcms == '' || typeof(dcms) == 'undefined') {
                            alertx("请选择导出模式！");
                            return false;
                        } else {
                            var action = "${ctx}/slzt/slinfo/export?startTime=" + startTime + "&endTime=" + endTime + "&lczt=" + lczt + "&ywlx=" + ywlx + "&dcms=" + dcms;
                            $("#searchForm", doc).attr("action", action);
                            $("#searchForm", doc).submit();
                            return false;
                        }

                    }
                },
                /*  loaded: function (h) {
                 closeTip();
                 $(".jbox-content", top.document).css("overflow-y", "hidden");
                 }, */
                iframeScrolling: 'no',
                showType: 'show',
                opacity: 0.5,
                top: "15%",
                border: 1,
                persistent: true
            });
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/gt/gtYwinfo/list">业务信息列表</a></li>
</ul>
<form:form id="searchForm" modelAttribute="gtYwinfo" action="${ctx}/gt/gtYwinfo/list" method="post"
           class="breadcrumb form-search" cssStyle=" margin: 0; border: 0;">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
       <%--  <li><label for="by6">受理回执号：</label>
            <form:input id="by6" path="by6" htmlEscape="false" maxlength="50" class="input-medium inputWidth"/>
        </li> --%>
        <li><label for="ywlsh">业务流水号：</label>
            <form:input id="ywlsh" path="ywlsh" htmlEscape="false" maxlength="50" class="input-medium inputWidth"/>
        </li>
        <li><label for="grsbh">个人社保号：</label>
            <form:input id="grsbh" path="grsbh" htmlEscape="false" maxlength="50" class="input-medium inputWidth"/>
        </li>
        <li><label for="sfzh">身份证号：</label>
            <form:input id="sfzh" path="sfzh" htmlEscape="false" maxlength="50" class="input-medium inputWidth"/>
        </li>
        <li><label for="slr">受理人编号：</label>
            <form:input id="slr" path="slr" htmlEscape="false" maxlength="50" class="input-medium inputWidth"/>
        </li>
        <li class="clearfix"></li>
        <li><label>申报方式：</label>
            <form:select id="sbfs" path="sbfs" class="input-medium selectWidth">
              <form:option value="" label="全部"/>
              <form:options items="${fns:getDictList('sb_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</form:select>
        </li>
        <li><label>业务状态：</label>
            <form:select id="lczt" path="lczt"  class="input-medium selectWidth">
                <form:option value="" label="全部"/>
                <form:options items="${fns:getDictList('lczt')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			
                </form:select>
                </li>
         <%--<li><label>归属辖区：</label>
            <sys:treeselect id="fenqu1" name="fenqu.code" value="${work.fenqu.code}" labelName="fenqu.name"
                            labelValue="${work.fenqu.name}" notAllowSelectParent="false"
                            title="辖区" url="/xq/area/treeData" cssClass="input-small" cssStyle="width: 110px;"
                            allowClear="true"/> 
        </li>--%>
         <%--<li><label>受理区域：</label>
            <sys:treeselect id="fenqu2" name="fqbh" value="${work.fqbh}" labelName="fqmc"
                            labelValue="${work.fqmc}" notAllowSelectParent="false"
                            title="辖区" url="/xq/area/treeData" cssClass="input-small" cssStyle="width: 110px;"
                            allowClear="true"/>
        </li> --%>
         <%--<li>  <label>受理部门：</label>
              <form:select path="by12" class="input-medium selectWidth">
                    <form:option value="" label="全部"/>
					<form:options items="${fns:getDictList('slbm')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select> 
		 </li>		--%> 
        <li class="clearfix"></li>
        <li><label for="dwbh">单位编号：</label>
            <form:input id="dwbh" path="dwbh" htmlEscape="false" maxlength="50" class="input-medium inputWidth"/>
        </li>
        <li><label>受理时间段：</label>
                <span>
					<input id="starttime" name="starttime" type="text" readonly="readonly"
                           maxlength="20" class="input-medium Wdate "
                           value="<fmt:formatDate value="${cjdate}" pattern="yyyy-MM-dd"/>"
                           onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"
                           style="width: 100px;vertical-align: middle;"/>
                   &nbsp;到&nbsp;
                   <input id="endtime" name="endtime" type="text" readonly="readonly"
                          maxlength="20" class="input-medium Wdate "
                          value="<fmt:formatDate value="${cjdate}" pattern="yyyy-MM-dd"/>"
                          onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"
                          style="width: 100px;vertical-align: middle;"/>
				</span>
                <%--
                <input name="cjsj" type="text" readonly="readonly"
                           maxlength="20" class="input-mini Wdate"
                           value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                           onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"
                           style="width: 150px;"/>
                 </li>  --%>
        <li class="btns" style="padding-left: 60px;">
            <input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" style="width: 60px;"/>
            <input id="btnExport" class="btn btn-primary" type="button" value="导出" onclick="exportExcl()"
                   style="width: 60px;"/>
        </li>
    </ul>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>受理回执号</th>
        <th>业务流水号</th>
        <%--<th>业务功能代码</th>--%>
        <th>业务名称</th>
        <th>个人社保号</th>
        <th>个人身份证号</th>
        <th>姓名</th>
        <th>单位编号</th>
        <th>单位名称</th>
        <th>受理人</th>
        <th>审核人</th>
        <th>分配人</th>
        <th>申报方式</th>
        <th>受理区域</th>
        <th>受理时间</th>
        <th>协同</th>
        <th>流程状态</th>
        <th style="width: 110px;">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="gtYwinfo">
        <tr class="<%--followDetails--%>" >
            <td  style="font-size: 16px;">
                    ${gtYwinfo.smjbh}
            </td>
            <td<%-- style="width: 40px;overflow:hidden;white-space:nowrap;/*text-overflow:ellipsis;*/"--%>>
                    ${gtYwinfo.ywlsh}
            </td>
            <%--<td>
                    ${gtYwinfo.ywbh}
            </td>--%>
            <td>
                    ${gtYwinfo.ywmc}
            </td>
            <td>
                    ${gtYwinfo.grsbh}
            </td>
            <td>
                    ${gtYwinfo.sfzh}
            </td>
            <td>
                    ${gtYwinfo.xm}
            </td>
            <td>
                    <%--  ${ROWINFO.FQMC} --%> ${gtYwinfo.dwbh}

            </td>
            <td>
                    <%-- ${ROWINFO.BY20} --%>${gtYwinfo.dwmc}

            </td>
             <td>
                    ${gtYwinfo.slr}
            </td>
              <td>
                    ${gtYwinfo.shry.name}
            </td>
              <td>
                    ${gtYwinfo.fpr}
            </td>

            <td>
                    ${gtYwinfo.sbfs}
            </td>
            <td>
                    ${gtYwinfo.slqy}
            </td>

            <td><fmt:formatDate value="${gtYwinfo.cjdate}" type="both"/></td>
            <td>
                <c:if test="${gtYwinfo.synergy}">
                    是
                </c:if>
                <c:if test="${gtYwinfo.synergy==false}">
                    否
                </c:if>
            </td>
            <td>${fns:getDictLabel(gtYwinfo.lczt, 'lczt', '无')}</td>

         
            <td>
             <div class="btn-group">
                    <a href="${ctx}/gt/gtYwinfo/ywinfoBoShpage?ywlsh=${gtYwinfo.ywlsh}" class="btn btn-small">审核</a>
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
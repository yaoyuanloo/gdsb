<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>任务信息</title>
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
<sys:message content="${message}"/>
<div align="right">
    <input   class="btn btn-primary" onclick="javascript:window.location.href='${ctx}/gt/gtYwinfo/getywInfoListPer'"  type="button"    value="获取任务"/>
</div>
<form:form id="searchForm" modelAttribute="gtYwinfo" action="${ctx}/gt/gtYwinfo/ywInfoListPer" method="post" class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
</form:form>
<table id="contentTable" class="table table-striped table-bordered table-condensed" style="width: 100%;">
    <thead>
    <tr>
        <th>受理回执号</th>
        <th>业务流水号</th>
        <th>业务名称</th>
        <th>个人社保号</th>
        <th>个人身份证号</th>
        <th>姓名</th>
        <th>单位编号</th>
        <th>单位名称</th>

        <th>申报方式</th>
        <th>受理区域</th>
        <th>受理时间</th>
        <th>流程状态</th>

        <th style="width: 110px;">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="gtYwinfo">
        <tr class="followDetails" >
            <td  style="font-size: 16px;">
                    ${gtYwinfo.hzdh}
            </td>
            <td >
                    ${gtYwinfo.ywlsh}
            </td>

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


            <td>${fns:getDictLabel(gtYwinfo.sbfs.value, 'sb_type', '无')}</td>

            <td>
                    ${gtYwinfo.slqy}
            </td>
            <td><fmt:formatDate value="${gtYwinfo.cjdate}" type="both"/></td>
            <td><span  style="color: #00aa00"> 【${fns:getDictLabel(gtYwinfo.lczt, 'lczt', '无')}】</span></td>

         
            <td>
             <div class="btn-group">
                    <a href="${ctx}/gt/gtYwinfo/ywinfoShpage?ywlsh=${gtYwinfo.ywlsh}" class="btn btn-small">审核</a>
              </div>
                </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>
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
    </style>
    <script type="text/javascript">
        function selectlist() {
            var ywlsh = (chcekNumber()).json;
            //  console.log(ywlsh);
            var id=$("#userListId").val();

            if(ywlsh==""){
                top.$.jBox.tip("请勾选记录！");
                return;
            }
            if(id==""){
                top.$.jBox.tip("请选择业务员！");
                return;
            }


            var data = {
                id: id
            };
            for (var i in ywlsh) {
                data["maps['" + ywlsh[i].name + "']"] = ywlsh[i].value;
            }

            $.post(
                    '${ctx}/gt/gtYwinfo/toAssign',
                     data,
                     function (data) {
                        if (data) {
                            //showTip(response.msg);
                            top.$.jBox.tip("操作成功！");

                        }
                         location.href="${ctx}/gt/gtYwinfo/ywnoTask";

                    }
                    );

            function chcekNumber() {
                var js = new Array();
                var j = {};
                $("input[name='checkboxname']:checked").each(function () {
                    j = {"name": $(this).attr("value"), "value":""};
                    js.push(j);

                });
                console.log('js'+js);
                return {json: js};
            }


        }



    </script>
</head>
<body>
<sys:message content="${message}"/>
<td>
    <%-- <sys:treeselect id="jReviZe" name="primaryPerson.id" value="${office.primaryPerson.id}" labelName="office.primaryPerson.name" labelValue="${office.primaryPerson.name}"
      title="用户" url="/sys/office/treeData?type=3" allowClear="true" notAllowSelectParent="true"/> --%>


</td>

<div   style="width: 100%; height: 40px;margin-left:50%;">
    <form action="${ctx}/gt/gtYwinfo/toAssign">
    <span class="multiBoxLabel">请选择业务员</span>
    <sys:treeselect id="userList"  name="userList"
                    value=""
                    labelName=""
                    cssClass="input-small"
                    labelValue=""
                    title="一级审核员列表" url="/sys/office/treeDataUser?type=2"
                    allowClear="true" notAllowSelectParent="true"/>
    <input    class="btn btn-warning" type="button" data-toggle="tooltip"
             data-placement="right" style="margin-top:-8px;width:100px"  value="分配" onclick="selectlist()"/>

    <input   class="btn btn-warning" type="button" data-toggle="tooltip"
             data-placement="right" style="margin-top:-8px;width:100px"  value="自动分配" onclick="selectlist()"/>
    </form>

</div>

<table id="contentTable" class="table table-striped table-bordered table-condensed" style="width: 100%;">
    <thead>
    <tr>
        <th>选择</th>
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
            <td>
                <input type="checkbox" class="checkboxname"  name="checkboxname" value="${gtYwinfo.ywlsh}"/>
            </td>
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
            <td><span  style="color: #00aa00"> 【${fns:getDictLabel(gtYwinfo.lczt, 'lczt', '无')}】
                <c:if test="${!empty gtYwinfo.shry.name}">

                给${gtYwinfo.shry.name}
                 </c:if>
         </span></td>
            <td>
             <div class="btn-group">
                    <a href="${ctx}/gt/gtYwinfo/detail?ywlsh=${gtYwinfo.ywlsh}" class="btn btn-small">预览</a>
              </div>
                </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>
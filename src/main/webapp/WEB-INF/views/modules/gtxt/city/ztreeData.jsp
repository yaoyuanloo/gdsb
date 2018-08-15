<%--
  Created by IntelliJ IDEA.
  User: Coradisan
  Date: 2016/10/25 0025
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    $(document).ready(function () {
        getTreeData();
    });

    function getTreeData() {
//        console.log("getTreeData");
        var setting = {
            check: {
                enable: true,
                chkStyle: "checkbox"
            },
            data: {simpleData: {enable: true, idKey: "id", pIdKey: "pId", rootPId: '0'}},
            callback: {
                onClick: function (event, treeId, treeNode) {
//                    if (!treeNode.isParent) {
                    var id = treeNode.id == '0' ? '' : treeNode.id;
                    <%--if (changeBoo) {--%>
                    <%--confirmx("该业务还有未保存项，是否继续切转至其他业务？", function(){--%>
                    <%--$('#organizationContent').attr("src", "${ctx}/city/dYwinfo/ywsx?id=" + id);--%>
                    <%--});--%>
                    <%--} else {--%>
                    <!--$('#organizationContent').attr("src", "$ {ctx}/city/dYwinfo/ywsx?id=" + id);-->
//                    }

                    console.log(nodes);
                }
            }
        };
        $.getJSON("${ctx}/admin/sys/office/treeDataUser?type=2", function (data) {
            $.fn.zTree.init($("#mydatatree"), setting, data).expandAll(false);
        })
    }
</script>
<body>
<div align="center">
    <ul id="mydatatree" class="ztree">
    </ul>
</div>
</body>
</html>

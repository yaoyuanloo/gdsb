<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<!DOCTYPE html>
<%--<!--[if IE 8]> <!--<html lang="en" class="ie8 no-js">--> <![endif]-->--%>
<%--<!--[if IE 9]> <!--<html lang="en" class="ie9 no-js">--> <![endif]-->--%>
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
    <title>广东 | 机构与操作员管理</title>
    <meta name="decorator" content="yhdefault"/>
    <%--<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=Edge"/>--%>
    <%--<!-- Bootstrap -->--%>
    <%--<link rel="stylesheet" href="assets/plugins/bootstrap-3.3.5/css/bootstrap.min.css">--%>
    <%--<!-- Font Awesome Icons -->--%>
    <%--<link rel="stylesheet" href="assets/plugins/font-awesome-4.4.0/css/font-awesome.min.css"/>--%>
    <%--<!--插件样式-->--%>
    <%--<link rel="stylesheet" href="assets/plugins/ztree/css/zTreeStyle/zTreeStyle.css"/>--%>
    <%--<!--自定义样式-->--%>
    <%--<link rel="stylesheet" href="assets/css/style_gd.css"/>--%>
    <%--<link rel="stylesheet" href="assets/css/custom.css"/>--%>
    <%--<link rel="stylesheet" href="assets/css/color.css"/>--%>
    <%--<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->--%>
    <%--<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->--%>
    <%--<!--[if lt IE 9]>--%>
    <%--<script src="assets/js/html5shiv.min.js"></script>--%>
    <%--<script src="assets/js/respond.min.js"></script>--%>
    <%--<![endif]-->--%>
    <style>
        .close_tab{

        }
    </style>
</head>
<body class="skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Left side column. -->
    <section class="sub-sidebar">
        <ul id="mytree" class="ztree">
        </ul>
    </section>
    <!-- /.sidebar -->

    <!-- Content Wrapper. Contains page content -->

    <div class="content-wrapper">
        <!-- Main content -->
        <section class="col-lg-12 main_content">
            <div id="subtabs">
                <!-- Nav tabs -->
                <ul class="nav nav-tabs maintab" role="tablist">
                    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab"
                                                              data-toggle="tab">工作台</a></li>
                </ul>
                <!-- Tab panes -->
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="home">
                        <!-- box -->
                        <div class="box box-default">
                            <!-- box-header -->
                            <div class="box-header with-border">
                                <h3 class="box-title">
                                    <div class="dec_1"></div>
                                    参保登记申报
                                </h3>
                                <div class="box-tools pull-right">
                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                    </button>
                                </div>
                            </div>
                            <!-- box-body -->
                            <div class="box-body">
                                <form class="form-horizontal" name="myform" id="myform" method="post" action="">
                                    <div class="form-group">
                                        <label class="span2 control-label"><b class="mr5 red500">*</b>证件号码：</label>
                                        <div class="span4">
                                            <input type="text" placeholder="请输入证件号码" class="form-control" name=" "
                                                   id="idcard"/>
                                        </div>
                                        <label class="span2 control-label"><b class="mr5 red500">*</b>姓名：</label>
                                        <div class="span4">
                                            <input type="text" placeholder="请输入姓名" class="form-control" name=" "
                                                   id="name"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-offset-2 span10">
                                            <button type="submit" class="btn yellow">保存(S)</button>
                                            <button type="submit" class="btn gray">重置(R)</button>
                                            <button type="submit" class="btn yellow">确定</button>
                                            <button type="submit" class="btn gray">关闭</button>
                                            <button type="submit" class="btn darkgray">禁用</button>
                                        </div>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

</div>
<!-- ./wrapper -->
<!--   -->
<%--<script src="assets/js/jquery-1.12.3.min.js"></script>--%>
<%--<script src="assets/plugins/bootstrap-3.3.5/js/bootstrap.min.js"></script>--%>
<%--<!--自定义ztree打开tab-->--%>
<%--<script src="assets/plugins/ztree/js/jquery.ztree.all-3.5.js"></script>--%>
<%--<!--建伟定义ztree样式及打开tab-->--%>
<%--<!--<script src="assets/plugins/ztree/js/r_ztree-3.5.js"></script>--%>
<%--<script src="assets/plugins/ztree/js/r_ztree.exhide-3.5.min.js"></script>--%>
<%--<script src="assets/plugins/ztree/js/ztreesearch.js"></script>-->--%>

<%--<script src="assets/plugins/jquery-bootpag/jquery.bootpag.min.js"></script>--%>

<%--<script src="assets/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"></script>--%>
<%--<script src="assets/plugins/bootstrap-select-1.10.0/js/bootstrap-select.js"></script>--%>
<%--<script src="assets/plugins/bootstrap-select-1.10.0/js/i18n/defaults-zh_CN.min.js"></script>--%>
<%--<script src="assets/js/bootstrap-addtabs.js"></script>--%>
<%--<script src="assets/js/app.js"></script>--%>
<script type="text/javascript">
    <!--

    //    var setting = {
    //        /*
    //         check: {
    //         enable: true
    //         },*/
    //        callback: {
    //            //onClick: zTreeOnClick
    //            //,onNodeCreated: zTreeOnNodeCreated
    //        },
    //        data: {
    //            /*key: {
    //             url: "xUrl"
    //             }, */
    //            simpleData: {
    //                enable: true
    //            }
    //        },
    //        edit: {
    //            enable: false
    //        }
    //    };

    //    var zNodes =


    /*[
     {id: 1, pId: 0, name: "父节点1", open: true},
     {id: 11, pId: 1, name: "父节点11"},
     {id: 111, pId: 11, name: "叶子节点111", url: "form.html"},
     {id: 112, pId: 11, name: "叶子节点112"},
     {id: 113, pId: 11, name: "叶子节点113"},
     {id: 114, pId: 11, name: "叶子节点114"},
     {id: 12, pId: 1, name: "父节点12"},
     {id: 121, pId: 12, name: "叶子节点121"},
     {id: 122, pId: 12, name: "叶子节点122"},
     {id: 123, pId: 12, name: "叶子节点123"},
     {id: 124, pId: 12, name: "叶子节点124"},
     {id: 13, pId: 1, name: "父节点13", isParent: true},
     {id: 2, pId: 0, name: "父节点2"},
     {id: 21, pId: 2, name: "父节点21", open: true},
     {id: 211, pId: 21, name: "叶子节点211"},
     {id: 212, pId: 21, name: "叶子节点212"},
     {id: 213, pId: 21, name: "叶子节点213"},
     {id: 214, pId: 21, name: "叶子节点214"},
     {id: 22, pId: 2, name: "父节点22"},
     {id: 221, pId: 22, name: "叶子节点221"},
     {id: 222, pId: 22, name: "叶子节点222"},
     {id: 223, pId: 22, name: "叶子节点223"},
     {id: 224, pId: 22, name: "叶子节点224"},
     {id: 23, pId: 2, name: "父节点23"},
     {id: 231, pId: 23, name: "叶子节点231"},
     {id: 232, pId: 23, name: "叶子节点232"},
     {id: 233, pId: 23, name: "叶子节点233"},
     {id: 234, pId: 23, name: "叶子节点234"},
     {id: 3, pId: 0, name: "父节点3", isParent: true}
     ];*/
    /*
     function zTreeOnClick(event, treeId, treeNode) {
     //alert(treeNode.tId + ", " + treeNode.name);
     Addtabs.add({
     id: $(this).attr('data-addtab'),
     title: $(this).attr('name') ? $(this).attr('name') : $(this).html(),
     content: Addtabs.options.content ? Addtabs.options.content : $(this).attr('content'),
     url: $(this).attr('url'),
     ajax: $(this).attr('ajax') ? true : false
     })

     };

     function zTreeOnNodeCreated(event, treeId, treeNode) {
     alert(treeNode.tId + ", " + treeNode.name);
     $.fn.zTree.getZTreeObj("mytree").getSelectedNodes()[0].addtabs;
     };
     */

    $(document).ready(function () {
        getTreeData();//获取tree数据
//        $.fn.zTree.init($("#mytree"), setting, zNodes);
    });


    function getTreeData() {
        var setting = {
            data: {simpleData: {enable: true, idKey: "id", pIdKey: "pId", rootPId: '0'}},
            callback: {
                onClick: function (event, treeId, treeNode) {
                    console.log(treeNode);
                    if (!treeNode.isParent) {
//                        var changeBoo = window.frames["organizationContent"].changeBoo;
                        var id = treeNode.id == '0' ? '' : treeNode.id;
                        <%--if (changeBoo) {--%>
                        <%--confirmx("该业务还有未保存项，是否继续切转至其他业务？", function(){--%>
                        <%--$('#organizationContent').attr("src", "${ctx}/city/dYwinfo/ywsx?id=" + id);--%>
                        <%--});--%>
                        <%--} else {--%>
                        Addtabs.add({
                            id: id,
                            title: "定义 " + treeNode.name + " 业务属性",
                            url: '${ctx}/city/dYwinfo/ywsxn?id=' + id
//                            ajax: true
                        });
                        <!--$('#organizationContent').attr("src", "$ {ctx}/city/dYwinfo/ywsx?id=" + id);-->
                    }
                }
            }
        };
        $.getJSON("${ctx}/city/dYwinfo/treeDataCheck", function (data) {
            $.fn.zTree.init($("#mytree"), setting, data).expandAll(false);
        })
    }


    //点击菜单打开标签
    $("#subtabs").addtabs({
        monitor: ".ztree"
//参数
//  content string||html 直接指定内容
//  close bool 是否可以关闭，默认是true
//  monitor 监视的区域,默认是body
//  iframeUse true使用iframe，false使用ajax,默认true
//  iframeHeight 固定TAB中IFRAME高度
//  callback 关闭后回调函数
//
    });
    //
    //-->
</script>

</body>
</html>
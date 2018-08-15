<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>Title</title>
    <meta name="decorator" content="yhdefault"/>
</head>
<body>
<div class="">
    <!--行一-->
    <div class="row">
        <div class="span12">
            <!-- box -->
            <div class="box box-default">
                <!-- box-header -->
                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        个人基本资料
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    </div>
                </div>

                <!-- box-body -->
                <div class="box-body">
                    <form class="form-horizontal" name="myform" id="myform" method="post" action="">
                        <div class="form-group">
                            <label class="span1 control-label">电脑号：</label>
                            <div class="span2">
                                <input type="text" placeholder="请输入电脑号码" class="form-control" name="aac001" id="aac001"/>
                            </div>
                            <label class="span1 control-label">身份证号</label>
                            <div class="span2">
                                <input type="text" placeholder="请输入身份证号码" class="form-control" name="aac002" id="aac002"/>
                            </div>

                            <div class="span6 pull-right">
                                <button type="button" id="queryInfo" class="btn btn-sm yellow">查询(F)</button>
                                <button type="submit" class="btn btn-sm gray">重置(R)</button>
                            </div>
                            <hr class=dotline color=#111111 size=1>
                        </div>

                    </form>

                    <div class="form-horizontal">
                        <div class="form-group">
                            <label class="span1 control-label">姓名</label>
                            <div class="span2">
                                <input type="text" disabled class="form-control" name=" " id="aac003"/>
                            </div>
                            <label class="span1 control-label">证件号码</label>
                            <div class="span2">
                                <input type="text" disabled class="form-control" name=" " id="aac002"/>

                            </div>
                            <label class="span1 control-label">电脑号</label>
                            <div class="span2">
                                <input type="text" disabled class="form-control" name=" " id="aac001s"/>
                            </div>
                            <label class="span1 control-label">性别</label>
                            <div class="span2">
                                <input type="text" disabled class="form-control" name=" " id="aac004"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="span1 control-label">出生日期</label>
                            <div class="span2">
                                <input type="text" disabled class="form-control" name=" " id="aac006"/>
                            </div>
                            <label class="span1 control-label">参加工作日期</label>
                            <div class="span2">
                                <input type="text" disabled class="form-control" name=" " id="IDCD"/>

                            </div>
                            <label class="span1 control-label">电单位管理码</label>
                            <div class="span2">
                                <input type="text" disabled class="form-control" name=" " id="IDCD"/>
                            </div>
                            <label class="span1 control-label">其他人员类别</label>
                            <div class="span2">
                                <input type="text" disabled class="form-control" name=" " id="IDCD"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="span1 control-label">人员类别</label>
                            <div class="span2">
                                <input type="text" disabled class="form-control" name=" " id="idno"/>
                            </div>
                            <label class="span1 control-label">特殊人员类别</label>
                            <div class="span2">
                                <input type="text" disabled class="form-control" name=" " id="IDCD"/>

                            </div>
                            <label class="span1 control-label">单位名称</label>
                            <div class="span5">
                                <input type="text" disabled class="form-control" name=" " id="IDCD"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- box -->
            <div class="box box-default">

                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        异地申请信息
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                        </button>
                    </div>
                </div>
                <%--<!-- box-body -->--%>
                <div class="box-body">

                    <div class="form-horizontal">
                        <div class="form-group">
                            <label class="span1 control-label">异地申请受理号</label>
                            <div class="span2">
                                <input type="text" class="form-control" name=" " id="idno"/>
                            </div>
                            <label class="span1 control-label">处理状态</label>
                            <div class="span2">
                                <select name="show" class="form-control selectpicker">
                                    <option value="1">请选择</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                            <label class="span1 control-label">受理部门</label>
                            <div class="span2">
                                <select name="show" class="form-control selectpicker">
                                    <option value="1">请选择</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                            <label class="span1 control-label"><b class="mr5 red500">*</b>联系人关系</label>
                            <div class="span2">
                                <input type="text" class="form-control" name=" " id="IDCD"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="span1 control-label"><b class="mr5 red500">*</b>联系人</label>
                            <div class="span2">
                                <input type="text" class="form-control" name=" " id="idno"/>
                            </div>
                            <label class="span1 control-label"><b class="mr5 red500">*</b>联系电话</label>
                            <div class="span2">
                                <input type="text" class="form-control" name=" " id="idno"/>
                            </div>
                            <label class="span1 control-label"><b class="mr5 red500">*</b>联系地址</label>
                            <div class="span5">
                                <input type="text" class="form-control" name=" " id="idno"/>
                            </div>
                        </div>


                    </div>


                </div>

            </div>
            <!-- box -->
            <div class="box box-default">

                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        邮寄信息
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                        </button>
                    </div>
                </div>
                <%--<!-- box-body -->--%>
                <div class="box-body">

                    <div class="form-horizontal">
                        <div class="form-group">
                            <label class="span1 control-label">邮寄标志</label>
                            <div class="span2">
                                <select name="show" class="form-control selectpicker">
                                    <option value="1">请选择</option>
                                    <option value="0">...</option>
                                </select>
                            </div>

                        </div>


                    </div>

                </div>


            </div>
            <!-- box -->
            <div class="box box-default">

                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        异地就医信息
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                        </button>
                    </div>
                </div>

                <%--<!-- box-body -->--%>
                <div class="box-body">

                    <div class="form-horizontal">
                                    <div class="form-group">
                                        <label class="span2 control-label">省内异地就医申请</label>
                                        <div class="span2">
                                            <select name="show" class="form-control selectpicker">
                                                <option value="1">请选择</option>
                                                <option value="0">...</option>
                                            </select>
                                        </div>
                                        <label class="span2 control-label">异地就医待遇类型</label>
                                        <div class="span2">
                                            <select name="show" class="form-control selectpicker">
                                                <option value="1">请选择</option>
                                                <option value="0">...</option>
                                            </select>
                                        </div>
                                        <label class="span2 control-label">省内异地就医类别</label>
                                        <div class="span2">
                                            <select name="show" class="form-control selectpicker">
                                                <option value="1">请选择</option>
                                                <option value="0">...</option>
                                            </select>
                                        </div>
                                    </div>
                        <div class="form-group">
                                        <label class="span2 control-label">医疗保险类型</label>
                                        <div class="span2">
                                            <select name="show" class="form-control selectpicker">
                                                <option value="1">请选择</option>
                                                <option value="0">...</option>
                                            </select>
                                        </div>


                                    <label class="span2 control-label">异地类型</label>
                                    <div class="span6">
                                        <div class="checkbox-list">
                                            <label class="checkbox-inline">
                                                <input type="checkbox" id="inlineCheckbox21" value="option1">
                                                养老保险 </label>
                                            <label class="checkbox-inline">
                                                <input type="checkbox" id="inlineCheckbox22" value="option2">
                                                医疗保险 </label>
                                            <label class="checkbox-inline">
                                                <input type="checkbox" id="inlineCheckbox23" value="option3" disabled>
                                                大额医疗 </label>
                                            <label class="checkbox-inline">
                                                <input type="checkbox" id="inlineCheckbox22" value="option2">
                                                生育保险 </label>
                                            <label class="checkbox-inline">
                                                <input type="checkbox" id="inlineCheckbox22" value="option2">
                                                工伤保险 </label>
                                        </div>
                                    </div>
                        </div>
                    </div>

                </div>

            </div>


            <!-- box -->
            <div class="box box-default">

                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        异地申请安置地信息
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                        </button>
                    </div>
                </div>

                <%--<!-- box-body -->--%>
                <div class="box-body">

                    <div class="form-horizontal">
                        <div class="form-group">
                            <label class="span2 control-label">所属省、自治区或直辖</label>
                            <div class="span2">
                                <select name="show" class="form-control selectpicker">
                                    <option value="1">请选择</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                            <label class="span1 control-label">所属地级市</label>
                            <div class="span2">
                               <select name="show" class="form-control selectpicker">
                                    <option value="1">请选择</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                            <label class="span1 control-label">所属县或区</label>
                            <div class="span2">
                                <select name="show" class="form-control selectpicker">
                                    <option value="1">请选择</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                        </div>

                    </div>

                </div>
            </div>
                <%--<!-- end box -->--%>

                <!-- box -->
                <div class="box box-default">

                    <div class="box-header with-border">
                        <h3 class="box-title">
                            <div class="dec_1"></div>
                            异地选定医疗机构信息
                        </h3>
                        <div class="box-tools pull-right">
                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                            </button>
                        </div>
                    </div>

                    <%--<!-- box-body -->--%>
                    <div class="box-body">

                        <table class="table table-bordered table-striped table-hover tablesorter" id="dynamic_pager_content" data-resizable-columns-id="table2">
                            <thead>
                            <tr>
                                <th data-resizable-column-id="">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" id="select_all" value="option1"></label> </th>
                                <th data-resizable-column-id=""> 医药机构名称 </th>
                                <th data-resizable-column-id=""> 联系电话 </th>
                                <th data-resizable-column-id=""> 联系人 </th>
                                <th data-resizable-column-id=""> 邮编 </th>
                                <th data-resizable-column-id=""> 等级 </th>
                                <th data-resizable-column-id=""> 级别 </th>
                                <th data-resizable-column-id=""> 类型 </th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>


                            </tr>

                        </table>

                    </div>

                    </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>


<script>
        $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square_gd',
            radioClass: 'iradio_square_gd',
            increaseArea: '20%' // optional
        });
    });
</script>

<script>

    $(document).ready(function () {
        $("#queryInfo").click(function () {
            if ($("#aac001").val().trim() == "" && $("#aac002").val().trim() == "") {
                $("#aac001").focus();
                showTip("请输入社保电脑号或者个人身份证号进行查询", 'info', 2000, 0);
                twinkle("#aac001");
                twinkle("#aac002");
            } else {
                $.post("${ctx}/gtxtbusiness/medical/getPersInfo", {dnh: $("#aac001").val(),sfzh: $("#aac002").val()}, function (data) {
                    $("#aac001s").val(data.list[0].aac001)
                });
            }
        });
    });
</script>
<script>

    $(function () {
        //下拉选框
        $('.selectpicker').selectpicker({
            //style: 'btn-info',
            //size: 4
        });
        //日期插件
        $('.form_date').datetimepicker({
            language: 'zh-CN',
            format: "yyyy mm dd",
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
        //
        //end
    });

    //-->
</script>


</body>

</html>

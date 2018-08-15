<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>快捷业务-档案归还-受理</title>
    <meta name="decorator" content="yhdefault"/>
</head>
<body>
<!--页面主体-->
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
                        档案归还信息
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    </div>
                </div>
                <!-- box-body -->
                <div class="box-body">
                    <form class="form-horizontal" name="myform" id="myform" method="post" action="">
                        <div class="form-group">
                            <label class="span2 control-label"><b class="mr5 red500">*</b>档案编号：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入档案编号" class="form-control" name="bec085"
                                       id="bec085"/>
                            </div>
                            <label class="span2 control-label">借阅人身份证号：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入借阅人身份证号" class="form-control" name="aac002"
                                       id="aac002"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="span2 control-label">借阅人姓名：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入借阅人姓名" class="form-control" name="aac003"
                                       id="aac003"/>
                            </div>
                            <label class="span2 control-label">借阅人工作证号：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入借阅人工作证号" class="form-control" name="bec063"
                                       id="bec063"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="span2 control-label">借档日期：</label>
                            <div class="span4">
                                <div class="input-group date form_date" data-date="" data-link-field="bee015"
                                     data-link-format="yyyy-mm-dd">
                                    <input class="form-control" readonly="readonly" id="bee015" name="bee015" placeholder="请输入借档日期" size="18" type="text" >
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                                <input type="hidden" id="bee015" value=""/>
                            </div>
                            <label class="span2 control-label">借阅人单位名称：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入借阅人单位名称" class="form-control" name="aab004"
                                       id="aab004"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="span2 control-label">借档经办人：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入借档经办人" class="form-control" name="bee018"
                                       id="bee018"/>
                            </div>
                            <label class="span2 control-label">档案名称：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入档案名称" class="form-control" name="bec089"
                                       id="bec089"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="span2 control-label">借阅ID：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入借阅ID" class="form-control" name="bec095"
                                       id="bec095"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 span10">
                                <button type="button" id="fileQuery" class="btn yellow">查询(S)</button>
                                <button type="submit" class="btn gray" id="resetButton">重置(R)</button>
                                <%--<button type="submit" class="btn yellow">确定</button>--%>
                                <%--<button type="submit" class="btn gray">关闭</button>--%>
                                <%--<button type="submit" class="btn darkgray">禁用</button>--%>
                            </div>
                        </div>

                    </form>
                </div>
            </div>

        </div>
    </div>
    <!--行一./-->
</div>
<!-- custom-->
<script>
    <!--
    $(function () {
        //下拉选框
//        $('.selectpicker').selectpicker({
//            //style: 'btn-info',
//            //size: 4
//        });
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

<script>
    //bootstrapValidator 使用须知：
    //要验证一个表单项，则该表单项必须有name属性，则验证将不起作用
    //为保持良好的效果，表单元素最好放在div.form-group里面
    //bootstrapvalidator已经对重复提交做了设计，如果一个表单需要经过bootstrapvalidator验证，点击提交按钮的时候，提交按钮会置灰，直到服务器返回响应。如果一个表单不需要验证，可以给表单一个class,如validation-form，在js主函数里面调用$("form.validation-form").bootstrapValidator();将验证器置空即可。
    //提示信息可以整合在tooltip容器内显示，如下
    $(document).ready(function () {
        $('#myform')
                .bootstrapValidator({
                    container: 'tooltip',
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    fields: {
                    	bec085: {
						    validators: {
						        notEmpty: {
						            message: '档案编号不能为空!'
						        }
						    }
						}
                    }
                })
                .on('error.field.bv', function (e, data) {
                    // Get the tooltip
                    var $parent = data.element.parents('.form-group'),
                            $icon = $parent.find('.form-control-feedback[data-bv-icon-for="' + data.field + '"]'),
                            title = $icon.data('bs.tooltip').getTitle();

                    // Destroy the old tooltip and create a new one positioned to the right
                    $icon.tooltip('destroy').tooltip({
                        html: true,
                        placement: 'bottom',
                        title: title,
                        container: 'body'
                    });

                });

        // Reset the Tooltip container form
        $('#resetButton').on('click', function (e) {
            var fields = $('#myform').data('bootstrapValidator').getOptions().fields,
                    $parent, $icon;

            for (var field in fields) {
                $parent = $('[name="' + field + '"]').parents('.form-group');
                $icon = $parent.find('.form-control-feedback[data-bv-icon-for="' + field + '"]');
                $icon.tooltip('destroy');
            }

            // Then reset the form
            $('#myform').data('bootstrapValidator').resetForm(true);
        });
        $("#fileQuery").click(function () {
            if ($("#bec085").val() == "") {
            	alert("请输入档案编号进行查询!");
                showTip("请输入档案编号进行查询", 'info', 2000, 0);
            }else{
           	    $.post("${ctx}/wx/WXCompany/returnedfile", {bec085: $("#bec085").val()}, function (data) {
           	    $("#aab004").val(data["aab004"]);
           	    $("#aac002").val(data["aac002"]);
           	    $("#aac003").val(data["aac003"]);
           	    $("#bec063").val(data["bec063"]);
           	    $("#bee015").val(data["bee015"]);
           	    $("#bee018").val(data["bee018"]);
        	    $("#bec089").val(data["bec089"]);
           	    $("#bec095").val(data["bec095"]);
           	    return false;
            }); 
         }
   	  });
    });
</script>
</body>
</html>

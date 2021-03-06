<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>快捷业务-档案转入受理登记-受理</title>
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
                        档案转入受理登记
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    </div>
                </div>
                <!-- box-body -->
                <div class="box-body">
                    <form class="form-horizontal" name="myform" id="myform" method="post" action="">

                        <div class="form-group">
                            <label class="span2 control-label"><b class="mr5 red500">*</b>档案类别：</label>
                            <div class="span4">
                                <select name="bec081" id="bec081" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                </select>
                            </div>
                            <label class="span2 control-label">原档案编号：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入原档案编号" class="form-control" name="bec090"
                                       id="bec090"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="span2 control-label">姓名：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入姓名" class="form-control" name="aac003" id="aac003"/>
                            </div>
                            <label class="span2 control-label">身份证号：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入身份证号" class="form-control" name="aac002"
                                       id="aac002"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="span2 control-label">是否缺失材料：</label>
                            <div class="span4">
                                <select name="bec083" id="bec083" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                </select>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="span2 control-label">备注：</label>
                            <div class="span10">
                                <input type="text" placeholder="请输入备注" class="form-control" name="bee003" id="bee003"/>
                            </div>
                        </div>
                        
						

                        <div class="form-group">
                            <div class="col-sm-offset-2 span10">
                                <button type="submit" class="btn yellow">保存(S)</button>
                                <button type="submit" class="btn gray" id="resetButton">重置(R)</button>
                            </div>
                        </div>
						<table class="table table-bordered table-striped table-hover" id="dynamic_pager_content">
				              <thead>
				                <tr>
				                  <th>序号选择 </th>
				                  <th>选择 </th>
				                  <th>材料代码 </th>
				                  <th>机构代码 </th>
				                </tr>
				              </thead>
				              <tbody>
				                <tr>
				                  <td>1</td>
				                  <td>
                                      <input type="checkbox">
                                  </td>
				                  <td>广东深圳</td>
				                  <td>111</td>
				                </tr>
				              </tbody>
            			</table>
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
                        name: {
                            //selector: '#name',
                            validators: {
                                notEmpty: {
                                    message: '姓名不能为空'
                                },
                                regexp: {
                                    regexp: /^[\u4E00-\u9FA5]{2,10}$/,
                                    message: '姓名不是中文或姓名长度有误'
                                }
                            }
                        },
                        idcard: {
                            //selector: '#idcard',
                            validators: {
                                notEmpty: {
                                    message: '身份证号码不能为空'
                                },
                                regexp: {
                                    regexp: /(^\d{15}$)|(^\d{17}([0-9]|X|x)$)/,
                                    message: '身份证号码不正确'
                                }
                            }
                        },
                        phone: {
                            //selector: '#phone',
                            validators: {
                                digits: {
                                    message: '手机号只能为数字'
                                },
                                notEmpty: {
                                    message: '手机号不能为空'
                                }
                            }
                        },
                        /*validatecode: {
                         //selector: '#validatecode',
                         validators: {
                         notEmpty: {
                         message: '验证码不能为空'
                         },
                         regexp: {
                         regexp: /^\d{6}$/,
                         message: '验证码格式不正确'
                         }
                         }
                         },*/
                        content: {
                            //selector: '#content',
                            validators: {
                                notEmpty: {
                                    message: '内容不能为空'
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
    });
</script>
</body>
</html>

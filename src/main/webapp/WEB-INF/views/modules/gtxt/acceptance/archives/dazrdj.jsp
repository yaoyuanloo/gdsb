<%--
  Created by IntelliJ IDEA.
  User: cxdwe
  Date: 2016/10/13
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>Title</title>
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
                        	个人基本信息
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    </div>
                </div>
                <!-- box-body -->
                <div class="box-body">
                    <form class="form-horizontal" name="myform" id="myform" method="post" action="">
                        <div class="form-group">
                            <label class="span2 control-label"><b class="mr5 red500">*</b>证件类型：</label>
                            <div class="span4">
                                <select name="credentialsType" class="form-control selectpicker">
                                    <option value="1">居民身份证（户口簿）</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                             <label class="span2 control-label"><b class="mr5 red500">*</b>身份证号码：</label>
                             <div class="span4">
                                 <input type="text" placeholder="请输入证件号码" class="form-control" name="idcard" id=""/>
                             </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="span2 control-label"><b class="mr5 red500">*</b>姓名：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入姓名" class="form-control" name="name"/>
                            </div>
                            
                            
                             <label class="span2 control-label"><b class="mr5 red500">*</b>性别：</label>
                             <div class="span4">
                                <select name="sex" class="form-control selectpicker">
                                    <option value="1">男</option>
                                    <option value="0">女</option>
                                </select>
                            </div>
                        </div>

                       

                        <div class="form-group">
                           	 <label class="span2 control-label"><b class="mr5 red500">*</b>出生日期：</label>
                             <div class="span4">
                                <div class="input-group date form_date" data-date="" data-link-field="borndate"
                                     data-link-format="yyyy-mm-dd">
                                    <input class="form-control" name="dateofbirth" readonly="readonly" placeholder="请选择出生日期" size="18" type="text" value="">
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                                <input type="hidden" id="borndate" value=""/>
                            </div>
                            <label class="span2 control-label"><b class="mr5 red500">*</b>民族：</label>
                            <div class="span4">
                                <select name="minorities" class="form-control selectpicker">
                                    <option value="1">汉族</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                           <label class="span2 control-label"><b class="mr5 red500">*</b>国家或地区：</label>
                            <div class="span4">
                                <select name="locality" class="form-control selectpicker">
                                    <option value="1">中国China</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                            <label class="span2 control-label"><b class="mr5 red500">*</b>证件号码：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入证件号码" class="form-control" name="idcardtype"/>
                            </div>
                        </div>

                        <div class="form-group">
                          
                            <label class="span2 control-label"><b class="mr5 red500">*</b>户籍性质：</label>
                            <div class="span4">
                                <select name="registryNature" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                            
                            <label class="span2 control-label"><b class="mr5 red500">*</b>政治面貌：</label>
                            <div class="span4">
                                <select name="politics" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                          
                            <label class="span2 control-label"><b class="mr5 red500">*</b>婚姻状况：</label>
                            <div class="span4">
                                <select name="married" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                            
                            <label class="span2 control-label"><b class="mr5 red500">*</b>健康状况：</label>
                            <div class="span4">
                                <select name="goodHealth" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                        </div>

                       <div class="form-group">
                             <label class="span2 control-label"><b class="mr5 red500">*</b>参加工作日期：</label>
                             <div class="span4">
                                <div class="input-group date form_date"  data-date="" data-link-field="borndate"
                                     data-link-format="yyyy-mm-dd">
                                    <input class="form-control" placeholder="请选择参加工作日期" readonly="readonly" name="workingHours" size="18" type="text" value="">
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                                <input type="hidden" id="borndate" value=""/>
                            </div>
                            
                            <label class="span2 control-label"><b class="mr5 red500">*</b>文化程度：</label>
                            <div class="span4">
                                <select name="half-educated " class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                            
                        </div>
                        
                        
                       <div class="form-group">
                            <label class="span2 control-label"><b class="mr5 red500">*</b>工作单位名称：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入工作单位名称" class="form-control" name="workUnitName"/>
                            </div>
                            <label class="span2 control-label"><b class="mr5 red500">*</b>工作单位类型：</label>
                            <div class="span4">
                                <select name="workUnitType" class="form-control selectpicker">
                                    <option value="1">请您选择</option>
                                </select>
                            </div>
                        </div>
                        
                        
                        <div class="form-group">
                            <label class="span2 control-label"><b class="mr5 red500">*</b>工作单位所属行业：</label>
                            <div class="span4">
                                <select name="workUnitHy" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                            
                            <label class="span2 control-label"><b class="mr5 red500">*</b>工作单位经济类型：</label>
                            <div class="span4">
                                <select name="workUnitJj" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                        </div>
                        
                        
                        <div class="form-group">
                            <label class="span2 control-label"><b class="mr5 red500">*</b>工作地点行政区别：</label>
                            <div class="span4">
                                <select name="workqb" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                            
                            <label class="span2 control-label">工作职位(岗位)类型：</label>
                            <div class="span4">
                                <select name="workzw" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                        </div>
                        
                         <div class="form-group">
                            <label class="span2 control-label"><b class="mr5 red500">*</b>户籍行政区划：</label>
                            <div class="span4">
                                <select name="registryqb" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                            
                            <label class="span2 control-label"><b class="mr5 red500">*</b>户籍地地址：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入户籍地址" class="form-control" name="registryadder"/>
                            </div>
                        </div>
                        
                        
                        
                         <div class="form-group">
                         
                         	<label class="span2 control-label"><b class="mr5 red500">*</b>现居住地址：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入现居住地址" class="form-control" name="xadder"/>
                            </div>
                            <label class="span2 control-label"><b class="mr5 red500">*</b>现居住地址行政区划：</label>
                            <div class="span4">
                                <select name="xzzadder" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="span2 control-label">固定电话：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入固定电话" class="form-control" name="fixedPhones."/>
                            </div>
                            <label class="span2 control-label"><b class="mr5 red500">*</b>手机号码：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入手机号码" class="form-control" name="cellPhone "/>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="span2 control-label">工作证号：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入工作证号" class="form-control" name="WorkPermitNo"/>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        	档案转入信息
                    </h3>
                   <!--  <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    </div> -->
                </div>
                
                
                <div class="box-body">
                    <form class="form-horizontal" name="myform" id="myform" method="post" action="">
                        <div class="form-group">
                        	<label class="span2 control-label"><b class="mr5 red500">*</b>存档编号：</label>
                            <div class="span4">
                                <input type="text" placeholder="请输入存档编号" class="form-control" name="idcard" id=""/>
                            </div>
                        
                            <label class="span2 control-label"><b class="mr5 red500">*</b>存档类别：</label>
                            <div class="span4">
                                <select name="show" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                        </div>
                        
                        <div class="form-group">
                        	<label class="span2 control-label"><b class="mr5 red500">*</b>存档状态：</label>
                            <div class="span4">
                                <select name="show" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                            <label class="span2 control-label"><b class="mr5 red500">*</b>存档性质：</label>
                            <div class="span4">
                                <select name="show" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                        </div>
                        
                        <div class="form-group">
                        	<label class="span2 control-label"><b class="mr5 red500">*</b>是否有党员资料：</label>
                            <div class="span4">
                                <select name="show" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                            <label class="span2 control-label"><b class="mr5 red500">*</b>现档案管理机构单位名称：</label>
                            <div class="span4">
                                <select name="show" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                        </div>
                        
                        
                        <div class="form-group">
                        
                        	<label class="span2 control-label"><b class="mr5 red500"></b>转入日期：</label>
                             <div class="span4">
                                <div class="input-group date form_date" data-date="" data-link-field="borndate"
                                     data-link-format="yyyy-mm-dd">
                                    <input class="form-control" readonly="readonly" placeholder="请选择转入日期" size="18" type="text" value="">
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                                <input type="hidden" id="borndate" value=""/>
                            </div>
                        
                        	<label class="span2 control-label"><b class="mr5 red500">*</b>原存档编号：</label>
                            <div class="span4">
                                <select name="show" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                        </div>
                        
                        
                        <!-- <div class="form-group">
                        	<label class="span2 control-label"><b class="mr5 red500">*</b>原存档编号：</label>
                            <div class="span4">
                                <select name="show" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                           <label class="span2 control-label"><b class="mr5 red500"></b>转入日期：</label>
                             <div class="span4">
                                <div class="input-group date form_date" data-date="" data-link-field="borndate"
                                     data-link-format="yyyy-mm-dd">
                                    <input class="form-control" placeholder="请选择转入日期" size="18" type="text" value="">
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                                <input type="hidden" id="borndate" value=""/>
                            </div>
                        </div> -->
                        
                        
                         <div class="form-group">
                        	<label class="span2 control-label"><b class="mr5 red500">*</b>转入原因：</label>
                            <div class="span4">
                                <select name="show" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                            <label class="span2 control-label"><b class="mr5 red500">*</b>原存档单位名称：</label>
                            <div class="span4">
                                <select name="show" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                        </div>
                        
                        
                        <div class="form-group">
                        	<label class="span2 control-label"><b class="mr5 red500"></b>转出日期：</label>
                            <div class="span4">
                                <div class="input-group date form_date" data-date="" data-link-field="borndate"
                                     data-link-format="yyyy-mm-dd">
                                    <input class="form-control" readonly="readonly" placeholder="请选择转出日期" name="workingHours" size="18" type="text" value="">
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                                <input type="hidden" id="borndate" value=""/>
                            </div>
                        
                        	<label class="span2 control-label"><b class="mr5 red500"></b>原存档单位行政区划：</label>
                            <div class="span4">
                                <select name="show" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                           
                        </div>
                        
                        
                        <div class="form-group">
                        	<label class="span2 control-label"><b class="mr5 red500">*</b>转出原因：</label>
                            <div class="span4">
                                <select name="show" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                            <label class="span2 control-label"><b class="mr5 red500">*</b>转出单位名称：</label>
                            <div class="span4">
                               <input type="text" placeholder="请输入转出单位名称" class="form-control" name="idcard" id=""/>
                            </div>
                        </div>
                        
                        
                         <div class="form-group">
                        	<label class="span2 control-label">转往单位行政区划：</label>
                            <div class="span4">
                                <select name="show" class="form-control selectpicker">
                                    <option value="1">请您选择...</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                        </div>
                        
                        
                         <div class="form-group">
                            <label class="span2 control-label">转入备注：</label>
                            <div class="span10">
                                <textarea rows="1" class="form-control tip" name="content" id="content"
                                          placeholder="请输入转入备注,最多输入500字"></textarea>
                            </div>
                        </div>
                         <div class="form-group">
                            <label class="span2 control-label">转出备注：</label>
                            <div class="span10">
                                <textarea rows="1" class="form-control tip" name="content" id="content"
                                          placeholder="请输入转出备注,最多输入500字"></textarea>
                            </div>
                        </div>
                        
                         <div class="form-group">
                            <div class="col-sm-offset-2 span10">
                                <button type="submit" class="btn yellow">保存(S)</button>
                                <button type="submit" class="btn gray" id="resetButton">重置(R)</button>
                                <button type="submit" class="btn yellow">确定</button>
                                <button type="submit" class="btn gray">关闭</button>
                                <button type="submit" class="btn darkgray">禁用</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            
            
           <!--  <div class="box box-default">
                box-header
                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        	档案转入信息
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    </div>
                </div>

        	</div> -->
    </div>
    <!--行一./-->
</div>
</div>
<!-- custom-->
<script>
    <!--
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
                           // selector: '#idcard',
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
                        
                        
                        idcardtype: {
                            //selector: '#idcardtype',
                            validators: {
                                notEmpty: {
                                    message: '证件号码不能为空'
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

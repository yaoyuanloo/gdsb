<%--
  Created by IntelliJ IDEA.
  User: cxd
  Date: 2016/11/3 0003
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>单位信息维护</title>
    <meta name="decorator" content="yhdefault"/>
</head>
<body>
<div class="row">
    <div class="span12">
        <div class="form-horizontal" name="infoForm" method="post" action="">
            <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        信息查询
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse">
                            <i class="fa fa-minus"></i>
                        </button>
                    </div>
                </div>
                <div class="box-body">
                    <form class="form-horizontal" name="myform" method="post" action="">
                        <div class="form-group">
                            <label class="span1 control-label">组织机构代码</label>
                            <div class="span2">
                                <input type="text" placeholder="" class="form-control" name="aac002"/>
                            </div>
                            <label class="span1 control-label">法人身份证号</label>
                            <div class="span2">
                                <input type="text" placeholder="" class="form-control" name="aac002"/>
                            </div>
                            <div class="pull-right">
                                <button type="button" class="btn btn-sm yellow">查询(F)</button>
                                <button type="button" class="btn btn-sm gray">保存</button>
                                <button type="submit" class="btn btn-sm gray">重置(R)</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="span1 control-label">组织机构代码</label>
                            <div class="span2">
                                <input type="text" placeholder="" class="form-control" name="aac002"
                                       readonly/>
                            </div>
                            <label class="span1 control-label">单位名称</label>
                            <div class="span2">
                                <input type="text" placeholder="" class="form-control" name="aac002"
                                       readonly/>
                            </div>
                            <label class="span1 control-label">单位地址</label>
                            <div class="span2">
                                <input type="text" placeholder="" class="form-control" name="aac002"
                                       readonly/>
                            </div>
                            <label class="span1 control-label">单位状态</label>
                            <div class="span2">
                                <input type="text" placeholder="" class="form-control" name="aac002"
                                       readonly/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        单位基本信息
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                        </button>
                    </div>
                </div>
                <div class="box-body">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label class="span1 control-label">档案类型</label>
                            <div class="span2">
                                <input type="text" placeholder="" class="form-control" name="name"/>
                            </div>
                            <label class="span1 control-label">操作人</label>
                            <div class="span2">
                                <input type="text" placeholder="" class="form-control" name="name"/>
                            </div>
                            <label class="span1 control-label">操作时间</label>
                            <div class="span2">
                                <input type="text" placeholder="" class="form-control" name="name"/>
                            </div>
                            <label class="span1 control-label">管理部门</label>
                            <div class="span2">
                                <input type="text" placeholder="" class="form-control" name="name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="span1 control-label">备注</label>
                            <div class="span11">
                                <textarea rows="2" class="form-control tip" name="content"
                                          placeholder="最多输入500字"/></textarea>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        受理意见
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    </div>
                </div>
                <div class="box-body">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label class="span1 control-label">意见</label>
                            <div class="span11">
                                <textarea rows="2" class="form-control tip" name="content" id="content"
                                          placeholder="最多输入500字"/></textarea>
                            </div>
                        </div>
                    </div>
                    <ul id="myTab" class="nav nav-tabs">
                        <li class="active"><a href="#YWCL" data-toggle="tab">业务所需材料</a></li>
                        <li><a href="#CZYD" data-toggle="tab">常住异地</a></li>
                    </ul>
                    <div id="myTabContent" class="tab-content">
                        <div class="tab-pane active" id="YWCL">
                            <div>
                                业务材料
                            </div>
                        </div>
                        <div class="tab-pane" id="CZYD">
                            <div>
                                常住异地
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<form id="submitForm" action="${ctx}/gtxt/accept/medical/save" method="post" style="margin: 0; border: 0;">
    <input type="hidden" id="jsoninfo" name="jsoninfo"/>
    <input type="hidden" id="ywid" name="ywid" value="${ywinfo.id}"/>
    <input type="hidden" id="flowcode" name="flowcode" value="${ywatter.flowcode.value}"/>
    <input type="hidden" id="shjbcode" name="shjbcode" value="${ywatter.shjbcode.value}"/>

    <input type="hidden" id="grsbh" name="grsbh" class="sino" value=""/>
    <input type="hidden" id="sfzh" name="sfzh" class="idno" value=""/>
    <input type="hidden" id="ywbh" name="ywbh" value="${ywinfo.pywinfo.code}"/>
    <input type="hidden" id="ywmc" name="ywmc" value="${ywinfo.pywinfo.name}"/>
    <input type="hidden" id="xm" name="xm" class="peosonname" value=""/>
    <input type="hidden" id="dwbh" name="dwbh" class="dwbh" value=""/>
    <input type="hidden" id="dwmc" name="dwmc" class="dwmc" value=""/>
</form>

<script>
    function tingbao() {
        alert("确认停保！");
    }
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square_gd',
            radioClass: 'iradio_square_gd',
            increaseArea: '20%' // optional
        });
    });
    $('.form_date').datetimepicker({
        language: 'zh-CN',
        format: "yyyy-mm-dd",
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
    $('.selectpicker').selectpicker({
        //style: 'btn-info',
        //size: 4
    });

    customDropDown.prototype = {
        initEvents: function () {
            var obj = this;
            obj.options.on("click", function () {
                var opt = $(this);
                obj.text = opt.find("a").text();
                obj.val = opt.attr("value");
                obj.index = opt.index();
                obj.placeholder.text(obj.text);
            });
        },
        getText: function () {
            return this.text;
        },
        getValue: function () {
            return this.val;
        },
        getIndex: function () {
            return this.index;
        }
    };
    $(function () {
        var mydropdown1 = new customDropDown($("#dropdown_to_select"));
        $('#page_selection').bootpag({
            total: 10,
            page: 1,
            maxVisible: 5,
            leaps: true,
            firstLastUse: true,
            first: '首页',
            last: '末页',
            prev: '<i class="glyphicon glyphicon-chevron-left"></i>',
            next: '<i class="glyphicon glyphicon-chevron-right"></i>',
            wrapClass: 'pagination pagination-sm',
            activeClass: 'active',
            disabledClass: 'disabled',
            nextClass: 'next',
            prevClass: 'prev',
            lastClass: 'last',
            firstClass: 'first'
        }).on('page', function (event, num) {
            $("#dynamic_pager_content").html("Page " + num + " content here"); // or some ajax content loading...
        });
    });
    $(document).ready(function () {
        $('input:radio[name="first"]').change(function () {
            if ($(this).val() == 1) {
                $("#yuanyin").fadeIn('fast');
            } else if ($(this).val() == 2) {
                $("#yuanyin").fadeOut('fast');
            }
        });
        $('input:radio[name="pay"]').change(function () {
            if ($(this).val() == 1) {
                $(".end").find("option[text='0']").attr("selected", true);
            } else if ($(this).val() == 2) {
                $("#end").val("1");
            }
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
            $('#myform').data('bootstrapValidator').resetForm(true);
        });
    });
    $("#sqr").change(function () {
        if ($(this).val() == 0) {
            $("#daibanren").fadeIn('fast');
        } else
            $("#daibanren").fadeOut('fast');
    });
</script>
</body>
</html>

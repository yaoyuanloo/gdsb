<%--
  Created by IntelliJ IDEA.
  User: cxd
  Date: 2016/11/3 0003
  Time: 15:34
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
                        养老待遇核定
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    </div>
                </div>
                <!-- box-body -->
                <div class="box-body">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label class="span1 control-label">电脑号</label>
                            <div class="span2">
                                <input type="text" placeholder="请输入电脑号" class="form-control" name="idcard"/>
                            </div>
                            <label class="span1 control-label">身份证号</label>
                            <div class="span2">
                                <input type="text" placeholder="请输身份证号" class="form-control" name="name"/>
                            </div>
                            <label class="span1 control-label">社保卡号</label>
                            <div class="span2">
                                <input type="text" placeholder="请输入社保卡号" class="form-control" name="name"/>
                            </div>
                            <form name="myform" id="myform" method="post" action="">
                                <div class="pull-right">
                                    <button type="button" onclick="search();" class="btn btn-sm yellow">查询(F)</button>
                                    <button type="button" class="btn btn-sm yellow">保存(S)</button>
                                    <button type="button" class="btn btn-sm gray">重置(R)</button>
                                </div>
                            </form>
                        </div>
                        <div class="form-group">
                            <label class="span1 control-label">姓名</label>
                            <div class="span2">
                                <input type="text" class="form-control" name="name" readonly="readonly"/>
                            </div>
                            <label class="span1 control-label">户籍</label>
                            <div class="span8">
                                <input type="text" class="form-control" name="name" readonly="readonly"/>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

            <div class="box box-default">
                <!-- box-header -->
                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        申请人信息
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    </div>
                </div>
                <div class="box-body">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <%--<label class="span1 control-label"></label>--%>
                            <div class="span3">
                                <center>
                                <div class="radio-list">
                                    <label class="radio-inline">
                                        <input type="radio" name="optionsRadios" onclick="" id="optionsRadios22"
                                               value="option1"/>
                                        <label>本人申请</label>
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="optionsRadios" onclick="sfinfo('')"
                                               id="optionsRadios23" value="option2"/>
                                        <label>他人代办</label>
                                    </label>
                                </div>
                                </center>
                            </div>
                            <label class="span1 control-label">申请人姓名</label>
                            <div class="span2">
                                <input type="text" placeholder="请输入申请人姓名" class="form-control" name="name"/>
                            </div>
                            <label class="span1 control-label">申请人电话</label>
                            <div class="span2">
                                <input type="text" placeholder="申请人联系电话" class="form-control" name="name"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- box -->
            <div class="box box-default">
                <!-- box-header -->
                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        受理信息
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    </div>
                </div>
                <!-- box-body -->
                <div class="box-body">
                    <div class="form-horizontal">


                        <div class="form-group">
                            <label class="span1 control-label">离退休类别</label>
                            <div class="span2">
                                <select name="show" class="form-control selectpicker">
                                    <option value="0">111</option>
                                    <option value="1">...</option>
                                </select>
                            </div>
                            <label class="span1 control-label">户籍地</label>
                            <div class="span2">
                                <select name="show" class="form-control selectpicker">
                                    <option value="0">111</option>
                                    <option value="1">...</option>
                                </select>
                            </div>
                            <label class="span1 control-label">居住地</label>
                            <div class="span2">
                                <select name="show" class="form-control selectpicker">
                                    <option value="0">111</option>
                                    <option value="1">...</option>
                                </select>
                            </div>
                            <label class="span1 control-label">收职工档案</label>
                            <div class="span2">
                                <select name="show" class="form-control selectpicker">
                                    <option value="0">否</option>
                                    <option value="1">...</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="span1 control-label">选择银行</label>
                            <div class="input-group span2">
                                <input type="text" name="q" class="form-control"
                                       placeholder="请选择选择银行"/>
                                <span class="input-group-btn">
                              <button type='submit' name='search' id='search-btn' class="btn btn-flat">
                                  <i class="fa fa-search"></i>
                              </button>
                            </span>
                            </div>
                            <label class="span1 control-label">开户户名</label>
                            <div class="span2">
                                <input type="text" placeholder="" class="form-control" name="name"/>
                            </div>
                            <label class="span1 control-label">银行账号</label>
                            <div class="span2">
                                <input type="text" placeholder="" class="form-control" name="name"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="span1 control-label">通讯地址</label>
                            <div class="input-group span2">
                                <input type="text" name="q" class="form-control"
                                       placeholder="省"/>
                                <span class="input-group-btn">
                              <button type='submit' name='search' class="btn btn-flat">
                                <i class="fa fa-search"></i></button>
                            </span>
                            </div>
                            <label class="span1 control-label">市级</label>
                            <div class="input-group span2">
                                <input type="text" name="q" class="form-control"
                                       placeholder="市"/>
                                <span class="input-group-btn">
                              <button type='submit' name='search' class="btn btn-flat">
                                <i class="fa fa-search"></i></button>
                            </span>
                            </div>
                            <label class="span1 control-label">县(区)</label>
                            <div class="input-group span2">
                                <input type="text" name="q" class="form-control"
                                       placeholder="县(区)"/>
                                <span class="input-group-btn">
                              <button type='submit' name='search' class="btn btn-flat">
                                <i class="fa fa-search"></i></button>
                            </span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="span1 control-label">街道</label>
                            <div class="span8">
                                <input type="text" placeholder="请输入街道" class="form-control" name="name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="span1 control-label">备注</label>
                            <div class="span11">
                            <textarea rows="2" class="form-control tip" name="content" id="content"
                                      placeholder="最多输入500字"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- box -->
<div class="box box-default">
    <!-- box-header -->
    <div class="box-header with-border">
        <h3 class="box-title">
            <div class="dec_1"></div>
            受理意见
        </h3>
        <div class="box-tools pull-right">
            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
        </div>
    </div>
    <!-- box-body -->
    <div class="box-body">
        <div class="form-horizontal">


            <div class="form-group">
                <label class="span1 control-label">意见</label>
                <div class="span11">
                    <textarea rows="2" class="form-control tip" name="content"
                              placeholder="最多输入500字"></textarea>
                </div>
            </div>

        </div>
    </div>

</div>
<!-- box -->
<div class="box box-default">
    <!-- box-header -->
    <div class="box-header with-border">
        <h3 class="box-title">
            <div class="dec_1"></div>
            查询信息列表
        </h3>
        <div class="box-tools pull-right">
            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
        </div>
    </div>
    <!-- box-body -->
    <div class="box-body">
        <div class="form-horizontal">
            <div class="form-group">

                <ul id="myTab" class="nav nav-tabs">
                    <li><a href="#YWCXBQ09" data-toggle="tab">查询医疗信息</a></li>
                    <li><a href="#YWCXBQ01" data-toggle="tab">单位基本信息</a></li>
                    <li><a href="#YWCXBQ01" data-toggle="tab">个人基本信息</a></li>
                    <li><a href="#YWCXBQ01" data-toggle="tab">个人缴费基本信息</a></li>
                    <li><a href="#YWCXBQ01" data-toggle="tab">历史缴费信息</a></li>
                    <li><a href="#YWCXBQ01" data-toggle="tab">历史住院信息</a></li>
                    <li><a href="#YWCXBQ01" data-toggle="tab">转诊信息</a></li>
                    <li><a href="#YWCXBQ01" data-toggle="tab">长住异地信息</a></li>
                    <li><a href="#YWCXBQ01" data-toggle="tab">门诊病种信息</a></li>
                </ul>

                <div id="myTabContent" class="tab-content" style="height:200px;">

                </div>

            </div>
        </div>
    </div>
</div>
</div>
<script language="JavaScript">


    $(function () {
        //下拉选框
        $('.selectpicker').selectpicker({
            //style: 'btn-info',
            //size: 4
        });
        $('input').iCheck({
            checkboxClass: 'icheckbox_square_gd',
            radioClass: 'iradio_square_gd',
            increaseArea: '20%' // optional
        });
        //日期插件
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
    });

    function search(){
        $.ajax({
            url: "${ctx}/gtxt/accept/pension/monthretirecheckfind",
            type: "POST",
            data:{
                aac147: "124343",
                aac058: "03"
            },
            success: function(data){
                if(!data.bizSuccess){
                    alert(data.message);
                }
                console.log(data);
            }
        });
        return false;
    }
</script>
</body>
</html>

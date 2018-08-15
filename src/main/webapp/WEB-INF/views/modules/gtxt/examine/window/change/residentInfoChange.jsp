<%--
  Created by IntelliJ IDEA.
  User: cxd
  Date: 2016/11/3 0003
  Time: 19:47
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>居民信息维护</title>
    <meta name="decorator" content="yhdefault"/>
    <style>
        body{
            padding: 0px 10px;
        }
    </style>
</head>
<body>
<div>
    <div class="row">
        <div class="span12">
            <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        ${gtywinfo.dwmc}
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    </div>
                </div>
                <div class="box-body">
                    <form class="form-horizontal" id="searchForm">
                        <div class="form-group">
                            <label class="span1 control-label">电脑号</label>
                            <div class="span2">
                                <input type="text" readonly class="form-control aac001" name="aac001"
                                       id="dnh" value="${gtywinfo.dnh}"/>
                            </div>
                            <label class="span1 control-label">身份证号</label>
                            <div class="span2">
                                <input type="text" readonly class="form-control aac147" name="aac147"
                                       id="sfzh" value="${gtywinfo.sfzh}"/>
                            </div>
                            <label class="span1 control-label">社保卡号</label>
                            <div class="span2">
                                <input type="text" readonly class="form-control aac002" name="aac002"
                                       id="sbkh" value="${gtywinfo.dnh}"/>
                            </div>
                            <div class="span2">
                                <button type="button" onclick="tijiao();" class="btn btn-sm yellow">提交</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="span1 control-label">姓名</label>
                            <div class="span2">
                                <input type="text" class="form-control aac003" name="aac003" readonly="readonly"/>
                            </div>
                            <label class="span1 control-label">单位名称</label>
                            <div class="span2">
                                <input type="text" class="form-control aab004" name="aab004" readonly="readonly"/>
                            </div>
                            <label class="span1 control-label">组织机构代码</label>
                            <div class="span2">
                                <input type="text" class="form-control aab034" name="aab034" readonly="readonly"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="span1 control-label">参保类型</label>
                            <div class="span2">
                                <input type="text" class="form-control" name="cblx" readonly="readonly"/>
                            </div>
                            <label class="span1 control-label">操作人</label>
                            <div class="span2">
                                <input type="text" class="form-control" name="czr" value="${fns:getUser().name}" readonly="readonly"/>
                            </div>
                            <label class="span1 control-label">操作时间</label>
                            <div class="span2">
                                <input type="text" class="form-control" name="czsj" value="${fns:formatDate(gtywinfo.cjdate,'yyyy-MM-dd')}" readonly="readonly"/>
                            </div>
                        </div>
                        <input type="hidden" name="aac006" class="aac006"/>
                        <input type="hidden" name="aac004" class="aac004"/>
                        <input type="hidden" name="aac005" class="aac005"/>
                        <input type="hidden" name="aac058" class="aac005" value="01"/>
                    </form>
                </div>
            </div>
            <%--<div class="box box-default">
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
                            <label class="span1 control-label"></label>
                            <div class="span3">
                                <div class="radio-list">
                                    <label class="radio-inline">
                                        <input type="radio" name="optionsRadios" onclick="isYourself(this);"
                                               id="optionsRadios22" value="option1"/>
                                        <label>本人申请</label>
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="optionsRadios" onclick="isYourself(this);"
                                               id="optionsRadios23" value="option2"/>
                                        <label>他人代办</label>
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>--%>
            <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        受理信息录入
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    </div>
                </div>
                <form class="box-body" id="inputForm">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label class="span1 control-label">家庭电话</label>
                            <div class="span2">
                                <input type="text" readonly class="form-control" name="aae005" value="${jsonData.aae005}"/>
                            </div>
                            <label class="span1 control-label">手机号码</label>
                            <div class="span2">
                                <input type="text" readonly class="form-control" name="aac067" value="${jsonData.aac067}"/>
                            </div>
                            <label class="span1 control-label">联系人</label>
                            <div class="span2">
                                <input type="text" readonly class="form-control" name="aae004" value="${jsonData.aae004}"/>
                            </div>
                            <label class="span1 control-label">邮政编码</label>
                            <div class="span2">
                                <input type="text" readonly class="form-control" name="aae007" value="${jsonData.aae007}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="span1 control-label">通讯地址</label>
                            <div class="span11">
                                <input type="text" readonly class="form-control" name="aae006" value="${jsonData.aae006}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="span1 control-label">备注</label>
                            <div class="span11">
                                <textarea rows="2" readonly class="form-control tip" name="note" id="note"
                                          placeholder="最多输入500字">${jsonData.note}</textarea>
                            </div>
                        </div>
                    </div>
                </form>
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
                            <div class="span12">
                                <textarea rows="2" readonly class="form-control tip" name="yijian" id="yijian"
                                          placeholder="最多输入500字">${jsonData.yijian}</textarea>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        审核意见
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    </div>
                </div>
                <div class="box-body">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <div class="span12">
                                <textarea rows="2" class="form-control tip" name="yijian" id="yijian"
                                          placeholder="最多输入500字"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%--<div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        查询信息列表
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    </div>
                </div>
                <div class="box-body">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <ul id="myTab" class="nav nav-tabs">
                                <li><a href="#YWCXBQ01" data-toggle="tab">查询医疗信息</a></li>
                                <li><a href="#YWCXBQ02" data-toggle="tab">单位基本信息</a></li>
                                <li><a href="#YWCXBQ03" data-toggle="tab">个人基本信息</a></li>
                                <li><a href="#YWCXBQ04" data-toggle="tab">个人缴费基本信息</a></li>
                                <li><a href="#YWCXBQ05" data-toggle="tab">历史缴费信息</a></li>
                                <li><a href="#YWCXBQ06" data-toggle="tab">历史住院信息</a></li>
                                <li><a href="#YWCXBQ07" data-toggle="tab">转诊信息</a></li>
                                <li><a href="#YWCXBQ08" data-toggle="tab">长住异地信息</a></li>
                                <li><a href="#YWCXBQ09" data-toggle="tab">门诊病种信息</a></li>
                            </ul>
                            <div id="myTabContent" class="tab-content" style="height:200px;">
                                <div class="tab-pane" id="YWCXBQ01">
                                    医疗信息
                                </div>
                                <div class="tab-pane" id="YWCXBQ02">
                                    单位基本信息
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>--%>
        </div>
    </div>
</div>
<form id="submitForm" action="${ctx}/gtxt/examine/window/save" method="post" style="margin: 0; border: 0;">
    <input type="hidden" id="jsoninfo" name="jsoninfo"/>
    <input type="hidden" id="ywlsh" name="ywlsh" value="${gtywinfo.ywlsh}"/>
    <input type="hidden" id="ywid" name="ywid" value="${gtywinfo.ywid}"/>
    <input type="hidden" id="flowcode" name="flowcode" value="${flowcode}"/>
    <input type="hidden" id="shjbcode" name="shjbcode" value="${shjbcode}"/>
    <input type="hidden" id="ywbh" name="ywbh" value="${gtywinfo.ywbh}"/>
    <input type="hidden" id="ywmc" name="ywmc" value="${gtywinfo.ywmc}"/>
    <input type="hidden" id="grsbh" name="grsbh" class="aac002" value=""/>
    <input type="hidden" id="sfzh" name="sfzh" class="aac147" value="${gtywinfo.sfzh}"/>
    <input type="hidden" id="dnh" name="dnh" class="aac001" value="${gtywinfos[0].dnh}"/>
    <input type="hidden" id="xm" name="xm" class="aac003" value="${gtywinfo.xm}"/>
    <input type="hidden" id="dwbh" name="dwbh" class="dwbh" value="${gtywinfo.dwbh}"/>
    <input type="hidden" id="dwmc" name="dwmc" class="dwmc" value="${gtywinfo.dwmc}"/>
</form>
<script>
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

    function tijiao() {
        var data = $("#infoForm").serializeJson();
        $("#jsoninfo").val(JSON.stringify(data));
        $("#submitForm").submit();
    }
</script>
</body>
</html>

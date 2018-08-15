<%--
  Created by IntelliJ IDEA.
  User: cxd
  Date: 2016/9/6
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>跨省医疗关系转入</title>
    <meta name="decorator" content="default"/>
    <style>
        td, td * {
            /*word-break: keep-all;
            word-wrap: break-word;*/
        }

        .ulHead {
            text-align: center;
            background-color: #2fa4e7;
            color: white;
            line-height: 30px;
            border-radius: 3px;
        }

        .dl-horizontal dd {
            margin-left: 110px;
        }

        #personInfo {
            font-size: 14px;
        }

        #personInfo th {
            text-align: right;
            width: 70px;
        }

        #yewuleixing th {
            text-align: right;
            width: 70px;
        }

        .form-horizontal .controls {
            margin-left: 60px;
        }

        #tableinfo tr td input, select {
            margin: 0px;
            /*margin-left: 10px;*/
            width: 250px;
        }

        #tableinfo .titleinfo {
            text-align: right;
            width: 130px;
            padding-right: 10px;
        }

        /*#contenttable{*/
        /*width: 800px;*/
        /*}*/

        #contenttable, #luruinfo {
            border: 1px solid #ddd;
            border-collapse: separate;
            border-radius: 6px;
            border-top: none;
        }

        #tableinfo .longstyle {
            width: 669px;
        }

        #luruinfo tr td input {
            margin: 0px;
            /*margin-left: 10px;*/
            width: 250px;
        }

        #luruinfo .titleinfo {
            text-align: right;
            width: 130px;
            padding-right: 10px;
        }

        .form-search .ul-form li label {
            width: 130px;
        }

        .selectWidth {
            width: 164px;
        }

        .inputWidth {
            width: 150px;
        }
    </style>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="${ctx}/gtxt/examine/window/list?pageNo=${(not empty pageNo)?pageNo : 0}">窗口审核列表</a></li>
    <li class="active"><a href="#examine" data-toggle="tab" style="color: red;">审核内容</a></li>
    <li><a href="#YWCXBQ09" data-toggle="tab">审核材料</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">基本信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">个人缴费基本信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">历史缴费信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">历史住院信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">转诊信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">长住异地信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">门诊病种信息</a></li>
</ul>
<div id="myTabContent" class="tab-content">
    <div class="tab-pane active" id="examine">
        <input id="ywlsh" type="hidden" value="${ywlsh}">
        <input id="dwbh" type="hidden" value="${busRecviewBean.DWBH}"/>
        <input id="idcd" type="hidden" value="${busRecviewBean.SFZH}"/>
        <input id="newywbh" type="hidden" value="${newywbh}"/>
        <input id="lczt" type="hidden" value="${busRecviewBean.LCZT}"/>
        <input id="by15" type="hidden" value="${busRecviewBean.BY15}"/>
        <div>
            <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                <tr>
                    <th width="80">业务名称</th>
                    <td width="250">${gtywinfo.ywmc}</td>
                    <th width="80">受理回执号</th>
                    <td>${gtywinfo.hzdh}</td>
                    <th width="80">业务流水号</th>
                    <td>${gtywinfo.ywlsh}</td>
                </tr>
                <tr>
                    <th width="80">身份证号</th>
                    <td>${gtywinfo.sfzh}</td>
                    <th width="80">姓名</th>
                    <td>${gtywinfo.xm}</td>
                    <th width="80">所在单位</th>
                    <td>${gtywinfo.dwmc}</td>
                </tr>
                <tr>
                    <th width="80">经办人</th>
                    <td>${gtywinfo.slr.name}</td>
                    <th width="80">经办时间</th>
                    <td><fmt:formatDate value="${gtywinfo.cjdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <th width="80">联系电话</th>
                    <td>${jsonData.phone}</td>
                </tr>
            </table>
            <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" href="#collapseOne"
                       style="text-align: center; font-size: 18px;">
                      参保人个人信息
                    </a>
                </div>
                <div id="collapseOne" class="accordion-body collapse in">
                    <div class="accordion-inner" style="padding: 0;">
                        <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                            <tr>
                               
                                <th width="80">姓名:</th>
                                <td></td>
                                <th width="80">性别:</th>
                                <td></td>
                                 <th width="80">个人编号:</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th width="80">公民身份证号:</th>
                                <td></td>
                                <th width="80">户籍地地址:</th>
                                <td></td>
                                <th width="80">本地参保起始时间:</th>
                                <td> <input name="startDate" type="text" readonly="readonly"
                                                  maxlength="20" class="input-mini Wdate"
                                                  value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                                                  onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                                                  style="width: 150px;"/>
                                </td>
                            </tr>
                           
                        
                           
                        </table>
                    </div>
                </div>
            </div>
             <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" href="#collapseOne"
                       style="text-align: center; font-size: 18px;">
                    历年缴费信息
                    </a>
                </div>
                <div id="collapseOne" class="accordion-body collapse in">
                    <div class="accordion-inner" style="padding: 0;">
                        <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                            <tr>
                                <th width="80" rowspan="2">序号</th>
                                
                                <th width="80" >时间自年月至年月</th>
                            
                                <th width="80" >医疗保险类型</th>
                                
                                 <th width="80" >医疗保障编号</th>
                               
                                <th width="80" >已转个人账户余额</th>
                                <th width="80" >地区经办机构名称</th>
                               
                                <th width="80" >统筹地区经办机构行政区划代码</th>
                               
                            </tr>
                            <tr>
                                <th width="80">0</th>
                                <th width="80"></th>
                                <th width="80"></th>
                                <th width="80"></th>
                                <th width="80"></th>
                                <th width="80"></th>
                                <th width="80"></th>
                                
                                
                            </tr>
                           
                            
                           
                        </table>
                        <div style="padding: 0; ">
                                    <table class="table table-striped table-bordered table-condensed">
                                        <tr>
                                            <th>
                                                审核意见
                                            </th>
                                        </tr>
                                        <tr>
                                            <td style="width: 100%; padding: 0;" align="center">
                                                <textarea name="examineopinion" id="examineopinion" rows="4" style="width: 98%; resize: none;"></textarea>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                    </div>
                </div>
            </div>
            <center>
                <div class="breadcrumb" style="margin-top: 3px; margin-right: 10px;">
                    <button type="button" id="ywbanjie" onclick="" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-cloud-upload"></i>&nbsp; 提 交
                    </button>
                    <button type="button" id="xgqfb" onclick="" class="btn btn-warning"
                            style="width: 110px; padding-left: 3px; padding-right: 3px;"><i
                            class="icon-edit"></i>&nbsp;打印凭证
                    </button>
                    <button type="button" id="lrfpxx" onclick="" class="btn btn-warning"
                            style="width: 120px; padding-left: 3px; padding-right: 3px;"><i
                            class="icon-edit"></i>&nbsp;打印信息表
                    </button>
                 
                
                    <button type="button" id="baocun" onclick="" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-save"></i>&nbsp; 保 存
                    </button>
                  
                    <button type="button" id="bdzhuanjian" onclick="" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-external-link"></i>&nbsp;中止任务
                    </button>
                    <button type="button" id="fanhui"
                            onclick="location.href='${ctx}/sisl/busreview/list?pageNo=${pageNo}'" class="btn"
                            style="width: 110px;"><i
                            class="icon-reply"></i>&nbsp;返回前台
                    </button>
                </div>
            </center>
            <%--<div id="centerDiv" class="breadcrumb form-search" style="margin: 0; text-align: center;">

            </div>--%>
        </div>
    </div>
    <div class="tab-pane" id="YWCXBQ09">...</div>
    <div class="tab-pane" id="YWCXBQ01">...</div>
</div>
<script type="text/javascript">
    function fapiao(){
        top.$.jBox.open("iframe:${ctx}/gtxt/utils/util/fapiao?type=medical", "发票录入或修改", 1000, 600, {
            loaded: function () {
                closeTip();
                $(".jbox-content", top.document).css("overflow-y", "auto");
            },
            closed: function () {

            },
            opacity: 0.5,
            border: 1,
            iframeScrolling: "auto",
            persistent: true,
            buttons: {'保存': 'save' },
            submit: function (v, h, f) {
                if (v == "save") {
                    alertx("发票录入保存成功！");
                }
            }
        });
    }
    function qxxiugai(){
        top.$.jBox.open("iframe:${ctx}/gtxt/utils/util/qingdan?type=medical", "清单录入或修改", 1000, 600, {
            loaded: function () {
                closeTip();
                $(".jbox-content", top.document).css("overflow-y", "auto");
            },
            closed: function () {

            },
            opacity: 0.5,
            border: 1,
            iframeScrolling: "auto",
            persistent: true,
            buttons: {'保存': 'save' },
            submit: function (v, h, f) {
                if (v == "save") {
                    alertx("清单录入保存成功！");
                }
            }
        });
    }

    function tijiao() {
        var data = $("#infoForm").serializeJson();

        $("#jsoninfo").val(JSON.stringify(data));
        $("#submitForm").submit();
    }
</script>
</body>
</html>

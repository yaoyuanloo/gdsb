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
    <title>窗口审核详细</title>
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
                    <td width="250">${typename}</td>
                    <th width="80">受理回执号</th>
                    <td></td>
                    <th width="80">业务流水号</th>
                    <td></td>
                </tr>
                <tr>
                    <th width="80">身份证号</th>
                    <td></td>
                    <th width="80">姓名</th>
                    <td></td>
                    <th width="80">所在单位</th>
                    <td></td>
                </tr>
                <tr>
                    <th width="80">经办人</th>
                    <td></td>
                    <th width="80">经办时间</th>
                    <td></td>
                    <th width="80">联系电话</th>
                    <td></td>
                </tr>
            </table>
            <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" href="#collapseOne"
                       style="text-align: center; font-size: 18px;">
                        审核信息
                    </a>
                </div>
                
                
                
                <div id="collapseOne" class="accordion-body collapse in">
                    <div class="accordion-inner " style="padding: 0;text-align: center;">
                       <table id="contentTable"
						class="table table-striped table-bordered table-condensed"
						style="margin-align: center; margin-top: 0px; margin-top: -9px;">
						<thead >
			    <tr>
							<th colspan="4" style="text-align:center;">个人基本信息</th>
			    </tr>
				<tr>
				    <td width="20%">个人身份证号：</td>
					<td width="30%">440402108212059067</td>
					<td width="20%">个人姓名：</td>
					<td width="30%">常文豪</td>
					
				</tr>
				<tr>
				    <td>联系人：</td>
					<td>常文豪</td>
					<td>联系电话：</td>
					<td >13212345678</td>
					
				</tr>
				<tr>
					<th  colspan="4" style="text-align:center;">转入地社保机构信息:</th>
				</tr>
				<tr>
				    <td>社保经办机构名称:</td>
					<td colspan="3" style="width:100%;text-align:center">苍梧县社会保险事业管理所</td>
				</tr>
				<tr>
				    <td>开户户名:</td>
					<td colspan="3" style="width:100%;text-align:center">苍梧县社会保险事业管理所</td>
				</tr>
				<tr>
				    <td>开户银行:</td>
					<td colspan="3" style="width:100%;text-align:center">苍梧县工商银行</td>
				</tr>
				<tr>
				    <td>银行行号:</td>
					<td colspan="3" style="width:100%;text-align:center">102621130202</td>
				</tr>
				<tr>
				    <td>地址:</td>
					<td colspan="3" style="width:100%;text-align:center">广西苍梧县龙玗镇广信路3号</td>
				</tr>
				<tr>
				    <td>邮政编码:</td>
					<td colspan="3" style="width:100%;text-align:center">543100</td>
				</tr>
				<tr>
				    <td>银行账号:</td>
					<td colspan="3" style="width:100%;text-align:center">2104302229249006636</td>
				</tr>
				<tr>
					<th colspan="4" style="text-align: center;height:20px;">银行信息</th>
				</tr>
				<tr>
				    <td rowspan="2" >银行名称:</td>
					<td rowspan="2" >农业银行</td>
				    <td>账号：</td>
					<td >6228230115012345764</td>
				</tr>
				<tr>
				    <td>户名：</td>
					<td >常文豪</td>
					
				</tr>
				<tr>
					<th colspan="4" style="text-align: center;height:50px;">劳动局失业登记信息</th>
				</tr>
				<tr>
				    <td>失业登记日期<font color="red"></font>:</td>
					<td >20160801</td>
					 <td>失业证号:</td>
					<td>123</td>
				</tr>
				<tr>
				    <td >劳动关系停止时间<font color="red"></font>：</td>
					<td >20160801</td>
					<td>是否自愿失业:</td>
					<td>非自愿</td>
				</tr>
			    </thead>
		        </table>
					
                    </div>
                </div>
            </div>
            <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" href="#collapseTwo"
                       style="text-align: center; font-size: 18px;">
                        录入信息
                    </a>
                    
                </div>
                     
                <div id="collapseTwo" class="accordion-body collapse in">
                    <div class="accordion-inner" style="padding: 0;">
                        <center>
                            <div id="controlForm" class="form-search breadcrumb" style=" margin: 0; border: 0;">
                            <div style="padding: 0; ">
                                    <table class="table table-striped table-bordered table-condensed">
                                        <tr>
                                            <th>
                                                审核意见
                                            </th>
                                        </tr>
                                        <tr>
                                            <td style="width: 100%; padding: 0;" align="center">
                                                <textarea name="" id="" rows="4"
                                                          style="width: 98%; resize: none;"></textarea>
                                            </td>
                                        </tr>
                                        <tr>
                                         <button type="button" id="ywbanjie" onclick="yewubanjie()" class="btn btn-warning"
                                          style="width: 110px;"><i
                                          class="icon-print"></i>&nbsp;打印
                                        </button>
                                        </tr>
                                        
                                    </table>
                                </div>
                            </div>
                        </center>
                    </div>
                </div>
            </div>
            <center>
                <div class="breadcrumb" style="margin-top: 3px; margin-right: 10px;">
                
                    <button type="button" id="ywbanjie" onclick="yewubanjie()" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-cloud-upload"></i>&nbsp; 提 交
                    </button>
                    
                    <button type="button" id="lrfpxx" onclick="" class="btn btn-warning"
                            style="width: 110px; padding-left: 3px; padding-right: 3px;"><i
                            class="icon-edit"></i>&nbsp;发票信息录入
                    </button>
                    <button type="button" id="qdsh" onclick="" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-legal"></i>&nbsp;清单审核
                    </button>
                    <button type="button" id="xiugai" onclick="xiugai()" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-pencil"></i>&nbsp; 计 算
                    </button>
                    <button type="button" id="baocun" onclick="baocun()" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-save"></i>&nbsp; 保 存
                    </button>
                    <button type="button" id="qxxiugai" onclick="qxxiugai()" class="btn btn-warning"
                            style="width: 110px;"><i
                            class="icon-picture"></i>&nbsp;补充材料
                    </button>
                    <button type="button" id="bdzhuanjian" onclick="forwording()" class="btn btn-warning"
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
        top.$.jBox.open("iframe:${ctx}/gtxt/utils/util/fapiao?type=birth", "发票录入或修改", 1000, 600, {
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
</script>
</body>
</html>

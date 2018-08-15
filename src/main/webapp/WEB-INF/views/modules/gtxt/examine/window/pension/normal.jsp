<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>一般人员建账审核详细</title>
<meta name="decorator" content="default" />
<style>
.selectWidth {
	width: 164px;
}

.inputWidth {
	width: 170px;
}

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
	width: 264px;
}

.inputWidth {
	width: 250px;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		
		
		
	    $("#jzfs").change(function () {
	    	if ($(this).val() == 0)
	    	$(".jiaofeitype").fadeIn('fast');
	    	else
	    	$(".jiaofeitype").fadeOut('fast');
	    	})
	});
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
	function thumbnail(imgPath, ywlsh) {
		loading("正在加载，请稍等...");
		top.$.jBox.open("iframe:${ctx}/sisl/busreview/imgshow?imgPath="
				+ imgPath + "&ywlsh=" + ywlsh, "扫描件 详细", 880, 660, {
			loaded : function() {
				closeTip();
				$(".jbox-content", top.document).css("overflow-y", "hidden");
			},
			closed : function() {

			},
			opacity : 0.5,
			border : 1,
			iframeScrolling : "no",
			buttons : {},
			submit : function(v, h, f) {
				if (v == "qwe") {
					alert("Asd");
					return false;
				}
			}
		});
	}
	function toBusdocs() {
		var dwbh = $("#dwbh").val();
		$.jBox("iframe:${ctx}/busdocsList/busdocsinfo/list?dwbh=" + dwbh + "",
				{
					title : "企业基本信息",
					width : 1000,
					height : 360,
					buttons : {
						'关闭' : true
					}
				});
	}
	function toBasicinfo() {
		var idcd = $("#idcd").val();
		$.jBox("iframe:${ctx}/per/basicinfo/list?IDCD=" + idcd + "&type=1", {
			title : "个人基本信息",
			width : 1000,
			height : 350,
			buttons : {
				'关闭' : true
			}
		});
	}
	function toBusProcessM() {
		var ywbh = $("#newywbh").val();

		$.jBox("iframe:${ctx}/ProcessMaterial/ProcessMaterialList/list?ywbh="
				+ ywbh + "", {
			title : "需审核的材料及操作流程",
			width : 1000,
			height : 450,
			buttons : {
				'关闭' : true
			}
		});
	}
	//window.location.href="${ctx}/busdocsList/busdocsinfo/list;"
	//self.location="${ctx}/busdocsList/busdocsinfo/list";
	//window.navigate("${ctx}/busdocsList/busdocsinfo/list");
	//window.open('WEB-INF/modules/sisl/busdocsList.jsp','','height=500,width=611,scrollbars=yes,status=yes')
	//window.open('${ctx}/busdocsList/busdocsinfo/list','','height=500,width=611,scrollbars=yes,status=yes')
	function yewubanjie() {
		var ywlsh = $("#ywlsh").val();
		var indwbh = $("#indwbh").val();
		var JFSJ = $("#JFSJ").val();

		if ((indwbh != null) && (indwbh.trim() != "")) {//单位编号非为空验证
			if ((JFSJ != null) && (JFSJ.trim() != "")) {//缴费时间非为空验证
				jbox();
			} else {
				alertx("请选择【缴费时间】！");
			}
		} else {
			alertx("请输入【单位编号】！");
		}

		function jbox() {
			top.$
					.jBox(
							"<div class='form-search' style='padding:20px;text-align:center;'>是否办结？</div>",
							{
								title : "提示",
								submit : function(v, h, f) {
									if (v == "ok") {
										var data = {
											ywlsh : ywlsh,
											indwbh : indwbh,
											JFSJ : JFSJ
										}
										$
												.post(
														"${ctx}/sisl/busreview/qiyebanjie",
														data,
														function(data) {
															if (data.status == 1) {
																confirmx(
																		data.msg
																				+ "是否返回上一页？",
																		"${ctx}/sisl/busreview/list?pageNo=${pageNo}");
															} else {
																showTip(
																		data.msg,
																		'info',
																		2000, 0);
															}
														});
									}
								},
								buttons : {
									"继续" : "ok",
									"取消" : "cancel"
								}
							});
		}
	}
	function forwording() {
		var ywlsh = $("#ywlsh").val();
		top.$.jBox.open("iframe:${ctx}/sisl/busreview/zhuanjian", "注意事项", 400,
				300, {
					ajaxData : {
						ywlsh : ywlsh
					},
					buttons : {
						"确认" : "qr",
						"返回" : "cancer"
					},
					submit : function(v, h, f) {
						var win = h.find("iframe")[0].contentWindow;
						var doc = win.document;
						var qId = $("#ROWINFOId", doc).val();
						var qName = $("#ROWINFOName", doc).val();
						var oId = $("#organizationId", doc).val();
						var oName = $("#organizationName", doc).val();
						var bean = $("#RepiectBean", doc).val();
						var reason = $("#reason", doc).val().trim();
						var lczt = $("#lczt", doc).val();
						var data = {
							Bean : bean,
							ywlsh : ywlsh,
							qName : qName,
							oName : oName,
							reason : reason,
							lczt : lczt,
							ywlsh : ywlsh
						};
						//                    console.log(data);
						if (v == "qr") {

							$.post("${ctx}/sisl/busreview/receipt", data,
									function(response) {
										if (response.success) {
											showTip("转件成功！", 'info', 2000, 0);

										} else {
											alert(response.msg);
											showTip("转件失败！", 'info', 2000, 0);
										}
									});
							return false;
						}
					},
					loaded : function(h) {
						closeTip();
						$(".jbox-content", top.document).css("overflow-y",
								"hidden");
					},
					iframeScrolling : 'no',
					showType : 'show',
					opacity : 0.5,
					top : "15%",
					border : 1,
					persistent : true
				});
	}
	
	function calculate(){
		
		var date1=$("#startDate").val();
		var datesouce=date1;
		var date2=$("#endDate").val();
   //结束时间
		/* var date1 = '2013-03-26';
		var date2 = '2011-01-10'; */
		// 拆分年月日
		date1 = date1.split('-');
		// 得到月数
		date1 = parseInt(date1[0]) * 12 + parseInt(date1[1]);
		// 拆分年月日
		date2 = date2.split('-');	
		//alert("111111111:"+date2);
		// 得到月数
		date2 = parseInt(date2[0]) * 12 + parseInt(date2[1]);
		var m = Math.abs(date1 - date2);
		//alert(m);
		var tb=null;
		var show=null;
		var ss=null;
		tb+='<thead><tr><th>选择</th><th>身份证号</th><th>开始年月</th><th>结束年月</th><th>核销状态</th></tr>';
		for(var i=0;i<m;i++){
			
				var cy=(date1)/12;
				var st=cy.toString();
				st=st.split('.');
		       // alert(st[0]);//年
				var mon=(date1)-12*st[0]; //月
				if(mon==0){
					ss=parseInt(st[0])-1;
					mon=12;
				}
				if(mon==12){
					show=ss+"-"+(mon);//alert(show);
					 date1=date1+1; 
				}else{
				show=st[0]+"-"+(mon);//alert(show);
				 date1=date1+1; }
			
			
			tb+='<tr><td><i class="icon-check-empty"></i></td><td>'+$("#IDNo").val()+'</td><td>'+show+'</td><td>'+show+'</td><td>'+'未核销'+'</td></thead>'
		}
		
		
		
		$("#tabledata").html(tb);
		
		
		
	}
	function tijiao() {
		var ywlsh = $("#ywlsh").val();
		var xgq = $("#xgq").val();
		var xgh = $("#xgh").val();
		var xgstate = $("#xgstate").val();//修改项

		if (xgstate == null) {//普通件 走正常提交流程
			jbox();
		} else {//功能件
			if (xgh != null && xgh.trim() != "") {//内容非空
				var regxm = /[\u4e00-\u9fa5]/;//姓名正则
				var regsfz = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/;//身份证正则
				//                var reghj = /^[-+]?\d+$/;//户籍正则
				if (xgstate == "xgxm" && !regxm.test(xgh)) {//修改姓名
					alertx("请填写正确的汉字作为姓名！");
				} else if (xgstate == "xgsfz" && !regsfz.test(xgh)) {//修改身份证
					alertx("请填写正确的身份证号！");
				} else {
					jbox();
				}
			} else {
				if (xgstate == "xghj") {
					alertx("请选择变更后的户籍！");
				} else if (xgstate == "xgxm") {
					alertx("请填写修改后的姓名！");
				} else if (xgstate == "xgsfz") {
					alertx("请填写修改后的身份证！");
				}
			}
		}

		function jbox() {
			top.$
					.jBox(
							"<div class='form-search' style='padding:20px;text-align:center;'>是否提交？</div>",
							{
								title : "提示",
								submit : function(v, h, f) {
									if (v == "ok") {
										var data = {
											ywlsh : ywlsh,
											xgq : xgq,
											xgh : xgh,
											lczt : $("#lczt").val(),
											by15 : $("#by15").val()
										}
										//                            console.log(data);
										$.post("${ctx}/sisl/busreview/tijiao",
												data, function(data) {
													showTip(data.msg, 'info',
															2000, 0);
												});
<%--$.post("${ctx}/sisl/busreview/hehe", data, function (data) {--%>
	
<%--showTip(data.msg, 'info', 2000, 0);--%>
	
<%--});--%>
	}
								},
								buttons : {
									"继续" : "ok",
									"取消" : "cancel"
								}
							});
		}

	}

	function xiugai() {
		$("#tableinfo tr td input,select:not(#uneidt)").each(function(i, o) {
			$(o).removeAttr("disabled");//可编辑
		});
		$("#ywbanjie").css("display", "none");//办结按钮隐藏
		$("#xiugai").css("display", "none");//修改按钮隐藏
		$("#bdzhuanjian").css("display", "none");//转件按钮隐藏
		$("#baocun").css("display", "inline");//保存按钮显示
		$("#qxxiugai").css("display", "inline");//取消修改按钮显示
		$("#fanhui").css("display", "none");//取消修改按钮显示

		$("tr[name='clickhiddentr']").css("display", "none");//隐藏办结

		$("div[name='clickhiddentr']").css("display", "none");//隐藏办结
	}

	function qxxiugai() {
		// 确认对话框
		top.$.jBox.confirm("您确认要【取消修改】吗？", '系统提示', function(v) {
			if (v == 'ok') {
				window.location.reload(true);
			}
		});
	}
    

	function baocun() {
		var ywlsh = $("#ywlsh").val();
		var DWJC = $("#DWJC").val();//企业名称
		var DWDZ = $("#DWDZ").val();//企业注册地址
		var GSH = $("#GSH").val();//企业工商注册号
		var DWDM = $("#DWDM").val();//组织机构代码号
		var HYLX = $("#HYLX").val();//企业行业类别
		var JJLX = $("#JJLX").val();//企业经济类别
		var ZCXS = $("#ZCXS").val();//组成形式名称
		var YLJG = $("#YLJG").val();//定点医疗机构名称
		var FZRQ = $("#FZRQ").val();//核发工商执照日期
		var FRXM = $("#FRXM").val();//企业法人姓名
		var FRSFZ = $("#FRSFZ").val();//企业法人证件号
		var JBRDH = $("#JBRDH").val();//企业电话
		var ZGBM = $("#ZGBM").val();//企业主管部门
		var JBRSJ = $("#JBRSJ").val();//经办人移动电话
		var YB = $("#YB").val();//邮政编码
		var SJSDFS = $("#SJSDFS").val();//票据送达方式
		var YHBM = $("#YHBM").val();//银行名称
		var YHMC = $("#YHMC").val();//银行营业部简称
		var YHZH = $("#YHZH").val();//银行账号
		var JBR = $("#JBR").val();//银行账号
		//            var YWZT = $("#YWZT").val();//业务状态

		jbox();

		function jbox() {
			top.$
					.jBox(
							"<div class='form-search' style='padding:20px;text-align:center;'>是否提交？</div>",
							{
								title : "提示",
								submit : function(v, h, f) {
									if (v == "ok") {
										var data = {
											ywlsh : ywlsh,
											DWJC : DWJC,
											DWDZ : DWDZ,
											GSH : GSH,
											DWDM : DWDM,
											HYLX : HYLX,
											JJLX : JJLX,
											ZCXS : ZCXS,
											YLJG : YLJG,
											FZRQ : FZRQ,
											FRXM : FRXM,
											FRSFZ : FRSFZ,
											JBRDH : JBRDH,
											ZGBM : ZGBM,
											JBRSJ : JBRSJ,
											YB : YB,
											SJSDFS : SJSDFS,
											YHBM : YHBM,
											YHMC : YHMC,
											YHZH : YHZH,
											JBR : JBR
										//                                YWZT:YWZT
										}
										console.log(data);
										$.post("${ctx}/sisl/busreview/baocun",
												data, function(data) {
													showTip(data.msg, 'info',
															2000, 0);
												});
									}
								},
								buttons : {
									"继续" : "ok",
									"取消" : "cancel"
								}
							});
		}
	}
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a
			href="${ctx}/gtxt/examine/window/list?pageNo=${(not empty pageNo)?pageNo : 0}">窗口审核列表</a></li>
		<li class="active"><a href="#examine" data-toggle="tab"
			style="color: red;">窗口业务审核</a></li>
		<li><a href="#YWCXBQ09" data-toggle="tab">任务日志</a></li>
		<li><a href="#YWCXBQ01" data-toggle="tab">档案基本信息</a></li>
		<li><a href="#YWCXBQ01" data-toggle="tab">档案内容</a></li>
		<li><a href="#YWCXBQ01" data-toggle="tab">同类业务档案</a></li>
		<li><a href="#YWCXBQ01" data-toggle="tab">个人缴费信息</a></li>
		<li><a href="#YWCXBQ01" data-toggle="tab">历史缴费信息</a></li>
		<li><a href="#YWCXBQ01" data-toggle="tab">个人账户基本信息</a></li>
		<li><a href="#YWCXBQ01" data-toggle="tab">异地转入视同和地方养老信息</a></li>
		<li><a href="#YWCXBQ01" data-toggle="tab">异地转入工资信息</a></li>
		<li><a href="#YWCXBQ01" data-toggle="tab">视同建账详细信息</a></li>
	</ul>
	<div>
            <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                <tr>
                    <th width="80">业务名称</th>
                    <td width="250"></td>
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
          </div>
		<div id="centerDiv" style="width: 100% ; margin: 0; overflow-x: hidden; overflow-y: auto;">
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane active" id="examine">
					<input id="ywlsh"   type="hidden" value="${ywlsh}"> 
					<input id="dwbh"    type="hidden" value="${busRecviewBean.DWBH}" />
					<input id="idcd"    type="hidden" value="${busRecviewBean.SFZH}" /> 
					<input id="newywbh" type="hidden" value="${newywbh}" /> 
					<input id="lczt"    type="hidden" value="${busRecviewBean.LCZT}" /> 
					<input id="by15"    type="hidden" value="${busRecviewBean.BY15}" />
						
					<div>
						<div id="centerDiv" class="breadcrumb form-search"
							style="margin: 0; text-align: center;">
							<table id="baseTable"
								class="table table-striped table-bordered table-condensed"
								style="margin: 0;">
							</table>
							<div id="baseTable">
							</div>
							<center>

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
                            <form id="submitForm" action="${ctx}/gtxt/examine/window/save" method="post" style="margin: 0; border: 0;">
                                <input type="hidden" id="jsoninfo" name="jsoninfo"/>
                                <input type="hidden" id="ywlsh" name="ywlsh" value="${gtywinfo.ywlsh}"/>
                                <input type="hidden" id="ywid" name="ywid" value="${gtywinfo.ywid}"/>
                                <input type="hidden" id="flowcode" name="flowcode" value="${flowcode}"/>
                                <input type="hidden" id="shjbcode" name="shjbcode" value="${shjbcode}"/>
                                <input type="hidden" id="ywbh" name="ywbh" value="${gtywinfo.ywbh}"/>
                                <input type="hidden" id="ywmc" name="ywmc" value="${gtywinfo.ywmc}"/>
                                <input type="hidden" id="grsbh" name="grsbh" class="sino" value=""/>
                                <input type="hidden" id="sfzh" name="sfzh" class="idno" value=""/>
                                <input type="hidden" id="dnh" name="dnh" class="pcno" value=""/>
                                <input type="hidden" id="xm" name="xm" class="peosonname" value=""/>
                                <input type="hidden" id="dwbh" name="dwbh" class="dwbh" value=""/>
                                <input type="hidden" id="dwmc" name="dwmc" class="dwmc" value=""/>
                            </form>
                            <form id="infoForm" method="post" class="breadcrumb form-search" style=" margin: 0; border: 0;">
                                <ul class="ul-form" style="">
                                       <li> <label for="sqr">一般人员建账方式：</label>
										  <select   id="jzfs" name="jzfs" class="input-medium selectWidth">
											    <option value="1">调入</option>
												<option value="0">本市</option>
										   </select>
									   </li>
                                    <li><label >选择地：</label>
                                        <sys:treeselect id="fenqu" name="fenqu.code" value="${work.fenqu.code}" labelName="fenqu.name"
                                          labelValue="${work.fenqu.name}" notAllowSelectParent="false"
                                          title="辖区" url="/xq/area/treeData" cssClass="input-small" cssStyle="width: 105px;"
                                          allowClear="true"/>
                                      </li>
                                   
                                   <li class="jiaofeitype" style="display: none;"><label for="jiaofei">缴费类别：</label>
                                            <select id="jiaofei" name="jiaofei" class="input-medium selectWidth">
                                               <option value="1">视同</option>
                                               <option value="0">实际</option>
                                             </select>
                                      </li>
                                    
                                    <li class="clearfix"></li>
                                   
                                    <li><label>视同截至时间点：</label> 
									   <input name="cjsj" type="text"
										readonly="readonly" maxlength="20" class="input-mini Wdate"
										value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM"/>"
										onclick="WdatePicker({dateFmt:'yyyy-MM',isShowClear:true});"
										style="width: 150px;" /> 
									</li>
                                    <li><label style="width:230px">调出地 ：</label>
                                        <sys:treeselect id="fenqu" name="fenqu.code" value="${work.fenqu.code}" labelName="fenqu.name"
                                          labelValue="${work.fenqu.name}" notAllowSelectParent="false"
                                          title="辖区" url="/xq/area/treeData" cssClass="input-small" cssStyle="width: 105px;"
                                          allowClear="true"/>
                                      </li>	
                                    
                                    <li class="clearfix"></li>
                                   
                                   <li ><label>视同起始时间点：</label>
										
										<input id="startDate"
											name="cjsj" type="text" readonly="readonly" maxlength="20"
											class="input-mini Wdate"
											value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM"/>"
											onclick="WdatePicker({dateFmt:'yyyy-MM',isShowClear:true});"
											style="width: 150px;" />
										</li>
										
										<li ><label style="width:230px">视同结束时间点：</label>
										
										<input id="endDate"
											name="cjsj" type="text" readonly="readonly" maxlength="20"
											class="input-mini Wdate"
											value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM"/>"
											onclick="WdatePicker({dateFmt:'yyyy-MM',isShowClear:true});"
											style="width: 150px;" /></li>
                                  
                                     <li class="clearfix"></li>
                                     
                                
									<li><label for="note">备注：</label> 
									  <input id="note"  name="note" type="text" htmlEscape="false" maxlength="100" style="width: 710px;" />
									 </li>
										
						
                                </ul>
                                <div style="padding: 0; ">
                                    <table class="table table-striped table-bordered table-condensed">
                                        <tr>
                                            <th>
                                                诊断
                                            </th>
                                        </tr>
                                        <tr>
                                            <td style="width: 100%; padding: 0;" align="center">
                                                <textarea name="" id="" rows="4" style="width: 98%; resize: none;"></textarea>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </form>
                        </center>
                    </div>
                </div>
            </div>
			</center>
							<div class="breadcrumb"
										style="margin-top: 3px; margin-right: 10px;">
										<button type="button" id="ywbanjie" onclick=""
											class="btn btn-warning" style="width: 150px;">
											<i class="icon-cloud-upload"></i>&nbsp;初审通过
										</button>
										<button type="button" id="xiugai" onclick=""
											class="btn btn-warning" style="width: 150px;">
											<i class="icon-pencil"></i>&nbsp;转受理补充材料
										</button>
										<button type="button" id="baocun" onclick=""
											class="btn btn-warning" style="width: 150px;">
											<i class="icon-save"></i>&nbsp; 转初审补充材料
										</button>
										<button type="button" id="qxxiugai" onclick=""
											class="btn btn-warning" style="width: 150px;">
											<i class="icon-picture"></i>&nbsp;中止任务
										</button>
										<button type="button" id="xgqfb" onclick=""
											class="btn btn-warning"
											style="width: 200px; padding-left: 2px; padding-right: 2px;">
											<i class="icon-edit"></i>&nbsp;退回录入个人基本信息
										</button>
									</div>
						</div>
						<div class="breadcrumb"
							style="margin-top: 3px; margin-right: 10px;">
							<button type="button" id="xgqfb" onclick=""
								class="btn btn-small"
								style="width: 100px; padding-left: 2px; padding-right: 2px;">
								<i class="icon-edit"></i>&nbsp;计算
							</button>
							<button type="button" id="xgqfb" onclick="calculate()"
								class="btn btn-small"
								style="width: 100px; padding-left: 2px; padding-right: 2px;">
								<i class="icon-edit"></i>&nbsp;增加
							</button>
							<button type="button" id="xgqfb" onclick=""
								class="btn btn-small"
								style="width: 100px; padding-left: 2px; padding-right: 2px;">
								<i class="icon-edit"></i>&nbsp;删除
							</button>
						</div>
						<div class="pagination"></div>

						<table id="tabledata" class="table table-striped table-bordered table-condensed">
							
						</table>		
						<div
							style="padding: 0 5px 5px 5px; margin: 0; background: #ffffff;">
							<ul class="thumbnails" style="margin-top: 5px;">
								<c:set value="${fns:getUser()}" var="loginUser" />
								<c:forEach items="${imgs}" var="img" varStatus="status">
									<li class="span3 thumbnail" style="margin: 5px; width: 220px;">
										<a
										href="javascript:thumbnail('${img.id}', '${busRecviewBean.YWLSH}');">
											<img src="${img.id}?username=admin&password=admin"
											style="width: 250px; height: 200px;">
									</a> <span>${img.BY2}</span>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				</div>
				</div>
				
				<div class="tab-pane" id="YWCXBQ09">...</div>
				<div class="tab-pane" id="YWCXBQ01">...</div>
			
</body>
</html>

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
    <title>养老待遇核定</title>
    <meta name="decorator" content="default"/>
    <style>
   
    </style>
</head>
<body>
<%-- <ul class="nav nav-tabs">
    <li><a href="${ctx}/gtxt/examine/window/list?pageNo=${(not empty pageNo)?pageNo : 0}">窗口审核列表</a></li>
    <li class="active"><a href="#examine" data-toggle="tab" style="color: red;">窗口业务审核</a></li>
    <li><a href="#YWCXBQ09" data-toggle="tab">查询医疗信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">单位基本信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">个人基本信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">个人缴费基本信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">历史缴费信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">历史住院信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">转诊信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">长住异地信息</a></li>
    <li><a href="#YWCXBQ01" data-toggle="tab">门诊病种信息</a></li>
</ul> --%>
<div id="myTabContent" class="tab-content">
    <div class="tab-pane active" id="examine">
        <div>
            <div id="centerDiv" class="breadcrumb form-search" style="margin: 0; text-align: center;">
                <div id="baseTable">
                  <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                        <thead>
	                        <tr>
	                            <th colspan="6"  style="text-align: center;"><h5>退休基本信息</h5></th>
	                        </tr>
	                        <tr>
	                            <td style="text-align: center;">姓名：</td>
	                            <td colspan="1">
	                            	<input id="yearmybacktotal" name="yearmybacktotal" type="text" value=""
	                                       class="input-medium inputWidth"/><a href="#" style="color: red;">*</a>
	                            </td>
	                            <td style="text-align: center;">身份证号：</td>
	                            <td>
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                             <td style="text-align: center;">性别：</td>
	                             <td>
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                             
	                        </tr>
	                        <tr>
	                            <td style="text-align: center;">出生年月：</td>
	                            <td colspan="1">
	                            
	                                 <input id="startDate" name="cjsjs" type="text" readonly="readonly"  maxlength="20" class="input-mini Wdate"
                      
                                          value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM"/>"
                                          onclick="WdatePicker({dateFmt:'yyyy-MM',isShowClear:true});"
                                          style="width: 150px;"/><a href="#" style="color: red;">*</a>
                                    
	                            </td>
	                            <td style="text-align: center;">参加工作年月：</td>
	                            <td>
	                            	   <input id="startDate" name="cjsjs" type="text" readonly="readonly"
                       maxlength="20" class="input-mini Wdate"
                       value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM"/>"
                       onclick="WdatePicker({dateFmt:'yyyy-MM',isShowClear:true});"
                       style="width: 150px;"/><a href="#" style="color: red;">*</a>
	                            </td>
	                            <td style="text-align: center;">退休时年龄：</td>
	                            <td>
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                        </tr>
	                        <tr>
	                           <td style="text-align: center;">居住地址：</td>
	                            <td colspan="6">
	                            	<input id="yearmybacktotal"  style="width:300px  "  name="yearmybacktotal" type="text" value=""
	                                       class="input-medium inputWidth"/> <a href="#" style="color: red;">*</a>
	                            </td>
	                        </tr>
	                        <tr>
	                            <td style="text-align: center;">退休时所在辖区：</td>
	                            <td colspan="1">
	                            	<input id="yearmybacktotal" name="yearmybacktotal" type="text" value=""
	                                       class="input-medium inputWidth" style="width: 90%"/>
	                            </td>
	                            <td style="text-align: center;">退休类型：</td>
	                            <td  colspan="4">
	                            	
	                                        <select
											id="JFSJ" style="width: 150px;">
												<option value="1">企业</option>
												<option value="2">机关</option>
												<option value="3">事业</option>
												<option value="4">全额拨款事业单位</option>
												<option value="5">差额拨款事业单位</option>
												<option value="6">自收自支事业单位</option>
												<option value="7">社会团体</option>
												<option value="8">民办非企业单位</option>
												<option value="9">城镇个体工商户</option>
												<option value="10">个人缴费</option>
												
										</select>
	                            </td>
	                        </tr>
	                        
	                         <tr>
	                            <td style="text-align: center;">参保人员状态:</td>
	                            <td colspan="1">
	                            	<input id="yearmybacktotal" name="yearmybacktotal" type="text" value=""
	                                       class="input-medium inputWidth" style="width: 90%"/>
	                            </td>
	                            <td style="text-align: center;">离退休类别:</td>
	                            <td>
	                            	 <select
											id="JFSJ" style="width: 150px;">
												<option value="1">正常</option>
												<option value="2">提前</option>
												<option value="3">延迟</option>
												
										</select>
	                            </td>
	                            <td style="text-align: center;">待遇发放形式:</td>
	                            <td>
	                            	 <select
											id="JFSJ" style="width: 150px;">
												<option value="1">银行发放</option>
												<option value="2">异地银行</option>
												<option value="3">现金</option>
												<option value="3">单位代发</option>
												
										</select>
	                            </td>
	                           
	                        </tr>
	                        
	                        
	                         <tr>
	                            <td style="text-align: center;">用工形式:</td>
	                            <td>
	                            	 <select
											id="JFSJ" style="width: 150px;">
												<option value="1">原固定职工</option>
												<option value="2">城镇合同制职工</option>
												<option value="3">农村合同制工人</option>
												<option value="3">临时工</option>
												<option value="1">外来劳务工</option>
												<option value="2">法人代表</option>
												<option value="3">其他</option>
												
										</select>
	                            </td>
	                            <td style="text-align: center;">退休形式：</td>
	                            <td colspan="1">
	                            	 <select
											id="JFSJ" style="width: 150px;">
												<option value="1">正常</option>
												<option value="2">提前</option>
												<option value="3">延迟</option>
												
												
										</select>
	                            </td>
	                              <td style="text-align: center;">社会化管理形式:</td>
	                            <td colspan="1">
	                            	<select
											id="JFSJ" style="width: 150px;">
												<option value="1">社区管理</option>
												<option value="2">社保机构管理</option>
												<option value="3">依托企业管理</option>
												<option value="4">其他</option>
												<option value="5">退职</option>
												<option value="6">因病提前退休</option>
												<option value="7">工伤退休</option>
												<option value="8">特殊工种提前退休</option>
												<option value="9">军转干提前退休</option>
												<option value="10">公务员退休</option>
												
										</select>
	                            </td> 
	                        </tr>
	                        
	                        <tr>
	                            <td style="text-align: center;">个人身份：</td>
	                            <td colspan="1" style="text-align: center;">
	                            <input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
                                 </td>
                                 <td style="text-align: center;">单位报退休待遇：</td>
	                            <td colspan="1">
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                            
	                             <td style="text-align: center;">技术职称：</td>
	                            <td colspan="1">
	                            	<select
											id="JFSJ" style="width: 150px;">
												<option value="1">无</option>
												<option value="2">初</option>
												<option value="3">中</option>
												<option value="4">高</option>
												<option value="5">副高</option>
											
												
										</select>
	                            </td>
	                        </tr>
	                        
	                         <tr>
	                            <td style="text-align: center;" rowspan="1">离退休日期:</td>
	                            <td colspan="1">
	                            	 <input id="startDate" name="cjsjs" type="text" readonly="readonly"
                       maxlength="20" class="input-mini Wdate"
                       value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM"/>"
                       onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:true});"
                       style="width: 150px;"/> <a href="#" style="color: red;">*</a>
	                            </td>
	                            <td style="text-align: center;">待遇首次支付年月:</td>
	                            <td colspan="4">
	                            	 <input id="startDate" name="cjsjs" type="text" readonly="readonly"
                       maxlength="20" class="input-mini Wdate"
                       value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM"/>"
                       onclick="WdatePicker({dateFmt:'yyyy-MM',isShowClear:true});"
                       style="width: 150px;"/> <a href="#" style="color: red;">*</a>
	                            </td>
	                        </tr>
	                        
	                        <tr>
	                            <td style="text-align: center;">邮政编码:</td>
	                            <td>
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td> <a href="#" style="color: red;">*</a>
	                            <td style="text-align: center;">联系人:</td>
	                            <td>
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                            <td style="text-align: center;">联系电话:</td>
	                            <td>
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                        </tr>
	                        
	                         <tr>
	                            <td style="text-align: center;">因办理养老金年月:</td>
	                            <td colspan="3"> 
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                            <td style="text-align: center;">首次参保时间:</td>
	                            <td colspan="3"> 
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                        </tr>
	                        
	                         <tr>
	                            <td style="text-align: center;">档案编号：</td>
	                            <td colspan="1"> 
	                            	<textarea rows="1" style="width: 90%;outline:none;resize:none;"></textarea>
	                            </td>
	                            
	                            <td style="text-align: center;">居住地标记：</td>
	                            <td> 
	                            	<select
											id="JFSJ" style="width: 150px;">
												<option value="1">市内</option>
												<option value="2">省内市外</option>
												<option value="3">省外</option>
												<option value="4">国外</option>
												
											
												
										</select> <a href="#" style="color: red;">*</a>
	                            </td>
	                            <td style="text-align: center;">户籍所在地：</td>
	                            <td> 
	                            	<select
											id="JFSJ" style="width: 150px;">
												<option value="1">市内</option>
												<option value="2">省内市外</option>
												<option value="3">省外</option>
												<option value="4">国外</option>
												
											
												
										</select> <a href="#" style="color: red;">*</a>
	                            </td>
	                        </tr>
	                        
	                      
                        </thead>
                    </table>
                    <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                        <thead>
                             <tr>
	                            <th colspan="6"  style="text-align: center;"><h5>新办法退休待遇信息</h5></th>
	                        </tr>
	                        <tr>
	                            <th width="80">实际缴费月数:</th>
	                            <td></td>
	                            <th width="80">特殊工种加发比例:</th>
	                            <td></td>
	                            <th width="80">工伤待遇差额：</th>
	                            <td></td>
	                        </tr>
	                        <tr>
	                            <th width="80">视同缴费月份:</th>
	                            <td></td>
	                            <th width="80">记发月数:</th>
	                            <td></td>
	                            <th width="80">基础养老金：</th>
	                            <td></td>
	                        </tr>
	                         <tr>
	                            <th width="80">累计缴费月份:</th>
	                            <td></td>
	                            <th width="80">上年度省职工平均工资:</th>
	                            <td></td>
	                            <th width="80">过渡性养老金：</th>
	                            <td></td>
	                        </tr>
	                         <tr>
	                            <th width="80">特殊工种月数:</th>
	                            <td></td>
	                            <th width="80">个人账户储蓄额:</th>
	                            <td></td>
	                            <th width="80">个帐养老金：</th>
	                            <td></td>
	                        </tr>
	                         <tr>
	                            <th width="80">本人平均缴费指数:</th>
	                            <td></td>
	                            <th width="80">退休津贴:</th>
	                            <td></td>
	                            <th width="80">地方性养老金：</th>
	                            <td></td>
	                        </tr>
	                         <tr>
	                            <th width="80">平均指数化缴费工资:</th>
	                            <td></td>
	                            <th width="80">补充养老金本金:</th>
	                            <td></td>
	                            <th width="80">养老待遇调整：</th>
	                            <td></td>
	                        </tr>
	                         <tr>
	                            <th width="80">1993年前12月前视帐总额:</th>
	                            <td></td>
	                            <th width="80">补充养老金利息:</th>
	                            <td></td>
	                            <th width="80">新办法近期待遇合计：</th>
	                            <td></td>
	                        </tr>
	                         <tr>
	                            <th width="80">1994年1月后视帐总额:</th>
	                            <td></td>
	                            <th width="80">一次新待遇合计:</th>
	                            <td></td>
	                            <th width="80">新旧对比补差：</th>
	                            <td></td>
	                        </tr>
	                         <tr>
	                            <th width="80">缴费年限津贴:</th>
	                            <td></td>
	                            <th width="80">高级职称津贴:</th>
	                            <td></td>
	                            <th width="80">省分担基础养老金：</th>
	                            <td></td>
	                        </tr>
	                         <tr>
	                            <th width="80">近期待遇合计:</th>
	                            <td></td>
	                            <th width="80">备注:</th>
	                            <td></td>
	                            
	                        </tr>
                        </thead>
                    </table>
                </div>
                
                <div class="breadcrumb" style="margin-top: 3px; margin-right: 10px;">
                            <button type="button" id="ywbanjie" onclick="yewubanjie()" class="btn btn-warning"
                                    style="width: 110px;"><i
                                    class="icon-cloud-upload"></i>&nbsp; 通过
                            </button>
                            <button type="button" id="qdsh" onclick="qxxiugai()" class="btn btn-warning"
                                    style="width: 150px;"><i
                                    class="icon-legal"></i>&nbsp;转受理补充材料
                            </button>
                            <button type="button" id="xgqfb" onclick="qxxiugai()" class="btn btn-warning"
                                    style="width: 150px; padding-left: 2px; padding-right: 2px;"><i
                                    class="icon-edit"></i>&nbsp;转初审补充材料
                            </button>
                            <button type="button" id="xiugai" onclick="xiugai()" class="btn btn-warning"
                                    style="width: 150px;"><i
                                    class="icon-pencil"></i>&nbsp; 终止任务
                            </button>
                            
                            <ul class="breadcrumb">
                                 <li ><label for="note">备注：</label> <input id="note"
										name="note" type="text" htmlEscape="false" maxlength="100"
										style="width: 710px;" /></li>
							</ul>	
                            
                           
                   </div>
                   
                   <div class="breadcrumb" style="margin-top: 3px; margin-right: 10px;">
                        <button type="button" id="tijiao" onclick="" class="btn btn-info"
                                style="width: 110px;"><i
                                class="icon-cloud-upload"></i>&nbsp;提交
                        </button>
                    </div>
            </div>
            
            
            
            
        </div>
    </div>
    <div class="tab-pane" id="YWCXBQ09">...</div>
    <div class="tab-pane" id="YWCXBQ01">...</div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
    });
</script>
</body>
</html>

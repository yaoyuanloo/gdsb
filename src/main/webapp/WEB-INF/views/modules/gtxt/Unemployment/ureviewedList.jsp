<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>窗口审核详细</title>
    <meta name="decorator" content="default"/>
    <style>
   
    </style>
</head>
<body>
<ul class="nav nav-tabs">
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
</ul>
<div id="myTabContent" class="tab-content">
    <div class="tab-pane active" id="examine">
        <div>
            <div id="centerDiv" class="breadcrumb form-search" style="margin: 0; text-align: center;">
                <div id="baseTable">
                    <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                        <thead>
	                        <tr>
	                            <th width="80">受理回执号</th>
	                            <td></td>
	                            <th width="80">业务流水号</th>
	                            <td></td>
	                            <th width="80">业务名称</th>
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
                        </thead>
                    </table>
                    <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                        <thead>
	                        <tr>
	                            <th colspan="5"  style="text-align: center;"><h5>领取期限与待遇区间</h5></th>
	                        </tr>
	                        <tr>
	                            <td style="text-align: center;">领取期限开始日</td>
	                            <td colspan="2">
	                            	<input id="yearmybacktotal" name="yearmybacktotal" type="text" value=""
	                                       class="input-medium inputWidth"/><a href="#" style="color: red;">*</a>
	                            </td>
	                            <td style="text-align: center;">领取期限结束日</td>
	                            <td>
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                        </tr>
	                        <tr>
	                            <td style="text-align: center;">待遇开始年月</td>
	                            <td colspan="2">
	                            	<input id="yearmybacktotal" name="yearmybacktotal" type="text" value=""
	                                       class="input-medium inputWidth"/><a href="#" style="color: red;">*</a>
	                            </td>
	                            <td style="text-align: center;">待遇结束年月</td>
	                            <td>
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                        </tr>
	                        
	                        <tr>
	                            <td style="text-align: center;">计发失业金实际缴费时投段</td>
	                            <td colspan="2">
	                            	<input id="yearmybacktotal" name="yearmybacktotal" type="text" value=""
	                                       class="input-medium inputWidth" style="width: 90%"/>
	                            </td>
	                            <td style="text-align: center;">月数</td>
	                            <td>
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                        </tr>
	                        
	                         <tr>
	                            <td style="text-align: center;">纳入定期待遇农民工时段</td>
	                            <td colspan="2">
	                            	<input id="yearmybacktotal" name="yearmybacktotal" type="text" value=""
	                                       class="input-medium inputWidth" style="width: 90%"/>
	                            </td>
	                            <td style="text-align: center;">月数</td>
	                            <td>
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                        </tr>
	                        
	                        
	                         <tr>
	                            <td style="text-align: center;">结转上次待遇月数</td>
	                            <td>
	                            	<input id="yearmybacktotal" name="yearmybacktotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                            <td style="text-align: center;">上次申领失业保险时间</td>
	                            <td colspan="2">
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                        </tr>
	                        
	                        <tr>
	                            <td style="text-align: center;">医保待遇</td>
	                            <td colspan="1" style="text-align: center;">医疗保险缴费标准</td>
	                            <td colspan="3">
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                        </tr>
	                        
	                         <tr>
	                            <td style="text-align: center;" rowspan="3">求职补贴待遇核定</td>
	                            <td style="text-align: center;">核定月数</td>
	                            <td colspan="3">
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                        </tr>
	                        
	                        <tr>
	                            <td style="text-align: center;">平均工资</td>
	                            <td>
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                            <td style="text-align: center;">计发比例</td>
	                            <td>
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                        </tr>
	                        
	                         <tr>
	                            <td style="text-align: center;">计发月标准</td>
	                            <td colspan="3"> 
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                        </tr>
	                        
	                        <tr>
	                            <td style="text-align: center;">计发农民工实际缴费时段(条例实施前)</td>
	                            <td colspan="2"> 
	                            	<textarea rows="4" style="width: 90%;outline:none;resize:none;"></textarea>
	                            </td>
	                            
	                            <td style="text-align: center;">月数</td>
	                            <td> 
	                            	<input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/>
	                            </td>
	                        </tr>
	                        
	                        <tr>
	                            <td style="text-align: center;" rowspan="2">一次性生活补助核定(条例实施前)</td>
	                            <td style="text-align: center;">平均工资</td>
	                            <td><input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/></td>
	                            <td style="text-align: center;">计发比例</td>
	                            <td><input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/></td>
	                        </tr>
	                        
	                        <tr>
	                            <td style="text-align: center;">计发金额</td>
	                            <td colspan="4"><input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/></td>
	                        </tr>
	                        
	                        <tr>
	                            <td style="text-align: center;">一次性生活补助合计金额</td>
	                            <td colspan="4"><input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/></td>
	                        </tr>
	                        
	                        <tr>
	                            <td style="text-align: center;">养老视同失业时段</td>
	                            <td colspan="2"><input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/></td>
	                                       
	                            <td style="text-align: center;">月数</td>
	                            <td><input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth"/></td>
	                        </tr>
	                        
	                        <tr>
	                           	<td style="text-align: center;">备注</td>
	                           	<td colspan="5"><input id="yearmyhightotal" name="yearmyhightotal" type="text" value=""
	                                       class="input-medium inputWidth" style="width: 94%"/></td>
	                        </tr>
                        </thead>
                    </table>
                </div>
                
                <div class="breadcrumb" style="margin-top: 3px; margin-right: 10px;">
                            <button type="button" id="ywbanjie" onclick="yewubanjie()" class="btn btn-warning"
                                    style="width: 110px;"><i
                                    class="icon-cloud-upload"></i>&nbsp; 提 交
                            </button>
                            <button type="button" id="qdsh" onclick="qxxiugai()" class="btn btn-warning"
                                    style="width: 110px;"><i
                                    class="icon-legal"></i>&nbsp;清单审核
                            </button>
                            <button type="button" id="xgqfb" onclick="qxxiugai()" class="btn btn-warning"
                                    style="width: 110px; padding-left: 2px; padding-right: 2px;"><i
                                    class="icon-edit"></i>&nbsp;修改起付标准
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
                                    onclick="location.href='${ctx}/sisl/busreview/list?pageNo=${pageNo}'" class="btn btn-warning"
                                    style="width: 110px;"><i
                                    class="icon-reply"></i>&nbsp;返回前台
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

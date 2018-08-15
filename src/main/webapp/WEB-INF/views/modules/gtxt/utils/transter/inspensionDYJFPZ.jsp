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
    <title>省内养老打印缴费凭证</title>
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
	                            <th colspan="8"  style="text-align: center;"><h5>省内基本养老保险参保凭证</h5></th>
	                        </tr><hr/>
	                        <tr>
	                            <th colspan="8"  style="text-align: center;"><h5>参保人员基本信息</h5></th>
	                        </tr>
	                        <tr>
	                            <td style="text-align: center;">姓名：</td>
	                            <td >
	                            	
	                            </td>
	                            <td style="text-align: center;">性别：</td>
	                            <td>
	                            	
	                            </td>
	                             <td style="text-align: center;">单位名称：</td>
	                             <td colspan="3">
	                            	
	                            </td>
	                             
	                        </tr>
	                        <tr>
	                            <td style="text-align: center;">公民身份证号：</td>
	                            <td colspan="1">
	                                
                                    
	                            </td>
	                            <td style="text-align: center;">个人编号：</td>
	                            <td> 
	                            </td>
	                            <td style="text-align: center;">参加工作时间：</td>
	                            <td>
	                            	
	                            </td>
	                             <td style="text-align: center;">当地统筹时间：</td>
	                            <td>
	                            	
	                            </td>
	                        </tr>
	                        <tr>
	                           <td style="text-align: center;">本人首次缴费时间：</td>
	                            <td >
	                            	 
	                            </td>
	                            <td style="text-align: center;">本人建立个人账户时间：</td>
	                            <td >
	                            	
	                            </td>
	                            <td style="text-align: center;">本地实际缴费月数：</td>
	                            <td >
	                            	
	                            </td>
	                            <td style="text-align: center;">全部实际缴费月数合计：</td>
	                            <td >
	                            	
	                            </td>
	                        </tr>
	                        <tr>
	                            <th colspan="8"  style="text-align: center;"><h5>参保人员养老保险基金基本信息(单位:元)</h5></th>
	                        </tr>
	                         <tr>
	                            <td style="text-align: center;" colspan="4">个人账户基金储存额</td>
	                            <td style="text-align: center;" colspan="4">省外转入的统筹基金转移额</td>
	                        
	                        </tr>
	                        
	                         <tr>
	                            <td style="text-align: center;" colspan="4">0</td>
	                             <td style="text-align: center;" colspan="4"></td>
	                           
	                        </tr>
	                        
	                        <tr>
	                            <th colspan="8"  style="text-align: center;"><h5>参保地社保机构信息</h5></th>
	                        </tr>
	                         <tr>
	                            <td style="text-align: center;" colspan="2">社保机构地址：</td>
	                            <td style="text-align: center;" colspan="2">0</td>
	                            <td style="text-align: center;" colspan="2">邮政编码：</td>
	                            <td style="text-align: center;" colspan="2">0</td>
	                         </tr>

                        </thead>
                    </table>
                    <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                        <thead>
                             <tr>
	                            <th colspan="12"  style="text-align: center;"><h5>历史实际缴费及个人账户记账信息</h5></th>
	                        </tr>
	                        <tr>
	                            <th width="80" colspan="2">参保地址</th>
	                            
	                            <th width="80" rowspan="2">年份</th>
	                            
	                            <th width="80" rowspan="2">缴费起止时间</th>
	                            
	                            <th width="80" rowspan="2">缴费月数</th>
	                            
	                            <th width="80" rowspan="2">月缴费基数</th>
	                            <th width="80" colspan="3">缴费比例</th>
	                            <th width="80" colspan="2">当年记账金额</th>
	                            <th width="80" rowspan="2">缴费类型</th>
	                           
	                        </tr>
	                        <tr>
	                            <th width="80">行政区划代码</th>
	                            
	                            <th width="80">名称</th>
	                            
	                            <th width="80">单位</th>
	                            <th width="80">行政区划代码</th>
	                            
	                            <th width="80">个人</th>
	                            
	                            <th width="80">小计</th>
	                            <th width="80">个人缴费</th>
	                            <td></td>
	                        </tr>
	                         <tr>
	                            
	                            <td></td>
	                            
	                            <td></td>
	                           
	                            <td></td>
	                            <td></td>
	                            
	                            <td></td>
	                           
	                            <td></td>
	                            <td></td>
	                            
	                            <td></td>
	                           
	                            <td></td>
	                            <td></td>
	                            
	                            <td></td>
	                           
	                            <td></td>
	                        </tr>
	                        
	                 
                        </thead>
                    </table>
                </div>
                
              <!--   <div class="breadcrumb" style="margin-top: 3px; margin-right: 10px;">
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
                            
                           
                   </div> -->
                   
                   <div class="breadcrumb" style="margin-top: 3px; margin-right: 10px;">
                        <button type="button" id="tijiao" onclick="" class="btn btn-warning"
                                style="width: 110px;"><i
                                class="icon-cloud-upload"></i>&nbsp;打印凭证
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

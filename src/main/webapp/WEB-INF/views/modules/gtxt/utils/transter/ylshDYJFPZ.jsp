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
    <title>医疗审核打印缴费凭证</title>
    <meta name="decorator" content="default"/>
    <style>
   
    </style>
</head>
<body>

<div id="myTabContent" class="tab-content">
    <div class="tab-pane active" id="examine">
        <div>
            <div id="centerDiv" class="breadcrumb form-search" style="margin: 0; text-align: center;">
                <div id="baseTable">
                  <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                        <thead>
	                        <tr>
	                            <th colspan="8"  style="text-align: center;"><h5>参保凭证</h5></th>
	                        </tr><hr/>
	                        <tr>
	                            <th colspan="8"  style="text-align: center;"><h5>基本信息</h5></th>
	                        </tr>
	                        <tr>
	                            <td style="text-align: center;" rowspan="2">参保人：</td>
	                            <td >
	                            	
	                            </td>
	                            <td style="text-align: center;">姓名：</td>
	                            <td>
	                            	
	                            </td>
	                             <td style="text-align: center;">公民身份证号：</td>
	                             
	                             <td colspan="1"></td>
	                             <td style="text-align: center;">医疗保障编号：</td>
	                             
	                             <td colspan="1"></td>
	                            	
	                            
	                             
	                        </tr>
	                        <tr>
	                            <td style="text-align: center;">户籍所在地：</td>
	                            <td colspan="3">
	                               
                                    
	                            </td>
	                           
	                        
	                            <td style="text-align: center;">户籍类型：</td>
	                            <td colspan="1">
	                               
                                    
	                            </td>
	                           
	                        </tr>
	                         <tr>
	                            <td style="text-align: center;">姓名：</td>
	                            <td colspan="1">
	                               
                                    
	                            </td>
	                           
	                        
	                            <td style="text-align: center;">公民身份证号：</td>
	                            <td colspan="3">
	                               
                                    
	                            </td>
	                           
	                        </tr>
	                       
                        </thead>
                    </table>
                    <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                        <thead>
                             <tr>
	                            <th colspan="4"  style="text-align: center;"><h5>参保信息</h5></th>
	                        </tr>
	                        <tr>
	                            <th width="80" >医疗保障类型:</th>
	                            <td></td>
	                            <th width="80" >参保地:</th>
	                            <td></td>
	                           
	                        </tr>
	                        <tr>
	                            <th width="80" rowspan="2">参保时间</th>
	                            <td></td>
	                            <th width="80" rowspan="2">待遇享受起止时间:</th>
	                             <td></td>
	                        </tr>
	                         <tr>
	                            
	                            <td></td>
	                            
	                            <td></td>
	                        </tr>
	                        <tr>
	                            <th width="80" rowspan="2">个人账户余额:</th>
	                            <td colspan="3">小写：</td>
	                           
	                            
	                        </tr>
	                         <tr>
	                            <td colspan="3">大写：</td>
	                        </tr>
	                 
                        </thead>
                    </table>
                     <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                        <thead>
                             <tr>
	                            <th colspan="3"  style="text-align: center;"><h5>经办机构信息</h5></th>
	                        </tr>
	                        <tr>
	                            <th width="80" >办理机构名称:</th>
	                            <td colspan="2"></td>
	                            
	                        </tr>
	                        <tr>
	                            <th width="80" rowspan="1">联系人</th>
	                            
	                            <th width="80" rowspan="2">(自主打印):</th>
	                             <td width="80">电话</td>
	                        </tr>
	                         <tr>
	                            
	                            <td>0</td>
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

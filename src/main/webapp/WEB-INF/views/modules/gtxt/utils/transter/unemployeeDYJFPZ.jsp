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
    <title>失业审核打印缴费凭证</title>
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
	                            <th colspan="8"  style="text-align: center;"><h5>失业保险关系转移凭证</h5></th>
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
	                             <td style="text-align: center;">个人编号：</td>
	                             
	                             <td colspan="1">
	                            	
	                            </td>
	                             
	                        </tr>
	                        <tr>
	                            <td style="text-align: center;">社会保障号：</td>
	                            <td colspan="5">
	                               
                                    
	                            </td>
	                           
	                        </tr>
	                         <tr>
	                            <td style="text-align: center;">户籍所在地：</td>
	                            <td colspan="5">
	                               
                                    
	                            </td>
	                           
	                        </tr>
	                       
	                        <tr>
	                            <th colspan="8"  style="text-align: center;"><h5>截至打印日期失业保险记录</h5></th>
	                        </tr>
	                         <tr>
	                            <td style="text-align: center;" rowspan="3">已核待遇的缴费信息</td>
	                            <td style="text-align: center;" colspan="3">累计缴费月数</td>
	                            <td style="text-align: center;" colspan="3"></td>
	                            <td style="text-align: center;">视同缴费月数</td>
	                            <td></td>
	                             <td style="text-align: center;">起止年月:</td>
	                            <td></td>
	                        
	                        </tr>
	                         <tr>
	                            <td style="text-align: center;" >视同缴费月数:</td>
	                            <td></td>
	                             <td style="text-align: center;">起止年月:</td>
	                            <td></td>
	                            
	                           
	                        </tr>
	                         <tr>
	                            <td style="text-align: center;" >实际缴费月数:</td>
	                            <td></td>
	                             <td style="text-align: center;">起止年月:</td>
	                            <td></td>
	                            
	                           
	                        </tr>
	                        
	                         <tr>
	                            <td style="text-align: center;" >原农名工缴费月数:</td>
	                            <td></td>
	                             <td style="text-align: center;">起止年月:</td>
	                            <td></td>
	                            
	                           
	                        </tr>
	                     
	                         <tr>
	                           <td style="text-align: center;" rowspan="4">可核待遇的信息</td>
	                            <td style="text-align: center;" colspan="3">累计缴费月数</td>
	                            <td style="text-align: center;" colspan="3"></td>
	                            <td style="text-align: center;">视同缴费月数</td>
	                            <td></td>
	                             <td style="text-align: center;">起止年月:</td>
	                            <td></td>
	                         </tr>
	                          <tr>
	                            <td style="text-align: center;" >实际缴费月数:</td>
	                            <td></td>
	                             <td style="text-align: center;">起止年月:</td>
	                            <td></td>
	                            
	                           
	                        </tr>
                            <tr>
	                            <td style="text-align: center;" >原农名工缴费月数:</td>
	                            <td></td>
	                             <td style="text-align: center;">起止年月:</td>
	                            <td></td>
	                            
	                           
	                        </tr>
	                        <tr>
	                            <td style="text-align: center;" >结转的失业金领取月数:</td>
	                            <td></td>
	                             <td style="text-align: center;" colspan="4">0</td>
	                            <td></td>
	                            
	                           
	                        </tr>
	                        <tr>
	                            <td style="text-align: center;" >核定失业金信息:</td>
	                            <td></td>
	                            <td></td>
	                             <td style="text-align: center;" colspan="4">本地可领取失业金月数:</td>
	                            <td colspan="3"></td>
	                            
	                           
	                        </tr>
	                        <tr>
	                            <td style="text-align: center;" >申请人电话:</td>
	                            <td colspan="4"></td>
	                            <
	                             <td style="text-align: center;" colspan="4">申请人姓名:</td>
	                            <td colspan="3"></td>
	                            
	                           
	                        </tr>
	                        
                        </thead>
                    </table>
                    <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                        <thead>
                             <tr>
	                            <th colspan="12"  style="text-align: center;"><h5>社会保险经办机构信息</h5></th>
	                        </tr>
	                        <tr>
	                            <th width="80" >机构名称</th>
	                            <td></td>
	                            <th width="80" >机构地址</th>
	                            <td></td>
	                           
	                        </tr>
	                        <tr>
	                            <th width="80">行政区划代码</th>
	                            <td></td>
	                            <th width="80">邮政编码:</th>
	                            <td></td>
	                            
	                        </tr>
	                         <tr>
	                            <th width="80">联系人:</th>
	                            <td></td>
	                            <th width="80">联系电话:</th>
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

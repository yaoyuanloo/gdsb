<%--
  Created by IntelliJ IDEA.
  User: cxdwe
  Date: 2016/10/13
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
    	body{
			font-family: "Microsoft YaHei" ! important;
			font-size: 13px;
    	}
    </style>
    <meta name="decorator" content="yhdefault"/>
</head>
<body>

<!--页面主体-->
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
            	行业统筹企业养老保险关系转入</h3>
	          <div class="box-tools pull-right">
	            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
	          </div>
        </div>
        <!-- box-body -->
        <div class="box-body">
          <form class="form-horizontal" name="myform" id="myform" method="post" action="">
            <div class="form-group">
              <label class="span1 control-label">电脑号：</label>
              <div class="span2">
               <input type="text" placeholder="请输入电脑号" class="form-control" name="idcard" id=""/>
              </div>
              <label class="span1 control-label">身份证号：</label>
              <div class="span2">
                <input type="text" placeholder="请输入身份证号" class="form-control" name="name"/>
              </div>
              <label class="span1 control-label">社保卡号：</label>
              <div class="span2">
                <input type="text" placeholder="请输入社保卡号" class="form-control" name="name"/>
              </div>
              <div class="span3 pull-right">
                <button type="submit" class="btn btn-sm yellow">查询(F)</button>
                <button type="submit" class="btn btn-sm gray">重置(R)</button>
              </div>
            </div>
            <table class="table table-bordered table-striped table-hover" id="dynamic_pager_content">
              <thead>
                <tr>
                  <th>姓名 </th>
                  <th>身份证号 </th>
                  <th>户籍 </th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>张三</td>
                  <td>43502178789890800</td>
                  <td>广东深圳</td>
                </tr>
              </tbody>
            </table>
          </form>
        
        </div>
      </div>
      
      <div class="box box-default" style="margin-top: -20px;"> 
      		  <div class="box-header with-border">
	          	<h3 class="box-title">
	            <div class="dec_1"></div>
	                                    行业统筹企业养老保险关系转入信息</h3>
		        <div class="box-tools pull-right">
		           <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
		        </div>
	        </div>
	         <div class="box-body">
                    <form class="form-horizontal" name="myform" id="myform" method="post" action="">
                        <div class="form-group">
                              <label class="span2 control-label">申请人：</label>
                              <div class="span4">
	                                <select name="show" class="form-control selectpicker">
	                                    <option value="1">本人办理</option>
	                                    <option value="0">他人代办</option>
	                                </select>
                             </div>
                             
                             <label class="span2 control-label">联系电话：</label>
                              <div class="span4">
	                                <input type="text" placeholder="请输入联系电话" class="form-control" name="" id=""/>
                             </div>
                        </div>
                        
                        <div class="form-group">
                             <label class="span2 control-label">个人身份证：</label>
                              <div class="span4">
	                                <input type="text" placeholder="请输入联系电话" class="form-control" name="" id=""/>
                             </div>
                             
                             <label class="span2 control-label">个人姓名：</label>
                              <div class="span4">
	                               <input type="text" placeholder="请输入联系电话" class="form-control" name="" id=""/>
                             </div>
                        </div>
                        <div class="form-group">
                           	  <label class="span2 control-label">其他申报材料：</label>
                              <div class="span4">
	                               <input type="text" placeholder="请输入联系电话" class="form-control" name="" id=""/>
                              </div>
                              
                              <label class="span2 control-label">转入总金额：</label>
                              <div class="span4">
	                               <input type="text" placeholder="请输入联系电话" class="form-control" name="" id=""/>
                              </div>
                        </div>
                        <div class="form-group">
                            <label class="span2 control-label">备注：</label>
                            <div class="span10">
                                <textarea rows="1" class="form-control tip" name="content" id="content"
                                          placeholder="最多输入500字"></textarea>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <div class="col-sm-offset-2 span10">
                                <button type="submit" class="btn yellow">保存(S)</button>
                                <button type="submit" class="btn gray" id="resetButton">重置(R)</button>
                                <button type="submit" class="btn gray">关闭</button>
                                <button type="submit" class="btn darkgray">禁用</button>
                            </div>
                        </div>
                        
                        <ul class="nav nav-tabs">
							  <li class="active"><a href="#">业务所需材料</a></li>
							  <li><a href="#">单位基本信息</a></li>
							  <li><a href="#">个人基本信息</a></li>
							  <li><a href="#">查询医疗信息</a></li>
							  <li><a href="#">个人缴费基本信息</a></li>
							  <li><a href="#">历史缴费信息</a></li>
							  <li><a href="#">历史住院信息</a></li>
							  <li><a href="#">转诊信息</a></li>
							  <li><a href="#">长住异地信息</a></li>
							  <li><a href="#">门诊病种信息</a></li>
						</ul>
                    </form>
                </div>
      </div>
    </div>
  </div>
  <!--行一./-->  
</div>



</body>
</html>

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
            	部队养老保险关系转入申请</h3>
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
      
      
      <div class="box box-default" style="margin-top: -22px;">
      		 <div class="box-header with-border">
	          	<h3 class="box-title">
	            	<div class="dec_1"></div>
	                                                部队养老保险关系转入申请信息
	            </h3>
		        <div class="box-tools pull-right">
		           <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
		        </div>
	        </div>
	         <div class="box-body">
                    <form class="form-horizontal" name="myform" id="myform" method="post" action="">
                        <div class="form-group">
                              <label class="span1 control-label">申请人：</label>
                              <div class="span2">
	                                <select name="show" class="form-control selectpicker">
	                                    <option value="1">本人办理</option>
	                                    <option value="0">他人代办</option>
	                                </select>
                             </div>
                             <label class="span2 control-label">联系电话：</label>
                              <div class="span2">
	                                <input type="text" placeholder="请输入联系电话" class="form-control" name="" id=""/>
                             </div>
                             
                             <label class="span2 control-label">申请人户籍：</label>
                              <div class="span2">
	                                <input type="text" placeholder="请输入申请人户籍" class="form-control" name="" id=""/>
                             </div>
                        </div>
                    </form>
                </div>
      	</div>
      
      
       <div class="box box-default" style="margin-top: -22px;">
      		 <div class="box-header with-border">
	          	<h3 class="box-title">
	            	<div class="dec_1"></div>
	                                               养老转出机构详情
	            </h3>
		        <div class="box-tools pull-right">
		           <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
		        </div>
	        </div>
	         <div class="box-body">
                    <form class="form-horizontal" name="myform" id="myform" method="post" action="">
                        <div class="form-group">
                              <label class="span2 control-label">关系转出地：</label>
                              <div class="span2">
	                                <select name="show" class="form-control selectpicker">
	                                    <option value="1">广东省</option>
	                                    <option value="0">...</option>
	                                </select>
	                               
                             </div>
                             <div class="span2">
	                                <select name="show" class="form-control selectpicker">
	                                    <option value="1">深圳市</option>
	                                    <option value="0">...</option>
	                                </select>
	                                
                             </div>
                             <div class="span2">
	                                <select name="show" class="form-control selectpicker">
	                                    <option value="1">福田区</option>
	                                    <option value="0">...</option>
	                                </select>
                             </div>
                              <label class="span2 control-label">邮政编码：</label>
                              <div class="span2">
	                               <input type="text" placeholder="请输入联系电话" class="form-control" name="" id=""/>
                              </div>
                        </div>
                        <div class="form-group">
                             <label class="span2 control-label">参保凭证号：</label>
                              <div class="span2">
	                                <input type="text" placeholder="请输入联系电话" class="form-control" name="" id=""/>
                             </div>
                             
                             <label class="span2 control-label">社保机构名称：</label>
                              <div class="span2">
	                                <input type="text" placeholder="请输入申请人户籍" class="form-control" name="" id=""/>
                             </div>
                              <label class="span2 control-label">社保机构地址：</label>
                              <div class="span2">
	                               <input type="text" placeholder="请输入联系电话" class="form-control" name="" id=""/>
                              </div>
                        </div>
                    </form>
                </div>
      		</div>
      		
      		
      		
      	 <div class="box box-default" style="margin-top: -22px;">
      		 <div class="box-header with-border">
	          	<h3 class="box-title">
	            	<div class="dec_1"></div>
	                                               转入申请其他信息
	            </h3>
		        <div class="box-tools pull-right">
		           <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
		        </div>
	        </div>
	         <div class="box-body">
                    <form class="form-horizontal" name="myform" id="myform" method="post" action="">
                        <div class="form-group">
                             <label class="span2 control-label">调动时间：</label>
                             <div class="span2">
                                <div class="input-group date form_date" data-date="" data-link-field="borndate"
                                     data-link-format="yyyy-mm-dd">
                                    <input class="form-control" placeholder="请输入出生日期" size="18" type="text" value="">
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                                <input type="hidden" id="borndate" value=""/>
                            </div>
                             
                              <label class="span2 control-label">联系人：</label>
                              <div class="span2">
	                               <input type="text" placeholder="请输入联系电话" class="form-control" name="" id=""/>
                              </div>
                        </div>
                        <div class="form-group">
                             <label class="span2 control-label">移动电话：</label>
                              <div class="span2">
	                                <input type="text" placeholder="请输入联系电话" class="form-control" name="" id=""/>
                             </div>
                             
                             <label class="span2 control-label">固定电话：</label>
                              <div class="span2">
	                                <input type="text" placeholder="请输入申请人户籍" class="form-control" name="" id=""/>
                             </div>
                        </div>
                    </form>
                </div>
      		</div>
      		
      		
      		<div class="box box-default" style="margin-top: -22px;">
      		 <div class="box-header with-border">
	          	<h3 class="box-title">
	            	<div class="dec_1"></div>
	                                              转入退款信息设置
	            </h3>
		        <div class="box-tools pull-right">
		           <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
		        </div>
	        </div>
	         <div class="box-body">
                    <form class="form-horizontal" name="myform" id="myform" method="post" action="">
                        <div class="form-group">
                              <label class="span3 control-label">转入原因：</label>
                              <div class="span2">
	                                <select name="show" class="form-control selectpicker">
	                                    <option value="1">请您选择...</option>
	                                    <option value="0">...</option>
	                                </select>
                             </div>
                             
                              <label class="span2 control-label">原个人编号(养老)：</label>
                              <div class="span2">
	                                <select name="show" class="form-control selectpicker">
	                                    <option value="1">请您选择...</option>
	                                    <option value="0">...</option>
	                                </select>
                             </div>
                        </div>
                        <div class="form-group">
                             <label class="span3 control-label">是否曾在转出机关失业单位参保：</label>
                              <div class="span2">
	                                <select name="show" class="form-control selectpicker">
	                                    <option value="1">请您选择...</option>
	                                    <option value="0">...</option>
	                                </select>
                             </div>
                             
                              <label class="span2 control-label">是否需要退款：</label>
                              <div class="span2">
	                                <select name="show" class="form-control selectpicker">
	                                    <option value="1">请您选择...</option>
	                                    <option value="0">...</option>
	                                </select>
                             </div>
                        </div>
                        
                        
                        <div class="form-group">
                             <label class="span3 control-label">退款类型：</label>
                              <div class="span2">
	                                <select name="show" class="form-control selectpicker">
	                                    <option value="1">请您选择...</option>
	                                    <option value="0">...</option>
	                                </select>
                             </div>
                             
                              <label class="span2 control-label">开户名：</label>
                              <div class="span2">
	                               <input type="text" placeholder="请输入申请人户籍" class="form-control" name="" id=""/>
                             </div>
                        </div>
                        
                        <div class="form-group">
                             <label class="span3 control-label">银行名称：</label>
                              <div class="span2">
	                                <select name="show" class="form-control selectpicker">
	                                    <option value="1">请您选择...</option>
	                                    <option value="0">...</option>
	                                </select>
                             </div>
                             
                              <label class="span2 control-label">银行账户：</label>
                              <div class="span2">
	                               <input type="text" placeholder="请输入申请人户籍" class="form-control" name="" id=""/>
                             </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="span3 control-label">备注：</label>
                            <div class="span8">
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
							  <li><a href="#">查询医疗信息</a></li>
							  <li><a href="#">单位基本信息</a></li>
							  <li><a href="#">个人基本信息</a></li>
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

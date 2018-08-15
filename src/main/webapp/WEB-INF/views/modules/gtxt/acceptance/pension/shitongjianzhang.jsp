<%--
  Created by IntelliJ IDEA.
  User: cxd
  Date: 2016/10/20
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html style="height: 100%;">
<head>
    <title>养老业务|视同建账</title>
    <meta name="decorator" content="yhdefault"/>
    <style>
        html, body {
            padding: 5px;
            height: 100%;
            min-height: 100%;
        }

        .form .ul-form {
            margin: 0;
            overflow: hidden;
        }

        .form .ul-form li {
            float: left;
            list-style: none;
        }

        .form .ul-form li>div {
            float: right;
            /*width: 179px;*/
            min-width: 179px;
        }

        .form .ul-form li label {
            /*width: 110px;*/
            min-width: 90px;
            text-align: right;
            line-height: 34px;
        }

        .form .ul-form li span label {
            width: auto;
        }

        .form .ul-form li.clearfix {
            float: none;
        }

        .form .ul-form li.btns {
            padding-left: 10px;
        }

        .form .ul-form li.btns .btn {
            margin-right: 5px;
        }
    </style>
</head>
<body>
<div>
    <%--<nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-2">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <span class="navbar-brand">视同建账</span>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <div class="btn">
                            <label class="checkbox-inline">
                                <input type="checkbox" name="xietong" id="xietong" value="1">
                                是否协同
                            </label>
                        </div>
                    </div>
                    <button type="submit" class="btn yellow">提交</button>
                </form>
            </div>
        </div>
    </nav>--%>
    <div class="row">
        <div class="span12">
            <div class="bs-callout bs-callout-info" style=" padding: 5px; margin: 0 0 10px 0; line-height: 30px;">
                <div class="row">
                    <div class="span2">
                        <span class="navbar-brand">视同建账</span>
                    </div>
                    <div class="span10">
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <div class="btn yellow">
                                    <label class="checkbox-inline">
                                        <input type="checkbox" name="xietong" id="xietong" value="1">
                                        是否协同
                                    </label>
                                </div>
                            </div>
                            <button type="submit" class="btn yellow">提交</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="span12">
            <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        查询条件
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    </div>
                </div>
                <div class="box-body">
                    <form class="form-horizontal" name="myform" method="post" action="">
                        <div class="form-group">
                            <label class="col-xs-1-5 control-label">统筹区编码：</label>
                            <div class="span2">
                                <select name="content" class="form-control selectpicker">
                                    <option value="0">...</option>
                                </select>
                            </div>
                            <label class="col-xs-1-5 control-label">姓名：</label>
                            <div class="span2">
                                <input type="text" placeholder="请输入姓名" class="form-control" name="aac003" id="aac003"/>
                            </div>
                            <div class="span1"></div>
                            <div class="span3">
                                <button type="button" class="btn yellow">查询(S)</button>
                                <button type="reset" class="btn gray" id="resetButton1">重置(R)</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-1-5 control-label">社保编号：</label>
                            <div class="span2">
                                <input type="text" placeholder="请输入社保编号" class="form-control" name="bec063"
                                       id="bec063"/>
                            </div>
                            <label class="col-xs-1-5 control-label">身份证号：</label>
                            <div class="span2">
                                <input type="text" placeholder="请输入身份证号" class="form-control" name="aab004"
                                       id="aab004"/>
                            </div>
                        </div>
                    </form>
                    <form class="form" style=" margin: 0; border: 0;">
                        <ul class="ul-form" style="">
                            <c:forEach begin="0" end="10" varStatus="status">
                                <li>
                                    <label class="col-md-2 control-label">姓名${status.index}：</label>
                                    <div class="col-md-3 control-div">
                                        <input class="form-control" type="text" placeholder="请输入姓名${status.index}"
                                               name="aac003${status.index}"
                                               id="aac003${status.index}"/>
                                    </div>
                                </li>
                            </c:forEach>
                            <c:forEach begin="0" end="10" varStatus="status">
                                <li>
                                    <label class="col-md-2 control-label">你猜${status.index}：</label>
                                    <div class="col-md-3 control-div">
                                        <select name="content" class="form-control selectpicker">
                                            <option value="${status.index}">你猜${status.index}</option>
                                        </select>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </form>
                </div>
            </div>
            <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        个人基本信息
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    </div>
                </div>
                <div class="box-body">
                    <form class="form-horizontal" name="myform" method="post" action="">
                        <div class="form-group">
                            <label class="col-xs-1-5 control-label">社保编号：</label>
                            <div class="span2">
                                <input type="text" class="form-control" name="bec063" id="bec063"/>
                            </div>
                            <label class="col-xs-1-5 control-label">姓名：</label>
                            <div class="span2">
                                <input type="text" class="form-control" name="aab004" id="aab004"/>
                            </div>
                            <label class="col-xs-1-5 control-label">证件号码：</label>
                            <div class="span2">
                                <input type="text" class="form-control" name="aab005" id="aab005"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-1-5 control-label">性别：</label>
                            <div class="span2">
                                <input type="text" class="form-control" name="bec063"/>
                            </div>
                            <label class="col-xs-1-5 control-label">民族：</label>
                            <div class="span2">
                                <input type="text" class="form-control" name="aab004"/>
                            </div>
                            <label class="col-xs-1-5 control-label">出生日期：</label>
                            <div class="span2">
                                <input type="text" class="form-control" name="aab005"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-1-5 control-label">移动电话：</label>
                            <div class="span2">
                                <input type="text" class="form-control" name="bec063"/>
                            </div>
                            <label class="col-xs-1-5 control-label">固定电话：</label>
                            <div class="span2">
                                <input type="text" class="form-control" name="aab004"/>
                            </div>
                            <label class="col-xs-1-5 control-label">参加工作日期：</label>
                            <div class="span2">
                                <input type="text" class="form-control" name="aab005"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-1-5 control-label">家庭地址：</label>
                            <div class="span2">
                                <input type="text" class="form-control" name="bec063"/>
                            </div>
                            <label class="col-xs-1-5 control-label">所属区：</label>
                            <div class="span2">
                                <input type="text" class="form-control" name="aab004"/>
                            </div>
                            <label class="col-xs-1-5 control-label">生存状态：</label>
                            <div class="span2">
                                <input type="text" class="form-control" name="aab005"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-xs-1-5 control-label">医保类型：</label>
                            <div class="span2">
                                <input type="text" class="form-control" name="bec063"/>
                            </div>
                            <label class="col-xs-1-5 control-label">养老离退休标志：</label>
                            <div class="span2">
                                <input type="text" class="form-control" name="aab004"/>
                            </div>
                            <label class="col-xs-1-5 control-label">省个人识别号：</label>
                            <div class="span2">
                                <input type="text" class="form-control" name="aab005"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div>
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active">
                        <a href="#shitonggonglingshenbao" role="tab" data-toggle="tab">视同工龄申报</a>
                    </li>
                    <li role="presentation">
                        <a href="#shitongjianzhangshengcheng" role="tab" data-toggle="tab">视同建账生成</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="shitonggonglingshenbao">
                        <div class="box-body">
                            <div class="box box-default">
                                <div class="box-header with-border">
                                    <h3 class="box-title">
                                        <div class="dec_1"></div>
                                        人员认定信息
                                    </h3>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body">
                                    <form class="form-horizontal" name="myform" id="myform" method="post" action="">
                                        <div class="form-group">
                                            <%--
                                                BIC086	群体类别	101	一般人群
                                                BIC086	群体类别	102	特殊人群
                                            --%>
                                            <label class="col-xs-1-5 control-label">群体类别：</label>
                                            <div class="span2">
                                                <select name="bic086" class="form-control selectpicker">
                                                    <option value="101">一般人群</option>
                                                    <option value="102">特殊人群</option>
                                                </select>
                                            </div>
                                            <%--
                                                AAC013	用工形式	7	省内农合工
                                                AAC013	用工形式	5	聘用离退休人员
                                                AAC013	用工形式	6	其他用工
                                                AAC013	用工形式	1	固定工
                                                AAC013	用工形式	2	城合工
                                                AAC013	用工形式	3	临时工
                                                AAC013	用工形式	4	外省农合工
                                            --%>
                                            <label class="col-xs-1-5 control-label">用工形式：</label>
                                            <div class="span2">
                                                <select name="content" class="form-control selectpicker">
                                                    <option value="1">固定工</option>
                                                    <option value="2">城合工</option>
                                                    <option value="3">临时工</option>
                                                    <option value="4">外省农合工</option>
                                                    <option value="5">聘用离退休人员</option>
                                                    <option value="6">其他用工</option>
                                                    <option value="7">省内农合工</option>
                                                </select>
                                            </div>
                                            <label class="col-xs-1-5 control-label"><b
                                                    class="mr5 red500">*</b>建账基数：</label>
                                            <div class="span2">
                                                <input type="number" class="form-control" name="bic085"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-1-5 control-label">统账结合截止时间：</label>
                                            <div class="span2">
                                                <div class="input-group date form_date" data-date="" data-date-format=""
                                                     data-link-format="yyyy-MM-dd">
                                                    <input class="form-control" size="16" type="text" value=""
                                                           readonly/>
                                                    <span class="input-group-addon"><i
                                                            class="glyphicon glyphicon-remove"></i></span>
                                                    <span class="input-group-addon"><i
                                                            class="glyphicon glyphicon-calendar"></i></span>
                                                </div>
                                            </div>
                                            <%--
                                                特殊群体分类	1004	参照依照公务员管理的事业单位工作人员
                                                特殊群体分类	1002	转业干部、转业士官
                                                特殊群体分类	1001	退伍义务兵、复员干部
                                                特殊群体分类	1003	机关单位工作人员调入企业和机构改革后分流或流动到企业
                                            --%>
                                            <label class="col-xs-1-5 control-label">特殊群体分类：</label>
                                            <div class="span2">
                                                <select name="bic089" class="form-control selectpicker">
                                                    <option value="1004">参照依照公务员管理的事业单位工作人员</option>
                                                    <option value="1002">转业干部、转业士官</option>
                                                    <option value="1001">退伍义务兵、复员干部</option>
                                                    <option value="1003">机关单位工作人员调入企业和机构改革后分流或流动到企业</option>
                                                </select>
                                            </div>
                                            <label class="col-xs-1-5 control-label">12月前平均工资：</label>
                                            <div class="span2">
                                                <input type="number" class="form-control" name="bic087"/>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="box box-default">
                                <div class="box-header with-border">
                                    <h3 class="box-title">
                                        <div class="dec_1"></div>
                                        视同工作年限
                                    </h3>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body">
                                    <div class="row">
                                        <div class="span12">
                                            <button class="btn btn-xs yellow" id="addgzjlbtn">添加</button>
                                            <button class="btn btn-xs yellow" id="delgzjlbtn">删除</button>
                                        </div>
                                    </div>
                                    <form class="form-horizontal" id="gzjldate" method="post" action="">
                                        <table class="table table-bordered table-striped table-hover tablesorter"
                                               id="dynamic_pager_content" data-resizable-columns-id="table2"
                                               style="margin-bottom: 0;">
                                            <thead>
                                            <tr>
                                                <th data-resizable-column-id="" width="80px">
                                                    <label class="checkbox-inline">
                                                        <input type="checkbox" id="select_all" value="option1"></label>
                                                </th>
                                                <th data-resizable-column-id="" width="120px">编号</th>
                                                <th data-resizable-column-id="" width="200px">开始时间</th>
                                                <th data-resizable-column-id="" width="200px">结束时间</th>
                                                <th data-resizable-column-id=""></th>
                                            </tr>
                                            </thead>
                                            <tbody id="gzjllist">
                                            </tbody>
                                        </table>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="shitongjianzhangshengcheng">
                        <div class="box-body">
                            <form class="form-horizontal" name="myform" id="myform" method="post" action="">
                                <div class="form-group">
                                    <center>
                                        <div class="center-block">
                                            <button type="button" class="btn yellow">计算视同建账信息</button>
                                        </div>
                                    </center>
                                </div>
                            </form>
                            <div class="box box-default">
                                <div class="box-header with-border">
                                    <h3 class="box-title">
                                        <div class="dec_1"></div>
                                        补记额
                                    </h3>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body">
                                    <form class="form-horizontal" name="myform" method="post" action="">
                                        <table class="table table-bordered table-striped table-hover tablesorter"
                                               id="dynamic_pager_content" data-resizable-columns-id="table2"
                                               style="margin-bottom: 0;">
                                            <thead>
                                            <tr>
                                                <th>编号</th>
                                                <th>缴费时段</th>
                                                <th>截至2015年末补记本息</th>
                                                <th>备注</th>
                                                <th></th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                        <div class="row">
                                            <div class="span5"></div>
                                            <div class="span7">
                                                <div class="pull-right">
                                                    <div class="pageinfo">
                                                        <span class="mr15" 共<span
                                                            class="blue_data mlr5">80</span>条数据 </span>
                                                        <div id="dropdown_t>o_select" class="dropdown itempp">
                                                            <span class="btn-group">
                                                                <a data-toggle="dropdown" type="button"
                                                                   id="dropdownMenu1"
                                                                   class="btn btn-default btn-xs dropdown-toggle">
                                                                    <span class="placeholder">8</span>
                                                                </a>
                                                                <ul class="dropdown-menu" role="menu"
                                                                    aria-labelledby="dropdownMenu1">
                                                                  <li role="presentation" value="1">
                                                                      <a role="menuitem"
                                                                         href="javascript:void(0);">5</a>
                                                                  </li>
                                                                  <li role="presentation" value="2">
                                                                      <a role="menuitem"
                                                                         href="javascript:void(0);">10</a>
                                                                  </li>
                                                                  <li role="presentation" value="3">
                                                                      <a role="menuitem"
                                                                         href="javascript:void(0);">15</a>
                                                                  </li>
                                                                  <li role="presentation" value="4">
                                                                      <a role="menuitem"
                                                                         href="javascript:void(0);">20</a>
                                                                  </li>
                                                                </ul>
                                                            </span>
                                                        </div>
                                                        <span class="mr15">条/页</span> <span class="mr5">1/10</span>
                                                    </div>
                                                    <span id="page_selection"></span>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="box box-default">
                                <div class="box-header with-border">
                                    <h3 class="box-title">
                                        <div class="dec_1"></div>
                                        补齐额
                                    </h3>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body">
                                    <form class="form-horizontal" name="myform" method="post" action="">
                                        <table class="table table-bordered table-striped table-hover tablesorter"
                                               id="dynamic_pager_content" data-resizable-columns-id="table2"
                                               style="margin-bottom: 0;">
                                            <thead>
                                            <tr>
                                                <th>编号</th>
                                                <th>缴费时段</th>
                                                <th>缴费工资</th>
                                                <th>个人实际缴费</th>
                                                <th>补齐额</th>
                                                <th>缴费比例</th>
                                                <th>截至2015年末补齐本息</th>
                                                <th>备注</th>
                                                <th></th>
                                            </tr>
                                            </thead>
                                            <tbody>
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
                                            </tr>
                                            </tbody>
                                        </table>
                                        <div class="row">
                                            <div class="span5"></div>
                                            <div class="span7">
                                                <div class="pull-right">
                                                    <div class="pageinfo">
                                                        <span class="mr15"> 共<span
                                                            class="blue_data mlr5">80</span>条数据 </span>
                                                        <div id="dropdown_t>o_select" class="dropdown itempp">
                                                            <span class="btn-group">
                                                                <a data-toggle="dropdown" type="button"
                                                                   id="dropdownMenu1"
                                                                   class="btn btn-default btn-xs dropdown-toggle">
                                                                    <span class="placeholder">8</span>
                                                                </a>
                                                                <ul class="dropdown-menu" role="menu"
                                                                    aria-labelledby="dropdownMenu1">
                                                                  <li role="presentation" value="1">
                                                                      <a role="menuitem"
                                                                         href="javascript:void(0);">5</a>
                                                                  </li>
                                                                  <li role="presentation" value="2">
                                                                      <a role="menuitem"
                                                                         href="javascript:void(0);">10</a>
                                                                  </li>
                                                                  <li role="presentation" value="3">
                                                                      <a role="menuitem"
                                                                         href="javascript:void(0);">15</a>
                                                                  </li>
                                                                  <li role="presentation" value="4">
                                                                      <a role="menuitem"
                                                                         href="javascript:void(0);">20</a>
                                                                  </li>
                                                                </ul>
                                                            </span>
                                                        </div>
                                                        <span class="mr15">条/页</span> <span class="mr5">1/10</span>
                                                    </div>
                                                    <span id="page_selection"></span>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="box box-default">
                                <div class="box-header with-border">
                                    <h3 class="box-title">
                                        <div class="dec_1"></div>
                                        异地转入缴费账户
                                    </h3>
                                    <div class="box-tools pull-right">
                                        <button class="btn btn-box-tool" data-widget="collapse"><i
                                                class="fa fa-minus"></i></button>
                                    </div>
                                </div>
                                <div class="box-body">
                                    <form class="form-horizontal" name="myform" method="post" action="">
                                        <div class="form-group">
                                            <label class="col-xs-1-5 control-label">转入时间：</label>
                                            <div class="span2">
                                                <div class="input-group date form_date" data-date="" data-date-format="yyyy-MM-dd">
                                                    <input class="form-control" size="16" type="text" readonly/>
                                                    <span class="input-group-addon"><i
                                                            class="glyphicon glyphicon-remove"></i></span>
                                                    <span class="input-group-addon"><i
                                                            class="glyphicon glyphicon-calendar"></i></span>
                                                </div>
                                            </div>
                                            <label class="col-xs-1-5 control-label">转入视同缴费月数：</label>
                                            <div class="span2">
                                                <input type="text" placeholder="请输入转入视同缴费月数" class="form-control"
                                                       name="aac003" id="aac003"/>
                                            </div>
                                            <label class="col-xs-1-5 control-label">转入省份：</label>
                                            <div class="span2">
                                                <input type="text" placeholder="请输入转入省份" class="form-control"
                                                       name="aac003" id="aac003"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-1-5 control-label">开始时间：</label>
                                            <div class="span2">
                                                <div class="input-group date form_date" data-date="" data-date-format=""
                                                     data-link-field="bee023" data-link-format="yyyy-MM-dd">
                                                    <input class="form-control" size="16" type="text" value=""
                                                           readonly/>
                                                    <span class="input-group-addon"><i
                                                            class="glyphicon glyphicon-remove"></i></span>
                                                    <span class="input-group-addon"><i
                                                            class="glyphicon glyphicon-calendar"></i></span>
                                                </div>
                                                <input type="hidden" id="bee023" value=""/>
                                            </div>
                                            <label class="col-xs-1-5 control-label">结束时间：</label>
                                            <div class="span2">
                                                <div class="input-group date form_date" data-date="" data-date-format=""
                                                     data-link-field="bee023" data-link-format="yyyy-MM-dd">
                                                    <input class="form-control" size="16" type="text" value=""
                                                           readonly/>
                                                    <span class="input-group-addon"><i
                                                            class="glyphicon glyphicon-remove"></i></span>
                                                    <span class="input-group-addon"><i
                                                            class="glyphicon glyphicon-calendar"></i></span>
                                                </div>
                                                <input type="hidden" id="bee023" value=""/>
                                            </div>
                                            <label class="col-xs-1-5 control-label">转入金额：</label>
                                            <div class="span2">
                                                <input type="text" class="form-control" name="bec063" id="bec063"/>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(function () {
        $("table").resizableColumns({});
        flushCheckBox();
        $('#select_all').on('ifChecked', function (event) {
            $('input[name=myselect]').iCheck('check');
        });
        $('#select_all').on('ifUnchecked', function (event) {
            $('input[name=myselect]').iCheck('uncheck');
        });
        //下拉选框
//        $('.selectpicker').selectpicker({
//            //style: 'btn-info',
//            //size: 4
//        });
        flushDateTime();
        var tpl = $("#gongzuoTem").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
        $("#addgzjlbtn").click(function () {
            $("#gzjllist").append(Mustache.render(tpl));
            flushCheckBox();
            flushDateTime();
            var gzjl = $("#gzjldate").serializeJson();
            console.log(gzjl);
        });
        $("#delgzjlbtn").click(function () {
            $("#gzjllist input[name=myselect]:checked").parent().parent().parent().parent().remove();
        });


    });
    $(document).ready(function () {
        $('#page_selection').bootpag({
            total: 10,
            page: 1,
            maxVisible: 5,
            leaps: true,
            firstLastUse: true,
            first: '首页',
            last: '末页',
            prev: '<i class="glyphicon glyphicon-chevron-left"></i>',
            next: '<i class="glyphicon glyphicon-chevron-right"></i>',
            wrapClass: 'pagination pagination-sm',
            activeClass: 'active',
            disabledClass: 'disabled',
            nextClass: 'next',
            prevClass: 'prev',
            lastClass: 'last',
            firstClass: 'first'
        }).on('page', function (event, num) {
            $("#dynamic_pager_content").html("Page " + num + " content here");
        });

        $('#myform').bootstrapValidator({
            container: 'tooltip',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
//                        name: {
//                            //selector: '#name',
//                            validators: {
//                                notEmpty: {
//                                    message: '姓名不能为空'
//                                },
//                                regexp: {
//                                    regexp: /^[\u4E00-\u9FA5]{2,10}$/,
//                                    message: '姓名不是中文或姓名长度有误'
//                                }
//                            }
//                        },
                aac002: {
//                            selector: '#idcard',
                    validators: {
                        notEmpty: {
                            message: '身份证号码不能为空'
                        },
                        regexp: {
                            regexp: /(^\d{15}$)|(^\d{17}([0-9]|X|x)$)/,
                            message: '身份证号码不正确'
                        }
                    }
                }//,
//                        phone: {
//                            //selector: '#phone',
//                            validators: {
//                                digits: {
//                                    message: '手机号只能为数字'
//                                },
//                                notEmpty: {
//                                    message: '手机号不能为空'
//                                }
//                            }
//                        },
                /*validatecode: {
                 //selector: '#validatecode',
                 validators: {
                 notEmpty: {
                 message: '验证码不能为空'
                 },
                 regexp: {
                 regexp: /^\d{6}$/,
                 message: '验证码格式不正确'
                 }
                 }
                 },*/
//                        content: {
//                            //selector: '#content',
//                            validators: {
//                                notEmpty: {
//                                    message: '内容不能为空'
//                                }
//                            }
//                        }

            }
        }).on('error.field.bv', function (e, data) {
            // Get the tooltip
            var $parent = data.element.parents('.form-group'),
                    $icon = $parent.find('.form-control-feedback[data-bv-icon-for="' + data.field + '"]'),
                    title = $icon.data('bs.tooltip').getTitle();

            // Destroy the old tooltip and create a new one positioned to the right
            $icon.tooltip('destroy').tooltip({
                html: true,
                placement: 'bottom',
                title: title,
                container: 'body'
            });
        });

        // Reset the Tooltip container form
        $('#resetButton').on('click', function (e) {
            var fields = $('#myform').data('bootstrapValidator').getOptions().fields,
                    $parent, $icon;

            for (var field in fields) {
                $parent = $('[name="' + field + '"]').parents('.form-group');
                $icon = $parent.find('.form-control-feedback[data-bv-icon-for="' + field + '"]');
                $icon.tooltip('destroy');
            }

            // Then reset the form
            $('#myform').data('bootstrapValidator').resetForm(true);
        });
    });
    function flushCheckBox() {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square_gd',
            radioClass: 'iradio_square_gd',
            increaseArea: '20%' // optional
        });
    }
    function flushDateTime() {
        //日期插件
        $('.form_date').datetimepicker({
            language: 'zh-CN',
            format: "yyyy-mm-dd",
            weekStart: 1,
            todayBtn: 1,
            autoclose: true,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: true,
            pickerPosition: 'bottom-left'
        });
    }
</script>
<script type="text/template" id="gongzuoTem">
    <tr class="gzjl">
        <td>
            <label class="checkbox-inline">
                <input type="checkbox" name="myselect" value="option1">
            </label>
        </td>
        <td>
            <input type="text"/>
        </td>
        <td>
            <div class="input-group date form_date" data-date="" data-date-format="" data-link-format="yyyy-MM-dd">
                <input class="form-control" type="text" name="startDate" readonly/>
                <span class="input-group-addon"><i
                        class="glyphicon glyphicon-remove"></i></span>
                <span class="input-group-addon"><i
                        class="glyphicon glyphicon-calendar"></i></span>
            </div>
        </td>
        <td>
            <div class="input-group date form_date" data-date="" data-date-format="" data-link-format="yyyy-MM-dd">
                <input class="form-control" type="text" name="endtDate" readonly/>
                <span class="input-group-addon"><i
                        class="glyphicon glyphicon-remove"></i></span>
                <span class="input-group-addon"><i
                        class="glyphicon glyphicon-calendar"></i></span>
            </div>
        </td>
        <td>
            <input type="text" name="bh"/>
        </td>
    </tr>
</script>
</body>
</html>

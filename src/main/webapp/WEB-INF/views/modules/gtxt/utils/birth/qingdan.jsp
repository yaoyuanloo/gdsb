<%--
  Created by IntelliJ IDEA.
  User: cxd
  Date: 2016/9/7
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>清单录入</title>
    <meta name="decorator" content="default"/>
    <style>
        tr td {
            padding: 0;
            margin: 0;
        }

        .tablehead td{
            font-weight: bold;
            text-align: center;
        }

        #totalTable .tablehead td{
            width: 30px;
        }

        .thumbnail {
            height: 60px;
            width: 80px;
            /*padding: 3px;*/
        }

        .slt {
            height: 100%;
        }

        .myinput {
            padding: 0;
            margin: 0;
            border: 0;
            width: 100%;
            background: red;
            height: 100%;
        }
    </style>
</head>
<body style="overflow-x: hidden;">
<div class="accordion-group">
    <div class="accordion-heading">
        <a class="accordion-toggle" data-toggle="collapse" href="#collapseOne"
           style="text-align: center; font-size: 18px;">
            总单
        </a>
    </div>
    <div id="collapseOne" class="accordion-body collapse in">
        <div class="accordion-inner" style="padding: 0;">
            <table id="totalTable" class="table table-bordered table-condensed">
                <tr class="tablehead">
                    <td rowspan="3" style="width: 100px;"></td>
                    <td rowspan="3">自费</td>
                    <td colspan="10">床位费</td>
                    <td rowspan="3">超封顶</td>
                    <td rowspan="3">合计</td>
                </tr>
                <tr class="tablehead">
                    <td colspan="2">普通病房</td>
                    <td colspan="2">层流洁净病房</td>
                    <td colspan="2">层流简易病房</td>
                    <td colspan="2">监护病房</td>
                    <td colspan="2">特殊防护病房</td>
                </tr>
                <tr class="tablehead">
                    <td>天数</td>
                    <td>金额</td>
                    <td>天数</td>
                    <td>金额</td>
                    <td>天数</td>
                    <td>金额</td>
                    <td>天数</td>
                    <td>金额</td>
                    <td>天数</td>
                    <td>金额</td>
                </tr>
                <tr>
                    <td style="text-align: center; font-weight: bold;">
                        费用合计
                    </td>
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
                    <td></td>
                </tr>
                <tr>
                    <td style="text-align: center; font-weight: bold;">
                        不予支付
                    </td>
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
                    <td></td>
                </tr>
            </table>
        </div>
    </div>
</div>
<div class="accordion-group">
    <div class="accordion-heading">
        <a class="accordion-toggle" data-toggle="collapse" href="#collapseTwo"
           style="text-align: center; font-size: 18px;">
            清单录入
        </a>
    </div>
    <div id="collapseTwo" class="accordion-body collapse in">
        <div class="accordion-inner" style="padding: 0;">
        </div>
        <table class="table table-bordered table-condensed">
            <tr class="tablehead">
                <td style="width: 30px;">
                    序号
                </td>
                <td style="width: 60px;">
                    缩略图
                </td>
                <td style="width: 210px;">
                    清单名称
                </td>
                <td style="width: 100px;">
                    金额
                </td>
                <td>
                    备注
                </td>
                <td style="width: 40px;">
                    操作
                </td>
            </tr>
            <tr>
                <td style="text-align: center; vertical-align: middle;">1</td>
                <td>
                    <div class="thumbnail">
                        <a href="javascript:void(0);" onclick="qingdan()"><img src="/imgs/1.jpg" alt="" class="slt"/></a>
                    </div>
                </td>
                <td style="padding: 0;">
                    <select style="width: 200px; margin: 0;">
                        <option value="2">自费</option>
                        <option value="11">床位费-普通病房</option>
                        <option value="12">床位费-层流洁净病房</option>
                        <option value="13">床位费-层流简易病房</option>
                        <option value="14">床位费-监护病房</option>
                        <option value="15">床位费-特殊防护病房</option>
                        <option value="16">超封顶</option>
                    </select>
                </td>
                <td style="padding: 0;">
                    <input type="number" style="width: 100px; margin: 0;" min="0" />
                </td>
                <%--<td style="padding: 0; margin: 0;"><input type="text" style="text-align: center; height: 100%; width: 100%; margin: 0; padding: 0;"  /></td>--%>
                <td style="padding: 0; margin: 0;"><textarea style="width: 100%; height: 100%; margin: 0; padding: 0; resize: none;"></textarea></td>
                <td>
                    <div class="btn-group">
                        <a href="#" class="btn btn-small">保存</a>
                    </div>
                </td>
            </tr>
            <tr>
                <td style="text-align: center; vertical-align: middle;">2</td>
                <td>
                    <div class="thumbnail">
                        <a href="javascript:void(0);" onclick="qingdan()"><img src="/imgs/2.jpg" alt="" class="slt"/></a>
                    </div>
                </td>
                <td style="padding: 0;">
                    <select style="width: 200px; margin: 0;">
                        <option value="2">自费</option>
                        <option value="11">床位费-普通病房</option>
                        <option value="12">床位费-层流洁净病房</option>
                        <option value="13">床位费-层流简易病房</option>
                        <option value="14">床位费-监护病房</option>
                        <option value="15">床位费-特殊防护病房</option>
                        <option value="16">超封顶</option>
                    </select>
                </td>
                <td style="padding: 0;">
                    <input type="number" style="width: 100px; margin: 0;" min="0" />
                </td>
                <%--<td style="padding: 0; margin: 0;"><input type="text" style="text-align: center; height: 100%; width: 100%; margin: 0; padding: 0;"  /></td>--%>
                <td style="padding: 0; margin: 0;"><textarea style="width: 100%; height: 100%; margin: 0; padding: 0; resize: none;"></textarea></td>
                <td>
                    <div class="btn-group">
                        <a href="#" class="btn btn-small">保存</a>
                    </div>
                </td>
            </tr>
        </table>
        </div>
    </div>
</body>
</html>

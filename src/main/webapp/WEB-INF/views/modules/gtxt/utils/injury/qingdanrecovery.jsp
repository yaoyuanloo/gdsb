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
    <title>工伤康复清单录入</title>
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
                    <td></td>
                    <td>康复总费用</td>
                    <td>药费</td>
                    <td>手术费</td>
                    <td>检查费</td>
                    <td>治疗费</td>
                    <td>自费</td>
                    <td>不合理药</td>
                    <td>不合理治疗费</td>
                    <td>不合理手术费</td>
                    <td>其他不予支付费用</td>
                    <td>不予支付费用小计</td>
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
                        <option value="1">康复总费用</option>
                        <option value="2">药费</option>
                        <option value="3">手术费</option>
                        <option value="4">检查费</option>
                        <option value="5">治疗费</option>
                        <option value="6">自费</option>
                        <option value="11">不合理药</option>
                        <option value="12">不合理治疗费</option>
                        <option value="13">不合理手术费</option>
                        <option value="16">其他不予支付费用</option>
                        <option value="16">不予支付费用小计</option>
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
                        <option value="1">康复总费用</option>
                        <option value="2">药费</option>
                        <option value="3">手术费</option>
                        <option value="4">检查费</option>
                        <option value="5">治疗费</option>
                        <option value="6">自费</option>
                        <option value="11">不合理药</option>
                        <option value="12">不合理治疗费</option>
                        <option value="13">不合理手术费</option>
                        <option value="16">其他不予支付费用</option>
                        <option value="16">不予支付费用小计</option>
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

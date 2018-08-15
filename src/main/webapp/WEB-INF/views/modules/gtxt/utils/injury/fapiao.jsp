<%--
  Created by IntelliJ IDEA.
  User: cxd
  Date: 2016/9/7
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>发票录入</title>
    <meta name="decorator" content="default"/>
    <style>
        tr td {
            padding: 0;
            margin: 0;
        }

        .thumbnail {
            height: 40px;
            width: 50px;
            /*padding: 3px;*/
        }

        .slt {
            height: 100%;
        }

        .tablehead td {
            text-align: center;
            word-wrap: break-word;
            word-break: normal;
            font-weight: bold;
        }

        /*.tablehead td:first-child {
            height: 60px;
            width: 60px;
            padding: 3px;
        }*/

        .myinput {
            padding: 0;
            margin: 0;
            border: 0;
            width: 100%;
            background: red;
            height: 100%;
        }

        .selectWidth {
            width: 164px;
        }

        .inputWidth {
            width: 150px;
        }
    </style>
</head>
<body>
<div id="searchForm" class="breadcrumb form-search" style=" margin: 0; border: 0;">
    <ul class="ul-form">
        <li><label>入院日期：</label>
            <input name="starthospitaldate" type="text" readonly="readonly"
                   maxlength="20" class="input-mini Wdate"
                   value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                   style="width: 150px;"/>
        </li>
        <li><label>出院日期：</label>
            <input name="endhospitaldate" type="text" readonly="readonly"
                   maxlength="20" class="input-mini Wdate"
                   value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                   style="width: 150px;"/>
        </li>
        <li><label for="firsthospital">首诊医院：</label>
            <select id="firsthospital" name="firsthospital" class="input-medium selectWidth">
                <option value="0">非首选</option>
                <option value="1">首选</option>
            </select>
        </li>
        <li>
            <label>医疗机构：</label>
            <sys:treeselect id="hospital" name="hospital.code" value="${work.fenqu.code}"
                            labelName="fenqu.name"
                            labelValue="${work.fenqu.name}" notAllowSelectParent="false"
                            title="医疗机构" url="/xq/area/treeData" cssClass="input-small"
                            cssStyle="width: 105px;"
                            allowClear="true"/>
        </li>
        <li><label for="sqr">医院等级：</label>
            <select id="sqr" name="sqr" class="input-medium selectWidth">
                <option value="1">1</option>
                <option value="2">2</option>
            </select>
        </li>
        <li><label for="firstpay">报销类型：</label>
            <select id="firstpay" name="firstpay" class="input-medium selectWidth">
                <option value="1">门诊</option>
                <option value="2">住院</option>
            </select>
        </li>
        <li class="clearfix"></li>
    </ul>
</div>
<table class="table table-bordered table-condensed">
    <tr class="tablehead">
        <td rowspan="2" style="width: 80px;">发票共 <span style="color: red;">3</span> 张</td>
        <td colspan="3">医药费</td>
        <td colspan="3">诊查费</td>
        <td colspan="3">治疗费</td>
        <td colspan="3">其他</td>
        <td rowspan="2">总计</td>
    </tr>
    <tr class="tablehead">
        <td>西药</td>
        <td>中成药</td>
        <td>中草药</td>
        <td>检验费</td>
        <td>检查费</td>
        <td>诊查费</td>
        <td>手术费</td>
        <td>材料费</td>
        <td>治疗费</td>
        <td>床位费</td>
        <td>护理费</td>
        <td>其他</td>
    </tr>
    <tr>
        <td style="text-align: center; font-weight: bold;">
            合计
        </td>
        <td style="padding: 0; margin: 0;"><input type="text" readonly="readonly" style="height: 100%; width: 100%; margin: 0; border: 0; padding: 0;"  /></td>
        <td style="padding: 0; margin: 0;"><input type="text" readonly="readonly" style="height: 100%; width: 100%; margin: 0; border: 0; padding: 0;"  /></td>
        <td style="padding: 0; margin: 0;"><input type="text" readonly="readonly" style="height: 100%; width: 100%; margin: 0; border: 0; padding: 0;"  /></td>
        <td style="padding: 0; margin: 0;"><input type="text" readonly="readonly" style="height: 100%; width: 100%; margin: 0; border: 0; padding: 0;"  /></td>
        <td style="padding: 0; margin: 0;"><input type="text" readonly="readonly" style="height: 100%; width: 100%; margin: 0; border: 0; padding: 0;"  /></td>
        <td style="padding: 0; margin: 0;"><input type="text" readonly="readonly" style="height: 100%; width: 100%; margin: 0; border: 0; padding: 0;"  /></td>
        <td style="padding: 0; margin: 0;"><input type="text" readonly="readonly" style="height: 100%; width: 100%; margin: 0; border: 0; padding: 0;"  /></td>
        <td style="padding: 0; margin: 0;"><input type="text" readonly="readonly" style="height: 100%; width: 100%; margin: 0; border: 0; padding: 0;"  /></td>
        <td style="padding: 0; margin: 0;"><input type="text" readonly="readonly" style="height: 100%; width: 100%; margin: 0; border: 0; padding: 0;"  /></td>
        <td style="padding: 0; margin: 0;"><input type="text" readonly="readonly" style="height: 100%; width: 100%; margin: 0; border: 0; padding: 0;"  /></td>
        <td style="padding: 0; margin: 0;"><input type="text" readonly="readonly" style="height: 100%; width: 100%; margin: 0; border: 0; padding: 0;"  /></td>
        <td style="padding: 0; margin: 0;"><input type="text" readonly="readonly" style="height: 100%; width: 100%; margin: 0; border: 0; padding: 0;"  /></td>
        <td style="padding: 0; margin: 0;"><input type="text" readonly="readonly" style="height: 100%; width: 100%; margin: 0; border: 0; padding: 0;"  /></td>
    </tr>
    <tr>
        <td>
            <div class="thumbnail" style="margin: 0 auto;">
                <a href="javascript:void(0);" onclick="qingdan()"><img src="/imgs/1.jpg" alt="" class="slt"/></a>
            </div>
        </td>
        <c:forEach begin="0" end="12" >
            <td style="padding: 0; margin: 0;"><input type="text" style="text-align:center; height: 100%; width: 100%; margin: 0; border: 0; padding: 0;"  /></td>
        </c:forEach>
    </tr>
    <tr>
        <td>
            <div class="thumbnail" style="margin: 0 auto;">
                <a href="javascript:void(0);" onclick="qingdan()"><img src="/imgs/2.jpg" alt="" class="slt"/></a>
            </div>
        </td>
        <c:forEach begin="0" end="12" >
            <td style="padding: 0; margin: 0;"><input type="text" style="text-align:center;height: 100%; width: 100%; margin: 0; border: 0; padding: 0;"  /></td>
        </c:forEach>
    </tr>
    <tr>
        <td>
            <div class="thumbnail" style="margin: 0 auto;">
                <a href="javascript:void(0);" onclick="qingdan()"><img src="/imgs/3.jpg" alt="" class="slt"/></a>
            </div>
        </td>
        <c:forEach begin="0" end="12" >
            <td style="padding: 0; margin: 0;"><input type="text" style="text-align:center;height: 100%; width: 100%; margin: 0; border: 0; padding: 0;"  /></td>
        </c:forEach>
    </tr>
</table>
<script>
    function qingdan() {
        top.$.jBox.open("iframe:${ctx}/gtxt/utils/util/qingdan?type=${type}&qingdan=${qingdan}", "清单录入或修改", 1000, 600, {
            loaded: function () {
                closeTip();
//                $(".jbox-content", top.document).css("overflow-y", "hidden");
                $(".jbox-content", top.document).css("overflow-x", "hidden");
            },
            closed: function () {

            },
            opacity: 0.5,
            border: 1,
            iframeScrolling: "auto",
            persistent: true,
            buttons: {'保存': 'save'},
            submit: function (v, h, f) {
                if (v == "save") {
                    alertx("清单录入保存成功！");
                }
            }
        });
    }
</script>
</body>
</html>

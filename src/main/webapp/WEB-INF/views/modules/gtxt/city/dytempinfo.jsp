<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>f
<head>
    <title>打印模板预览页面</title>
    <meta name="decorator" content="default"/>
    <link type="text/css" href="${ctxStatic}/utf8-jsp/themes/default/css/ueditor.css">

    <style>
        #div {
            width: 100%;
            margin: 0;
            overflow-x: hidden;
            overflow-y: auto;
        }

        .nrong {
            width: 92%;
            background-color: #FDFDFD;
            border: 1px solid red;
        }

        .accordion-toggle {
            color: black;
        }

        .form-search .ul-form li label {
            width: 100px;
        }

        table {
            table-layout: fixed;
        }

        table th {
            /*width: 80px;*/

        }

        #baseTable td {
            padding: 0;
        }

        #baseTable td > input {
            padding: 0;
            margin: 0;
            border: 0;
            width: 80%;
            background: none;
            height: 28px;
        }

        #zysxTable th {
            text-align: center;
            width: 70px;
        }

        .table td i {
            margin: 4px 2px 0 2px;
        }

        .input-append .accordion-toggle {
            /*padding-left: 10px;*/
            /*padding-right: 10px;*/

        }

        .btn {
            width: 200px;
        }
    </style>
    <script type="text/javascript">

        $(document).ready(function () {
          var userinfo={name:"${gtywinfo.xm}",dnh:"${gtywinfo.dnh}"}
          var tpl = $("#slhzTemp").html();
          var view = Mustache.render(tpl,userinfo);;
          $("#slTemp").html(view);
        })
    </script>


</head>

<body>

<div id="bdiv" align="center">
    <div align="center" class="breadcrumb">
        <div style="width: 768px;" align="center">
            <div class="">
                <div>
                    <a style="font-size: 18px; line-height: 22px;">${typename}</a>
                </div>
                <table id="baseTable" class="table table-striped table-bordered table-condensed">
                    <tr>
                        <td colspan="6" style="text-align: center;">
                            <h5 style="font-size: 20px;font-family: '微软雅黑';text-align: center;line-height: 35px;">
                                基本信息
                            </h5>
                        </td>
                    </tr>
                    <tr>
                        <th width="82">姓名</th>
                        <td>
                            <input readonly="readonly" id="name" value="${gtywinfo.xm}"/>
                        </td>
                        <th width="82">身份证号</th>
                        <td>
                            <input readonly="readonly" id="idno" value="${gtywinfo.sfzh}"/>
                        </td>
                        <th width="82">户籍</th>
                        <td>
                            <input readonly="readonly" id="home" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <th width="82">电脑号</th>
                        <td>
                            <input readonly="readonly" id="pcno" class="pcno" value="${gtywinfo.dnh}"/>
                        </td>
                        <th width="82">单位编号</th>
                        <td>
                            <input readonly="readonly" id="dwbh" class="dwbh" value="${gtywinfo.dwbh}"/>
                        </td>
                        <th width="82">联系电话</th>
                        <td>
                            <input readonly="readonly" id="phone" class="phone" value="${jsondata.phone}"/>
                        </td>
                    </tr>
                    <tr>
                        <th width="82">单位名称</th>
                        <td colspan="5">
                            <input readonly="readonly" id="dwmc" value="${gtywinfo.dwmc}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>业务类型</th>
                        <td colspan="5">
                            <%--<input readonly="readonly" id="ywmc" value="${gtywinfo.ywmc}"/>--%>
                            ${gtywinfo.ywmc}
                            <c:forEach items="${gtywinfos}" var="info">
                                <c:if test="${info.id != gtywinfo.id}">
                                    - ${info.ywmc}
                                </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div align="center" class="breadcrumb">
        <div class="breadcrumb">
            <div align="center">
                <h5 style="font-size: 20px;font-family: '微软雅黑';text-align: center;line-height: 35px;">模板预览</h5>
            </div>
            <div id="temps" style="width: 768px;">
                <ul class="nav nav-tabs" style="margin-bottom: 0;">
                    <c:if test="${slTemp != null}">
                        <li class="active"><a href="#slTemp" data-toggle="tab">受理模板</a></li>
                    </c:if>
                    <c:if test="${sjTemp != null}">
                        <li><a href="#sjTemp" data-toggle="tab">收件模板</a></li>
                    </c:if>
                    <c:if test="${bqTemp != null}">
                        <li><a href="#bqTemp" data-toggle="tab">补齐材料模板</a></li>
                    </c:if>
                </ul>
                <div id="myTabContent" class="tab-content" style="background: white;">
                    <div class="tab-pane active" id="slTemp">
                    </div>
                    <div class="tab-pane" id="sjTemp">
                        ${gtxt:htmlUnescape(sjTemp.conment)}
                    </div>
                    <div class="tab-pane" id="bqTemp">
                        ${gtxt:htmlUnescape(bqTemp.conment)}
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcrumb" align="center">
        <button type="button" id="qrdy" onclick="tiaozhuan()"
                class="btn btn-warning" style="width: 130px;">
            <i class="icon-update"></i>&nbsp; 确认打印
        </button>
        <button type="button" id="dysl" onclick="dayin()"
                class="btn btn-warning" style="width: 130px;">
            <i class="icon-save"></i>&nbsp; 打 印
        </button>
        <button type="button" id="cancel" onclick="dayin()"
                class="btn btn-warning" style="width: 130px;">
            <i class="icon-save"></i>&nbsp; 返回
        </button>
    </div>
</div>
</div>
</div>
<script src="${ctxStatic}/jquery/jquery.jqprint-0.3.js" type="text/javascript"></script>
<script>
    $(document).ready(function () {
        $("[data-toggle='tooltip']").tooltip({
            delay: {show: 1000, hide: 200}
        });
        $("[data-toggle='popover']").popover();
    });

    function dayin() {
        $("#myTabContent .tab-pane.active").jqprint({
            importCSS: true
        });
        <%--location.href = "${ctx}/gt/gtSmjinfo/update";--%>
    }

    function tiaozhuan() {
        location.href = "${ctx}/city/dWrittempinfo/tiaozhuan?ywlsh=${gtywinfo.ywlsh}&hzdh=${gtywinfo.hzdh}";
    }
</script>
<script id="slhzTemp" type="text/template">
    ${gtxt:htmlUnescape(slTemp.conment)}
</script>
</body>
</html>

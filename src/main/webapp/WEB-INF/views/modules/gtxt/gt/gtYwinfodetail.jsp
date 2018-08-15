<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>深圳社保受理系统</title>
    <meta name="decorator" content="default"/>
    <style>
        .selectWidth {
            width: 164px;
        }

        .inputWidth {
            width: 170px;
        }

        td, td * {
            word-break: break-all;
            word-wrap: break-word;
        }

        .ulHead {
            text-align: center;
            background-color: #2fa4e7;
            color: white;
            line-height: 30px;
            border-radius: 3px;
        }

        .dl-horizontal dd {
            margin-left: 110px;
        }

        #personInfo {
            font-size: 14px;
        }

        #personInfo th {
            text-align: right;
            width: 70px;
        }
    </style>
    <script type="text/javascript">
        $(document).ready(function () {
            var dnh =${sIztInfoBean.DNH};
            var dwbh =${sIztInfoBean.DWBH};
//	      if(dnh==0 ||isNull(dnh)){
//	          $("#btn2").hide();
//	      }
//	      if(dwbh==0 || isNull(dwbh)){
//	    	$("#btn1").hide();
//	      }
//	      $(document).bind('mousewheel', function (event, delta) {
//              console.log(event.originalEvent.deltaY);
//          });
        });
        /*  $(document).ready(function () {
         $("#centerDiv").css({"margin-top": ($("#topDiv").outerHeight() + 13)});
         $(window).resize(function () {
         $("#centerDiv").css({"margin-top": ($("#topDiv").outerHeight() + 13)});
         });

         $(document).bind('mousewheel', function (event, delta) {
         console.log(event.originalEvent.deltaY);
         });
         }); */
        function page(n, s) {
            $("#pageNo").val(n);
            $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }

        function thumbnail(imgPath, ywlsh) {
            loading("正在加载，请稍等...");
            top.$.jBox.open("iframe:${ctx}/slzt/slinfo/imgshow?imgPath=" + imgPath + "&ywlsh=" + ywlsh, "扫描件 详细", 800, 600, {
                loaded: function () {
                    closeTip();
                    $(".jbox-content", top.document).css("overflow-y", "hidden");
                },
                closed: function () {

                },
                opacity: 0.5,
                border: 1,
                iframeScrolling: "no",
                buttons: {},
                submit: function (v, h, f) {
                    if (v == "qwe") {
                        /*$.post("
                        ${ctx}/slzt/zsyw/dwsb/json",{},function(data){
                         alert(data);
                         });*/
//                        return false;
                    }
                }
            });
        }

        function toBusdocs() {
            var dwbh = $("#dwbh").val();
            $.jBox("iframe:${ctx}/busdocsList/busdocsinfo/list?dwbh=" + dwbh + "", {
                title: "企业基本信息",
                width: 1000,
                height: 360,
                buttons: {'关闭': true}
            });
        }
        function toBasicinfo() {
            var idcd = $("#idcd").val();
            $.jBox("iframe:${ctx}/per/basicinfo/list?IDCD=" + idcd + "&type=1", {
                title: "个人基本信息",
                width: 1000,
                height: 350,
                buttons: {'关闭': true}
            });
        }
        function toBusProcessM() {
            var ywbh = $("#newywbh").val();

            $.jBox("iframe:${ctx}/ProcessMaterial/ProcessMaterialList/list?ywbh=" + ywbh + "", {
                title: "需审核的材料及操作流程",
                width: 1000,
                height: 450,
                buttons: {'关闭': true}
            });
        }
        function toJDSXQ() {
            var ywlsh = $("#ywlsh").val();
            $.jBox.open("iframe:${ctx}/shouli/jds/getJds?ywlsh=" + ywlsh + '', "显示决定书详情", 500, 350, {
                title: "决定书详情",
                width: 500,
                height: 350,
                buttons: {'关闭': true}
            });
        }

    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="javascript:history.go(-1);">业务信息列表</a></li>
    <li class="active"><a href="${ctx}/slzt/slinfo/detail?repage">业务详细查询</a></li>
</ul>
<div id="content" class="row-fluid">
    <div id="left" class="accordion-group" style="width:400px;">
        <div class="accordion-heading">
            <a class="accordion-toggle">基本信息</a>
        </div>
        <input id="dnh" type="hidden" value="${gtywinfo.grsbh}"/>
        <input id="dwbh" type="hidden" value="${gtywinfo.dwbh}"/>
        <input id="idcd" type="hidden" value="${gtywinfo.sfzh}"/>
        <input id="ywlsh" type="hidden" value="${gtywinfo.ywlsh}"/>
        <input id="newywbh" type="hidden" value="${newywbh}"/>
        <table id="personInfo" class="table table-bordered table-condensed">
            <tbody>
            <tr>
                <th>业务流水号</th>
                <td>${gtywinfo.ywlsh}</td>
            </tr>
            <tr>
                <th>业务名称</th>
                <td>${gtywinfo.ywmc}</td>
            </tr>
          <%--   <tr>
                <th>创建人</th>
                <td>${sIztInfoBean.CJR}${fns:getUserByName(sIztInfoBean.CJR).name}</td>
            </tr> --%>
           <%--  <tr>
                <th>专管员</th>
                <td>${sIztInfoBean.FGRDM}${fns:getUserByName(sIztInfoBean.FGRDM).name}</td>
            </tr> --%>
            <tr>
                <th>单位编号</th>
                <td>${gtywinfo.dwbh}</td>
            </tr>
            <tr>
                <th>单位名称</th>
                <td>${gtywinfo.dwmc}</td>
            </tr>
            <tr>
                <th>经办区域</th>
                <td>gtywinfo.fqbh</td>
            </tr>
            <tr>
                <th>电脑号</th>
                <td>${gtywinfo.grsbh}</td>
            </tr>
            <tr>
                <th>姓名</th>
                <td>${sIztInfoBean.XM}</td>
            </tr>
            <tr>
                <th>身份证号</th>
                <td>${gtywinfo.sfzh}</td>
            </tr>
            <tr>
                <th>创建时间</th>
                <td>${gtywinfo.cjdate}</td>
            </tr>
            <tr>
                <th>业务状态</th>
                <td>gtywinfo.lczt</td>
            </tr>
            </tbody>
        </table>
        <div class="pagination">${page}</div>
        <center>
            <div class="btn-group">
                <a href="javascript:onClick=toBusdocs()" class="btn btn-group-item" id="btn1">单位档案</a>
                <a href="javascript:onClick=toBasicinfo()" class="btn btn-group-item" id="btn2">个人档案</a>
                <a href="javascript:onClick=toBusProcessM()" class="btn btn-group-item" id="btn3">材料与流程</a>
                <a href="javascript:onClick=toJDSXQ()" class="btn btn-group-item" id="btn4">决定书详情</a>
            </div>
        </center>
    </div>
    <div id="openClose" class="close">&nbsp;</div>
    <div id="right">
        <div id="centerDiv" style="width: 100%; margin: 0; overflow-y: auto;">
            <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle">办理流程</a>
                </div>
                <table id="contentTable" class="table table-striped table-bordered table-condensed">
                    <thead>
                   <%--  <tr>
                        <th width="140px">操作时间</th>
                        <th width="130px">操作内容</th>
                        <th width="200px">操作人</th>
                        <th>处理意见</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${lcBean}" var="liucheng">
                        <tr>
                            <td>
                                    ${liucheng.CLSJ}
                            </td>
                            <td>
                                    ${fns:getYwlcLabel(liucheng.YWLC)}
                            </td>
                            <td>
                                    ${liucheng.CLR}${fns:getUserByName(liucheng.CLR).name}
                            </td>
                            <td>
                                    ${liucheng.CLYJ}
                            </td>
                        </tr>
                    </c:forEach> --%>
                    </tbody>
                </table>
            </div>
            <div class="accordion-group">
                <div class="accordion-heading">
                    <a class="accordion-toggle">扫描件</a>
                </div>
                <div style="padding: 0 5px 5px 5px; margin: 0; background: #ffffff;">
        <%--             <ul class="thumbnails" style="margin-top: 5px;">
                        <c:set value="${fns:getUser()}" var="loginUser"/>
                        <c:if test="${empty imgs}">
                            <div class="alert alert-error" style="font-size: 14px; margin: 0; text-align: center;">
                                此业务目前没有扫描件!

                            </div>
                        </c:if>
                        <c:forEach items="${imgs}" var="img" varStatus="status">
                            <li class="span3 thumbnail" style="margin: 5px; width: 220px;">
                                <a href="javascript:thumbnail('${img.id}', '${sIztInfoBean.YWLSH}');">
                                    <img src="${img.id}?username=admin&password=admin"
                                         style="width:250px;height:200px;">
                                </a>
                                <span>${img.BY2}</span>
                            </li>
                        </c:forEach>
                    </ul> --%>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var showDetailObj = null;
    var detailTrTheme = "info";
    var tableTrTheme = "";
    $(function () {
        //$("#centerDiv").css({"overflow-y" : "scroll"});
    });
    var leftWidth = 360; // 左侧窗口大小
    var htmlObj = $("html"), mainObj = $("#main");
    var frameObj = $("#left, #openClose, #right, #right iframe");
    function wSize() {
        var strs = getWindowSize().toString().split(",");
        htmlObj.css({"overflow-x": "hidden", "overflow-y": "auto"});
//        $("body").css("overflow", "hidden");
        mainObj.css("width", "auto");
        frameObj.height(strs[0] - 5);
        var leftWidth = ($("#left").width() < 0 ? 0 : $("#left").width());
        $("#right").width($("#content").width() - leftWidth - $("#openClose").width() - 5);
    }
    function tableTurnCss() {
        $("#treeTableList").find("tr:odd").removeClass(tableTrTheme).removeClass(detailTrTheme);
        $("#treeTableList").find("tr:even").addClass(tableTrTheme);
    }
</script>
<script src="${ctxStatic}/common/wsize.min.js" type="text/javascript"></script>
</body>
</html>

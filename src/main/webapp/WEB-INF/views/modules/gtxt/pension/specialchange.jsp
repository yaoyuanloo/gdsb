<%--
  Created by IntelliJ IDEA.
  User: cxd
  Date: 2016/9/7
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>养老业务-特殊人员建账变更-审核</title>
    <meta name="decorator" content="default"/>
    <style>
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
            width: 100%;
            background: none;
            height: 28px;
        }

        #zysxTable th {
            text-align: center;
            width: 70px;
        }

        .multiBox {
        }

        .multiBoxIcon {
        }

        .multiBoxLabel {
        }

        .table td i {
            margin: 4px 2px 0 2px;
        }

        .selectWidth {
            width: 164px;
        }

        .inputWidth {
            width: 150px;
        }

        .input-append .accordion-toggle{
            /*padding-left: 10px;*/
            /*padding-right: 10px;*/
        }

        table {
            table-layout: fixed;
        }
    </style>
</head>
<body>
<div id="content" class="row-fluid">
    <div id="left" class="accordion-group">
        <div class="accordion-heading" style=" height: 40px;">
            <a class="accordion-toggle" style="text-align: center; font-size: 18px; line-height: 26px;">${typename}</a>
        </div>
        <table class="table">
            <tr>
                <td>
                    <ul id="yewuleibie" class="nav nav-tabs nav-stacked">
                        <c:choose>
                            <c:when test="${checkMultiLabel}">
                                <c:forEach items="${types}" var="t">
                                    <li>
                                        <a href="javascript:void(0);" class="multiBox" value="${t.id}"
                                           onclick="checkMultiLabel(this)">
                                            <i class="multiBoxIcon span1 icon-check-empty"></i>
                                            <span class="multiBoxLabel">${t.name}</span>
                                        </a>
                                    </li>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${types}" var="t">
                                    <li>
                                        <a href="javascript:void(0);" class="multiBox" value="${t.id}"
                                           onclick="checkLabel(this)">
                                            <i class="multiBoxIcon span1 icon-circle-blank"></i>
                                            <span class="multiBoxLabel">${t.name}</span>
                                        </a>
                                    </li>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </td>
            </tr>
        </table>
        <input id="ywmc" type="hidden"/>
    </div>
    <div id="openClose" class="close">&nbsp;</div>
    <div id="right">
       <ul class="nav nav-tabs">
		<li><a
			href="${ctx}/gtxt/examine/window/list?pageNo=${(not empty pageNo)?pageNo : 0}">窗口审核列表</a></li>
		<li class="active"><a href="#examine" data-toggle="tab"
			style="color: red;">窗口业务审核</a></li>
		<li><a href="#YWCXBQ09" data-toggle="tab">任务日志</a></li>
		<li><a href="#YWCXBQ01" data-toggle="tab">档案基本信息</a></li>
		<li><a href="#YWCXBQ01" data-toggle="tab">档案内容</a></li>
		<li><a href="#YWCXBQ01" data-toggle="tab">同类业务档案</a></li>
		<li><a href="#YWCXBQ01" data-toggle="tab">个人缴费信息</a></li>
		<li><a href="#YWCXBQ01" data-toggle="tab">历史缴费信息</a></li>
		<li><a href="#YWCXBQ01" data-toggle="tab">个人账户基本信息</a></li>
		<li><a href="#YWCXBQ01" data-toggle="tab">异地转入视同和地方养老信息</a></li>
		<li><a href="#YWCXBQ01" data-toggle="tab">异地转入工资信息</a></li>
		<li><a href="#YWCXBQ01" data-toggle="tab">视同建账详细信息</a></li>
	</ul>
	
        <div id="centerDiv" style="width: 100%; margin: 0;overflow-x: hidden; overflow-y: auto;">
           	<div>
            <table class="table table-striped table-bordered table-condensed" style="margin: 0;">
                <tr>
                    <th width="80">业务名称</th>
                    <td width="250"></td>
                    <th width="80">受理回执号</th>
                    <td></td>
                    <th width="80">业务流水号</th>
                    <td></td>
                </tr>
                <tr>
                    <th width="80">身份证号</th>
                    <td></td>
                    <th width="80">姓名</th>
                    <td></td>
                    <th width="80">所在单位</th>
                    <td></td>
                </tr>
                <tr>
                    <th width="80">经办人</th>
                    <td></td>
                    <th width="80">经办时间</th>
                    <td></td>
                    <th width="80">联系电话</th>
                    <td></td>
                </tr>
            </table>
          </div>
            <center>
                 <div id="controlForm" class="breadcrumb form-search"
									style="margin: 0; border: 0;">
									<ul class="breadcrumb" style="height: 30px;">

                                     <li ><label> 安置,流动,改制时间：</label>
                               <input name="cjsj" type="text" readonly="readonly"
                       maxlength="20" class="input-mini Wdate"
                       value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM"/>"
                       onclick="WdatePicker({dateFmt:'yyyy-MM',isShowClear:true});"
                       style="width: 150px;"/>
                            </li>
                            &nbsp;
									  <li ><label for="jiaofei">缴费类别：</label>
                                            <select id="jiaofei" name="jiaofei" class="input-medium selectWidth">
                                               <option value="1">视同</option>
                                               <option value="0">实际</option>
                                             </select>
                                        </li>

									<li > <label>视同缴费人员类别：</label>
										<select
											id="JFSJ" style="width: 150px;">
												<option value="">请选择</option>
												<option value="1">市外调入</option>
												<option value="2">转业干部</option>
												<option value="1">转业士官</option>
												<option value="2">退伍义务兵</option>
												<option value="1">复原干部</option>
												<option value="2">机关人员</option>
												<option value="1">事业单位人员</option>
												
										  </select>
                                       </li> &nbsp;
                                        <li > <label>平均工资：</label>
                                                <input id="note" name="note" type="text" htmlEscape="false" maxlength="100" style="width: 50px;"/>
                                        </li>
                      
                    
                           <button type="button" id="xgqfb" onclick=""
								class="btn btn-small"
								style="width: 50px; padding-left: 2px; padding-right: 2px;">
								<i class="icon-edit"></i>&nbsp;查询
							</button>
                    
                              &nbsp;      			
								</ul>
								<ul class="breadcrumb" style="height: 22px;">
                            <li ><label>视同起始时间点：</label>
                               <input id="startDate" name="cjsjs" type="text" readonly="readonly"
                       maxlength="20" class="input-mini Wdate"
                       value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM"/>"
                       onclick="WdatePicker({dateFmt:'yyyy-MM',isShowClear:true});"
                       style="width: 150px;"/>
                            </li>
                            
                            <li><label>视同结束时间点：</label>
                               <input id="endDate" name="cjsje" type="text" readonly="readonly"
                       maxlength="20" class="input-mini Wdate"
                       value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM"/>"
                       onclick="WdatePicker({dateFmt:'yyyy-MM',isShowClear:true});"
                       style="width: 150px;"/>
                            </li>
                 </ul>
									<ul class="breadcrumb">
                                 <li ><label for="note">备注：</label> <input id="note"
										name="note" type="text" htmlEscape="false" maxlength="100"
										style="width: 710px;" /></li>
								</ul>	
								<div class="breadcrumb" style="margin-top: 3px; margin-right: 10px;">
                            <button type="button" id="ywbanjie" onclick="" class="btn btn-warning"
                                    style="width: 150px;"><i
                                    class="icon-cloud-upload"></i>&nbsp;初审通过
                            </button>
                            <button type="button" id="xiugai" onclick="" class="btn btn-warning"
                                    style="width: 150px;"><i
                                    class="icon-pencil"></i>&nbsp;转受理补充材料
                            </button>
                            <button type="button" id="baocun" onclick="" class="btn btn-warning"
                                    style="width: 150px;"><i
                                    class="icon-save"></i>&nbsp; 转初审补充材料
                            </button>
                            <button type="button" id="qxxiugai" onclick="" class="btn btn-warning"
                                    style="width: 150px;"><i
                                    class="icon-picture"></i>&nbsp;中止任务
                            </button>
                           <button type="button" id="xgqfb" onclick="" class="btn btn-warning"
                                    style="width: 200px; padding-left: 2px; padding-right: 2px;"><i
                                    class="icon-edit"></i>&nbsp;退回录入个人基本信息
                            </button>
                        </div>
						 </div>											
									
					</center>
					
					
					<div class="breadcrumb"
							style="margin-top: 3px; margin-right: 10px;">
							<button type="button" id="xgqfb" onclick=""
								class="btn btn-small"
								style="width: 100px; padding-left: 2px; padding-right: 2px;">
								<i class="icon-edit"></i>&nbsp;计算
							</button>
							<button type="button" id="xgqfb" onclick="calculate()"
								class="btn btn-small"
								style="width: 100px; padding-left: 2px; padding-right: 2px;">
								<i class="icon-edit"></i>&nbsp;增加
							</button>
							<button type="button" id="xgqfb" onclick=""
								class="btn btn-small"
								style="width: 100px; padding-left: 2px; padding-right: 2px;">
								<i class="icon-edit"></i>&nbsp;删除
							</button>
						</div>
						
						<div class="pagination"></div>

						<table id="tabledata" class="table table-striped table-bordered table-condensed"> 
						 
						<thead><tr><th>选择</th><th>身份证号</th><th>开始年月</th><th>结束年月</th><th>核销状态</th></tr>
						 </table>       
        </div>
    </div>
</div>
</div>

<script>
    $(document).ready(function () {
    	
    	
    	 $("#jzfschage").change(function () {
    	    	if ($(this).val() == 0)
    	    	$(".contenttype").fadeIn('fast');
    	    	else
    	    	$(".contenttype").fadeOut('fast');
    	    	})
    	
    	
    	
        var tpl = $("#baseTableTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
        updateBaseTable({msg: '0'}, tpl);
        $("#searchForm").submit(function () {
            if ($("#searchInput").val() == "") {
                showTip("请输入单位社保编号", 'info', 2000, 0);
            } else {
                $.post("${ctx}/slzt/zsyw/dwsb/json", {dwbh: $("#searchInput").val()}, function (data) {
                    updateBaseTable(data, tpl);
                    $("#shenheBtn").attr("dwbh", ($("#searchInput").val()));
                });
            }
            return false;
        });
        $("[data-toggle='tooltip']").tooltip({
            delay: {show: 1000, hide: 200}
        });
        $("[data-toggle='popover']").popover();

        $("#sqr").change(function () {
            if ($(this).val() == 0)
                $(".daibanren").fadeIn('fast');
            else
                $(".daibanren").fadeOut('fast');
        });
    });

    function updateBaseTable(data, tpl) {
        if (((data['msg']).toString().trim()) != '0') {
            showTip(((data['msg']).toString().trim()), 'error');
        }
        $("#baseTable").children().remove();
        $("#baseTable").append(Mustache.render(tpl, {
            dict: {
                udstarttime: function (v) {
                    if (data.udayy1) {
                        return data.udayy1 + "年" + data.udamm1 + "月";
                    } else {
                        return "";
                    }
                },
                udchar: function () {
                    if (data['udchar'] == null) {
                        return "";
                    } else {
                        return (data['udchar'] == '0') ? "企业" : '机关企业';
                    }
                }
            },
            data: data
        }));
    }

    var values = new Array();
    function allCheck(e) {
        var i = $(e).find("i")[0];
        if (!$(i).hasClass("icon-check")) {
            $(i).removeClass("icon-check-empty").addClass("icon-check");
            $("#paperTable .multiBoxIcon").removeClass("icon-check-empty").addClass("icon-check");
        } else {
            $(i).removeClass("icon-check").addClass("icon-check-empty");
            $("#paperTable .multiBoxIcon").removeClass("icon-check").addClass("icon-check-empty");
        }
        setValues();
        checkAll();
    }

    function checkLabel(e) {
        var box = ($(e).children("i"))[0];
        if (!($(box).hasClass("active"))) {
            $(".multiBoxIcon").removeClass("icon-circle").removeClass("active").addClass("icon-circle-blank");
            $(box).addClass("icon-circle").addClass("active");

            $("#shenheBtn").attr("ywbh", ($(e).attr("value")));
        }
    }

    function checkMultiLabel(e) {
        var box = ($(e).find(".multiBoxIcon"))[0];
        if ($(box).hasClass("icon-check-empty")) {
            $(box).addClass("icon-check").removeClass("icon-check-empty");
        } else {
            $(box).addClass("icon-check-empty").removeClass("icon-check");
        }
        $.post("${ctx}/slzt/zsyw/dwsb/zhuyi", {ywbh: $(e).attr("value")}, function (data) {
            $("#zysxTable").html("");
            $("#blsj").val("");

            $("#blsj").val((data.ywxx.by1).toString().trim());
            ywsc = data.ywsc;
            ywscCount = ywsc.length;

            $("#ywscPageBar").html("");
            /*if (ywsc.length > pageSize) {*/
            var prev = $("<li class='disabled'><a href='javascript:void(0);' onclick='prev($(this));' class='icon-double-angle-left'></a></li>");
            $("#ywscPageBar").append(prev);
            for (var i = 0; i < (ywscCount / pageSize); i++) {
                $("#ywscPageBar").append($("<li><a href='javascript:void(0);' onclick='ywscPage(this);' data-page-no='" + (i + 1) + "'>" + (i + 1) + "</a></li>"));
            }
            var next = $("<li><a href='javascript:void(0);' onclick='next($(this));' class='icon-double-angle-right'></a></li>");
            $("#ywscPageBar").append(next);
            var f = (($("#ywscPageBar").find("li a")[1]));
            ywscPage(f);
            $("#ywscPageBar").attr("data-page-count", ywscCount);
            /*} else {
             var page = $("#ywscPageBar").attr("data-page-no");
             var li = ($("#ywscPageBar").find("li")[1]);
             var a = $(li).find("a");
             console.log(a);
             ywscPage(a);
             }*/
        });
        checkAll();
    }

    function checkAll() {
        var e = $("#paperTable .multiBox").find(".icon-check");
        var all = $("#paperTable tr");
        if (e.length == all.length) {
            $("#allcheckBox .multiBoxIcon:first").addClass("icon-check").removeClass("icon-check-empty");
        } else {
            $("#allcheckBox .multiBoxIcon:first").addClass("icon-check-empty").removeClass("icon-check");
        }
    }
   
    function checkNumber() {
        var a = $("#yewuleibie .multiBox");
        var c = $("#yewuleibie .multiBox").find(".icon-check").parent();
        var vs = new Array();
        var ns = new Array();
        var js = new Array();
        var j = {};
        $(c).each(function () {
            j = {"name": $(this).attr("value"), "value": $(this).find(".multiBoxLabel").html()};
            js.push(j);
            vs.push($(this).attr("value"));
            ns.push($(this).find(".multiBoxLabel").html());
        });
        return {all: a, checked: c, values: vs, names: ns, json: js, boo: (c.length < a.length) ? false : true};
    }
</script>
<script type="text/javascript">
    var showDetailObj = null;
    var detailTrTheme = "info";
    var tableTrTheme = "";
    //    $(function () {
    //        $("#centerDiv").css({"overflow-y" : "scroll"});
    //    });
    var leftWidth = 200; // 左侧窗口大小
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
<script type="text/template" id="baseTableTpl">
    <tr>
        <th width="80">姓名</th>
        <td>
            <input readonly="readonly" id="name" value="{{data.name}}"/>
        </td>
        <th width="80">身份证号</th>
        <td>
            <input readonly="readonly" id="idcard" value="{{dict.idcard}}"/>
        </td>
        <th width="80">户籍</th>
        <td>
            <input readonly="readonly" id="home" value="{{dict.home}}"/>
        </td>
    </tr>
</script>
</body>
</html>

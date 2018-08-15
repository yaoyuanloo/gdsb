<%--
  Created by IntelliJ IDEA.
  User: cxd
  Date: 2016/9/6
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>登记业务-居民家庭登记-受理</title>
    <meta name="decorator" content="yhdefault"/>
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
    <div id="">
        <div class="box box-default" style="width: 100%; margin: 0;overflow-x: hidden; overflow-y: auto;">
         <div class="box-header with-border">
                    <h3 class="box-title"><div class="dec_1"></div>
                                                              居民家庭登记
                    </h3>
            </div>
            <div class="box-body" style="margin: 0;">
              <form class="form-horizontal" name="myform" id="myform" method="post" action="">
                    <div style="float: left;">
                        <a class="accordion-toggle" style="font-size: 18px; line-height: 22px;">${typename}</a>
                    </div>
                    <div class="form-group">
                         <label class="span2 control-label"><b class="mr5 red500">*</b>户主证件类型:</label>
                         <div class="span3">
                              <select id="aac058" name="aac058" class="form-control selectpicker">
                              <option value="01" selected="selected">居民身份证(户口簿)</option>
                              <option value="02">中国人民解放军军官证</option>
                            </select>                 
                         </div>
                         <label class="span2 control-label"><b class="mr5 red500">*</b>户主证件号码:</label>
                         <div class="span2">
                             <input id="aac147" name="aac147" type="text" placeholder="请输入身份证号" class="form-control"/>
                         </div>
                          <button id="searchBtn" type="submit" class="btn yellow">查询</button>
                    </div>
                <div class="form-group">
	                            <label class="span1 control-label">姓名</label>
	                            <div class="span2">
	                                 <input disabled class="form-control" id="aab400" name="aab400" class="aab400" />
	                            </div>
	                            <label class="span1 control-label">证件类型</label>
	                            <div class="span2">
	                                 <input disabled class="form-control" id="aac058" name="aac058" class="aac058" />
	                            </div>
	                            <label class="span1 control-label">证件号码</label>
	                            <div class="span2">
	                                 <input disabled class="form-control" id="aac147" name="aac147" class="aac147" />
	                            </div>
	                            <label class="span1 control-label">户籍</label>
	                            <div class="span2">
	                                <input disabled class="form-control" id="aac010" name="aac010" class="aac010" />
	                          </div>
						</div>
                  </form>
             </div> 
          <%--   <form id="infoForm" method="post" class="form-search breadcrumb" style=" margin: 0; border: 0;">
               
            <div id="searchForm" action="${ctx}/slzt/slinfo/list" method="post"
                 class="breadcrumb form-search" cssStyle=" margin: 0; border: 0;"> --%>
             <div class="box-body">
               <form class="form-horizontal" name="myform" id="myform" method="post" action="">
                   <div class="form-group">
                        <label class="span2 control-label">申请人：</label>
                        <div class="span2" >
                           <select id="sqr" name="sqr" class="form-control selectpicker">
                               <option value="0">他人代办</option>
                               <option value="1">本人办理</option>
                               
                           </select>
                       </div>                      
                       <label class="span2 control-label">联系电话：</label>
                        <div class="span2">
                           <input type="text" placeholder="请输入联系电话" class="form-control" name="" id=""/>
                       </div>
                        <label  for="ywlsh" class="span2 control-label">户籍编号：</label>
                        <div class="span2">
                           <input id="aab401" name="aab401" type="text" placeholder="请输入户籍编号" class="form-control"/>
                       </div>
                 </div>
                 <div class="form-group">
                 <label class="span2 control-label">户主姓名：</label>
                        <div class="span2">
                           <input id="aab400" name="aab400"  type="text" placeholder="请输入户主姓名" class="form-control" />
                       </div>
                        <label  for="ywlsh" class="span2 control-label">户籍人口数：</label>
                        <div class="span2">
                           <input  id="bab100" name="bab100" type="text" placeholder="请输入户籍人口数" class="form-control"/>
                       </div>
                       <label class="span2 control-label">户口所在地行政区划代码：</label>
                        <div class="span2">
                           <input id="aac300" name="aac300"  type="text" placeholder="请输入划分码" class="form-control" />
                       </div>
                 </div>
                 <div class="form-group">
                        <label  for="ywlsh" class="span2 control-label">险种类型：</label>
                        <div class="span2">
                           <input   id="aae140" name="aae140" type="text" placeholder="请输入险种类型" class="form-control"/>
                       </div>
                       <label class="span2 control-label">参保日期：</label>
                        <div class="span2">
                           <input  id="aab050" name="aab050"  type="text" placeholder="请输入参保日期" class="form-control" />
                       </div>
                        <label  for="ywlsh" class="span2 control-label">参保状态：</label>
                        <div class="span2">
                           <input id="aab051" name="aab051" type="text" placeholder="请输入参保状态" class="form-control"/>
                       </div>
                 </div>
                 <div class="form-group">
                       
                       <label class="span2 control-label">征收方式：</label>
                        <div class="span2">
                           <input id="baa140" name="baa140"  type="text" placeholder="请输入征收方式" class="form-control" />
                       </div>
                       <div id="daibanren">
	                        <label  for="ywlsh" class="span2 control-label">代办人姓名：</label>
	                        <div class="span2">
	                           <input type="text" placeholder="请输入代办人姓名" class="form-control" name="" id=""/>
	                       </div>
	                       
	                       <label class="span2 control-label">代办人身份证：</label>
	                        <div class="span2">
	                           <input type="text" placeholder="请输入代办人身份证" class="form-control" name="" id=""/>
	                       </div>
                	    </div>
                 </div>
                 <div class="form-group" style="width: 100%">
                        <label  for="ywlsh" class="span2 control-label">备注：</label>
                        <div class="span4" style="width: 80%">
                           <input id="aae013" name="aae013" type="text"  class="form-control" maxlength="90%"/>
                       </div>
                 </div>
                   <div class="form-group">
                            <div class="col-sm-offset-2 span10">
                                <button type="submit" class="btn yellow" onclick="tijiao()">保存(S)</button>
                                <button type="submit" class="btn gray" id="resetButton">重置(R)</button>
                                <button type="submit" class="btn gray">关闭</button>
                                <button type="submit" class="btn darkgray">禁用</button>
                            </div>
                        </div>
               </form>
            </div>
                    <form id="submitForm" action="${ctx}/gtxt/accept/medical/save" method="post" style="margin: 0; border: 0;">
			            <input type="hidden" id="jsoninfo" name="jsoninfo"/>
			            <input type="hidden" id="ywid" name="ywid" value="${ywinfo.id}"/>
			            <input type="hidden" id="nextywid" name="nextywid" value=""/>
			            <input type="hidden" id="cls" name="cls" value=""/>
			            <input type="hidden" id="teamwork" name="teamwork" value=""/>
			            <input type="hidden" id="active" name="active" value=""/>
			            <input type="hidden" id="flowcode" name="flowcode" value="${ywatter.flowcode.value}"/>
			            <input type="hidden" id="shjbcode" name="shjbcode" value="${ywatter.shjbcode.value}"/>			
			            <input type="hidden" id="hzdh" name="hzdh" value="${hzdh}"/>
			            <input type="hidden" id="slhzh" name="slhzh" value="${slhzh}"/>
			            <input type="hidden" id="grsbh" name="grsbh" class="sino" value=""/>
			            <input type="hidden" id="sfzh" name="sfzh" class="aac147" value=""/>
			            <input type="hidden" id="dnh" name="dnh" class="pcno" value="${gtywinfos[0].dnh}"/>
			            <input type="hidden" id="ywbh" name="ywbh" value="${ywinfo.pywinfo.code}"/>
			            <input type="hidden" id="ywmc" name="ywmc" value="${ywinfo.pywinfo.name}"/>
			            <input type="hidden" id="xm" name="xm" class="aac003" value=""/>
			            <input type="hidden" id="dwbh" name="dwbh" class="dwbh" value=""/>
			            <input type="hidden" id="dwmc" name="dwmc" class="dwmc" value=""/>
			            <input type="hidden" id="phone" name="phone" class="aac067" value=""/>
        			</form>
            </div>
            <ul id="myTab" class="nav nav-tabs">
                <li><a href="#YWCXBQ09" data-toggle="tab">查询医疗信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">单位基本信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">个人基本信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">个人缴费基本信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">历史缴费信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">历史住院信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">转诊信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">长住异地信息</a></li>
                <li><a href="#YWCXBQ01" data-toggle="tab">门诊病种信息</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
                <!-- 个人基本信息 -->
                <div class="tab-pane" id="YWCXBQ01">
                    <div>
                    </div>
                </div>
                <div class="tab-pane" id="YWCXBQ09">
                    <!-- 查询医疗信息 -->
                    查询医疗信息
                </div>
                <div class="tab-pane" id="YWCXBQ05">
                    <!-- 生育待遇信息 -->
                    生育待遇信息
                </div>
                <!-- 养老待遇信息 -->
                <div class="tab-pane" id="YWCXBQ07">
                    <!-- 养老待遇信息 -->
                    养老待遇信息
                </div>
                <!-- 个人账户基本信息 -->
                <div class="tab-pane" id="YWCXBQ08">
                    <!-- 个人账户基本信息 -->
                    <div>
                    </div>
                </div>
                <!-- 工伤待遇查询 -->
                <div class="tab-pane" id="YWCXBQ06">
                    <!-- 工伤待遇查询 -->
                </div>
                <!-- 历史缴费信息 -->
                <div class="tab-pane" id="YWCXBQ04">
                    <!-- 历史缴费信息 -->
                    <div>
                    </div>
                </div>

                <div class="tab-pane" id="YWCXBQ03">
                    <div>
                    </div>
                </div>

                <div class="tab-pane" id="YWCXBQ02">
                    <!-- 单位 -->
                    <div>
                    </div>
                </div>

            </div>
        </div>
<script>
    $(document).ready(function () {
        var tpl = $("#baseTableTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
        updateBaseTable({msg: '0'}, tpl);
        $("#searchBtn").click(function () {
            if ($("#aac147").val().trim() == "" && $("#aac058 option:selected").val().trim() == "") {
           	 $("#aac147").focus();
                showTip("请输入证件类型和证件号码进行查询", 'info', 2000, 0);
                twinkle("#aac147");
                twinkle("#aac158");
            } else {
           	 $.post("${ctx}/gtxt/Register/homeDeclareSelect", {type: $("#aac058 option:selected").val(),zjhm: $("#aac147").val()}, function (data) {
           	  for (var i in data) {
                  $("." + i).val(data[i]);               
              }
           	  return false;
            }); 
         }
   	  });
        
        $("[data-toggle='tooltip']").tooltip({
            delay: {show: 1000, hide: 200}
        });
        $("[data-toggle='popover']").popover();

        $("#sqr").change(function () {
            if ($(this).val() == 0)
                $("#daibanren").fadeIn('fast');
            else
                $("#daibanren").fadeOut('fast');
        });

        $("#firstpay").change(function () {
            if ($(this).val() == 1)
                $(".firstpay").fadeIn('fast');
            else
                $(".firstpay").fadeOut('fast');
        });
    });

    function updateBaseTable(data, tpl) {
        if (((data['msg']).toString().trim()) != '0') {
            showTip(((data['msg']).toString().trim()), 'error');
        }
        $("#baseTable").children().remove();
       /*  $("#baseTable").append(Mustache.render(tpl, {
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
        })); */
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
    function tijiao() {
         if(($("#aac147").val() == null && $("#aac058 option:selected").val() == null)|| ($("#aac147").val() == undefined && $("#aac058 option:selected").val() == undefined) || ($("#aac147").val() == '' && $("#aac058 option:selected").val() == '')){
            twinkle("#inputBar");
        }else if(!checkNumber("#paperTable").boo){
            twinkle("#paperTable");
        }else{
            liuzhuan();
        }  
   /* 	 $.post("${ctx}/gtxt/Register/homeDeclareSave", {}, function (data) {
      	  for (var i in data) {
             $("." + i).val(data[i]);               
         }
      	  return false;
       });   */
    }

    function liuzhuan() {
        top.$.jBox.confirm("是否有下一单业务", '系统提示', function (v, h, f) {
            if (v == 'ok') {
            	alert("ok");
                top.$.jBox.open("iframe:${ctx}/tag/treeselect?url=" + encodeURIComponent("/city/dYwinfo/treeData") + "&module=&checked=&extId=<%--${ywinfo.id}--%>&isAll=", "选择下一单业务", 400, 500, {
                    ajaxData: {
                        selectIds: "1"
                    },
                    buttons: {
                        "确定": "ok"
                    },
                    persistent: true,
                    submit: function (v, h, f) {
                        if (v == "ok") {
                            var tree = h.find("iframe")[0].contentWindow.tree;//h.find("iframe").contents();
                            var ids = [], names = [], nodes = [];
                            if ("${checked}" == "true") {
                                nodes = tree.getCheckedNodes(true);
                            } else {
                                nodes = tree.getSelectedNodes();
                            }
                            for (var i = 0; i < nodes.length; i++) {
                                if (nodes[i].level == 0) {
                                    top.$.jBox.tip("不能选择根节点（" + nodes[i].name + "）请重新选择。");
                                    return false;
                                }
                                if (nodes[i].isParent) {
                                    top.$.jBox.tip("不能选择父节点（" + nodes[i].name + "）请重新选择。");
                                    return false;
                                }
                                ids.push(nodes[i].id);
                                names.push(nodes[i].name);
                            }
                            var idstr = ids.join(",").replace(/u_/ig, "");
                            var nameatr = names.join(",");
                            $("#nextywid").val(ids[0]);
                        }
                        var data = $("#infoForm").serializeJson();
                        $("#jsoninfo").val(JSON.stringify(data));
                        $("#submitForm").submit();

                    },
                    loaded: function (h) {
                        $(".jbox-content", top.document).css("overflow-y", "hidden");
                    }
                });
            } else if (v == 'cancel') {
                var hzdh = $("#hzdh").val();
                if(hzdh == null || hzdh == undefined || hzdh == ''){
                    submit();
                }else{
                    checkMultiBusiness();
                }
            }
        }, {
            persistent: true,
            buttons: {
                "有": "ok",
                "没有": "cancel"
            },
            buttonsFocus: 1
        });
        top.$('.jbox-body .jbox-icon').css('top', '55px');
    }
    function checkMultiBusiness(){
        top.$.jBox.open("iframe:${ctx}/gtxt/utils/util/teamwork", "多业务设置", 500, 500, {
            ajaxData: {
                'hzdh': "${hzdh}",
                'ywid': "${ywinfo.id}",
                'ywmc': "${ywinfo.pywinfo.name}"
            },
            buttons: {
                "确定": "ok"
            },
            persistent: true,
            submit: function (v, h, f) {
                if (v == "ok") {
                    var doc = h.find("iframe")[0].contentWindow.document;
                    var teamwork = $("#teamwork", doc).val();
                    var active = $("#mutilBusinessSetting .multiBoxIcon.active", doc).attr("value");
                    $("#teamwork").val(teamwork);
                    $("#active").val(active);
                    submit();
                }
            },
            loaded: function (h) {
                $(".jbox-content", top.document).css("overflow-y", "hidden");
            }
        });
    }

    function submit(){
        var data = $("#infoForm").serializeJson();
        $("#jsoninfo").val(JSON.stringify(data));
        var cls = checkNumber("#paperTable").values;
        $("#cls").val(JSON.stringify(cls));
        $("#submitForm").submit(); 
    }
</script>
<script type="text/javascript">
//    $(function () {
//        $("#centerDiv").css({"overflow-y" : "scroll"});
//    });
    var leftWidth = 220; // 左侧窗口大小
    var htmlObj = $("html"), mainObj = $("#main");
    var frameObj = $("#left, #openClose, #right, #right iframe");
    function wSize() {
        var strs = getWindowSize().toString().split(",");
        htmlObj.css({"overflow-x": "hidden", "overflow-y": "auto"});
        mainObj.css("width", "auto");
        frameObj.height(strs[0] - 5);
        var leftWidth = ($("#left").width() < 0 ? 0 : $("#left").width());
        $("#right").width($("#content").width() - leftWidth - $("#openClose").width() - 5);
    }
</script>
<script src="${ctxStatic}/common/wsize.min.js" type="text/javascript"></script>
<script type="text/template" id="baseTableTpl">
    <tr>
        <th width="80">姓名</th>
        <td>
            <input readonly="readonly" id="aab400"  name="aab400" value="{{data.name}}" class="aab400"/>
        </td>
        <th width="80">证件类型</th>
        <td>
            <input readonly="readonly" id="aac058" name="aac058" value="{{dict.idcard}}" class="aac058"/>
        <th width="80">证件号码</th>
        <td>
            <input readonly="readonly" id="aac147" name="aac147" value="{{dict.idcard}}" class="aac147"/>
        </td>
        <th width="80">户籍</th>
        <td>
            <input readonly="readonly" id="aac010" name="aac010" value="{{dict.home}}" class="aac010"/>
        </td>
    </tr>
   <%-- <tr>
        <th>业务类型</th>
        <td colspan="5">
            <ul class="nav nav-pills" style="margin-bottom: 0;">
                <c:choose>
                    <c:when test="${checkMultiLabel}">
                        <c:forEach items="${types}" var="t">
                            <li>
                                <a href="javascript:void(0);" class="multiBox" value="${t.id}"
                                   onclick="checkMultiLabel(this)">
                                    <i class="multiBoxIcon icon-check-empty"></i>
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
                                    <i class="multiBoxIcon icon-circle-blank"></i>
                                    <span class="multiBoxLabel">${t.name}</span>
                                </a>
                            </li>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </ul>
        </td>
    </tr>--%>
</script>
</body>
</html>

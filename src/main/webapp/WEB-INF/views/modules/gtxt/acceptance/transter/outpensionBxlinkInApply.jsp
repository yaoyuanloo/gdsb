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
    <title>跨省养老保险关系转入申请-受理</title>
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

        .input-append .accordion-toggle {
            /*padding-left: 10px;*/
            /*padding-right: 10px;*/
        }

        table {
            table-layout: fixed;
        }

        .row-fluid .span1 {
            /*margin-left: 3px;*/
        }
    </style>
</head>
<body>
<%--<div class="row-fluid">--%>
 <div class="row">
        <div class="span12">
           <form class="form-horizontal" name="infoForm" id="myform" method="post" action="">
           <div>
            <!-- box -->
            <div class="box box-default">
                <!-- box-header -->
                <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        个人基本资料
                    </h3>
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
                                <input type="text" placeholder="请输入电脑号码" class="form-control" name="aac001" id="aac001"/>
                            </div>
                            <label class="span1 control-label">身份证号</label>
                            <div class="span2">
                                <input type="text" placeholder="请输入身份证号码" class="form-control" name="aac002" id="aac002"/>
                            </div>
                            <label class="span1 control-label">社保卡号</label>
                            <div class="span2">
                                <input type="text" placeholder="请输入社保卡号码" class="form-control" name="aac002" id="aac002"/>
                            </div>
                             <div class="span3 pull-right">
                                <button type="button" id="queryInfo" class="btn btn-sm yellow">查询(F)</button>
                                <button type="submit" class="btn btn-sm gray">重置(R)</button>
                            </div> 
                           
                        </div>

                    </form>

                    <div class="form-horizontal">
                    
                        <div class="form-group">
                            <label class="span1 control-label">姓名</label>
                            <div class="span2">
                                <input type="text" disabled class="form-control" name=" " id="aac003"/>
                            </div>
                            <label class="span1 control-label">身份证号码</label>
                            <div class="span2">
                                <input type="text" disabled class="form-control" name=" " id="aac002"/>

                            </div>
                            <label class="span1 control-label">户籍</label>
                            <div class="span2">
                                <input type="text" disabled class="form-control" name=" " id="aac001s"/>
                            </div>                          
                         </div>
                        <div class="form-group">
                          <label class="span1 control-label">申请人</label>
                            <div class="span2">
                                <select id="sqr" name="sqr"  class="form-control selectpicker">
                                    <option value="0">他人代办</option>
                                    <option value="1">本人办理</option>
                                </select>
                            </div>
                            <label class="span1 control-label">联系电话</label>
                            <div class="span2">
                                <input type="text" class="form-control" name=" " id="aac002"/>
                            </div>                             
                             <div id="daibanren" >
		                        <label  for="ywlsh" class="span1 control-label">代办人姓名：</label>
		                        <div class="span2">
		                           <input type="text" placeholder="请输入代办人姓名" class="form-control" name="" id=""/>
		                       </div>
		                       
		                       <label class="span1 control-label">代办人身份证：</label>
		                        <div class="span2">
		                           <input type="text" placeholder="请输入代办人身份证" class="form-control" name="" id=""/>
		                       </div>
                	        </div>
                	      </div>
                        </div> 
                    </div>
                </div>
                       <!-- box -->
            <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title"> <div class="dec_1"></div>
                                                               养老转出机构详细
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                        </button>
                    </div>
                </div>
                <%--<!-- box-body -->--%>
                <div class="box-body">

                    <div class="form-horizontal">
                     <!-- form-group -->
                        <div class="form-group">
                            <label class="span1 control-label">关系转出地</label>
                            <div class="span2">
                                <select id="linkOutWhere" name="linkOutWhere" class="form-control selectpicker">
                     			   <option value="0">请选择</option>
                        
                   				 </select>
                            </div>
                            <label class="span1 control-label">省</label>
                            <div class="span2">
                                 <select id="shenWhere" name="shenWhere" class="form-control selectpicker">
			                        <option value="0">请选择</option>  
			                    </select>
                            </div>
                            <label class="span1 control-label">市</label>
                            <div class="span2">
                                <select id="xianWhere" name="xianWhere" class="form-control selectpicker">
			                        <option value="0">请选择</option>
			                    </select>
                            </div>
                            <label class="span1 control-label">邮寄标志</label>
                            <div class="span2">
                                <select name="show" class="form-control selectpicker">
                                    <option value="1">请选择</option>
                                    <option value="0">...</option>
                                </select>
                            </div>
                        </div>
                        <!-- form-group -->
                         <div class="form-group">
                           <label class="span1 control-label">邮政编码</label>
                           <div class="span2">
                               <input type="text" class="form-control" name=" " id="aac003"/>
                           </div>
                           <label class="span1 control-label">申请人户籍</label>
                           <div class="span2">
                               <select id="applylive" name="applylive" class="form-control selectpicker">
		                        <option value="0">本市</option>
		                        <option value="1">市外广东省内</option>
		                        <option value="1">外省</option>
		                    </select>
                           </div>
                           <label class="span1 control-label">参保凭证号</label>
                           <div class="span2">
                               <input type="text"  class="form-control" name=" " id="aac001s"/>
                           </div>
                           <label class="span1 control-label">社保机构名称</label>
                           <div class="span2">
                               <input type="text"   class="form-control" name=" " id="aac001s"/>
                           </div>                       
               	       </div>
               	      <!-- form-group -->
                         <div class="form-group">
                           <label class="span1 control-label">社保机构地址</label>
                           <div class="span2">
                               <input type="text" class="form-control" name=" " id="aac003"/>
                           </div>
               	       </div>               	       
                     </div> 
                    </div>
              </div>
              <div class="box box-default">
           		<div class="box-header with-border">
                    <h3 class="box-title"> <div class="dec_1"></div>
                                                               转入申请其他信息
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                        </button>
                    </div>
                </div>
                <%--<!-- box-body -->--%>
                <div class="box-body">

                    <div class="form-horizontal">
                     <!-- form-group -->
                        <div class="form-group">
                            <label class="span2 control-label">调动时间</label>
                            <div class="span2">
                                 <input name="applyDate" type="text" 
                                               maxlength="20" class="form-control"
                                               value="<fmt:formatDate value="${work.cjsj}" pattern="yyyy-MM-dd"/>"
                                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'/*,isShowClear:true*/});"
                                              />
                            </div>
                            <label class="span2 control-label">联系人</label>
                            <div class="span2">
                                 <input type="text" class="form-control" name=" " id="aac003"/>
                            </div>
                            <label class="span2 control-label">移动电话</label>
                            <div class="span2">
                                <input type="text" class="form-control" name=" " id="aac003"/>
                            </div>
                            
                        </div>
                        <!-- form-group -->
                         <div class="form-group">
                            <label class="span2 control-label">固定电话</label>
                            <div class="span2">
                                <input type="text" class="form-control" name=" " id="aac003"/>
                            </div>
                           <label class="span2 control-label">转入原因</label>
                           <div class="span2">
                                <select id="shenWhere" name="shenWhere" class="form-control selectpicker">
				                        <option value="0">请选择</option> 
			                    </select>
                           </div>
                           <label class="span2 control-label">原个人编号（养老）</label>
                           <div class="span2">
                               <input type="text" class="form-control" name=" " id="aac003"/>
                           </div>                      
               	       </div>
               	         <!-- form-group -->
                         <div class="form-group">                           
                           <label class="span2 control-label">是否曾在转出机关失业单位参保</label>
                           <div class="span2">
                                <select id="shenWhere" name="shenWhere" class="form-control selectpicker">
				                        <option value="0">请选择</option> 
			                    </select>
                           </div>
                           <label class="span2 control-label">是否需要退款</label>
                           <div class="span2">
                               <select id="shenWhere" name="shenWhere" class="form-control selectpicker">
				                        <option value="0">是</option> 
				                        <option value="1">否</option> 
			                    </select>
                           </div>                       
               	       </div>     	       
                     </div> 
                    </div>
                    </div>
                     <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title"> <div class="dec_1"></div>
                                                               转入退款信息设置
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                        </button>
                    </div>
                </div>
                </div>
                <%--<!-- box-body -->--%>
                <div class="box-body">

                    <div class="form-horizontal">
                    <!-- form-group -->
                         <div class="form-group">
                           <label class="span1 control-label">退款类型</label>
                           <div class="span2">
                               <select id="shenWhere" name="shenWhere" class="form-control selectpicker">
				                        <option value="0">请选择</option> 
				                        <option value="1">....</option> 
			                    </select>
                           </div>
                            <label class="span1 control-label">开户名</label>
                           <div class="span2">
                               <input type="text" class="form-control" name=" " id="aac003"/>
                           </div>
                            <label class="span1 control-label">银行名称</label>
                           <div class="span2">
                                 <select id="shenWhere" name="shenWher" class="form-control selectpicker">
				                        <option value="0">请选择</option> 
				                        <option value="1">....</option> 
			                    </select>
                           </div>
                            <label class="span1 control-label">银行账号</label>
                           <div class="span2">
                               <input type="text" class="form-control" name=" " id="aac003"/>
                           </div>
               	       </div> 
               	       <!-- form-group -->
                         <div class="form-group">
                           <label class="span1 control-label">备注</label>
                           <div class="span4">
                                <input type="text" class="form-control" name=" " id="aac003"/>
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
                     </div> 
                    </div>
                </div>
                 <ul id="myTab" class="nav nav-tabs">
		            <li class="active"><a href="#YWCL" data-toggle="tab">业务所需材料</a></li>
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
		            <%-- 业务材料 --%>
		            <div class="tab-pane active" id="YWCL">
		                <div class="breadcrumb">
		                    <c:choose>
		                        <c:when test="${fn:length(cailiaoList) <= 0}">
		                            <div class="alert" style="font-size: 14px; margin: 0; text-align: center;">
		                                <button type="button" class="close" data-dismiss="alert">&times;</button>
		                                <strong>温馨提示：</strong>未找到【${ywinfo.pywinfo.name}】 业务所需材料。
		                            </div>
		                        </c:when>
		                        <c:otherwise>
		                            <table class="table table-striped table-bordered table-condensed"
		                                   style="overflow-y: auto;">
		                                <thead>
		                                <tr>
		                                    <th class="multiBox" id="allcheckBox" onclick="allCheck(this)"
		                                        style=" text-align: center; width: 40px; color: #1a22ff;">
		                                        <i class="multiBoxIcon icon-check-empty" style="width: 30px;"></i>
		                                            <%--<span class="multiBoxLabel pull-right">全选</span>--%>
		                                    </th>
		                                    <th>材料名称</th>
		                                </tr>
		                                </thead>
		                                <tbody id="paperTable">
		                                <c:forEach items="${cailiaoList}" var="cl">
		                                    <tr class="multiBox" onclick="checkMultiLabel(this, '#paperTable')" rank="1"
		                                        value="${cl.id}">
		                                        <td width="16px">
		                                            <div value="${cl.id}" style="margin: 0 auto; text-align: center;">
		                                                <i class="multiBoxIcon icon-check-empty" style="" value="${cl.id}"></i>
		                                            </div>
		                                        </td>
		                                        <td class="multiBoxLabel">${cl.name}</td>
		                                    </tr>
		                                </c:forEach>
		                                </tbody>
		                            </table>
		                        </c:otherwise>
		                    </c:choose>
		                </div>
		
		            </div>
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
        </form> 
	       
	         <form id="submitForm" action="${ctx}/gtxt/accept/medical/save" method="post" style="margin: 0; border: 0;">
	            <input type="hidden" id="jsoninfo" name="jsoninfo"/>
	            <input type="hidden" id="ywid" name="ywid" value="${ywinfo.id}"/>
	            <input type="hidden" id="flowcode" name="flowcode" value="${ywatter.flowcode.value}"/>
	            <input type="hidden" id="shjbcode" name="shjbcode" value="${ywatter.shjbcode.value}"/>
	
	            <input type="hidden" id="grsbh" name="grsbh" class="sino" value=""/>
	            <input type="hidden" id="sfzh" name="sfzh" class="idno" value=""/>
	            <input type="hidden" id="ywbh" name="ywbh" value="${ywinfo.pywinfo.code}"/>
	            <input type="hidden" id="ywmc" name="ywmc" value="${ywinfo.pywinfo.name}"/>
	            <input type="hidden" id="xm" name="xm" class="peosonname" value=""/>
	            <input type="hidden" id="dwbh" name="dwbh" class="dwbh" value=""/>
	            <input type="hidden" id="dwmc" name="dwmc" class="dwmc" value=""/>
	        </form>
       </div>      
       </div>         
                
                

<script>
    $(document).ready(function () {
        var tpl = $("#baseTableTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
//        updateBaseTable({msg: '0'}, tpl);
        $("#searchBtn").click(function () {
//            if ($("#searchInput").val() == "") {
//                showTip("请输入单位社保编号", 'info', 2000, 0);
//            } else {
            var ajaxdata = {
                pcno: $("#pcno").val(),
                icno: $("#icno").val(),
                sino: $("#sino").val()
            };
            $.post("${ctx}/gtxt/utils/util/json", ajaxdata, function (data) {
//                    updateBaseTable(data, tpl);
//                    $("#shenheBtn").attr("dwbh", ($("#searchInput").val()));
                for (var i in data) {
                    $("." + i).val(data[i]);
                }
            });
//            }
            return false;
        });
        $("[data-toggle='tooltip']").tooltip({
            delay: {show: 1000, hide: 200}
        });
        $("[data-toggle='popover']").popover();

        $("#sqr").change(function () {
            if ($(this).val() == 0){
            	  $("#daibanren").fadeIn('fast');
            }else
                $("#daibanren").fadeOut('fast');
        });

        $("#firstpay").change(function () {
            if ($(this).val() == 1) {
                $(".firstpay").fadeIn('fast');
                $(".firstpay input").removeClass("disabled");
                $(".firstpay input").removeAttr("disabled");
            } else {
                $(".firstpay").fadeOut('fast');
                $(".firstpay input").addClass("disabled");
                $(".firstpay input").attr("disabled", "disabled");
            }
        });
    });

    function tijiao() {
        var data = $("#infoForm").serializeJson();

        $("#jsoninfo").val(JSON.stringify(data));
        $("#submitForm").submit();
    }

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
        checkAll();
    }

    function checkLabel(e, pid) {
        var box = ($(e).children("i"))[0];
        var box = ($(pid).find($(e)).find(".multiBoxIcon"))[0];
        if (!($(box).hasClass("active"))) {
            $(".multiBoxIcon").removeClass("icon-circle").removeClass("active").addClass("icon-circle-blank");
            $(box).addClass("icon-circle").addClass("active");

            $("#shenheBtn").attr("ywbh", ($(e).attr("value")));
        }
    }

    function checkMultiLabel(e, pid) {
        var box = ($(pid).find($(e)).find(".multiBoxIcon"))[0];
        if ($(box).hasClass("icon-check-empty")) {
            $(box).addClass("icon-check").removeClass("icon-check-empty");
        } else {
            $(box).addClass("icon-check-empty").removeClass("icon-check");
        }
        checkAll(pid);
    }

    function checkAll(pid) {
        var e = $(pid + " .multiBox").find(".icon-check");
        var all = $(pid + " tr");
        if (e.length == all.length) {
            $("#allcheckBox .multiBoxIcon:first").addClass("icon-check").removeClass("icon-check-empty");
        } else {
            $("#allcheckBox .multiBoxIcon:first").addClass("icon-check-empty").removeClass("icon-check");
        }
        console.log(checkNumber(pid));
    }

    function checkNumber(pid) {
        var a = $(pid + " .multiBox");
        var c = $(pid + " .multiBox").find(".icon-check").parents(".multiBox");
        var vs = new Array();
        var ns = new Array();
        var js = new Array();
        var j = {};
        $(c).each(function () {
            j = {"name": $(this).find(".multiBoxLabel").html(), "value": $(this).attr("value")};
            js.push(j);
            vs.push($(this).attr("value"));
            ns.push($(this).find(".multiBoxLabel").html());
        });
        return {all: a, checked: c, values: vs, names: ns, json: js, boo: (c.length < a.length) ? false : true};
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

</script>
</body>
</html>

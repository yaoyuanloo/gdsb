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
    <title>跨省养老保险参保缴费凭证-受理</title>
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
                   <!--  <form class="form-horizontal" name="myform" id="myform" method="post" action="">
                        <div class="form-group">
                            <label class="span2 control-label">电脑号：</label>
                            <div class="span2">
                                <input type="text" placeholder="请输入电脑号码" class="form-control" name="aac001" id="aac001"/>
                            </div>
                            <label class="span2 control-label">身份证号</label>
                            <div class="span2">
                                <input type="text" placeholder="请输入身份证号码" class="form-control" name="aac002" id="aac002"/>
                            </div>
                            <label class="span2 control-label">社保卡号</label>
                            <div class="span2">
                                <input type="text" placeholder="请输入社保卡号码" class="form-control" name="aac002" id="aac002"/>
                            </div>
                             <div class="span3 pull-right">
                                <button type="button" id="queryInfo" class="btn btn-sm yellow">查询(F)</button>
                                <button type="submit" class="btn btn-sm gray">重置(R)</button>
                            </div> 
                           
                        </div>

                    </form> -->

                    <div class="form-horizontal">
                    
                        <div class="form-group">
                            <label class="span2 control-label">个人编号</label>
                            <div class="span2">
                                <input type="text"  placeholder="个人编号/身份证号/姓名" class="form-control" name=" " id="aac003"/>
                            </div>
                            <label class="span2 control-label">社会保障号码</label>
                            <div class="span2">
                                <input type="text"  class="form-control" name=" " id="aac002"/>

                            </div>
                            <label class="span2 control-label">姓名</label>
                            <div class="span2">
                                <input type="text"  class="form-control" name=" " id="aac001s"/>
                            </div>
                                                  
                        </div>
                        <div class="form-group">
                         <label class="span2 control-label">性别</label>
                            <div class="span2">
                                 <select    class="form-control selectpicker">
                                    <option value="0">男</option>
                                    <option value="1">女</option>
                                </select>
                            </div>   
                          <label class="span2 control-label">户籍地址</label>
                            <div class="span2">
                               <input type="text"  placeholder="请输入户籍地址" class="form-control" name=" " id="aac001s"/>
                            </div>
                            <label class="span2 control-label">养老账户类别</label>
                            <div class="span2">
                                <select    class="form-control selectpicker">
                                    <option value="0">请选择</option>
                                    <option value="1">......</option>
                                </select>
                            </div>                
	                    
                	    </div>
                	    <div class="form-group">
                	       <label  for="ywlsh" class="span2 control-label">单位类型</label>
	                        <div class="span2">
	                          <input type="text" placeholder="请输入单位类型" class="form-control" name="" id=""/>
	                         </div>
	                        <label class="span2 control-label">单位代码</label>
	                        <div class="span2">
	                           <input type="text" placeholder="请输入单位代码" class="form-control" name="" id=""/>
	                        </div>
                          <label class="span2 control-label">单位名称</label>
                            <div class="span2">
                               <input type="text"  placeholder="请输入单位名称" class="form-control" name=" " id="aac001s"/>
                            </div>  
                	      </div>
                        </div> 
                    </div>
                </div>

             <!-- 标签 start -->
              <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title"> <div class="dec_1"></div>
                                                              申请人填报信息
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                        </button>
                    </div>
                </div>
                
              <!-- 标签 end -->
                <%--<!-- box-body -->--%>
                <div class="box-body">
                    <div class="form-horizontal">
                     <!-- form-group -->
                       <div class="form-group" align="center">
                            <div class="span4">
				                <div class="radio-list">
				                  <label class="radio-inline">
				                    <input type="radio" name="optionsRadios" id="optionsRadios22" value="option1" checked>
				                   		 联网办理 </label>
				                  <label class="radio-inline">
				                    <input type="radio" name="optionsRadios" id="optionsRadios23" value="option2" checked>
				                                             手工办理</label>
				                </div>
				          </div>
                       </div>
                    <!-- form-group -->
                         <div class="form-group">
                           <label class="span2 control-label">原参保地行政区划分码</label>
                           <div class="span2">
                                <select    class="form-control selectpicker">
                                    <option value="0">请选择</option>
                                    <option value="1">......</option>
                                </select>
                           </div>
                            <label class="span2 control-label">原社保机构名称</label>
                           <div class="span2">
                               <input type="text" class="form-control" name=" " id="aac003"/>
                           </div>
                            <label class="span2 control-label">申请转移地类型</label>
                           <div class="span2">
                                  <select    class="form-control selectpicker">
                                    <option value="0">请选择</option>
                                    <option value="1">......</option>
                                </select>
                           </div>     
               	       </div> 
               	       <!-- form-group -->
                         <div class="form-group">
                          <label class="span2 control-label">原社保机构地址</label>
                           <div class="span2">
                              <input type="text" class="form-control" name=" " id="aac003"/>
                           </div>
                           <label class="span2 control-label">原社保机构邮政编码</label>
                           <div class="span2">
                                <input type="text" class="form-control" name=" " id="aac003"/>
                           </div>
                           <label class="span2 control-label">原社保机构联系电话</label>
                           <div class="span2">
                                <input type="text" class="form-control" name=" " id="aac003"/>
                           </div>
               	       </div>     
               	        <!-- form-group -->
                         <div class="form-group">
                          <label class="span2 control-label">寄送方式</label>
                           <div class="span2">
                                <select    class="form-control selectpicker">
                                    <option value="0">邮政</option>
                                    <option value="1">自取</option>
                                </select>
                           </div>
                           <label class="span2 control-label">申请人联系电话</label>
                           <div class="span2">
                                <input type="text" class="form-control" name=" " id="aac003"/>
                           </div>
                           <label class="span2 control-label">备注</label>
                           <div class="span2">
                                <input type="text" class="form-control" name=" " id="aac003"/>
                           </div>
               	       </div>      
                      <!--  <div class="form-group">
                            <div class="col-sm-offset-2 span10">
                                <button type="submit" class="btn yellow" onclick="tijiao()">保存</button>
                                <button type="submit" class="btn gray" id="resetButton">作废</button>
                                <button type="submit" class="btn gray">清屏</button>
                                <button type="submit" class="btn gray">预览</button>
                                <button type="submit" class="btn gray">打印缴费凭证</button>
                            </div>
                        </div>   --> 	       
                     </div> 
                  </div>
               </div>
                    <!-- box  -->
                <div class="box box-default">
                  <ul id="myTab" class="nav nav-tabs">
			            <li class="active"><a href="#YWCL" data-toggle="tab">参保信息</a></li>
			            <li><a href="#YWCXBQ09" data-toggle="tab">欠费信息</a></li>
			       </ul> 
	               <div id="myTabContent" class="tab-content">
			            <%-- 个人参保信息 --%>
			            <div class="tab-pane active" id="YWCL">
			                <div >
			                     <table class="table table-bordered table-striped table-hover tablesorter" id="TableFile" data-resizable-columns-id="table2">
			                       <thead>
			                      <tr >                      
			                          <th colspan="1" style="width: 50px; text-align: center;"></th>
			                           <th colspan="1" style="width: 80px; text-align: center;" >险种类型</th>
			                           <th colspan="1" style="width: 80px; text-align: center;">本次参保日期</th>
			                           <th colspan="1" style="width: 80px; text-align: center;">个人缴费状态</th>                       
			                       </tr> 
			                       </thead>                                      
			                 </table>  
			                </div>
			            </div>
			            <!-- 个人基本信息 -->
			            <div class="tab-pane" id="YWCXBQ09">
			                <div>
			                   <table class="table table-bordered table-striped table-hover tablesorter" id="TableFile" data-resizable-columns-id="table2">
			                       <thead>
			                      <tr>                      
			                          <th colspan="1" style=" width: 50px; text-align: center;"></th>
			                           <th colspan="1" style="text-align: center;" >险种类型 </th>
			                           <th colspan="1" style="text-align: center;">费款所属期</th>
			                           <th colspan="1" style="text-align: center;">费用大类</th>    
			                           <th colspan="1" style=" text-align: center;">单位应交统筹</th>
			                           <th colspan="1" style="text-align: center;" >单位应交划入账户 </th>
			                           <th colspan="1" style="text-align: center;">个人应交统筹</th>
			                           <th colspan="1" style="text-align: center;">个人应交划入账户</th>                       
			                       </tr> 
			                       </thead>                                      
			                 </table>  
			                </div>
			            </div>
	             </div>
             </div>
                <!-- 标签 start -->
              <div class="box box-default">
                <div class="box-header with-border">
                    <h3 class="box-title"> <div class="dec_1"></div>
                                                             经办机构信息
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
                           <label class="span2 control-label">行政区划分</label>
                           <div class="span2">
                              <input type="text" class="form-control" name=" " id="aac003"/>
                           </div>
                            <label class="span2 control-label">经办机构名称</label>
                           <div class="span2">
                               <input type="text" class="form-control" name=" " id="aac003"/>
                           </div>
                            <label class="span2 control-label">电话</label>
                           <div class="span2">
                                <input type="text" class="form-control" name=" " id="aac003"/>
                           </div>
                           
               	       </div> 
               	       <!-- form-group -->
                       <div class="form-group">
                          <label class="span2 control-label">地址</label>
                           <div class="span2">
                              <input type="text" class="form-control" name=" " id="aac003"/>
                           </div>
                           <label class="span2 control-label">邮政编码</label>
                           <div class="span2">
                                <input type="text" class="form-control" name=" " id="aac003"/>
                           </div>
               	       </div>    
                       <div class="form-group">
                            <div class="col-sm-offset-2 span10">
                                <button type="submit" class="btn yellow" onclick="tijiao()">保存</button>
                                <button type="submit" class="btn gray" id="resetButton">作废</button>
                                <button type="submit" class="btn gray">清屏</button>
                                <button type="submit" class="btn gray">预览</button>
                                <button type="submit" class="btn gray">打印联系函</button>
                                <button type="submit" class="btn gray">打印申请表</button>
                            </div>
                        </div>   	       
                     </div> 
                  </div>
               </div>
               <!-- box end -->
                 </form>
           </div>
        </div>
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
      
                
                
                
<script>
    $(document).ready(function () { 
   	    $('input').iCheck({
   	      checkboxClass: 'icheckbox_square_gd',
   	      radioClass: 'iradio_square_gd',
   	      increaseArea: '80%' // optional
   	    });
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

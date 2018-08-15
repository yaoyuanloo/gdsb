<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>材料清单预览</title>
    <meta name="decorator" content="default"/>
    <style>
        .form-search .ul-form li label {
            width: 100px;
        }

        table {
            table-layout: fixed;
        }

     	.yewuleibies  li{
     		float: left;
     		margin-left:50px;
     		margin-top: 15px;
     	}
      

        #baseTable td {
            padding: 0;
        }

        #baseTable input {
            padding: 0;
            margin: 0;
            border: 0;
            width: 100%;
            height: 100%;
            background: none;
            height: 28px;
        }
		.breadcrumbs li{
			list-style: none;
		}

        #zysxTable th {
            text-align: center;
            width: 70px;
        }
        .multiBoxtable{
       		font-size: 15px;
       		color: black;
       		font-family:"Microsoft YaHei";
        }
        .multiBoxLabel{
        	font-family:"Microsoft YaHei";
        }
        .icon-caret-right{
        	color: black;
        }
        #wrap{word-break:break-all; width:200px;}
	#work-wrap{
		word-wrap: break-word;
 word-break: normal;
	}
    </style>
    <script type="text/javascript">
    function thumbnail(id,file){
		 $.ajax({ 
			 type: "POST", 
			 url: "${ctx}/gt/gtSmjinfo/showQd",  
			 data: { 
			     "yxid":id
			 },             
//			 contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			 success: function(data){ 
			   var inventory = eval( "(" + data + ")" );
			   if(inventory.length==0){
				   alert("该影像没有清单!");
				   return;
			   }
			   var picContent="";
			   $("#right").html(picContent);
			   picContent += '<div id="centerDiv" style="width: 100%; margin: 0; overflow-x: hidden; overflow-y: auto;">';
			   picContent += '<ul id="myTab" class="nav nav-tabs">';
			   picContent += '<li><a href="#YWCXBQ01" data-toggle="tab">'+inventory[0].name+'材料清单</a></li>';
			   picContent += '</ul></div>';
			   picContent += '<div id="myTabContent" class="tab-content">';
			   picContent += '<div class="tab-pane active" id="YWCXBQ01">';
			   picContent += '<div>';
			   picContent += '<ul id="qdInfo" class="nav nav-tabs nav-stacked yewuleibies">';
			   console.log(inventory);
			   for(var j=0;j<inventory.length;j++){
				   picContent+='<li style="width:350px;display:block;text-align:center;">';
                   picContent+='<a href="javascript:showpath(\'' + decodeURIComponent(inventory[j].smjpath) + '\')"><img alt="" style="width: 100%; height: 100%;" src='+(file+inventory[j].smjpath)+'></br>'+inventory[j].smjmc+'</a></li>'
				 
			   }
			   picContent +='</ul></div></div>';
			   $("#right").append(picContent);
			 }, 
			 error : function(XMLHttpRequest, textStatus, errorThrown){ 
			        alert("错误,请联系管理员！"); 
			 } 
		}); 
		
	}
    
    function showpath(path){
		var pathInfo=$("#pz").val();
        pathInfo = pathInfo.replace(/\\/g, "/");
		var CaluNumCtrl=document.getElementById("CaluNumCtrl");
        console.log(pathInfo+path);
	    var sum = CaluNumCtrl.FD_OpenPic(pathInfo+path); 
	}
    </script>
   
  
</head>
<body>
<div id="content" class="row-fluid">
<input type="hidden" id="pz" name="pz" value="${pz}">
<OBJECT id="CaluNumCtrl" align="CENTER" WIDTH=0 HEIGHT=0 codeBase="FDEye.CAB#version=1,0,0,0" classid="CLSID:99FF00A4-3A7A-4A2D-AB94-09AA5F9A8524"></OBJECT> 
    <div id="left" class="accordion-group">
        <table class="table">
            <tr>
                <td>
                <div  id="yewuleibietd">
                    <ul class="nav nav-tabs nav-stacked yewuleibie" oncontextmenu="return false;">
                       	<c:forEach items="${gtSmjinfo}" var="yxList">
	                        	 <li>
		                             <a href="javascript:thumbnail('${yxList.id}','${ctxfile}');" class="multiBox" value="">
		                               	<i class="icon-caret-right"></i>
		                                <span class="multiBoxtable">${yxList.smjmc }</span>
		                                <c:if test="${yxList.type eq 2}">
		                                	<img src="/userfiles/1/images/123.jpg"
	                                         style="width:100%;height:100%;">
	                                    </c:if>
	                                    
	                                     <c:if test="${yxList.type eq 1}">
		                                	<img src="${yxList.smjpath}"
	                                         style="width:100%;height:100%;">
	                                    </c:if>
		                            </a>
		                        </li>
                       	</c:forEach>
                     </ul>
                    </div>
                </td>
            </tr>
        </table>
    </div>
   <div id="openClose" class="close">&nbsp;</div>

      <div id="right">
			
	 </div>
</div>
<iframe id="printFrame" src="" frameborder="0" style="width: 0; height: 0;"></iframe>
<script type="text/javascript">
    var showDetailObj = null;
    var detailTrTheme = "info";
    var tableTrTheme = "";
    $(function () {
        //$("#centerDiv").css({"overflow-y" : "scroll"});
    });
    var leftWidth = 260; // 左侧窗口大小
    var htmlObj = $("html"), mainObj = $("#main");
    var frameObj = $("#left, #openClose, #right, #right iframe");
    function wSize() {
        var strs = getWindowSize().toString().split(",");
        console.log(strs);
        console.log(strs[0]);
        
        htmlObj.css({"overflow-x": "hidden", "overflow-y": "auto"});
//        $("body").css("overflow", "hidden");
        mainObj.css("width", "auto");
        frameObj.height(strs[0] - 15);
        var leftWidth = ($("#left").width() < 0 ? 0 : $("#left").width());
        $("#right").width($("#content").width() - leftWidth - $("#openClose").width() - 15);
    }
    function tableTurnCss() {
        $("#treeTableList").find("tr:odd").removeClass(tableTrTheme).removeClass(detailTrTheme);
        $("#treeTableList").find("tr:even").addClass(tableTrTheme);
    }
</script>
<script src="${ctxStatic}/common/wsize.min.js" type="text/javascript"></script>

</body>
</html>

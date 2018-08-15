<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ attribute name="input" type="java.lang.String" required="true" description="输入框"%>
<%@ attribute name="type" type="java.lang.String" required="true" description="files、images、flash、thumb"%>
<%@ attribute name="uploadPath" type="java.lang.String" required="true" description="打开文件管理的上传路径"%>
<%@ attribute name="selectMultiple" type="java.lang.Boolean" required="false" description="是否允许多选"%>
<%@ attribute name="readonly" type="java.lang.Boolean" required="false" description="是否查看模式"%>
<%@ attribute name="maxWidth" type="java.lang.String" required="false" description="最大宽度"%>
<%@ attribute name="maxHeight" type="java.lang.String" required="false" description="最大高度"%>
<ol id="${input}Preview"></ol><c:if test="${!readonly}"><a href="javascript:" onclick="${input}FinderOpen();" class="btn">${selectMultiple?'添加':'替换'}</a>&nbsp;<a href="javascript:" onclick="${input}DelAll();" class="btn">清除</a></c:if>
<script type="text/javascript">
	function ${input}FinderOpen(){//<c:if test="${type eq 'thumb'}"><c:set var="ctype" value="images"/></c:if><c:if test="${type ne 'thumb'}"><c:set var="ctype" value="${type}"/></c:if>
		var date = new Date(), year = date.getFullYear(), month = (date.getMonth()+1)>9?date.getMonth()+1:"0"+(date.getMonth()+1);
		var url = "${ctxStatic}/ckfinder/ckfinder.html?type=${ctype}&start=${ctype}:${uploadPath}/"+year+"/"+month+
			"/&action=js&func=${input}SelectAction&thumbFunc=${input}ThumbSelectAction&cb=${input}Callback&dts=${type eq 'thumb'?'1':'0'}&sm=${selectMultiple?1:0}";
		windowOpen(url,"文件管理",1000,700);
		//top.$.jBox("iframe:"+url+"&pwMf=1", {title: "文件管理", width: 1000, height: 500, buttons:{'关闭': true}});
	}
	function ${input}SelectAction(fileUrl, data, allFiles){
		var url="", files=ckfinderAPI.getSelectedFiles();
		for(var i=0; i<files.length; i++){//<c:if test="${type eq 'thumb'}">
			url += files[i].getThumbnailUrl();//</c:if><c:if test="${type ne 'thumb'}">
			url += files[i].getUrl();//</c:if>

            url = decodeURIComponent(url);
            /*
			index=url.lastIndexOf("\/");
			index_d=url.lastIndexOf(".");
			alert(index);
			alert(index_d);
			
			urltup=url.substring(index+1,index_d.length); */
			if (i<files.length-1) url+="|";
		}//<c:if test="${selectMultiple}">
		$("#${input}").val($("#${input}").val()+($("#${input}").val(url)==""?url:"|"+url));//</c:if><c:if test="${!selectMultiple}">
		$("#${input}").val(url);//</c:if>
		${input}Preview();
		//top.$.jBox.close();
	}
    function ${input}ThumbSelectAction(fileUrl, data, allFiles){
		var url="", files=ckfinderAPI.getSelectedFiles();
		for(var i=0; i<files.length; i++){
			url += files[i].getThumbnailUrl();
			if (i<files.length-1) url+="|";
		}//<c:if test="${selectMultiple}">
		$("#${input}").val($("#${input}").val()+($("#${input}").val(url)==""?url:"|"+url));//</c:if><c:if test="${!selectMultiple}">
		$("#${input}").val(url);//</c:if>
		${input}Preview();
		//top.$.jBox.close();
	}
	function ${input}Callback(api){
		ckfinderAPI = api;
	}
	function ${input}Del(obj){
		var url = $(obj).prev().attr("url");
		$("#${input}").val($("#${input}").val().replace("|"+url,"","").replace(url+"|","","").replace(url,"",""));
		${input}Preview();
	}
	function ${input}DelAll(){
		$("#${input}").val("");
		${input}Preview();
	}
	function ${input}Preview(){
		var li, urls = $("#${input}").val().split("|");
		var bq="";
		var cl="";
		var hzdh=$("#hzdh").val();
		 $.ajax({ 
			 type: "POST", 
			 url: "${ctx}/gt/gtSmjinfo/showcl",            
			 data: { 
			     "id":hzdh
			 },             
//			 contentType: "application/x-www-form-urlencoded;charset=UTF-8",
			 success: function(data){
				 var inventory = eval( "(" + data + ")" );
				 cl+="<select name='clm'>";
				 for(var j=0;j<inventory.length;j++){
					   cl+='<option value='+inventory[j].id+'>'+inventory[j].name+'</option>';
				 }
				 cl+="</select>";
			 }, 
			 error : function(XMLHttpRequest, textStatus, errorThrown){ 
			        alert("错误,请联系管理员！"); 
			 } 
		});
		 
		 
		 $.ajax({ 
			 type: "POST", 
			 url: "${ctx}/gt/gtSmjinfo/showyw",            
			 data: { 
			     "id":hzdh
			 },             
//			 contentType: "application/x-www-form-urlencoded;charset=UTF-8",
			 success: function(data){ 
				 var inventory = eval( "(" + data + ")" );
				 bq+="<select name='ywlsh'>";
				 for(var j=0;j<inventory.length;j++){
					   bq+='<option value='+inventory[j].id+'>'+inventory[j].name+'</option>';
				 }
				 bq+="</select>";
                 $("#${input}Preview").append(bq);
                 $("#${input}Preview").children().remove();
                 //$("#${input}Preview").append(bq);
                 for (var i=0; i<urls.length; i++){
                     if (urls[i]!=""){
                         <%--//<c:if test="${type eq 'thumb' || type eq 'images'}">--%>
                         li = "<li><img onclick='thumbnail(\""+urls[i]+"\")' src=\""+urls[i]+"\" url=\""+urls[i]+"\" style=\"max-width:200px;max-height:200px;_height:200px;border:0;padding:3px;\">"+bq+" "+cl+"</li>";
                         $("#${input}Preview").append(li);

                         <%--//</c:if>--%>
                         <%--<c:if test="${type ne 'thumb' && type ne 'images'}">
                         li = "<li><a href=\""+urls[i]+"\" url=\""+urls[i]+"\" target=\"_blank\">"+decodeURIComponent(urls[i].substring(urls[i].lastIndexOf("/")+1))+"</a>";//</c:if>
                         li += "&nbsp;&nbsp;<c:if test="${!readonly}"><a href=\"javascript:\" onclick=\"${input}Del(this);\"><i class='icon-remove-circle'></i></a>
                         </c:if>--%>
                        // $("#${input}Preview").append(bq);
                        // $("#${input}Preview").append(cl);
                     }
                 }
                 if ($("#${input}Preview").text() == ""){
                     $("#${input}Preview").html("<li style='list-style:none;padding-top:5px;'></li>");
                 }
			 }, 
			 error : function(XMLHttpRequest, textStatus, errorThrown){ 
			        alert("错误,请联系管理员！"); 
			 } 
		}); 
	}
	${input}Preview();
</script>
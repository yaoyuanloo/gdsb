<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<%
String path=request.getSession().getServletContext().getRealPath("");
%>
<html>
<head>
    <title>业务影像表管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#upload").click(function () {
                var str = "";
                var number = 0;
                $("input[name='logo']").each(function (index, item) {
                    str += $(this).val() + ",";
                });
                var syttt = str.split(",");
                for (var i = 0; i < syttt.length; i++) {
                    if (syttt[i] != "") {
                        number++;
                    }
                }

                if (number == 0) {
                    return;
                }
                $.ajax({
                    cache: true,
                    type: "POST",
                    url:"${ctx}/gt/gtSmjinfo/save",
                    data:$("#uploadFrom").serialize(),// ,// 你的formid
                    async: false,
                    success: function(data) {
                        var inventory = eval( "(" + data + ")" );
                        alert(inventory[0]);
                    },
                    error : function(XMLHttpRequest, textStatus, errorThrown){ 
    			        alert("设定成功!"); 
    			 	} 
                   
                });
            });
        });
        
        function page(n, s) {
            $("#pageNo").val(n);
            $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }
		
        function thumbnail(path){
			var pathInfo=$("#pz").val();
            pathInfo = pathInfo.replace(/\\/g, "/");
			var CaluNumCtrl=document.getElementById("CaluNumCtrl");
		    var sum = CaluNumCtrl.FD_OpenPic(pathInfo+path); 
		}
	</script>

</head>
<body>
<div class="form-search breadcrumb">
    <ul class="ul-form">
        <li><h4 style="line-height: 38px;">扫描件上传</h4></li>
        <li style="float: right; line-height: 38px; margin-right: 3px;">
            <button type="button" id="tijiao4" onclick="" class="btn btn-warning"
                    style="width: 110px;">
                <i class="icon-cloud-upload"></i>&nbsp; 高拍仪
            </button>
        </li>
        <li style="float: right; line-height: 38px; margin-right: 3px;">
            <button type="button" id="tijiao3" onclick="" class="btn btn-warning"
                    style="width: 110px;"><i
                    class="icon-cloud-upload"></i>&nbsp; 扫描仪
            </button>
        </li>
        <li style="float: right; line-height: 38px; margin-right: 3px;">
            <button type="button" id="tijiao2" onclick="" class="btn btn-warning"
                    style="width: 110px;"><i
                    class="icon-cloud-upload"></i>&nbsp;手动
            </button>
        </li>
        <li style="float: right; line-height: 38px; margin-right: 3px;">
            <button type="button" id="upload" class="btn btn-warning"
                    style="width: 110px;"><i
                    class="icon-cloud-upload"></i>&nbsp; 影像上传
            </button>
        </li>
        <li style="float: right; line-height: 38px; margin-right: 3px;">
            <button type="button" id="sureupload" onclick="update()" class="btn btn-warning"
                    style="width: 110px;"><i
                    class="icon-cloud-upload"></i>&nbsp; 确认上传
            </button>
        </li>
    </ul>
</div>
<sys:message content="${message}"/>
<input type="hidden" id="ywlsh" name="ywlsh" value="${ywlsh}">
<input type="hidden" id="hzdh" name="hzdh" value="${hzdh}">
<input type="hidden" id="pz" name="pz" value="${pz}">
<div id="myTabContent" class="tab-content">
    <div class="tab-pane active" id="YWCXBQ01">
        <form method="post" id="uploadFrom">
            <!-- <input type="hidden" value="${ywlsh}" name="ywlsh" id="ywlsh"> -->
            <input type="hidden" id="logo" name="logo" class="input-xlarge"/>
            <sys:ckfinder input="logo" selectMultiple="true" type="images" uploadPath="/YwImg"/>
        </form>
        <hr>
    </div>
</div>
<script>
    function update() {
        location.href = "${ctx}/gt/gtSmjinfo/update?ywlsh=${ywlsh}&hzdh=${hzdh}";
    }
</script>
<OBJECT id="CaluNumCtrl" style="width: 0; height: 0; margin: 0; border: 0; padding: 0;"
        codeBase="${ctxStatic}/com/FDEye.CAB" classid="CLSID:99FF00A4-3A7A-4A2D-AB94-09AA5F9A8524"></OBJECT>
</body>
</html>
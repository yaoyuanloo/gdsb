<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>文书模版列表</title>
	<meta name="decorator" content="yhdefault"/>
	<script type="text/javascript">
		$(document).ready(function() {
			 var mydropdown1=new customDropDown($("#dropdown_to_select"));
	            $('#page_selection').bootpag({
	                total:${page.last},
	    			page: ${page.pageNo},
	    			maxVisible: 5,
	    			leaps: true,
	    			firstLastUse: true,
	    			first: '首页',
	    			last: '末页',
	    			prev: '<i class="glyphicon glyphicon-chevron-left"></i>',
	    			next: '<i class="glyphicon glyphicon-chevron-right"></i>',
	                wrapClass: 'pagination pagination-sm',
	    			activeClass: 'active',
	    			disabledClass: 'disabled',
	    			nextClass: 'next',
	    			prevClass: 'prev',
	    			lastClass: 'last',
	    			firstClass: 'first'
	    	    }).on('page', function(event, num){
	    	    	page(num,${page.pageSize});
	            });
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#dwrittemList").submit();
        	return false;
        }
		function customDropDown(ele){
				this.dropdown=ele;
				this.placeholder=this.dropdown.find(".placeholder");
				this.options=this.dropdown.find("ul.dropdown-menu > li");
				this.val='';
				this.index=-1;//默认为-1;
				this.initEvents();
		}
	        
	    customDropDown.prototype={
	    			initEvents:function(){
	    				var obj=this;
	    				obj.options.on("click",function(){
	    					var opt=$(this);
	    					obj.text=opt.find("a").text();
	    					obj.val=opt.attr("value");
	    					obj.index=opt.index();
	    					obj.placeholder.text(obj.text);
	    					page(${page.pageNo},obj.text);
	    				});
	    			},
	    			getText:function(){
	    				return this.text;
	    			},
	    			getValue:function(){
	    				return this.val;
	    			},
	    			getIndex:function(){
	    				return this.index;
	    			}
	    }
		
		
		
		 function dwrittemAdd(id){
	        showDialog(id);
	     }
	        
	     function dwrittemUpdate(id){
	        showDialog(id);
	     }
	       
	        
       	function showDialog(id){
       		var stats="";
       		if(id==""){
       			stats="新增";
       		}else{
       			stats="修改";
       		}
       		BootstrapDialog.show({
               title: '地级市业务分类'+stats,
               message: '<iframe src="${ctx}/city/dWrittemp/form?id='+id+'" width="570" height="216" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" id="iframe1" allowtransparency="yes"></iframe>',
               buttons: [{
                   label: '保存',
                   cssClass:'btn btn-warning',
                   action: function(dialog){
                       var oFrameWin = document.getElementById("iframe1").contentWindow;
                   		oFrameWin.document.getElementById("dwrittemForm").submit();
                   		dialog.close();
                   		location.href="${ctx}/city/dWrittemp/list";
                   }
               	}, {
                   label: '关闭',
                   action: function(dialog){
                       dialog.close();
                   }
               }, ]
           });
       }
	        
	</script>
</head>
<body>
	<!--页面主体-->
<div class=""> 
  <!--行一-->
  <div class="row">
    <div class="span12"> 
      <!-- box -->
      <div class="box box-default"> 
        <!-- box-header -->
        	<div class="box-header with-border">
                  <h3 class="box-title">
                      <div class="dec_1"></div>
                    	  地级市业务分类列表
                  </h3>
                  <div class="box-tools pull-right">
                      <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                  </div>
           </div>
        <!-- box-body -->
        <div class="box-body">
          <form class="form-horizontal" name="myform" id="myform" method="post" action="${ctx}/city/dWrittemp/">
            <div class="form-group pull-rigth">
            		<div class="pull-right">
	               		<label class="span2 control-label">名称：</label>
	               		<div class="span6">
                			<input type="text" value="${name}" placeholder="请输入角色名" class="form-control" name="name" id="name"/>
              			</div>
	              		<button type="submit" class="btn btn-sm yellow">查询</button>
              			<button type="button" onclick="dwrittemAdd('')" class="btn btn-sm yellow">新增</button>
	              	</div>
            </div>
          </form>
          <sys:message content="${message}"/>
        <form class="form-horizontal" name="dwrittemList" id="dwrittemList" method="post" action="${ctx}/city/dWrittemp/">
		       	<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
				<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		        <table id="contentTable" class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th>名称</th>
						<th>更新时间</th>
						<th>备注信息</th>
						<th>文书列表</th>
						<shiro:hasPermission name="city:dWrittemp:edit"><th>操作</th></shiro:hasPermission>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${page.list}" var="dWrittemp">
					<tr>
						<td><a href="${ctx}/city/dWrittemp/form?id=${dWrittemp.id}">
							${dWrittemp.name}
						</a></td>
						<td>
							<fmt:formatDate value="${dWrittemp.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td>
							${dWrittemp.remarks}
						</td>
						<td>
							<a href="${ctx}/city/dWrittempinfo/list?id=${dWrittemp.id}">文书列表</a>
						</td>
						<shiro:hasPermission name="city:dWrittemp:edit"><td>
		    				<a href="javascript:void(0)" onclick="dwrittemUpdate('${dWrittemp.id}')">修改</a>
							<a href="${ctx}/city/dWrittemp/delete?id=${dWrittemp.id}" onclick="return confirmx('确认要删除该地级市业务分类吗？', this.href)">删除</a>
						</td></shiro:hasPermission>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		            <!--pager-->
		              	<div class="pull-right">
			                <div class="pageinfo"> 
			                	${page}
			                </div>
		                	<span id="page_selection"></span> 
		                </div>
		            <!-- red pager-->
         </form>
        </div>
      </div>
    </div>
  </div>
  <!--行一./-->  
</div>
</body>
</html>
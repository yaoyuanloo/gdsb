<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>本地业务制定管理</title>
	<meta name="decorator" content="yhdefault"/>
	<script type="text/javascript">
	
		 <!--让多选框单选-->
	        $(document).ready(function() {
	            $(':checkbox[name="checkid"]').each(function(){
	                $(this).click(function(){
	                    if($(this).attr('checked')){
	                        $(':checkbox[name="checkid"]').removeAttr('checked');
	                        $(this).attr('checked','checked');
	                    }
	                });
	            });
	            
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
	      
	        
	        function RoleAdd(id){
	        	showDialog(id);
	        }
	        
	        function RoleUpdate(id){
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
                    title: '柜台受理角色'+stats,
                    message: '<iframe src="${ctx}/city/gtRole/form?id='+id+'" width="570" height="250" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" id="iframe1" allowtransparency="yes"></iframe>',
                    buttons: [{
                        label: '保存',
                        cssClass:'btn btn-warning',
                        action: function(dialog){
	                        var oFrameWin = document.getElementById("iframe1").contentWindow;
	                    	oFrameWin.document.getElementById("inputForm").submit();
	                    	dialog.close();
	                    	location.href="${ctx}/city/gtRole/list";
                        }
                    	}, {
                        label: '关闭',
                        action: function(dialog){
                            dialog.close();
                        }
                    }, ]
                });
	        }
	        
	        
	        function page(n,s){
				$("#pageNo").val(n);
				$("#pageSize").val(s);
				$("#contentTable").submit();
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
	</script>
</head>
<body>
<!--页面主体-->
<div class=""> 
 <sys:message content="${message}"/>
  <!--行一-->
  <div class="row">
    <div class="span12"> 
      <!-- box -->
      <div class="box box-default"> 
        <!-- box-header -->
       	  <div class="box-header with-border">
                    <h3 class="box-title">
                        <div class="dec_1"></div>
                        定制用户角色
                    </h3>
                    <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    </div>
          </div>
      
        <!-- box-body -->
        <div class="box-body">
          <form class="form-horizontal" name="contentTable" id="contentTable" method="post" action="${ctx}/city/gtRole/">
           		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
				<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	            <div class="form-group pull-rigth">
	              	<div class="pull-right">
	               		<label class="span3 control-label">角色名：</label>
	              		<div class="span5">
	                		<input type="text" value="${jsname }" placeholder="请输入角色名" class="form-control" name="jsname" id="jsname"/>
	              		</div>
	              		<button type="submit" class="btn btn-sm yellow">查询</button>
	              		<button type="button" onclick="RoleAdd('')" id="popbtn" class="btn btn-sm yellow">新增</button>
	              	</div>
	            </div>
          </form>
            <table class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>角色名</th>
				<th>角色编号</th>
				<th>状态</th>
				<shiro:hasPermission name="city:gtRole:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="gtRole">
			<tr>
				<td><a href="${ctx}/city/gtRole/form?id=${gtRole.id}">
					${gtRole.name}
				</a></td>
				<td>
					${gtRole.code}
				</td>
				<td>
					${fns:getDictLabel(gtRole.state, 'state', '')}
				</td>
				<shiro:hasPermission name="city:gtRole:edit"><td>
    				<a href="javascript:void(0)" onclick="RoleUpdate('${gtRole.id}')">修改</a>
					<a href="${ctx}/city/gtRole/delete?id=${gtRole.id}" onclick="return confirmx('确认要删除该柜台受理角色管理吗？', this.href)">删除</a>
					<a href="${ctx}/city/gtRole/shouquan?id=${gtRole.id}&companyid=${gtRole.zone}">授权</a>
			
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
        </div>
      </div>
    </div>
  </div>
  <!--行一./-->  
</div>
</body>
</html>
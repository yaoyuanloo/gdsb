<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>文书模板信息表管理</title>
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
			$("#dWrittempinfoform").submit();
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
  <!--行一-->
  <div class="row">
    <div class="span12"> 
      <!-- box -->
      <div class="box box-default"> 
        <!-- box-header -->
		<div class="box-header with-border">
                  <h3 class="box-title">
                      <div class="dec_1"></div>
                    	  文书模板信息列表
                  </h3>
                  <div class="box-tools pull-right">
                      <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                  </div>
         </div>
        
         
         
        <!-- box-body -->
        <div class="box-body">
          <form class="form-horizontal" name="myform" id="myform" method="post" action="${ctx}/city/dWrittempinfo/">
             <div class="form-group pull-rigth">
            	<div class="pull-right span4">
	               	<label class="span3 control-label">模板名称：</label>
	               	<div class="span5">
                		<input type="text" value="${mbname}" placeholder="请输入模板名称" class="form-control" name="mbname" id="mbname"/>
              		</div>
	              	<button type="submit" class="btn btn-sm yellow">查询</button>
	              	<button type="button" class="btn btn-sm yellow">新增</button>
              		<button type="button" onclick="javascript:window.location.href='${ctx}/city/dWrittemp/list'" class="btn btn-sm gray">返回</button>
	           </div>
            </div>
          </form>
          <sys:message content="${message}"/>
         <form class="form-horizontal" name="dWrittempinfoform" id="dWrittempinfoform" method="post" action="${ctx}/city/dWrittempinfo/">
      			<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
				<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
       			<table id="contentTable" class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th>模板名称</th>
							<th>更新时间</th>
							<th>备注信息</th>
						 <th>操作</th>
						</tr>
			      </thead>
				  <tbody>
					 <c:forEach items="${page.list}" var="dWrittempinfo">
						<tr>
							<td><a href="${ctx}/city/dWrittempinfo/form?id=${dWrittempinfo.id}">
								${dWrittempinfo.name}
							</a></td>
							<td>
								<fmt:formatDate value="${dWrittempinfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
							</td>
							<td>
								${dWrittempinfo.remarks}
							</td>
							<td>
				    				<a href="${ctx}/city/dWrittempinfo/form?id=${dWrittempinfo.id}">修改</a>
									<a href="${ctx}/city/dWrittempinfo/delete?id=${dWrittempinfo.id}" onclick="return confirmx('确认要删除该文书模板信息表吗？', this.href)">删除</a>
							</td>
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
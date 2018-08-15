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
	        function page(n,s){
	            $("#pageNo").val(n);
	            $("#pageSize").val(s);
	            $("#myform").submit();
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
           定制本地业务属性</h3>
          <div class="box-tools pull-right">
            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
          </div>
        </div>
        <!-- box-body -->
        <div class="box-body">
        	 <sys:message content="${message}"/>
          <form class="form-horizontal" name="myform" id="myform" method="post" action="">
           	<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
			<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
            <div class="form-group" style="">
              <div class="pull-right">
                <!-- <button type="button" class="btn btn-sm yellow"><a href="javascript:void(0);" class="popbtn">新增</a></button> -->
              </div>
            </div>
            <table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>类型编号</th>
				<th>业务类型</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="pYwCate">
			<tr>
				<td>
					${pYwCate.code}
				</td>
				<td>
					${pYwCate.name}
				</td>

				<td>${fns:getDictLabel(pYwCate.state, 'state', '无')}</td>
				<td>
    				<a href="${ctx}/city/dYwinfo/getywList?id=${pYwCate.id}">业务列表</a>
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
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
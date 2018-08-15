<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>公共业务信息表管理</title>
	<meta name="decorator" content="yhdefault"/>
	<script type="text/javascript">
			$(document).ready(function() {
				var str ="${listYwid}";
				$(str.split(",")).each(function (i,dom){
					$(":checkbox[value='"+dom+"']").prop("checked",true);
					$(":checkbox[value='"+dom+"']").attr("disabled", true);
				});
			
			
				$('input[name="checkid"]').each(function(){
	                if($(this).attr('checked')){
	                    $(this).attr('checked','checked');
	                }
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
	            $("#ywform").submit();
	            return false;
	        }



	        function checkInfo(){
	            obj = document.getElementsByName("checkid");
	            check_val = [];
	            for(k in obj){
	                if(obj[k].checked)
	                    check_val.push(obj[k].value);
	            }
	            if(check_val.length>0){
	            	$.ajax({
	            		type:'post',
	            		url:"${ctx}/city/dYwinfo/tbDyinfo?ids="+check_val,
	            		data:{},
	            		cache:false,
	            		dataType:'json',
	            		success:function(data){
	            			if(data!=null){
	            			  alert(data.msg);
	            			}
	            		}
	            		
	            	});
	            }else{
	                alert('请选择类别');
	            }
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
          定制本地业务</h3>
          <div class="box-tools pull-right">
            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
          </div>
        </div>
        <!-- box-body -->
        <div class="box-body">
          <form modelAttribute="pYwCate" class="form-horizontal" name="ywform" id="ywform" method="post" action="${ctx}/city/dYwinfo/getywList">
           		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
				<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
				<input type="hidden" value="${pYwCate.id }" id="id" name="id">
	            <div class="form-group">
	              <div class="pull-right">
	                <button type="button" class="btn btn-sm yellow" onclick="checkInfo()">添加</button>
	                <button type="button" class="btn btn-sm gray" onclick="javascript:window.location.href='${ctx}/city/dYwinfo/list'">返回</button>
	              </div>
	            </div>
				<table id="contentTable" class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th>业务编码</th>
							<th>业务名称</th>
							<th>备注信息</th>
						</tr>
					</thead>
					<tbody>
				<c:forEach items="${page.list}" var="pYwinfo">
					<tr>
						<td>
						    <input type="checkbox" name="checkid" value="${pYwinfo.id}"/>
							${pYwinfo.code}
						</td>
						<td>
								${pYwinfo.name}
						</td>
						<td>
							${pYwinfo.remarks}
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
</div>



</body>
</html>
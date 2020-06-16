<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>图书管理系统</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/xadmin.css">
<script src="./lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
<!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>
<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"><c:choose>
								<c:when test="${admin.type==1}"><span>超级管理员</span></c:when>
								<c:otherwise><span>管理员</span></c:otherwise>
						</c:choose>
							： <span class="x-red">${admin.account}</span><span>&nbsp;欢迎使用图书借阅平台</span>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			onclick="location.reload()" title="刷新"> <i
			class="layui-icon layui-icon-refresh" style="line-height: 30px"></i></a>
	</div>
	<div class="layui-fluid">
		<div class="layui-row layui-col-space15">
			<div class="layui-col-md12">
				<div class="layui-card">
					<div class="layui-card-body ">
						<form class="layui-form layui-col-space5" action="${path }/borrowListY">

							<div class="layui-inline layui-show-xs-block">
								<input type="text" name="book_id" placeholder="请输入图书编号"
									autocomplete="off" class="layui-input">
							</div>
							<div class="layui-inline layui-show-xs-block">
								<input type="text" name="u_id" placeholder="请输入用户ID"
									autocomplete="off" class="layui-input">
							</div>

							<div class="layui-inline layui-show-xs-block">
								<button class="layui-btn" lay-submit="" lay-filter="sreach">
									<i class="layui-icon">&#xe615;</i>
								</button>
							</div>
							
						</form>
					</div>
					<div class="layui-card-header">
				
						<button class="layui-btn"
							onclick="xadmin.open('办理借阅','${path}/admin/borrowAdd.jsp',600,550)">
							<i class="layui-icon"></i>办理借阅
						</button>
					</div>
					<div class="layui-card-body ">
						<table class="layui-table layui-form">
							<thead>
								<tr>
								<!--	<th><input type="checkbox" name="" lay-skin="primary">
									</th>
									-->
									<th>序号</th>
									<th>图书编号</th>
									<th>图书名称</th>
									<th>用户ID</th>
									<th>用户名</th>
									<th>借书时间</th>
									<th>还书时间</th>
									<th>是否逾期</th>
									<th>归还状态</th>
									<th>操作</th>
							</thead>
							<tbody>
	
			
			
							  <c:forEach items="${borrowList }" var="borrow" varStatus="status">
							  <c:if test="${borrow.ory}">
							  
								<tr id="table">
									<td>
									<!--<input type="checkbox" name="aid"
										value="${type.u_id }" lay-skin="primary">
										-->
										${status.count }
										</td>
									  <td>${borrow.book_id }</td>
							          <td>${borrow.bookname }</td>
							          <td>${borrow.user_id }</td>
							          <td>${borrow.u_name }</td>
							          <td>${borrow.borrow_date }</td>
							          <td>${borrow.back_date }</td>
							          <td>
						
						 <c:choose>
						 <c:when test="${borrow.ory}">
						 	<span style="color:red; font-size: 14px;font-weight: bold; ">逾期</span>
						 </c:when>
						 <c:otherwise>
							未逾期
						 </c:otherwise>
						 </c:choose>
				
							          </td>
							          
							          <td class="td-status">
                             
        						 <c:choose>
							          <c:when test="${borrow.or_back == 0}">
							            <a class="layui-btn layui-btn-normal layui-btn-mini" style="background-color: #009688"
                               
                                    >
							          预约未取
							          </a>
							          </c:when>
							          <c:when test="${borrow.or_back == 1}">
							              <a class="layui-btn layui-btn-normal layui-btn-mini" style="background-color: red"

                                    >
							          未还
							           </a>
							          </c:when>
							          <c:otherwise>
							                  <a class="layui-btn layui-btn-normal layui-btn-mini" 
                                
                                    >
							          
							             已还
							              </a>
							          </c:otherwise>
							     </c:choose>
                                    </td>
							          
							          

									<td class="td-manage"><a title="编辑"
										onclick="xadmin.open('编辑','/bookDB/borrowById?id=${borrow.id }&all=all')"
										href="javascript:;"> <i class="layui-icon">&#xe642;</i>
									</a> 
												<c:if test="${borrow.or_back == 2 }">
									<a title="删除"
										href="javascript:deleteAdmin(${borrow.id });">
											<i class="layui-icon">&#xe640;</i>
									</a>
									</c:if> </td>
								</tr>
								</c:if>
								</c:forEach>
					
							</tbody>
						</table>
					</div>
					<div>
						<div >

						</div>
					</div>
				</div>
				

			</div>
		</div>
	</div>
</body>
<script>

</script>
<script>
      layui.use(['laydate','form'], function(){
        var laydate = layui.laydate;
        var form = layui.form;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });

       /*用户-停用*/
      function member_stop(obj,id){
          layer.confirm('确认要停用吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
              }
              
          });
      }
       
       

//   	  window.open ("kl.jsp", "", "height=200, width=400, top=400, left=400");

      
      
      
      
      /*用户-删除*/
      function deleteAdmin(id){
		var r=confirm("您确定删除此记录吗？");
		if (r==true){
			  window.location.href="${path}/borrowDelete?id="+id;
		}
	
	}
      
      
//     function deleteAdmin(id,i){
    	 
  	
//     }
      
      /*
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              $(obj).parents("tr").remove();
              layer.msg('已删除!',{icon:1,time:1000});
          });
      }
      
      */
      
      

      function delAll (argument) {

        var data = tableCheck.getData();
  
        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
      }
    </script>
<script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
</html>
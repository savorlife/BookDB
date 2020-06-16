<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.systop.entity.Admin"%>
<%@ page import="com.systop.dao.AdminDAO"%>
<%@ page import="com.systop.dao.impl.AdminDAOimpl"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>图书借阅平台</title>
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
		<span class="layui-breadcrumb"> <c:choose>
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
						<form class="layui-form layui-col-space5" action="${path }/typeList">

							<div class="layui-inline layui-show-xs-block">
								<input type="text" name="typeName" placeholder="请输入搜素内容"
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
							onclick="xadmin.open('添加类型','${path}/admin/typeAdd.jsp',600,400)">
							<i class="layui-icon"></i>添加
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
									<th>类型名程</th>
									<th>操作</th>
							</thead>
							<tbody>
					
							
							
							  <c:forEach items="${typeList }" var="type" varStatus="status">
								<tr>
									<td>
					
										${status.count }
										</td>
							          <td>${type.typeName }</td>


									<td class="td-manage"><a title="编辑"
										onclick="xadmin.open('编辑','/bookDB/typeFindId?id=${type.typeID }')"
										href="javascript:;"> <i class="layui-icon">&#xe642;</i>
									</a> 
									<a title="删除"
										href="javascript:deleteType(${type.typeID },'${type.typeName}');">
											<i class="layui-icon">&#xe640;</i>
									</a></td>
								</tr>
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
      function deleteType(id,name){
		var r=confirm("您确定要删除“"+name+"”类型吗？");
		if (r==true){
			  window.location.href="${path}/typeDel?id="+id;
		}
	
	}
      
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
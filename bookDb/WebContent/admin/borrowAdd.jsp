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
<link rel="stylesheet" href="${path }/css/font.css">
<link rel="stylesheet" href="${path }/css/xadmin.css">
<script type="text/javascript" src="${path }/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="${path }/js/xadmin.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>
<body>
	<div class="layui-fluid">
		<div class="layui-row">
			<form class="layui-form" method="post" action="${path}/borrowAdd" >
			
			
			<div class="layui-form-item">
					<label for="L_id" class="layui-form-label"> <span
						class="x-red">*</span>图书编号
					</label>
					<div class="layui-input-inline">
						<input type="number" id="book_id" name="book_id" onblur="funBook()"
							value="" required="" lay-verify="id"
							autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red" id="bookname"></span>
					</div>
				</div>
				
				<div class="layui-form-item">
					<label for="L_id" class="layui-form-label"> <span
						class="x-red">*</span>用户ID
					</label>
					<div class="layui-input-inline">
						<input type="text" id="user_id" name="user_id" onblur="fun()"
							value="" required="" lay-verify="id"
							autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red" id="u_name"></span>
					</div>
				</div>
				
				
				

				
				
				
				
				
			<div class="layui-form-item" >
					<label for="L_id" class="layui-form-label"> <span
						class="x-red">*</span>借阅日期
					</label>
				<div class="layui-input-inline">
						 <input type="text" value="${nowDate.format(time)}" class="layui-input" name="borrow_date" id="borrow_date">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red"></span>
					</div>
			</div>
				
				
	
				
				<div class="layui-form-item">
					<label class="layui-form-label" ><span class="x-red">*</span>借阅状态</label>
					<div class="layui-input-inline" style="width: 255px;">
						<input type="radio" name="type" lay-skin="primary" title="预约未取" value="0" > 
						<input type="radio" name="type" lay-skin="primary" title="未还" value="1" checked="checked">
						<input type="radio" name="type" lay-skin="primary" title="已还" value="2" >
					</div>
				</div>
		
				<div class="layui-form-item">
					<label for="L_repass" class="layui-form-label"> </label>
					<button class="layui-btn" lay-filter="add" lay-submit="">
						办理</button>
				</div>
			</form>
		</div>
	</div>
	<script src="${path }/js/AjaxCha.js" ></script>
	<script src="${path }/js/AjaxChaBook.js" ></script>
	<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //执行一个laydate实例
  laydate.render({
	    elem: '#borrow_date' //指定元素
	  });
});
</script>
	<script>layui.use(['form', 'layer','jquery'],
                function() {
            $ = layui.jquery;
            var form = layui.form,
            layer = layui.layer;

 
                form.onsubmit();
    
                
				/*
                //监听提交
                form.on('submit(add)',
                function(data) {
                    console.log(data);
                    //发异步，把数据提交给php
                    layer.alert("增加成功", {
                        icon: 6
                    },
                    function() {
                        //关闭当前frame
                        xadmin.close();

                        // 可以对父窗口进行刷新 
                        xadmin.father_reload();
                    });
                    return false;
                });

        
				
				*/
        });
	//实现Ajax重要的内容
	
        </script>
	<script>var _hmt = _hmt || []; (function() {
                var hm = document.createElement("script");
                hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
                var s = document.getElementsByTagName("script")[0];
                s.parentNode.insertBefore(hm, s);
            })();</script>
</body>

</html>

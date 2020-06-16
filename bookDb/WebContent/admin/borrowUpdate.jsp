<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.systop.entity.Admin"%>
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
<script type="text/javascript" src="./lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>
<body>
	<div class="layui-fluid">
		<div class="layui-row">
			<form class="layui-form" method="post" action="${path }/borrowUpdate">
			
			
			
			<div class="layui-form-item" hidden="" >
					<label for="L_id" class="layui-form-label"> <span
						class="x-red">*</span>ID
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_id" name="id" readonly="readonly"
							value="${borrow.id}" required="" lay-verify="id"
							autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red">您无权修改ID</span>
					</div>
				</div>
				
					<div class="layui-form-item" <c:if test="${all!=1}">hidden=""</c:if>>
					<label for="L_id" class="layui-form-label"> <span
						class="x-red">*</span>图书编号
					</label>
					<div class="layui-input-inline">
						<input type="text" id="book_id" name="book_id" onblur="funBook()"
							value="${borrow.book_id}" required="" lay-verify="id"
							autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red" id="bookname"></span>
					</div>
				</div>
				
				<div class="layui-form-item" <c:if test="${all!=1}">hidden=""</c:if>>
					<label for="L_id" class="layui-form-label"> <span
						class="x-red">*</span>用户ID
					</label>
					<div class="layui-input-inline">
						<input type="text" id="user_id" name="user_id" onblur="fun()"
							value="${borrow.user_id}" required="" lay-verify="id"
							autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red" id="u_name"></span>
					</div>
				</div>
				
				
				
				
				
				
			<div class="layui-form-item" <c:if test="${all!=1}">hidden=""</c:if>>
					<label for="L_id" class="layui-form-label"> <span
						class="x-red">*</span>借阅日期
					</label>
				<div class="layui-input-inline">
						 <input type="text" value="${borrow.borrow_date}" class="layui-input" name="borrow_date" id="borrow_date">
					</div>

				
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red"></span>
					</div>
			</div>
				
				
				
			<div class="layui-form-item" <c:if test="${all!=1}">hidden=""</c:if>>
					<label for="L_id" class="layui-form-label"> <span
						class="x-red">*</span>还书日期
					</label>
				<div class="layui-input-inline">
						 <input type="text" value="${borrow.back_date}" class="layui-input" name="back_date" id="back_date">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red"></span>
					</div>
			</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="x-red">*</span>借阅状态</label>
					<div class="layui-input-block">
						<input type="radio" name="type" lay-skin="primary" title="预约未取" value="0" <c:if test="${borrow.or_back==0}">checked=""</c:if>> 
						<input type="radio" name="type" lay-skin="primary" title="未还" value="1" <c:if test="${borrow.or_back==1}">checked=""</c:if>>
					<input type="radio" name="type" lay-skin="primary" title="已还" value="2" <c:if test="${borrow.or_back==2}">checked=""</c:if>>
					</div>
				</div>
	
				<div class="layui-form-item">
					<label for="L_repass" class="layui-form-label"> </label>
					<button class="layui-btn" lay-filter="add" lay-submit="">
						修改</button>
				</div>
			</form>
		</div>
	</div>
		<script src="${path }/js/AjaxCha.js" ></script>
			<script src="${path }/js/AjaxChaBook.js" ></script>
	<script src="/static/build/layui.js"></script>
<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //执行一个laydate实例
  laydate.render({
    elem: '#back_date' //指定元素
  });
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

            //自定义验证规则
            form.verify({
            	account: function(value) {
                    if (value.length < 5) {
                        return '账号至少得5个字符啊';
                    }
                },
                adminpass: [/(.+){6,12}$/, '密码必须6到12位'],
                readminpass: function(value) {
                    if ($('#L_adminpass').val() != $('#L_readminpass').val()) {
                        return '两次密码不一致';
                    }
                }
            });
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
		
        
        </script>
	<script>var _hmt = _hmt || []; (function() {
                var hm = document.createElement("script");
                hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
                var s = document.getElementsByTagName("script")[0];
                s.parentNode.insertBefore(hm, s);
            })();</script>
</body>

</html>

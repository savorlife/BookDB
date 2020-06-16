<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String path=request.getContextPath();
request.setAttribute("path", path);
%>
<!doctype html>
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>图书借阅平台</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" href="${path}/css/font.css">
<link rel="stylesheet" href="${path}/css/login.css">
<link rel="stylesheet" href="${path}/css/xadmin.css">
<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<script src="${path}/lib/layui/layui.js" charset="utf-8"></script>
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-bg">

	<div class="login layui-anim layui-anim-up">
		<div class="message">图书借阅平台后台管理登录</div>
		<div id="darkbannerwrap"></div>

		<form  method="post" action="${path}/login" class="layui-form"
			onsubmit="return check()">
			<input name="adminName" id="adminName" placeholder="用户名" type="text"
				lay-verify="required" class="layui-input">
			<hr class="hr15">
			<input name="adminPwd" id="adminPwd" lay-verify="required"
				placeholder="密码" type="password" class="layui-input">
			<hr class="hr15">
			<input value="登录" lay-submit lay-filter="login" style="width: 100%;"
				type="submit">
			<hr class="hr20">

		</form>
		<span style="color:red;font-size:16px;">${cuo}</span>

	</div>

	<script>
    function check(){
    	var adminName=document.getElementById("adminName").value;
    	var adminPwd=document.getElementById("adminPwd").value;
    	if (adminName == null || adminName ==""){
        	alert("用户名不能为空");

        	return false;
    	}   
    	if(adminPwd == null || adminPwd ==""){
    		alert("密码不能为空");

    	      return false;
    	}
    	
    	return true;
    }
//        $(function  () {
//            layui.use('form', function(){
//              var form = layui.form;
              // layer.msg('玩命卖萌中', function(){
              //   //关闭后的操作
              //   });
              //监听提交
//              form.on('submit(login)', function(data){
                // alert(888)
//                layer.msg(JSON.stringify(data.field),function(){
//                    location.href='/hagen_dazs/admin/doLogin.jsp'
//                });
//                return false;
//              });
//            });
//        })
       

    </script>
</body>
</html>
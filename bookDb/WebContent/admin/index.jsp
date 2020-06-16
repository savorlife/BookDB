<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page import="com.systop.entity.Borrow"%>
<%@ page import="com.systop.dao.impl.BorrowDaoImpl"%>
<%@ page import="com.systop.dao.BorrowDao"%>
<%@ page import="java.util.List"%>

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
<link rel="stylesheet" href="${path }/css/font.css">
<link rel="stylesheet" href="${path }/css/xadmin.css">
<link rel="stylesheet" href="${path }/css/theme80.min.css">
<!-- <link rel="stylesheet" href="./css/theme5.css"> -->
<script src="${path }/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="${path }/js/xadmin.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
<script>
            // 是否开启刷新记忆tab功能
            // var is_remember = false;
        </script>
</head>
<body class="index">
	<!-- 顶部开始 -->
	<div class="container">
		<div class="logo">
			<a href="./index.html">图书借阅平台后台管理</a>
		</div>
		<div class="left_open">
			<a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
		</div>
		
		<ul class="layui-nav right" lay-filter="">
			<li class="layui-nav-item"><a href="javascript:;">${admin.account}</a>
				<dl class="layui-nav-child">
					<!-- 二级菜单 -->
					<dd>
						<a onclick="xadmin.open('个人信息','/bookDB/admin/adminUpdate.jsp',600,550)">个人信息</a>
					</dd>
					<dd>
						<a href="/bookDB/login.jsp">退出</a>
					</dd>
				</dl></li>
			<li class="layui-nav-item to-index"><a href="/bookDB/index">前台首页</a></li>
		</ul>
	</div>
	<!-- 顶部结束 -->
	<!-- 中部开始 -->
	<!-- 左侧菜单开始 -->
	<div class="left-nav" >
		<div id="side-nav">
			<ul id="nav">
			
			<li><a href="javascript:;"> <i class="iconfont left-nav-li"
						lay-tips="借阅管理">&#xe6b8;</i> <cite>借阅管理</cite> 
						
						<span id="tip1" style="background-color: red;color:#fff;font-size: 6px;display: none;
								border-radius: 4px;width: 40px; height: 16px;text-align: center;line-height: 16px;
								">新预约</span>
						
						<i
						class="iconfont nav_right">&#xe697;</i></a>
					<ul class="sub-menu">
						<li><a onclick="xadmin.add_tab('借阅记录','/bookDB/borrowList')"> <i
								class="iconfont">&#xe6a7;</i> <cite>借阅记录</cite>
								
								<span id="tip" style="background-color: red;color:#fff;font-size: 6px;display: none;
								border-radius: 4px;width: 40px; height: 16px;text-align: center;line-height: 16px;
								">新预约</span>
								
								</a></li>
						<li><a onclick="xadmin.add_tab('逾期记录','/bookDB/borrowListY')">
								<i class="iconfont">&#xe6a7;</i> <cite>逾期记录</cite>
						</a></li>
					

					</ul></li>
			
				<li><a href="javascript:;"> <i class="iconfont left-nav-li"
						lay-tips="图书管理">&#xe6b8;</i> <cite>图书管理</cite> <i
						class="iconfont nav_right">&#xe697;</i></a>
					<ul class="sub-menu">
						<li><a onclick="xadmin.add_tab('图书列表','/bookDB/bookList')"> <i
								class="iconfont">&#xe6a7;</i> <cite>图书列表</cite></a></li>
						<li><a onclick="xadmin.add_tab('图书类型','/bookDB/typeList')">
								<i class="iconfont">&#xe6a7;</i> <cite>图书类型</cite>
						</a></li>
					
					</ul></li>
			
			
				<li><a href="javascript:;"> <i class="iconfont left-nav-li"
						lay-tips="用户管理">&#xe6b8;</i> <cite>用户管理</cite> <i
						class="iconfont nav_right">&#xe697;</i></a>
					<ul class="sub-menu">
						<li><a onclick="xadmin.add_tab('用户列表','/bookDB/userList')"> <i
								class="iconfont">&#xe6a7;</i> <cite>用户列表</cite></a></li>
						<!--		
						<li><a onclick="xadmin.add_tab('用户操作','member-list.html')">
								<i class="iconfont">&#xe6a7;</i> <cite>用户操作</cite>
						</a></li>
						-->
					</ul></li>
					
					
					
				<!-- 如果是超级管理员则显示管理员列表 -->
				<c:if test="${admin.type == 1}">
				<li><a href="javascript:;"> <i class="iconfont left-nav-li"
						lay-tips="管理员管理">&#xe726;</i> <cite>管理员管理</cite> <i
						class="iconfont nav_right">&#xe697;</i></a>
					
						
						<ul class="sub-menu">
						<li><a onclick="xadmin.add_tab('管理员列表','/bookDB/adminList')">
								<i class="iconfont">&#xe6a7;</i> <cite>管理员列表</cite>
						</a></li>
					</ul>
					<!--													
					<ul class="sub-menu">
						<li><a onclick="xadmin.add_tab('管理员操作','admin-list.html')">
								<i class="iconfont">&#xe6a7;</i> <cite>管理员操作</cite>
						</a></li>
					</ul>
					-->
					</li>
					
					</c:if> 
					
				
			</ul>
		</div>
	</div>
	<!-- <div class="x-slide_left"></div> -->
	<!-- 左侧菜单结束 -->
	<!-- 右侧主体开始 -->
	<div class="page-content">
		<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
			<ul class="layui-tab-title">
				<li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
			</ul>
			<div class="layui-unselect layui-form-select layui-form-selected"
				id="tab_right">
				<dl>
					<dd data-type="this">关闭当前</dd>
					<dd data-type="other">关闭其它</dd>
					<dd data-type="all">关闭全部</dd>
				</dl>
			</div>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<iframe src='./admin/welcome.jsp' frameborder="0" scrolling="yes"
						class="x-iframe"></iframe>
				</div>
			</div>
			<div id="tab_show"></div>
		</div>
	</div>
	<div class="page-content-bg"></div>
	<style id="theme_style"></style>

</body>
<script type="text/javascript">
self.setInterval("fun()",500);


function fun() {
	//var u_id = document.getElementById("user_id").value;
		//1、创建xhr对象
		try {
			xhr = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e) {
			try {
				xhr = new XMLHttpRequest();
			} catch (ee) {
				try {
					xhr = new ActiveXObject("Msxml2.XMLHTTP");
				} catch (eee) {
					alert('该换浏览器了！浏览器不支持Ajax！');
				}
			}
		}

		if (xhr) {
			//2、创建Ajax请求，Ajax也有两种请求形式get post

				xhr.open("post", "/bookDB/tip");

			

			//3、发送Ajax请求
			xhr.send(null);
			
		xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {   //为啥等4可以看下面readyState值的含义
					//4、处理服务器响应
					var data = xhr.responseText;

					//消息展示容器

					var k = document.getElementById("tip");
					if (data == "1") {
						
						document.getElementById("tip").style.display="inline-block";
						document.getElementById("tip1").style.display="inline-block";
						
					} else {
						document.getElementById("tip").style.display="none";
						document.getElementById("tip1").style.display="none";
					}
				}
			};
		}

	}
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String path=request.getContextPath();
    %>
<!doctype html>
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>哈根达斯后台登录</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/xadmin.css">
</head>
<body>
	<div class="layui-container">
		<div class="fly-panel">
			<div class="fly-none">
				<h2>
					<img style="width: 100px" ; alt="<%=path %>/images/success.jpg"
						src="<%=path %>/images/success.jpg">
				</h2>
				<p>添加成功</p>

			</div>
		</div>
	</div>

	<script>
//    function refreshParent() {
//    	  window.opener.location.href = window.opener.location.href;
//    	  window.close();  
 //   	 }     


    window.onbeforeunload = function() {
        //这里刷新方法有很多，具体要看你的子窗口是怎样出来的
        window.opener.location.reload();
        //parent.location.reload();
        //self.opener.location.reload();
        //window.opener.location.href=window.opener.location.href;
    };
        var _hmt = _hmt || [];
        (function() {
          var hm = document.createElement("script");
          hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })();
        </script>
</body>
</html>
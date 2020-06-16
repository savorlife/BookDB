<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<form class="layui-form" method="post" action="${path}/adminAdd">
				<div class="layui-form-item">
					<label for="L_account" class="layui-form-label"> <span
						class="x-red">*</span>账号
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_account" name="account" required=""  onblur="fun()"
							lay-verify="account" autocomplete="off" class="layui-input">
					</div>
						
						<span id="keyi" class="layui-form-mid"  style="color:green; "></span>
					
					 
						<span id="chong" class="layui-form-mid" style="color:red;"></span>
					
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label"><span class="x-red">*</span>角色</label>
					<div class="layui-input-block">
						<input type="radio" name="type" lay-skin="primary" title="管理员" value="0" <c:if test="${type==0||type==null}">checked=""</c:if>> 
						<input type="radio" name="type" lay-skin="primary" title="超级管理员" value="1" <c:if test="${type==1}">checked=""</c:if>>
					</div>
				</div>
				<div class="layui-form-item">
					<label for="L_adminpass" class="layui-form-label"> <span
						class="x-red">*</span>密码
					</label>
					<div class="layui-input-inline">
						<input type="password" id="L_adminpass" name="adminpass" value="${adminpass }"
							required="" lay-verify="adminpass" autocomplete="off"
							class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">6到16个字符</div>
				</div>
				<div class="layui-form-item">
					<label for="L_readminpass" class="layui-form-label"> <span
						class="x-red">*</span>确认密码
					</label>
					<div class="layui-input-inline">
						<input type="password" id="L_readminpass" name="readminpass" value="${adminpass }"
							required="" lay-verify="readminpass" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label for="L_repass" class="layui-form-label"> </label>
					<button class="layui-btn" lay-filter="add" lay-submit="">
						增加</button>
				</div>
			</form>
		</div>
	</div>
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
	//实现Ajax重要的内容
	function fun() {
		var L_account = document.getElementById("L_account").value;
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
				xhr.open("post", "/bookDB/adminCheck?L_account="+L_account);

				//3、发送Ajax请求
				xhr.send(null);
				
			xhr.onreadystatechange = function() {
					if (xhr.readyState == 4) {   //为啥等4可以看下面readyState值的含义
						//4、处理服务器响应
						var data = xhr.responseText;

						//消息展示容器
						var span = document.getElementById("chong");
						var k = document.getElementById("keyi");
						if (data == "1") {
							k.innerHTML = '恭喜，O(∩_∩)O哈哈~可以使用';
							span.innerHTML = '';
						} else {
						//	span.style.border = "solid 1px red";
						k.innerHTML = '';
							span.innerHTML = '-_-!!!,不可以使用';
						}
					}
				};
			}

		}
        
        </script>
	<script>var _hmt = _hmt || []; (function() {
                var hm = document.createElement("script");
                hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
                var s = document.getElementsByTagName("script")[0];
                s.parentNode.insertBefore(hm, s);
            })();</script>
</body>

</html>

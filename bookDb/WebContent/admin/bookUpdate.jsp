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
        <style type="text/css">
#imgPreview {
 width: 150px;
 height: 180px;

 border: 1px solid black;
 text-align: center;
}
#prompt3 {
 width: 150px;
 height: 180px;
 text-align: center;
 position: relative;
}
#imgSpan {
 position: absolute;
 top: 60px;
 left: 46px;
}
.filepath {
 width: 150px;
 height: 180px;
 opacity: 0;
}
#img3 {
 height: 100%;
 width: 100%;
 display: block;
    position: relative;
    top: -207px;
    right: -151px;
}

</style>
</head>
<body>
	<div class="layui-fluid">
		<div class="layui-row">
			<form class="layui-form" method="post" action="${path}/bookUpdate" enctype="multipart/form-data">
			
				<div class="layui-form-item">
					<label for="L_id" class="layui-form-label"> <span
						class="x-red">*</span>图书编号
					</label>
					<div class="layui-input-inline">
						<input type="text" id="L_id" name="id" readonly="readonly"
							value="${book.id}" required="" lay-verify="id"
							autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red">无权修改</span>
					</div>
				</div>
				
				<div class="layui-form-item">
					<label for="L_id" class="layui-form-label"> <span
						class="x-red">*</span>图书名称
					</label>
					<div class="layui-input-inline">
						<input type="text" id="user_id" name="bookname"
							value="${book.bookname }" required="" lay-verify="id"
							autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red" ></span>
					</div>
				</div>
				
				
					
						<div class="layui-form-item">
					<label for="L_id" class="layui-form-label"> <span
						class="x-red">*</span>图书封面
					</label>
					<div class="layui-input-inline">
						<div id="imgPreview">
 <div id="prompt3">
 <span id="imgSpan">
 点击上传
 <br />
 <i class="aui-iconfont aui-icon-plus">&nbsp;+</i>
 <!--AUI框架中的图标-->
 </span>
 <input type="file" id="file" name="img" value="${book.img }" class="filepath" onchange="changepic(this)" accept="image/jpg,image/jpeg,image/png,image/PNG">
 <!--当vaule值改变时执行changepic函数，规定上传的文件只能是图片-->
 </div>
 <img src="${book.img }" id="img3" />
</div>
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red" ></span>
					</div>
				</div>
				
				
				
				<div class="layui-form-item">
					<label for="L_id" class="layui-form-label"> <span
						class="x-red">*</span>图书类型
					</label>
					<div class="layui-input-inline">
						<select name="booktype">
                  			<c:forEach items="${typelist }" var="type" varStatus="status">
                  			
                  			<option value="${type.typeID }" <c:if test="${type.typeID==book.booktype}">selected</c:if>>${type.typeName }</option>        
                  			</c:forEach> 
                       </select>
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red"></span>
					</div>
				</div>
				
				<div class="layui-form-item">
					<label for="L_id" class="layui-form-label"> <span
						class="x-red">*</span>作者
					</label>
					<div class="layui-input-inline">
						<input type="text" id="" name="author" 
							value="${book.author }" required="" lay-verify="id"
							autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red"></span>
					</div>
				</div>

				<div class="layui-form-item">
					<label for="L_id" class="layui-form-label"> <span
						class="x-red">*</span>出版社
					</label>
					<div class="layui-input-inline">
						<input type="text" id="" name="publisher" 
							value="${book.publisher }" required="" lay-verify="id"
							autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red"> </span>
					</div>
				</div>
				
					<div class="layui-form-item">
					<label for="L_id" class="layui-form-label"> <span
						class="x-red">*</span>定价
					</label>
					<div class="layui-input-inline">
						<input type="text" id="" name="price" 
onkeyup="value=value.replace(/[^\d.]/g,'')"
							value="${book.price }" required="" lay-verify="id"
							autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red">请输入整数或小数 </span>
					</div>
				</div>
				
						<div class="layui-form-item">
					<label for="L_id" class="layui-form-label"> <span
						class="x-red">*</span>库存
					</label>
					<div class="layui-input-inline">
						<input type="number" id="" name="kucun" 
							value="${book.kucun }" required="" lay-verify="id"
							autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">
						<span class="x-red"> </span>
					</div>
				</div>
				<div class="layui-form-item layui-form-text">
           			 <label for="desc" class="layui-form-label">简介</label>
          			  <div class="layui-input-block">
              		  <textarea  style="width: 400px;height: 170px;" placeholder="请输入内容" id="desc" name="content" class="layui-textarea">${book.content }</textarea>
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
            })();
	
	
	
	function changepic() {
		 $("#prompt3").css("display", "none");
		 var reads = new FileReader();
		 f = document.getElementById('file').files[0];
		 reads.readAsDataURL(f);
		 reads.onload = function(e) {
		 document.getElementById('img3').src = this.result;
		 $("#img3").css("display", "block");
		 $("#img3").css("top", "-13px");
		 $("#img3").css("right", "0");

		 };
		}
	
	
	
	
	
	
	
	
	</script>
</body>

</html>

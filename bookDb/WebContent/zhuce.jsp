<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>注册</title>
    <script src="/bookDB/js/jquery-3.4.1.js"></script>
    <script src="/bookDB/js/jquery-3.4.1.min.js"></script>

    <link rel="stylesheet" href="/bookDB/css/index.css">
    <link rel="stylesheet" href="/bookDB/css/mine.css">
    
    <style>
       /* #adminBtn{
        font-size: 14px;
      }
      .search{
        margin-left: 145px;
      } */
    </style>
</head>
<body>

      <!-- 头 -->
<header name="top">
  <div id="head">
    <img src="img/logo1.png" alt="">
    
    <div class="search" >
      <input type="text" class="searchtext" default="向上生长">
      <span type="button" value="提交" class="searchbtn">搜索</span>
      <a href="gaojisearch.jsp">高级搜素</a>
    </div>
    
        <c:choose>
<c:when test="${user !=null }">
<span class="adminBtn">${user.u_name }</span>
</c:when>
<c:otherwise>
<a id="adminBtn" href="javascript:void(0)">登陆</a>
</c:otherwise>
</c:choose>

    <div href="#" id="deng">
      <div id="login-header"> </div>
        <!-- 登陆框主体 -->
        <div id="login" class="login">
          <!-- 登陆框标题 -->
     
          <div id="login-title" class="login-title">登陆会员</div>
          <div class="cha"><a id="closeBtn" href="javascript:void(0)">×</a></div>
          <!-- 登陆框表单 -->
         <form action="/bookDB/loginIndex" method="POST" id="login-form">
          <div class="login-input">
              <label>登录名：</label>
              <input type="text" placeholder="请输入账号ID"name="u_id" maxlength="4" class="list-input"/>
          </div>
          
          <div class="login-input">
              <label>密&nbsp;&nbsp;&nbsp;码：</label>
              <input type="password" placeholder="请输入密码" name="u_pass" class="list-input"/>
          </div>
          <div style="color: red;margin-left: 120px;">${cuo }</div>
          
            <!-- 登陆框登陆按钮 -->
      <input type="submit"  id="loginSubmit" value="登陆会员" class="loginSubmit"/>
      </form>
      </div>
      
      <!-- 遮盖层 -->
      <div id="bg" class="bg"></div>
    </div>
    
  </div>
   
    
    </header>
    
    <nav>
    <ul>
      <li style="background-color: #fff;"><a href="/bookDB/index" >分类</a> </li>
      <li><a href="/bookDB/huiyuan/jilu" >借阅记录</a> </li>
    
      <li><a id="mine" href="/bookDB/huiyuan/mine" >
        <img src="/bookDB/img/mine.png" alt="">
        我的</a> </li>
    </ul>
    </nav>
    <div id="box" >
        <ul id="fl" style="display:none;margin-top: 20px;">
             <c:forEach items="${typelist }" var="type" varStatus="status">
                   <li>
    <a href="/bookDB/index?type=${type.typeID }">
        ${type.typeName }
    </a>	
    </li>		   
 </c:forEach>
 
           </ul>
          
    <div id="xinxi">
  <form action="/bookDB/zhuce" method="post" onsubmit="return check()">
        <p>
          <span>身份id：</span><input type="number" maxlength="10"  placeholder="可自行输入,也可由系统生成" name="u_id" id="u_id" value="" >
          </p>
          <p>
            <span>手机号</span><input type="" name="u_phone" value="" required="required">
          </p>
          <p>
           <span>姓名：</span> <input type="text" placeholder="请输入姓名" name="u_name" maxlength="4" id="" value="" required="required">
          </p>
          <p>
            <span>密码：</span> <input type="password" name="userpass" id="userpass" required="required">
           </p>
           <p style=" height: 20px; width:100%; color: red;">${msg }</p>
           <p>
             <button id="gaiB" onclick="return check()">注册</button>
           </p>
          
      </form>
      
    </div >
      



    </div>

    <div id="success">修改成功!</div>

</body>
<script src="/bookDB/js/index.js"></script>
<script src="/bookDB/js/flhover.js"></script>
<script>
/*
$('#gaiB').click(function(){
	  var userpass= document.getElementById('userpass').value;
		  if(userpass.length<6){
		    alert("密码最少为6位");
		    return false;
		  }
	})
	*/
function check(){
	 var userpass= document.getElementById('u_id').value;
	  if(userpass.length<6){
	    alert("账号长度不得少于6位");
	    return false;
	  }else if(userpass.length>18){
		  alert("账号长度不得大于于18位");
		    return false;

	  }
	  var userpass= document.getElementById('userpass').value;
	  if(userpass.length<6){
	    alert("密码最少于6位");
	    return false;
	  }
}

$('.searchbtn').click(function(){
	 var bookname = $('.searchtext').val();
	 console.log(bookname);
	 window.location.href="/bookDB/index?bookname="+bookname;

})

</script>
</html>
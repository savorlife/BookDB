<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>图书借阅平台</title>
    <link rel="stylesheet" href="/bookDB/css/index.css">
    <style type="text/css">
    .w{
    width: 100px;
    }
    </style>
</head>
<body >
  <!-- 头 -->
<header name="top">
<img src="/bookDB/img/logo1.png" alt="">

<div class="search" >
  <input type="text" name="bookname" id="searchTop" class="searchtext" default="向上生长">
  <span type="button" value="提交" id="searchName" class="searchbtn">搜索</span>
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


<div id="deng">
  <div id="login-header"> </div>
    <!-- 登陆框主体 -->
    
    <div id="login" class="login" <c:if test="${show !=null }">style="display:block;"</c:if>>
      <!-- 登陆框标题 -->
      <a id="zhuce" href="/bookDB/zhuce.jsp">注册</a>
      <div id="login-title" class="login-title">登陆会员</div>
      <div class="cha"><a id="closeBtn" href="javascript:void(0)">×</a></div>
      <!-- 登陆框表单 -->
      <form action="/bookDB/loginIndex" method="POST" id="login-form">
          <div class="login-input">
              <label>登录名：</label>
              <input type="text" placeholder="请输入账号ID"name="u_id" required="required" maxlength="4" class="list-input"/>
          </div>
          
          <div class="login-input">
              <label>密&nbsp;&nbsp;&nbsp;码：</label>
              <input type="password" placeholder="请输入密码" name="u_pass" required="required" class="list-input"/>
          </div>
          <div style="color: red;margin-left: 120px;">${cuo }</div>
          
            <!-- 登陆框登陆按钮 -->
      <input type="submit"  id="loginSubmit" value="登陆会员" class="loginSubmit"/>
      </form>
    
  </div>
  
  <!-- 遮盖层 -->
  <div id="bg" class="bg"></div>
</div>

</header>

<nav>
<ul>
  <li><a href="/bookDB/index" >分类</a> </li>
  <li><a href="/bookDB/huiyuan/jilu" >借阅记录</a> </li>
  <li><a id="mine" href="/bookDB/huiyuan/mine" >
    <img src="/bookDB/img/mine.png" alt="">
    我的</a> </li>
</ul>
</nav>

<div id="box" >
 <ul id="fl">
 <c:forEach items="${typelist }" var="type" varStatus="status">
                   <li>
    <a href="/bookDB/index?type=${type.typeID }">
        ${type.typeName }
    </a>	
    </li>		   
 </c:forEach>
 
   


 </ul>

    <div id="shu">


       <c:forEach items="${bookList }" var="book" varStatus="status">
        <a href="/bookDB/shumian?id=${book.id }" target="main"> 
          <img class="w" src="${book.img }" alt="">
          <span class="content">   
                 <h3>${book.bookname }</h3>  
                 <span>${book.author }</span>
                 <p class="p">
                ${book.content }
                 </p>           
          </span>  
        </a> 
	</c:forEach>
      
       



      </div>

</div>




            <a id="up" href="#top">
              <img src="img/up.png" alt="">
              </a>
</body>
<script src="/bookDB/js/jquery-3.4.1.js"></script>
<script src="/bookDB/js/jquery-3.4.1.min.js"></script>
<script src="/bookDB/js/index.js"></script>

<script>
$('#fl li a').click(function(){
  var i = $('#fl li a').index(this)+1;

  window.location.href="bookDB/typeFind?type="+i;

})

$('.searchbtn').click(function(){
	 var bookname = $('.searchtext').val();
	 console.log(bookname);
	 window.location.href="/bookDB/index?bookname="+bookname;

})



</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>书籍详情</title>
    <script src="/bookDB/js/jquery-3.4.1.js"></script>
    <script src="/bookDB/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="/bookDB/css/shumian.css">
    <link rel="stylesheet" href="/bookDB/css/index.css">
    <style type="text/css">
    /*
    #success{
    	top:300px;
    	left: 600px;
    	height: 130px;
    	width: 270px;
    	display:none;
    }
    */
    </style>
</head>
<body>

      <!-- 头 -->
<header name="top">
    <img src="bookDB/img/logo1.png" alt="">
    
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

    <div  id="deng">
      <div id="login-header"> </div>
        <!-- 登陆框主体 -->
        <div id="login" class="login">
          <!-- 登陆框标题 -->
          <a id="zhuce" href="zhuce.jsp">注册</a>
          <div id="login-title" class="login-title">登陆会员</div>
          <div class="cha"><a id="closeBtn" href="javascript:void(0)">×</a></div>
          <!-- 登陆框表单 -->
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
        <ul id="fl" style="display:none">
             <c:forEach items="${typelist }" var="type" varStatus="status">
                   <li>
    <a href="/bookDB/index?type=${type.typeID }">
        ${type.typeName }
    </a>	
    </li>		   
 </c:forEach>
 
 </ul>
          
    

           <div id="shumian">
             <c:forEach items="${book }" var="book" varStatus="status">
            <img src="${book.img }" style="width: 350px;" alt="">
            <div id="content">
                <h3>${book.bookname }</h3>
                <p>作者：${book.author }</p>
                <span>定价：￥${book.price }</span>
                <p>出版社：${book.publisher }</p>
                <p>所属分类：${book.typeName }</p>
                <span>库存：${book.kucun }</span>
                
           		
                <a id="yuyue" href="/bookDB/huiyuan/borrow?id=${book.id }">立即预约</a>
            </div>
            <div id="jianjie">
                <h3>内容简介</h3>
                <p>
                ${book.content }
                </p>
            </div>
            </c:forEach>
        </div>

    </div>



<div id="success" style="">${y}</div>
<c:if test="${y !=null}">
<input type="text" id="tip" hidden="" value="${y}"/>
</c:if>


</body>
<script src="js/flhover.js"></script>
<script src="js/index.js"></script>
<script>

$(document).ready(function(){
	
	      if($('#tip').val() != null) {
	        $("#success").animate({
	      top: '300px',
	      left:'650px',
	      opacity:'1',
	      height:'100px',
	      width:'260px'
	    });

		setTimeout(function(){$("#success").hide();},1500);

	  
	      }
})  
	 

</script>
</html>
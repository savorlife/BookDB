<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>我的</title>
    <script src="/bookDB/js/jquery-3.4.1.js"></script>
    <script src="/bookDB/js/jquery-3.4.1.min.js"></script>

    <link rel="stylesheet" href="/bookDB/css/index.css">
    <link rel="stylesheet" href="/bookDB/css/mine.css">
    <script src="/bookDB/js/index.js"></script>
    <style>
       #adminBtn{
        font-size: 14px;
      }
      .search{
        margin-left: 145px;
      }
      #xinxi span{
      width: 130px;
      }
      #quxiao{
      display:inline-block;
      margin-top:48px;
      
      	width: 100px;
      	height: 40px;
      	color: white;
      	text-align: center;
      	line-height: 40px;
      	background-color: #c6a58a;
      }
      button {
	border: none;
}
    </style>
</head>
<body>

      <!-- 头 -->
<header name="top">
  <div id="head">
    <img src="/bookDB/img/logo1.png" alt="">
    
    <div class="search" >
      <input type="text" class="searchtext" default="向上生长">
      <span type="button" value="提交" class="searchbtn">搜索</span>
      <a href="/bookDB/gaojisearch.jsp">高级搜素</a>
    </div>
    
      <c:choose>
<c:when test="${user !=null }">
<span class="adminBtn">${user.u_name }</span>
</c:when>
<c:otherwise>
<a id="adminBtn" href="javascript:void(0)">登陆</a>
</c:otherwise>
</c:choose>

  </div>
   
    
    </header>
    
    <nav>
    <ul>
      <li style="background-color: #fff;"><a href="/bookDB/index" >分类</a> </li>
      <li><a href="/bookDB/huiyuan/jilu" >借阅记录</a> </li>
    
      <li><a id="mine" href="/bookDB/huiyuan/mine" style="background-color: #c6a58a;">
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
      <p>
      <span>账号ID：</span><input type="text" readonly value="${user.u_id }">
      </p>
      <p>
        <span>用户名：</span><input type="text" readonly value="${user.u_name }">
      </p>
      <p>
       <span>手机号:</span> <input type="text" name="" id="" readonly value="${user.u_phone }">
      </p>

       <p>
        <span>剩余可借次数：</span> <input type="number" name="max" id="" readonly value="${user.max }">
       </p>
       <p style=" height: 20px; width:100%; color: red;">${msg }</p>
       <p>
         <button id="gaiB">修改</button>
       </p>
      
    </div >
      
    <form action="/bookDB/update" method="post" id="gai">
    	<input type="number" hidden="" name="u_id" value="${user.u_id }" >
    	<input type="number" hidden=""  name="max" id="" readonly value="${user.max }">
      <p>
          <span>用户名：</span> <input type="text" name="u_name" maxlength="4" required="required" value="${user.u_name }">
        </p>
          <p>
            <span>手机号</span><input type="number" name="u_phone" value="${user.u_phone }" required="required">
          </p>
        <p>
          <span>旧密码：</span> <input type="password" name="juserpass" id="" required="required">
        </p>
        <p>
          <span>新密码：</span> <input type="password" name="userpass" id="" required="required">
        </p>
        <p>
          <button type="submit" id="sumbit">提交</button>
          <span id="quxiao">取消</span>
        </p>
    </form>


    </div>

    <div id="success"  <c:if test="${msg != null }">style="display: block;"</c:if>  >
    	${msg }</div>

</body>
<script src="/bookDB/js/flhover.js"></script>
<script>







$('#quxiao').click(function(){
  $("#gai").css('display','none');
  $("#xinxi").css('display','block');
})

    $('#gaiB').click(function(){
      $("#gai").css('display','block');
      $("#xinxi").css('display','none');
    $("#gai").animate({
      top: '130px',
      left:'570px',
      opacity:'1',
      height:'350px',
      width:'400px'
    });

    })
/*
    $('#sumbit').click(function(){
      $("#success").css('display','block');
    $("#success").animate({
      top: '300px',
      left:'650px',
      opacity:'1',
      height:'100px',
      width:'200px'
    });
    
	setTimeout(function(){
    $("#success").hide();
    location.reload();
    },1500);

    })
    */
    $('.searchbtn').click(function(){
	 var bookname = $('.searchtext').val();
	 console.log(bookname);
	 window.location.href="/bookDB/index?bookname="+bookname;

})

</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>借阅记录</title>
    <script src="/bookDB/js/jquery-3.4.1.js"></script>
    <script src="/bookDB/js/jquery-3.4.1.min.js"></script>

    <link rel="stylesheet" href="/bookDB/css/index.css">
    <link rel="stylesheet" href="/bookDB/css/jilu.css">
    <script src="/bookDB/js/index.js"></script>
    <style>
      #adminBtn{
        font-size: 14px;
      }
      .search{
        margin-left: 145px;
      }
      ul li img{
      width: 95px;
      }
      ul li div{
      width: 250px;
      }
      
    </style>
</head>
<body>

      <!-- 头 -->
<header name="top">

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


   
    
    </header>
    
    <nav>
    <ul>
      <li style="background-color: #fff;" ><a href="/bookDB/index" >分类</a> </li>
      <li style="background-color: #c6a58a;"><a href="/bookDB/huiyuan/jilu" >借阅记录</a> </li>
    
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
          

           <div id="jilu">

            <div class="title" >预约未取<span>></span> </div>
            <ul id="weiqu">
            <c:forEach items="${borrowList }" var="borrow" varStatus="status">
           
	          	 <c:if test="${borrow.or_back == 0}">
	             	 <li>
	                <img src="${borrow.img}" alt="">
	                <div>
	                <p>图书编号：<span >${borrow.book_id }</span> </p>
	                  <p>图书名称：${borrow.bookname }</p>
	                </div>
	                <div>
	                  <p><span class="htime">请在得到通知后尽快到图书馆取书</span></p>
	                </div>
	
	             	 </li>
				</c:if>
		 </c:forEach>
            </ul>


            <div class="title">未还 <span>></span></div>
            <ul id="weihuan">
            <c:forEach items="${borrowList }" var="borrow" varStatus="status">
           
	          	 <c:if test="${borrow.or_back == 1}">
	     			 <li>
	                <img src="${borrow.img}" alt="">
	                <div>
	                <p>图书编号：<span >${borrow.book_id }</span> </p>
	                  <p>图书名称：${borrow.bookname }</p>
	                </div>
	                <div>
	                  <p>借书时间：<span >${borrow.borrow_date }</span> </p>
	                  <p>应还时间：<span class="htime">${borrow.yinghuan }</span></p>
	                </div>
	
	             	 </li>
				</c:if>
		 </c:forEach>
            </ul>



            <div class="title">已还<span>></span></div>
            <ul id="yihuan">
       <c:forEach items="${borrowList }" var="borrow" varStatus="status">
           
	          <c:if test="${borrow.or_back == 2}">
	     			 <li>
	                <img src="${borrow.img}" alt="">
	                <div>
	                <p>图书编号：<span >${borrow.book_id }</span> </p>
	                  <p>图书名称：${borrow.bookname }</p>
	                </div>
	                <div>
	                  <p>借书时间：<span >${borrow.borrow_date }</span> </p>
	                  <p>还书时间：<span>${borrow.back_date }</span></p>
	                </div>
	
	             	 </li>
			</c:if>
		 </c:forEach>

            </ul>
           </div>


    </div>


</body>
<script src="../js/flhover.js"></script>
<script>




var i=0;

$('.title:nth-of-type(1)').click(function(){
  i++;

  $("#weiqu").slideToggle("slow");
if(i%2 == 0){
  $('.title:nth-of-type(1) span').css({
    'transform':'rotate(270deg)',
    '-ms-transform':'rotate(270deg)',
    '-webkit-transform':'rotate(270deg)'
    });
}else{
  $('.title:nth-of-type(1) span').css({
    'transform':'rotate(270deg)',
    '-ms-transform':'rotate(90deg)',
    '-webkit-transform':'rotate(90deg)'
    });
}})

$('.title:nth-of-type(2)').click(function(){
  i++;

  $("#weihuan").slideToggle("slow");
if(i%2 == 0){
  $('.title:nth-of-type(2) span').css({
    'transform':'rotate(90deg)',
    '-ms-transform':'rotate(90deg)',
    '-webkit-transform':'rotate(90deg)'
    });
}else{
  $('.title:nth-of-type(2) span').css({
    'transform':'rotate(270deg)',
    '-ms-transform':'rotate(270deg)',
    '-webkit-transform':'rotate(270deg)'
    });
}})

$('.title:nth-of-type(3)').click(function(){
  i++;

  $("#yihuan").slideToggle("slow");
if(i%2 == 0){
  $('.title:nth-of-type(3) span').css({

    'transform':'rotate(270deg)',
    '-ms-transform':'rotate(270deg)',
    '-webkit-transform':'rotate(270deg)'

    });
}else{
  $('.title:nth-of-type(3) span').css({
    
    'transform':'rotate(90deg)',
    '-ms-transform':'rotate(90deg)',
    '-webkit-transform':'rotate(90deg)'
   
    });
}})





$('#quxiao').click(function(){
  $("#gai").css('display','none');
})

    $('#gaiB').click(function(){
      $("#gai").css('display','block');
    $("#gai").animate({
      top: '130px',
      left:'580px',
      opacity:'1',
      height:'350px',
      width:'400px'
    });

    })

    $('#sumbit').click(function(){
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
    $('.searchbtn').click(function(){
	 var bookname = $('.searchtext').val();
	 console.log(bookname);
	 window.location.href="/bookDB/index?bookname="+bookname;

})

</script>
</html>
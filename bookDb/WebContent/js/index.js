
$('nav ul li:nth-of-type(1)').click(function(){
   $('#box').css('display','block');
   $('nav ul li:nth-of-type(1)').css('background-color','#c6a58a');
   $(location).attr('href', 'index.html');
  })
  
  $('nav ul li a').click(function(){
   var i = $('nav ul li a').index(this);
    $('nav ul li a').removeClass('xz');
    $('nav ul li a:eq('+i+')').addClass('xz');
  })
  
  
  //nav动态浮动
  setInterval('navf()',11);  
  
      function navf() {
       var p= $(document).scrollTop();
         if(p >=`80`){
        $("nav").addClass('navf');
        $('#box').css('margin-top','42px');
  
        $('#fl').addClass('flf');
        $('#shu').addClass('shu');
  
        $('#up').css('display','inline-block');
        $('#up').css('width','50px');
        $('#up').css('height','20px');
      
        }else{
         $("nav").removeClass('navf');
         $('#box').css('margin-top','0');
  
         $('#fl').removeClass('flf');
        $('#shu').removeClass('shu');
  
        $('#up').css('display','none');
        }
      }
  
    var w=$("nav").css('position');
  
    var login=document.getElementById('login');
        var bg=document.getElementById('bg');
        // 1.点击"点击，弹出登陆框",弹出登陆窗口和遮盖层
        var adminBtn=document.getElementById('adminBtn');
        adminBtn.onclick=function(){
            login.style.display="block";
            bg.style.display="block";
            return false;
        }
        // 2.点击"关闭",隐藏登陆窗口和遮盖层
        var closeBtn=document.getElementById('closeBtn');
        closeBtn.onclick=function(){
            login.style.display="none";
            bg.style.display="none";
            return false;
        }
        // 3.鼠标拖拽功能
        var login_title=document.getElementById('login-title');
        login_title.onmousedown=function(e){
            e = e || window.event;
            var x=e.pageX || e.clientX +(document.body.scrollLeft || document.documentElement.scrollLeft);
            var y=e.pageY || e.clientY +(document.body.scrollTop || document.documentElement.scrollTop);
            
            var boxX=login.offsetLeft;
            var boxY=login.offsetTop;
            
            var mouse_in_boxX=x-boxX;
            var mouse_in_boxY=y-boxY;
            
            document.onmousemove=function(e){
                var x=e.pageX || e.clientX +(document.body.scrollLeft || document.documentElement.scrollLeft);
                var y=e.pageY || e.clientY +(document.body.scrollTop || document.documentElement.scrollTop);
                
                login.style.left=x-mouse_in_boxX+256+'px';
                login.style.top=y-mouse_in_boxY-142+'px';
            }
        }
        
        login_title.onmouseup = function(){
            document.onmousemove=null;
        }
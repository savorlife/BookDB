window.onload = function(){
	fun();
}
window.onresize = function(){
	fun();
}


function fun() {
		var u_id = document.getElementById("user_id").value;
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
	
					xhr.open("post", "/bookDB/borrowCheck?u_id="+u_id);

				

				//3、发送Ajax请求
				xhr.send(null);
				
			xhr.onreadystatechange = function() {
					if (xhr.readyState == 4) {   //为啥等4可以看下面readyState值的含义
						//4、处理服务器响应
						var data = xhr.responseText;

						//消息展示容器
	
						var k = document.getElementById("u_name");
						if (data != null ) {
							k.innerHTML = data;
						} else {
						k.innerHTML = '';
							span.innerHTML = '无此用户';
						}
					}
				};
			}

		}
window.onload = function(){
	funBook();
}
window.onresize = function(){
	funBook();
}


function funBook() {
		var book_id = document.getElementById("book_id").value;
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

					xhr.open("post", "/bookDB/borrowCheckBook?book_id="+book_id);

				//3、发送Ajax请求
				xhr.send(null);
				
			xhr.onreadystatechange = function() {
					if (xhr.readyState == 4) {   //为啥等4可以看下面readyState值的含义
						//4、处理服务器响应
						var dataB = xhr.responseText;

						//消息展示容器
	
						var bookname = document.getElementById("bookname");
						if (dataB != null ) {
							bookname.innerHTML = dataB;
						} else {
							bookname.innerHTML = '编号无效';
						}
					}
				};
			}

		}
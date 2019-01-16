<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type = "text/javascript">
//封装并返回ajax对象
function getXhr(){
	var xhr = null;
	if (window.XMLHttpRequest){
		//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xhr=new XMLHttpRequest();
	}
	else{
		// IE6, IE5 浏览器执行代码
		xhr=new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xhr;
}
function check_user(){
	var xhr = getXhr();
	var username = document.getElementById("username").value;
	xhr.open("POST", "check_user?username = "+username, true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				var txt = xhr.responseText;
				document.getElementById("username").innerHTML = txt;
			}else
				{
				document.getElementById("username").innerHTML = "验证出错";
				}
		}
	};
	xhr.send(null);
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head> 
<body>
	<!--登陆框开始-->
	<form action="UserServlet" method="post">
		用户名：<input type="text" class="inputName" name="username"  placeholder="用户名"><br />
		 
		 密  码：<input type="password" name="password" placeholder="密码"><br />
		<button type="submit" >登录</button>
	</form>
</body>
</html>
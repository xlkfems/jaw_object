<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	#div1{
		width:45%;
		height:80%;
		position:absolute;
		left:40px;
		transition-duration:0.5s; 
		top:30px;
		transition-duration:0.5s;
		text-decoration:none;
		background:#FFF8D7;
		border-radius:10px;
		background-color:rgba(33,33,33,0.14);
	}
	#div2{
		position:absolute;
		left:80px;
		top:110px;
		width:80%;
		height:80%;
		
	}
</style>
<body background="backstage/images/slide-1.jpg">
	<div id="div1">
		<h3>&emsp;&emsp;${notice.title}</h3>
		&emsp;&emsp;&nbsp;${notice.date_time}
		<div id="div2">
		${notice.content}
	</div>
	</div>
</body>
</html>

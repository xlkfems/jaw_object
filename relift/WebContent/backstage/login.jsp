<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>橙联后台登录</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<!-- load css -->
	<link rel="stylesheet" type="text/css" href="common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="css/login.css" media="all">
</head>
<body>
<div class="layui-canvs"></div>
<div class="layui-layout layui-layout-login">
	<h1>
		 <strong>橙联物流系统后台</strong>
		 <em>内部人员通道</em>
	</h1>
	
	<form action="" method="post">
	<div class="layui-user-icon larry-login">
		 <input type="text" placeholder="账号" class="login_txtbx" id="username"/>
	</div>
	<div class="layui-pwd-icon larry-login">
		 <input type="password" placeholder="密码" class="login_txtbx" id="password"/>
	</div>
    <div class="layui-submit larry-login">
    	<input type="button" value="立即登陆" class="submit_btn" onclick="vali()"/>
    </div>
    </form>
    
    <div class="layui-login-text">
    	<p>© 2020-2021 魔方 版权所有</p>
        <p>湘xxxxxx</p>
    </div>
</div>
<script type="text/javascript" src="common/layui/lay/dest/layui.all.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="jsplug/jparticle.jquery.js"></script>
<script type="text/javascript">
$(function(){
	$(".layui-canvs").jParticle({
		background: "#141414",
		color: "#E6E6E6"
	});
	$(".submit_btn").click(function(){
	  
	});
});
</script>
<script>
	function vali(){
		var usr=$("#username").val();
		var paw=$("#password").val();
		var nams=/^\d{6,10}$/;
		if($("#username").val()!="admin"){
			alert("请输入正确的账户");
		}else if($("#username").val()==""){
			alert("账号不能为空！");
		}else{
			location.href="index.jsp";
		}
	}
  </script>
</body>
</html>
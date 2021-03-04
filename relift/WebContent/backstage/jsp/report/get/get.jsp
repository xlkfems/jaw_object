<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>提货回告信息</title>
    <link rel="stylesheet" href="../../../layui/css/layui.css">
    <link rel="stylesheet" href="../../../css/admin.css">
</head>
<body>

<div class="layui-tab layui-tab-brief" lay-filter="demo">
    <ul class="layui-tab-title">
        <li class="layui-this">新单回告</li>
        <li>回告历史</li>
    </ul>
    <div class="layui-tab-content" style="height: 100px; display: block">
        <div class="layui-tab-item layui-show">
          <table class="layui-table">
		  <colgroup>
		  <col width="80">
		  <col>
		  </colgroup>
		  <tr>
		  	   <td>ID</td>
    	   	   <td>运单号</td>
    	       <td>发货人</td>
    	       <td>发货地</td>
    	       <td>收货人</td>
    	       <td>收货地</td>
    	       <td>操作</td>
    	   </tr>
    	    <tr>
    	   	   <td>1</td>
    	       <td>HY694500</td>
    	       <td>荆锋</td>
    	       <td>长沙</td>
    	       <td>康佳宇</td>
    	       <td>上海</td>
    	       <td>
    	       <button type="button" class="layui-btn layui-btn-sm layui-btn-normal" onclick="phone('提货回告','../phone.jsp','800','500')">回告客户</button>    
    	       </td>
    	   </tr>
    	</table>
        </div>
        <div class="layui-tab-item">
           <table class="layui-table">
		  <colgroup>
		  <col width="80">
		  <col>
		  </colgroup>
		  <tr>
		  	   <td>ID</td>
    	   	   <td>运单号</td>
    	       <td>发货人</td>
    	       <td>发货地</td>
    	       <td>收货人</td>
    	       <td>收货地</td>
    	       <td>操作</td>
    	   </tr>
    	    <tr>
    	   	   <td>1</td>
    	       <td>HY694500</td>
    	       <td>荆锋</td>
    	       <td>长沙</td>
    	       <td>康佳宇</td>
    	       <td>上海</td>
    	       <td>
    	       <button type="button" class="layui-btn layui-btn-sm layui-btn-danger" onclick="history('回告详情','../history.jsp','800','500')">查看详情</button>    
    	       </td>
    	   </tr>
    	</table>
        </div>
    </div>
</div>
<script src="../../../layui/layui.js"></script>
<script src="../../../js/jquery/jquery-3.3.1.js"></script>
<script src="../../../js/jquery/jquery.cookie.js"></script>
<script src="../../../js/nginx.js"></script>
<script src="../../../js/customerService/get/informGet.js"></script>
	<script src="../../../js/x-layui.js"></script>
<script type="text/javascript">
/*添加*/
function history(title,url,w,h){
    x_admin_show(title,url,w,h);
}
function phone(title,url,w,h){
    x_admin_show(title,url,w,h);
}
  </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>司机运单信息表</title>
    <link rel="stylesheet" href="../../../layui/css/layui.css">
    <link rel="stylesheet" href="../../../css/admin.css">
</head>
<body>

<div class="layui-tab layui-tab-brief" lay-filter="demo">
    <ul class="layui-tab-title">
        <li class="layui-this">司机运输合同</li>
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
    	   	   <td>货运编号</td>
    	       <td>发货客户姓名</td>
    	       <td>发货客户电话</td>
    	       <td>收货客户姓名</td>
    	       <td>收货客户电话</td>
    	       <td>操作</td>
    	   </tr>
    	    <tr>
    	   	   <td>1</td>
    	       <td>HY694500</td>
    	       <td>康佳宇</td>
    	       <td>1783231213</td>
    	       <td>荆锋</td>
    	       <td>1783231211</td>
    	       <td>
    	       <button type="button" class="layui-btn layui-btn-sm" onclick="receipt('司机回执','receipt.jsp','800','500')">通知到货</button>
    	       <button type="button" class="layui-btn layui-btn-sm layui-btn-normal">中转</button>
    	       <button type="button" class="layui-btn layui-btn-sm layui-btn-danger">差错报告</button>    
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
<script src="../../../js/getGoodsControl/callback/driverCallback.js"></script>
	<script src="../../../js/x-layui.js"></script>
<script type="text/javascript">
/*添加*/
function receipt(title,url,w,h){
    x_admin_show(title,url,w,h);
}
function update_select(title,url,w,h){
    x_admin_show(title,url,w,h);
}
  </script>
</body>
</html>
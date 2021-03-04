<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>客户物流信息</title>
    <link rel="stylesheet" href="../../../layui/css/layui.css">
    <link rel="stylesheet" href="../../../css/admin.css">
</head>
<body>

<div class="layui-tab layui-tab-brief" lay-filter="demo">
    <ul class="layui-tab-title">
        <li class="layui-this">我收到的</li>
        <li>收货历史</li>
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
    	       <td>操作</td>
    	   </tr>
    	    <tr>
    	   	   <td>1</td>
    	       <td>HY694500</td>
    	       <td>康佳宇</td>
    	       <td>湖南长沙市</td>
    	       <td>
    	       <button type="button" class="layui-btn layui-btn-sm layui-btn-normal" onclick="cal_client('客户回执','cal_client.jsp','800','500')">通知到货</button>
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
    	       <td>验收内容</td>
    	       <td>收货日期</td>
    	   </tr>
    	    <tr>
    	   	   <td>1</td>
    	       <td>HY694500</td>
    	       <td>已验收</td>
    	       <td>12-24</td>
    	   </tr>
    	</table>
        </div>
    </div>
</div>
<script src="../../../layui/layui.js"></script>
<script src="../../../js/jquery/jquery-3.3.1.js"></script>
<script src="../../../js/jquery/jquery.cookie.js"></script>

<script src="../../../js/nginx.js"></script>
<script src="../../../js/getGoodsControl/callback/customerCallback.js"></script>
	<script src="../../../js/x-layui.js"></script>
<script type="text/javascript">
/*添加*/
function cal_client(title,url,w,h){
    x_admin_show(title,url,w,h);
}

  </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>运输合同结算页面</title>
    <link rel="stylesheet" href="../../../layui/css/layui.css">
    <link rel="stylesheet" href="../../../css/admin.css">
</head>
<body>
    <div class="layui-tab layui-tab-brief" lay-filter="demo">
        <ul class="layui-tab-title">
            <li class="layui-this">新结运费</li>
            <li>结算历史</li>
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
    	   	   <td>回执单编号</td>
    	       <td>司机编号</td>
    	       <td>结算类型</td>
    	       <td>操作</td>
    	   </tr>
    	    <tr>
    	   	   <td>1</td>
    	       <td>HY694500</td>
    	       <td>SJ981234</td>
    	       <td>待结入</td>
    	       <td>
    	       <button type="button" class="layui-btn layui-btn-sm" onclick="close_transport('详情信息','close_transport.jsp','800','500')">结算</button>
    	       <button type="button" class="layui-btn layui-btn-sm layui-btn-danger" onclick="query_transport('详情信息','query_transport.jsp','800','500')">查看详情</button>    
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
    	   	   <td>回执单编号</td>
    	       <td>司机编号</td>
    	       <td>结算类型</td>
    	       <td>操作</td>
    	   </tr>
    	    <tr>
    	   	   <td>1</td>
    	       <td>HY694500</td>
    	       <td>SJ981234</td>
    	       <td>结入</td>
    	       <td>
    	       <button type="button" class="layui-btn layui-btn-sm layui-btn-danger" onclick="query_transport('详情信息','query_transport.jsp','800','500')">查看详情</button>    
    	       </td>
    	   </tr>
    	</table>
            </div>
        </div>
    </div>
    <script src="../../../layui/layui.js"></script>
    <script src="../../../js/jquery/jquery-3.3.1.js"></script>

    <script src="../../../js/nginx.js"></script>
    <script src="../../../js/clearControl/transport/transportManage.js"></script>
	<script src="../../../js/x-layui.js"></script>
<script type="text/javascript">
/*添加*/
function query_transport(title,url,w,h){
    x_admin_show(title,url,w,h);
}
function close_transport(title,url,w,h){
    x_admin_show(title,url,w,h);
}
  </script>
</body>
</html>
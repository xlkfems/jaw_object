<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>运单监控</title>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <link rel="stylesheet" href="../../css/admin.css">
</head>
<body>
    <div class="layui-tab layui-tab-brief" lay-filter="demo">
        <ul class="layui-tab-title">
            <li class="layui-this">打印客户运量</li>
            <li>打印专线整体</li>
            <li>打印司机运量</li>
            <li>打印车辆成本</li>
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
    	   	   <td>发货客户</td>
    	       <td>运费总计</td>
    	       <td>保险费总计</td>
    	       <td>件数总计</td>
    	   </tr>
    	    <tr>
    	   	   <td>1</td>
    	       <td>荆锋</td>
    	       <td>14</td>
    	       <td>14</td>
    	       <td>2</td>
    	   </tr>
    	</table>
            </div>
            <div class="layui-tab-item ">
                 <table class="layui-table">
		  <colgroup>
		  <col width="80">
		  <col>
		  </colgroup>
		  <tr>
		  	   <td>ID</td>
    	   	   <td>装货地点</td>
    	       <td>交货地点</td>
    	       <td>总运费总计</td>
    	       <td>保险费总计</td>
    	       <td>次数</td>
    	   </tr>
    	</table>
            </div>
            <div class="layui-tab-item ">
                <table class="layui-table">
		  <colgroup>
		  <col width="80">
		  <col>
		  </colgroup>
		  <tr>
		  	   <td>ID</td>
    	   	   <td>司机编号</td>
    	       <td>承运费总计</td>
    	       <td>加运费总计</td>
    	       <td>总计</td>
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
    	   	   <td>司机名称</td>
    	       <td>车号</td>
    	       <td>准载重量</td>
    	       <td>车厢宽度</td>
    	       <td>操作</td>
    	   </tr>
    	</table>
            </div>
       
        </div>
    </div>
    <script src="../../layui/layui.js"></script>
    <script src="../../js/jquery/jquery-3.3.1.js"></script>

    <script src="../../js/nginx.js"></script>
    <script src="../../js/monitor/statistics/statistics.js"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>支出录入页面</title>
    <link rel="stylesheet" href="../../../layui/css/layui.css">
    <link rel="stylesheet" href="../../../css/admin.css">
</head>
<body>
    <div class="layui-tab layui-tab-brief" lay-filter="demo">
        <ul class="layui-tab-title">
            <li class="layui-this">员工工资</li>
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
    	   	   <td>员工编号</td>
    	       <td>职员姓名</td>
    	       <td>部门</td>
    	       <td>职位</td>
    	       <td>操作</td>
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
    	   	   <td>财务费用id</td>
    	       <td>财务费用</td>
    	       <td>支出月份</td>
    	       <td>填写日期</td>
    	   </tr>
    	</table>
            </div>
        </div>
    </div>
    <script src="../../../layui/layui.js"></script>
    <script src="../../../js/jquery/jquery-3.3.1.js"></script>
    <script src="../../../js/nginx.js"></script>
    <script src="../../../js/checkControl/expend/expend.js"></script>
    <script type="text/javascript">
    </script>
</body>
</html>
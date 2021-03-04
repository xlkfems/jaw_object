<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
        request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>票据详情页</title>
    <link rel="stylesheet" href="<%=basePath%>backstage/layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin.css">
</head>
<style>
	#div1{
		position:absolute;
		left:170px; 
		top:0px;
	}
</style>
<body>

<div class="layui-tab layui-tab-brief" lay-filter="demo">
    <ul class="layui-tab-title">
        <li class="layui-this">票据查看</li>
    </ul>
    <br/>&nbsp;
      <div class="layui-input-inline">
      <form action="<%=basePath%>billServlet?oper=query_phone" method="post">
        <input type="tel" name="phone" placeholder="订单编号查询" lay-verify="required|phone" autocomplete="off" class="layui-input">
      	<button type="submit" id="div1" class="layui-btn"><i class="layui-icon layui-icon-search"></i></button>
      </form>
      </div>
    
    <div class="layui-tab-content" style="height: 100px; display: block">
        <div class="layui-tab-item layui-show">
             <table class="layui-table">
		  <colgroup>
		  <col width="80">
		  <col>
		  </colgroup>
		  <tr>
		  	   <td>ID</td>
    	   	   <td>货运单编号</td>
    	   	   <td>状态</td>
    	       <td>填写日期</td>
    	   </tr>
    	   <c:forEach items="${pages.getListBill()}" var="bi">
    	    <tr>
    	   	   <td>${bi.bi_id}</td>
    	       <td>${bi.bi_number}</td>
    	       <td>${bi.state}</td>
    	       <td>${bi.bi_date}</td>
    	   </tr>
    	   </c:forEach>
    	</table>
        </div>
        <center>
    	<a href="<%=basePath%>billServlet?oper=query&pageNo=${1}"><button type="button" class="layui-btn  layui-btn-sm">首页</button></a>
 		<a href="<%=basePath%>billServlet?oper=query&pageNo=${pages.currPageNo-1}"><button type="button" class="layui-btn   layui-btn-sm">上一页</button></a>
 		<button type="button" class=" layui-btn-primary layui-btn-sm">${pages.getCurrPageNo()}</button>
 		<a href="<%=basePath%>billServlet?oper=query&pageNo=${pages.currPageNo+1}"><button type="button" class="layui-btn  layui-btn-sm">下一页</button></a>
 		<a href="<%=basePath%>billServlet?oper=query&pageNo=${pages.currPageNo+pages.getTotalPageCount()}"><button type="button" class="layui-btn  layui-btn-sm">尾页</button></a>
 		</center>
    </div>
</div>

<script src="<%=basePath%>backstage/layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery.cookie.js"></script>
<script src="<%=basePath%>backstage/js/nginx.js"></script>
<script src="<%=basePath%>backstage/js/goodsBillControl/detail/goodsBillDetail.js"></script>
<script src="<%=basePath%>backstage/js/x-layui.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cn.com.relife.util.*,cn.com.relife.entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
        request.getServerPort() + path + "/";
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单信息页</title>
    <link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>css/admin.css">
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
        <li class="layui-this">订单信息</li>
    </ul>
    <br/>&nbsp;
      <div class="layui-input-inline">
      <form action="<%=basePath%>placeServlet?oper=query_phone" method="post">
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
    	       <td>货运单状态</td>
    	       <td>操作</td>
    	   </tr>
    	   <c:forEach items="${pages.getListPlace()}" var="s">
    	    <tr>
    	   	   <td>${s.id}</td>
    	       <td>${s.number}</td>
    	       <td>${s.state}</td>
    	       <td><button type="button" onclick="order_single('订单详情','<%=basePath%>placeServlet?oper=details&number=${s.number}','800','500')" class="layui-btn layui-btn-sm">查看详情</button></td>
    	   </tr>
    	    </c:forEach>
    	</table>
    	<div id="demo3"></div>
    	<center>
    	<a href="<%=basePath%>placeServlet?oper=query&pageNo=${1}"><button type="button" class="layui-btn layui-btn-sm">首页</button></a>
 		<a href="<%=basePath%>placeServlet?oper=query&pageNo=${pages.currPageNo-1}"><button type="button" class="layui-btn  layui-btn-sm">上一页</button></a>
 		<button type="button" class=" layui-btn-primary layui-btn-sm">${pages.getCurrPageNo()}</button>
 		<a href="<%=basePath%>placeServlet?oper=query&pageNo=${pages.currPageNo+1}"><button type="button" class="layui-btn layui-btn-sm">下一页</button></a>
 		<a href="<%=basePath%>placeServlet?oper=query&pageNo=${pages.currPageNo+pages.getTotalPageCount()}"><button type="button" class="layui-btn layui-btn-sm">尾页</button></a>
 		</center>
        </div>
    </div>
</div>

	<script src="<%=basePath%>backstage/layui/layui.js"></script>
	<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
	<script src="<%=basePath%>backstage/js/nginx.js"></script>
	<script src="<%=basePath%>backstage/js/goodsBillControl/detail/goodsBillDetail.js"></script>
	<script src="<%=basePath%>backstage/js/x-layui.js"></script>
<script type="text/javascript">
/*添加*/
function order_single(title,url,w,h){
    x_admin_show(title,url,w,h);
}

  </script>
</body>
</html>
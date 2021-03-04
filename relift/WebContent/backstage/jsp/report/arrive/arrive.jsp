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
    <title>提货回告信息</title>
    <link rel="stylesheet" href="<%=basePath%>backstage/layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin.css">
</head>
<body>

<div class="layui-tab layui-tab-brief" lay-filter="demo">
    <ul class="layui-tab-title">
        <li class="layui-this">客户回告</li>
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
    	    <c:forEach items="${pages.getListPlace()}" var="place">
    	    <tr>
    	   	   <td>${place.id}</td>
    	       <td>${place.number}</td>
    	       <td>${place.m_name}</td>
    	       <td>${place.m_address_block}</td>
    	       <td>${place.a_name}</td>
    	       <td>${place.a_address_block}</td>
    	       <td>
    	       <button type="button" class="layui-btn layui-btn-sm layui-btn-normal" onclick="phone('到货回告','<%=basePath%>placeServlet?oper=client&number=${place.number}','800','500')">回告客户</button>    
    	       </td>
    	   </tr>
    	    </c:forEach>
    	</table>
    	<center>
    	<a href="<%=basePath%>placeServlet?oper=report&pageNo=${1}"><button type="button" class="layui-btn  layui-btn-sm">首页</button></a>
 		<a href="<%=basePath%>placeServlet?oper=report&pageNo=${pages.currPageNo-1}"><button type="button" class="layui-btn   layui-btn-sm">上一页</button></a>
 		<button type="button" class=" layui-btn-primary layui-btn-sm">${pages.getCurrPageNo()}</button>
 		<a href="<%=basePath%>placeServlet?oper=report&pageNo=${pages.currPageNo+1}"><button type="button" class="layui-btn  layui-btn-sm">下一页</button></a>
 		<a href="<%=basePath%>placeServlet?oper=report&pageNo=${pages.currPageNo+pages.getTotalPageCount()}"><button type="button" class="layui-btn  layui-btn-sm">尾页</button></a>
 		</center>
        </div>
    </div>
</div>
<script src="<%=basePath%>backstage/layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery.cookie.js"></script>

<script src="<%=basePath%>backstage/js/nginx.js"></script>
<script src="<%=basePath%>backstage/js/customerService/pass/informPass.js"></script>
	<script src="<%=basePath%>backstage/js/x-layui.js"></script>
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
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
    <title>客户运单结算页面</title>
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
            <li class="layui-this">历史运单</li>
        </ul>
        <br/>&nbsp;
      <div class="layui-input-inline">
      <form action="<%=basePath%>placeServlet?oper=query_phon" method="post">
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
    	   	   <td>货运编号</td>
    	       <td>客户编号</td>
    	       <td>货运金额(元)</td>
    	   </tr>
    	   <c:forEach items="${pages.getListPlace()}" var="place">
    	    <tr>
    	   	   <td>${place.id}</td>
    	       <td>${place.number}</td>
    	       <td>${place.pick}</td>
    	       <td>${place.pl_money}</td>
    	   </tr>
    	   </c:forEach>
    	</table>
    	<center>
    	<a href="<%=basePath%>placeServlet?oper=query_close&pageNo=${1}"><button type="button" class="layui-btn  layui-btn-sm">首页</button></a>
 		<a href="<%=basePath%>placeServlet?oper=query_close&pageNo=${pages.currPageNo-1}"><button type="button" class="layui-btn   layui-btn-sm">上一页</button></a>
 		<button type="button" class=" layui-btn-primary layui-btn-sm">${pages.getCurrPageNo()}</button>
 		<a href="<%=basePath%>placeServlet?oper=query_close&pageNo=${pages.currPageNo+1}"><button type="button" class="layui-btn  layui-btn-sm">下一页</button></a>
 		<a href="<%=basePath%>placeServlet?oper=query_close&pageNo=${pages.currPageNo+pages.getTotalPageCount()}"><button type="button" class="layui-btn  layui-btn-sm">尾页</button></a>
 		</center>
            </div>
    <script src="<%=basePath%>backstage/layui/layui.js"></script>
    <script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>

    <script src="<%=basePath%>backstage/js/nginx.js"></script>
    <script src="<%=basePath%>backstage/js/clearControl/goodsBill/goodsBillManage.js"></script>
	<script src="<%=basePath%>backstage/js/x-layui.js"></script>
<script type="text/javascript">
/*添加*/
function query_goodsBill(title,url,w,h){
    x_admin_show(title,url,w,h);
}
function close_goodsBill(title,url,w,h){
    x_admin_show(title,url,w,h);
}
  </script>
</body>
</html>
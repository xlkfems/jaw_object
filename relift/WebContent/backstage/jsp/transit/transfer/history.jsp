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
    <title>Title</title>
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
        <li class="layui-this">中转历史</li>
    </ul>
    <br/>&nbsp;
      <div class="layui-input-inline">
      <form action="<%=basePath%>centreServlet?oper=query_phone" method="post">
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
    	       <td>中转地</td>
    	       <td>验货人</td>
    	       <td>中转站点</td>
    	   </tr>
    	    <c:forEach items="${pages.getListCentre()}" var="centre">
    	    <tr>
    	   	   <td>${centre.id}</td>
    	       <td>${centre.fre_number}</td>
    	       <td>${centre.location}</td>
    	       <td>${centre.dr_number}</td>
    	       <td>${centre.tr_name}</td>
    	   </tr>
    	   </c:forEach>
    	</table>
    	 <center>
    	<a href="<%=basePath%>centreServlet?oper=query&pageNo=${1}"><button type="button" class="layui-btn layui-btn-sm">首页</button></a>
 		<a href="<%=basePath%>centreServlet?oper=query&pageNo=${pages.currPageNo-1}"><button type="button" class="layui-btn  layui-btn-sm">上一页</button></a>
 		<button type="button" class=" layui-btn-primary layui-btn-sm">${pages.getCurrPageNo()}</button>
 		<a href="<%=basePath%>centreServlet?oper=query&pageNo=${pages.currPageNo+1}"><button type="button" class="layui-btn layui-btn-sm">下一页</button></a>
 		<a href="<%=basePath%>centreServlet?oper=query&pageNo=${pages.currPageNo+pages.getTotalPageCount()}"><button type="button" class="layui-btn layui-btn-sm">尾页</button></a>
 		</center>
        </div>
    </div>
</div>

	<script src="<%=basePath%>backstage/layui/layui.js"></script>
    <script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>backstage/js/nginx.js"></script>
    <script src="<%=basePath%>backstage/js/checkControl/expend/expend.js"></script>
    <script src="<%=basePath%>backstage/js/x-layui.js"></script>
<script type="text/javascript">
/*添加*/
function add_transfer(title,url,w,h){
    x_admin_show(title,url,w,h);
}

  </script>
</body>
</html>
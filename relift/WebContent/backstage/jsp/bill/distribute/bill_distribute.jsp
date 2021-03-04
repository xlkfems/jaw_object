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
    <title>票据分发页</title>
    <link rel="stylesheet" href="<%=basePath%>backstage/layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin.css">
</head>
<body>

<div class="layui-tab layui-tab-brief" lay-filter="demo">
    <ul class="layui-tab-title">
        <li class="layui-this">票据分发</li>
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
    	   	   <td>货运单编号</td>
    	       <td>填写日期</td>
    	       <td>操作</td>
    	   </tr>
    	  <c:forEach items="${pages.getListMake()}" var="make" >
    	    <tr>
    	   	   <td>${make.make_id}</td>
    	       <td>${make.fre_number}</td>
    	       <td>${make.make_time}</td>
    	       <td><button type="button"onclick="bill_out('票据分发','<%=basePath%>billServlet?oper=query_bill&number=${make.fre_number}','800','500')" class="layui-btn layui-btn-sm" id="distribute">分发</button></td>
    	   	</tr>
		</c:forEach>
    	</table>
        </div>
         <center>
    	<a href="<%=basePath%>billServlet?oper=distribute&pageNo=${1}"><button type="button" class="layui-btn  layui-btn-sm">首页</button></a>
 		<a href="<%=basePath%>billServlet?oper=distribute&pageNo=${pages.currPageNo-1}"><button type="button" class="layui-btn   layui-btn-sm">上一页</button></a>
 		<button type="button" class=" layui-btn-primary layui-btn-sm">${pages.getCurrPageNo()}</button>
 		<a href="<%=basePath%>billServlet?oper=distribute&pageNo=${pages.currPageNo+1}"><button type="button" class="layui-btn  layui-btn-sm">下一页</button></a>
 		<a href="<%=basePath%>billServlet?oper=distribute&pageNo=${pages.currPageNo+pages.getTotalPageCount()}"><button type="button" class="layui-btn  layui-btn-sm">尾页</button></a>
 		</center>
    </div>
</div>

<script src="<%=basePath%>backstage/layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery.cookie.js"></script>
<script src="<%=basePath%>backstage/js/nginx.js"></script>
<script src="<%=basePath%>backstage/js/goodsBillControl/detail/goodsBillDetail.js"></script>
<script src="<%=basePath%>backstage/js/x-layui.js"></script>
<script type="text/javascript">
/*添加*/
function bill_out(title,url,w,h){
    x_admin_show(title,url,w,h);
}

  </script>
</body>
</html>
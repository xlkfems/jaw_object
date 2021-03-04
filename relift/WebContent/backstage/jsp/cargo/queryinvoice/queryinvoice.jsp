<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
        request.getServerPort() + path + "/";
%>
<base href="c">
<head>
    <meta charset="UTF-8">
    <title>接货单查询页面</title>
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
            <li class="layui-this">待发运单</li>
        </ul>
        
        <br/>&nbsp;
      <div class="layui-input-inline">
      <form action="<%=basePath%>makeServlet?oper=query_phone" method="post">
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
    	       <td>备注</td>
    	       <td>发生时间</td>
    	       <td>操作</td>
    	   </tr>
    	   <c:forEach items="${pages.getListMake()}" var="make">
    	    <tr>
    	   	   <td>${make.make_id}</td>
    	       <td>${make.fre_number}</td>
    	       <td>${make.state}</td>
    	       <td>${make.remark}</td>
    	       <td>${make.make_time}</td>
    	       <td>
               <button type="button" class="layui-btn layui-btn-sm layui-btn-warm" onclick="query_invoice('接货单详情','<%=basePath%>makeServlet?oper=Queryfreight&number=${make.fre_number}','800','500')">查看详情</button>
    	       <button type="button" class="layui-btn layui-btn-sm" onclick="update_incoice('修改接货单','<%=basePath%>makeServlet?oper=update_incoice&number=${make.fre_number}','800','500')">修改</button>  	       
    	       </td>
    	   </tr>
    	   </c:forEach>
    	</table>
    	 <center>
    	<a href="<%=basePath%>makeServlet?oper=committed&pageNo=${1}"><button type="button" class="layui-btn  layui-btn-sm">首页</button></a>
 		<a href="<%=basePath%>makeServlet?oper=committed&pageNo=${pages.currPageNo-1}"><button type="button" class="layui-btn   layui-btn-sm">上一页</button></a>
 		<button type="button" class=" layui-btn-primary layui-btn-sm">${pages.getCurrPageNo()}</button>
 		<a href="<%=basePath%>makeServlet?oper=committed&pageNo=${pages.currPageNo+1}"><button type="button" class="layui-btn  layui-btn-sm">下一页</button></a>
 		<a href="<%=basePath%>makeServlet?oper=committed&pageNo=${pages.currPageNo+pages.getTotalPageCount()}"><button type="button" class="layui-btn layui-btn-sm">尾页</button></a>
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
function query_invoice(title,url,w,h){
    x_admin_show(title,url,w,h);
}
function update_incoice(title,url,w,h){
    x_admin_show(title,url,w,h);
}
  </script>
</body>
</html>
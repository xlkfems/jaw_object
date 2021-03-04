<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
        request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>查询运输合同</title>
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
            <li class="layui-this">所有合同</li>
        </ul>
        <br/>&nbsp;
      <div class="layui-input-inline">
      <form action="<%=basePath%>contractServlet?oper=query_phone" method="post">
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
    	   	   <td>货运回执单编号</td>
    	       <td>回执单状态</td>
    	       <td>收货联系人</td>
    	       <td>操作</td>
    	   </tr>
    	    <c:forEach items="${pages.getListCon()}" var="con">
    	    	<tr>
    	   	   <td>${con.con_id}</td>
    	       <td>${con.fre_number}</td>
    	       <td>${con.con_receipt}</td>
    	       <td>${con.take_Name}</td>
    	       <td>
    	       <button type="button" class="layui-btn layui-btn-sm layui-btn-warm" onclick="query_select('合同详情','<%=basePath%>contractServlet?oper=contract_query&number=${con.fre_number}','800','500')">查看详情</button>
    	       <button type="button" class="layui-btn layui-btn-sm" onclick="update_select('修改详情','<%=basePath%>contractServlet?oper=update_contract&number=${con.fre_number}','800','500')">修改</button>
    	       </td>
    	   </tr>
    	   </c:forEach>
    	</table>
    	 <center>
    	<a href="<%=basePath%>contractServlet?oper=query_contra&pageNo=${1}"><button type="button" class="layui-btn layui-btn-sm">首页</button></a>
 		<a href="<%=basePath%>contractServlet?oper=query_contra&pageNo=${pages.currPageNo-1}"><button type="button" class="layui-btn  layui-btn-sm">上一页</button></a>
 		<button type="button" class=" layui-btn-primary layui-btn-sm">${pages.getCurrPageNo()}</button>
 		<a href="<%=basePath%>contractServlet?oper=query_contra&pageNo=${pages.currPageNo+1}"><button type="button" class="layui-btn layui-btn-sm">下一页</button></a>
 		<a href="<%=basePath%>contractServlet?oper=query_contra&pageNo=${pages.currPageNo+pages.getTotalPageCount()}"><button type="button" class="layui-btn layui-btn-sm">尾页</button></a>
 		</center>
            </div>
        </div>
    </div>
    <script src="<%=basePath%>backstage/layui/layui.js"></script>
    <script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>

    <script src="<%=basePath%>backstage/js/nginx.js"></script>
    <script src="<%=basePath%>backstage/js/vehicleControl/select/cargoReceiptDetail.js"></script>
	<script src="<%=basePath%>backstage/js/x-layui.js"></script>
<script type="text/javascript">
/*添加*/
function query_select(title,url,w,h){
    x_admin_show(title,url,w,h);
}
function update_select(title,url,w,h){
    x_admin_show(title,url,w,h);
}
  </script>
</body>
</html>
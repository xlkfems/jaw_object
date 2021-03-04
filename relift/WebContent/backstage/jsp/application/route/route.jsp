<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cn.com.relife.util.*,cn.com.relife.entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
        request.getServerPort() + path + "/";
	%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>线路管理页</title>
    <link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin.css">
    <style>
    </style>
</head>
<body>


<div class="layui-tab layui-tab-brief">
    <ul class="layui-tab-title">
    	<li >添加城市范围信息</li>
        <li class="layui-this">城市信息</li>
        <li>线路信息</li>
    </ul>
    <div class="layui-tab-content">
        
        <div class="layui-tab-item ">
            <div class="layui-form-item">
                <form class="layui-form" action="<%=basePath%>RoadmapaddServlet?oper=add" method="post">

                    <div class="layui-form-item">
                        <label class="layui-form-label">主要城市：</label>
                        <div class="layui-input-inline">
                            <select name="city" id="city">
                                <option value="">请选择城市</option>
                                <option value="北京">北京</option>
                                <option value="上海">上海</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">范围城市：</label>
                        <div class="layui-input-inline">
                            <select name="rangeCity">
                                <option value="">请选择范围城市</option>
                                <option value="北京">北京</option>
                                <option value="上海">上海</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">已选范围：</label>
                        <div class="layui-btn-container" id="selectedCity"></div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button type="submit" class="layui-btn"  id="addInfo">立即提交</button>
                            <button type="reset" id="resetForm" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="layui-tab-item layui-show">
           <table class="layui-table">
		  <colgroup>
		  <col width="80">
		  <col>
		  </colgroup>
		  <tr>
		  	   <td>ID</td>
    	   	   <td>主要城市</td>
    	       <td>范围城市</td>
    	       <td>操作</td>
    	  </tr>
    <c:forEach items="${pages.getListRoad()}" var="road">
    	   <tr>
		  	   <td>${road.path_id}</td>
    	   	   <td>${road.path_city}</td>
    	       <td>${road.path_scope}</td>
    	       <td>
    	       <button type="button" class="layui-btn layui-btn-sm layui-btn-normal" onclick="rou_update('修改信息','<%=basePath%>RoadmapaddServlet?oper=one&id=${road.path_id}','800','500')">修改</button>
    	       <a href="<%=basePath%>RoadmapaddServlet?oper=del&id=${road.path_id}">
    	       <button type="button" class="layui-btn layui-btn-sm layui-btn-danger">删除</button>
    	       </a>
    	       </td>
    	   </tr>
    	 </c:forEach>
    	</table>
    	<center>
    	<p>[总页数/当前页数]：${pages.getTotalPageCount()}/${pages.getCurrPageNo()}</p>
 			<a href="<%=basePath%>RoadmapaddServlet?oper=all&pageNo=${pages.currPageNo-1}">后退一页</a>&emsp;
 			&emsp;<a href="<%=basePath%>RoadmapaddServlet?oper=all&pageNo=${pages.currPageNo+1}">前进一页</a>
 		</center>
        </div>
        <!-- <div class="layui-tab-item">
            <div style="padding: 20px; background-color: #F2F2F2;" id="routeInfo">
            
            </div>
        </div> -->
    </div>
</div>

<script src="<%=basePath%>layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>

<script src="<%=basePath%>backstage/js/nginx.js"></script>
<script src="<%=basePath%>backstage/js/appControl/route/routeManage.js"></script>
<script src="<%=basePath%>backstage/js/x-layui.js"></script>
<script type="text/javascript">
/*添加*/

function rou_update(title,url,w,h){
    x_admin_show(title,url,w,h);
}
  </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cn.com.relife.util.*,cn.com.relife.entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
        request.getServerPort() + path + "/";
	%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>城市扩充信息修改页</title>
    <link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin.css">
</head>
<body>
<div class="layui-form-item">
    <form class="layui-form" action="<%=basePath%>RoadmapaddServlet?oper=upda&id=${road.path_id}" method="post">
        <div class="layui-form-item">
           <label class="layui-form-label">主要城市：</label>
              <div class="layui-input-inline">
                  <select name="city" id="city" >
                    <option value="${road.path_city}">${road.path_city}</option>
                     <option value="北京">北京</option>
                      <option value="上海">上海</option>
                  </select>
             </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">范围城市：</label>
            <div class="layui-input-inline">
                <select name="rangeCity" id="rangeCity">
                    <option value="${road.path_scope}">${road.path_scope}</option>
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
                <button type="submit" class="layui-btn layui-btn-radius layui-btn-normal" id="close">立即修改</button>
            </div>
        </div>
    </form>
</div>
<script src="<%=basePath%>layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>

<script src="<%=basePath%>backstage/js/nginx.js"></script>
<script src="<%=basePath%>backstage/js/appControl/route/routeModify.js"></script>
<script type="text/javascript">
	
		//layui新弹框关闭父级弹框刷新数据
		$("#close").click(function(){
			//先得到当前iframe层的索引
			var index = parent.layer.getFrameIndex(window.name); 
			//再执行关闭 
			parent.layer.close(index);  
			//关闭父级页面的表格
			//parent.layui.table.reload('table');
			window.parent.location.reload();
		});
	
</script>
</body>
</html>
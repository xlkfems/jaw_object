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
    <title>职员信息修改页</title>
    <link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
    
</head>
<body>

<div class="layui-form-item" style="margin-top: 10px">
    <form class="layui-form" action="<%=basePath%>ClerkServlet?oper=upd&id=${clerk.cl_id }" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">职员编号</label>
            <div class="layui-input-inline">
                <input type="text" name="employeeCode" class="layui-input"  value="${clerk.cl_number }">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">职员姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="employeeName" value="${clerk.cl_name }" class="layui-input" >
                
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">职位</label>
            <div class="layui-input-inline">
                <select name="position" id="position" >
                    <option value="">${clerk.cl_section }</option>
                    <option value="经理">经理</option>
                    <option value="助理">助理</option>
                    <option value="员工">员工</option>
                    <option value="派件员">派件员</option>
                </select>
            </div>
            <div class="layui-form-mid layui-word-aux">请选择员工职位</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
            	<input type="text" name="gender"  value="${clerk.cl_sex }" class="layui-input" autocomplete="off">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">出生日期</label>
            <div class="layui-input-inline">
                <input type="text" name="birthday" value="${clerk.cl_time }" id="birthday" class="layui-input"  />
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn layui-btn-radius layui-btn-normal" id="close">立即修改</button>
            </div>
        </div>
    </form>
</div>
<script src="<%=basePath%>layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/nginx.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
<script src="<%=basePath%>backstage/js/appControl/employee/employeeModify.js"></script>
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
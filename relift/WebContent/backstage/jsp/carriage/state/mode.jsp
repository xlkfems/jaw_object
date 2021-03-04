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
    <title></title>
    <link rel="stylesheet" href="<%=basePath%>backstage/layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin.css">
</head>
<body>

<div class="layui-form-item" style="margin-top: 20px">
    <form class="layui-form" action="modeServlet?oper=update_mode" method="post">
       	<div class="layui-form-item">
            <label class="layui-form-label">货运编号</label>
            <div class="layui-input-inline">
                <input type="text" id="number" name="number" value="${number}" value="${make.fre_number}"  readonly class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">司机编号</label>
            <div class="layui-input-inline">
                <input type="text" id="dispense" value="${city}" name="dispense" readonly class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">当前位置</label>
            <div class="layui-input-inline">
                <input type="text" id="acceptStation" value="${weizhi}" name="acceptStation"  lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn layui-btn-radius layui-btn-normal" id="close">修改</button>
            </div>
        </div>
    </form>
</div>

<script src="<%=basePath%>backstage/layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery.cookie.js"></script>
<script src="<%=basePath%>backstage/js/nginx.js"></script>
</body>
</html>

<script type="text/javascript">
layui.use(['element', 'form', 'laydate', 'layer', 'table'], function(){
    let element = layui.element,
    form = layui.form,
    laydate = layui.laydate,
    layer = layui.layer,
    table = layui.table;
    let bill_code = window.location.href.split('=')[1];
    let employeeId = $.cookie('loginId');

});

</script>
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
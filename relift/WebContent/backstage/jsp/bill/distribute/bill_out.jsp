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
    <form class="layui-form" action="billServlet?oper=addbill" method="post">
       	<div class="layui-form-item">
            <label class="layui-form-label">货运编号</label>
            <div class="layui-input-inline">
                <input type="text" id="number" name="number" value="${make.fre_number}"  readonly class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">分发人</label>
            <div class="layui-input-inline">
                <input type="text" id="dispense" value="ZY884812" name="dispense" readonly class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">领票人</label>
            <div class="layui-input-inline">
                <select name="receiveBillPerson" id="receiveBillPerson" >
                 <option value="">请选择领票人</option>
                	<c:forEach items="${driverList}" var="driver">
                    	<option value="${driver.dr_number}">${driver.dr_number}</option>
                 	</c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">领票时间</label>
            <div class="layui-input-inline">
                <input type="text" id="receiveBillTime" name="receiveBillTime" class="layui-input" readonly>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">接货点</label>
            <div class="layui-input-inline">
                <input type="text" id="acceptStation" value="${make.make}" name="acceptStation" readonly lay-verify="required" placeholder="请输入接货点" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn layui-btn-radius layui-btn-normal"id="close">分发</button>
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

    form.render();

    $.ajax({
        type: 'get',
        url: nginx_url + '/driverInfo/selectAllId',
        dataType: 'json',
        async: false,
        success: function (result) {
            console.log(result);
            $.each(result, function (i, item) {
                let option = '<option value="' + item + '">';
                option += item;
                option += '</option>';
                $("#receiveBillPerson").append(option);
            });
            form.render('select');
        }
    });
    $("#releasePerson").val(employeeId);
    laydate.render({
        elem: '#receiveBillTime',
        value: new Date()
    });
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
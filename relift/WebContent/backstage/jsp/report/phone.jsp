<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
        request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="<%=basePath%>backstage/layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin.css">
</head>
<body>

<div class="layui-form-item" style="margin-top: 20px">
    <form class="layui-form" action="<%=basePath%>messageServlet?oper=add" method="post" >
        <div class="layui-form-item">
            <label class="layui-form-label">客户编号</label>
            <div class="layui-input-inline">
                <input type="text" id="dialNo" value="${place.pick}" name="dialNo" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">标题</label>
            <div class="layui-input-inline">
                <div class="layui-input-inline">
                    <input type="text" id="type" name="type"  class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">内容</label>
            <div class="layui-input-inline">
                <input type="text" id="content" name="content" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">填写人</label>
            <div class="layui-input-inline">
                <input type="text" id="writer" value="admin" name="writer"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">填写时间</label>
            <div class="layui-input-inline">
                <input type="text" id="receiveBillTime" name="receiveBillTime" class="layui-input" readonly>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-radius layui-btn-normal" type="submit" lay-filter="confirm" id="confirm">确认提交</button>
            </div>
        </div>
    </form>
</div>

<script src="<%=basePath%>backstage/layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery.cookie.js"></script>

<script src="<%=basePath%>backstage/js/nginx.js"></script>
<script src="<%=basePath%>backstage/js/customerService/write.js"></script>

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
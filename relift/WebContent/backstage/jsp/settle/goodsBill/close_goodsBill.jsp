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
    <title>运输合同结算页面</title>
    <link rel="stylesheet" href="<%=basePath%>backstage/layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin.css">
</head>
<body>
    <div class="layui-tab layui-tab-brief" lay-filter="demo">
        <div class="layui-tab-content" style="height: 100px; display: block">
            <div class="layui-tab-item layui-show">
                <div class="layui-form-item">
                <form class="layui-form" action="<%=basePath%>placeServlet?oper=update_place" method="post">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">客户编号</label>
                            <div class="layui-input-inline">
                                <input type="text" id="customerCode" value="${place.pick}" name="customerCode" readonly autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">货运单编号</label>
                            <div class="layui-input-inline">
                                <input type="text" id="goodsBillCode" value="${place.number}" name="goodsBillCode" readonly autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-form-item">
           				 <label class="layui-form-label">结算时间</label>
            				<div class="layui-input-inline">
              			  <input type="text" id="receiveBillTime" name="receiveBillTime" class="layui-input" readonly>
            </div>
        </div>
                    </div>
                    <div class="layui-form-item">
                    
                        <div class="layui-inline">
                            <label class="layui-form-label">总运费</label>
                            <div class="layui-input-inline">
                                <input type="text" id="carryGoodsFee" value="${place.pl_money}" name="carryGoodsFee" readonly autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" type="submit" id="close">结账</button>
                        </div>
                    </div>
                </form>
                </div>
            </div>
        </div>
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
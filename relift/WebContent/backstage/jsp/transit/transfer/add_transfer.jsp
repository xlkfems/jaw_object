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
    <title>Title</title>
    <link rel="stylesheet" href="<%=basePath%>backstage/layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin.css">
</head>
<body>

<div class="layui-form-item" style="margin-top: 20px">
    <form class="layui-form" action="<%=basePath%>centreServlet?oper=add" method="post">
     <div class="layui-form-item">
            <label class="layui-form-label">货运编号</label>
            <div class="layui-input-inline">
                <input type="text" lay-verify="required" value="${number}" class="layui-input" id="fre_number" name="fre_number"   />
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">中转地</label>
            <div class="layui-input-inline">
                <input type="text" lay-verify="required" value="${modes.location}" class="layui-input" id="transferStation" name="transferStation"   />
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">中转验收人</label>
                <div class="layui-input-inline">
                    <input type="text" lay-verify="required" value="${modes.dr_number}" class="layui-input" id="transferCheck" name="transferCheck"   />
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">验收时间</label>
                <div class="layui-input-inline">
                     <input type="text" id="receiveBillTime" name="receiveBillTime" class="layui-input" readonly>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">中转站点名</label>
            <div class="layui-input-inline">
            <select name="receiveBillPerson" id="receiveBillPerson" lay-filter="demo">
                 <option value="">请选择中转站</option>
                	<c:forEach items="${trs}" var="trark">
                    	<option value="${trark.tr_name}">${trark.tr_name}</option>
                 	</c:forEach>
                </select>  
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">中转地址</label>
            <div class="layui-input-inline" style="width: 514px">
 			     <input type="text" lay-verify="required" class="layui-input" id="transferCompany" name="transferCompany"   />
 			</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">中转地电话</label>
            <div class="layui-input-inline">
                <input type="text" lay-verify="required" class="layui-input" id="transferStationTel" name="transferStationTel"   />
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" type="submit" id="close">提交</button>
            </div>
        </div>
    </form>
</div>

<script src="<%=basePath%>backstage/layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery.cookie.js"></script>
<script src="<%=basePath%>backstage/js/nginx.js"></script>
<script src="<%=basePath%>backstage/js/pass/transfer/write.js"></script>
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
layui.use(['element', 'form', 'laydate', 'layer', 'table'], function(){
    let element = layui.element,
    form = layui.form,
    laydate = layui.laydate,
    layer = layui.layer,
    table = layui.table;
    form.on('select(demo)', function(data){
    	var tr_name=$("#receiveBillPerson").val();
    	$.ajax({
			type:"post",//请求方式post get
			async:true,//false:同步接收
			dateType:"text",//接收数据格式
			url: "<%=basePath%>modeServlet",//地址
			data:"oper=query_trark&tr_name="+tr_name,//参数数据
			success:function(msg){
				var msg = msg.split(",");
				for(var i=0;i<msg.length;i++){
					document.getElementById("transferCompany").value=msg[0];
					document.getElementById("transferStationTel").value=msg[1];
				}	
			}
		});
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
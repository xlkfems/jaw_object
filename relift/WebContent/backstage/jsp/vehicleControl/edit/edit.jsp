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
    <title>填写运输合同</title>
    <link rel="stylesheet" href="<%=basePath%>backstage/layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin.css">
    <style>
        .wd-100 {
            width: 140px;
        }
    </style>
</head>
<body>
<div class="layui-form-item" style="margin-top: 20px">
    <form class="layui-form" action="<%=basePath%>contractServlet?oper=qurey_edit" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">货运单编号</label>
            <div class="layui-input-inline">
                <select name="goodsRevertBillCode"  id="goodsRevertBillCode" lay-filter="demo">
                    <option value="">请选择货运编号</option>
                    	<c:forEach items="${billList}" var="bill" >
                  			<option value="${bill.bi_number}">${bill.bi_number}</option>
                    	</c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">装货地点</label>
                <div class="layui-input-inline">
                    <input type="text" name="cargo" id="cargo" readonly class="layui-input test-item" />
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">起运时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="startCarryTime" id="startCarryTime" readonly class="layui-input test-item" />
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">交货地点</label>
                <div class="layui-input-inline">
                    <input type="text" name="delivery" id="delivery" readonly class="layui-input test-item" />
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">预计到达时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="arriveTime" id="arriveTime" readonly class="layui-input test-item" />
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">收货联系人</label>
                <div class="layui-input-inline">
                    <input type="text" id="receiveGoodsLinkman" name="receiveGoodsLinkman" readonly lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">联系人电话</label>
                <div class="layui-input-inline">
                    <input type="text" id="linkmanPhone" name="linkmanPhone" readonly lay-verify="required|phone"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">收货详细地址</label>
            <div class="layui-input-inline" style="width: 575px">
                <input type="text" id="receiveGoodsDetailAddr" name="receiveGoodsDetailAddr" readonly lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">运费结算方式</label>
                <div class="layui-input-inline">
                    <input type="text" id="carriageBanlanceMode" name="carriageBanlanceMode" lay-verify="required" placeholder="请输入运费结算方式"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">备注</label>
                <div class="layui-input-inline">
                    <input type="text" id="remark" name="remark" placeholder="请输入备注"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">司机编号</label>
                <div class="layui-input-inline">
                    <input type="text" id="driverId" readonly name="driverId"  placeholder="请输入司机编号"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">货运单状态</label>
                <div class="layui-input-inline">
                   <input type="text" id="backBillState" readonly name="backBillState" value="待配车" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">总运费</label>
                <div class="layui-input-inline">
                    <input type="text" id="allCarriage" name="allCarriage" lay-verify="required|number" placeholder="请输入总运费"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">签定时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="signTime" id="signTime" class="layui-input test-item"/>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn"  type="submit">立即提交</button>
                <button type="reset" id="resetForm" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script src="<%=basePath%>backstage/layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
<script src="<%=basePath%>backstage/js/nginx.js"></script>
<script type="text/javascript">
layui.use(['element', 'form', 'laydate', 'layer', 'table'], function(){
    let element = layui.element,
    form = layui.form,
    laydate = layui.laydate,
    layer = layui.layer,
    table = layui.table;
    form.on('select(demo)', function(msg){
    	var number=$("#goodsRevertBillCode").val();
    	$.ajax({
			type:"post",//请求方式post get
			async:true,//false:同步接收
			dateType:"text",//接收数据格式
			url: "<%=basePath%>contractServlet",//地址
			data:"oper=con_query&number="+number,//参数数据
			success:function(msg){
				var msg = msg.split(",");
				for(var i=0;i<msg.length;i++){
					document.getElementById("cargo").value=msg[0]
					document.getElementById("delivery").value=msg[1]
					document.getElementById("receiveGoodsLinkman").value=msg[2]
					document.getElementById("linkmanPhone").value=msg[3]
					document.getElementById("receiveGoodsDetailAddr").value=msg[4]
					document.getElementById("startCarryTime").value=msg[5]
					document.getElementById("arriveTime").value=msg[6]
					document.getElementById("driverId").value=msg[7]
					document.getElementById("remark").value=msg[8]
					document.getElementById("carriageBanlanceMode").value=msg[9]
					document.getElementById("allCarriage").value=msg[10]
				}	
			}
		});
    });
    
    laydate.render({
        elem: '#signTime',
        value: new Date()
    });
});
</script>
</body>
</html>
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
    <title>接货单填写页面</title>
    <link rel="stylesheet" href="<%=basePath%>backstage/layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin.css">
    
    <style>
        .wd-100 {
            width: 100px;
        }
    </style>
</head>
<body>
<div class="layui-form-item" style="margin-top: 20px">
    <form class="layui-form" action="makeServlet?oper=add" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">订单编号</label>
            <div class="layui-input-inline">
                <select id="send_place" name="send_place" lay-filter="demo">
                    <option value="">请选择订单编号</option>
                    <c:forEach items="${placeList}" var="place">
                    	<option  value="${place.number}">${place.number}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">发货客户</label>
                <div class="layui-input-inline">
                    <input type="text" id="m_name" name="m_name" readonly="readonly" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">发货客户电话</label>
                <div class="layui-input-inline">
                    <input type="text" id="m_phone"  name="m_phone" readonly="readonly"  class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">发货客户地址</label>
            <div class="layui-input-inline" style="width: 534px">
                <input type="text" id="m_address_block" name="m_address_block" readonly="readonly"  class="layui-input">
            </div>
        </div>
        <div class="layui-form-item"> 
            <div class="layui-inline">
                <label class="layui-form-label wd-100">收货客户</label>
                <div class="layui-input-inline">
                    <input type="text" id="a_name" name="a_name" readonly="readonly"  class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">收货客户电话</label>
                <div class="layui-input-inline">
                    <input type="text" id="a_phone"  name="a_phone"  readonly="readonly" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">收货客户地址</label>
            <div class="layui-input-inline" style="width: 534px">
                <input type="text" id="a_address_block"  name="a_address_block" readonly="readonly"  class="layui-input">
            </div>
        </div>
        
        <div class="layui-form-item"> 
            <div class="layui-inline">
                <label class="layui-form-label wd-100">件数</label>
                <div class="layui-input-inline">
                    <input type="text" id="piece" name="piece" readonly="readonly" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">总体积</label>
                <div class="layui-input-inline">
                    <input type="text" id="bulk"  name="bulk" readonly="readonly" class="layui-input">
                </div>
            </div>
        </div>
         <div class="layui-form-item"> 
            <div class="layui-inline">
                <label class="layui-form-label wd-100">保价费</label>
                <div class="layui-input-inline">
                    <input type="text" id="support" name="support"  readonly="readonly"    class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">计费标准</label>
                <div class="layui-input-inline">
                    <input type="text" id="a_phone" value="计重"  readonly="readonly"  class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">发货日期</label>
            <div class="layui-input-inline">
                <input type="text" name="sendGoodsDate"  id="sendGoodsDate" class="layui-input test-item" />
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">发货地址</label>
            <div class="layui-input-inline" style="width: 534px">
                <input type="text" id="consignment" name="consignment" lay-verify="required" placeholder="请输入发货地址" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">收货地址</label>
            <div class="layui-input-inline" style="width: 534px">
                <input type="text" id="delivery" name="delivery" lay-verify="required" placeholder="请输入收货地址" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">预期交货日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="predeliveryDate" id="predeliveryDate" class="layui-input test-item" />
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">实际交货日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="factDealDate" id="factDealDate" readonly="readonly" class="layui-input test-item" />
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">付款方式</label>
                <div class="layui-input-inline">
                    <input type="text" id="payMode" name="payMode" lay-verify="required" placeholder="请输入付款方式"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">取货方式</label>
                <div class="layui-input-inline">
                    <input type="text" id="fetchGoodsMode" name="fetchGoodsMode" lay-verify="required" placeholder="请输入取货方式"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">填票人</label>
                <div class="layui-input-inline">
                    <input type="text" id="writeBillPerson"  name="writeBillPerson" readonly="readonly" lay-verify="required" placeholder="请输入填票人"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">填写日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="writeDate" id="writeDate"  class="layui-input test-item"/>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">是否结账</label>
                <div class="layui-input-inline">
                    <input type="checkbox" id="checkSettle" name="checkSettle" lay-filter="checkSettle" lay-skin="switch" lay-text="结账|未结账">
                </div>
            </div>
            <input type="hidden" id="ifSettleAccounts" name="ifSettleAccounts" value="false">
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">运费</label>
                <div class="layui-input-inline">
                    <input type="text" id="carriage" name="carriage" lay-verify="required|number" placeholder="请输入运费"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">职员编号</label>
                <div class="layui-input-inline">
                    <input type="text" id="employeeCode" value="admin" name="employeeCode" readonly="readonly"  placeholder="admin"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">备注</label>
                <div class="layui-input-inline">
                    <input type="text" id="remark" name="remark" placeholder="请输入备注"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">状态</label>
                <div class="layui-input-inline">
                    <input type="text" id="acceptStation" name="acceptStation" readonly="readonly" lay-verify="required" 
                           autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn"  class="layui-btn layui-btn-sm">立即提交</button>
                <button type="reset" id="resetForm" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery.cookie.js"></script>
<script src="<%=basePath%>backstage/layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/goodsBillControl/edit/editGoodsBill.js"></script>
<script src="<%=basePath%>backstage/js/x-layui.js"></script>
<script type="text/javascript">

</script>
<script type="text/javascript">
layui.use(['element', 'form', 'laydate', 'layer', 'table'], function(){
    let element = layui.element,
    form = layui.form,
    laydate = layui.laydate,
    layer = layui.layer,
    table = layui.table;
    form.on('select(demo)', function(data){
    	var number=$("#send_place").val();
    	$.ajax({
			type:"post",//请求方式post get
			async:true,//false:同步接收
			dateType:"text",//接收数据格式
			url: "<%=basePath%>makeServlet",//地址
			data:"oper=query&number="+number,//参数数据
			success:function(msg){
				var msg = msg.split(",");
				for(var i=0;i<msg.length;i++){
					document.getElementById("m_name").value=msg[3];
					document.getElementById("m_phone").value=msg[4];
					document.getElementById("m_address_block").value=msg[5];
					document.getElementById("a_name").value=msg[0];
					document.getElementById("a_phone").value=msg[1];
					document.getElementById("a_address_block").value=msg[2];
					document.getElementById("piece").value=msg[6];//件数
					document.getElementById("bulk").value=msg[8];//体积
					document.getElementById("support").value=msg[7];//货物价值
					document.getElementById("acceptStation").value=msg[9];//货物价值
					document.getElementById("writeBillPerson").value=msg[10];//货物价值
					document.getElementById("carriage").value=msg[11];//货物价值
					document.getElementById("remark").value=msg[12];//货物价值
				}	
			}
		});
    });
});
</script>
</body>
</html>
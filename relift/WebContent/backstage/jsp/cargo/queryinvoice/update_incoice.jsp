<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
        request.getServerPort() + path + "/";
%>
<head>
    <meta charset="UTF-8">
    <title>接货单填写页面</title>
    <link rel="stylesheet" href="<%=basePath%>backstage/layui/css/layui.css">
    <link rel="stylesheet"  href="<%=basePath%>backstage/css/admin.css">
    <style>
        .wd-100 {
            width: 100px;
        }
    </style>
    
</head>
<body>
<div class="layui-form-item" style="margin-top: 20px">
    <form class="layui-form" action="<%=basePath%>makeServlet?oper=update_make" method="post" id="goodsBillForm">
    
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">货运编号</label>
            <div class="layui-input-inline">
                <input type="text" name="sendGoodsCustomerNo" value="${make.fre_number}" id="sendGoodsCustomerNo" readonly autocomplete="off" class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">发货客户</label>
                <div class="layui-input-inline">
                    <input type="text" id="sendGoodsCustomer" value="${make.liaisons}" name="sendGoodsCustomer" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">发货客户电话</label>
                <div class="layui-input-inline">
                    <input type="text" id="sendGoodsCustomerTel" value="${make.phone}" name="sendGoodsCustomerTel" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">发货客户地址</label>
            <div class="layui-input-inline" style="width: 534px">
                <input type="text" id="sendGoodsCustomerAddr" value="${make.site}" name="sendGoodsCustomerAddr" disabled autocomplete="off" class="layui-input" value="${user.make_mend}">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">收货客户</label>
                <div class="layui-input-inline">
                    <input type="text" id="receiveGoodsCustomer" value="${make.take_Name}" name="receiveGoodsCustomer" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">收货客户电话</label>
                <div class="layui-input-inline">
                    <input type="text" id="receiveGoodsCustomerTel" value="${make.take_phone}" name="receiveGoodsCustomerTel" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">收货客户地址</label>
            <div class="layui-input-inline" style="width: 534px">
                <input type="text" id="receiveGoodsCustomerAddr" value="${make.take_site}" name="receiveGoodsCustomerAddr" disabled autocomplete="off" class="layui-input">
            </div>
        </div>
        
          <div class="layui-form-item"> 
            <div class="layui-inline">
                <label class="layui-form-label wd-100">件数</label>
                <div class="layui-input-inline">
                    <input type="text" id="piece" name="piece" value="${make.piece}" readonly="readonly" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">总体积</label>
                <div class="layui-input-inline">
                    <input type="text" id="bulk"  name="bulk" value="${make.bulk}" readonly="readonly" class="layui-input">
                </div>
            </div>
        </div>
         <div class="layui-form-item"> 
            <div class="layui-inline">
                <label class="layui-form-label wd-100">保价费</label>
                <div class="layui-input-inline">
                    <input type="text" id="support" name="support" value="${make.support}"  readonly="readonly"    class="layui-input">
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
                <input type="text" name="sendGoodsDate"  value="${make.make_date}" id="sendGoodsDate" disabled class="layui-input test-item" />
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">发货地址</label>
            <div class="layui-input-inline" style="width: 534px">
                <input type="text" id="sendGoodsAddr"  value="${make.make}" name="sendGoodsAddr"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">收货地址</label>
            <div class="layui-input-inline" style="width: 534px">
                <input type="text" id="receiveGoodsAddr"  value="${make.make_receipt}" name="receiveGoodsAddr"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">付款方式</label>
                <div class="layui-input-inline">
                    <input type="text" id="payMode" value="${make.moneystate}" name="payMode" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">取货方式</label>
                <div class="layui-input-inline">
                    <input type="text" id="fetchGoodsMode" value="${make.make_state}" name="fetchGoodsMode" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">填票人</label>
                <div class="layui-input-inline">
                    <input type="text" id="writeBillPerson" value="${make.make_people}" name="writeBillPerson" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">填写日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="writeDate" value="${make.make_time}" id="writeDate" disabled class="layui-input test-item"/>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            
            <div class="layui-inline">
                <label class="layui-form-label wd-100">运费</label>
                <div class="layui-input-inline">
                    <input type="text" id="carriage" value="${make.make_freight}" name="carriage" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            
            <div class="layui-inline">
                <label class="layui-form-label wd-100">职员编号</label>
                <div class="layui-input-inline">
                    <input type="text" id="employeeCode" value="${make.clerk}" name="employeeCode" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">备注</label>
                <div class="layui-input-inline">
                    <input type="text" id="remark" value="${make.remark}" name="remark" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">状态</label>
                <div class="layui-input-inline">
                    <input type="text" id="acceptStation" value="${make.state}" name="acceptStation" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-radius layui-btn-normal" type="submit" lay-filter="modifyGoodsBill" id="modifyGoodsBill">立即修改</button>
            </div>
        </div>
        </div>
    </form>
</div>
<script src="<%=basePath%>backstage/layui/layui.js"></script>
	<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
	<script src="<%=basePath%>backstage/js/nginx.js"></script>
	<script src="<%=basePath%>backstage/js/goodsBillControl/detail/goodsBillDetail.js"></script>

</body>
</html>
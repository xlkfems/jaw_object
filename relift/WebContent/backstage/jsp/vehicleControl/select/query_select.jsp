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
    <form class="layui-form" action="" id="cargoReceiptForm">
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">货运回执单编号</label>
            <div class="layui-input-inline">
                <input type="text" id="goodsRevertBillCode" value="${contract.fre_number}" name="goodsRevertBillCode" disabled lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">装货地点</label>
                <div class="layui-input-inline">
                    <input type="text" id="loadStation" value="${contract.make}" name="loadStation" disabled lay-verify="required" placeholder="请输入装货地点"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">起运时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="startCarryTime" value="${contract.bi_state}" id="startCarryTime" disabled class="layui-input test-item" />
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">交货地点</label>
                <div class="layui-input-inline">
                    <input type="text" id="dealGoodsStation" value="${contract.make_receipt}" name="dealGoodsStation" disabled placeholder="请输入交货地点"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">收货联系人</label>
                <div class="layui-input-inline">
                    <input type="text" id="receiveGoodsLinkman" value="${contract.take_Name}" name="receiveGoodsLinkman" disabled lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">联系人电话</label>
                <div class="layui-input-inline">
                    <input type="text" id="linkmanPhone" value="${contract.take_phone}" name="linkmanPhone" disabled lay-verify="required|phone"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">收货详细地址</label>
            <div class="layui-input-inline" style="width: 575px">
                <input type="text" id="receiveGoodsDetailAddr" value="${contract.take_site}" name="receiveGoodsDetailAddr" disabled lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
         `<div class="layui-inline">
                <label class="layui-form-label wd-100">运费结算方式</label>
                <div class="layui-input-inline">
                    <input type="text" id="carriageBanlanceMode" value="${contract.con_close}" name="carriageBanlanceMode" disabled lay-verify="required" placeholder="请输入运费结算方式"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">备注</label>
                <div class="layui-input-inline">
                    <input type="text" id="remark" name="remark" value="${contract.con_remark}" disabled lay-verify="required" placeholder="请输入备注"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">司机编号</label>
                <div class="layui-input-inline">
                    <input type="text" id="driverId" name="driverId" value="${contract.dr_number}" disabled placeholder="请输入司机编号"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">回执单状态</label>
                <div class="layui-input-inline">
                    <input type="text" id="backBillState" value="${contract.con_receipt}" name="backBillState" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
      
        </div>

        <div class="layui-form-item">
        
            <div class="layui-inline">
                <label class="layui-form-label wd-100">总运费</label>
                <div class="layui-input-inline">
                    <input type="text" id="allCarriage" value="${contract.con_freight}" name="allCarriage" disabled lay-verify="required|number" placeholder="请输入总运费"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            
            <div class="layui-inline">
                <label class="layui-form-label wd-100">签定时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="signTime" value="${contract.con_time}" id="signTime" disabled class="layui-input test-item"/>
                </div>
            </div>
        </div>
    </form>
</div>
<script src="<%=basePath%>backstage/layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
<script src="<%=basePath%>backstage/js/nginx.js"></script>
<script src="<%=basePath%>backstage/js/vehicleControl/select/showDetail.js"></script>

</body>
</html>
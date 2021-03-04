<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>接货单填写页面</title>
    <link rel="stylesheet" href="../../../layui/css/layui.css">
    <link rel="stylesheet" href="../../../css/admin.css">
    <style>
        .wd-100 {
            width: 100px;
        }
    </style>
</head>
<body>
<div class="layui-form-item" style="margin-top: 20px">
    <form class="layui-form" action="" id="goodsBillForm">
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">发货客户编号</label>
            <div class="layui-input-inline">
                <input type="text" name="sendGoodsCustomerNo" id="sendGoodsCustomerNo" disabled autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">发货客户</label>
                <div class="layui-input-inline">
                    <input type="text" id="sendGoodsCustomer" name="sendGoodsCustomer" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">发货客户电话</label>
                <div class="layui-input-inline">
                    <input type="text" id="sendGoodsCustomerTel" name="sendGoodsCustomerTel" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">发货客户地址</label>
            <div class="layui-input-inline" style="width: 534px">
                <input type="text" id="sendGoodsCustomerAddr" name="sendGoodsCustomerAddr" disabled autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">收货客户编号</label>
            <div class="layui-input-inline">
                <input type="text" id="receiveGoodsCustomerCode" name="receiveGoodsCustomerCode" disabled autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">收货客户</label>
                <div class="layui-input-inline">
                    <input type="text" id="receiveGoodsCustomer" name="receiveGoodsCustomer" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">收货客户电话</label>
                <div class="layui-input-inline">
                    <input type="text" id="receiveGoodsCustomerTel" name="receiveGoodsCustomerTel" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">收货客户地址</label>
            <div class="layui-input-inline" style="width: 534px">
                <input type="text" id="receiveGoodsCustomerAddr" name="receiveGoodsCustomerAddr" disabled autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">发货日期</label>
            <div class="layui-input-inline">
                <input type="text" name="sendGoodsDate" id="sendGoodsDate" disabled class="layui-input test-item" />
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">发货地址</label>
            <div class="layui-input-inline" style="width: 534px">
                <input type="text" id="sendGoodsAddr" name="sendGoodsAddr" disabled autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">收货地址</label>
            <div class="layui-input-inline" style="width: 534px">
                <input type="text" id="receiveGoodsAddr" name="receiveGoodsAddr" disabled autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">货物名称</label>
                <div class="layui-input-inline">
                    <input type="text" id="payMode" name="payMode" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">重量</label>
                <div class="layui-input-inline">
                    <input type="text" id="fetchGoodsMode" name="fetchGoodsMode" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">送货类型</label>
                <div class="layui-input-inline">
                    <input type="text" id="writeBillPerson" name="writeBillPerson" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">上门日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="writeDate" id="writeDate" disabled class="layui-input test-item"/>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">提货方式</label>
                <div class="layui-input-inline">
				<input type="text" id="transferStation" name="transferStation" disabled autocomplete="off" class="layui-input">                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">付款方式</label>
                <div class="layui-input-inline">
                    <input type="text" id="transferStation" name="transferStation" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">备注</label>
                <div class="layui-input-inline">
                    <input type="text" id="remark" name="remark" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
    </form>
</div>
<script src="../../../layui/layui.js"></script>
<script src="../../../js/jquery/jquery-3.3.1.js"></script>
</body>
</html>
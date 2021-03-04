<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>顾客确认收货页面</title>
    <link rel="stylesheet" href="../../../layui/css/layui.css">
    <link rel="stylesheet" href="../../../css/admin.css">
</head>
<body>

<div class="layui-form-item" style="margin-top: 20px">
    <form class="layui-form" action="" id="confirmForm">
        <div class="layui-form-item">
            <label class="layui-form-label">货运单编号</label>
            <div class="layui-input-inline">
                <input type="text" id="goodsBillCode" name="goodsBillCode" disabled class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">客户名称</label>
            <div class="layui-input-inline">
                <input type="text" id="customer" name="customer" disabled class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">验收记录</label>
            <div class="layui-input-inline">
                <input type="text" id="checkGoodsRecord" name="checkGoodsRecord" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">收货人</label>
            <div class="layui-input-inline">
                <input type="text" id="receiveGoodsPerson" name="receiveGoodsPerson" disabled class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">收货日期</label>
            <div class="layui-input-inline">
                <input type="text" id="receiveGoodsDate" name="receiveGoodsDate" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-radius layui-btn-normal" lay-submit lay-filter="confirm" id="confirm">确认收货</button>
            </div>
        </div>
    </form>
</div>
<script src="../../../layui/layui.js"></script>
<script src="../../../js/jquery/jquery-3.3.1.js"></script>
<script src="../../../js/jquery/jquery.cookie.js"></script>

<script src="../../../js/nginx.js"></script>
<script src="../../../js/getGoodsControl/callback/confirm.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../../layui/css/layui.css">
    <link rel="stylesheet" href="../../../css/admin.css">
</head>
<body>

<div class="layui-form-item" style="margin-top: 20px">
    <form class="layui-form" action="" id="releaseForm">
        <div class="layui-form-item">
            <label class="layui-form-label">回执编号</label>
            <div class="layui-input-inline">
                <input type="text" id="goodsRevertCode" name="goodsRevertCode" disabled class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">司机姓名</label>
            <div class="layui-input-inline">
                <input type="text" id="driverName" name="driverName" disabled class="layui-input">
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
                <input type="text" id="receiveGoodsPerson" name="receiveGoodsPerson" required lay-verify="required" placeholder="请输入接货点" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">收货日期</label>
            <div class="layui-input-inline">
                <input type="text" id="rceiveGoodsDate" name="rceiveGoodsDate"disabled class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-radius layui-btn-normal" lay-submit lay-filter="confirm" id="confirm">确认提交</button>
            </div>
        </div>
    </form>
</div>

<script src="../../../layui/layui.js"></script>
<script src="../../../js/jquery/jquery-3.3.1.js"></script>
<script src="../../../js/jquery/jquery.cookie.js"></script>

<script src="../../../js/nginx.js"></script>
<script src="../../../js/getGoodsControl/callback/inform.js"></script>
</body>
</html>
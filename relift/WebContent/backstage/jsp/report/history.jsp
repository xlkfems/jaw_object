<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>回告信息详情页</title>
    <link rel="stylesheet" href="./../../layui/css/layui.css">
    <link rel="stylesheet" href="./../../css/admin.css">
</head>
<body>
<div class="layui-form-item" style="margin-top: 20px">
    <form class="layui-form" action="" id="informForm">
        <div class="layui-form-item">
            <label class="layui-form-label">拨出号码</label>
            <div class="layui-input-inline">
                <input type="text" id="dialNo" name="dialNo" disabled class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">类别</label>
            <div class="layui-input-inline">
                <div class="layui-input-inline">
                    <input type="text" id="type" name="type" disabled class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">内容</label>
            <div class="layui-input-inline">
                <input type="text" id="content" name="content" disabled class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">填写人</label>
            <div class="layui-input-inline">
                <input type="text" id="writer" name="writer" disabled class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">填写时间</label>
            <div class="layui-input-inline">
                <input type="text" id="writeTime" name="writeTime" disabled class="layui-input">
            </div>
        </div>
    </form>

</div>
<script src="./../../layui/layui.js"></script>
<script src="./../../js/jquery/jquery-3.3.1.js"></script>
<script src="./../../js/jquery/jquery.cookie.js"></script>

<script src="./../../js/nginx.js"></script>
<script src="./../../js/customerService/detail.js"></script>
</body>
</html>
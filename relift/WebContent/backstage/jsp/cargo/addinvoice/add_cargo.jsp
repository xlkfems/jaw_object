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
    <title>添加货物</title>
   <link rel="stylesheet" href="<%=basePath%>backstage/layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin.css">
</head>
<body>

<div class="layui-form-item"  style="margin-top: 20px">
    <form class="layui-form" action="" id="goodsForm">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">件数</label>
                <div class="layui-input-inline">
                    <input type="text" id="pieceAmount" value="${query_refer.piece}" name="pieceAmount" lay-verify="required|number" placeholder="请输入件数" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">总体积</label>
                <div class="layui-input-inline">
                    <input type="text" id="volume" value="${query_refer.weight}" name="volume" lay-verify="required|number" placeholder="请输入体积" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">计价方式</label>
                <div class="layui-input-inline">
                    <input type="text" id="priceMode" name="priceMode" value="计重" disabled="disabled" lay-verify="required" placeholder="请输入计价方式"
                           autocomplete="off" class="layui-input layui-btn-disabled">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">计费标准</label>
                <div class="layui-input-inline">
                    <input type="text" id="priceStandard" name="priceStandard" value="体积/7000" disabled="disabled"  lay-verify="required" placeholder="请输入计费标准" autocomplete="off"
                           class="layui-input layui-btn-disabled">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">货物价值</label>
                <div class="layui-input-inline">
                    <input type="text" id="goodsValue" value="${query_refer.cost}" name="goodsValue" lay-verify="required|number" placeholder="请输入货物价值"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" class="layui-btn" lay-submit lay-filter="addGoods" id="addGoods">立即提交</button>
                <button type="reset" id="resetForm" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
<script src="<%=basePath%>backstage/layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/nginx.js"></script>
<script src="<%=basePath%>backstage/js/goodsBillControl/edit/editGoods.js"></script>
</body>
</html>
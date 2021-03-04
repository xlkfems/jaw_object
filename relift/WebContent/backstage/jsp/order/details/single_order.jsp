<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
        request.getServerPort() + path + "/";
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单查询页面</title>
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
    <form class="layui-form" action="" id="goodsBillForm">
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">运单编号</label>
            <div class="layui-input-inline">
                <input type="text" name="number" value="${place.number}" id="number" disabled autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
                <label class="layui-form-label wd-100">客户编号</label>
                <div class="layui-input-inline">
				<input type="text" id="pick" name="pick" value="${place.pick}" disabled autocomplete="off" class="layui-input">                </div>
            </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">发货客户</label>
                <div class="layui-input-inline">
                    <input type="text" id="m_name" value="${place.m_name}" name="m_name" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">发货客户电话</label>
                <div class="layui-input-inline">
                    <input type="text" id="m_phone" value="${place.m_phone}" name="m_phone" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">发货客户地址</label>
            <div class="layui-input-inline" style="width: 534px">
                <input type="text" id="m_address_block" value="${place.m_address_block}" name="m_address_block" disabled autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">收货客户</label>
                <div class="layui-input-inline">
                    <input type="text" id="a_name" value="${place.a_name}" name="a_name" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">收货客户电话</label>
                <div class="layui-input-inline">
                    <input type="text" id="a_phone" value="${place.a_phone}" name="a_phone" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">收货客户地址</label>
            <div class="layui-input-inline" style="width: 534px">
                <input type="text" id="a_address_block" value="${place.a_address_block}" name="a_address_block" disabled autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">发货地址</label>
            <div class="layui-input-inline" style="width: 534px">
                <input type="text" id="m_address_block" value="${place.m_address_block}" name="m_address_block" disabled autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label wd-100">收货地址</label>
            <div class="layui-input-inline" style="width: 534px">
                <input type="text" id="a_address_block" value="${place.a_address_block}" name="a_address_block" disabled autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">货物名称</label>
                <div class="layui-input-inline">
                    <input type="text" id="cargo" name="cargo" value="${place.cargo}" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">总体积</label>
                <div class="layui-input-inline">
                    <input type="text" id="weight" name="weight" value="${place.weight}" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">送货类型</label>
                <div class="layui-input-inline">
                    <input type="text" id="type" name="type" value="${place.type}" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label wd-100">订单状态</label>
                <div class="layui-input-inline">
                    <input type="text" name="state" id="state" value="${place.state}" disabled class="layui-input test-item"/>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
           
            <div class="layui-inline">
                <label class="layui-form-label wd-100">付款方式</label>
                <div class="layui-input-inline">
                    <input type="text" id="money" name="money" value="${place.money}" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">备注</label>
                <div class="layui-input-inline">
                    <input type="text" id="remark" name="remark" value="${place.remark}" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">货物价值</label>
                <div class="layui-input-inline">
                    <input type="text" id="cost" name="cost" value="${place.insuredPrice}" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label wd-100">件数</label>
                <div class="layui-input-inline">
                    <input type="text" id="piece" name="piece" value="${place.piece}" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
    </form>
</div>
<script src="<%=basePath%>backstage/layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
</body>
</html>
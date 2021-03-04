<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cn.com.relife.util.*,cn.com.relife.entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
        request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>客户信息查询单个页面</title>
    <link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
</head>
<body>

<div class="layui-form-item" style="margin-top: 10px">
    <form class="layui-form" action="" id="cusForm">
        <div class="layui-form-item">
            <label class="layui-form-label">客户编号</label>
            <div class="layui-input-inline">
                <input type="text" name="customerCode" id="customerCode" value="${client.number }" disabled  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">客户姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="customer" value="${client.name }" id="customer" disabled  autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">电话</label>
                <div class="layui-input-inline">
                    <input type="text" name="phone" id="phone" disabled value="${client.phone }"  autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">传真</label>
                <div class="layui-input-inline">
                    <input type="text" name="fax" id="fax" disabled value="${client.fax }"  autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">邮编</label>
                <div class="layui-input-inline">
                    <input type="text" name="postCode" id="postCode" disabled value="${client.postcode }" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-inline" style="width: 514px">
                <input type="text" name="address" id="address" disabled value="${client.address }" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">联系人</label>
                <div class="layui-input-inline">
                    <input type="text" name="linkman" id="linkman" disabled value="${client.contact }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">联系人手机</label>
                <div class="layui-input-inline">
                    <input type="text" name="linkmanMobile" id="linkmanMobile" disabled value="${client.conphone }" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">客户类型</label>
                <div class="layui-input-inline">
                    <input type="text" name="customerType" id="customerType" disabled value="${client.usertype }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">企业性质</label>
                <div class="layui-input-inline">
                    <input type="text" name="enterpriseProperty" id="enterpriseProperty" disabled value="${client.enterprise }" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">企业规模</label>
                <div class="layui-input-inline">
                    <input type="text" name="enterpriseSize" id="enterpriseSize" disabled value="${client.scale }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">电子邮件</label>
                <div class="layui-input-inline">
                    <input type="text" name="email" id="email" value="${client.email }" disabled autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <!--<div class="layui-form-item">-->
            <!--<div class="layui-input-block">-->
                <!--<button type="button" class="layui-btn layui-btn-radius" lay-submit lay-filter="goToMod" id="goToMod">修改</button>-->
            <!--</div>-->
        <!--</div>-->
    </form>
</div>
<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
<script src="<%=basePath%>layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/appControl/customer/customerDetail.js"></script>
</body>
</html>
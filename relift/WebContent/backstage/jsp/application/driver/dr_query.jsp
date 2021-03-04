<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cn.com.relife.util.*,cn.com.relife.entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
        request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>司机信息详情页</title>
    <link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin.css">
</head>
<body>

<div class="layui-form-item" style="margin-top: 10px">
    <form class="layui-form" action="" id="driverForm">
        <div class="layui-form-item">
	        <div class="layui-inline">
	            <label class="layui-form-label">司机编号</label>
	            <div class="layui-input-inline">
	                <input type="text" name="customerCodes" id="customerCode" value="${driver.dr_number}" disabled autocomplete="off" class="layui-input">
	            </div>
	        </div>
            <div class="layui-inline">
                <label class="layui-form-label">司机姓名</label>
                <div class="layui-input-inline">
                    <input type="text" id="driverName" name="driverName" disabled required value="${driver.dr_name}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">身份证号</label>
                <div class="layui-input-inline">
                    <input type="text" id="idCard" name="idCard" disabled value="${driver.dr_identity }"autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">电话</label>
                <div class="layui-input-inline">
                    <input type="text" id="phone" disabled name="phone" value="${driver.dr_phone }" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-inline" >
                    <input disabled type="text"  value="${driver.dr_sex }" class="layui-input" autocomplete="off">
                   <%--  <input disabled type="radio" name="gender"  title="女" value="${driver.dr_sex }"> --%>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">出生日期</label>
                <div class="layui-input-inline">
                    <input type="text" id="birthday" disabled name="birthday" value="${driver.dr_hoday }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">车号</label>
                <div class="layui-input-inline">
                    <input type="text" id="carNo" name="carNo" disabled value="${driver.dr_car }" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">车型</label>
                <div class="layui-input-inline">
                    <input type="text" id="carType" name="carType" disabled value="${driver.dr_state }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">准载体积</label>
                <div class="layui-input-inline">
                    <input type="text" id="allowCarryVolume" name="allowCarryVolume" disabled value="${driver.dr_volume }" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">（单位： 立方米）</div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">准载重量</label>
                <div class="layui-input-inline">
                    <input type="text" id="allowCarryWeight" name="allowCarryWeight" disabled value="${driver.dr_load }" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">（单位： 吨）</div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">住址</label>
                <div class="layui-input-block" style="width: 514px">
                    <input type="text" id="address" name="address" disabled value="${driver.dr_address }" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">车厢长度</label>
                <div class="layui-input-inline">
                    <input type="text" id="carLength" name="carLength" disabled value="${driver.dr_long }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">车厢宽度</label>
                <div class="layui-input-inline">
                    <input type="text" id="carWidth" name="carWidth" disabled value="${driver.dr_width }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">载物高度</label>
                <div class="layui-input-inline">
                    <input type="text" id="goodsHeight" name="goodsHeight" disabled value="${driver.dr_length }" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">驾驶证</label>
                <div class="layui-input-inline">
                    <input type="text" id="driveLicence" name="driveLicence" disabled value="${driver.dr_licence }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">行驶证</label>
                <div class="layui-input-inline">
                    <input type="text" id="runLicence" name="runLicence" disabled value="${driver.dr_xing }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">营运证</label>
                <div class="layui-input-inline">
                    <input type="text" id="bizLicence" name="bizLicence" disabled value="${driver.dr_run }" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
           
            <div class="layui-inline">
                <label class="layui-form-label">司机状态</label>
                <div class="layui-input-inline">
                    <input type="text" id="carFrameNo" disabled name="carFrameNo" value="${driver.dr_vin }" autocomplete="off" class="layui-input">
                </div>
            </div>
            
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">车属单位</label>
                <div class="layui-input-inline">
                    <input type="text" id="carDept" disabled name="carDept" value="${driver.dr_unit }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">单位电话</label>
                <div class="layui-input-inline">
                    <input type="text" id="carDeptTel" disabled name="carDeptTel" value="${driver.unit_phone }" autocomplete="off" class="layui-input">
                </div>
            </div>
            
            <input type="hidden" id="companyCar" disabled name="companyCar" value="${driver.dr_company }">
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-inline">
                <input type="text" id="remark" disabled name="remark" value="${driver.dr_remark }" autocomplete="off" class="layui-input">
            </div>
        </div>
    </form>
</div>
<script src="<%=basePath%>layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>

<script src="<%=basePath%>backstagejs/nginx.js"></script>
<script src="<%=basePath%>backstage/js/appControl/driver/driverDetail.js"></script>
</body>
</html>
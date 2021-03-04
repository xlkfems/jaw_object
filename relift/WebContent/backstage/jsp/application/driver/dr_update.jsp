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
    <form class="layui-form" action="<%=basePath%>DriverServlet?oper=upda&id=${driver.dr_id}" method="post">
        <div class="layui-form-item">
        <div class="layui-inline">
	            <label class="layui-form-label">司机编号</label>
	            <div class="layui-input-inline">
	                <input type="text" name="customerCodes"  value="${driver.dr_number }"   autocomplete="off" class="layui-input">
	            </div>
	        </div>
            <div class="layui-inline">
                <label class="layui-form-label">司机姓名</label>
                <div class="layui-input-inline">
                    <input type="text"  name="driverName"   value="${driver.dr_name }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">身份证号</label>
                <div class="layui-input-inline">
                    <input type="text"  name="idCard"   value="${driver.dr_identity }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">电话</label>
                <div class="layui-input-inline">
                    <input type="text"  name="phone"  value="${driver.dr_phone }" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-inline">
                    <input type="text" name="gender"  value="${driver.dr_sex }" class="layui-input" autocomplete="off">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">出生日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="birthday"  value="${driver.dr_hoday }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">车号</label>
                <div class="layui-input-inline">
                    <input type="text" id="carNo" name="carNo"  value="${driver.dr_car }" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">车型</label>
                <div class="layui-input-inline">
                    <input type="text" id="carType" name="carType"  value="${driver.dr_state }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">准载体积</label>
                <div class="layui-input-inline">
                    <input type="text" id="allowCarryVolume" name="allowCarryVolume"  value="${driver.dr_volume }" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">（单位： 立方米）</div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">准载重量</label>
                <div class="layui-input-inline">
                    <input type="text" id="allowCarryWeight" name="allowCarryWeight"  value="${driver.dr_load }" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">（单位： 吨）</div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">住址</label>
                <div class="layui-input-block" style="width: 514px">
                    <input type="text" id="address" name="address"  value="${driver.dr_address }" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">车厢长度</label>
                <div class="layui-input-inline">
                    <input type="text" id="carLength" name="carLength"  value="${driver.dr_long }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">车厢宽度</label>
                <div class="layui-input-inline">
                    <input type="text" id="carWidth" name="carWidth"  value="${driver.dr_width }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">载物高度</label>
                <div class="layui-input-inline">
                    <input type="text" id="goodsHeight" name="goodsHeight"  value="${driver.dr_length }" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">驾驶证</label>
                <div class="layui-input-inline">
                    <input type="text" id="driveLicence" name="driveLicence"  value="${driver.dr_licence }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">行驶证</label>
                <div class="layui-input-inline">
                    <input type="text" id="runLicence" name="runLicence"  value="${driver.dr_xing }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">营运证</label>
                <div class="layui-input-inline">
                    <input type="text" id="bizLicence" name="bizLicence"   value="${driver.dr_run }" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
           
            <div class="layui-inline">
                <label class="layui-form-label">司机状态</label>
                <div class="layui-input-inline">
                    <input type="text" id="carFrameNo" name="carFrameNo"   value=${driver.dr_vin } autocomplete="off" class="layui-input">
                </div>
            </div>
            
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">车属单位</label>
                <div class="layui-input-inline">
                    <input type="text" id="carDept" name="carDept"   value="${driver.dr_unit }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">单位电话</label>
                <div class="layui-input-inline">
                    <input type="text" id="carDeptTel" name="carDeptTel"   value="${driver.unit_phone }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <input type="hidden" id="companyCar" name="companyCar" value="${driver.dr_company }">
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-inline">
                <input type="text" id="remark" name="remark"   value="${driver.dr_remark }" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
            	
                <button type="submit" class="layui-btn layui-btn-radius layui-btn-normal" id="close">立即修改</button>
             
            </div>
        </div>
    </form>
</div>
<script src="<%=basePath%>layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
<script src="<%=basePath%>backstage/js/nginx.js"></script>
<%-- <script src="<%=basePath%>backstage/js/appControl/driver/driverModify.js"></script>--%>
<script type="text/javascript">
	
		//layui新弹框关闭父级弹框刷新数据
		$("#close").click(function(){
			//先得到当前iframe层的索引
			var index = parent.layer.getFrameIndex(window.name); 
			//再执行关闭 
			parent.layer.close(index);  
			//关闭父级页面的表格
			//parent.layui.table.reload('table');
			window.parent.location.reload();
		});

</script>
</body>
</html>
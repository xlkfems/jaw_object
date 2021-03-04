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
    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin.css">
</head>
<body>

<div class="layui-form-item" style="margin-top: 10px">
    <form class="layui-form" action="<%=basePath%>ClientServlet?oper=upda&id=${client.id }" method="post" >
        <div class="layui-form-item">
            <label class="layui-form-label">客户编号</label>
            <div class="layui-input-inline">
                <input type="text" name="customerCode" id="customerCode" value="${client.number }"   autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">客户姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="customer" value="${client.name }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">电话</label>
                <div class="layui-input-inline">
                    <input type="text" name="phone"  value="${client.phone }"  autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">传真</label>
                <div class="layui-input-inline">
                    <input type="text" name="fax"   value="${client.fax }"  autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">邮编</label>
                <div class="layui-input-inline">
                    <input type="text" name="postCode"   value="${client.postcode }" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-inline" style="width: 514px">
                <input type="text" name="address"  value="${client.address }" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">联系人</label>
                <div class="layui-input-inline">
                    <input type="text" name="linkman"  value="${client.contact }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">联系人手机</label>
                <div class="layui-input-inline">
                    <input type="text" name="linkmanMobile"   value="${client.conphone }" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">客户类型</label>
                <div class="layui-input-inline">
                    <input type="text" name="customerType"  value="${client.usertype }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">企业性质</label>
                <div class="layui-input-inline">
                    <input type="text" name="enterpriseProperty"   value="${client.enterprise }" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">企业规模</label>
                <div class="layui-input-inline">
                    <input type="text" name="enterpriseSize"  value="${client.scale }" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">电子邮件</label>
                <div class="layui-input-inline">
                    <input type="text" name="email" value="${client.email }"  autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
            	
                <button type="submit" class="layui-btn layui-btn-radius layui-btn-normal" id="close">修改</button>
           		
            </div>
        </div>
    </form>
</div>
<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
<script src="<%=basePath%>layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/appControl/customer/customerManage.js"></script>
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
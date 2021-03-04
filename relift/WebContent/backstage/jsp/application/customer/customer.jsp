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
    <title>客户Client管理页面</title>
    <link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin.css">
</head>
<style>
	#div1{
		position:absolute;
		left:170px; 
		top:0px;
	}
</style>
<body>
    <div class="layui-tab layui-tab-brief" >
        <ul class="layui-tab-title">
            <li >添加客户</li>
            <li class="layui-this">客户查询</li>
        </ul>
        <div class="layui-tab-content" style="height: 100px; display: block">
            <div class="layui-tab-item ">
                <div class="layui-form-item">
                <form class="layui-form" action="<%=basePath%>ClientServlet?oper=add" method="post">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">客户姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="customer"  placeholder="请输入客户姓名" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">电话</label>
                            <div class="layui-input-inline">
                                <input type="text" name="phone"  placeholder="请输入电话" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">钱包余额</label>
                            <div class="layui-input-inline">
                                <input type="text" name="fax"  placeholder="请输入钱包余额" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">邮编</label>
                            <div class="layui-input-inline">
                                <input type="text" name="postCode"  placeholder="请输入邮编" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">地址</label>
                            <div class="layui-input-block" style="width: 514px">
                                <input type="text" name="address"  placeholder="请输入地址" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">联系人</label>
                            <div class="layui-input-inline">
                                <input type="text" name="linkman"  placeholder="请输入联系人" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">联系人手机</label>
                            <div class="layui-input-inline">
                                <input type="text" name="linkmanMobile"   placeholder="请输入联系人手机" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">客户类型</label>
                            <div class="layui-input-inline">
                                <input type="text" name="customerType"  placeholder="请输入客户类型" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">企业性质</label>
                            <div class="layui-input-inline">
                                <input type="text" name="enterpriseProperty"  placeholder="请输入企业性质" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">企业规模</label>
                            <div class="layui-input-inline">
                                <input type="text" name="enterpriseSize"  placeholder="请输入企业规模" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">电子邮件</label>
                            <div class="layui-input-inline">
                                <input type="text" name="email"  placeholder="请输入电子邮件" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button type="submit" class="layui-btn">立即提交</button>
                            <button type="reset" id="resetForm" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
                </div>
            </div>
 
            <div class="layui-tab-item layui-show">
             <br/>&nbsp;
      <div class="layui-input-inline">
      <form action="<%=basePath%>ClientServlet?oper=query_phone" method="post">
        <input type="tel" name="phone" placeholder="客户编号查询" lay-verify="required|phone" autocomplete="off" class="layui-input">
      	<button type="submit" id="div1" class="layui-btn"><i class="layui-icon layui-icon-search"></i></button>
      </form>
        </div>
               <table class="layui-table">
		  <colgroup>
		  <col width="80">
		  <col>
		  </colgroup>
		  <tr>
		  	   <td>ID</td>
		  	   <td>客户编号</td>
    	       <td>客户姓名</td>
    	       <td>电话</td>
    	       <td>地址</td>
    	       <td>电子邮箱</td>
    	       <td>操作</td>
    	   </tr>
    	   <c:forEach items="${pages.getListClient()}" var="c">
    	    <tr>
    	   	   <td>${c.id}</td>
    	   	   <td>${c.number}</td>
    	       <td>${c.name}</td>
    	       <td>${c.phone}</td>
    	       <td>${c.address}</td>
    	       <td>${c.email}</td>
    	       <td>
					<button type="button" class="layui-btn layui-btn-sm" onclick="cus_query('详情信息','<%=basePath%>ClientServlet?oper=one&id=${c.id}','800','500')">查看详细</button>
    	       		<button type="button" class="layui-btn layui-btn-sm layui-btn-normal" onclick="cus_update('修改信息','<%=basePath%>ClientServlet?oper=ones&id=${c.id}','800','500')">修改</button>
    	       		<a href="<%=basePath%>ClientServlet?oper=del&id=${c.id}" >
    	       		<button type="button" class="layui-btn layui-btn-sm layui-btn-danger">删除</button>
    	       		</a>
    	       </td>
    	   </tr>
    	 </c:forEach>
    	</table>
    	 <center>
    	<a href="<%=basePath%>ClientServlet?oper=all&pageNo=${1}"><button type="button" class="layui-btn  layui-btn-sm">首页</button></a>
 		<a href="<%=basePath%>ClientServlet?oper=all&pageNo=${pages.currPageNo-1}"><button type="button" class="layui-btn   layui-btn-sm">上一页</button></a>
 		<button type="button" class=" layui-btn-primary layui-btn-sm">${pages.getCurrPageNo()}</button>
 		<a href="<%=basePath%>ClientServlet?oper=all&pageNo=${pages.currPageNo+1}"><button type="button" class="layui-btn  layui-btn-sm">下一页</button></a>
 		<a href="<%=basePath%>ClientServlet?oper=all&pageNo=${pages.currPageNo+pages.getTotalPageCount()}"><button type="button" class="layui-btn  layui-btn-sm">尾页</button></a>
 		</center>
            </div>
        </div>
    </div>
    <script src="<%=basePath%>layui/layui.js"></script>
    <script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>backstage/js/nginx.js"></script>
    <script src="<%=basePath%>backstage/js/appControl/customer/customerManage.js"></script>
	<script src="<%=basePath%>backstage/js/x-layui.js"></script>
<script type="text/javascript">
/*添加*/
function cus_query(title,url,w,h){
    x_admin_show(title,url,w,h);
}
function cus_update(title,url,w,h){
    x_admin_show(title,url,w,h);
}
  </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cn.com.relife.util.*,cn.com.relife.entity.*" %>
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
    <title>职员管理页面</title>
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
            <li >添加公告</li>
            <li class="layui-this">公告查询</li>
        </ul>
      
        <div class="layui-tab-content" style="height: 100px; display: block">
            <div class="layui-tab-item ">
                <div class="layui-form-item">
                    <form class="layui-form" action="<%=basePath%>noticeServlet?oper=add" method="post">
                        <div class="layui-form-item">
                            <label class="layui-form-label">公告标题</label>
                            <div class="layui-input-inline">
                                <input type="text" name="employeeName" id="employeeName"   placeholder="请输入职员姓名"  class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">发布日期</label>
                            <div class="layui-input-inline">
                                <input type="text" name="birthday" id="birthday" class="layui-input" />
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
					    <label class="layui-form-label">内容</label>
					    <div class="layui-input-block">
					      <textarea placeholder="请输入内容" id="content" name="content" class="layui-textarea"></textarea>
					    </div>
					  </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button type="submit" class="layui-btn">立即提交</button>
                                <button type="reset"  class="layui-btn" id="resetForm">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="layui-tab-item layui-show">
                <table class="layui-table">
                
		  <colgroup>
		  <col width="80">
		  <col>
		  </colgroup>
		  <tr>
		  	   <td>ID</td>
		  	   <td>公告标题</td>
    	       <td>发表日期</td>
    	       <td>操作</td>
    	   </tr>
    	 <c:forEach items="${pages.getListNotice()}" var="c">
    	    <tr>
    	   	   <td>${c.id}</td>
    	   	   <td>${c.title}</td>
    	       <td>${c.date_time}</td>
    	       <td>
    	       <a href="<%=basePath%>noticeServlet?oper=delete&id=${c.id}">
    	       <button type="button" class="layui-btn layui-btn-sm layui-btn-danger">删除</button>
    	       </a>
    	       </td>
    	   </tr>
    	 </c:forEach>
    	</table>
    	  <center>
    	<a href="<%=basePath%>noticeServlet?oper=query_phone&pageNo=${1}"><button type="button" class="layui-btn  layui-btn-sm">首页</button></a>
 		<a href="<%=basePath%>noticeServlet?oper=query_phone&pageNo=${pages.currPageNo-1}"><button type="button" class="layui-btn   layui-btn-sm">上一页</button></a>
 		<button type="button" class=" layui-btn-primary layui-btn-sm">${pages.getCurrPageNo()}</button>
 		<a href="<%=basePath%>noticeServlet?oper=query_phone&pageNo=${pages.currPageNo+1}"><button type="button" class="layui-btn  layui-btn-sm">下一页</button></a>
 		<a href="<%=basePath%>noticeServlet?oper=query_phone&pageNo=${pages.currPageNo+pages.getTotalPageCount()}"><button type="button" class="layui-btn  layui-btn-sm">尾页</button></a>
 		</center>
            </div>
        </div>
    </div>
    <script src="<%=basePath%>layui/layui.js"></script>
    <script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>

    <script src="<%=basePath%>backstage/js/nginx.js"></script>
    <script src="<%=basePath%>backstage/js/appControl/employee/employeeManage.js"></script>
	<script src="<%=basePath%>backstage/js/x-layui.js"></script>
<script type="text/javascript">
/*添加*/
function emp_update(title,url,w,h){
    x_admin_show(title,url,w,h);
}
  </script>
</body>
</html>
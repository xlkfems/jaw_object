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
            <li >添加职员</li>
            <li class="layui-this">职员查询</li>
        </ul>
      
        <div class="layui-tab-content" style="height: 100px; display: block">
            <div class="layui-tab-item ">
                <div class="layui-form-item">
                    <form class="layui-form" action="<%=basePath%>ClerkServlet?oper=add" method="post">
                        <div class="layui-form-item">
                            <label class="layui-form-label">职员姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="employeeName" required  placeholder="请输入职员姓名"  class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">职位</label>
                            <div class="layui-input-inline">
                                <select name="position">
                                    <option value=""></option>
                                    <option value="员工">员工</option>
                                </select>
                            </div>
                            <div class="layui-form-mid layui-word-aux">请选择员工职位</div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">性别</label>
                            <div class="layui-input-block">
                                <input type="radio" name="gender" value="男" title="男" checked>
                                <input type="radio" name="gender" value="女" title="女">
                            </div>
                        </div>
                        
                        <div class="layui-form-item">
                            <label class="layui-form-label">出生日期</label>
                            <div class="layui-input-inline">
                                <input type="text" name="birthday" id="birthday" class="layui-input" />
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
            <br/>&nbsp;
      <div class="layui-input-inline">
      <form action="<%=basePath%>ClerkServlet?oper=query_phone" method="post">
        <input type="tel" name="phone" placeholder="职员编号查询" lay-verify="required|phone" autocomplete="off" class="layui-input">
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
		  	   <td>职员编号</td>
    	       <td>职员姓名</td>
    	       <td>职位</td>
    	       <td>性别</td>
    	       <td>出生日期</td>
    	       <td>操作</td>
    	   </tr>
    	 <c:forEach items="${pages.getListClerk()}" var="c">
    	    <tr>
    	   	   <td>${c.cl_id}</td>
    	   	   <td>${c.cl_number}</td>
    	       <td>${c.cl_name}</td>
    	       <td>${c.cl_section}</td>
    	       <td>${c.cl_sex}</td>
    	       <td>${c.cl_time}</td>
    	       <td>
    	       <button type="button" class="layui-btn layui-btn-sm layui-btn-normal" onclick="emp_update('修改信息','<%=basePath%>ClerkServlet?oper=one&id=${c.cl_id}','800','500')">修改</button>
    	       <a href="<%=basePath%>ClerkServlet?oper=del&id=${c.cl_id}">
    	       <button type="button" class="layui-btn layui-btn-sm layui-btn-danger">删除</button>
    	       </a>
    	       </td>
    	   </tr>
    	 </c:forEach>
    	</table>
    	  <center>
    	<a href="<%=basePath%>ClerkServlet?oper=all&pageNo=${1}"><button type="button" class="layui-btn  layui-btn-sm">首页</button></a>
 		<a href="<%=basePath%>ClerkServlet?oper=all&pageNo=${pages.currPageNo-1}"><button type="button" class="layui-btn   layui-btn-sm">上一页</button></a>
 		<button type="button" class=" layui-btn-primary layui-btn-sm">${pages.getCurrPageNo()}</button>
 		<a href="<%=basePath%>ClerkServlet?oper=all&pageNo=${pages.currPageNo+1}"><button type="button" class="layui-btn  layui-btn-sm">下一页</button></a>
 		<a href="<%=basePath%>ClerkServlet?oper=all&pageNo=${pages.currPageNo+pages.getTotalPageCount()}"><button type="button" class="layui-btn  layui-btn-sm">尾页</button></a>
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
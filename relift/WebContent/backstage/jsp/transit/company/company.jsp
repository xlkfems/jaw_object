<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cn.com.relife.util.*,cn.com.relife.entity.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
        request.getServerPort() + path + "/";
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>中转站信息</title>
    <link rel="stylesheet" href="<%=basePath%>layui/css/layui.css">
    <link rel="stylesheet" href="<%=basePath%>backstage/css/admin.css">
</head>
<body>
<div class="layui-tab layui-tab-brief">
    <ul class="layui-tab-title">
        <li>中转站信息录入</li>
        <li class="layui-this">中转站信息查询</li>
    </ul>
    <div class="layui-tab-content" style="height: 100px; display: block">
        <div class="layui-tab-item">
            <div class="layui-form-item" style="margin-top: 20px">
                <form class="layui-form" action="<%=basePath%>transferServlet?oper=add" method="post">
                    <div class="layui-form-item">
                        <label class="layui-form-label">城市</label>
                        <div class="layui-input-inline">
               <select name="tr_city" id="tr_city" >
                 <option value="">请选择城市</option>
                 <option  value="长沙">长沙</option>
                 <option  value="石家庄">石家庄</option>
				 <option  value="太原">太原</option>
				 <option  value="北京">北京</option>
				 <option  value="呼和浩特">呼和浩特</option>
				 <option  value="沈阳">沈阳</option>
				 <option  value="长春">长春</option>
				 <option  value="哈尔滨">哈尔滨</option>
				 <option  value="南京">南京</option>
				 <option  value="杭州">杭州</option>
				 <option  value="合肥">合肥</option>
				 <option  value="福州">福州</option>
				 <option  value="南昌">南昌</option>
				 <option  value="济南">济南</option>
				 <option  value="郑州">郑州</option>
				 <option  value="武汉">武汉</option>
				 <option  value="广州">广州</option>
				 <option  value="南宁">南宁</option>
				 <option  value="海口">海口</option>
				 <option  value="成都">成都</option>
				 <option  value="贵阳">贵阳</option>
				 <option  value="昆明">昆明</option>
				 <option  value="拉萨">拉萨</option>
				 <option  value="西安">西安</option>
				 <option  value="兰州">兰州</option>
				 <option  value="银川">银川</option>
				 <option  value="乌鲁木齐市">乌鲁木齐市</option>
                </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">站点名称</label>
                        <div class="layui-input-inline">
                            <input type="text" class="layui-input" id="tr_name" name="tr_name"  />
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">联系电话</label>
                        <div class="layui-input-inline">
                            <input type="text" class="layui-input" id="tr_phone" name="tr_phone"  />
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">位置信息</label>
                        <div class="layui-input-inline">
                            <input type="text" class="layui-input" id="tr_longitude" name="tr_longitude"  placeholder="经纬度录入"   />
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">详细地址</label>
                        <div class="layui-input-inline" style="width: 514px">
                            <input type="text"  class="layui-input" id="tr_address" name="tr_address"/> 
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                        	<button type="submit"  class="layui-btn">提交</button>
                            <button type="reset" id="resetForm" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div  class="layui-tab-item layui-show">
            <table class="layui-table">
		  <colgroup>
		  <col width="80">
		  <col>
		  </colgroup>
		  <tr>
		  	   <td>ID</td>
    	   	   <td>所在城市</td>
    	       <td>站点名称</td>
    	       <td>联系方式</td>
    	       <td>经纬度</td>
    	       <td>详细地址</td>
    	   </tr>
    	   <c:forEach items="${pages.getListTransfer()}" var="s">
    	    <tr>
    	   	   <td>${s.tr_id}</td>
    	       <td>${s.tr_city}</td>
    	       <td>${s.tr_name}</td>
    	       <td>${s.tr_phone}</td>
    	       <td>${s.tr_longitude}</td>
    	       <td>${s.tr_address}</td>
    	   </tr>
    	    </c:forEach>
    	</table>
    	 <center>
    	<a href="<%=basePath%>transferServlet?oper=query&pageNo=${1}"><button type="button" class="layui-btn layui-btn-sm">首页</button></a>
 		<a href="<%=basePath%>transferServlet?oper=query&pageNo=${pages.currPageNo-1}"><button type="button" class="layui-btn  layui-btn-sm">上一页</button></a>
 		<button type="button" class=" layui-btn-primary layui-btn-sm">${pages.getCurrPageNo()}</button>
 		<a href="<%=basePath%>transferServlet?oper=query&pageNo=${pages.currPageNo+1}"><button type="button" class="layui-btn layui-btn-sm">下一页</button></a>
 		<a href="<%=basePath%>transferServlet?oper=query&pageNo=${pages.currPageNo+pages.getTotalPageCount()}"><button type="button" class="layui-btn layui-btn-sm">尾页</button></a>
 		</center>
        </div>
    </div>
</div>
<script src="<%=basePath%>layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
<script src="<%=basePath%>backstage/js/pass/company/write.js"></script>
</body>
</html>
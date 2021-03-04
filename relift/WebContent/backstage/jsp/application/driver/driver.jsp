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
    <title>司机管理页面</title>
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
<div class="layui-tab layui-tab-brief">

    <ul class="layui-tab-title">
        <li >司机填写</li>
        <li class="layui-this">司机查询</li>
    </ul>
    <div class="layui-tab-content" style="height: 100px; display: block">
        <div class="layui-tab-item ">
            <div class="layui-form-item">
                <form class="layui-form" action="<%=basePath%>DriverServlet?oper=add" method="post">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">司机姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="driverName" required  placeholder="请输入司机姓名" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">身份证号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="idCard" required  placeholder="请输入身份证号" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">电话</label>
                            <div class="layui-input-inline">
                                <input type="text" name="phone" required  placeholder="请输入电话" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">性别</label>
                            <div class="layui-input-inline">
                                <input type="radio" name="gender" value="男" title="男" checked>
                                <input type="radio" name="gender" value="女" title="女">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">出生日期</label>
                            <div class="layui-input-inline">
                                <input type="text" id="birthday" name="birthday" required  placeholder="请输入出生日期" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">车号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="carNo" required  placeholder="请输入车号" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">车型</label>
                            <div class="layui-input-inline">
                                <input type="text" name="carType" required  placeholder="请输入车型" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">准载体积</label>
                            <div class="layui-input-inline">
                                <input type="text" name="allowCarryVolume" required  placeholder="请输入准载体积" autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">（单位： 立方米）</div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">准载重量</label>
                            <div class="layui-input-inline">
                                <input type="text" name="allowCarryWeight" required  placeholder="请输入准载重量" autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">（单位： 吨）</div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">住址</label>
                            <div class="layui-input-block" style="width: 514px">
                                <input type="text" name="address" required  placeholder="请输入司机住址" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">车厢长度</label>
                            <div class="layui-input-inline">
                                <input type="text" name="carLength" required  placeholder="请输入车厢长度" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">车厢宽度</label>
                            <div class="layui-input-inline">
                                <input type="text" name="carWidth" required  placeholder="请输入车厢宽度" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">载物高度</label>
                            <div class="layui-input-inline">
                                <input type="text" name="goodsHeight" required  placeholder="请输入载物高度" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">驾驶证</label>
                            <div class="layui-input-inline">
                                <input type="text" name="driveLicence" required  placeholder="请输入驾驶证" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">行驶证</label>
                            <div class="layui-input-inline">
                                <input type="text" name="runLicence" required  placeholder="请输入行驶证" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">营运证</label>
                            <div class="layui-input-inline">
                                <input type="text" name="bizLicence" required  placeholder="请输入营运证" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">保险证</label>
                            <div class="layui-input-inline">
                                <input type="text" name="insuranceCard" required  placeholder="请输入保险证" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">发动机号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="engineNo" required  placeholder="请输入发动机号" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">车属单位</label>
                            <div class="layui-input-inline">
                                <input type="text" name="carDept" required  placeholder="请输入车属单位" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">单位电话</label>
                            <div class="layui-input-inline">
                                <input type="text" name="carDeptTel" required  placeholder="请输入车属单位电话" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">公司车</label>
                            <div class="layui-input-inline">
                                <input type="checkbox" lay-skin="switch" id="switchValue" lay-text="是|否">
                            </div>
                        </div>
                        <input type="hidden" id="companyCar" name="companyCar" value="false">
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">备注</label>
                        <div class="layui-input-inline">
                            <input type="text" name="remark" required  placeholder="请输入备注" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button type="submit" class="layui-btn"  id="addDriver">立即提交</button>
                            <button type="reset" id="resetForm" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
       
        <div class="layui-tab-item layui-show">
        <br/>&nbsp;
      <div class="layui-input-inline">
      <form action="<%=basePath%>DriverServlet?oper=query_phone" method="post">
        <input type="tel" name="phone" placeholder="司机编号查询" lay-verify="required|phone" autocomplete="off" class="layui-input">
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
		  	   <td>司机编号</td>
    	   	   <td>司机姓名</td>
    	       <td>司机身份证</td>
    	       <td>电话</td>
    	       <td>状态</td>
    	       <td>车号</td>
    	       <td>车型</td>
    	       <td>操作</td>
    	   </tr>
    	 <c:forEach items="${pages.getListDriver()}" var="der">
    	   <tr>
		  	   <td>${der.dr_id}</td>
		  	    <td>${der.dr_number}</td>
    	   	   <td>${der.dr_name}</td>
    	       <td>${der.dr_identity}</td>
    	       <td>${der.dr_phone}</td>
    	       <td>${der.dr_remark}</td>
    	       <td>${der.dr_car}</td>
    	       <td>${der.dr_state}</td>
    	       <td>
    	       <button type="button" class="layui-btn layui-btn-sm" onclick="dr_query('详情信息','DriverServlet?oper=one&id=${der.dr_id}','800','500')">查看详细</button>
    	       <button type="button" class="layui-btn layui-btn-sm layui-btn-normal" onclick="dr_update('修改信息','<%=basePath%>DriverServlet?oper=ones&id=${der.dr_id}','800','500')">修改</button>
    	       <a href="<%=basePath%>DriverServlet?oper=del&id=${der.dr_id}">
    	       <button type="button" class="layui-btn layui-btn-sm layui-btn-danger">删除</button>
    	       </a>
    	       </td>
    	   </tr>
    	</c:forEach>
    	</table>
    	<center>
    	<a href="<%=basePath%>DriverServlet?oper=all&pageNo=${1}"><button type="button" class="layui-btn  layui-btn-sm">首页</button></a>
 		<a href="<%=basePath%>DriverServlet?oper=all&pageNo=${pages.currPageNo-1}"><button type="button" class="layui-btn   layui-btn-sm">上一页</button></a>
 		<button type="button" class=" layui-btn-primary layui-btn-sm">${pages.getCurrPageNo()}</button>
 		<a href="<%=basePath%>DriverServlet?oper=all&pageNo=${pages.currPageNo+1}"><button type="button" class="layui-btn  layui-btn-sm">下一页</button></a>
 		<a href="<%=basePath%>DriverServlet?oper=all&pageNo=${pages.currPageNo+pages.getTotalPageCount()}"><button type="button" class="layui-btn  layui-btn-sm">尾页</button></a>
 		</center>
        </div>
    </div>

</div>
<script src="<%=basePath%>layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>

<script src="<%=basePath%>backstage/js/nginx.js"></script>
<script src="<%=basePath%>backstage/js/appControl/driver/driverManage.js"></script>
<script src="<%=basePath%>backstage/js/x-layui.js"></script>
<script type="text/javascript">
function dr_query(title,url,w,h){
    x_admin_show(title,url,w,h);
}
function dr_update(title,url,w,h){
    x_admin_show(title,url,w,h);
}
  </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>橙联后台管理</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	
	<%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
        request.getServerPort() + path + "/";
	%>
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>backstage/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>backstage/common/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>backstage/css/adminstyle.css" media="all">
</head>
<body>
<div class="layui-layout layui-layout-admin" id="layui_layout">
	<!-- 顶部区域 -->
	<div class="layui-header header header-demo">

	
		<div class="layui-main">
		    <!-- logo区域 -->
			<div class="admin-logo-box">
				<a class="logo" title="logo">橙联物流后台</a>
				<div class="larry-side-menu">
					<i class="fa fa-bars" aria-hidden="true"></i>
				</div>
			</div>
            <!-- 右侧导航 -->
            <ul class="layui-nav larry-header-item">
            		<li class="layui-nav-item">
            			账户名：admin
            		</li>
					<li class="layui-nav-item">
						<a href="login.jsp">
                        <i class="iconfont icon-exit"></i>
						退出</a>
					</li>
            </ul>
		</div>
	</div>
	<!-- 左侧侧边导航开始 -->
	<div class="layui-side layui-side-bg layui-larry-side" id="larry-side">
        <div class="layui-side-scroll" id="larry-nav-side" lay-filter="side">
		
		<!-- 左侧菜单 -->
			<ul class="layui-nav layui-nav-tree">
				<li class="layui-nav-item layui-this">
					<a href="javascript:;" data-url="<%=basePath%>noticeServlet?oper=query">
				    	<i class="iconfont " data-icon='icon-home1'></i>
						<span>首页</span>
					</a>
				</li>
			<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont " ></i>
					   <span>订单信息</span>
					   <em class="layui-nav-more"></em>
					</a>
					   <dl class="layui-nav-child">
					
					    	<dd>
					    		<a href="javascript:;" data-url="<%=basePath%>placeServlet?oper=query">
					    		   <i class="iconfont " data-icon='icon-wenzhang2'></i>
					    		   <span>查询所有信息</span>
					    		</a>
					    	</dd>		   
					   </dl>
			   </li>
			<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont " ></i>
					   <span>票据管理</span>
					   <em class="layui-nav-more"></em>
					</a>
					   <dl class="layui-nav-child">
					
					    	<dd>
					    		<a href="javascript:;" data-url="<%=basePath%>billServlet?oper=distribute">
					    		   <i class="iconfont " data-icon='icon-wenzhang'></i>
					    		   <span>票据分发</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;" data-url="<%=basePath%>billServlet?oper=query">
					    		   <i class="iconfont " data-icon='icon-wenzhang2'></i>
					    		   <span>票据详情</span>
					    		</a>
					    	</dd>		   
					   </dl>
			   </li>
				<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont " ></i>
					   <span>接货管理</span>
					   <em class="layui-nav-more"></em>
					</a>
					   <dl class="layui-nav-child">
					    	<dd>
					    		<a href="javascript:;" data-url="<%=basePath%>makeServlet?oper=inquire">
					    		   <i class="iconfont " data-icon='icon-wenzhang2'></i>
					    		   <span>填写接货单</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;" data-url="<%=basePath%>makeServlet?oper=committed">
					    		   <i class="iconfont " data-icon='icon-icon1'></i>
					    		   <span>查询接货单</span>
					    		</a>
					    	</dd>
					   </dl>
			   </li>
				<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont " ></i>
					   <span>配车管理</span>
					   <em class="layui-nav-more"></em>
					</a>
					<dl class="layui-nav-child">
                           <dd>
                           	   <a href="javascript:;" data-url="<%=basePath%>contractServlet?oper=query_bill">
					              <i class="iconfont "  data-icon='icon-zhuti'></i>
					              <span>填写运输合同</span>
					           </a>
                           </dd>
                           <dd>
                           	   <a href="javascript:;" data-url="<%=basePath%>contractServlet?oper=query_contra">
					              <i class="iconfont "  data-icon='icon-zhuti'></i>
					              <span>查询运输合同</span>
					           </a>
                           </dd>
                    </dl>
				</li>
				<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont " ></i>
					   <span>运输管理</span>
					   <em class="layui-nav-more"></em>
					</a>
					   <dl class="layui-nav-child">
                           <dd>
                           	   <a href="javascript:;" data-url="<%=basePath%>modeServlet?oper=query" >
					              <i class="iconfont "  data-icon='icon-zhuti'></i>
					              <span>运输状态</span>
					           </a>
                           </dd>
					   </dl>
				</li>
			<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont " ></i>
					   <span>中转管理</span>
					   <em class="layui-nav-more"></em>
					</a>
					    <dl class="layui-nav-child">
					    	<dd>
					    		<a href="javascript:;" data-url="<%=basePath%>transferServlet?oper=query">
					    		   <i class="iconfont  " data-icon='icon-zhandianpeizhi'></i>
					    		   <span>中转站点</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;" data-url="<%=basePath%>modeServlet?oper=query_interim">
					    		   <i class="iconfont  " data-icon='icon-zhandianguanli1'></i>
					    		   <span>中转运单</span>
					    		</a>
					    	</dd>
					    	<dd>
					    		<a href="javascript:;" data-url="<%=basePath%>centreServlet?oper=query">
					    		   <i class="iconfont  " data-icon='icon-zhandianguanli1'></i>
					    		   <span>中转历史</span>
					    		</a>
					    	</dd>
					    </dl>
				</li>
				<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont " ></i>
					   <span>结算管理</span>
					   <em class="layui-nav-more"></em>
					</a>
					<dl class="layui-nav-child">
                           <dd>
                           	   <a href="javascript:;" data-url="<%=basePath%>centreServlet?oper=query_place">
					              <i class="iconfont "  data-icon='icon-zhuti'></i>
					              <span>客户运单结算</span>
					           </a>
                           </dd>
                             <dd>
                           	   <a href="javascript:;" data-url="<%=basePath%>placeServlet?oper=query_close">
					              <i class="iconfont "  data-icon='icon-zhuti'></i>
					              <span>结算历史</span>
					           </a>
                           </dd>
                    </dl>
				</li>
					<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont " ></i>
					   <span>客户服务</span>
					   <em class="layui-nav-more"></em>
					</a>
					<dl class="layui-nav-child">
                           <dd>
                           	   <a href="javascript:;" data-url="<%=basePath%>placeServlet?oper=report">
					              <i class="iconfont "  data-icon='icon-zhuti'></i>
					              <span>客户回告</span>
					           </a>
                           </dd>
                    </dl>
				</li>
					<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont " ></i>
					   <span>应用管理</span>
					   <em class="layui-nav-more"></em>
					</a>
					<dl class="layui-nav-child">
                           <dd>
                           	   <a href="javascript:;" data-url="<%=basePath%>ClientServlet?oper=all">
					              <i class="iconfont "  data-icon='icon-zhuti'></i>
					              <span>客户管理</span>
					           </a>
                           </dd>
                           <dd>
                           	    <a href="javascript:;" data-url="<%=basePath%>DriverServlet?oper=all">
					              <i class="iconfont "  data-icon='icon-zhuti'></i>
					              <span>司机管理</span>
					           </a>
                           </dd>
                           <dd>
                           	    <a href="javascript:;" data-url="<%=basePath%>ClerkServlet?oper=all">
					              <i class="iconfont "  data-icon='icon-zhuti'></i>
					              <span>职员管理</span>
					           </a>
                           </dd>
                            <dd>
                           	    <a href="javascript:;" data-url="<%=basePath%>noticeServlet?oper=query_phone">
					              <i class="iconfont "  data-icon='icon-zhuti'></i>
					              <span>公告管理</span>
					           </a>
                           </dd>
                    </dl>
				</li>
				<li class="layui-nav-item">
					<a href="javascript:;">
					   <i class="iconfont " ></i>
					   <span>地图一览</span>
					   <em class="layui-nav-more"></em>
					</a>
					<dl class="layui-nav-child">
                           <dd>
                           	   <a href="javascript:;" data-url="nationwide.jsp">
					              <i class="iconfont "  data-icon='icon-zhuti'></i>
					              <span>全国地图</span>
					           </a>
                           </dd>
                          <dd>
					    		<a href="javascript:;" data-url="<%=basePath%>transferServlet?oper=nationwide">
					    		   <i class="iconfont  " data-icon='icon-zhandianguanli1'></i>
					    		   <span>站点查询</span>
					    		</a>
					       </dd>
                           <dd>
                           	    <a href="javascript:;" data-url="line.jsp">
					              <i class="iconfont "  data-icon='icon-zhuti'></i>
					              <span>路线查询</span>
					           </a>
                           </dd>
                    </dl>
				</li>
		</ul>
	    </div>
	</div>

	<!-- 左侧侧边导航结束 -->
	<!-- 右侧主体内容 -->
	<div class="layui-body" id="larry-body" style="bottom: 0;border-left: solid 2px #2299ee;">
		<div class="layui-tab layui-tab-card larry-tab-box" id="larry-tab" lay-filter="demo" lay-allowclose="true">
			<div class="go-left key-press pressKey" id="titleLeft" title="滚动至最右侧"><i class="larry-icon larry-weibiaoti6-copy"></i> </div>
			<ul class="layui-tab-title">
				<li class="layui-this" id="admin-home"><i class="iconfont "></i><em>后台首页</em></li>
			</ul>
			<div class="go-right key-press pressKey" id="titleRight" title="滚动至最左侧"><i class="larry-icon larry-right"></i></div> 
			<ul class="layui-nav closeBox">
				 
				</ul>
			<div class="layui-tab-content" style="min-height: 150px; ">
				<div class="layui-tab-item layui-show">
					<iframe class="larry-iframe" data-id='0' src="<%=basePath%>noticeServlet?oper=query"></iframe>
				</div>
			</div>
		</div>
	</div>
	<!-- 底部区域 -->
	<div class="layui-footer layui-larry-foot" id="larry-footer">
		<div class="layui-mian">  
		    <p class="p-admin">
		    	<span>2020 &copy;</span>
		    	 湖南长沙魔方项目组,版权所有
		    </p>
		</div>
	</div>
</div>
<!-- 加载js文件-->                                                                                                                                                                                           
	<script type="text/javascript" src="<%=basePath%>backstage/common/layui/layui.js"></script> 
	<script type="text/javascript" src="<%=basePath%>backstage/js/larry.js"></script>
	<script type="text/javascript" src="<%=basePath%>backstage/js/index.js"></script>
<!-- 锁屏 -->
<div class="lock-screen" style="display: none;">
	<div id="locker" class="lock-wrapper">
		<div id="time"></div>
		<div class="lock-box center">
			<img src="images/userimg.jpg" alt="">
			<h1>admin</h1>
		</div>
	</div>
</div>

</body>
</html>
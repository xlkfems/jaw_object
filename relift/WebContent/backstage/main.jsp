<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
        request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>LarryBlogCMS-Home</title>
  <meta name="renderer" content="webkit"> 
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"> 
  <meta name="apple-mobile-web-app-status-bar-style" content="black"> 
  <meta name="apple-mobile-web-app-capable" content="yes">  
  <meta name="format-detection" content="telephone=no"> 
	<link rel="stylesheet" type="text/css" href="<%=basePath%>backstage/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>backstage/common/bootstrap/css/bootstrap.css" media="all">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>backstage/common/global.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>backstage/css/main.css" media="all">
</head>
<style type="text/css">
	#div2{
		position:absolute;
		right:120px;
		top:70px;
	}
	#div3{
		position:absolute;
		right:400px;
		top:100px;
	}
  </style>
<body>
<section class="larry-wrapper">
		<div class="col-lg-6">
             <section class="panel">
                  <header class="panel-heading bm0">
                        <span class='span-title'>物流政策及其公告</span>
                        <span class="badge" style="background-color:#FF3333;"> new </span>
                        <span class="tools pull-right"><a href="javascript:;" class="iconpx-chevron-down"></a></span>
                  </header>
                  <div class="panel-body">
                       <table class="table table-hover personal-task">
                             <tbody>
                             <c:forEach items="${pages.getListNotice()}" var="make" >
                              <tr>
                                <td>
                                  <a href="noticeServlet?oper=query_no&number=${make.title}" target="_blank">${make.title}</a>
                                </td>
                                <td class="col-md-5">查看详情 &nbsp;&nbsp;&nbsp;&nbsp; ${make.date_time}</td>
                              </tr>
                              </c:forEach>
                             </tbody>
                       </table>
                  </div>
             </section>
		</div>
		<div class="col-lg-6">
		     <!-- 快捷操作 -->
             <section class="panel">
                  <header class="panel-heading bm0">
                        <span class='span-title'>日期</span>
                        <span class="tools pull-right"><a href="javascript:;" class="iconpx-chevron-down"></a></span>
                  </header>
                  <div class="panel-body">
                        <table class="table table-hover personal-task shortcut">
                            <tr>
                            	<td>
                            	<br/><br/><br/><br/><br/><br/><br/><br/><br/>
			                    <div>
					  			<font size="5px;">
			                    <div class="data" id="div3">
			                        <p class="time" id="time">00:00:00</p>
			                        <p id="date"></p>
			                    </div>
			                    
			                    <div id="div2">
			                    <img id="weatherImg" src="<%=basePath%>backstage/images/weather_img01.png" alt="">
			                       </font>
			                            	多云
			                             <p>4-14℃</p>
			                            <p>长沙市雨花区</p>
			                    </div>
			             
			                </div>
                            	</td>
                            </tr>
                        </table>
                  </div>
             </section>
		</div>
</section>
<section class="panel">
                  <header class="panel-heading bm0">
                       <span class='span-title'>物流信息统计｛SEO数据统计｝</span>
                       <span class="tools pull-right"><a href="javascript:;" class="iconpx-chevron-down"></a></span>
                  </header>
                  <div class="panel-body laery-seo-box">
                        <div class="larry-seo-stats" id="larry-seo-stats"></div>
                  </div>
 </section>
 
<script type="text/javascript" src="<%=basePath%>backstage/common/layui/layui.js"></script>
<script type="text/javascript">
	layui.use(['jquery','layer','element'],function(){
		window.jQuery = window.$ = layui.jquery;
		window.layer = layui.layer;
        window.element = layui.element();

       $('.panel .tools .iconpx-chevron-down').click(function(){
       	   var el = $(this).parents(".panel").children(".panel-body");
       	   if($(this).hasClass("iconpx-chevron-down")){
       	   	   $(this).removeClass("iconpx-chevron-down").addClass("iconpx-chevron-up");
       	   	   el.slideUp(200);
       	   }else{
       	   	   $(this).removeClass("iconpx-chevron-up").addClass("iconpx-chevron-down");
       	   	   el.slideDown(200);
       	   }
       })

	});
</script>
<script type="text/javascript" src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>backstage/jsplug/echarts.min.js"></script>
<script type="text/javascript" src="<%=basePath%>backstage/js/base.js"></script>
<script type="text/javascript">
var myChart = echarts.init(document.getElementById('larry-seo-stats'));
option = {
    title : {
        text: '本月货运情况',
        subtext: '',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['四川省','广东省','福建省','浙江省','湖南省']
    },
    series : [
        {
            name: '货运量',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:3, name:'四川省'},
                {value:2, name:'广东省'},
                {value:1, name:'福建省'},
                {value:2, name:'浙江省'},
                {value:${count}, name:'湖南省'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
myChart.setOption(option);
</script>
</body>
</html>
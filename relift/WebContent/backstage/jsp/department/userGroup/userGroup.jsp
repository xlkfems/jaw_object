<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" +     
        request.getServerPort() + path + "/";
%>
<script src="<%=basePath%>backstage/layui/layui.js"></script>
<script src="<%=basePath%>backstage/js/jquery/jquery-3.3.1.js"></script>
<script src="<%=basePath%>backstage/js/nginx.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>自定义Marker图标</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <style>
        body,
        html,
        #container {
            overflow: hidden;
            width: 100%;
            height: 100%;
            margin: 0;
            font-family: "微软雅黑";
        }
         ul li {
        list-style: none;
    }
    .btn-wrap {
        z-index: 999;
        position: fixed;
        bottom: 3.5rem;
        margin-left: 3rem;
        padding: 1rem 1rem;
        border-radius: .25rem;
        background-color: #fff;
        box-shadow: 0 2px 6px 0 rgba(27, 142, 236, 0.5);
    }
    .btn {
        width: 120px;
        height: 30px;
        float: left;
        background-color: #fff;
        color: rgba(27, 142, 236, 1);
        font-size: 14px;
        border:1px solid rgba(27, 142, 236, 1);
        border-radius: 5px;
        margin: 0 5px;
        text-align: center;
        line-height: 30px;
    }
    .btn:hover {
        background-color: rgba(27, 142, 236, 0.8);
        color: #fff;
    }
        </style>
        <script src="//api.map.baidu.com/api?type=webgl&v=1.0&ak=sx9CXfjnE6SmM7CWxfZ5yLcEGT9umYGT"></script>
    </head>
<body>
	<form action="<%=basePath%>modeServlet?oper=update_nmsl" method="post">
 		<ul class="btn-wrap" style="z-index: 99;">
        	<button  type="submit" class = "btn">刷新车辆信息</button>
   	 	</ul>
    </form>
    <div id="container"></div>
   
</body>
</html>
<script type="text/javascript">

var map = new BMapGL.Map('container'); // 创建Map实例
map.centerAndZoom(new BMapGL.Point(112.59, 28.12), 7); // 初始化地图,设置中心点坐标和地图级别
map.enableScrollWheelZoom(true); // 开启鼠标滚轮缩放
 
var p1 = new BMapGL.Point(113.00000, 28.21667);
var p2 = new BMapGL.Point(116.41667,39.91667);

var driving = new BMapGL.DrivingRoute(map, {renderOptions:{map: map, autoViewport: true}});
driving.search(p1, p2);

var marker1 = new BMapGL.Marker(new BMapGL.Point(113.09564, 30.37214));
var marker2 = new BMapGL.Marker(new BMapGL.Point(114.50456,34.84645));
var marker3 = new BMapGL.Marker(new BMapGL.Point(115.64358,38.10680));

// 在地图上添加点标记
map.addOverlay(marker1);
map.addOverlay(marker2);
map.addOverlay(marker3);

// 创建小车图标
var myIcon = new BMapGL.Icon("<%=basePath%>backstage/jsp/department/userGroup/car.png", new BMapGL.Size(52, 26));
// 创建Marker标注，使用小车图标
var pt = new BMapGL.Point("${nmsl.longitude}", "${nmsl.latitude}");
var marker = new BMapGL.Marker(pt, {
    icon: myIcon
});

// 将标注添加到地图
map.addOverlay(marker);
var opts = {
	    width: 200,
	    height: 100,
	    title: '车辆位置'
	};

var infoWindow = new BMapGL.InfoWindow("${nmsl.reveal}", opts);
//点标记添加点击事件
marker.addEventListener('click', function () {
 map.openInfoWindow(infoWindow, pt); // 开启信息窗口
});

</script>
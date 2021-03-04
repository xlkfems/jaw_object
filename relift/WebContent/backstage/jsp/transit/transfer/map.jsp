<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>中转站</title>
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
    </style>
    <script src="//api.map.baidu.com/api?type=webgl&v=1.0&ak=sx9CXfjnE6SmM7CWxfZ5yLcEGT9umYGT"></script>
</head>
	<body>
	    <div id="container"></div>
	</body>
	</html>
	
	<script type="text/javascript">
		var map = new BMapGL.Map('container');
		map.centerAndZoom(new BMapGL.Point(113.00000, 28.21667), 7);
		map.enableScrollWheelZoom(true); // 开启鼠标滚轮缩放
		
		<c:forEach items="${traList}" var="bks">	
				// 创建点标记
				var longitude="${bks.tr_longitude}";
				var longitude = longitude.split(",");
				
				var point = new BMapGL.Point(longitude[0],longitude[1]);
				var marker = new BMapGL.Marker(point);
				map.addOverlay(marker);
				
				var opts = {
					    width: 200,
					    height: 100,
					    title: '中转站'
					};
					var infoWindow = new BMapGL.InfoWindow("${bks.tr_address}", opts);
					// 点标记添加点击事件
					marker.addEventListener('click', function () {
					    map.openInfoWindow(infoWindow, point); // 开启信息窗口
				});
		</c:forEach>
		
	</script>
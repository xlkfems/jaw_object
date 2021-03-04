<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>地图单击拾取经纬度</title>
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
<script>
var map = new BMapGL.Map('container');
map.centerAndZoom(new BMapGL.Point(113.404, 28.928), 6);
map.enableScrollWheelZoom(true);
map.addEventListener('click', function (e) {
    alert('点击位置经纬度：' + e.latlng.lng + ',' + e.latlng.lat);
});
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="//api.map.baidu.com/api?type=webgl&v=1.0&ak=sx9CXfjnE6SmM7CWxfZ5yLcEGT9umYGT"></script>
    <title>根据城市名称定位</title>
    <style>
        html, body, #allmap{
            width: 100%;
            height: 100%;
            padding: 0;
            margin: 0;
            overflow: hidden;
        }
        #result{
            padding: 7px 15px;
            position: fixed;
            top: 10px;
            left: 20px;
            width: 550px;
            background: #fff;
            box-shadow: 0 2px 6px 0 rgba(27, 142, 236, 0.5);
            border-radius: 7px;
            z-index: 99;
        }
        #cityName2{
            width:170px; 
            margin-right:10px;
            height:25px;
            border: 1px solid rgba(27, 142, 236, 0.5);
            border-radius: 5px;
        }
       #cityName{
            width:170px; 
            margin-right:10px;
            height:25px;
            border: 1px solid rgba(27, 142, 236, 0.5);
            border-radius: 5px;
        }
        #result button{
            border: 1px solid rgba(27, 142, 236, 0.5);
            border-radius: 5px;
            background: rgba(27, 142, 236, 0.5);
            color: #fff
        }
    </style>
</head>
<body>
    <div id='allmap'></div>
    <div id='result'>
        出发地: <input id="cityName" type="text"/>
        到达地: <input id="cityName2" type="text"/>
		<button onclick="theLocation()"/>查询</button>
    </div>
    <script>
         // 百度地图API功能
        var map = new BMapGL.Map("allmap");
        var point = new BMapGL.Point(116.331398,39.897445);
        map.centerAndZoom(point,7);
		
        map.enableScrollWheelZoom(true);
        
        function theLocation(){
            var city = document.getElementById("cityName").value;
            var city2 = document.getElementById("cityName2").value;
            
            if(city=="长沙市"){
            	var p1= new BMapGL.Point(113.00000,28.21667);
            }else if(city=="郑州市"){
            	var p1= new BMapGL.Point(113.65000,34.76667);
            }else if(city=="北京市"){
            	var p1= new BMapGL.Point(116.41667,39.91667);
            }else if(city=="武汉市"){
            	var p1= new BMapGL.Point(114.31667,30.51667);
            }else if(city=="南昌市"){
            	var p1= new BMapGL.Point(115.90000,28.68333);
            }else if(city=="广州市"){
            	var p1= new BMapGL.Point(113.23333,23.16667);
            }else if(city=="合肥市"){
            	var p1= new BMapGL.Point(117.17000,31.79000);
            }else if(city=="南京市"){
            	var p1= new BMapGL.Point(118.78333,32.05000);
            }else if(city=="福州市"){
            	var p1= new BMapGL.Point(119.30000,26.08333);
            }else if(city=="贵阳市"){
            	var p1= new BMapGL.Point(106.71667,26.56667);
            }else if(city=="石家庄市"){
            	var p1= new BMapGL.Point(114.48333,38.03333);
            }else if(city=="济南市"){
            	var p1= new BMapGL.Point(117.10000,36.70000);
            }else if(city=="海口市"){
            	var p1= new BMapGL.Point(110.35000,20.01667);
            }else if(city=="昆明市"){
            	var p1= new BMapGL.Point(102.73333,25.05000);
            }else if(city=="呼和浩特市"){
            	var p1= new BMapGL.Point(111.69000,40.88000);
            }else if(city=="兰州市"){
            	var p1= new BMapGL.Point(103.73333,36.03333);
            }else if(city=="长春市"){
            	var p1= new BMapGL.Point(125.35000,43.88333);
            }else if(city=="哈尔滨市"){
            	var p1= new BMapGL.Point(126.63333,45.75000);
            }else{
            	alert("未查到该地址,请期待后续更新");
            }
            
            if(city2=="长沙市"){
            	var p2= new BMapGL.Point(113.00000,28.21667);
            }else if(city2=="郑州市"){
            	var p2= new BMapGL.Point(113.65000,34.76667);
            }else if(city2=="北京市"){
            	var p2= new BMapGL.Point(116.41667,39.91667);
            }else if(city2=="武汉市"){
            	var p2= new BMapGL.Point(114.31667,30.51667);
            }else if(city2=="南昌市"){
            	var p2= new BMapGL.Point(115.90000,28.68333);
            }else if(city2=="广州市"){
            	var p2= new BMapGL.Point(113.23333,23.16667);
            }else if(city2=="合肥市"){
            	var p2= new BMapGL.Point(117.17000,31.79000);
            }else if(city2=="南京市"){
            	var p2= new BMapGL.Point(118.78333,32.05000);
            }else if(city2=="福州市"){
            	var p2= new BMapGL.Point(119.30000,26.08333);
            }else if(city2=="贵阳市"){
            	var p2= new BMapGL.Point(106.71667,26.56667);
            }else if(city2=="石家庄市"){
            	var p2= new BMapGL.Point(114.48333,38.03333);
            }else if(city2=="济南市"){
            	var p2= new BMapGL.Point(117.10000,36.70000);
            }else if(city2=="海口市"){
            	var p2= new BMapGL.Point(110.35000,20.01667);
            }else if(city2=="昆明市"){
            	var p2= new BMapGL.Point(102.73333,25.05000);
            }else if(city2=="呼和浩特市"){
            	var p2= new BMapGL.Point(111.69000,40.88000);
            }else if(city2=="兰州市"){
            	var p2= new BMapGL.Point(103.73333,36.03333);
            }else if(city2=="长春市"){
            	var p2= new BMapGL.Point(125.35000,43.88333);
            }else if(city2=="哈尔滨市"){
            	var p2= new BMapGL.Point(126.63333,45.75000);
            }else{
            	alert("未查到该地址,请期待后续更新");
            }
            var driving = new BMapGL.DrivingRoute(map, {renderOptions:{map: map, autoViewport: true}});
            driving.search(p1, p2);
            
        }
    </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8"/>
	<title>天气预报查询接口</title>
</head>
<body>
<h2>天气预报接口使用说明</h2>
<p>本接口是外部天气接口的一个代理实现，提供缓存功能，支持JSONP形式调用，编码均为UTF-8</p>
<p>返回的数据格式皆为json，字段请参考<a href="https://www.sojson.com/blog/305.html" target="_blank">https://www.sojson.com/blog/305.html</a></p>
<p><a href="city.html" target="_blank">城市名称及代码对应表</a></p>

<h2>使用城市代码查询</h2>
<p>http://localhost:8080/weather/api/weather?cityCode=101300101</p>

<h2>使用城市名称查询</h2>
<p>http://localhost:8080/weather/api/weather?cityName=南宁</p>

<h2>使用JSONP形式调用，增加参数jsoncallback</h2>
<p>http://localhost:8080/weather/api/weather?cityCode=101300101&jsoncallback=foo</p>
<p>http://localhost:8080/weather/api/weather?cityName=南宁&jsoncallback=foo</p>
</body>
</html>

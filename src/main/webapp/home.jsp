<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8"/>
	<title>天气预报查询接口</title>
</head>
<body>
<h2>使用城市代码查询</h2>
<p>http://localhost:8080/weather/api/weather?cityCode=101300101</p>

<h2>使用城市名称查询</h2>
<p>http://localhost:8080/weather/api/weather?cityName=南宁</p>

<p>返回格式皆为json，具体格式请参考<a href="https://www.sojson.com/blog/305.html" target="_blank">https://www.sojson.com/blog/305.html</a></p>
<p><a href="city.html" target="_blank">城市名称及代码对应表</a></p>
</body>
</html>

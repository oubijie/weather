# weather

#### 项目描述
天气预报API，用于给学生练习Ajax，JSON和JSONP

天气数据来源于[sojson.com的开放接口](https://www.sojson.com/blog/305.html)，但由于有访问限制，两次访问必须间隔3秒，而且该开放接口不提供jsonp的调用方式，故写下此项目，一来做数据的缓存，可以并发访问，二来增加jsonp的调用方式。

#### 相关知识点
Servlet&JSP

Ajax

JSON

JSONP

#### 安装

1. Eclipse项目，无需数据库，导入Eclipse后部署到tomcat运行

#### 使用说明

1. 本接口是外部天气接口的一个代理实现，提供缓存功能，支持JSONP形式调用，编码均为UTF-8

2. 返回的数据格式皆为json，字段请参考[sojson.com的天气接口说明](https://www.sojson.com/blog/305.html)

3. 查询天气支持使用城市名称或城市代码，形式如：

   ```url
   http://localhost:8080/weather/api/weather?cityCode=101300101
   ```

   ```url
   http://localhost:8080/weather/api/weather?cityName=南宁
   ```

   城市名称及代码需要填写正确才能返回数据，在city.html中有城市名称及代码对应表，或者参考sojson.com上的接口说明。

   如果想使用JSONP形式调用，在调用接口时增加参数jsoncallback

   ```
   http://localhost:8080/weather/api/weather?cityCode=101300101&jsoncallback=foo
   ```

   ```
   http://localhost:8080/weather/api/weather?cityName=南宁&jsoncallback=foo
   ```

   


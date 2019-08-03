# weather

#### 项目描述
天气预报API，用于给学生练习Ajax，JSON和JSONP

天气数据来源于[sojson.com的开放接口](https://www.sojson.com/blog/305.html)，但由于有访问限制，两次访问必须间隔3秒，而且该开放接口不提供jsonp的调用方式，故写下此项目，一来做数据的缓存，可以并发访问，二来增加jsonp的调用方式。

项目首发于[gitee](https://gitee.com/oubijie/weather)，github只用于同步备份

#### 相关知识点
Servlet&JSP

Ajax

JSON

JSONP

#### 安装

1. Eclipse项目，无需数据库，导入Eclipse后部署到tomcat运行

#### 使用说明

1. 本接口是外部天气接口的一个代理实现，提供缓存功能，支持JSONP形式调用，编码均为UTF-8

2. 返回的数据格式皆为json，字段请参考[sojson.com的天气接口说明](https://www.sojson.com/blog/305.html)，或参考文档最后的字段说明

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

#### 接口成功返回值
```json
{
    "time": "2018-09-22 12:37:21",//系统更新时间
    "cityInfo": {
        "city": "天津市",  //请求城市
        "cityId": "101030100",//请求ID
        "parent": "天津",     //上级，一般是省份
        "updateTime": "12:32"//天气更新时间
    },
    "date": "20180922",     //当前天气的当天日期
    "message": "Success !", //返回message
    "status": 200,          //返回状态
    "data": {
        "shidu": "22%",     //湿度
        "pm25": 15.0,       //pm2.5
        "pm10": 46.0,       //pm10
        "quality": "优",    //空气质量
        "wendu": "24",      //温度
        "ganmao": "各类人群可自由活动",//感冒提醒（指数）
        "forecast": [//今天+未来14天
            {
                "date": "22",
                "ymd": "2018-09-22",   //年月日  （新增）
                "week": "星期六",       //星期 （新增）
                "sunrise": "05:57",
                "high": "高温 26.0℃",
                "low": "低温 15.0℃",
                "sunset": "18:10",
                "aqi": 55.0,
                "fx": "西北风",
                "fl": "4-5级",
                "type": "晴",
                "notice": "愿你拥有比阳光明媚的心情"
            },
            {
                "date": "23",
                "ymd": "2018-09-22",   //年月日  （新增）
                "week": "星期日",       //星期 （新增）
                "sunrise": "05:58",
                "high": "高温 23.0℃",
                "low": "低温 14.0℃",
                "sunset": "18:09",
                "aqi": 29.0,
                "fx": "西北风",
                "fl": "4-5级",
                "type": "晴",
                "notice": "愿你拥有比阳光明媚的心情"
            },
            {
                "date": "24",
                "ymd": "2018-09-22",   //年月日  （新增）
                "week": "星期一",       //星期 （新增）
                "sunrise": "05:59",
                "high": "高温 24.0℃",
                "low": "低温 15.0℃",
                "sunset": "18:07",
                "aqi": 25.0,
                "fx": "西北风",
                "fl": "<3级",
                "type": "晴",
                "notice": "愿你拥有比阳光明媚的心情"
            },
            {
                "date": "25",
                "ymd": "2018-09-22",   //年月日  （新增）
                "week": "星期二",       //星期 （新增）
                "sunrise": "06:00",
                "high": "高温 24.0℃",
                "low": "低温 16.0℃",
                "sunset": "18:05",
                "aqi": 56.0,
                "fx": "西南风",
                "fl": "<3级",
                "type": "晴",
                "notice": "愿你拥有比阳光明媚的心情"
            },
            {
                "date": "26",  
                "ymd": "2018-09-22",   //年月日  （新增）
                "week": "星期三",       //星期 （新增）
                "sunrise": "06:01",
                "high": "高温 24.0℃",
                "low": "低温 17.0℃",
                "sunset": "18:04",
                "aqi": 86.0,
                "fx": "西南风",
                "fl": "3-4级",
                "type": "阴",
                "notice": "不要被阴云遮挡住好心情"
            }
        ]
    }
}
```


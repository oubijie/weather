package com.veryoo.weather.service.impl;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;
import com.veryoo.weather.service.WeatherService;

public class WeatherServiceImpl implements WeatherService {

	public static Map<String, Map> data = new HashMap();

	@Override
	public Map getWeatherDataByCityCode(String cityCode) {
		Map map = getWeatherDataFromCache(cityCode);
		if(map == null) {
			map = getWeatherDataFromApi(cityCode);
		}
		return map;
	}

	@Override
	public Map getWeatherDataByCityName(String cityName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private Map getWeatherDataFromCache(String cityCode) {
		System.out.println("尝试通过缓存获取天气信息");
		Map map = data.get(cityCode);
		if(map != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String today = sdf.format(new Date());
			if(!today.equals(map.get("date"))) {
				map = null;  //缓存的天气数据如果不是当天的，返回null
				System.out.println("通过缓存获取天气信息失败！");
			}else {
				System.out.println("通过缓存获取天气信息成功！");
			}
		}else {
			System.out.println("通过缓存获取天气信息失败！");
		}
		
		return map;
	}
	
	private Map getWeatherDataFromApi(String cityCode) {
		Map map = null;
		try {
			System.out.println("开始通过API获取天气数据");
			URL url = new URL("http://t.weather.sojson.com/api/weather/city/"+cityCode);
			URLConnection open = url.openConnection();
			InputStream input = open.getInputStream();
			String result = IOUtils.toString(input,"utf-8");
			System.out.println(result);
			map = JSON.parseObject(result);
		} catch (Exception e) {
			System.err.println("通过API获取天气数据发生错误！");
			map = new HashMap();
			map.put("status", 500);
			map.put("message", "Error!");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			map.put("date", sdf.format(new Date()));
		}
		
		data.put(cityCode, map);  //获取的数据放到缓存
		
		return map;
	}
	
	
}

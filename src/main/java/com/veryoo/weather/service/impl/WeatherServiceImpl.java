package com.veryoo.weather.service.impl;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;
import com.veryoo.weather.service.WeatherService;
import com.veryoo.weather.utils.CityDataUtil;

public class WeatherServiceImpl implements WeatherService {

	//本地缓存的天气数据
	public static Map<String, Map> cacheData = new HashMap();

	/**
	 * 通过城市代码查询天气
	 * 先在本地缓存中查询，如果缓存没有再去外部接口查询
	 */
	@Override
	public Map getWeatherDataByCityCode(String cityCode) {
		Map map = getWeatherDataFromCache(cityCode);
		if(map == null) {
			map = getWeatherDataFromApi(cityCode);
		}
		return map;
	}

	
	/**
	 * 通过城市名称查询天气
	 * 先把城市名称转换成城市代码，再通过城市代码查询天气
	 * 城市名称和城市代码对应关系存放在city.json文件中
	 */
	@Override
	public Map getWeatherDataByCityName(String cityName) {
		Map map = null;
		String cityCode = CityDataUtil.getCityCodeByName(cityName);
		if(cityCode == null) {
			System.err.println("未找到该城市名称！");
			map = new HashMap();
			map.put("status", 500);
			map.put("message", "未找到该城市名称！");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			map.put("date", sdf.format(new Date()));
		}else{
			map = getWeatherDataByCityCode(cityCode);
		}
		return map;
	}
	
	
	/**
	 * 在本地缓存中查询城市天气
	 * @param cityCode
	 * @return
	 */
	private Map getWeatherDataFromCache(String cityCode) {
		System.out.println("尝试通过缓存获取天气信息");
		Map map = cacheData.get(cityCode);
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
	
	
	/**
	 * 使用sojson.com的开放天气api查询城市天气
	 * @param cityCode
	 * @return
	 */
	private Map getWeatherDataFromApi(String cityCode) {
		Map map = null;
		try {
			System.out.println("开始通过API获取天气数据");
			URL url = new URL("http://t.weather.sojson.com/api/weather/city/"+cityCode);
			String result = IOUtils.toString(url,"utf-8");
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
		
		cacheData.put(cityCode, map);  //获取的数据放到缓存
		
		return map;
	}
	
	
}

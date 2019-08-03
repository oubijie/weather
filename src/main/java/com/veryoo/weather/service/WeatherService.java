package com.veryoo.weather.service;

import java.util.Map;

public interface WeatherService {

	/**
	 * 通过城市代码查询天气
	 * @param cityCode
	 * @return
	 */
	Map getWeatherDataByCityCode(String cityCode);
	
	
	/**
	 * 通过城市名称查询天气
	 * @param cityName
	 * @return
	 */
	Map getWeatherDataByCityName(String cityName);
}

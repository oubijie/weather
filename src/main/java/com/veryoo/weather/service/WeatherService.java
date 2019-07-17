package com.veryoo.weather.service;

import java.util.Map;

public interface WeatherService {

	Map getWeatherDataByCityCode(String cityCode);
	
	Map getWeatherDataByCityName(String cityName);
}

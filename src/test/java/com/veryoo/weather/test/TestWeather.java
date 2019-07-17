package com.veryoo.weather.test;

import java.util.Map;

import com.veryoo.weather.service.WeatherService;
import com.veryoo.weather.service.impl.WeatherServiceImpl;

public class TestWeather {

	public static void main(String[] args) {
		WeatherService w = new WeatherServiceImpl();
		
		Map map = w.getWeatherDataByCityCode("1013001011");
		System.out.println(map);
		
//		Map map2 = w.getWeatherDataByCityCode("101300101");
//		System.out.println(map2);
	}
}

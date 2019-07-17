package com.veryoo.weather.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class CityMap {

	private static Map<String, String> city;
	
	static {
		try {
			city = new HashMap<String, String>();
			InputStream fis = Thread.currentThread().getContextClassLoader().getResourceAsStream("city.json");
			String cityStr = IOUtils.toString(fis, "utf-8");
			JSONArray array = JSON.parseArray(cityStr);
			for(int i=0; i<array.size(); i++) {
				JSONObject obj = array.getJSONObject(i);
				String cityCode = (String)obj.get("city_code");
				if(cityCode != null && !cityCode.trim().equals("")) {
					city.put((String)obj.get("city_name"),cityCode);
				}
			}
			System.out.println("初始化city数据完成，共有数据：" + city.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getCityCodeByName(String cityName) {
		return city.get(cityName);
	}
}

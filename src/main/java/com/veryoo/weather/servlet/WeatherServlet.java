package com.veryoo.weather.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.veryoo.weather.service.WeatherService;
import com.veryoo.weather.service.impl.WeatherServiceImpl;


@WebServlet(value={"/api/weather"})
public class WeatherServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/Json");
		
		WeatherService w = new WeatherServiceImpl();
		
		Map map = null;
		
		String cityCode = req.getParameter("cityCode");
		if(cityCode != null && !cityCode.trim().equals("")) {
			map = w.getWeatherDataByCityCode(cityCode);
		}else {
			String cityName = req.getParameter("cityName");
			if(cityName != null && !cityName.trim().equals("")) {
				map = w.getWeatherDataByCityName(cityName);
			}
		}
		
		//JSONP改造，如果带jsoncallback参数，则以jsonp形式返回数据
		String callback = req.getParameter("jsoncallback");
		if(callback!=null && !callback.trim().equals("")) {
			resp.getWriter().write(callback+"(");
			resp.getWriter().write(JSON.toJSONString(map));
			resp.getWriter().write(");");
		}else {
			resp.getWriter().write(JSON.toJSONString(map));
		}
		resp.getWriter().flush();
	}
	
	

}

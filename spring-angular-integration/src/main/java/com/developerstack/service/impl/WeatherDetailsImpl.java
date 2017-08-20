package com.developerstack.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.developerstack.model.WeatherDeatils;
import com.developerstack.service.WeatherDetailsService;

import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;

@Service
public class WeatherDetailsImpl implements WeatherDetailsService{

	@Override
	public WeatherDeatils getWeatherDeatils(String cityName) {
		WeatherDeatils weatherDeatils=new WeatherDeatils();
		
		 boolean isMetric = true;
		    String owmApiKey = "d961dabbe1a2ab41fbc58710dfc4a356"; /* YOUR OWM API KEY HERE */
		    
		    OpenWeatherMap.Units units = (isMetric)
		        ? OpenWeatherMap.Units.METRIC
		        : OpenWeatherMap.Units.IMPERIAL;
		    OpenWeatherMap owm = new OpenWeatherMap(units, owmApiKey);
		    try {
		    	CurrentWeather currentWeather=owm.currentWeatherByCityName(cityName);
		    	weatherDeatils.setCity(currentWeather.getCityName());
		    	DateFormat formatterIST = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss a");
		    	formatterIST.setTimeZone(TimeZone.getTimeZone("GMT+10")); // better than using IST
		    	weatherDeatils.setUpdatedTime(formatterIST.format(new Date()));
		    	weatherDeatils.setWeather(currentWeather.getWeatherInstance(0).getWeatherName());
		    	weatherDeatils.setWind(new Long(Math.round(currentWeather.getWindInstance().getWindSpeed()*3.6)).toString());
		    	weatherDeatils.setTemperature(new Float(currentWeather.getMainInstance().getTemperature()).toString());
		    	
		    }
		     catch (Exception e) {
				e.printStackTrace();
			}
		
		return weatherDeatils;
	}

}

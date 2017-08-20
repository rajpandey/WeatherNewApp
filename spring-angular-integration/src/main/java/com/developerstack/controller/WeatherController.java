package com.developerstack.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.developerstack.model.WeatherDeatils;
import com.developerstack.service.WeatherDetailsService;

@Controller
public class WeatherController {
	
	@Autowired
	private WeatherDetailsService weatherDetailsService;
	
	@RequestMapping(value = "/getWeatherDetails", method = RequestMethod.POST)
	public ResponseEntity<WeatherDeatils> getWeatherDetails(@RequestBody String cityName, HttpServletRequest request) {
		WeatherDeatils weatherDetails=  weatherDetailsService.getWeatherDeatils(cityName);
		return new ResponseEntity<WeatherDeatils>(weatherDetails, HttpStatus.OK);
		
	}
}

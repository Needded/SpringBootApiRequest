package com.example.weather.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Record that receives the data from the API request.
 * 
 * @param String The city name.
 * @param MainData The record that receives the weather condition.
 * @param WeatherTypeData The array that receives the temperature.
 */
//@JsonIgnoreProperties Ignore the other elements from the JSON response. Wanted: "temp" and "main".
@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherData(String name, MainData main, WeatherTypeData [] weather) {
	
	public record MainData( @JsonProperty("temp")double temp) {}
	
	public record WeatherTypeData( @JsonProperty("main")String main) {}

}

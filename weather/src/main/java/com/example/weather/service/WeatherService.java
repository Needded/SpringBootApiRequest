package com.example.weather.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *Service class for making API requests to retrieve weather data.
 */

@Service
public class WeatherService {

	 private RestTemplate restTemplate;
	 private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);
	 
	    /**
	     * Constructs a new WeatherService with the specified RestTemplate.
	     *
	     * @param restTemplate The RestTemplate to use for making API requests.
	     */
	    @Autowired
	    public WeatherService(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }

	    /**
	     * Retrieves weather data for a specified city and API key.
	     *
	     * @param url The base URL of the weather API.
	     * @param api The API key for accessing the weather API.
	     * @return WeatherData object containing weather information.
	     */
	    public WeatherData getWeather(String url,String api)  {
	        
	    	//Make up the request URL with URL, city and temperature metric.
			String city="london";
			String celcius="&units=metric";
	        String makeUrl = url + "?q=" + city +"&appid=" + api + celcius;
	    	
	    	//Make the request to the API  and store on the WeatherData record.
	        WeatherData weatherData=null;
	        try {
	        	weatherData = restTemplate.getForObject(makeUrl, WeatherData.class);
	        }catch(RestClientException restClientException) {
	        	logger.error("Error when obtaining weather data", restClientException);
	        	System.out.println("Error when obtaining weather data"+ restClientException);
	        } 
	       
	        return weatherData;
	    }
}

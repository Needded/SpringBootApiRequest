package com.example.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Controller class that manage the HTTPS request.
 */

@Controller
@RequestMapping
public class WeatherController {
	
	//Insert own APIKEY here.
	private final String APIKEY="";
	//OpenWeatherMap URL API to get current weather information.
	private final String URL="https://api.openweathermap.org/data/2.5/weather";
	private WeatherService weatherService;
	
	/*
	 * Constructs a new WeatherController with the specified WeatherService.
	 * 
	 * @param weatherService The WeatherService class to deal with the business logic.
	 */
	@Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
	
	/**
	 * Handles HTTP GET requests to fetch weather data and populate the model with relevant information.
	 *
	 * @param model The model object used to pass data to the HTML template.
	 * @return The name of the HTML template ("WeatherPage") to render.
	 */
	@GetMapping
	public String getWeather(Model model) {
		
		//Call the service layer the WeatherService.	
		WeatherData weatherData = weatherService.getWeather(URL, APIKEY);
		
		//Uses the Model class to transmit the relevant information to HTML template.
        model.addAttribute("city", weatherData.name());
        model.addAttribute("weather",weatherData.weather()[0].main());
        model.addAttribute("temperature", weatherData.main().temp());

	    // Return the name of the HTML template to render.
	    return "WeatherPage";
		
	}

}

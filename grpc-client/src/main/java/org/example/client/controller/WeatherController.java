package org.example.client.controller;

import org.example.client.model.Weather;
import org.example.client.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/weather/loc/{city}")
    public ResponseEntity<Weather> fetchWeatherByLocation(@PathVariable("city") String city){
        return ResponseEntity.ok(weatherService.fetchWeatherByLocation(city));
    }
}

package org.example.client.service;

import org.example.client.model.Weather;
import org.example.client.util.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    private WeatherClient weatherClient;


    public Weather fetchWeatherByLocation(String city) {
        return weatherClient.fetchWeather(city);
    }
}

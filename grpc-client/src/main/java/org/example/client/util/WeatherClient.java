package org.example.client.util;

import com.example.grpc.WeatherRequest;
import com.example.grpc.WeatherResponse;
import com.example.grpc.WeatherServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.example.client.model.Weather;
import org.springframework.stereotype.Component;

// WeatherClient.java
@Component
public class WeatherClient {

    @GrpcClient("weather-service")
    private WeatherServiceGrpc.WeatherServiceBlockingStub stub;

    public Weather fetchWeather(String location) {
        WeatherRequest request = WeatherRequest.newBuilder()
                .setLocation(location)
                .build();

        WeatherResponse response = stub.getWeather(request);
        System.out.println("Temperature: " + response.getTemperature());
        System.out.println("Conditions: " + response.getConditions());
        return new Weather(response.getTemperature(),response.getConditions());
    }
}

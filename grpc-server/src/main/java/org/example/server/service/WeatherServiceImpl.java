package org.example.server.service;

import com.example.grpc.WeatherRequest;
import com.example.grpc.WeatherResponse;
import com.example.grpc.WeatherServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

// WeatherServiceImpl.java
@Service
@GrpcService
public class WeatherServiceImpl extends WeatherServiceGrpc.WeatherServiceImplBase {
    @Override
    public void getWeather(WeatherRequest request, StreamObserver<WeatherResponse> responseObserver) {
        String location = request.getLocation();
        String temperature = fetchTemperature(location);
        String conditions = fetchConditions(location);

        WeatherResponse response = WeatherResponse.newBuilder()
                .setTemperature(temperature)
                .setConditions(conditions)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private String fetchTemperature(String location) {
        // Simulated method to fetch temperature based on location
        return "25°C"; // Example response
    }

    private String fetchConditions(String location) {
        // Simulated method to fetch weather conditions based on location
        return "Clear skies"; // Example response
    }
}

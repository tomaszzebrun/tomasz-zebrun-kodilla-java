package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculatAverageTemperature() {
        // for empty temperatures
        if (temperatures.getTemperatures().size() == 0) {
            return -300.0;
        }
        double result = 0.0; 
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            result += temperature.getValue();
        }
        return result/temperatures.getTemperatures().size();
    }

    public double calculatMedianTemperatures() {
        int temperaturesSize = temperatures.getTemperatures().size();
        // for empty temperatures
        if (temperaturesSize == 0) {
            return -300.0;
        }
        Double[] values = temperatures.getTemperatures().values().toArray(new Double[0]);
        Arrays.sort(values);
        if (temperaturesSize % 2 == 0) {
            return (values[temperaturesSize/2 - 1] + values[temperaturesSize/2])/2;
        } else {
            return values[temperaturesSize/2];
        }
    }
}

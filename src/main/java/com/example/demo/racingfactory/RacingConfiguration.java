package com.example.demo.racingfactory;

import com.example.demo.racingfactory.constants.RacingTypes;
import com.example.demo.racingfactory.services.BikeTypeService;
import com.example.demo.racingfactory.services.CarTypeService;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RacingConfiguration {
    private CarTypeService carTypeService;
    private BikeTypeService bikeTypeService;

    public static final Map<String, ServiceFactory> serviceFactoryMap = new HashMap<>();

    @PostConstruct
    private Map<String, ServiceFactory> getObject() {
        serviceFactoryMap.put(RacingTypes.CAR, carTypeService);
        serviceFactoryMap.put(RacingTypes.BIKE, bikeTypeService);

        return serviceFactoryMap;
    }
}

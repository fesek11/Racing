package com.example.demo.racingfactory;

import com.example.demo.participant.Participant;
import com.example.demo.racingfactory.constants.RacingTypes;
import com.example.demo.racingfactory.impl.BikeRacing;
import com.example.demo.racingfactory.impl.CarRacing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RacingFactoryImplementationService {
    private static final Map<RacingTypes, RacingI> handler = new HashMap<>();
    @Autowired
    private BikeRacing bikeRacing;
    @Autowired
    private CarRacing carRacing;

    public static RacingI createInstance(String racing) throws Exception {
        return Optional.ofNullable(handler.get(racing)).orElseThrow(() -> new IllegalArgumentException("Invalid racing"));
    }

    @PostConstruct
    private Map<RacingTypes, RacingI> getObject() {
        handler.put(RacingTypes.BikeRacing, bikeRacing);
        handler.put(RacingTypes.CarRacing, carRacing);
        return handler;
    }

}

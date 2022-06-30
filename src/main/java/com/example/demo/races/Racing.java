package com.example.demo.races;

import com.example.demo.participant.Participant;

import java.util.List;

public interface Racing {
    void typeOfRacing(RacingType racingType);

    List<Participant> score();
}

package com.example.demo.racingfactory;

import com.example.demo.participant.Participant;

import java.util.Map;

public interface RacingI {
    void takeAPart(Participant participant);

    Map<Long, Participant> getScore();
}

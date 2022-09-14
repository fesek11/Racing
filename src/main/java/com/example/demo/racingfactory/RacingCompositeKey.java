package com.example.demo.racingfactory;

import lombok.AllArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
class RacingCompositeKey implements Serializable {

    @Column(name = "participant_id")
    Long studentId;

    @Column(name = "bikeRacing_id")
    Long courseId;

    // standard constructors, getters, and setters
    // hashcode and equals implementation
}
package com.example.demo.racingdb;

import javax.persistence.*;

@Entity
public class Racing {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    // todo: Finish db entity (
    //  1 - do descending sort to define the winner by time
    //  2 - return map<long, Participant(id)> in the final version
    //  )
}

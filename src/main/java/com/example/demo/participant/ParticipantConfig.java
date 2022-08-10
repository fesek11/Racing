package com.example.demo.participant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//@Configuration
public class ParticipantConfig {

    @Bean
    CommandLineRunner commandLineRunner(ParticipantRepository participantRepository) {
        return args -> {

//            participantRepository.saveAll(List.of(
//                    new Participant("Den","Denys","Fesenko", "dens@gmail.com", "26qds"),
//                    new Participant("Fey","Djordj","Oruel", "djordj@gmail.com", "26qds"),
//                    new Participant("Afh","Ali","Kibod", "kibodali@gmail.com", "26qds")
        };
    }

}

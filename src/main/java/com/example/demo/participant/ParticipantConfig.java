package com.example.demo.participant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ParticipantConfig {

    @Bean
    CommandLineRunner commandLineRunner(ParticipantRepository participantRepository) {
        return args -> {

            participantRepository.saveAll(List.of(
                    new Participant("Denis", "den@gmail.com", 26),
                    new Participant("Ila", "ila@gmail.com", 19),
                    new Participant("Gomer", "goome@gmail.com", 51)));
        };
    }

}

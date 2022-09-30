package com.example.demo.racingfactory;

import com.example.demo.participant.Participant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/racing")
@Slf4j
public class RacingController {
    private RacingRepository racingRepository;
    private RacingConfiguration racingConfiguration;

//    @GetMapping("/{racing-type}")
//    public List<Participant> getParticipantsList(@PathVariable("racing-type") String racing) throws Exception {
//        log.info(String.valueOf(RacingConfiguration.serviceFactoryMap.size()));
//        log.info(String.valueOf(RacingConfiguration.serviceFactoryMap.values()));
//        return racingRepository.findAll();
//    }

    @PostMapping("/{racing-type}/{id-participant}")
    public void addParticipantToRacingList(@PathVariable("racing-type") String racing, @PathVariable("id-participant") Long id) throws Exception {
        RacingConfiguration.serviceFactoryMap.get(racing).addParticipant(id);
    }

}

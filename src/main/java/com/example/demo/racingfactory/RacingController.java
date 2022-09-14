package com.example.demo.racingfactory;

import com.example.demo.participant.Participant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/racing")
public class RacingController {
    private RacingRepository racingRepository;

    @GetMapping("/{racing-type}")
    public List<Participant> getParticipantsList(@PathVariable("racing-type") String racing) throws Exception {
        return RacingConfiguration.serviceFactoryMap.get(racing).getParticipants();
    }

    @PostMapping("/{racing-type}/{id-participant}")
    public void addParticipantToRacingList(@PathVariable("racing-type") String racing, @PathVariable("id-participant") Long id) throws Exception {
        RacingConfiguration.serviceFactoryMap.get(racing).addParticipant(id);
    }

}

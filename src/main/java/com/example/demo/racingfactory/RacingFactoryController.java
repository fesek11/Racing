package com.example.demo.racingfactory;

import com.example.demo.participant.Participant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/racing")
public class RacingFactoryController {


    @GetMapping("/{racing-type}")
    public Map<Long, Participant> getScore(@PathVariable("racing-type") String racing) throws Exception {
        RacingI racingFactory = RacingFactoryImplementationService.createInstance(racing);
        return racingFactory.getScore();
    }

    @PostMapping(path = "{participantId}")
    public void addParticipantToList(@PathVariable Long participantId) {

    }
}

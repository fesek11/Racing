package com.example.demo.registration;

import com.example.demo.participant.Participant;
import com.example.demo.participant.ParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class EmailValidator implements Predicate<String> {
    private final ParticipantRepository participantRepository;

    @Override
    public boolean test(String email) {
        String regex = "^[a-zA-Z\\d_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z\\d.-]+$";
        if (!Pattern.matches(regex, email)) {
            throw new IllegalStateException("Email " + email + " is not valid");
        }
        Optional<Participant> participantByEmail = participantRepository.findParticipantByEmail(email);
        if (participantByEmail.isPresent()) {
            throw new IllegalStateException("Email " + email + " is taken");
        }

        return true;
    }
}

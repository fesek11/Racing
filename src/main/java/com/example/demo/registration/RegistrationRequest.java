package com.example.demo.registration;

import lombok.*;
import org.springframework.web.bind.annotation.PostMapping;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String email;
    private final String password;

}

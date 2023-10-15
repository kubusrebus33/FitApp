package com.example.Jakub.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDto {
    @Email(message = "invalid username address")
    @NonNull
    private String username;

    @NonNull
    @Pattern(regexp= "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$", message = "invalid password!")
    private String password;

}

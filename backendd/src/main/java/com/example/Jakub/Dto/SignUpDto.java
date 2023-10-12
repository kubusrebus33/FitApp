package com.example.Jakub.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDto {

    @NonNull
    private String username;

    @NonNull
    private String password;

}

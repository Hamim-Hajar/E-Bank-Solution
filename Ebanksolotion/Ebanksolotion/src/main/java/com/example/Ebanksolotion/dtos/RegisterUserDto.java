package com.example.Ebanksolotion.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto {
    private String email;

    private String password;

    private String fullName;

}

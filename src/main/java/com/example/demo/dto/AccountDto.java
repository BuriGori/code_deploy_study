package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
public class AccountDto {

    private String name;

    public AccountDto(String name){
        AccountDto.builder().name(name).build();
    }
}

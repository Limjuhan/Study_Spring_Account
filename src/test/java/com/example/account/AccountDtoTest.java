package com.example.account;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AccountDtoTest {
    @Test
    void AccountDataTest() {
//        AccountDto dto = new AccountDto();
//        dto.setAccountNumber("vvton");
//        String accountN = dto.getAccountNumber();
//
//        System.out.println(dto.toString());

        AccountDto accountDto = new AccountDto(
                "accountNum",
                "summer",
                LocalDateTime.now());
        System.out.println(accountDto.toString());
        //given
        //when
        //then
    
    }
}
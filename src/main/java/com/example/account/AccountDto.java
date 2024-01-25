package com.example.account;

import lombok.*;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

//@Data //getter,stter,toString
@Getter
@Setter
@ToString
//@NoArgsConstructor//빈생성자 생성
@AllArgsConstructor//모든속성가진 생성자 생성
@RequiredArgsConstructor//필수값 가진 생성자 생성
@Slf4j//log기능
public class AccountDto {
    private String accountNumber;
    private String nickname;
    private LocalDateTime registeredAt;

    public void log() {
        log.error("error is occurred");
    }

}

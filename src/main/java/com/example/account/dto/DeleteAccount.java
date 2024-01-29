package com.example.account.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class DeleteAccount {
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request {
        @NonNull
        @Min(1)//최소값
        private Long userId;

        @NotBlank
        @Size(min = 10, max = 10)//자리수
        private String accountNumber;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long userId;
        private String accountNumber;
        private LocalDateTime unRegisteredAt;

        public static Response from(AccountDto accountDto) {
            return Response.builder()
                    .userId(accountDto.getUserId())
                    .accountNumber(accountDto.getAccountNumber())
                    .unRegisteredAt(accountDto.getUnRegisterdAt())
                    .build();

        }
    }

}

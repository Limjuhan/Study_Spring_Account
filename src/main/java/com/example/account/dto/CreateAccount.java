package com.example.account.dto;

import lombok.*;

import javax.validation.constraints.Min;
import java.time.LocalDateTime;

public class CreateAccount {
    @Getter
    @Setter
    public static class Request {
        @NonNull
        @Min(1)
        private Long userId;
        @NonNull
        @Min(100)
        private Long initialBalance;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private Long userId;
        private Long initialBalance;
        private LocalDateTime registeredAt;
    }

}

package com.example.account.domain;

import com.example.account.exception.AccountException;
import com.example.account.type.AccountStatus;
import com.example.account.type.ErrorCode;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // 자바 객체가 아닌 테이블
@EntityListeners(AuditingEntityListener.class)//@CreatedDate,@LastModifiedDate사용위한 생성
public class Account {
    @Id //account테이블의 pk로 지정
    @GeneratedValue
    private Long id;

    @ManyToOne
    private AccountUser accountUser;
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    private Long balance;

    private LocalDateTime registredAt;
    private LocalDateTime unRegistredAt;

    @CreatedDate //스프링에서 시간 자동으로 입력
    private LocalDateTime createdAt;
    @LastModifiedDate //스프링에서 시간 자동으로 입력
    private LocalDateTime updatedAt;

    public void useBalance(Long amount) {
        if (amount > balance) {
            throw new AccountException(ErrorCode.AMOUNT_EXCEED_BALANCE);
        }
        balance -= amount;

    }

}

package com.example.account.domain;

import com.example.account.type.AccountStatus;
import com.example.account.type.TransactionResultType;
import com.example.account.type.TransactionType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Transaction {
    @Id //테이블의 pk로 지정
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @Enumerated(EnumType.STRING)
    private TransactionResultType transactionResultType;

    @ManyToOne // 트랜젝션 n개가 특정account하나에 연결
    private Account account;
    private Long amount;
    private Long balanceSnapshot;

    private String transactionId;//거래고유id
    private LocalDateTime transactedAt;

    @CreatedDate //스프링에서 시간 자동으로 입력
    private LocalDateTime createdAt;
    @LastModifiedDate //스프링에서 시간 자동으로 입력
    private LocalDateTime updatedAt;

}

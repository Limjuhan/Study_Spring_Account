package com.example.account.repository;

import com.example.account.domain.Account;
import com.example.account.domain.AccountUser;
import com.example.account.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//account테이블 접근위한 인터페이스 생성
public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {//<엔티티, 프라이머리키>


}

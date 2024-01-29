package com.example.account.repository;

import com.example.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//account테이블 접근위한 인터페이스 생성
public interface AccountRepository extends JpaRepository<Account, Long> {//<엔티티, 프라이머리키>
    Optional<Account> findFirstByOrderByIdDesc();


}

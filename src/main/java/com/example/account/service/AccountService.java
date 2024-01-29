package com.example.account.service;

import com.example.account.domain.Account;
import com.example.account.domain.AccountUser;
import com.example.account.dto.AccountDto;
import com.example.account.exception.AccountException;
import com.example.account.repository.AccountRepository;
import com.example.account.repository.AccountUserRepository;
import com.example.account.type.AccountStatus;
import com.example.account.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static com.example.account.type.AccountStatus.IN_USE;

@Service
@RequiredArgsConstructor//생성자 생성시 반드시 들어가야하는 데이터 를 생성자로 생성.ex:final
public class AccountService {
    private final AccountRepository accountRepository;
    //사용자 조회
    private final AccountUserRepository accountUserRepository;

    /**
     * //사용자가 있는지 조회.
     * //계좌의 번호를 생성하고
     * //계좌를 저장하고, 그 정보를 넘긴다.
     */
    @Transactional
    public AccountDto createAccount(Long userId, Long initialBalance) {
        //userId확인 없을시 예외처리 발생
        AccountUser accountUser = accountUserRepository.findById(userId)
                .orElseThrow(() -> new AccountException(ErrorCode.USER_NOT_FOUND));

        //계좌 생성.
        String newAccountNumber = accountRepository.findFirstByOrderByIdDesc()
                .map(account -> (Integer.parseInt(account.getAccountNumber())) + 1 + "")
                .orElse("1000000000");//계좌없을시 "1000000000"입력

        Account account = accountRepository.save(
                Account.builder()
                        .accountUser(accountUser)
                        .accountStatus(IN_USE)
                        .accountNumber(newAccountNumber)
                        .balance(initialBalance)
                        .registredAt(LocalDateTime.now())
                        .build()
        );


    }

    @Transactional
    public Account getAccount(Long id) {
        return accountRepository.findById(id).get();
    }


}

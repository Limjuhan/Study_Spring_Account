package com.example.account.controller;

import com.example.account.domain.Account;
import com.example.account.dto.CreateAccount;
import com.example.account.service.AccountService;
import com.example.account.service.RedisTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController // 컨트롤러가 bean에 등록되도록 스프링에 알려주는 역할.
@RequiredArgsConstructor
//컨트롤러->서비스->리파지토리. 컨트롤러가 리파지토리로 바로 접근이 아닌 서비스만 참조하는 구조생성.
public class AccountController {
    private final AccountService accountService;
    private final RedisTestService redisTestService;

    @PostMapping("/account")
    public CreateAccount.Response createAccount(
            @RequestBody @Valid CreateAccount.Request request
    ) {
        accountService.createAccount(
                request.getUserId(),
                request.getInitialBalance());

        return "success";
    }
    @GetMapping("/get-lock")
    public String getLock() {
        return redisTestService.getLock();
    }



    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

}

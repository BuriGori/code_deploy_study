package com.example.demo.controller;

import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;

    @GetMapping("/list")
    public List<Account> showList(){
        return accountRepository.findAll();
    }

    @GetMapping("/list/{id}")
    public Account showAccount(@PathVariable Long id){
        return accountRepository.findById(id).orElse(new Account());
    }

    @PostMapping("/add")
    public Account addAccount(@RequestBody AccountDto accountDto){
        Account account = Account.builder().name(accountDto.getName()).build();
        return accountRepository.save(account);
    }
}

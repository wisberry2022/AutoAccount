package com.account.mysalary.controller;

import com.account.mysalary.common.util.HttpResponseUtil;
import com.account.mysalary.dto.OpenDto;
import com.account.mysalary.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/api/v1/account")
    public ResponseEntity getMyAccount() {
        return new ResponseEntity(accountService.getAccounts(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/account/{name}")
    public ResponseEntity getTotalExpense(@PathVariable String name) {
        Long result = accountService.getTotalExpenses(name);
        return new ResponseEntity(HttpResponseUtil.getSuccessCode(result), HttpStatus.OK);
    }

    @PostMapping("/api/v1/account")
    public ResponseEntity assignAccount(@RequestBody OpenDto account) throws Exception {
        try {
            accountService.openAccount(account);
            return new ResponseEntity(HttpResponseUtil.getSuccessCode(account), HttpStatus.ACCEPTED);
        }catch(Exception e) {
            throw new Exception("Invalid Account Data!");
        }
    }

}

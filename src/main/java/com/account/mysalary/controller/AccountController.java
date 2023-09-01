package com.account.mysalary.controller;

import com.account.mysalary.common.util.HttpResponseUtil;
import com.account.mysalary.dto.AccountDto;
import com.account.mysalary.dto.OpenDto;
import com.account.mysalary.dto.UpdateNameDto;
import com.account.mysalary.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("mysalary")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/api/v1/account")
    public ResponseEntity getMyAccount() {
        return new ResponseEntity(accountService.getAccounts(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/account/{id}")
    public ResponseEntity getAccountDetail(@PathVariable String id) throws Exception {
        AccountDto result = accountService.getDetail(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/api/v1/account/{id}/amount")
    public ResponseEntity getTotalExpense(@PathVariable String id) {
        Long result = accountService.getTotalExpenses(Long.parseLong(id));
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

    @PutMapping("/api/v1/account")
    public ResponseEntity changeAccountName(@RequestBody UpdateNameDto dto) throws Exception {
        accountService.changeAccountName(dto);
        return new ResponseEntity(HttpResponseUtil.getSuccessCode(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/api/v1/account")
    public ResponseEntity deleteAccount(@RequestBody Map<String, String> target) throws Exception {
        accountService.deleteAccount(Long.parseLong(target.get("id")));
        return new ResponseEntity(HttpResponseUtil.getSuccessCode(), HttpStatus.ACCEPTED);
    }

}

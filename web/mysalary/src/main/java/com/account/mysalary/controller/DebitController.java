package com.account.mysalary.controller;

import com.account.mysalary.common.util.HttpResponseUtil;
import com.account.mysalary.dto.DebitDto;
import com.account.mysalary.service.AccountService;
import com.account.mysalary.service.DebitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DebitController {

    private final DebitService debitService;

    @PostMapping("/api/v1/transfer")
    public ResponseEntity assignTransfer(@RequestBody DebitDto debit) throws Exception {
        if(debitService.isAssignedTransfer(debit)) {
            throw new Exception("해당 계좌는 이미 자동이체 등록되어있는 계좌입니다!");
        }
        debitService.setDirectDebit(debit);
        return new ResponseEntity(HttpResponseUtil.getSuccessCode(debit), HttpStatus.ACCEPTED);
    }

}

package com.account.mysalary.controller;

import com.account.mysalary.common.util.HttpResponseUtil;
import com.account.mysalary.dto.DebitDeleteDto;
import com.account.mysalary.dto.DebitDto;
import com.account.mysalary.dto.UpdateDebitDto;
import com.account.mysalary.service.DebitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("mysalary")
public class DebitController {

    private final DebitService debitService;

    @PostMapping("/api/v1/debit")
    public ResponseEntity assignTransfer(@RequestBody DebitDto debit) throws Exception {
        debitService.setDirectDebit(debit);
        return new ResponseEntity(HttpResponseUtil.getSuccessCode(debit), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/api/v1/debit")
    public ResponseEntity changeDebit(@RequestBody UpdateDebitDto update) throws Exception {
        System.out.println("자동이체 수정 " + update);
        debitService.updateDebit(update);
        return new ResponseEntity(HttpResponseUtil.getSuccessCode(update), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/api/v1/debit/{id}")
    public ResponseEntity deleteDebit(@PathVariable String id) throws Exception {
        debitService.deleteDebit(Long.parseLong(id));
        return new ResponseEntity(HttpResponseUtil.getSuccessCode(), HttpStatus.ACCEPTED);
    }
}

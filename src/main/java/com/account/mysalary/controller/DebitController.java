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

    @GetMapping("/api/v1/account/{accountId}/debit")
    public ResponseEntity inquiryDebit(@PathVariable String accountId) throws Exception {
        try {
            List<DebitDto>  result = debitService.inquiry(Long.parseLong(accountId));
            return new ResponseEntity(HttpResponseUtil.getSuccessCode(result), HttpStatus.OK);
        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/api/v1/debit/{debitId}")
    public ResponseEntity getDebitDetail(@PathVariable String debitId) throws Exception {
        DebitDto result = debitService.getDetail(Long.parseLong(debitId));
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping("/api/v1/debit")
    public ResponseEntity assignTransfer(@RequestBody DebitDto debit) throws Exception {
        if(debitService.isAssignedTransfer(debit)) {
            throw new Exception("해당 계좌는 이미 자동이체 등록되어있는 계좌입니다!");
        }
        debitService.setDirectDebit(debit);
        return new ResponseEntity(HttpResponseUtil.getSuccessCode(debit), HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/v1/debit")
    public ResponseEntity changeDebit(@RequestBody UpdateDebitDto update) throws Exception {
        debitService.updateDebit(update);
        return new ResponseEntity(HttpResponseUtil.getSuccessCode(update), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/api/v1/debit")
    public ResponseEntity deleteDebit(@RequestBody DebitDeleteDto dto) throws Exception {
        debitService.deleteDebit(Long.parseLong(dto.getId()));
        return new ResponseEntity(HttpResponseUtil.getSuccessCode(), HttpStatus.ACCEPTED);
    }
}

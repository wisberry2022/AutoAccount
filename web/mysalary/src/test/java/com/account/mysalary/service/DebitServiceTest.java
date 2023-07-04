package com.account.mysalary.service;

import com.account.mysalary.dto.DebitDto;
import com.account.mysalary.dto.UpdateDebitDto;
import com.account.mysalary.entity.Account;
import com.account.mysalary.entity.AutoDeposit;
import com.account.mysalary.repository.AccountRepository;
import com.account.mysalary.repository.AutoDepositRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class DebitServiceTest {

    @Autowired
    private DebitService debitService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AutoDepositRepository depositRepository;
    @Autowired
    private AccountRepository accountRepository;
    private UpdateDebitDto updateDto;

    private DebitDto debitDto;

    @Test
    public void contextLoads() {

    }

    @BeforeEach
    public void updateDebitDto() {
        debitDto = DebitDto.builder()
                .date(new Date())
                .withdrawal("1122008177401")
                .deposit("3028558834191")
                .amount(500000)
                .name("적금통장")
                .build();
    }

    @Test
    public void updateDebit() throws Exception {
        updateDto = UpdateDebitDto.builder()
                .name("엄마통장")
                .amount(100000L)
                .beforeDeposit("8819203918321")
                .deposit("11110390231")
                .withdrawal(8L)
                .build();
//        debitService.setDirectDebit(debitDto);
        debitService.updateDebit(updateDto);
    }

    public Long getId(AutoDeposit entity) {
        return entity.getId();
    }

    public Account getWithdrawal(AutoDeposit entity) {
        return entity.getWithdrawal();
    }

    public String getDeposit(AutoDeposit entity) {
        return entity.getDeposit();
    }

    public Long getAmount(AutoDeposit entity) {
        return entity.getAmount();
    }

    public String getName(AutoDeposit entity) {
        return entity.getName();
    }

    public Date getDate(AutoDeposit entity) {
        return entity.getDate();
    }


}

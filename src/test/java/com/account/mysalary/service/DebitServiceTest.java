package com.account.mysalary.service;

import com.account.mysalary.dto.DebitDto;
import com.account.mysalary.dto.UpdateDebitDto;
import com.account.mysalary.entity.Account;
import com.account.mysalary.entity.AutoDeposit;
import com.account.mysalary.repository.AccountRepository;
import com.account.mysalary.repository.AutoDepositRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;

import java.util.Date;
import java.util.List;

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
    @Disabled
    public void updateDebit() throws Exception {
        updateDto = UpdateDebitDto.builder()
                .name("엄마통장")
                .amount(100000L)
                .beforeDeposit("8819203918321")
                .deposit("11110390231")
                .withdrawal(8L)
                .build();
        debitService.updateDebit(updateDto);
    }

    @Test
    @Disabled
    public void inquiryDebits() throws Exception {
        List<DebitDto> result = debitService.inquiry(1L);
        Assertions.assertEquals(result.size(), 3);
    }

    @Test
    @Disabled
    public void getDetail() throws Exception {
        DebitDto result = debitService.getDetail(4L);
        System.out.println(result);
    }

}

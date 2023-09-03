package com.account.mysalary.service;

import com.account.mysalary.dto.DebitDto;
import com.account.mysalary.dto.OpenDto;
import com.account.mysalary.dto.UpdateDebitDto;
import com.account.mysalary.entity.Account;
import com.account.mysalary.entity.AutoDeposit;
import com.account.mysalary.repository.AccountRepository;
import com.account.mysalary.repository.AutoDepositRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;

import java.util.Date;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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

    @BeforeAll
    public void updateDebitDto() throws Exception {
        OpenDto target = OpenDto.builder()
                .owner("왕인서")
                .serial("1122008177401")
                .balance(10000L)
                .name("BNK-일반")
                .build();
        accountService.openAccount(target);
        debitDto = DebitDto.builder()
                .date(new Date())
                .withdrawal("1122008177401")
                .deposit("3028558834191")
                .amount(500000)
                .name("적금통장")
                .build();
        debitService.setDirectDebit(debitDto);
    }

    @Test
    @Order(1)
    public void isRightDB() throws Exception {
        System.out.println("isRightDB: " + debitService.inquiry(1L));
    }


    @Test
    @Order(2)
    public void updateDebit() throws Exception {
        updateDto = UpdateDebitDto.builder()
                .name("엄마통장")
                .amount(100000L)
                .beforeDeposit("3028558834191")
                .deposit("11110390231")
                .withdrawal(1L)
                .build();
        debitService.updateDebit(updateDto);
        System.out.println("updateDebit: " + debitService.getDetail(1L));
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

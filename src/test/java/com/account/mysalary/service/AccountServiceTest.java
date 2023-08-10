package com.account.mysalary.service;

import com.account.mysalary.dto.*;
import com.account.mysalary.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountRepository ar;
    @Autowired
    private AccountService as;

    @Autowired
    private DebitService ts;

    private OpenDto openDto = null;
    private TransferDto transferDto = null;
    private DebitDto debitDto = null;

    private UpdateNameDto updateDto = null;

    @Test
    void contextLoads() {
    }

    @BeforeEach
    public void setFixture() {
        openDto = OpenDto.builder()
                .owner("왕인서")
                .serial("11220081774021")
                .balance(0L)
                .name("일반통장")
                .build();
        transferDto = TransferDto.builder()
                .name("일반통장")
                .amount(300000)
                .build();
        debitDto = DebitDto.builder()
                .date(new Date())
                .withdrawal("11220081774021")
                .deposit("3028558834191")
                .amount(500000)
                .name("적금통장")
                .build();
    }

    @Test
    @Disabled
    public void openAccount() {
        Assertions.assertEquals(ar.findByName("일반통장").get().getName(), "일반통장");
    }

    @Test
    @Disabled
    public void deposit() {
        as.openAccount(openDto);
        as.deposit(transferDto);
        Assertions.assertEquals(ar.findBalanceByName("일반통장"), 300000);
    }

    @Test
    @Disabled
    public void withdrawal() {
        as.openAccount(openDto);
        as.deposit(transferDto);
        transferDto.setAmount(150000);
        as.withdrawal(transferDto);
        Assertions.assertEquals(ar.findBalanceByName("일반통장"), 150000);
    }

    @Test
    @Disabled
    public void setDirectDebit() {
        Assertions.assertEquals(as.getTotalExpenses(6L), 1000000);
    }

    @Test
    @Disabled
    public void getAccounts() {
        as.openAccount(openDto);
        openDto.setSerial("302930910298");
        openDto.setName("취미통장");
        openDto.setBalance(1500000L);
        as.openAccount(openDto);
        System.out.println(as.getAccounts());
    }

    @Test
    @Disabled
    public void isAssignTransfer() {
        Assertions.assertEquals(ts.isAssignedTransfer(debitDto), true);
    }

    @Test
    @Disabled
    public void updateAccount() throws Exception {
        updateDto = UpdateNameDto.builder().before("일반통장").after("예금통장").build();
        as.openAccount(openDto);
        as.changeAccountName(updateDto);
        Assertions.assertEquals(ar.findByName("예금통장").get().getName(), "예금통장");
    }

    @Test
    @Disabled
    public void deleteAccount() throws Exception {
        as.deleteAccount(6L);
    }

    @Test
    @Disabled
    public void getAccountDetail() throws Exception {
        AccountDto result = as.getDetail("6");
        System.out.println(result);
    }
}

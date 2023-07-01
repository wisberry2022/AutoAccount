package com.account.mysalary.service;

import com.account.mysalary.dto.OpenDto;
import com.account.mysalary.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private AccountRepository ar;
    @Autowired
    private AccountService as;

    private OpenDto openDto = null;

    @Test
    void contextLoads() {
    }

    @BeforeEach
    public void setFixture() {
        openDto = OpenDto.builder()
                .owner("왕인서")
                .serial("1122008177401")
                .balance(0L)
                .name("일반통장")
                .build();
    }

    @Test
    public void openAccount() {
        as.openAccount(openDto);
        Assertions.assertEquals(ar.findByName("일반통장").get().getName(), "일반통장");
    }

}

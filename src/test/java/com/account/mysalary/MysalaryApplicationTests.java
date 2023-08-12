package com.account.mysalary;

import com.account.mysalary.entity.Account;
import com.account.mysalary.repository.AccountRepository;
import com.account.mysalary.repository.AutoDepositRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

@SpringBootTest
class MysalaryApplicationTests {

	@Autowired
	private AutoDepositRepository adr;

	@Autowired
	private AccountRepository ar;

	private Account normal;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void setFixture() {
		normal = Account.builder().id(1L).owner("jack").balance(0L).name("normal").serial("112202391023").build();
		ar.save(normal);
	}

	@Test
	@Disabled
	public void checkEntity() {
		Assertions.assertEquals(ar.findById(6L).get().getName(), "BNK-청약");
	}


}

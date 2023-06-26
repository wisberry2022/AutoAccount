import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.program.account.Account;
import org.program.account.AccountImpl;
import org.program.trade.AutoTradingManager;

import java.util.Arrays;

public class AutoTradingManagerTest {

    private AutoTradingManager atm;
    private Account lifeAccount;
    private Account monthlySpendAccount;

    @BeforeEach
    public void init() {
        lifeAccount = new AccountImpl("일반계좌");
        lifeAccount.deposit(300000);
        lifeAccount.setAutoTransfer("월간정기출금액", 300000);
        monthlySpendAccount = new AccountImpl("월간정기출금액");
        atm = new AutoTradingManager(Arrays.asList(lifeAccount, monthlySpendAccount));
    }

    @Test
    public void deposit() {
        atm.autoDeposit("일반계좌", "월간정기출금액");
        Assertions.assertEquals(lifeAccount.getBalance(), 0);
        Assertions.assertEquals(monthlySpendAccount.getBalance(), 300000);

    }



}

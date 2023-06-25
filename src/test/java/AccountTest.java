import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.program.account.Account;
import org.program.account.AccountImpl;

public class AccountTest {

    private Account monthlySpendAccount;
    private Account lifeAccount;
    private Account privateSavingAccount;

    @BeforeEach
    public void init() {
        monthlySpendAccount = new AccountImpl("월간정기출금액");
        lifeAccount = new AccountImpl("일반통장");
        privateSavingAccount = new AccountImpl("개인저축통장");
    }

    @Test
    public void getTotalAmount() {
        Assertions.assertEquals(lifeAccount.getTotalAmount(), 0);
    }

    @Test
    public void setAutoTransfer() {
        lifeAccount.setAutoTransfer("월간정기출금액", 300000);
        lifeAccount.setAutoTransfer("개인저축통장", 500000);
        Assertions.assertEquals(lifeAccount.getTotalAutoTransferAmount(), 300000+500000);
    }

    @Test
    public void getAutoTransferMoney() {
        lifeAccount.setAutoTransfer("월간정기출금액", 300000);
        Assertions.assertEquals(lifeAccount.getDetailAutoTransferMoney("월간정기출금액"), 300000);
    }

}

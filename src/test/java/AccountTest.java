import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.program.account.Account;
import org.program.data.Data;

import java.util.HashMap;

public class AccountTest {
    
    private Account normal;

    private Account installment;

    private Data data;

    @BeforeEach
    public void setFixture() {
        normal = new Account("일반통장", 30000);
        installment = new Account("적금통장", 0);
        data = Data.getInstance();
    }

    @Test
    public void setAutoDeposit() {
        normal.setAutoDeposit("적금통장", 5000);
        normal.showAutoDeposit();
    }

    @Test
    public void doAutoDeposit() {
        normal.setAutoDeposit("적금통장", 5000);
        normal.autoDeposit("적금통장");
        Assertions.assertEquals(installment.getBalance(), 5000);
        Assertions.assertEquals(normal.getBalance(), 25000);
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.program.account.Account;
import org.program.data.Data;

import java.util.HashMap;

public class AccountTest {
    
    private Account normal;

    private Account installment;
    private Account hobby;
    private Account parent;

    @BeforeEach
    public void setFixture() {
        normal = new Account("일반통장", 30000);
        installment = new Account("적금통장", 0);
        hobby = new Account("취미통장",  0);
        parent = new Account("부모님통장", 0);
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

    @Test
    public void getTotalExpenses() {
        normal.setAutoDeposit("적금통장", 500000);
        normal.setAutoDeposit("취미통장", 300000);
        normal.setAutoDeposit("부모님통장", 300000);
        Assertions.assertEquals(normal.getTotalExpenses(), 500000+300000+300000);
    }

    @Test
    public void getExpectedBalance() {
        normal.setAutoDeposit("적금통장", 500000);
        normal.setAutoDeposit("취미통장", 300000);
        normal.setAutoDeposit("부모님통장", 300000);
        Assertions.assertEquals(normal.getExpectedBalance(),
                normal.getBalance() - (500000+300000+300000)
        );
    }
}

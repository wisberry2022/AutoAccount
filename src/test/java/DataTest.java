import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.program.account.Account;
import org.program.data.Data;

import java.util.Map;

public class DataTest {

    private Data data;
    private Account normal2;

    @BeforeEach
    public void setFixture() {
        data = Data.getInstance();
        normal2 = new Account("일반통장", 5000);
    }

    @Test
    @Disabled
    public void setAutoTransfer() {
        Account normal = new Account("일반통장", 0);
        data.setAccount(normal);
        Assertions.assertEquals(data.getAccount("일반통장"), normal);
    }

    @Test
    public void initTest() {
        Assertions.assertEquals(normal2, data.getAccount("일반통장"));
    }

    @Test
    public void initTest2() {
        Account installment = new Account("적금통장", 0);
        Assertions.assertEquals(normal2, data.getAccount("일반통장"));
        Assertions.assertEquals(installment, data.getAccount("적금통장"));
    }

    @Test
    public void persistenceTest() {
        normal2.deposit(50000);
        Assertions.assertEquals(data.getAccount("일반통장").getBalance(), 55000);
    }

}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.program.practice.acc.Acc;

public class SecondTest {

    private Acc lifeAccount;
    private Acc installment;

    private Acc wdhAccount;

    @BeforeEach
    public void init() {
        lifeAccount = new Acc("일반통장");
        wdhAccount = new Acc("우동현 통장");
        installment = new Acc("청년도약계좌");
        lifeAccount.setAutoTransfer(installment, 500000);
        lifeAccount.setAutoTransfer(wdhAccount, 100000);
    }

    @Test
    public void setAutoTransfer() {
        Assertions.assertEquals(lifeAccount.getTransferAmount(), 500000 + 100000);
    }

    @Test
    public void autoDeposit() {
        lifeAccount.autoDeposit("청년도약계좌");
        Assertions.assertEquals(installment.getBalance(), 500000);
    }

}

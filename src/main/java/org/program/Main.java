package org.program;

import org.program.account.Account;
import org.program.account.AccountImpl;
import org.program.trade.AutoTradingManager;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Account mainAccount = new AccountImpl("월급계좌");
        Account installment = new AccountImpl("적금계좌");


        mainAccount.setAutoTransfer("월간정기출금액", 100000);
        mainAccount.setAutoTransfer("적금계좌", 300000);
        mainAccount.deposit(2700000);

        AutoTradingManager atm = new AutoTradingManager(Arrays.asList(mainAccount, installment));

        atm.autoDeposit("월급계좌", "적금계좌");

        System.out.println("월급계좌 잔액: " + mainAccount.getBalance());
        System.out.println("적금계좌 잔액: " + installment.getBalance());
        System.out.println("월급계좌 자동이체 금액: " + mainAccount.getTotalAutoTransferAmount());
    }
}
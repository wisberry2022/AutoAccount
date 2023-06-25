package org.program.account;

public interface Account {

    void deposit(long balance);

    long withdrawal(long balance);

    long getBalance();

    long getDetailAutoTransferMoney(String inquiry);

    String getName();

    long getTotalAutoTransferAmount();

    void setAutoTransfer(String targetAccount, long amount);

    void showTotalAutoTransferData();

    long getTotalAmount();
}

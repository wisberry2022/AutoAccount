package org.program.account;

import java.util.*;

public class AccountImpl implements Account{

    private Map<String, Long> autoTransferData;
    private long balance = 0;
    private String name;

    public AccountImpl(String name) {
        this.name = name;
        autoTransferData = new HashMap<>();
    }

    @Override
    public long getTotalAmount() {
        return 0;
    }

    @Override
    public void setAutoTransfer(String targetAccount, long amount) {
        autoTransferData.put(targetAccount, amount);
    }

    @Override
    public long getTotalAutoTransferAmount() {
        Iterator<String> keys = autoTransferData.keySet().iterator();
        List<String> accountList = new ArrayList<>();
        keys.forEachRemaining(accountList::add);

        return accountList.stream()
                .map(autoTransferData::get)
                .reduce(0L, Long::sum);
    }

    @Override
    public void deposit(long amount) {
        balance += amount;
    }

    @Override
    public long withdrawal(long amount) {
        balance -= amount;
        return amount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getBalance() {
        return balance;
    }

    @Override
    public long getDetailAutoTransferMoney(String inquiry) {
        return autoTransferData.get(inquiry);
    }

    @Override
    public void showTotalAutoTransferData() {
        autoTransferData.keySet().forEach(
                accountName -> System.out.println(accountName + " " + autoTransferData.get(accountName))
        );
    }
}

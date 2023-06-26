package org.program.practice.acc;

import java.util.HashMap;
import java.util.Map;

public class Acc {

    private static Map<String, Acc> accounts = new HashMap<>();
    private String name;
    private Map<String, Long> autoTransferData;
    private long balance = 0;

    public Acc(String name) {
        this.name = name;
        autoTransferData = new HashMap<>();
    }

    public void setAutoTransfer(Acc account, long amount) {
        autoTransferData.put(account.getName(), amount);
        accounts.put(account.getName(), account);
    }

    public String getName() {
        return name;
    }

    public long getTransferAmount() {
        return autoTransferData.keySet().stream()
                .map(autoTransferData::get)
                .reduce(0L, ((a,b) -> a+=b));
    }

    public void autoDeposit(String name) {
        accounts.get(name).deposit(autoTransferData.get(name));
    }

    public void deposit(long amount) {
        balance += amount;
    }

    public long withdrawal(long amount) {
        balance -= amount;
        return amount;
    }

    public long getBalance() {
        return balance;
    }

}

package org.program.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account {

    private static final Map<String, Account> accountInfo = new HashMap<>();
    private final Map<String, Long> autoDeposits;

    private final String name;
    private long balance;

    public Account(String name, long balance) {
        this.name = name;
        this.balance = balance;
        autoDeposits = new HashMap<>();
        accountInfo.put(name, this);
    }

    public void deposit(long amount) {
        balance += amount;
    }

    public long withdrawal(long amount) {
        balance -= amount;
        return amount;
    }

    public void setAutoDeposit(String name, long amount){
        if(accountInfo.containsKey(name)) {
            autoDeposits.put(name, amount);
        };
    }

    public void autoDeposit(String name) {
        if(autoDeposits.containsKey(name)) {
            accountInfo.get(name).deposit(autoDeposits.get(name));
            withdrawal(autoDeposits.get(name));
        }
    }

    public void showAutoDeposit() {
        autoDeposits.keySet().stream()
                .forEach(aName -> System.out.println(
                        aName + " " + autoDeposits.get(aName)
                ));
    }

    public long getBalance() {
        return balance;
    }
}

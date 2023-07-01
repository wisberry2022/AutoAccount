package org.program.account;

import org.program.data.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account {

    private final Map<String, Long> autoDeposits;

    private Map<String, Account> data = Data.getInstance().getData();

    private final String name;
    private long balance;

    public Account(String name, long balance) {
        this.name = name;
        this.balance = balance;
        autoDeposits = new HashMap<>();
        Data.getInstance().setAccount(this);
    }

    public void deposit(long amount) {
        balance += amount;
    }

    public long withdrawal(long amount) {
        balance -= amount;
        return amount;
    }

    public void setAutoDeposit(String name, long amount){
        if(data.containsKey(name)) {
            autoDeposits.put(name, amount);
        };
    }

    public void autoDeposit(String name) {
        if(autoDeposits.containsKey(name)) {
            data.get(name).deposit(autoDeposits.get(name));
            withdrawal(autoDeposits.get(name));
        }
    }

    public void showAutoDeposit() {
        autoDeposits.keySet().stream()
                .forEach(aName -> System.out.println(
                        aName + " " + autoDeposits.get(aName)
                ));
    }

    public long getTotalExpenses() {
        return autoDeposits.keySet().stream()
                .map(autoDeposits::get)
                .reduce(0L, (aLong, aLong2) -> aLong + aLong2);
    }

    public long getExpectedBalance() {
        return balance - getTotalExpenses();
    }

    public long getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}

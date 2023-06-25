package org.program.trade;

import org.program.account.Account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoTradingManager {

    private static Map<String, Account> accountMap = new HashMap<>();

    public AutoTradingManager(List<Account> accountList) {
        accountList.stream()
                .forEach(account -> {
                    accountMap.put(account.getName(), account);
                });
    }

    public void autoDeposit(String withdrawal, String deposit) {
        Account start = accountMap.get(withdrawal);
        Account target = accountMap.get(deposit);

        if(start.getDetailAutoTransferMoney(deposit) > start.getBalance()) {
            System.out.println(withdrawal + " 통장 잔액 부족으로 자동이체가 취소되었습니다");
            return;
        }

        target.deposit(start.getDetailAutoTransferMoney(deposit));
        start.withdrawal(start.getDetailAutoTransferMoney(deposit));
    }

}

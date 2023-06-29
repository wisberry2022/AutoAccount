package org.program.data;

import org.program.account.Account;

import java.util.HashMap;
import java.util.Map;

public class Data {

    private final Map<String, Account> data;

    private static Data me = getInstance();

    private Data() {
         data = new HashMap<>();
    }

    public static Data getInstance() {
        if(me != null) {
            return me;
        }
        return new Data();
    }

    public Map<String, Account> getData() {
        return data;
    }

}

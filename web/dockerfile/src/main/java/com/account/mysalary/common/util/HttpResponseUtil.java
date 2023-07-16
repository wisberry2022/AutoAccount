package com.account.mysalary.common.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HttpResponseUtil {

    private final static Map<String, Object> RESPONSE_DATA = new HashMap<>();

    public static Map<String, Object> getSuccessCode() {
        RESPONSE_DATA.put("result", "OK");
        return RESPONSE_DATA;
    }

    public static Map<String, Object> getSuccessCode(Object data) {
        RESPONSE_DATA.put("result", data);
        return RESPONSE_DATA;
    }

    public static Map<String, Object> getFailedCode() {
        RESPONSE_DATA.put("result", "FAIL");
        return RESPONSE_DATA;
    }

    public static Map<String, Object> getFailedCode(Object data) {
        RESPONSE_DATA.put("result", data);
        return RESPONSE_DATA;
    }

}

package com.account.mysalary.dto;

import lombok.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OpenDto {

    private String owner;
    private String serial;
    private String name;
    private Long balance;

    public void isThisNull() throws Exception {
        Field[] fields = this.getClass().getDeclaredFields();
        for(Field field:fields) {
            if(field.get(this) == null) {
                throw new Exception("필수값을 미입력하였습니다!");
            };
        }
    }

}

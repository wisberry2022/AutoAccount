package com.account.mysalary.dto;

import lombok.*;

import java.lang.reflect.Field;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DebitDto {

    private Long id;
    private String withdrawal;
    private String deposit;
    private String name;
    private long amount;
    private Date date;

    public void isThisNull() throws Exception {
        Field[] fields = this.getClass().getDeclaredFields();
        for(Field field:fields) {
            if(field.get(this) == null) {
                throw new Exception("필수값을 미입력하였습니다!");
            };
        }
    }

}

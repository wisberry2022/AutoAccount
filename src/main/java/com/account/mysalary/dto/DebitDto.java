package com.account.mysalary.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DebitDto {

    private Long id;

    /* 출금 계좌 번호 */
    private String withdrawal;
    
    /* 입금 계좌 번호 */
    private String deposit;

    /* 입금 계좌 이름 */
    private String name;
    private long amount;
    private Date date;

}

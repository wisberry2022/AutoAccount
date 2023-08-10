package com.account.mysalary.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AccountDto {

    private Long id;
    private String name;
    private String serial;
    private Long balance;
    private String owner;
    private int debitCount;

}

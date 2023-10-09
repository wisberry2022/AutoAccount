package com.account.mysalary.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InquiryDto {

    private Long id;
    private String name;
    private String serial;
    private Long balance;
    private String owner;
    private int debitCount;
    private long expense;
    private List<DebitDto> debits;

}

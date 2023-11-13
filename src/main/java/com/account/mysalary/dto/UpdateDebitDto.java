package com.account.mysalary.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateDebitDto {

    private Long withdrawal;
    private Long id;
    private Long amount;
    private String name;

}

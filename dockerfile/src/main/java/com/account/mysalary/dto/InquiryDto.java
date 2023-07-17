package com.account.mysalary.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InquiryDto {

    private String name;
    private String serial;
    private Long balance;
    private String owner;

}

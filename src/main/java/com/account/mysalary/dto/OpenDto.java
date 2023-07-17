package com.account.mysalary.dto;

import lombok.*;

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


}

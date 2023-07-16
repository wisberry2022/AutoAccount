package com.account.mysalary.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateNameDto {

    private String before;
    private String after;

}

package com.account.mysalary.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class AutoDeposit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =  "withdrawal")
    private Account withdrawal;

    @Column(length = 100, nullable = false)
    private String deposit;

    @Column(nullable = false)
    private Long amount;

    private Date date;



}

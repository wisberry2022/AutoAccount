package com.account.mysalary.entity;

import com.account.mysalary.dto.UpdateDebitDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Entity
@Getter
@Builder
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

    @Column(nullable = false)
    private String name;

    private Date date;

    public void changeDebit(UpdateDebitDto dto) {
        Optional.of(dto).ifPresent(update -> this.name = update.getName());
        Optional.of(dto).ifPresent(update -> this.amount = update.getAmount());
    }

}

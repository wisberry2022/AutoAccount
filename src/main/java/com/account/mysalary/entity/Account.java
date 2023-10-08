package com.account.mysalary.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=50, nullable = false)
    private String name;

    @Column(length=100, nullable = false, unique = true)
    private String serial;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Long balance;

    @Column(length = 60, nullable = false)
    private String owner;

    @OneToMany(mappedBy = "withdrawal", cascade = CascadeType.ALL)
    private List<AutoDeposit> autoDeposits = new ArrayList<>();

    public void deposit(long amount) {
        balance += amount;
    }

    public long withdrawal(long amount) {
        balance -= amount;
        return amount;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public long getTotalExpense() {
        return Optional.ofNullable(autoDeposits)
                .orElseGet(this::getAutoDeposits).stream()
                .map(AutoDeposit::getAmount)
                .reduce(0L, (a,b) -> a+=b);
    }

}

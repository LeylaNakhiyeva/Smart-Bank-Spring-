package az.bank.smart_banking_system.model.entity;

import az.bank.smart_banking_system.model.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    private Double balance;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;
}
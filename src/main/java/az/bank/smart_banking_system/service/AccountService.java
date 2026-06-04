package az.bank.smart_banking_system.service;

import az.bank.smart_banking_system.model.entity.Account;
import az.bank.smart_banking_system.model.enums.AccountStatus;
import az.bank.smart_banking_system.repository.AccountRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account createAccount(String accountNumber) {

        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBalance(0.0);
        account.setStatus(AccountStatus.ACTIVE);

        return repository.save(account);
    }

    public Account deposit(String accountNumber, Double amount) {

        Account acc = repository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        acc.setBalance(acc.getBalance() + amount);

        return repository.save(acc);
    }

    public Account withdraw(String accountNumber, Double amount) {

        Account acc = repository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (acc.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        acc.setBalance(acc.getBalance() - amount);

        return repository.save(acc);
    }

    public Account getAccount(String accountNumber) {
        return repository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }
}

package az.bank.smart_banking_system.controller;

import az.bank.smart_banking_system.model.entity.Account;
import az.bank.smart_banking_system.service.AccountService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Account create(@RequestParam String accountNumber) {
        return service.createAccount(accountNumber);
    }

    @PostMapping("/deposit")
    public Account deposit(@RequestParam String accountNumber,
                           @RequestParam Double amount) {
        return service.deposit(accountNumber, amount);
    }

    @PostMapping("/withdraw")
    public Account withdraw(@RequestParam String accountNumber,
                            @RequestParam Double amount) {
        return service.withdraw(accountNumber, amount);
    }

    @GetMapping
    public Account getAccount(@RequestParam String accountNumber) {
        return service.getAccount(accountNumber);
    }

    @GetMapping("/all")
    public List<Account> getAllAccounts() {
        return service.getAllAccounts();
    }
}
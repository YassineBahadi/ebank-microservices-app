package com.yassine.ebankservice.controllers;

import com.yassine.ebankservice.entities.BankAccount;
import com.yassine.ebankservice.services.EbankService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pc
 **/
@RestController
@AllArgsConstructor
public class EbankRestController {
    private final EbankService ebankService;

    @GetMapping("/accounts")
    public List<BankAccount> getAllBankAccounts() {
        return ebankService.getAllBankAccounts();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getBankAccountById(@PathVariable  String id) {
        return ebankService.getBankAccountById(id);
    }

    @PostMapping("/accounts")
    public BankAccount save(@RequestBody  BankAccount bankAccount){
        return ebankService.save(bankAccount);
    }
}

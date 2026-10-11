package com.yassine.ebankservice.services;

import com.yassine.ebankservice.entities.BankAccount;
import com.yassine.ebankservice.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author pc
 **/
@Service
@AllArgsConstructor
public class EbankService {
    private final BankAccountRepository accountRepository;

    public List<BankAccount> getAllBankAccounts() {
        return accountRepository.findAll();
    }

    public BankAccount getBankAccountById(String id) {
        return accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));
    }

    public BankAccount save(BankAccount bankAccount){
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        return accountRepository.save(bankAccount);
    }
}

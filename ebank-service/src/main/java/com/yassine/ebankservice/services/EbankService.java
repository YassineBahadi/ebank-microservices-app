package com.yassine.ebankservice.services;

import com.yassine.ebankservice.entities.BankAccount;
import com.yassine.ebankservice.feign.CustomerRestClient;
import com.yassine.ebankservice.model.Customer;
import com.yassine.ebankservice.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
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
    private final   BankAccountRepository accountRepository;
    private final   CustomerRestClient customerRestClient;


    @McpTool(description = "Get all Bank accounts")
    public List<BankAccount> getAllBankAccounts() {
        return accountRepository.findAll();
    }

    @McpTool(description = "Get a bank account by id")
    public BankAccount getBankAccountById(@McpToolParam(description = "The bank account id") String id) {
         BankAccount bankAccount= accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));
         bankAccount.setCustomer(customerRestClient.getCustomerById(bankAccount.getCustomerId()));
         return bankAccount;

    }

    @McpTool(description = "Save a new bank account")
    public BankAccount save(@McpToolParam(description = "The bank account to save (balance,type,customerId) ") BankAccount bankAccount){
        try {
            Customer customer = customerRestClient.getCustomerById(bankAccount.getCustomerId());
            bankAccount.setId(UUID.randomUUID().toString());
            bankAccount.setCreatedAt(new Date());
            return accountRepository.save(bankAccount);
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}

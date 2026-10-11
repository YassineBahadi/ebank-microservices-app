package com.yassine.ebankservice.repository;

import com.yassine.ebankservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author pc
 **/
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    List<BankAccount> findByCustomerId(Long id);
}

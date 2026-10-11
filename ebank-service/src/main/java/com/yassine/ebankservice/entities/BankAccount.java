package com.yassine.ebankservice.entities;

import com.yassine.ebankservice.model.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.Date;

/**
 * @author pc
 **/
@Entity
@Getter @Setter @Builder
@NoArgsConstructor  @AllArgsConstructor
public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private double balance;
    private String type;
    private long customerId;
    @Transient
    private Customer customer;
}

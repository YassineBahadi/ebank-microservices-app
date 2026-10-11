package com.yassine.customerservice.repository;

import com.yassine.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pc
 **/
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}

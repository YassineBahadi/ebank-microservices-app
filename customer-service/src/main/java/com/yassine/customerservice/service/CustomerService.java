package com.yassine.customerservice.service;

import com.yassine.customerservice.entities.Customer;
import com.yassine.customerservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pc
 **/
@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer findCustomerById(Long id){
        return customerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Customer with id:"+id+" Not found"));
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}

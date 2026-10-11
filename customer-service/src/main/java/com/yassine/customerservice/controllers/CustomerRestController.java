package com.yassine.customerservice.controllers;

import com.yassine.customerservice.entities.Customer;
import com.yassine.customerservice.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pc
 **/
@RestController
@AllArgsConstructor
public class CustomerRestController {
    private final CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable Long id){
        return customerService.findCustomerById(id);
    }

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }
}

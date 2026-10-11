package com.yassine.customerservice.service;

import com.yassine.customerservice.entities.Customer;
import com.yassine.customerservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pc
 **/
@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    @McpTool(description = "Get All customers")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @McpTool(description = "Find a customer by id")
    public Customer findCustomerById(@McpToolParam(description ="the customer id" ) Long id){
        return customerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Customer with id:"+id+" Not found"));
    }

    @McpTool(description = "Save a new customer")
    public Customer saveCustomer(@McpToolParam(description = "The Customer to save (name,email)") Customer customer){
        return customerRepository.save(customer);
    }
}

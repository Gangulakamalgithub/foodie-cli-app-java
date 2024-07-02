package com.myproject.foodiecliapp.service;

import com.myproject.foodiecliapp.exceptions.CustomerExistExceptions;
import com.myproject.foodiecliapp.model.Customer;
import com.myproject.foodiecliapp.repository.CustomerRepository;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{


    private CustomerRepository customerRepository;

    public CustomerServiceImpl (CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }



    @Override
    public Customer save(Customer customer) throws CustomerExistExceptions {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getId());
        if(customerById.isPresent()){
            throw new CustomerExistExceptions("Customer Already exists  in this Id: " + customer.getId());
        }
        return this.customerRepository.save(customer);
    }
}

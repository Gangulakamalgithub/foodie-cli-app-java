package com.myproject.foodiecliapp.controller;

import com.myproject.foodiecliapp.exceptions.CustomerExistExceptions;
import com.myproject.foodiecliapp.model.Customer;
import com.myproject.foodiecliapp.service.CustomerServiceImpl;

public class CustomerController {

    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    public Customer save(Customer customer) throws CustomerExistExceptions {
        return customerService.save(customer);
    }
}

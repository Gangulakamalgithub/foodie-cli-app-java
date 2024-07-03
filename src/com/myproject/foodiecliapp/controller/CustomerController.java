package com.myproject.foodiecliapp.controller;


import com.myproject.foodiecliapp.exceptions.CustomerExistsException;
import com.myproject.foodiecliapp.model.Customer;
import com.myproject.foodiecliapp.service.CustomerServiceImpl;

public class CustomerController {

    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    public Customer save(Customer customer) throws CustomerExistsException {
        return this.customerService.save(customer);
    }
}

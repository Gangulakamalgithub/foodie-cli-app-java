package com.myproject.foodiecliapp.service;

import com.myproject.foodiecliapp.exceptions.CustomerExistExceptions;
import com.myproject.foodiecliapp.model.Customer;

public interface CustomerService {

    public Customer save(Customer customer) throws CustomerExistExceptions;
}

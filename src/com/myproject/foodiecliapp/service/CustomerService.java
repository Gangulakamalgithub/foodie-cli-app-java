package com.myproject.foodiecliapp.service;




import com.myproject.foodiecliapp.exceptions.CustomerExistsException;
import com.myproject.foodiecliapp.exceptions.CustomerNotFoundException;
import com.myproject.foodiecliapp.model.Customer;

import java.util.List;

public interface CustomerService {

    public Customer save(Customer customer) throws CustomerExistsException;
    public List<Customer> getAllCustomers();
    public Customer getCustomerById(String id) throws CustomerNotFoundException;
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
    public void deleteCustomer(String id) throws CustomerNotFoundException;
}
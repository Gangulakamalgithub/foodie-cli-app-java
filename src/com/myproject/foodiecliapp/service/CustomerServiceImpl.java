package com.myproject.foodiecliapp.service;


import com.myproject.foodiecliapp.exceptions.CustomerExistsException;
import com.myproject.foodiecliapp.exceptions.CustomerNotFoundException;
import com.myproject.foodiecliapp.model.Customer;
import com.myproject.foodiecliapp.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) throws CustomerExistsException {
        Optional<Customer> customerById = this.customerRepository.getCustomerById(customer.getId());
        if(customerById.isPresent())
            throw new CustomerExistsException("Customer Already Exists with this Id  :" + customer.getId());
        return this.customerRepository.saveCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public Customer getCustomerById(String id) throws CustomerNotFoundException {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
        return null;
    }

    @Override
    public void deleteCustomer(String id) throws CustomerNotFoundException {

    }
}
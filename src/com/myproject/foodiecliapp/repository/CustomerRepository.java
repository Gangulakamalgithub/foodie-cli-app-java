package com.myproject.foodiecliapp.repository;

import com.myproject.foodiecliapp.factory.Factory;
import com.myproject.foodiecliapp.model.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {

    List<Customer> customersList;

    public CustomerRepository() {
        this.customersList = Factory.getCsvReader().readCustomersFromCsv();
    }

    public List<Customer> getCustomersList() {
        return this.customersList;
    }

    public Customer saveCustomer(Customer customer) {
        this.customersList.add(customer);
        return customer;
    }

    public Optional<Customer> getCustomerById(String id) {
        return this.customersList.stream().filter(customer -> customer.getId().equals(id)).findFirst();
    }

    public Optional<Customer> getCustomerByEmail(String email){
        return this.customersList.stream().filter(customer -> customer.getEmail().equals(email)).findFirst();
    }

    public Optional<Customer> updateCustomer(Customer customerToBeUpdated) {
        return this.customersList.stream().filter(customer -> customer.getId().equals(customerToBeUpdated.getId()))
                .findFirst()
                .map(customer -> {
                    customer.setName(customerToBeUpdated.getName());
                    customer.setEmail(customerToBeUpdated.getEmail());
                    customer.setPassword(customerToBeUpdated.getPassword());

                    return customer;
                });
    }

    public void deleteCustomer(Customer customer){
        this.customersList.remove(customer);
    }
}
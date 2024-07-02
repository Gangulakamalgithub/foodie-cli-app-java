package com.myproject.foodiecliapp.repository;

import com.myproject.foodiecliapp.model.Customer;
import com.myproject.foodiecliapp.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {

         private List<Customer> customerList;


         public CustomerRepository(){
             CsvReader csvReader = new CsvReader();
             this.customerList = csvReader.readCustomerFromCsv();
         }

         public List<Customer> getAllCustomers() {
             return customerList;
    }
        public Customer save (Customer customer){
             this.customerList.add(customer);
             return customer;
        }

        public Optional<Customer> findCustomerById(String id){
             return this.customerList.stream().filter(customer -> customer.getId().equals(id)).findFirst();

        }
}


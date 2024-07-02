package com.myproject.foodiecliapp.util;

import com.myproject.foodiecliapp.model.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    // read the data file CSV and create a list files

    public List<Customer> readCustomerFromCsv() {
        String customersCsvFilePath = "C:\\java fundamental\\Java programming\\foodie-cli-app-java\\Data\\customers.csv";

        // java io classes (FileReader, BufferedReader)
        List<Customer> customerList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(customersCsvFilePath))) {
            String CsvSplit = ",";
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(CsvSplit);
                Customer customer = new Customer();
                customer.setId(data[0]);
                customer.setName(data[1]);
                customer.setEmail(data[2]);
                customer.setPassword(data[3]);

                customerList.add(customer);


            }
        } catch (IOException e) {
            System.out.println("File not Found in The Path: " + customersCsvFilePath);
            System.exit(0);
            e.printStackTrace();
        }

           return customerList;
    }
}

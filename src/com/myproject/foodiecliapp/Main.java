package com.myproject.foodiecliapp;

import com.myproject.foodiecliapp.util.CsvReader;

public class Main {
    public static void main(String[] args) {
        CsvReader csvReader = new CsvReader();
        System.out.println(csvReader.readCustomerFromCsv());
    }

}

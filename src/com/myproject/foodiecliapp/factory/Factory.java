package com.myproject.foodiecliapp.factory;


import com.myproject.foodiecliapp.controller.CustomerController;
import com.myproject.foodiecliapp.controller.DishController;
import com.myproject.foodiecliapp.controller.RestaurantController;
import com.myproject.foodiecliapp.repository.CustomerRepository;
import com.myproject.foodiecliapp.repository.DishRepository;
import com.myproject.foodiecliapp.repository.RestaurantRepository;
import com.myproject.foodiecliapp.service.CustomerServiceImpl;
import com.myproject.foodiecliapp.service.DishServiceImpl;
import com.myproject.foodiecliapp.service.RestaurantServiceImpl;
import com.myproject.foodiecliapp.util.CsvReader;

public class Factory {

    public static CsvReader getCsvReader(){
        return new CsvReader();
    }

    public static CustomerRepository getCustomerRepository(){
        return new CustomerRepository();
    }

    public static CustomerServiceImpl getCustomerService(){
        return new CustomerServiceImpl(getCustomerRepository());
    }

    public static CustomerController getCustomerController(){
        return new CustomerController(getCustomerService());
    }

    public static DishRepository getDishRepository(){
        return new DishRepository();
    }

    public static DishServiceImpl getDishService() {
        return new DishServiceImpl(getDishRepository());
    }

    public static DishController getDishController(){
        return new DishController(getDishService());
    }

    public static RestaurantRepository getRestaurantRepository(){
        return new RestaurantRepository();
    }

    public static RestaurantServiceImpl getRestaurantService(){
        return new RestaurantServiceImpl(getRestaurantRepository());
    }

    public static RestaurantController getRestaurantController(){
        return new RestaurantController(getRestaurantService());
    }


}

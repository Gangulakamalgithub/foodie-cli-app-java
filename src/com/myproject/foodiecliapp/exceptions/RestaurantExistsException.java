package com.myproject.foodiecliapp.exceptions;

public class RestaurantExistsException extends Exception{

    public RestaurantExistsException(String message) {
        super(message);
    }
}
package com.myproject.foodiecliapp.exceptions;

public class DishExistsException extends Exception {
    public DishExistsException(String message) {
        super(message);
    }
}

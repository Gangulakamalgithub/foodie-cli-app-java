package com.myproject.foodiecliapp.service;

import com.myproject.foodiecliapp.exceptions.RestaurantExistsException;
import com.myproject.foodiecliapp.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    public List<Restaurant> getRestaurantList();
    public Restaurant save(Restaurant restaurant) throws RestaurantExistsException;
}

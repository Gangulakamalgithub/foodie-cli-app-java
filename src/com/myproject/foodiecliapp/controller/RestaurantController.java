package com.myproject.foodiecliapp.controller;


import com.myproject.foodiecliapp.exceptions.RestaurantExistsException;
import com.myproject.foodiecliapp.model.Restaurant;
import com.myproject.foodiecliapp.service.RestaurantServiceImpl;

import java.util.List;

public class RestaurantController {

    private final RestaurantServiceImpl restaurantService;

    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    public List<Restaurant> getRestaurantList(){
        return this.restaurantService.getRestaurantList();
    }

    public Restaurant saveRestaurant(Restaurant restaurant) throws RestaurantExistsException {
        return this.restaurantService.save(restaurant);
    }
}

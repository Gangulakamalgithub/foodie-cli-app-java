package com.myproject.foodiecliapp.controller;


import com.myproject.foodiecliapp.exceptions.DishExistsException;
import com.myproject.foodiecliapp.model.Dish;
import com.myproject.foodiecliapp.service.DishServiceImpl;

import java.util.List;

public class DishController {

    private DishServiceImpl dishService;

    public DishController(DishServiceImpl dishService) {
        this.dishService = dishService;
    }

    public List<Dish> getDisesList(){
        return this.dishService.getDishesList();
    }

    public Dish save(Dish dish) throws DishExistsException {
        return this.dishService.save(dish);
    }
}

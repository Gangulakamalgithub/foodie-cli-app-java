package com.myproject.foodiecliapp.service;



import com.myproject.foodiecliapp.exceptions.DishExistsException;
import com.myproject.foodiecliapp.exceptions.DishNotFoundException;
import com.myproject.foodiecliapp.model.Dish;

import java.util.List;

public interface DishService {

    public List<Dish> getDishesList();

    public Dish save(Dish dish) throws DishExistsException;
    public Dish getDishById(String id) throws DishNotFoundException;
}

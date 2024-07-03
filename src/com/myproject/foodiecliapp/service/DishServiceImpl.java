package com.myproject.foodiecliapp.service;

import com.myproject.foodiecliapp.exceptions.DishExistsException;
import com.myproject.foodiecliapp.exceptions.DishNotFoundException;
import com.myproject.foodiecliapp.model.Dish;
import com.myproject.foodiecliapp.repository.DishRepository;

import java.util.List;
import java.util.Optional;

public class DishServiceImpl implements DishService{

    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> getDishesList() {
        return this.dishRepository.getDishList();
    }

    @Override
    public Dish save(Dish dish) throws DishExistsException {
        Optional<Dish> dishById = this.dishRepository.getDishById(dish.getId());
        if(dishById.isPresent())
            throw new DishExistsException("Dish Already Exists with this Id  :" + dish.getId());
        return this.dishRepository.saveDish(dish);
    }

    @Override
    public Dish getDishById(String id) throws DishNotFoundException {
        return null;
    }
}
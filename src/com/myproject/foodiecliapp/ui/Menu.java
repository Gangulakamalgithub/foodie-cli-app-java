package com.myproject.foodiecliapp.ui;


import com.myproject.foodiecliapp.controller.CustomerController;
import com.myproject.foodiecliapp.controller.DishController;
import com.myproject.foodiecliapp.controller.RestaurantController;
import com.myproject.foodiecliapp.exceptions.CustomerExistsException;
import com.myproject.foodiecliapp.exceptions.DishExistsException;
import com.myproject.foodiecliapp.exceptions.RestaurantExistsException;
import com.myproject.foodiecliapp.factory.Factory;
import com.myproject.foodiecliapp.model.Customer;
import com.myproject.foodiecliapp.model.Dish;
import com.myproject.foodiecliapp.model.Restaurant;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private DishController dishController;
    private CustomerController customerController;
    private RestaurantController restaurantController;

    public Menu() {
        this.dishController = Factory.getDishController();
        this.customerController = Factory.getCustomerController();
        this.restaurantController = Factory.getRestaurantController();
    }

    public void displayMainMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                displayMenuHeader("WELCOME TO FOODIE APP");
                System.out.println();
                System.out.println("Please select the option !");
                System.out.println("--------------------------");
                System.out.println("1. Register (New Customer)");
                System.out.println("2. Login  (Existing Customer)");
                System.out.println("3. View Restaurants");
                System.out.println("4. View Dishes ");
                System.out.println("5. Add Restaurant");
                System.out.println("6. Add Dish");
                System.out.println("7. Place Order");
                System.out.println("8. View Orders");
                System.out.println("9. Exit");

                System.out.println("Please enter your choice (1-7)");

                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        customerRegisterForm();
                        break;
                    case 3:
                        displayRestaurants();
                        break;
                    case 4:
                        displayDishes();
                        break;
                    case 5:
                        newRestaurantForm();
                        break;
                    case 6:
                        newDishForm();
                        break;
                    case 7:

                    case 9:
                        System.out.println("Thanks for choosing Foodie App, See you again !");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid Input. Please enter the valid input from(1-7)");

                }
            }
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            e.printStackTrace();
            displayMainMenu();
        }
    }

    private void newRestaurantForm() throws RestaurantExistsException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter Address");
            String address = scanner.nextLine();
            System.out.println("Enter Dishes for Menu separated by : (D010:D009)");
            String menu = scanner.nextLine();
            Restaurant restaurant = new Restaurant();
            restaurant.setId(id);
            restaurant.setName(name);
            restaurant.setAddress(address);
            restaurant.setMenu(Arrays.asList(menu.split(":")));
            restaurantController.saveRestaurant(restaurant);

        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            newRestaurantForm();
        }
    }

    private void newDishForm() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter Description");
            String description = scanner.nextLine();
            System.out.println("Enter Price");
            double price = scanner.nextDouble();
            Dish dish = new Dish();
            dish.setId(id);
            dish.setName(name);
            dish.setDescription(description);
            dish.setPrice(price);

            this.dishController.save(dish);
            System.out.println(" : New Dish Added Successfully : " + dish.getId());
        } catch (DishExistsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            newDishForm();
        }


    }

    private void displayRestaurants() {
        List<Restaurant> restaurantList = this.restaurantController.getRestaurantList();
        String dashesLine = new String(new char[150]).replace('\0', '-');
        displayMenuHeader("Restaurants");
        System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "Address", "Menu Items");
        System.out.println(dashesLine);
        restaurantList.forEach(restaurant -> {
            System.out.printf("%-10s %-30s %-80s %-30s\n", restaurant.getId(), restaurant.getName(), restaurant.getAddress(), String.join(":", restaurant.getMenu()));
        });
    }

    private void displayDishes() {

        List<Dish> dishesList = this.dishController.getDisesList();
        String dashesLine = new String(new char[150]).replace('\0', '-');
        displayMenuHeader("Menu Items");
        System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
        System.out.println(dashesLine);
        dishesList.forEach(dish -> {
            System.out.printf("%-10s %-30s %-80s %-10s\n", dish.getId(), dish.getName(), dish.getDescription(), String.format("$%.2f", dish.getPrice()));
        });

    }

    private void customerRegisterForm() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please register entering the following details\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter E-mail");
            String email = scanner.nextLine();
        /*Console console = System.console();
        System.out.println("console : " + console);
        char[] passwordArray = console.readPassword("Enter Password (invisible)");
        String password = String.valueOf(passwordArray);*/
            System.out.println("Enter Password");
            String password = scanner.nextLine();
            // System.out.println("Id : " + id + " , Name : " + name + " , E-mail :  " + email + ", Password :" + password);
            Customer customer = new Customer();
            customer.setId(id);
            customer.setName(name);
            customer.setEmail(email);
            customer.setPassword(password);
       /* CustomerRepository customerRepository = new CustomerRepository();
        CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepository);
        CustomerController customerController = new CustomerController(customerService);*/



            Customer savedCustomer = customerController.save(customer);
            System.out.println("Customer Registration Successful");
            System.out.println("Details:");
            System.out.println("Id : " + customer.getId());
            System.out.println("Name : " + customer.getName());
            System.out.println("E-mail : " + customer.getEmail());
            System.out.println("Password : " + customer.getPassword());

        } catch (CustomerExistsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            customerRegisterForm();
        }

    }

    public void displayMenuHeader(String menuHeader) {
        String dashesLine = new String(new char[150]).replace('\0', '-');
        System.out.println(dashesLine);
        String spaces = new String(new char[70]).replace('\0', ' ');
        System.out.printf("%-70s %-10s %-70s \n", spaces, menuHeader, spaces);
        System.out.println(dashesLine);
    }
}





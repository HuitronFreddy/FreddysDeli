package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Signature {
    public static void buildBLT(Builder builder){
        builder.setBreadSize(Bread_Size.EIGHT_INCH);
        builder.setBreadType(Bread.WHITE);
        builder.setMeatType(Meat.BACON);
        builder.setCheeseType(Cheese.CHEDDAR);
        builder.setRegularTopping(new ArrayList<>(List.of(Regular_Topping.LETTUCE, Regular_Topping.TOMATOES)));
        builder.setSaucesType(new ArrayList<>(List.of(Sauce.RANCH)));
        builder.isToasted(true);
    }
    public static void buildPhillyCheeseSteak(Builder builder){
        builder.setBreadSize(Bread_Size.EIGHT_INCH);
        builder.setBreadType(Bread.WHITE);
        builder.setMeatType(Meat.STEAK);
        builder.setCheeseType(Cheese.AMERICAN);
        builder.setRegularTopping(new ArrayList<>(List.of(Regular_Topping.PEPPERS)));
        builder.setSaucesType(new ArrayList<>(List.of(Sauce.MAYO)));
        builder.isToasted(true);
    }
}


package org.example;

public class DrinkBuilder {
    private DrinkSize size;
    private double price = 0.0;

    public void setDrink(DrinkSize size) {
        this.size = size;
        switch (size) {
            case SMALL:
                price = 2.00;
                break;
            case MEDIUM:
                price = 2.50;
                break;
            case LARGE:
                price = 3.00;
                break;
            default:
                price= 0;
                break;
        }
    }

    public Drink buildDrink() {
        return new Drink(size, price);
    }
}

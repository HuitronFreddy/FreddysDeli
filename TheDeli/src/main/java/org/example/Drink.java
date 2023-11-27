package org.example;

public class Drink {
    private DrinkSize size;
    private double price;



    public Drink(DrinkSize size, double price) {
        this.size = size;
        this.price = price;
    }

    public Drink() {

    }

    public DrinkSize getSize() {
        return size;
    }

    public void setSize(DrinkSize size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString(){
        return "Drink Size: "+ size+"\n"+"Price: "+price+"\n**\n";
    }
}

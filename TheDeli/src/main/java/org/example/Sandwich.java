package org.example;

public class Sandwich {

    private Bread breadType;
    private RegularTopping regularTopping;
    private Meat meatType;
    private Cheese cheeseType;
    private Sauce sauceType;
    private boolean isToasted;
    private final Side sideType;
    private BreadLength breadLength;
    private double price;

    public Sandwich(Bread breadType, RegularTopping regularTopping, Meat meatType, Cheese cheeseType, Sauce sauceType, boolean isToasted, Side sideType, BreadLength breadLength, double price) {
        this.breadType = breadType;
        this.regularTopping = regularTopping;
        this.meatType = meatType;
        this.cheeseType = cheeseType;
        this.sauceType = sauceType;
        this.isToasted = isToasted;
        this.sideType = sideType;
        this.breadLength = breadLength;
        this.price = price;
    }

    public Bread getBreadType() {
        return breadType;
    }

    public void setBreadType(Bread breadType) {
        this.breadType = breadType;
    }

    public RegularTopping getRegularTopping() {
        return regularTopping;
    }

    public void setRegularTopping(RegularTopping regularTopping) {
        this.regularTopping = regularTopping;
    }

    public Meat getMeatType() {
        return meatType;
    }

    public void setMeatType(Meat meatType) {
        this.meatType = meatType;
    }

    public Cheese getCheeseType() {
        return cheeseType;
    }

    public void setCheeseType(Cheese cheeseType) {
        this.cheeseType = cheeseType;
    }

    public Sauce getSauceType() {
        return sauceType;
    }

    public void setSauceType(Sauce sauceType) {
        this.sauceType = sauceType;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toeasted) {
        isToasted = toeasted;
    }

    public Side getSideType() {
        return sideType;
    }

    public BreadLength getBreadLength() {
        return breadLength;
    }

    public void setBreadLength(BreadLength breadLength) {
        this.breadLength = breadLength;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

package org.example;

public class SandwichBuilder implements Builder{

    private Bread breadType;
    private RegularTopping regularTopping;
    private Meat meatType;
    private Cheese cheeseType;
    private Sauce sauceType;
    private boolean isToasted;
    private Side sideType;
    private BreadLength breadLength;


    public void setBreadType(Bread breadType) {
        this.breadType = breadType;
    }


    public void setRegularTopping(RegularTopping regularTopping) {
        this.regularTopping = regularTopping;
    }


    public void setMeatType(Meat meatType) {
        this.meatType = meatType;
    }


    public void setCheeseType(Cheese cheeseType) {
        this.cheeseType = cheeseType;
    }


    public void setSauceType(Sauce sauceType) {
        this.sauceType = sauceType;
    }


    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public void setSideType(Side sideType) {
        this.sideType = sideType;
    }
    public void setBreadLength(BreadLength breadLength) {
        this.breadLength = breadLength;
    }
}

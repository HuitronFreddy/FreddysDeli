package org.example;

import java.util.List;
//Supriya
public class SandwichBuilder implements Builder{
    Sandwich sandwich = new Sandwich();

    private Bread_Size breadSize;
    private Bread bread;
    private Meat meat;
    private boolean hasExtraMeat;
    private Cheese cheese;
    private boolean hasExtraCheese;
    private List<Regular_Topping> regularTopping;
    private List<Sauce> sauce;
    private boolean toasted;
    private Side side;
    private double breadSizePrice;
    private double extraMeatPrice;
    private double extraCheesePrice;
    @Override
    public void setBreadType(Bread bread) {
        this.bread = bread;

    }

    @Override
    public void setRegularTopping(List<Regular_Topping> regularTopping) {
        this.regularTopping= regularTopping;

    }

    @Override
    public void setBreadSize(Bread_Size breadSize) {
        breadSizePrice = 0;
        this.breadSize = breadSize;
        switch (breadSize){
            case FOUR_INCH:
                breadSizePrice =5.50;
                break;
            case EIGHT_INCH:
                breadSizePrice = 7.00;
                break;
            case TWELVE_INCH:
                breadSizePrice = 8.50;
                break;
            default:
                breadSizePrice= 0;
        }
    }

    @Override
    public void setMeatType(Meat meat) {
        this.meat = meat;
    }

    @Override
    public void setCheeseType(Cheese cheese) {
        this.cheese = cheese;
    }

    @Override
    public void setSaucesType(List<Sauce> sauce) {
        this.sauce = sauce;
    }

    @Override
    public void setSideType(Side side) {
        this.side = side;
    }

    @Override
    public void isToasted(boolean toasted) {
        this.toasted = toasted;
    }

    @Override
    public void extraMeat(boolean hasExtraMeat, Bread_Size breadSize, int numberOfExtraMeat) {
        this.hasExtraMeat = hasExtraMeat;
        extraMeatPrice = 0;
        this.breadSize = breadSize;
        if (hasExtraMeat&& numberOfExtraMeat>0){
            switch (breadSize){
                case FOUR_INCH:
                    extraMeatPrice =0.50*numberOfExtraMeat;
                    break;
                case EIGHT_INCH:
                    extraMeatPrice = 1.00*numberOfExtraMeat;
                    break;
                case TWELVE_INCH:
                    extraMeatPrice = 1.50*numberOfExtraMeat;
                    break;
                default:
                    extraMeatPrice= 0;
                    break;
            }
        }

    }

    @Override
    public void extraCheese(boolean hasExtraCheese, Bread_Size breadSize, int numberOfExtraCheese) {
        this.hasExtraCheese = hasExtraCheese;
        extraCheesePrice = 0;
        this.breadSize = breadSize;
        if (hasExtraCheese && numberOfExtraCheese >0){
            switch (breadSize){
                case FOUR_INCH:
                    extraCheesePrice =0.30 * numberOfExtraCheese;
                    break;
                case EIGHT_INCH:
                    extraCheesePrice = 0.60 * numberOfExtraCheese;
                    break;
                case TWELVE_INCH:
                    extraCheesePrice = 0.90 * numberOfExtraCheese;
                    break;
                default:
                    extraCheesePrice = 0;
                    break;
            }
        }
    }
    public Sandwich buildSandwich(){
        sandwich.setBasePrice(breadSizePrice+extraMeatPrice+extraCheesePrice);
        return new Sandwich(breadSize,bread,meat,hasExtraMeat,cheese,hasExtraCheese,regularTopping,sauce,toasted,side,breadSizePrice,extraMeatPrice,extraCheesePrice, sandwich.getBasePrice());
    }
}

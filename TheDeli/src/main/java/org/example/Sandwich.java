package org.example;
//Supriya
import java.util.List;

public class Sandwich {
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
    private double basePrice;

    public Sandwich(Bread_Size breadSize, Bread bread, Meat meat, boolean hasExtraMeat, Cheese cheese, boolean hasExtraCheese, List<Regular_Topping> regularTopping, List<Sauce> sauce, boolean toasted, Side side, double breadSizePrice, double extraMeatPrice, double extraCheesePrice, double basePrice) {
        this.breadSize = breadSize;
        this.bread = bread;
        this.meat = meat;
        this.hasExtraMeat = hasExtraMeat;
        this.cheese = cheese;
        this.hasExtraCheese = hasExtraCheese;
        this.regularTopping = regularTopping;
        this.sauce = sauce;
        this.toasted = toasted;
        this.side = side;
        this.breadSizePrice = breadSizePrice;
        this.extraMeatPrice = extraMeatPrice;
        this.extraCheesePrice = extraCheesePrice;
        this.basePrice = basePrice;
    }

    public Sandwich() {

    }


    public void setBreadSize(Bread_Size breadSize) {
        this.breadSize = breadSize;
    }

    public double getBreadSizePrice() {
        return breadSizePrice;
    }

    public void setBreadSizePrice(double breadSizePrice) {
        this.breadSizePrice = breadSizePrice;
    }

    public double getExtraMeatPrice() {
        return extraMeatPrice;
    }

    public void setExtraMeatPrice(double extraMeatPrice) {
        this.extraMeatPrice = extraMeatPrice;
    }

    public double getExtraCheesePrice() {
        return extraCheesePrice;
    }

    public void setExtraCheesePrice(double extraCheesePrice) {
        this.extraCheesePrice = extraCheesePrice;
    }

    public Bread_Size getBreadSize() {
        return breadSize;
    }

    public Bread getBread() {
        return bread;
    }

    public Meat getMeat() {
        return meat;
    }

    public boolean isHasExtraMeat() {
        return hasExtraMeat;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public boolean isHadExtraCheese() {
        return hasExtraCheese;
    }

    public List<Regular_Topping> getRegularTopping() {
        return regularTopping;
    }

    public List<Sauce> getSauce() {
        return sauce;
    }

    public boolean isToasted() {
        return toasted;
    }

    public Side getSide() {
        return side;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
    public double calculateTotalPrice(){
        double total = basePrice;
        return total;
    }
    @Override
    public String toString(){
        return String.format("Bread: %s\nBreadSize: %s price: %.2f\nMeat: %s\nExtraMeat: %s price: %.2f\nCheese: %s\nExtraCheese: %s price: %.2f\nRegularTopping: %s\nSauce: %s\nSide: %s\nisToasted: %s\nTotalSandwichPrice: %.2f\n******************************************\n"
                ,bread,breadSize,breadSizePrice,meat,hasExtraMeat,extraMeatPrice,cheese,hasExtraCheese,extraCheesePrice,regularTopping,sauce,side,toasted,getBasePrice());
    }
}
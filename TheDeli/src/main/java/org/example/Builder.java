package org.example;

import java.util.List;

public interface Builder {
    void setBreadType(Bread bread);
    void setRegularTopping(List<Regular_Topping> regularTopping);
    void setBreadSize(Bread_Size breadSize);
    void setMeatType(Meat meat);
    void setCheeseType(Cheese cheese);
    void setSaucesType(List<Sauce> sauce);
    void setSideType(Side side);
    void isToasted(boolean toasted);
    void extraMeat(boolean hasExtraMeat,Bread_Size breadSize,int numberOfExtraMeat);
    void extraCheese(boolean hasExtraCheese, Bread_Size bredSize, int numberOfExtraCheese);


}

package org.example;
//Supriya
public class Chip {
    private double chipPrice;

    public double getChipPrice() {
        return chipPrice;
    }

    public void setChipPrice(double chipPrice) {
        this.chipPrice = chipPrice;
    }
    @Override
    public String toString(){
        return "Chip price: "+ getChipPrice()+"\n**************************\n";
    }
}

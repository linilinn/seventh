package com.example.seventh.data.datamodels;

public class DrinkModel {
    private String drink;
    private String drinkDescription;
    private int imageResource;

    public DrinkModel(String drink, String drinkDescription, int imageResource) {
        this.drink = drink;
        this.drinkDescription = drinkDescription;
        this.imageResource = imageResource;
    }

    public String getDrink() {
        return drink;
    }

    public String getDrinkDescription() {
        return drinkDescription;
    }

    public int getImageResource() {
        return imageResource;
    }
}

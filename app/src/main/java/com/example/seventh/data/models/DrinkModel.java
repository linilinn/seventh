package com.example.seventh.data.models;

public class DrinkModel {
    private int idDrink;
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

    public int getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(int idDrink) {
        this.idDrink = idDrink;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setDrinkDescription(String drinkDescription) {
        this.drinkDescription = drinkDescription;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }
}

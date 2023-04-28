package com.example.seventh.data.datamodels;

public class FoodModel {
    private String food;
    private String foodDescription;
    private int imageResource;

    public FoodModel(String food, String foodDescription, int imageResource) {
        this.food = food;
        this.foodDescription = foodDescription;
        this.imageResource = imageResource;
    }

    public String getFood() {
        return food;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public int getImageResource() {
        return imageResource;
    }
}

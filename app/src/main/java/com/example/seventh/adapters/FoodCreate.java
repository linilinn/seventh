package com.example.seventh.adapters;

public class FoodCreate {
    private String food;
    private String foodDescription;
    private int imageResource;

    public FoodCreate(String food, String foodDescription, int imageResource) {
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

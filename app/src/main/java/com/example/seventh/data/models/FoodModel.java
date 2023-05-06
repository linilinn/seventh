package com.example.seventh.data.models;

public class FoodModel {
    private int idFood;
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

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}

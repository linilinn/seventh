package com.example.seventh.data.databases.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.seventh.data.models.FoodModel;


@Entity(tableName = "food_table")
public class FoodEntity {
    @PrimaryKey(autoGenerate = true)
    private int idFood;
    private String food;
    private String foodDescription;
    private int imageResource;

    public FoodEntity(String food, String foodDescription, int imageResource) {
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

    public void setFood(String food) {
        this.food = food;
    }
    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public FoodModel toFood() {
        return new FoodModel(this.food, this.foodDescription, this.imageResource);
    }
}

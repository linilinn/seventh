package com.example.seventh.data.databases.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.seventh.data.models.DrinkModel;


@Entity(tableName = "drink_table")
public class DrinkEntity {
    @PrimaryKey(autoGenerate = true)
    private int idDrink;
    private String drink;
    private String drinkDescription;
    private int imageResource;

    public DrinkEntity(String drink, String drinkDescription, int imageResource) {
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

    public void setDrink(String drink) {
        this.drink = drink;
    }
    public void setDrinkDescription(String drinkDescription) {
        this.drinkDescription = drinkDescription;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }
    public DrinkModel toDrink() {
        return new DrinkModel(this.drink, this.drinkDescription, this.imageResource);
    }

    public int getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(int idDrink) {
        this.idDrink = idDrink;
    }
}

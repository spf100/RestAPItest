package com.example.restapitest.model;

import androidx.annotation.NonNull;
import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class FoodConverter {
    Type type = new TypeToken<List<Entry.Food>>(){}.getType();

    @TypeConverter
    public String fromFoodList(@NonNull List<Entry.Food> foods){
        Gson gson = new Gson();
        Object src;
        String json = gson.toJson(foods, type);
        return json;
    }

    @TypeConverter
    public List<Entry.Food> toFoodList(@NonNull String foodsString){
        Gson gson = new Gson();
        List<Entry.Food> foods = gson.fromJson(foodsString, type);
        return foods;
    }
}

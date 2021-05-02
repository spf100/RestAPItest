package com.example.restapitest.model;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultDTO {
    public final int id;
    public final String brandname;
    public final String name;
    public final Double kilocal;

    public SearchResultDTO(int id, String brandname, String name, Double kilocal){
        this.id = id;
        this.brandname = brandname;
        this.name = name;
        this.kilocal = kilocal;
    }

    public static SearchResultDTO parseFood(SearchResultPOJO.FDCFood food){
        return new SearchResultDTO(
                food.getFdcID(),
                food.getBrandOwner(),
                food.getDescription(),
                food.getFoodNutrients()
                .stream()
                .filter( v -> v.getNutrientsID() == SearchResultPOJO.NUTRIENTS.KiloCal.code)
                .map(v -> v.getValue())
                .findFirst()
                .orElse(null)

        );
    }
    public static List<SearchResultDTO> parsePojo(SearchResultPOJO pojo){
        return pojo.getFoods()
                .stream()
                .map(SearchResultDTO::parseFood)
                .collect(Collectors.toList());
    }


}

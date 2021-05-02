package com.example.restapitest.service;
import com.example.restapitest.model.SearchResultPOJO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface IFDCService {
    @GET("/fdc/v1/foods/search")
    Call<SearchResultPOJO> searchFood(@Query("api_key") String key, @Query("query") String foodname);
}

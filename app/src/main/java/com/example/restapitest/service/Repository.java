package com.example.restapitest.service;

import android.app.Application;
import android.util.Log;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.android.volley.Response;
import com.example.restapitest.FoodItemAdapter;
import com.example.restapitest.RoomDB;
import com.example.restapitest.model.Entry;
import com.example.restapitest.model.EntryDAO;
import com.example.restapitest.model.SearchResultDTO;
import com.example.restapitest.model.SearchResultPOJO;

import java.util.List;
import java.util.concurrent.ExecutorService;

import javax.security.auth.callback.Callback;

import retrofit2.Call;

public class Repository {
    private final EntryDAO mEntryDao;
    private final LiveData<List<Entry>> mAllEntries;
    private final ExecutorService DBwriter = RoomDB.getDatabaseWriter();

    public Repository(Application application){
        RoomDB DB = RoomDB.getDatabase(application);
        this.mEntryDao = DB.entryDAO();
        this.mAllEntries = mEntryDao.getEntriesByTime();
    }

    public LiveData<List<Entry>> getmAllEntries(){return mAllEntries;}
    public void deleteAllEntries(){ DBwriter.submit(mEntryDao::deleteAll);}
    public void insert(Entry entry){ DBwriter.execute(() -> mEntryDao.insert(entry)); }
    public static void searchFood(String food, FoodItemAdapter adapter){
        FDCService.searchFood(food).enqueue(new Callback<SearchResultPOJO>() {
            @Override
            public void onResponse(@NotNull Call<SearchResultPOJO> call, @NotNull Response<SearchResultPOJO> response) {
                Log.d("search", "Success");
                adapter.setItems(SearchResultDTO.parsePojo(response.body()));
            }

            @Override
            public void OnFailure(@NotNull Call<SearchResultPOJO> call, @NotNull Throwable t) {
                Log.d("search", "failure");
                Log.d("search", call.request().toString());
            }
        });
    }
}

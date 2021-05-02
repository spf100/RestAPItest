package com.example.restapitest.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.OnConflictStrategy;

import java.util.List;


@Dao
public interface EntryDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Entry entry);

    @Query("DELETE FROM entries")
    void deleteAll();

    @Query("SELECT * FROM entries ORDER BY timestamp")
    LiveData<List<Entry>> getEntriesByTime();
}

package com.example.restapitest;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.restapitest.model.Entry;
import com.example.restapitest.model.EntryDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = Entry.class, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    public abstract EntryDAO entryDAO();

    private static volatile RoomDB INSTANCE;
    private static final int NumberOfThreads = 4;
    static final ExecutorService databaseWriter = Executors.newFixedThreadPool(NumberOfThreads);

    public static RoomDB getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (RoomDB.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), RoomDB.class, "database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static ExecutorService getDatabaseWriter(){return databaseWriter;}
}

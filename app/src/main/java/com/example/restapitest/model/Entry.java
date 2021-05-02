package com.example.restapitest.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "entries")
public class Entry {
    public static class Food {
        private String name;
        private int kilocal;
        private double grams;

        public String getName() { return name; }
        public void setName(String name){ this.name = name;}
        public int getKilocal(){return kilocal;}
        public void setKilocal(int kilocal){this.kilocal = kilocal;}
        public double getGrams(){return grams;}
        public void setGrams(double grams){this.grams = grams;}
        public Food(String name, int kilocal, double grams){
            setName(name);
            setKilocal(kilocal);
            setGrams(grams);
        }
        @NonNull
        @Override
        public String toString(){
            StringBuilder builder = new StringBuilder();

            builder.append("( ")
                    .append(getName()).append(' ')
                    .append(getKilocal()).append(' ')
                    .append(getGrams()).append(' ')
                    .append(')');
            return builder.toString();
        }
    }
}

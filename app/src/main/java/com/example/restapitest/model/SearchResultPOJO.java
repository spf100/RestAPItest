package com.example.restapitest.model;

public class SearchResultPOJO {
    public static class FDCFood{
        public static class Nutrients{
            int nutrientID;
            int number;
            String name;
            double value;

            public Nutrients(int nutrientID, int number, String name, double value){this.nutrientID = nutrientID; this.number = number; this.name = name; this.value = value;}

            public int getNutrientID() {
                return nutrientID;
            }
            public void setName(String Name){
                this.name = name;
            }

            public int getNumber(){
                return number;
            }
            public String getName(){
                return name;
            }





        }
    }
}

package com.example.restapitest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restapitest.model.Entry;
import com.example.restapitest.model.SearchResultDTO;

import java.util.ArrayList;
import java.util.List;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.FooditemHolder>{
    class FooditemHolder extends RecyclerView.ViewHolder{
        private TextView foodname;
        private TextView brandname;
        private TextView kilocal;

        public FooditemHolder(@NonNull View itemView){
            super(itemView);
            foodname = itemView.findViewById();
            brandname = itemView.findViewById();
            kilocal = itemView.findViewById();
        }
    }
    public interface ItemClickListener{
        void onItemClick(View view);
    }

    private List<SearchResultDTO> items = new ArrayList<>();
    private ItemClickListener itemClickListener;

    public FoodItemAdapter(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }
    @NonNull
    @Override
    public FooditemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(LAYOUTNAME, parent, false);
        return new FooditemHolder(itemView);
    }

    @Override
    public void onBindviewHolder(@NonNull FooditemHolder holder, int position){
        SearchResultDTO currentItem = items.get(position);
        holder.foodname.setText(currentItem.name);
        holder.brandname.setText(currentItem.brandname);
        holder.kilocal.setText(currentItem.kilocal == null? "N/A" : String.valueOf(currentItem.kilocal.intValue()));
        holder.itemView.setOnClickListener(itemClickListener::onItemClick);
    }

    @Override
    public int getItemCount(){ return items.size();}

    public void setItems(List<SearchResultDTO> items){
        this.items = items;
        notifyDataSetChanged();
    }
}

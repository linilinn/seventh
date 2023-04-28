package com.example.seventh.ui.adapters;

import static android.app.PendingIntent.getActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seventh.R;
import com.example.seventh.ui.FoodModel;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private List<FoodModel> foodModelList;


    public FoodAdapter(List<FoodModel> foodList) {
        this.foodModelList = foodList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FoodModel foodModel = foodModelList.get(position);
        holder.textView.setText(foodModel.getFood());
        holder.imageView.setImageResource(foodModel.getImageResource());
        holder.itemView.setOnClickListener(view -> {
            Bundle bundle3 = new Bundle();
            bundle3.putString("item", foodModel.getFood());
            bundle3.putString("description", foodModel.getFoodDescription());
            Navigation.findNavController(view).navigate(R.id.action_food_to_item, bundle3);
        });
    }

    @Override
    public int getItemCount() {
        return foodModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView13);
            imageView = (ImageView) itemView.findViewById(R.id.imageView4);
        }
    }
}
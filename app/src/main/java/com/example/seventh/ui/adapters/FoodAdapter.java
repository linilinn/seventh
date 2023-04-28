package com.example.seventh.ui.adapters;

import static android.app.PendingIntent.getActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seventh.R;
import com.example.seventh.data.datamodels.FoodModel;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private List<FoodModel> food;
    private LayoutInflater inflater;
    private Context context;

    public FoodAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.food = new ArrayList<>();
        this.context = context;
    }

    @Override
    @NonNull
    public FoodAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.food_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FoodModel foodModel = food.get(position);
        holder.textView.setText(foodModel.getFood());
        holder.imageView.setImageResource(foodModel.getImageResource());
        holder.itemView.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("item", foodModel.getFood());
            bundle.putString("description", foodModel.getFoodDescription());
            Navigation.findNavController(view).navigate(R.id.action_food_to_item, bundle);
        });
    }

    @Override
    public int getItemCount() {
        return food.size();
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

    public void updateFood(List<FoodModel> food) {
        this.food.clear();;
        this.food = food;
        notifyDataSetChanged();
    }
}
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
import com.example.seventh.data.models.DrinkModel;

import java.util.ArrayList;
import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.ViewHolder> {
    private List<DrinkModel> drinks;
    private LayoutInflater inflater;
    private Context context;

    public DrinkAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.drinks = new ArrayList<>();
        this.context = context;
    }

    @Override
    @NonNull
    public DrinkAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.drink_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DrinkModel drinkModel = drinks.get(position);
        holder.textView.setText(drinkModel.getDrink());
        holder.imageView.setImageResource(drinkModel.getImageResource());
        holder.itemView.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("item", drinkModel.getDrink());
            bundle.putString("description", drinkModel.getDrinkDescription());
            Navigation.findNavController(view).navigate(R.id.action_drink_to_item, bundle);
        });
    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView12);
            imageView = (ImageView) itemView.findViewById(R.id.imageView6);
        }
    }

    public void updateDrinks(List<DrinkModel> drinks) {
        this.drinks.clear();;
        this.drinks = drinks;
        notifyDataSetChanged();
    }
}
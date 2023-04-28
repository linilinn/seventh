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
import com.example.seventh.data.datamodels.DrinkModel;

import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.ViewHolder> {
    private List<DrinkModel> drinkModelList;


    public DrinkAdapter(List<DrinkModel> drinkList) {
        this.drinkModelList = drinkList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drink_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DrinkModel drinkModel = drinkModelList.get(position);
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
        return drinkModelList.size();
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
}
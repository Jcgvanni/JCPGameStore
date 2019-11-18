package com.example.jcpgamestore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> implements Filterable {

    private ArrayList<DataGame> dataSet;
    //copy of the dataset for the search function
    private ArrayList<DataGame> dataSetFull;

    public CustomAdapter(ArrayList<DataGame> data){
        this.dataSet = data;
        dataSetFull = new ArrayList<>( data );
    }

    //Filter the data to search
    @Override
    public Filter getFilter() {
        return dataFilter;
    }

    private Filter dataFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<DataGame> filteredList = new ArrayList<>(  );

            if (charSequence == null|| charSequence.length() == 0 ){
                filteredList.addAll( dataSetFull );
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for (DataGame item: dataSetFull){
                    if (item.getGameName().toLowerCase().contains( filterPattern )){
                        filteredList.add( item );
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            dataSet.clear();
            dataSet.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };







    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        myView.setOnClickListener(MainActivity.myOnClickListener);
        MyViewHolder myViewHolder = new MyViewHolder(myView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        TextView txtGameName = holder.txtGameName;
        TextView txtGamePrice = holder.txtGamePrice;
        ImageView imgGames = holder.imgGame;
        Button btnCart = holder.btnCart;
        Spinner qtySpinner = holder.qtySpinner;




        txtGameName.setText(dataSet.get(position).getGameName());
        txtGamePrice.setText(dataSet.get(position).getGamePrice());
        imgGames.setImageResource(dataSet.get(position).getImage());


    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtGameName;
        TextView txtGamePrice;
        ImageView imgGame;
        Button btnCart;
        Spinner qtySpinner;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtGameName = itemView.findViewById(R.id.txtGameName);
            this.txtGamePrice = itemView.findViewById(R.id.txtGamePrice);
            this.imgGame = itemView.findViewById(R.id.imgGame);
            this.btnCart = itemView.findViewById(R.id.btnCart);
            this.qtySpinner = itemView.findViewById(R.id.qtySpinner);
        }
    }
}



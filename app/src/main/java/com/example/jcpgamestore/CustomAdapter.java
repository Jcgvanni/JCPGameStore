package com.example.jcpgamestore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import com.example.jcpgamestore.model.Cart;
import com.example.jcpgamestore.model.DataGame;
import com.example.jcpgamestore.model.User;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> implements Filterable {

    private ArrayList<DataGame> dataSet;
    //copy of the dataset for the search function
    private ArrayList<DataGame> dataSetFull;

    private User user;

    public ArrayList<Cart> getCarts() {
        return carts;
    }

    private ArrayList<Cart> carts = new ArrayList<>();

    public void setUser(User user) {
        this.user = user;
    }

    public CustomAdapter(ArrayList<DataGame> data){
        dataSet = data;
        dataSetFull = new ArrayList<>( data );
    }

    public void updateDataSet(List<DataGame> data) {
        dataSet.clear();
        dataSet.addAll( data );
        dataSetFull = new ArrayList<>( data );

        this.notifyDataSetChanged();
    }

    public void cleanCart() {
        carts.clear();
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
        //myView.setOnClickListener(MainActivity.myOnClickListener);
        MyViewHolder myViewHolder = new MyViewHolder(myView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomAdapter.MyViewHolder holder, final int position) {
        TextView txtGameName = holder.txtGameName;
        TextView txtGamePrice = holder.txtGamePrice;
        ImageView imgGames = holder.imgGame;
        Button btnCart = holder.btnCart;
        btnCart.setId( position );
        final Spinner qtySpinner = holder.qtySpinner;


        txtGameName.setText(dataSet.get(position).getGameName());
        txtGamePrice.setText(dataSet.get(position).getPrice().toString());
        imgGames.setImageResource(dataSet.get(position).getImage());

        btnCart.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DataGame product = dataSet.get( position);


                //add only the quantity to the cart
                for (Cart cart: carts){
                    if (cart.getProduct().getId()==product.getId()){
                        Double qty = 0.00;
                        qty = cart.getQuantity() + Double.parseDouble(qtySpinner.getSelectedItem().toString());
                        cart.setQuantity( qty );
                        return;
                    }
                }

                Cart cart = new Cart();
                cart.setUser( user );
                cart.setUserId( user.getId() );
                cart.setProduct( product );
                cart.setProductId( product.getId() );
                cart.setQuantity(Double.parseDouble(qtySpinner.getSelectedItem().toString()));
                carts.add( cart );
            }
        } );

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



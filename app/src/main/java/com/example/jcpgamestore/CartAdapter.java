package com.example.jcpgamestore;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder > {

    Context context;
    List<CartAdapter> cartAdapterList;

    public CartAdapter(Context context, List<CartAdapter> cartAdapterList) {
        this.context = context;
        this.cartAdapterList = cartAdapterList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from( context ).inflate( R.layout.cart_item_layout, parent, false );
        return new CartViewHolder( itemView );
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return cartAdapterList.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {

         public CartViewHolder(@NonNull View itemView) {
            super( itemView );
        }
    }

    ImageView img_product;
    TextView txtGameName, txtPrice;
    Spinner txtAmount;

    public CartAdapter(@NonNull View itemView) {
        txtAmount = (Spinner)itemView.findViewById( R.id.qtySpinner );
        txtGameName = (TextView)itemView.findViewById( R.id.txtGameName );
        txtPrice = (TextView)itemView.findViewById( R.id.txtGamePrice );
        img_product = (ImageView)itemView.findViewById( R.id.imgGame );



    }


}

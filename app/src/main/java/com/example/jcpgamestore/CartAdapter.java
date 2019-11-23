package com.example.jcpgamestore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.jcpgamestore.model.Cart;


import java.util.ArrayList;

public class CartAdapter extends Adapter<CartAdapter.CartViewHolder> {

    private ArrayList<Cart> items;

    public CartAdapter(ArrayList<Cart> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cartView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout, parent, false);
        CartViewHolder cartViewHolder = new CartViewHolder(cartView);
        return cartViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Cart cart = items.get( position );
        TextView txtGameName = holder.txtGameName;
        TextView qty = holder.qty;
        TextView amount = holder.itemAmount;


        txtGameName.setText(cart.getProduct().getGameName());
        qty.setText( cart.getQuantity().toString());
        amount.setText(cart.calculateTotal().toString());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder{
        TextView txtGameName;
        TextView qty;
        TextView itemAmount;


        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtGameName = itemView.findViewById(R.id.txtGameName);
            this.qty = itemView.findViewById(R.id.txtViewQty);
            this.itemAmount = itemView.findViewById( R.id.txtViewAmount );
        }
    }
}

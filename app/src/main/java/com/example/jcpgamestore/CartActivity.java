package com.example.jcpgamestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.jcpgamestore.model.Cart;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    RecyclerView recyclerCart;
    Button btnPlaceOrder;
    ArrayList<Cart> cartArrayList = new ArrayList<>(  );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cart );
        cartArrayList = (ArrayList<Cart>) getIntent().getSerializableExtra("CART");

    }
}

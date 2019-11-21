package com.example.jcpgamestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

public class CartActivity extends AppCompatActivity {

    RecyclerView recyclerCart;
    Button btnPlaceOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cart );
    }
}

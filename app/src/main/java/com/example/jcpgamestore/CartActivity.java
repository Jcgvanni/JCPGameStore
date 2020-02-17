package com.example.jcpgamestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jcpgamestore.model.Cart;
import com.example.jcpgamestore.model.User;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private CartAdapter cartAdapter;
    private RecyclerView cartRecycler;
    private RecyclerView.LayoutManager layoutManager;
    private Button btnPlaceOrder;
    private ArrayList<Cart> cartArrayList = new ArrayList<>(  );
    private TextView totalAmount;
    private TextView shipment;
    private TextView totalOrder;
    private String TotalOrder;
    private String loggedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cart );
        cartArrayList = (ArrayList<Cart>) getIntent().getSerializableExtra("CART");
        loggedUser = getIntent().getStringExtra( "USER" );
        btnPlaceOrder = findViewById( R.id.btnPlaceOrder );
        cartRecycler = findViewById( R.id.recyclerCart );
        layoutManager = new LinearLayoutManager( this );
        cartRecycler.setLayoutManager( layoutManager );

        cartAdapter = new CartAdapter( cartArrayList );
        cartRecycler.setAdapter( cartAdapter );

        totalAmount = findViewById( R.id.txtTotalAmount );
        calculateTotal();
        shipment = findViewById(R.id.shipping);
        calculateShipment();
        totalOrder = findViewById(R.id.txtOrderTotal);
        calculateOrderTotal();


        //When placing an order, it resets the cart. So you can place an order again with the same user.
        btnPlaceOrder.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                Intent checkoutIntent = new Intent( CartActivity.this, CreditCardActivity.class );
                TotalOrder = totalOrder.getText(  ).toString();
                checkoutIntent.putExtra( "TOTAL_ORDER", TotalOrder );
                checkoutIntent.putExtra( "USER", loggedUser );

                startActivity( checkoutIntent );
                finish();

                } catch (Exception ex){
                    Log.e( "JCP GameStore", ex.getMessage() );
                }

            }
        } );
    }


    private void calculateTotal() {
        Double total = new Double( 0 );

        for (Cart cart: cartArrayList) {
            total = total + cart.calculateTotal();
        }
        DecimalFormat df = new DecimalFormat("C$ #.##");
        totalAmount.setText( df.format(total) );
    }
    private void calculateShipment(){
        Double total = new Double(0);
        for (Cart cart: cartArrayList){
            total += (cart.calculateTotal() * 0.1);
        }
        DecimalFormat df = new DecimalFormat("C$ #.##");
        shipment.setText( df.format(total) );
    }
    private void calculateOrderTotal(){
        Double total = new Double(0);
        Double  cost = 0.0;
        for (Cart cart: cartArrayList){
            total = (cart.calculateTotal());
            cost += (total * 0.1) + total;
        }
        DecimalFormat df = new DecimalFormat("C$ #.##");
        totalOrder.setText( df.format(cost) );
    }

}

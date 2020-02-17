package com.example.jcpgamestore;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

public class CheckOutActivity extends AppCompatActivity {


    String TotalOrder;
    String loggedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_check_out );

        final TextView txtViewOutput = findViewById( R.id.txtViewOutput );
        Intent myIntent = getIntent();

        try{
            if( myIntent != null ){
                TotalOrder = myIntent.getStringExtra( "TOTAL_ORDER" );
                loggedUser = myIntent.getStringExtra( "USER" );
                String outputStr = "Hello " + loggedUser + " .Thank you for shopping with us. Your total is " + TotalOrder;
                txtViewOutput.setText( outputStr );
                txtViewOutput.setGravity( Gravity.CENTER_HORIZONTAL );
                txtViewOutput.setPadding( 8,8,8,8 );
            }
        } catch(Exception ex){
            Log.e("JCP GameStore", ex.getMessage());    
        }
    }
}

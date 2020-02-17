package com.example.jcpgamestore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.braintreepayments.cardform.view.CardForm;

public class CreditCardActivity extends AppCompatActivity {

    String orderTotal, userName;
    CardForm cardForm;
    Button btnCCPay;
    AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_credit_card );

        Intent intent = getIntent();
        orderTotal = getIntent().getStringExtra( "TOTAL_ORDER" );
        userName = getIntent().getStringExtra( "USER" );

        cardForm = findViewById( R.id.card_form );
        btnCCPay = findViewById( R.id.btn_creditcard );
        cardForm.cardRequired( true ).expirationRequired( true ).cvvRequired( true ).postalCodeRequired( true ).mobileNumberRequired( true ).mobileNumberExplanation( "SMS is required on this number" ).setup( CreditCardActivity.this );
        cardForm.getCvvEditText().setInputType( InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        btnCCPay.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardForm.isValid()){
                    Intent cardIntent = new Intent(CreditCardActivity.this, CheckOutActivity.class);
                    cardIntent.putExtra( "TOTAL_ORDER", orderTotal );
                    cardIntent.putExtra( "USER", userName );
                    startActivity( cardIntent );

                } else {
                    Toast.makeText( CreditCardActivity.this, "Please complete the form", Toast.LENGTH_SHORT ).show();
                }
            }
        } );


    }
}

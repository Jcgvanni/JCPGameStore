package com.example.jcpgamestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SignupFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_signup_form );

        final Button btnSignUpForm = findViewById( R.id.btnSignUp );
        final EditText editFistName = findViewById( R.id.editTxtFName );
        final EditText editLastName = findViewById( R.id.editTxtLName );
        final EditText editEmail = findViewById( R.id.editTxtEmail );
        final EditText editPass = findViewById( R.id.editTxtPassword );
        final TextView loginTextView = findViewById( R.id.loginTxtView );

        btnSignUpForm.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupFormActivity.this, LoginActivity.class  );
                startActivity( intent );
            }
        } );

        loginTextView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( SignupFormActivity.this, LoginActivity.class );
                startActivity( intent );
            }
        } );






    }
}

package com.example.jcpgamestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jcpgamestore.model.User;

public class SignupFormActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_signup_form );


        final Button btnSignUpForm = findViewById( R.id.btnSignUp );
        final EditText editFullName = findViewById( R.id.editTxtFName );
        final EditText editAddress = findViewById( R.id.editTxtAddress );
        final EditText editEmail = findViewById( R.id.editTxtEmail );
        final EditText editPass = findViewById( R.id.editTxtPassword );
        final TextView loginTextView = findViewById( R.id.loginTxtView );

        final DatabaseHelper myDb = DatabaseHelper.getInstance(this);


        btnSignUpForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editEmail.getText().toString().isEmpty()) {
                    Toast.makeText(SignupFormActivity.this, "Email is empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (editPass.getText().toString().isEmpty()) {
                    Toast.makeText(SignupFormActivity.this, "Password is empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (editAddress.getText().toString().isEmpty()) {
                    Toast.makeText(SignupFormActivity.this, "Address is empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (editFullName.getText().toString().isEmpty()) {
                    Toast.makeText(SignupFormActivity.this, "Full Name is empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Verify if the email already exists
                if( myDb.findByEmail( editEmail.getText().toString() ) != null) {
                    Toast.makeText(SignupFormActivity.this, "Email already exists", Toast.LENGTH_SHORT).show();
                    return;
                }

                User user = new User();
                user.setEmail( editEmail.getText().toString() );
                user.setFullName( editFullName.getText().toString() );
                user.setPassword( editPass.getText().toString() );
                user.setAddress( editAddress.getText().toString() );

                boolean isInserted = myDb.addUserData(user);
                if (isInserted = true){
                    Toast.makeText(SignupFormActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignupFormActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(SignupFormActivity.this, LoginActivity.class  );
                startActivity( intent );
            }
        });


        loginTextView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( SignupFormActivity.this, LoginActivity.class );
                startActivity( intent );
            }
        } );








    }
}

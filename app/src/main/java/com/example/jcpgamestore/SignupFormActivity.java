package com.example.jcpgamestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SignupFormActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_signup_form );


        final Button btnSignUpForm = findViewById( R.id.btnSignUp );
        final EditText editFullName = findViewById( R.id.editTxtFName );
        final EditText editAddress = findViewById( R.id.editTxtLName );
        final EditText editEmail = findViewById( R.id.editTxtEmail );
        final EditText editPass = findViewById( R.id.editTxtPassword );
        final TextView loginTextView = findViewById( R.id.loginTxtView );
        //
        final DatabaseHelper myDb;
        myDb = DatabaseHelper.getInstance(this);


            btnSignUpForm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean isInserted = myDb.addUserData(editFullName.getText().toString(),
                            editEmail.getText().toString(),
                            editAddress.getText().toString(),
                            editPass.getText().toString());
                    if (isInserted = true){
                        Toast.makeText(SignupFormActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignupFormActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            Intent intent = new Intent(SignupFormActivity.this, LoginActivity.class  );
            startActivity( intent );



        loginTextView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( SignupFormActivity.this, LoginActivity.class );
                startActivity( intent );
            }
        } );








    }
}

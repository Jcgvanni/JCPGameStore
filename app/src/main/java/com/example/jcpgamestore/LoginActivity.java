package com.example.jcpgamestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jcpgamestore.model.User;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class LoginActivity extends AppCompatActivity {

    Button loginBtn;
    TextView signUpTV;

    EditText loginEdit;
    EditText passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );


        loginBtn = findViewById( R.id.btnLogin );
        signUpTV = findViewById( R.id.signUpTxtView );

        loginEdit = findViewById( R.id.username );
        passwordEdit = findViewById( R.id.password );

        final DatabaseHelper myDb = DatabaseHelper.getInstance(this);

        loginBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (loginEdit.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Email is empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (passwordEdit.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Password is empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                User user = myDb.findByEmail( loginEdit.getText().toString() );

                if ( user == null || !user.getPassword().equals( passwordEdit.getText().toString().toLowerCase())) {
                    Toast.makeText(LoginActivity.this, "Email or password invalid", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent( LoginActivity.this, MainActivity.class );
                intent.putExtra( "USER", user );
                startActivity( intent );
            }
        } );

        signUpTV.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( LoginActivity.this, SignupFormActivity.class);
                startActivity( intent );
            }
        } );

    }
}

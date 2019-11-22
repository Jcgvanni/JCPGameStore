package com.example.jcpgamestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    //Google Sign In
    int RC_SIGN_IN = 0;
    SignInButton signInButton;

    GoogleSignInClient mGoogleSignInClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        //Initializing Button
        signInButton =findViewById( R.id.sign_in_button );
        signInButton.setSize(SignInButton.SIZE_STANDARD);

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient( this, gso );

        signInButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        } );



        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        // Set the dimensions of the sign-in button.



        loginBtn = findViewById( R.id.btnLogin );
        signUpTV = findViewById( R.id.signUpTxtView );

        loginBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( LoginActivity.this, MainActivity.class );
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
    //Google SignIn
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult( signInIntent, RC_SIGN_IN );
    }

    //Google SignIn
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult( requestCode,resultCode, data );

        if (requestCode == RC_SIGN_IN){
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent( data );
            handleSignInResult(task);
        }
    }
    //Google SignIn
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult( ApiException.class );
            startActivity( new Intent( LoginActivity.this,MainActivity.class ) );
        } catch (Exception ex){
            Log.e("GOOGLE SIGN IN ERROR", ex.getMessage());
            Toast.makeText( LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show() ;
        }

    }

    protected void onStart(){
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount( this );
        if (account!=null){
            startActivity( new Intent( LoginActivity.this, MainActivity.class ) );
        }
        super.onStart();
    }


}

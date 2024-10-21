package com.example.ayusensei2;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class SecondActivity extends AppCompatActivity {

    private GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondpage); // Make sure you have created secondpage.xml layout

        // Configure Google Sign-In options
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id)) // Automatically uses the ID from google-services.json
                .requestEmail()
                .build();


        // Create a GoogleSignInClient instance
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Find the SignIn button and set the click listener
        Button signInButtonWithGoogle = findViewById(R.id.signUpWithGoogle);

        Button signInButtonWithEmail = findViewById(R.id.signUpWihtEmail);
        signInButtonWithGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInWithGoogle();
            }
        });

        signInButtonWithEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInWithEmail(view); // Pass the view to the method
            }
        });
    }

    public void signInWithEmail(View view) {
        Intent intent = new Intent(this, signupPage.class); // Use the correct class name
        startActivity(intent);
    }

    // Start the sign-in process
    private void signInWithGoogle() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI
            updateUI(account);
        } catch (ApiException e) {
            // Sign in failed, handle error
            updateUI(null);
        }
    }

    private void updateUI(GoogleSignInAccount account) {
        if (account != null) {
            // User is signed in
            String welcomeMessage = "Welcome, " + account.getDisplayName() + "!";
            // You can display this message in a TextView or log it
        } else {
            // User is not signed in
        }
    }
}

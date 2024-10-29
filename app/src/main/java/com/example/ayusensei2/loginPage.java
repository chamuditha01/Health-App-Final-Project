package com.example.ayusensei2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class loginPage extends AppCompatActivity {

    TextView floatingLabel;
    TextView floatingLabel1;

    private EditText txtLoginEmail;
    private TextView emailValidationMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginwithemail); // Make sure you're setting the correct layout file

        // Find the button by its ID and set up a click listener
        Button btnsignupurl = findViewById(R.id.btnsignupurl); // Ensure this matches your Button ID

        btnsignupurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSignupUrl(view); // Pass the view to the method
            }
        });

        Button btnfogotpwurl = findViewById(R.id.btnlforgotpwurl); // Ensure this matches your Button ID

        btnfogotpwurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onforgotpwUrl(view); // Pass the view to the method
            }
        });

        Button btnlogin = findViewById(R.id.btnlogin1); // Ensure this matches your Button ID

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclicklogin(view); // Pass the view to the method
            }
        });



        EditText editText = findViewById(R.id.txtloginemail);
        EditText editText1 = findViewById(R.id.txtloginpw);
        floatingLabel = findViewById(R.id.floatingLabel);
        floatingLabel1 = findViewById(R.id.floatingLabel1);
        txtLoginEmail = findViewById(R.id.txtloginemail);


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No action needed here
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Show the floating label when typing
                if (s.length() > 0) {
                    showFloatingLabel(floatingLabel); // Show label immediately when typing
                } else {
                    hideFloatingLabel(floatingLabel); // Hide label if the field is empty
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                // No action needed here
            }
        });

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No action needed here
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Show the floating label when typing
                if (s.length() > 0) {
                    showFloatingLabel(floatingLabel1); // Show label immediately when typing
                } else {
                    hideFloatingLabel(floatingLabel1); // Hide label if the field is empty
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // No action needed here
            }
        });




// Function to show the floating label with animation

        // Enable the back button in the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


    }

    // Function to show the floating label with animation
    private void showFloatingLabel(TextView label) {
        if (label.getVisibility() != View.VISIBLE) {
            label.setVisibility(View.VISIBLE);
            label.animate().translationY(-40).alpha(1).setDuration(200).start(); // Adjust -40 as needed
        }
    }

    // Function to hide the floating label with animation
    private void hideFloatingLabel(TextView label) {
        if (label.getVisibility() == View.VISIBLE) {
            label.animate().translationY(0).alpha(0).setDuration(200).withEndAction(() -> {
                label.setVisibility(View.GONE);
            }).start();
        }
    }
    public void onSignupUrl(View view) {
        Intent intent = new Intent(this, signupPage.class); // Use the correct class name
        startActivity(intent);
    }

    public void onforgotpwUrl(View view) {
        Intent intent = new Intent(this, fpinputemail.class); // Use the correct class name
        startActivity(intent);
    }

    public void onclicklogin(View view) {
        Intent intent = new Intent(this, btmNavMainClass.class); // Use the correct class name
        startActivity(intent);
    }

    // In your Activity class
    backButtonFunction backButtonFunction = new backButtonFunction(this);

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return backButtonFunction.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

}

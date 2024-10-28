package com.example.ayusensei2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class signupPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupwithemail); // Make sure you're setting the correct layout file

        // Enable the back button in the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    backButtonFunction backButtonFunction = new backButtonFunction(this);

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return backButtonFunction.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }


}

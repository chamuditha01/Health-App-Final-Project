package com.example.ayusensei2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class fpinputemail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fpinputemailui); // Make sure you're setting the correct layout file
        Button btnsendcode = findViewById(R.id.btnsendcode); // Ensure this matches your Button ID

        btnsendcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onverifycodeinput(view); // Pass the view to the method
            }
        });
        // Enable the back button in the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }


    public void onverifycodeinput(View view) {
        Intent intent = new Intent(this, fpvcodeinput.class); // Use the correct class name
        startActivity(intent);
    }

    backButtonFunction backButtonFunction = new backButtonFunction(this);

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return backButtonFunction.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }


}

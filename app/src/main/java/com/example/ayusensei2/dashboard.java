package com.example.ayusensei2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboardui); // Make sure you're setting the correct layout file


        Button BCC =findViewById(R.id.btnBCC);


        // Enable the back button in the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }


    public void onclickprofile(View view) {
        Intent intent = new Intent(this, profileUi.class); // Use the correct class name
        startActivity(intent);
    }

    public void onclickdashboard(View view) {
        Intent intent = new Intent(this, dashboard.class); // Use the correct class name
        startActivity(intent);
    }
    backButtonFunction backButtonFunction = new backButtonFunction(this);

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return backButtonFunction.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}

package com.example.ayusensei2;

import android.app.Activity;
import android.view.MenuItem;

public class backButtonFunction {
    private final Activity activity;

    // Constructor to receive the activity instance
    public backButtonFunction(Activity activity) {
        this.activity = activity;
    }

    // Method to handle the back button functionality
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            activity.onBackPressed(); // Navigate back using the activity instance
            return true;
        }
        return false;
    }
}

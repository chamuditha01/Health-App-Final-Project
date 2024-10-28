package com.example.ayusensei2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class BottomNavigationHelper  {

    public static void setupBottomNavigation(final Activity activity) {
        // Find the LinearLayouts for each menu item
        LinearLayout homeLayout = activity.findViewById(R.id.nav_home);
        LinearLayout marketplaceLayout = activity.findViewById(R.id.nav_home);
        LinearLayout aboutUsLayout = activity.findViewById(R.id.nav_home);
        LinearLayout profileLayout = activity.findViewById(R.id.nav_profile);

        // Set click listeners for each navigation item
        homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Home screen
                activity.startActivity(new Intent(activity, dashboard.class));
            }
        });

        /*marketplaceLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Marketplace screen
                activity.startActivity(new Intent(activity, MarketplaceActivity.class));
            }
        });

        aboutUsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to About Us screen
                activity.startActivity(new Intent(activity, AboutUsActivity.class));
            }
        });*/

        profileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Profile screen
                activity.startActivity(new Intent(activity, profileUi.class));
            }
        });
    }
}

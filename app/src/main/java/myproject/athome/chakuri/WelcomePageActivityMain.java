package myproject.athome.chakuri;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;


public class WelcomePageActivityMain extends CommonNavigationBarActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_welcome_page, null, false);
        drawerLayout.addView(contentView, 0);

        Toolbar tb = findViewById(R.id.common_toolbar);
        setSupportActionBar(tb);

        navView = findViewById(R.id.common_nav_view);
        View headerView = navView.getHeaderView(0);
        ImageView profilePic = headerView.findViewById(R.id.nav_header_imageView);
        profilePic.setImageResource(R.drawable.profile);


        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        String token = (shared.getString("TOKEN", ""));
        Integer user_Id = (shared.getInt("USERID",0));



    }

}

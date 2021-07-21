package myproject.athome.chakuri;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import myproject.athome.chakuri.activities.LoginActivityMain;
import myproject.athome.chakuri.model.api.APIService;

public class CommonNavigationBarActivity extends AppCompatActivity {

    protected DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    public NavigationView navView;
    private Toolbar tb;

    ///////////////Identity Services//////////////////////////
    public APIService mAPIService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_navigation_bar);
        setTitle(R.string.Welcome_chakuri);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.contact_details, null, false);

        drawerLayout = findViewById(R.id.common_drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open, R.string.close);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

         tb = findViewById(R.id.common_toolbar);
        setSupportActionBar(tb);

        ActionBar ab = getSupportActionBar();
        ab.setHomeButtonEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);


        navView = findViewById(R.id.common_nav_view);

        View headerView = navView.getHeaderView(0);
        ImageView profilePic = headerView.findViewById(R.id.nav_header_imageView);
        ImageView editPic = headerView.findViewById(R.id.editImage);

        editPic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(CommonNavigationBarActivity.this, "Change Profile Pic",Toast.LENGTH_SHORT).show();
            }
        });


        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {

//                    case R.id.personal_details:
//
//                        Intent i1 = new Intent(CommonNavigationBarActivity.this, PersonalDetailsMain.class);
//                        startActivity(i1);
//                        Toast.makeText(CommonNavigationBarActivity.this, "Personal Details",Toast.LENGTH_SHORT).show();break;


                case R.id.logout:

                        drawerLayout.closeDrawer(GravityCompat.START);

                        final AlertDialog.Builder alert = new AlertDialog.Builder(CommonNavigationBarActivity.this);
                        View mView = inflater.inflate(R.layout.logout_alert, null, false);

                        Button btn_cancel = mView.findViewById(R.id.btn_cancel);
                        Button btn_okay = mView.findViewById(R.id.btn_okay);


                        alert.setView(mView);
                        final AlertDialog alertDialog = alert.create();
                        alertDialog.setCanceledOnTouchOutside(false);

                        btn_cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialog.dismiss();
                            }
                        });

                        btn_okay.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialog.dismiss();
                                Intent i3 = new Intent(CommonNavigationBarActivity.this, LoginActivityMain.class);
                                startActivity(i3);
                                finish();
                                Toast.makeText(CommonNavigationBarActivity.this, "Logging Out",Toast.LENGTH_SHORT).show();
                            }
                        });

                        alertDialog.show();
                        break;


                    default:
                        return true;
                }


                return true;

            }
        });
    }



    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}

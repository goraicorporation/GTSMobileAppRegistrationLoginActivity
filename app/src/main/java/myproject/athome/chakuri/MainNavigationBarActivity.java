package myproject.athome.chakuri;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import myproject.athome.chakuri.activities.LoginActivityMain;
import myproject.athome.chakuri.activities.RegistrationActivityMain;
import myproject.athome.chakuri.model.api.APIService;

public class MainNavigationBarActivity extends AppCompatActivity {


    protected DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    public APIService mAPIService;
    public APIService mAPIService2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation_bar);
        setTitle(R.string.Welcome_chakuri);

         dl = findViewById(R.id.drawer_layout);
        t = new ActionBarDrawerToggle(this, dl,R.string.open, R.string.close);

        dl.addDrawerListener(t);
        t.syncState();

        Toolbar tb = findViewById(R.id.toolbar_main);
        setSupportActionBar(tb);

        ActionBar ab = getSupportActionBar();
        ab.setHomeButtonEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);



        nv = (NavigationView)findViewById(R.id.nav_view);


        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.nav_login:

                        Intent i = new Intent(MainNavigationBarActivity.this, LoginActivityMain.class);
                        startActivity(i);
                        Toast.makeText(MainNavigationBarActivity.this, "LOGIN",Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_register:

                        Intent i2 = new Intent(MainNavigationBarActivity.this, RegistrationActivityMain.class);
                        startActivity(i2);
                        Toast.makeText(MainNavigationBarActivity.this, "REGISTRATION",Toast.LENGTH_SHORT).show();break;

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
        t.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        t.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if (t.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (dl.isDrawerOpen(GravityCompat.START)) {
            dl.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }




}
package com.example.spacestationv2.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.spacestationv2.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = findViewById(R.id.toolbar);


        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new AllStatsFragment()).commit();
        navigationView.setCheckedItem(R.id.nav_allStats);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_allStats:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AllStatsFragment()).commit();
                break;
            case R.id.nav_co2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Co2Fragment()).commit();
                break;
            case R.id.nav_temperature:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TemperatureFragment()).commit();
                break;
            case R.id.nav_humidity:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HumidityFragment()).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;

        }
        return true;
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

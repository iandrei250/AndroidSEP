package com.example.spacestationui;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

//Bar Chart
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.android.material.navigation.NavigationView;


import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    BarChart mpBarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.main_page);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.navigation_drawer_open
        ,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //barChart
        mpBarChart=findViewById(R.id.barChart);
        BarDataSet barDataSet1=new BarDataSet(barEntries1(),"CO2");
        barDataSet1.setColors(Color.RED);
        BarDataSet barDataSet2=new BarDataSet(barEntries2(),"Humidity");
        barDataSet2.setColors(Color.BLUE);
        BarDataSet barDataSet3=new BarDataSet(barEntries3(),"Luminosity");
        barDataSet3.setColors(Color.YELLOW);
        BarDataSet barDataSet4=new BarDataSet(barEntries4(),"Stupidity");
        barDataSet4.setColors(Color.GREEN);

        BarData data = new BarData(barDataSet1,barDataSet2,barDataSet3,barDataSet4);
        mpBarChart.setData(data);

        String[] days=new String[]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        XAxis xAxis=mpBarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(days));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);

        mpBarChart.setDragEnabled(true);
        mpBarChart.setVisibleXRangeMaximum(3);

        float barSpace=0.05f;
        float groupSpace=0.16f;
        data.setBarWidth(0.16f);

        mpBarChart.getXAxis().setAxisMinimum(0);
        mpBarChart.getXAxis().setAxisMaximum(0+mpBarChart.getBarData().getGroupWidth(groupSpace,barSpace)*7);
        mpBarChart.getAxisLeft().setAxisMinimum(0);

        mpBarChart.groupBars(0,groupSpace,barSpace);

        mpBarChart.invalidate();
    }

    private ArrayList<BarEntry> barEntries1()
    {
        ArrayList<BarEntry>barEntries=new ArrayList<>();
        barEntries.add(new BarEntry(1,900));
        barEntries.add(new BarEntry(2,500));
        barEntries.add(new BarEntry(3,2000));
        barEntries.add(new BarEntry(4,1500));
        barEntries.add(new BarEntry(5,690));
        barEntries.add(new BarEntry(6,2400));
        barEntries.add(new BarEntry(7,1700));
        return barEntries;
    }
    private ArrayList<BarEntry>barEntries2()
    {
        ArrayList<BarEntry>barEntries=new ArrayList<>();
        barEntries.add(new BarEntry(1,300));
        barEntries.add(new BarEntry(2,900));
        barEntries.add(new BarEntry(3,500));
        barEntries.add(new BarEntry(4,1000));
        barEntries.add(new BarEntry(5,2000));
        barEntries.add(new BarEntry(6,1000));
        barEntries.add(new BarEntry(7,1200));
        return barEntries;
    }
    private ArrayList<BarEntry>barEntries3()
    {
        ArrayList<BarEntry>barEntries=new ArrayList<>();
        barEntries.add(new BarEntry(1,700));
        barEntries.add(new BarEntry(2,1000));
        barEntries.add(new BarEntry(3,300));
        barEntries.add(new BarEntry(4,1200));
        barEntries.add(new BarEntry(5,2100));
        barEntries.add(new BarEntry(6,1300));
        barEntries.add(new BarEntry(7,1500));
        return barEntries;
    }
    private ArrayList<BarEntry>barEntries4()
    {
        ArrayList<BarEntry>barEntries=new ArrayList<>();
        barEntries.add(new BarEntry(1,900));
        barEntries.add(new BarEntry(2,1400));
        barEntries.add(new BarEntry(3,100));
        barEntries.add(new BarEntry(4,1600));
        barEntries.add(new BarEntry(5,2500));
        barEntries.add(new BarEntry(6,1500));
        barEntries.add(new BarEntry(7,1100));
        return barEntries;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.nav_co2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CO2_Fragment()).commit();
                break;
            case R.id.nav_temp:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Temperature_Fragment()).commit();
                break;

            case R.id.nav_humidity :
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Humidity_Fragment()).commit();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
        }




    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.request_icon, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.item:
                Toast.makeText(MainActivity.this,"Button clicked", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

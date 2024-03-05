package com.example.testdatabase;

import static com.example.testdatabase.R.id.content_frame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.fragment.HomeFragment;
import com.fragment.ProductFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static int Fragment_Home= 0;
    private static int Fragment_Product= 1;
    private static int Fragment_Brand= 2;

    private int mCurrentFragment = Fragment_Home;

    DrawerLayout drawerLayour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayour = findViewById(R.id.drawerLayour);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle;
        toggle = new ActionBarDrawerToggle(this, drawerLayour, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayour.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigatonView);
        navigationView.setNavigationItemSelectedListener(this);

        //vào app replace homeFragment
        replaceFragment(new HomeFragment());
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            if (mCurrentFragment != Fragment_Home) {
                replaceFragment(new HomeFragment());
            }
        } else if (id == R.id.nav_product) {
            if (mCurrentFragment != Fragment_Product) {
                replaceFragment(new ProductFragment());
            }
        }

        drawerLayour.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayour.isDrawerOpen(GravityCompat.START)) {
            drawerLayour.closeDrawer(GravityCompat.START);
        } else {
           super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();

    }
}
package com.example.lab10_dev;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mainDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configuration de la toolbar
        Toolbar appToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(appToolbar);

        // Configuration du drawer layout
        mainDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView sideNavView = findViewById(R.id.nav_view);
        sideNavView.setNavigationItemSelectedListener(this);

        // Configuration du toggle pour le menu
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                this, mainDrawerLayout, appToolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        mainDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        // Afficher le premier fragment par défaut
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new FirstFragment())
                    .commit();
            sideNavView.setCheckedItem(R.id.nav_first_screen);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int selectedId = menuItem.getItemId();
        Fragment activeFragment = null;

        if (selectedId == R.id.nav_first_screen) {
            activeFragment = new FirstFragment();
        } else if (selectedId == R.id.nav_second_screen) {
            activeFragment = new SecondFragment();
        } else if (selectedId == R.id.nav_list_screen) {
            activeFragment = new ItemListFragment();
        }

        if (activeFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, activeFragment)
                    .commit();
        }

        // Fermeture du drawer après sélection
        if (mainDrawerLayout != null) {
            mainDrawerLayout.closeDrawer(GravityCompat.START);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mainDrawerLayout != null && mainDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mainDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
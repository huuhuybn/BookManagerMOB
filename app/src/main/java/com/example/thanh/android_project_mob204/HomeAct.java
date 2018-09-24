package com.example.thanh.android_project_mob204;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.thanh.android_project_mob204.fragment.BookFragment;
import com.example.thanh.android_project_mob204.fragment.InvoiceFragment;
import com.example.thanh.android_project_mob204.fragment.LibraryFragment;
import com.example.thanh.android_project_mob204.fragment.StatisticsFragment;

public class HomeAct extends AppCompatActivity {
    private BottomNavigationView btnav;
    private BookFragment bookFragment;
    private InvoiceFragment invoiceFragment;
    private LibraryFragment libraryFragment;
    private StatisticsFragment statisticsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_bar);
        btnav = findViewById(R.id.btNav);
        bookFragment = new BookFragment();
        invoiceFragment = new InvoiceFragment();
        libraryFragment = new LibraryFragment();
        statisticsFragment = new StatisticsFragment();
        showFragment(bookFragment);
        btnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.book:
                        showFragment(bookFragment);
                        return true;
                    case R.id.library:
                        showFragment(libraryFragment);
                        return true;
                    case R.id.statistics:
                        showFragment(statisticsFragment);
                        return true;
                    case R.id.invoice:
                        showFragment(invoiceFragment);
                        return true;
                    case R.id.user:
                        startActivity(new Intent(HomeAct.this,ListUserAct.class));
                        return true;
                }
                return false;
            }
        });
    }

    private void showFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();
    }
}

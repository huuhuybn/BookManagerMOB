package com.example.thanh.android_project_mob204;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.thanh.android_project_mob204.database.DatabaseHelper;
import com.example.thanh.android_project_mob204.model.User;

public class LoginActivity extends AppCompatActivity {


    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databaseHelper = new DatabaseHelper(this);


        User user = new User("admin","admin","Huy Nguyen","0913456789");
        databaseHelper.insertUser(user);

    }


    public void showBottomNavigation(View view) {
        Intent intent = new Intent(LoginActivity.this, BottomNavigationBar.class);
        startActivity(intent);
    }


}

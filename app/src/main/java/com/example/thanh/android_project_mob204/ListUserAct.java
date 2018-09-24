package com.example.thanh.android_project_mob204;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.thanh.android_project_mob204.adapter.AdapterUser;
import com.example.thanh.android_project_mob204.database.DatabaseHelper;
import com.example.thanh.android_project_mob204.model.User;
import com.example.thanh.android_project_mob204.sqlitedao.UserDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class ListUserAct extends AppCompatActivity implements Constant{


    private RecyclerView lvListUsers;
    private TextView tvNoUser;

    private AdapterUser adapterUser;

    private LinearLayoutManager linearLayoutManager;

    private DatabaseHelper databaseHelper;

    private UserDAO userDAO;

    private List<User> userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        initData();


    }

    private void initData() {
        databaseHelper = new DatabaseHelper(this);
        userDAO = new UserDAO(databaseHelper);
        userList = new ArrayList<>();
        userList = userDAO.getAllUsers();

        adapterUser = new AdapterUser(this, userList);
        lvListUsers.setAdapter(adapterUser);

        linearLayoutManager = new LinearLayoutManager(this);
        lvListUsers.setLayoutManager(linearLayoutManager);


    }

    private void initViews() {
        setContentView(R.layout.activity_list_user);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        lvListUsers = findViewById(R.id.lvListUsers);
        tvNoUser = findViewById(R.id.tv_no_user);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list_user_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_add_user:

                Intent intent = new Intent(this, ActAddUser.class);
                startActivityForResult(intent, ADD_USER);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}

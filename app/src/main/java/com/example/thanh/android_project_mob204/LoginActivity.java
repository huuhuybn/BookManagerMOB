package com.example.thanh.android_project_mob204;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thanh.android_project_mob204.database.DatabaseHelper;
import com.example.thanh.android_project_mob204.model.User;
import com.example.thanh.android_project_mob204.sqlitedao.UserDAO;

public class LoginActivity extends AppCompatActivity {


    private DatabaseHelper databaseHelper;

    private EditText edtUserName;
    private EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        databaseHelper = new DatabaseHelper(this);


    }

    public void initViews() {


        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);

    }


    public void showBottomNavigation(View view) {

        Log.e("showBottomNavigation","showBottomNavigation");

        String username = edtUserName.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        UserDAO userDAO = new UserDAO(databaseHelper);
        User user = userDAO.getUser(username);

        // neu user 1=null, tuc la user nay co ton tai trong DB. thi tien hanh so sanh password
        if (user != null) {

            String originalPassword = user.getPassword();
            if (originalPassword.equals(password)) {

                Intent intent = new Intent(LoginActivity.this, HomeAct.class);
                startActivity(intent);


                // neu mat khau sai thi thong bao
            }else {

                Toast.makeText(LoginActivity.this, getString(R.string.notify_wrong_username_password), Toast.LENGTH_LONG).show();

            }

            // neu user == null, user ko co trong co so du lieu thi thong bao sai username or password
        } else {

            Toast.makeText(LoginActivity.this, getString(R.string.notify_wrong_username_password), Toast.LENGTH_LONG).show();

        }

    }


}

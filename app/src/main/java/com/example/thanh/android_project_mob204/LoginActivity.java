package com.example.thanh.android_project_mob204;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thanh.android_project_mob204.database.DatabaseHelper;
import com.example.thanh.android_project_mob204.model.User;

public class LoginActivity extends AppCompatActivity {


    private DatabaseHelper databaseHelper;

    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnLogin;

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
        btnLogin = findViewById(R.id.btnLogin);

    }


    public void showBottomNavigation(View view) {

        String username = edtUserName.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        User user = databaseHelper.getUser(username);

        // neu user 1=null, tuc la user nay co ton tai trong DB. thi tien hanh so sanh password
        if (user != null) {

            String originalPassword = user.getPassword();
            if (originalPassword.equals(password)) {

                Intent intent = new Intent(LoginActivity.this, BottomNavigationBar.class);
                startActivity(intent);

            }

        // neu user == null, user ko co trong co so du lieu thi thong bao sai username or password
        } else {

            Toast.makeText(this, getString(R.string.notify_wrong_username_password), Toast.LENGTH_LONG).show();

        }

    }


}

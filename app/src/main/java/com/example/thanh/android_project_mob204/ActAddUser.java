package com.example.thanh.android_project_mob204;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.widget.EditText;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class ActAddUser extends Activity implements Constant {
    private EditText edtUserName;
    private EditText edtPassword;
    private EditText edtConfirmPassword;
    private EditText edtName;
    private EditText edtPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();

        findViewById(R.id.btnAddUser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // validate du lieu
                // kiem tra nhap trong
                // kiem tra 2 o password giong nhau
                // kiem tra sdt tu 9 ki tu
                // kiem tra username ton tai hay chua


                // lay du lieu tu edittext bo vao DB





            }
        });

    }

    private void initViews() {
        setContentView(R.layout.activity_add_user);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);

    }


}

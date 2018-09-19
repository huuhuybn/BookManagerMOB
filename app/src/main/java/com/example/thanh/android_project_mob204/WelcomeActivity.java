package com.example.thanh.android_project_mob204;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread timeCount = new Thread(){
            public void run()
            {
                try {
                    sleep(3000);
                } catch (Exception e) {
                    Log.d("Error", e.toString());
                }
                finally
                {
                    Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
        timeCount.start();
    }
    protected void onPause(){
        super.onPause();
        finish();
    }
}

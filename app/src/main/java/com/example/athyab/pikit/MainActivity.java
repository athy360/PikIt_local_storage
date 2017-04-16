package com.example.athyab.pikit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView tv_Name;
    private TextView tv_Email;
    private Button btn_Logout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv_Name = (TextView) findViewById(R.id.name);
        tv_Email = (TextView) findViewById(R.id.email);
        btn_Logout = (Button) findViewById(R.id.btnLogout);




        // Launching the login activity
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
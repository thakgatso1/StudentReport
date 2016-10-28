package com.example.admin.studentreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openRegistration(View v){
        Intent intent=new Intent(MainActivity.this,StudentRegistration.class);
        startActivity(intent);
    }
    public void login(View v){
        Intent intent=new Intent(MainActivity.this,Registerlecturer.class);
        startActivity(intent);

    }
}

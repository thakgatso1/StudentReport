package com.example.admin.studentreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Registerlecturer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerlecturer);
    }
    public void login(View v){
        Intent intent=new Intent(Registerlecturer.this,MainActivity.class);
        startActivity(intent);

    }
}

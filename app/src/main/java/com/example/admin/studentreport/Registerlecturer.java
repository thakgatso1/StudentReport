package com.example.admin.studentreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registerlecturer extends AppCompatActivity {
    private EditText editName, editAdrress, editUsername, editTPassword, editConPass;
    Button btnAddData;
    dbStudent db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerlecturer);
        btnAddData = (Button) findViewById(R.id.btnAdd);
        editName = (EditText) findViewById(R.id.edtname);
        editAdrress = (EditText) findViewById(R.id.edtAddress);
        editUsername = (EditText) findViewById(R.id.edtUserName);
        editTPassword = (EditText) findViewById(R.id.edtPassword);
        editConPass = (EditText) findViewById(R.id.edtconfirmP);
        db = new dbStudent(this);
    }

    public void add(View v) {
       Lecturer lecturer = new Lecturer(editName.getText().toString(), editAdrress.getText().toString(), editUsername.getText().toString(),editTPassword.getText().toString(),editConPass.getText().toString());
        db.insertLecturer(lecturer);

        if(!editTPassword.getText().toString().equalsIgnoreCase(editConPass.getText().toString())) {
            Toast.makeText(this, "your passwords dont match", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "lecturer successfully Added", Toast.LENGTH_LONG).show();
            Intent intent=new Intent(Registerlecturer.this,StudentRegistration.class);
            startActivity(intent);
        }

        editName.setText("");
        editAdrress.setText("");
        editUsername.setText("");
        editTPassword.setText("");
        editConPass.setText("");


    }
}

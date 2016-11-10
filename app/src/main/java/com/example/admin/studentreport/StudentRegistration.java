package com.example.admin.studentreport;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentRegistration extends AppCompatActivity {
    private EditText edtID, edtName, edtSurname, edtSubName, edtM1, edtM2, edtM3;
    private Button btnAdd, btnUpdate, btnDelete, btnViewAll;
    dbStudent db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);

        edtName = (EditText) findViewById(R.id.edtname);
        edtSurname = (EditText) findViewById(R.id.edtSurname);
        edtSubName = (EditText) findViewById(R.id.edtSubName);
        edtM1 = (EditText) findViewById(R.id.edtM1);
        edtM2 = (EditText) findViewById(R.id.edtM2);
        edtM3 = (EditText) findViewById(R.id.edtM3);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnViewAll = (Button) findViewById(R.id.btnViewAll);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        db = new dbStudent(this);

    }

    public void add(View v) {
        Student student = new Student(edtName.getText().toString(), edtSurname.getText().toString(), edtSubName.getText().toString(), Integer.parseInt(edtM1.getText().toString()),
                Integer.parseInt(edtM2.getText().toString()), Integer.parseInt(edtM3.getText().toString()));
        db.add(student);
        Toast.makeText(this, "Student successfully Added", Toast.LENGTH_LONG).show();


        edtName.setText("");
        edtSurname.setText("");
        edtSubName.setText("");
        edtM1.setText("");
        edtM2.setText("");
        edtM3.setText("");

    }

public void getAll(View v){
    Intent intent=new Intent(StudentRegistration.this,StudentReport.class);
    startActivity(intent);
}



}
package com.example.admin.studentreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLOutput;

public class UpdateStudent extends AppCompatActivity {
    private EditText edtID, edtName, edtSurname, edtSubName, edtM1, edtM2, edtM3;
    private Button btnUpdate;
    dbStudent db;
    Student objStudent;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_update_student);
        edtID = (EditText) findViewById(R.id.edtID1);
        edtName = (EditText) findViewById(R.id.edtname1);
        edtSurname = (EditText) findViewById(R.id.edtSurname1);
        edtSubName = (EditText) findViewById(R.id.edtSubName1);
        edtM1 = (EditText) findViewById(R.id.edtM11);
        edtM2 = (EditText) findViewById(R.id.edtM21);
        edtM3 = (EditText) findViewById(R.id.edtM31);
        btnUpdate = (Button) findViewById(R.id.btnUpdate1);


        intent = getIntent();
        intent.getExtras();

        objStudent = (Student) intent.getSerializableExtra("student");


        db = new dbStudent(this);


        edtID.setText(String.valueOf(objStudent.getStudId()));
        edtName.setText(objStudent.getStudName());
        edtSurname.setText(objStudent.getStudSurname());
        edtSubName.setText(objStudent.getSubjectName());
        edtM1.setText(String.valueOf(objStudent.getMark1()));
        edtM2.setText(String.valueOf(objStudent.getMark2()));
        edtM3.setText(String.valueOf(objStudent.getMark3()));
        System.out.println(objStudent.getStudId());

        setBtnUpdate();

    }

    public void setBtnUpdate() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(objStudent.getStudId());
                objStudent = new Student(Integer.parseInt(edtID.getText().toString()),edtName.getText().toString(), edtSurname.getText().toString(), edtSubName.getText().toString(), Integer.parseInt(edtM1.getText().toString()),
                        Integer.parseInt(edtM2.getText().toString()), Integer.parseInt(edtM3.getText().toString()));

                boolean isUpdated = db.update(objStudent);
                if (isUpdated) {
                    Toast.makeText(UpdateStudent.this, "Successfully Updated", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(UpdateStudent.this, "Data not Updated", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

}

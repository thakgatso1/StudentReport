package com.example.admin.studentreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateStudent extends AppCompatActivity {
    private EditText edtID, edtName, edtSurname, edtSubName, edtM1, edtM2, edtM3;
    private Button btnUpdate;
    dbStudent db;
    Student objStudent;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    edtID = (EditText) findViewById(R.id.edtID);
        edtName = (EditText) findViewById(R.id.edtname);
        edtSurname = (EditText) findViewById(R.id.edtSurname);
        edtSubName = (EditText) findViewById(R.id.edtSubName);
        edtM1 = (EditText) findViewById(R.id.edtM1);
        edtM2 = (EditText) findViewById(R.id.edtM2);
        edtM3 = (EditText) findViewById(R.id.edtM3);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);


        intent = getIntent();
        intent.getExtras();

        objStudent = (Student)intent.getSerializableExtra("Student");



        db = new dbStudent(this);



    edtID.setText("" + objStudent.getStudId());
        edtName.setText(objStudent.getStudName());
        edtSurname.setText(objStudent.getStudName());
        edtSubName.setText(objStudent.getSubjectName());
        edtM1.setText("" + objStudent.getMark1());
        edtM2.setText("" + objStudent.getMark2());
        edtM3.setText("" + objStudent.getMark3());

        setBtnUpdate();

    }



    public void setBtnUpdate(){
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdated = db.update(objStudent);
                if(isUpdated == true){
                    Toast.makeText(UpdateStudent.this, "Successfully Updated", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(UpdateStudent.this, "Data not Updated", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

}

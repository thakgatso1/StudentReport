package com.example.admin.studentreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StudentInformation extends AppCompatActivity {

    Student objStudent;
    ListView lstStud;
    dbStudent db;
    ArrayAdapter<String> arrstd;
    List<String> arrList;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_information);
        db = new dbStudent(getApplicationContext());
        lstStud = (ListView) findViewById(R.id.lstStudView);

        intent = getIntent();
        intent.getExtras();

        objStudent = (Student) intent.getSerializableExtra("Student");
        arrList = new ArrayList<>();
        arrList.add(""+objStudent.getStudId());
        arrList.add(objStudent.getStudName());
        arrList.add(objStudent.getStudSurname());
        arrList.add(objStudent.getSubjectName());
        arrList.add("" + objStudent.getMark1());

        arrList.add("" + objStudent.getMark2());
        arrList.add("" + objStudent.getMark3());




        arrstd = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrList);
        lstStud.setAdapter(arrstd);

    }


    public void delete(View v) {
        int i=0;

int result;
     result=   db.delete(objStudent);
        System.out.println(arrList.get(i));
        if(result>0) {
            Toast.makeText(getApplicationContext(), "succesfully deleted", Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(getApplicationContext(), "not deleted", Toast.LENGTH_LONG).show();
        }
    }

    public void update(View v) {

Intent in = new Intent(getApplicationContext(),UpdateStudent.class);
        in.putExtra("student",objStudent);
        startActivity(in);
    }
}

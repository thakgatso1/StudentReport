package com.example.admin.studentreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class StudentReport extends AppCompatActivity implements AdapterView.OnItemClickListener {
    List<Student> stdList = new ArrayList<Student>();
    ListView lstStud;
    ArrayAdapter<String> arrstd;
    dbStudent objDB;
    ArrayList<String> nameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_report);
        lstStud = (ListView) findViewById(R.id.stdList);
        objDB = new dbStudent(getApplicationContext());
        stdList = objDB.getAllLearner();

        for (int i = 0; i < stdList.size(); i++) {
            Student temp = stdList.get(i);
            nameList.add(temp.getStudName());
        }

        arrstd = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nameList);
        lstStud.setAdapter(arrstd);
        lstStud.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Student objStudent;

        String strName = stdList.get(position).getStudName();

        Intent intent = new Intent(StudentReport.this, StudentInformation.class);
        intent.putExtra("Student", stdList.get(position));
        startActivity(intent);


    }
}

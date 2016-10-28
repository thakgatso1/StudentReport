package com.example.admin.studentreport;

import java.io.Serializable;

/**
 * Created by admin on 2016-10-13.
 */
public class Student implements Serializable{
    private String studName,studSurname,subjectName;
    private int mark1,mark2,mark3, studId;

    //overloaded constructor
    public Student(int studId, String studSurname, String studName, String subjectName, int mark1, int mark2, int mark3) {
        this.studId = studId;
        setStudSurname(studSurname);
        setStudName (studName);
        setSubjectName(subjectName);
        setMark1(mark1);
        setMark2 (mark2);
        setMark3 (mark3);
    }



    public Student( String studSurname, String studName, String subjectName, int mark1, int mark2, int mark3) {
        setStudSurname(studSurname);
        setStudName (studName);
        setSubjectName(subjectName);
        setMark1(mark1);
        setMark2 (mark2);
        setMark3 (mark3);
    }
//Mutators


    public void setStudName(String studName) {
        this.studName = studName;
    }

    public void setStudSurname(String studSurname) {
        this.studSurname = studSurname;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }

    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }

    public void setMark3(int mark3) {
        this.mark3 = mark3;
    }


//Accessors
    public int getMark1() {
        return mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public int getMark3() {
        return mark3;
    }

    public int getStudId() {
        return studId;
    }

    public String getStudName() {
        return studName;
    }

    public String getStudSurname() {
        return studSurname;
    }

    public String getSubjectName() {
        return subjectName;
    }
}

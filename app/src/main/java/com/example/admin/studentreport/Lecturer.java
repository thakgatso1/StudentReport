package com.example.admin.studentreport;

/**
 * Created by admin on 2016-11-09.
 */
public class Lecturer {
    private String lectName,lectAddress,lectUserName,lectPassword,lectConPass;

    public Lecturer(String lectAddress, String lectConPass, String lectName, String lectPassword, String lectUserName) {
        setLectAddress (lectAddress);
        setLectConPass ( lectConPass);
        setLectName ( lectName);
        setLectPassword (lectPassword);
        setLectUserName ( lectUserName);
    }

    public void setLectAddress(String lectAddress) {
        this.lectAddress = lectAddress;
    }

    public void setLectConPass(String lectConPass) {
        this.lectConPass = lectConPass;
    }

    public void setLectName(String lectName) {
        this.lectName = lectName;
    }

    public void setLectPassword(String lectPassword) {
        this.lectPassword = lectPassword;
    }

    public void setLectUserName(String lectUserName) {
        this.lectUserName = lectUserName;
    }

    public String getLectAddress() {
        return lectAddress;
    }

    public String getLectConPass() {
        return lectConPass;
    }

    public String getLectName() {
        return lectName;
    }

    public String getLectPassword() {
        return lectPassword;
    }

    public String getLectUserName() {
        return lectUserName;
    }
}

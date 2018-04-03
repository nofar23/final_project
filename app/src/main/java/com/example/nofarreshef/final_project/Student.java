package com.example.nofarreshef.final_project;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Nofar Reshef on 03/04/2018.
 */

public class Student implements Serializable{
    private String name;
    private String phone;
    private String mail;
    private String address;
    private String colage;
    private String yearStudy;
    private String semester;

    transient private Bitmap photo;

    public Student() {
    }

    public Student(String name, String phone, String mail, String address, String colage, String yearStudy, String semester, Bitmap photo) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.colage = colage;
        this.yearStudy = yearStudy;
        this.semester = semester;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public String getAddress() {
        return address;
    }

    public String getColage() {
        return colage;
    }

    public String getYearStudy() {
        return yearStudy;
    }

    public String getSemester() {
        return semester;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setColage(String colage) {
        this.colage = colage;
    }

    public void setYearStudy(String yearStudy) {
        this.yearStudy = yearStudy;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public void writeObject(ObjectOutputStream out) throws IOException {
        //    if(photo != null) {
        photo.compress(Bitmap.CompressFormat.JPEG, 70, out);
        //  }
        out.defaultWriteObject();
    }
    private void readObject(ObjectInputStream in) throws  IOException, ClassNotFoundException{
        photo = BitmapFactory.decodeStream(in);
        in.defaultReadObject();
    }
}

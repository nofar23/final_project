package com.example.nofarreshef.final_project;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Bitmap bitmapP;
    Drawable myImage;
    ArrayList<Student> studentL = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);



        //myImage = getResources().getDrawable(R.drawable.cat);
        bitmapP=  BitmapFactory.decodeResource(getResources(),R.drawable.cat);
//just for now- persons array
        Student student1 = new Student();
        Student student2 = new Student("asaf","232637485","cdivn@oic.com","modiin","bengurion","B","second",bitmapP);
        Student student3 = new Student("adi","31463778474","dsoin@cadn.com", "holon","ariel", "c","first",bitmapP);

        student1.setName("Nofar");
        student1.setMail("nofar@vij.com");
        student1.setAddress("gadera");
        student1.setPhone("03294776425");
        student1.setColage("hit");
        student1.setYearStudy("A");
        student1.setSemester("first");
        student1.setPhoto(bitmapP);

        studentL.add(student1);
        studentL.add(student2);
        studentL.add(student3);


        try{
            FileOutputStream fos = openFileOutput("persons.dat", Activity.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentL);
            oos.close();

            //imageP.setImageBitmap(null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //end

        try{
            //read
            FileInputStream fis = openFileInput("persons.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            studentL = (ArrayList<Student>)ois.readObject();
            ois.close();
            if(studentL != null){
                final StudentAdapter adapter = new StudentAdapter(studentL,this);
                adapter.setListener(new StudentAdapter.StudentAdapterListener() {
                    @Override
                    public void onItemClicked(int position, View view) {
                        Intent i = new Intent(MainActivity.this, dailogStudent.class);
                       // i.putExtra("persons",studentL.get(position));
                        startActivity(i);
                    }

                    @Override
                    public void onItemLongClicked(int position, View view) {
                        studentL.remove(position);
                        adapter.notifyItemRemoved(position);
                    }
                });
                recyclerView.setAdapter(adapter);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    private void setFile(){
        Student student = new Student();



        try{
            FileOutputStream fos = openFileOutput("persons.dat", Activity.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentL);
            oos.close();

            //imageP.setImageBitmap(null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}


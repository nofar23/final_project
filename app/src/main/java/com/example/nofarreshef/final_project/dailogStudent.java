package com.example.nofarreshef.final_project;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class dailogStudent extends AppCompatActivity {

    Button add;
    Button back;
    Student student;
    TextView nameS;
    TextView facultyS;
    TextView yearS;
    TextView semesterS;
    TextView courses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailog_student);

        add = findViewById(R.id.add_friend_student_button);
        back = findViewById(R.id.back_button);
        nameS = findViewById(R.id.student_name_dialog);
        facultyS = findViewById(R.id.faculty_dialog);
        yearS = findViewById(R.id.academic_year);
        semesterS = findViewById(R.id.semester);


        Intent intent = getIntent();
        student = (Student) intent.getExtras().get("persons");
        showStudent(student);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (add.getText().toString().equalsIgnoreCase("Add")) {
                    add.setText("Remove");
                } else {
                    add.setText("Add");
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void showStudent (Student student){
        if(student.getName() != null){
            nameS.setText(student.getName());
        }
        if(student.getFaculty() != null){
            facultyS.setText(student.getFaculty());
        }
        if(student.getYearStudy() != null){
            yearS.setText(student.getYearStudy());
        }
        if(student.getSemester() != null){
            semesterS.setText(student.getSemester());
        }
    }
}

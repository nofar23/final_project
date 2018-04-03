package com.example.nofarreshef.final_project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nofar Reshef on 04/04/2018.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder>  {
    private List<Student> students;
    Context context;
    StudentAdapterListener listener;


    interface  StudentAdapterListener{
        void  onItemClicked(int position, View view);
        void  onItemLongClicked(int position, View view);
    }

    public  void setListener(StudentAdapterListener listener){
        this.listener=listener;
    }

    public StudentAdapter(List<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }

    public  class StudentViewHolder extends RecyclerView.ViewHolder{
        ImageView studentPicture;
        TextView studentName;
        public StudentViewHolder(final View itemView) {
            super(itemView);
            studentPicture = itemView.findViewById(R.id.student_picture_output);
            studentName = itemView.findViewById(R.id.student_name_output);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClicked(getAdapterPosition(),v);

                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onItemLongClicked(getAdapterPosition(),v);
                    return false;
                }
            });
        }
    }
    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        StudentViewHolder allViewHolder = new StudentViewHolder(view);
        return allViewHolder;
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        Bitmap student_photo=  BitmapFactory.decodeResource(context.getResources(),R.drawable.cat);
        holder.studentPicture.setImageBitmap(student_photo);
        holder.studentName.setText(students.get(position).getName()+ "");
    }

    @Override
    public int getItemCount() {
        return students.size();
    }


}

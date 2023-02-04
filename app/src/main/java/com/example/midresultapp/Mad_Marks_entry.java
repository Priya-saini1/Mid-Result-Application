package com.example.midresultapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Mad_Marks_entry extends AppCompatActivity {
    DatabaseHelper myDb;
EditText Mad_marks;
TextView name,subject,enrollment;
Button Addrecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_marks_entry);

        myDb = new DatabaseHelper(this);

        name = findViewById(R.id.name);
        subject = findViewById(R.id.Subject);
        Mad_marks = findViewById(R.id.Marks);
        enrollment = findViewById(R.id.Enroll);
        Addrecord = findViewById(R.id.AddButton);
        name.setText(getIntent().getExtras().getString("name"));
        subject.setText(getIntent().getExtras().getString("subject"));
        enrollment.setText(getIntent().getExtras().getString("enroll"));
        AddData();
    }
    public void AddData(){
        Addrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               boolean isInserted= myDb.insertData(enrollment.getText().toString(),name.getText().toString(),subject.getText().toString(),Mad_marks.getText().toString());
                if(isInserted==true)
                    Toast.makeText(Mad_Marks_entry.this, "Marks Inserted Successfully !", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Mad_Marks_entry.this, "Marks Are Not Inserted Successfully !", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
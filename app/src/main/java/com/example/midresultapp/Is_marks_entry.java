package com.example.midresultapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Is_marks_entry extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText Is_marks;
    TextView name,subject,enrollment;
    Button Addrecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_marks_entry);
        myDb = new DatabaseHelper(this);

        name = findViewById(R.id.name);
        subject = findViewById(R.id.Subject);
        Is_marks = findViewById(R.id.Marks);
        enrollment = findViewById(R.id.Enroll);
        Addrecord = findViewById(R.id.AddButton);
        name.setText(getIntent().getExtras().getString("name"));
        subject.setText(getIntent().getExtras().getString("subject"));
        enrollment.setText(getIntent().getExtras().getString("enroll"));
        AddIsData();
    }
    public void AddIsData(){
        Addrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted= myDb.insertData(enrollment.getText().toString(),name.getText().toString(),subject.getText().toString(),Is_marks.getText().toString());
                if(isInserted==true)
                    Toast.makeText(Is_marks_entry.this, "Marks Inserted Successfully !", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Is_marks_entry.this, "Marks Are Not Inserted Successfully !", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
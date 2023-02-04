package com.example.midresultapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Student_enrol extends AppCompatActivity {
    ListView StudentEnrol_Mad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_enrol);
        StudentEnrol_Mad = (ListView) findViewById(R.id.student_enrol);
        String [] madsubject = {"MAD"};
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Priya Saini");
        arrayList.add("Ankit Kanani");
        arrayList.add("Jyot Makwana");
        arrayList.add("Kaushal Savaliya");
        arrayList.add("Prachi Mehta");
        String [] enrol = {"200210107504","190210107027","190210107034","190210107063","190210107038"};


        //ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),R.layout.item_style,arrayList);

        StudentEnrol_Mad.setAdapter(arrayAdapter);
        StudentEnrol_Mad.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),Mad_Marks_entry.class);
                intent.putExtra("name",arrayList.get(i));
                intent.putExtra("subject",madsubject[0]);
                intent.putExtra("enroll",enrol[i]);
                startActivity(intent);


            }
        });

    }
}
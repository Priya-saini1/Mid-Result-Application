package com.example.midresultapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Student_enrol_Is extends AppCompatActivity {
    ListView StudentEnrol_Is;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_enrol_is);
        StudentEnrol_Is = (ListView) findViewById(R.id.student_enrol_is) ;
        String [] Issubject = {"IS"};
        String [] enrol = {"190210107040","190210107025","200210107506","190210107036","190210107026"};
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Drashti Mitaliya");
        arrayList.add("Rushi Jivani");
        arrayList.add("Dharmik Pajwani");
        arrayList.add("Sujit Maniya");
        arrayList.add("Demo xyz ");
        //ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),R.layout.item_style,arrayList);

        StudentEnrol_Is.setAdapter(arrayAdapter);
        StudentEnrol_Is.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),Is_marks_entry.class);
                intent.putExtra("name",arrayList.get(i));
                intent.putExtra("subject",Issubject[0]);
                intent.putExtra("enroll",enrol[i]);
                startActivity(intent);
            }
        });
    }
}
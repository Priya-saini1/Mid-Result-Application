package com.example.midresultapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class Subject_list extends AppCompatActivity {
    ListView SubjectList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);


        SubjectList = (ListView) findViewById(R.id.subjectList);
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Mobile Application Development");
        arrayList.add("Information Security");



        //ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),R.layout.item_style,arrayList);

        SubjectList.setAdapter(arrayAdapter);

        SubjectList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(Subject_list.this, i+""+arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
                if(i==0){
                   Mad();
                }
                else  if(i==1){
                    Is();
                }

            }
        });

        }
    public void Mad(){
        Intent  i = new Intent(getApplicationContext(),Student_enrol.class);
        startActivity(i);
    }
    public void Is(){
        Intent  i = new Intent(getApplicationContext(),Student_enrol_Is.class);
        startActivity(i);
    }

    }

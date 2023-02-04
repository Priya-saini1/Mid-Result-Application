package com.example.midresultapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ViewResult extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText enrol;
    TextView name,subject,marks,rollno;
    Button result;
    TextView tv,tv1,tv2,tv3,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_result);

        name = findViewById(R.id.name);
        tv = findViewById(R.id.textView);
        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        pass = findViewById(R.id.pass);
       // enrol = findViewById(R.id.viewresult);
        rollno = findViewById(R.id.rollno);
        subject = findViewById(R.id.subdetail);
        marks = findViewById(R.id.marksdetail);
        result = findViewById(R.id.search);
        myDb = new DatabaseHelper(this);
        viewResult();

    }
    public void  viewResult(){
       result.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Log.d("Priya","0");
               String enrol = getIntent().getExtras().getString("enrollment");
              Cursor res = myDb.getAllData(enrol);
               Log.d("Priya","1");
               if(res.getCount()==0)
              {
                  Log.d("Priya","2");
                  showmessage("Alert","Result To Be Declared!!");
                  Log.d("Priya","3");
                  return ;
              }
               name.setVisibility(View.VISIBLE);
               rollno.setVisibility(View.VISIBLE);
               subject.setVisibility(View.VISIBLE);
               marks.setVisibility(View.VISIBLE);
               //labels;
               tv.setVisibility(View.VISIBLE);
               tv1.setVisibility(View.VISIBLE);
               tv2.setVisibility(View.VISIBLE);
               tv3.setVisibility(View.VISIBLE);
               pass.setVisibility(View.VISIBLE);
               Integer m1=0;
              while(res.moveToNext()){
                  Log.d("Priya","4");
                  String enroll = res.getString(1).toString();
                  String n1 = res.getString(2).toString();
                  String s1 = res.getString(3).toString();
                  String M1 = res.getString(4).toString();
                  rollno.setText(enroll);
                  name.setText(n1);
                  subject.setText(s1);
                  marks.setText(M1);
                  m1 = Integer.parseInt(M1);
                  if(m1>=8){
                      pass.setText("Congratulation!! You have Passed this exam.");
                      pass.setTextColor(Color.GREEN);
                  }
                  else{
                      pass.setText("Sorry !! You have Not Passed this exam.");
                      pass.setTextColor(Color.RED);
                  }
              }


           }
       });
    }
    public void showmessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

                builder.show();
    }
}
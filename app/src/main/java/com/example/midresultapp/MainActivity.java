package com.example.midresultapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginButton;
    Spinner roles;
    String roles_value;
    CheckBox checkBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.loginButton);
        roles = (Spinner) findViewById(R.id.roles);
        checkBtn = (CheckBox) findViewById(R.id.checkBox);

        checkBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    password.setInputType(InputType.TYPE_CLASS_TEXT);
                }else{
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });





        String[] roles1 = {"Select Role","Professor","Student",};
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,roles1);
        myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        roles.setAdapter(myAdapter);
        roles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                roles_value = parent.getItemAtPosition(position).toString().toLowerCase();
                 //Toast.makeText(MainActivity.this, roles_value, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(roles_value.equalsIgnoreCase("Student")){
                    if((username.getText().toString().trim().equals("priya")&& password.getText().toString().trim().equals("1234")) )
                    {
                        Toast.makeText(MainActivity.this, "LoginSuccessfully", Toast.LENGTH_SHORT).show();
                        Intent  i = new Intent(getApplicationContext(),ViewResult.class);
                        i.putExtra("enrollment","200210107504");
                        startActivity(i);
                    }
                    else if((username.getText().toString().trim().equals("drashti") && password.getText().toString().trim().equals("2345"))){
                        Toast.makeText(MainActivity.this, "LoginSuccessfully", Toast.LENGTH_SHORT).show();
                        Intent  i = new Intent(getApplicationContext(),ViewResult.class);
                        i.putExtra("enrollment","190210107040");
                        startActivity(i);
                    }
                    else if((username.getText().toString().trim().equals("rushi") && password.getText().toString().trim().equals("1234"))){
                        Toast.makeText(MainActivity.this, "LoginSuccessfully", Toast.LENGTH_SHORT).show();
                        Intent  i = new Intent(getApplicationContext(),ViewResult.class);
                        i.putExtra("enrollment","190210107025");
                        startActivity(i);
                    }
                    else if((username.getText().toString().trim().equals("demo") && password.getText().toString().trim().equals("1234"))){
                        Toast.makeText(MainActivity.this, "LoginSuccessfully", Toast.LENGTH_SHORT).show();
                        Intent  i = new Intent(getApplicationContext(),ViewResult.class);
                        i.putExtra("enrollment","190210107026");
                        startActivity(i);
                    }

                    else{
                        Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

                    }
                }
                if(roles_value.equalsIgnoreCase("professor")){
                    if((username.getText().toString().trim().equals("professor") && password.getText().toString().trim().equals("1234")))
                    {
                        Toast.makeText(MainActivity.this, "LoginSuccessfully", Toast.LENGTH_SHORT).show();
                        Intent  i = new Intent(getApplicationContext(),Subject_list.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });
    }

}
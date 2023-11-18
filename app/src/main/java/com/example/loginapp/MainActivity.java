package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView email =(TextView) findViewById(R.id.EmailAddress);
        TextView password =(TextView) findViewById(R.id.Password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.LoginBtn);

        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals("admin@gmail.com") && password.getText().toString().equals("admin")){
                    //login credentials are correct
                    Intent intent = new Intent(MainActivity.this, chartActivity.class);
                    startActivity(intent);
                }
                else
                    //login credentials are incorrect
                    Toast.makeText(MainActivity.this,"INVALID LOGIN CREDENTIALS",Toast.LENGTH_LONG).show();
            }
        });
    }
}
package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_mail, et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_mail = (EditText)findViewById(R.id.txt_username);
        et_pass = (EditText)findViewById(R.id.txt_password);
    }

    //Métodos botones
    public void signIn(View view){

        String et_mail_String = et_mail.getText().toString();
        String et_pass_String = et_pass.getText().toString();

        if(et_mail_String.equals("oscar.faini@gmail.com") && et_pass_String.equals("Android2019")){

            Toast.makeText(this,"You are Logging in", Toast.LENGTH_LONG).show();

            Intent menu = new Intent(this,menu.class);
            startActivity(menu);
        }

        else {
            Toast.makeText(this,"Acces Denied", Toast.LENGTH_LONG).show();
        }
    }

    public void signUp(View view){
        Intent registrar = new Intent(this, signUp.class);
        startActivity(registrar);
    }
}

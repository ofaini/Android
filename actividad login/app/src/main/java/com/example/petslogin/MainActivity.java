package com.example.petslogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etmail, etpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etmail = (EditText)findViewById(R.id.txt_mail);
        etpass = (EditText)findViewById(R.id.txt_contrasena);
    }

    //Método para le boton
    public void singIn(View view){

        if(etmail.equals("oscarfaini@gmail.com") && etpass.equals("android")){
            Toast.makeText(this,"You are Logging in", Toast.LENGTH_LONG).show();

            Intent siguiente = new Intent(this,SecondActivity.class);
            startActivity(siguiente);

        }else{
            Toast.makeText(this,"Acces Denied", Toast.LENGTH_LONG).show();
        }
    }
}

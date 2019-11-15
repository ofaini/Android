package com.example.market;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.market.classes.connectionDB;

public class Signup extends AppCompatActivity {

    private EditText EMAIL, PASSWORD,FIRSTNAME,LASTNAME,PASSWORDC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Call id's
        EMAIL = findViewById(R.id.idEmail);
        FIRSTNAME = findViewById(R.id.idFname);
        LASTNAME = findViewById(R.id.idLname);
        PASSWORD = findViewById(R.id.idPasswd);
        PASSWORDC = findViewById(R.id.idPasswdc);
    }

    public void Register(View view){
        //1. Create Database manager
        connectionDB manager = new connectionDB(this,"data",null,1); //data es el alias de la base de datos
        //2. Let Database Read/Write
        SQLiteDatabase market = manager.getWritableDatabase();
        //3. Get values/text/numbers
        String Email = EMAIL.getText().toString();
        String Lname = LASTNAME.getText().toString();
        String Fname = FIRSTNAME.getText().toString();
        String Passwd = PASSWORD.getText().toString();
        String Passwdc = PASSWORDC.getText().toString();

        //***Validate: Do not repeat email
        //Call validateEmail function/method
        //boolean status = validateEmail();

        //4. Validate empty data AND Create Content Values
        if(!Email.isEmpty() && !Passwd.isEmpty() &&
                !Lname.isEmpty() && !Fname.isEmpty() && !Passwdc.isEmpty()) {
            if (Passwdc.equals(Passwd)) {

            Cursor row = market.rawQuery("SELECT email " +
                    "FROM users WHERE email = '" + Email + "'", null);
            //if(row.getCount()<1) puedo poner este codigo remplazando el de abajo
            if (!row.moveToFirst()) {
                ContentValues DATA = new ContentValues();
                //5. Create data pack
                DATA.put("email", Email);
                DATA.put("lastname", Lname);
                DATA.put("firstname", Fname);
                DATA.put("password", Passwd);
                //6. Save data into market Database
                market.insert("users", null, DATA);
                Toast.makeText(this, "The user has been created !!!",
                        Toast.LENGTH_SHORT).show();
                EMAIL.setText("");//limpiar el campo de email firstname lastname y password
                FIRSTNAME.setText("");
                LASTNAME.setText("");
                PASSWORD.setText("");
                PASSWORDC.setText("");
                //7. Close connection
                market.close();
            } else {
                EMAIL.setError("This field mustn't be empty");
                FIRSTNAME.setError("This field mustn't be empty");
                LASTNAME.setError("This field mustn't be empty");
                PASSWORD.setError("This field mustn't be empty");
                Toast.makeText(this, "The user already exists.",
                        Toast.LENGTH_SHORT).show();
            }
            }else{
                Toast.makeText(this,"Password must be the same", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "You must complete all fields.",
                    Toast.LENGTH_SHORT).show();
        }
    }







    //Mostrar y ocultar menu overflow
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    //Funciones de items overflow
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.iFind){

        }else if(id == R.id.iFemale){

        }else if(id == R.id.iAll){

        }else if(id == R.id.iAboutme){

        }else if(id == R.id.iLogout){

        }
        return super.onOptionsItemSelected(item);
    }

}

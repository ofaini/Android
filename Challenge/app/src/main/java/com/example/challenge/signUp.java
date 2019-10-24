package com.example.challenge;

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

public class signUp extends AppCompatActivity {

    private EditText et_email, et_lastname, et_firstname, et_passwd, et_cpasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        et_email = (EditText)findViewById(R.id.idEmail);
        et_lastname = (EditText)findViewById(R.id.idLname);
        et_firstname = (EditText)findViewById(R.id.idFname);
        et_passwd = (EditText)findViewById(R.id.idPasswd);
        et_cpasswd = (EditText)findViewById(R.id.idCPasswd);
    }

    //Metodo registrar
    public void registrar(View vies){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String email = et_email.getText().toString();
        String lastname = et_lastname.getText().toString();
        String firstname = et_firstname.getText().toString();
        String password = et_passwd.getText().toString();
        String cpasswd = et_cpasswd.getText().toString();

        if(!email.isEmpty() && !lastname.isEmpty() && !firstname.isEmpty() && !password.isEmpty() && !cpasswd.isEmpty()){
            if(password.equals(cpasswd)){

                ContentValues registro = new ContentValues();
                registro.put("email", email);
                registro.put("lastname", lastname);
                registro.put("firstname", firstname);
                registro.put("password",password);

                BaseDeDatos.insert("users", null, registro);
                BaseDeDatos.close();
                et_email.setText("");
                et_lastname.setText("");
                et_firstname.setText("");
                et_passwd.setText("");
                et_cpasswd.setText("");

                Toast.makeText(this, "The user has been created !!!", Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(this,"Password must be the same", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(this,"You must complete all fields", Toast.LENGTH_LONG).show();
        }
    }




    //Mostrar menu overflow
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    //Metodo funciones
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.item_find){
            Intent buscar = new Intent(this, findUser.class);
            startActivity(buscar);
        }
        if(id == R.id.item_all){
            Intent list = new Intent(this, listUsers.class);
            startActivity(list);
        }
        if(id == R.id.item_aboutUs){
            Intent about = new Intent (this, contactUs.class);
            startActivity(about);
        }
        if(id == R.id.item_logout){
            Intent exit = new Intent (this, login.class);
            startActivity(exit);
        }
        return super.onOptionsItemSelected(item);
    }
}

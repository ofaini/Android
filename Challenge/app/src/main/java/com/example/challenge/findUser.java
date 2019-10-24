package com.example.challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class findUser extends AppCompatActivity {

    private EditText et_email, et_lastname, et_firstname, et_passwd, et_cpasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_user);

        et_email = (EditText)findViewById(R.id.idEmailFind);
        et_lastname = (EditText)findViewById(R.id.idLnameFind);
        et_firstname = (EditText)findViewById(R.id.idFnameFind);
        et_passwd = (EditText)findViewById(R.id.idPasswdFind);
        et_cpasswd = (EditText)findViewById(R.id.idCPasswdFind);
    }

    //Metodo buscar usuarios
    public void buscar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String email = et_email.getText().toString();

        if(!email.isEmpty()){
            Cursor fila = BaseDeDatos.rawQuery("SELECT lastname, firstname, password FROM users where email ='"+email+"'", null);
            if(fila.moveToFirst()){
                et_lastname.setText(fila.getString(0));
                et_firstname.setText(fila.getString(1));
                et_passwd.setText(fila.getString(2));

                BaseDeDatos.close();
            }else{
                Toast.makeText(this, "The user does not exist",Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }
        }else{
            Toast.makeText(this, "You must introduce an Email to find", Toast.LENGTH_LONG).show();
        }
    }

    //Metodo para eliminar usuario
    public void eliminar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String email = et_email.getText().toString();

        if(!email.isEmpty()){

            int usuario = BaseDeDatos.delete("users", "email='"+email+"'", null);
            BaseDeDatos.close();

            et_email.setText("");
            et_lastname.setText("");
            et_firstname.setText("");
            et_passwd.setText("");
            et_cpasswd.setText("");

            if(usuario == 1){
                Toast.makeText(this,"User data deleted successfully",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"User does not exist",Toast.LENGTH_LONG).show();
            }

        }else{
            Toast.makeText(this,"Introduce email user to delete", Toast.LENGTH_LONG).show();
        }
    }

    //Metodo para modificar datos
    public void modify(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String email = et_email.getText().toString();
        String lastname = et_lastname.getText().toString();
        String firstname = et_firstname.getText().toString();
        String password = et_passwd.getText().toString();
        String cpasswd = et_cpasswd.getText().toString();

        if(!email.isEmpty() && !lastname.isEmpty() && !firstname.isEmpty() && !password.isEmpty() && !cpasswd.isEmpty()){
            if(password.equals(cpasswd)) {

                ContentValues registro = new ContentValues();
                registro.put("email", email);
                registro.put("lastname",lastname);
                registro.put("firstname",firstname);
                registro.put("password", password);

                int usuario = BaseDeDatos.update("users", registro,"email='"+email+"'",null);
                BaseDeDatos.close();

                et_email.setText("");
                et_lastname.setText("");
                et_firstname.setText("");
                et_passwd.setText("");
                et_cpasswd.setText("");

                if(usuario == 1){
                    Toast.makeText(this,"User data updated", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this,"User does not exist", Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(this,"Password must be the same", Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(this,"You must complete all fields", Toast.LENGTH_LONG).show();
        }

    }
}

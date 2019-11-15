package com.example.market;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.market.classes.connectionDB;

public class findUser extends AppCompatActivity {

    private EditText EMAIL,FIRSTNAME,LASTNAME,PASSWORD,PASSWORDC;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_user);

        //Call id's
        EMAIL = findViewById(R.id.idEmail_find);
        FIRSTNAME = findViewById(R.id.idFname_find);
        LASTNAME = findViewById(R.id.idLname_find);
        PASSWORD = findViewById(R.id.idPasswd_find);
        PASSWORDC = findViewById(R.id.idPasswdc_find);


    }

    //Metodo para consultar un usuario
    public void Buscar(View view){
        connectionDB manager = new connectionDB(this, "data",null,1);
        SQLiteDatabase market = manager.getWritableDatabase();

        String email = EMAIL.getText().toString();

        if(!email.isEmpty()){
            Cursor row = market.rawQuery("SELECT lastname, firstname, password FROM users WHERE email ='"+email+"'", null);

            if(row.moveToFirst()){
                EMAIL.setText(row.getString(0));
                LASTNAME.setText(row.getString(1));
                FIRSTNAME.setText(row.getString(2));
                PASSWORD.setText(row.getString(3));
                market.close();
            }else{
                Toast.makeText(this,"This user doesn't exist",Toast.LENGTH_SHORT).show();;
                market.close();
            }
        }else{
            Toast.makeText(this,"This field can not be empty", Toast.LENGTH_LONG).show();
            market.close();
        }
    }



    //Metodo eliminar
    public void delete (View view){
        connectionDB manager = new connectionDB(this, "data", null, 1);
        SQLiteDatabase market = manager.getWritableDatabase();

        String email = EMAIL.getText().toString();

        if(!email.isEmpty()){
            int usuario = market.delete("users", "email='" + email+"'",null);
            market.close();
            EMAIL.setText("");//limpiar el campo de email firstname lastname y password
            FIRSTNAME.setText("");
            LASTNAME.setText("");
            PASSWORD.setText("");
            PASSWORDC.setText("");

            if(usuario == 1){
                Toast.makeText(this,"User successfully removed", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"User does not exist",Toast.LENGTH_LONG).show();
            }

        }else{
            Toast.makeText(this,"Email can not be empty", Toast.LENGTH_LONG).show();;
        }
    }


}

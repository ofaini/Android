package com.example.challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listUsers extends AppCompatActivity {

    AdminSQLiteOpenHelper BaseDeDatos;
    ListView userList;
    ArrayList<String> listItem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        BaseDeDatos = new AdminSQLiteOpenHelper(this,"administracion", null,1);

        listItem = new ArrayList<>();

        userList = findViewById(R.id.idUserList);

        viewData();
    }

    private void viewData(){
        Cursor cursor = BaseDeDatos.selectUserDatabase();

        if(cursor.getCount() == 0){
            Toast.makeText(this,"Empty DataBase", Toast.LENGTH_LONG).show();
        }else {
            while(cursor.moveToNext()){
                listItem.add("Usuario: "+ cursor.getString(1) +" "+ cursor.getString(2)+'\n'+"Email: "+ cursor.getString(0));

            }
            adapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1, listItem);
            userList.setAdapter(adapter);
        }
    }


    //Mostrar menu overflow
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.email, menu);
        return true;
    }

    //Metodo funciones
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.itemGmail){
            Intent google = new Intent(this, gmailUsers.class);
            startActivity(google);
        }
        if(id == R.id.itemHotmail){
            Intent microsoft = new Intent(this, hotmailUsers.class);
            startActivity(microsoft);
        }if(id == R.id.itemRegistrar){
            Intent register = new Intent (this, signUp.class);
            startActivity(register);
        }

        return super.onOptionsItemSelected(item);
    }
}

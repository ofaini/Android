package com.example.challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class hotmailUsers extends AppCompatActivity {

    AdminSQLiteOpenHelper BaseDeDatos;
    ListView userList;
    ArrayList<String> listItem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotmail_users);

        BaseDeDatos = new AdminSQLiteOpenHelper(this,"administracion", null,1);

        listItem = new ArrayList<>();

        userList = findViewById(R.id.idHotmailList);

        viewData();
    }

    private void viewData(){
        Cursor cursor = BaseDeDatos.hotmail();

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


    public void regresar(View view){
        Intent back = new Intent(this, listUsers.class);
        startActivity(back);
    }
}

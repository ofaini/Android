package com.example.market.classes;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.market.R;

import java.util.ArrayList;

public class list_users extends AppCompatActivity {

    //Call Data Base Class Connection
    connectionDB market;
    //Create a ListView variable
    ListView userList;
    //Create an array List variable
    ArrayList<String> listItem;
    //Create an adapter variable
    ArrayAdapter adapter;

    int [] image = {R.mipmap.man};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        //Instance DB connection
        market = new connectionDB(this, "data", null, 1);

        //Create an empty array
        listItem = new ArrayList<>();

        //Call ListView id
        userList = findViewById(R.id.idUserList);

        //List users information
        viewData();

        //Events
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = userList.getItemAtPosition(i).toString();
                Toast.makeText(list_users.this, "Info: "+text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void viewData() {
        Cursor cursor = market.selectUserDatabase();

        if(cursor.getCount() == 0){
            Toast.makeText(this, "Empty Data Base", Toast.LENGTH_LONG).show();
        }else{
            while(cursor.moveToNext()){
                listItem.add(cursor.getString(2));
                listItem.add(cursor.getString(3));
            }
            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listItem);
            userList.setAdapter(adapter);
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

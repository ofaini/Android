package com.example.colorsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {


    private SeekBar sbrRed = null;
    private SeekBar sbrGreen = null;
    private SeekBar sbrBlue = null;
    private SeekBar sbrAlpha = null;
    private View viewColors = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sbrRed = findViewById(R.id.sbrRed);
        sbrGreen = findViewById(R.id.sbrGreen);
        sbrBlue = findViewById(R.id.sbrBlue);
        sbrAlpha = findViewById(R.id.sbrAlpha);
        viewColors = findViewById(R.id.viewColors);


        registerForContextMenu(viewColors);


        sbrRed.setOnSeekBarChangeListener(this);
        sbrGreen.setOnSeekBarChangeListener(this);
        sbrBlue.setOnSeekBarChangeListener(this);
        sbrAlpha.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean bo) {

        int r = sbrRed.getProgress();
        int g = sbrGreen.getProgress();
        int b = sbrBlue.getProgress();
        int a = sbrAlpha.getProgress();

        int colorHexa = Color.argb(a,r,g,b);

        viewColors.setBackgroundColor(colorHexa);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    //Menú options
    public void onCreateContextMenu(ContextMenu contmenu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(contmenu, v, menuInfo);

        getMenuInflater().inflate(R.menu.context, contmenu);
    }

    //Mostrar/ocultar menú
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.item1 || id == R.id.ityellow){
            sbrRed.setProgress(255);
            sbrGreen.setProgress(0);
            sbrBlue.setProgress(0);
            sbrAlpha.setProgress(120);
        }else if(id == R.id.item2 || id == R.id.ityellow){
            sbrRed.setProgress(0);
            sbrGreen.setProgress(255);
            sbrBlue.setProgress(0);
            sbrAlpha.setProgress(120);
        }else if(id == R.id.item3 || id == R.id.ityellow){
            sbrRed.setProgress(0);
            sbrGreen.setProgress(0);
            sbrBlue.setProgress(255);
            sbrAlpha.setProgress(120);
        }else if(id == R.id.item4 || id == R.id.ityellow){
            sbrRed.setProgress(255);
            sbrGreen.setProgress(255);
            sbrBlue.setProgress(0);
            sbrAlpha.setProgress(120);
        }else if(id == R.id.item5 || id == R.id.itblack){
            sbrRed.setProgress(10);
            sbrGreen.setProgress(10);
            sbrBlue.setProgress(10);
            sbrAlpha.setProgress(120);
        }else if(id == R.id.item6 || id == R.id.itwhite){
            sbrRed.setProgress(255);
            sbrGreen.setProgress(255);
            sbrBlue.setProgress(255);
            sbrAlpha.setProgress(120);
        }else if(id == R.id.item7 || id == R.id.itbrown){
            sbrRed.setProgress(108);
            sbrGreen.setProgress(59);
            sbrBlue.setProgress(42);
            sbrAlpha.setProgress(120);
        }else if(id == R.id.item8 || id == R.id.itcyan){
            sbrRed.setProgress(0);
            sbrGreen.setProgress(255);
            sbrBlue.setProgress(255);
            sbrAlpha.setProgress(120);
        }else if(id == R.id.item9 || id == R.id.itmagenta){
            sbrRed.setProgress(255);
            sbrGreen.setProgress(0);
            sbrBlue.setProgress(255);
            sbrAlpha.setProgress(120);
        }else if(id == R.id.item10 || id == R.id.itsemitransparent){
            sbrRed.setProgress(0);
            sbrGreen.setProgress(0);
            sbrBlue.setProgress(0);
            sbrAlpha.setProgress(120);
        }
        else if(id == R.id.item11){
            Intent siguiente = new Intent(this,contact.class);
            startActivity(siguiente);
        }
        return super.onOptionsItemSelected(item);
    }
}

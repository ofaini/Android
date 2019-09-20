package com.example.colorsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    //Inicializar componentes -> Null
    private SeekBar sbrRed = null;
    private SeekBar sbrGreen = null;
    private SeekBar sbrBlue = null;
    private SeekBar sbrAlpha = null;
    private View viewColors = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get components id's
        sbrRed = findViewById(R.id.sbrRed);
        sbrGreen = findViewById(R.id.sbrGreen);
        sbrBlue = findViewById(R.id.sbrBlue);
        sbrAlpha = findViewById(R.id.sbrAlpha);
        viewColors = findViewById(R.id.viewColors);

        //Habilitar el View component como menu contextual
        registerForContextMenu(viewColors);

        //Obtener el valor del seekBar
        sbrRed.setOnSeekBarChangeListener(this);
        sbrGreen.setOnSeekBarChangeListener(this);
        sbrBlue.setOnSeekBarChangeListener(this);
        sbrAlpha.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean bo) {
        //Cambiar colores
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
}

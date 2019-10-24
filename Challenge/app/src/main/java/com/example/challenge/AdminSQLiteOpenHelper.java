package com.example.challenge;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table users(email text primary key, lastname text, firstname text, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Metodo para listar todos los usuarios
    public Cursor selectUserDatabase(){
        SQLiteDatabase BaseDeDatos = this.getReadableDatabase();
        Cursor fila = BaseDeDatos.rawQuery("SELECT * FROM users", null);
        return fila;
    }

    //metodo para los usuarios de gmail
    public Cursor gmail(){
        SQLiteDatabase BaseDeDatos = this.getReadableDatabase();
        Cursor fila = BaseDeDatos.rawQuery("SELECT * FROM users WHERE email LIKE '%gmail%'", null);
        return fila;
    }

    //metodo para los usuarios de hotmail
    public Cursor hotmail(){
        SQLiteDatabase BaseDeDatos = this.getReadableDatabase();
        Cursor fila = BaseDeDatos.rawQuery("SELECT * FROM users WHERE email LIKE '%hotmail%'", null);
        return fila;
    }
}

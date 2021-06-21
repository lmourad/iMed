package com.example.imed;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexão extends SQLiteOpenHelper {
    public Conexão(@Nullable Context context) {
        super(context, name, null, version);
    }

    private static final String name = "banco.db";
    private static final int version = 1;


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table paciente(cpf varchar(11) primary key not null, "+
                "nome varchar(50) , senha varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
